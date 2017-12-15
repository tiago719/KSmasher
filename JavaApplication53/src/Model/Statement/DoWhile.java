package Model.Statement;

import Model.Texto;
import Model.EstiloProgramacao.EstiloProgramacao;

public class DoWhile extends Statement {

    
    private int LinhasEmBrancoDepoisChavetaAberta, LinhasEmBrancoDepoisChavetaFechada,
            LinhasEmBrancoEntreChavetaFechadaWhile, EspacosWhileParentesesAberto,
            EspacosParentesesAbertoCondicao, EspacosCondicaoParentesFechado, PosicaoPrimeiraChaveta;

    private Statement Condicao;
    private boolean TemChaveta;

    public DoWhile(String codigo, Texto t) {
        super(codigo, t);
    }

    @Override
    public String RetiraDados(String Codigo, Texto t) {
        int i, j, y = 0, PosWhile = 0;
        boolean AspasAberto = false, PlicasAberto = false;

        //procura se tem { ou nao
        for (i = 2; i < Codigo.length(); i++) {
            if (Codigo.charAt(i) != ' ' && Codigo.charAt(i) != '\n') {
                y = i;
                if (Codigo.charAt(i) == '{') {
                    TemChaveta = true;
                } else {
                    TemChaveta = false;
                }
                break;
            }
        }

        if (TemChaveta) {
            int numChavetasAbertos = 1;

            for (++i; i < Codigo.length(); i++) {
                if (Codigo.charAt(i) == '"' && Codigo.charAt(i - 1) != '\\') {
                    AspasAberto = !AspasAberto;
                }
                if (Codigo.charAt(i) == '\'' && Codigo.charAt(i - 1) != '\\') {
                    PlicasAberto = !PlicasAberto;
                }

                if (!AspasAberto && !PlicasAberto) {
                    if (Codigo.charAt(i) == '{') {
                        numChavetasAbertos++;
                    } else if (Codigo.charAt(i) == '}') {
                        if (--numChavetasAbertos == 0) {
                            break;
                        }
                    }
                }
            }
        } else {
            for (++i; i < Codigo.length(); i++) {
                if (Codigo.charAt(i) == '"' && Codigo.charAt(i - 1) != '\\') {
                    AspasAberto = !AspasAberto;
                }
                if (Codigo.charAt(i) == '\'' && Codigo.charAt(i - 1) != '\\') {
                    PlicasAberto = !PlicasAberto;
                }

                if (!AspasAberto && !PlicasAberto) {
                    if (Codigo.charAt(i) == ';') {
                        break;
                    }
                }
            }
        }
        PosWhile = i;
        //retira espacos entre }/; e while
        for (; i < Codigo.length(); i++) {
            if (Codigo.charAt(i) != ' ' && Codigo.charAt(i) != '\n') {
                break;
            }
        }

        i += 5 + 1; //depois do while

        //retira espacos entre while e (
        for (; i < Codigo.length(); i++) {
            if (Codigo.charAt(i) != ' ' && Codigo.charAt(i) != '\n') {
                break;
            }
        }

        i++;//fica depois do (

        //retira espacos ate condicao
        for (; i < Codigo.length(); i++) {
            if (Codigo.charAt(i) != ' ' && Codigo.charAt(i) != '\n') {
                break;
            }
        }

        //procura fim da condicao
        int numParentesesAbertos = 1;
        AspasAberto = false;
        PlicasAberto = false;
        for (j = ++i; j < Codigo.length(); j++) {
            if (Codigo.charAt(j) == '"' && Codigo.charAt(j - 1) != '\\') {
                AspasAberto = !AspasAberto;
            }
            if (Codigo.charAt(j) == '\'' && Codigo.charAt(j - 1) != '\\') {
                PlicasAberto = !PlicasAberto;
            }

            if (!AspasAberto && !PlicasAberto) {
                if (Codigo.charAt(j) == ')') {
                    if (Codigo.charAt(j) == '(') {
                        numParentesesAbertos++;
                    } else if (--numParentesesAbertos == 0) {
                        break;
                    }
                }
            }
        }
        int z;

        //procura ;
        for (z = j; z < Codigo.length(); z++) {
            if (Codigo.charAt(z) != ' ' && Codigo.charAt(z) != '\n') {
                break;
            }
        }

        //retira espacos do fim condicao ate )
        for (--j; j >= 0; j--) {
            if (Codigo.charAt(j) != ' ' && Codigo.charAt(j) != '\n') {
                break;
            }
        }

        Condicao = new Statement(Codigo.substring(i, j + 1), t);

        this.Codigo = null;
        if (z + 2 > Codigo.length()) {
            this.ParaAnalise = Codigo.substring(0, z);
        } else {
            this.ParaAnalise = Codigo.substring(0, z + 2);
        }
        this.NumCarateresAvancar = z + 1;
        return Codigo.substring(y, PosWhile + 1);

    }

    public int isPosicaoPrimeiraChaveta() {
        return PosicaoPrimeiraChaveta;
    }

    public void setPosicaoPrimeiraChaveta(int PosicaoPrimeiraChaveta) {
        this.PosicaoPrimeiraChaveta = PosicaoPrimeiraChaveta;
    }

    public int getLinhasEmBrancoDepoisChavetaAberta() {
        return LinhasEmBrancoDepoisChavetaAberta;
    }

    public void setLinhasEmBrancoDepoisChavetaAberta(int LinhasEmBrancoDepoisChavetaAberta) {
        this.LinhasEmBrancoDepoisChavetaAberta = LinhasEmBrancoDepoisChavetaAberta;
    }

    public int getLinhasEmBrancoDepoisChavetaFechada() {
        return LinhasEmBrancoDepoisChavetaFechada;
    }

    public void setLinhasEmBrancoDepoisChavetaFechada(int LinhasEmBrancoDepoisChavetaFechada) {
        this.LinhasEmBrancoDepoisChavetaFechada = LinhasEmBrancoDepoisChavetaFechada;
    }

    public int getLinhasEmBrancoEntreChavetaFechadaWhile() {
        return LinhasEmBrancoEntreChavetaFechadaWhile;
    }

    public void setLinhasEmBrancoEntreChavetaFechadaWhile(int LinhasEmBrancoEntreChavetaFechadaWhile) {
        this.LinhasEmBrancoEntreChavetaFechadaWhile = LinhasEmBrancoEntreChavetaFechadaWhile;
    }

    public int getEspacosWhileParentesesAberto() {
        return EspacosWhileParentesesAberto;
    }

    public void setEspacosWhileParentesesAberto(int EspacosWhileParentesesAberto) {
        this.EspacosWhileParentesesAberto = EspacosWhileParentesesAberto;
    }

    public int getEspacosParentesesAbertoCondicao() {
        return EspacosParentesesAbertoCondicao;
    }

    public void setEspacosParentesesAbertoCondicao(int EspacosParentesesAbertoCondicao) {
        this.EspacosParentesesAbertoCondicao = EspacosParentesesAbertoCondicao;
    }

    public int getEspacosCondicaoParentesFechado() {
        return EspacosCondicaoParentesFechado;
    }

    public void setEspacosCondicaoParentesFechado(int EspacosCondicaoParentesFechado) {
        this.EspacosCondicaoParentesFechado = EspacosCondicaoParentesFechado;
    }

    @Override
    public void analisaStatement() {
        LinhasEmBrancoDepoisChavetaAberta = 0;
        LinhasEmBrancoDepoisChavetaFechada = 0;
        LinhasEmBrancoEntreChavetaFechadaWhile = 0;
        EspacosWhileParentesesAberto = 0;
        EspacosParentesesAbertoCondicao = 0;
        EspacosCondicaoParentesFechado = 0;
        PosicaoPrimeiraChaveta = 0;
        
        int i;
        
        for(i = 0; i < ParaAnalise.length(); i++){
            if(Texto.IsDoWhile(new char[]{ParaAnalise.charAt(i),ParaAnalise.charAt(i+1)}))
            {
                i+=2;
            }
            while(ParaAnalise.charAt(i)!='{')
            {
                if(ParaAnalise.charAt(i)=='\n')
                {
                    LinhasEmBrancoDepoisChavetaAberta++;
                }
                else if(ParaAnalise.charAt(i)==';'){
                    PosicaoPrimeiraChaveta = 1;
                    LinhasEmBrancoDepoisChavetaAberta = 0;
                    return;
                }
                i++;
            }            
            while(ParaAnalise.charAt(i)!='}')
            {
                if(ParaAnalise.charAt(i)=='\n')
                {
                    LinhasEmBrancoDepoisChavetaFechada++;
                }
                i++;
            }
            while(ParaAnalise.charAt(i)!='(')
            {
                EspacosWhileParentesesAberto++;                
                i++;
            }
            i++; // Para passar do '(' para o proximo espaço
            while(ParaAnalise.charAt(i)==' ')
            {
                EspacosParentesesAbertoCondicao++;
                i++;
            }
            // encontra o ')' e no ciclo a seguir decrementa ate encontrar o fim da condicao;
            while(ParaAnalise.charAt(i)!=')'){
                i++;
            }
            i--;
            while(ParaAnalise.charAt(i)==' '){
                EspacosCondicaoParentesFechado++;
                i--;                
            }            
        }
    }

    @Override
    public void converteStatement() {
        //adicionar no inicio "do ..." e no final "while ( <condicao> );"
        
    }
}
