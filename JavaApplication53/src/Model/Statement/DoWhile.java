/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Statement;

import Model.Texto;

/**
 *
 * @author Tiago Coutinho
 */
public class DoWhile extends Statement {

    
    private int LinhasEmBrancoDepoisChavetaAberta, LinhasEmBrancoDepoisChavetaFechada,
            LinhasEmBrancoEntreChavetaFechadaWhile, EspacosWhileParentesesAberto,
            EspacosParentesesAbertoCondicao, EspacosCondicaoParentesFechado, PosicaoPrimeiraChaveta;

    private Statement Condicao;

    public DoWhile(String codigo, Texto t) {
        super(codigo, t);
    }

    @Override
    public String RetiraDados(String Codigo, Texto t) {
        int i, j;

        boolean temChaveta = true;

        //procura se tem { ou nao
        for (i = 2; i < Codigo.length(); i++) {
            if (Codigo.charAt(i) != ' ') {
                if (Codigo.charAt(i) == '{') {
                    temChaveta = true;
                } else {
                    temChaveta = false;
                }

                break;
            }
        }

        if (temChaveta) {
            int numChavetasAbertos = 1;
            boolean AspasAberto = false, PlicasAberto = false;
            for (; i < Codigo.length(); i++) {
                if (Codigo.charAt(i) == '"' && Codigo.charAt(i - 1) != '\\') {
                    AspasAberto = !AspasAberto;
                }
                if (Codigo.charAt(i) == '\'' && Codigo.charAt(i - 1) != '\\') {
                    PlicasAberto = !PlicasAberto;
                }

                if (!AspasAberto && !PlicasAberto) {
                    if (Codigo.charAt(i) == '}') {
                        if (--numChavetasAbertos == 0) {
                            break;
                        }
                    }
                }
            }
        } else {
            boolean AspasAberto = false, PlicasAberto = false;
            for (; i < Codigo.length(); i++) {
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

        //retira espacos entre }/; e while
        for (; i < Codigo.length(); i++) {
            if (Codigo.charAt(i) != ' ') {
                break;
            }
        }

        i += 5 + 1; //depois do while

        //retira espacos entre if e (
        for (; i < Codigo.length(); i++) {
            if (Codigo.charAt(i) != ' ') {
                break;
            }
        }

        i++;//fica depois do (

        //retira espacos ate condicao
        for (; i < Codigo.length(); i++) {
            if (Codigo.charAt(i) != ' ') {
                break;
            }
        }

        //procura fim do if
        int numParentesesAbertos = 1;
        boolean AspasAberto = false, PlicasAberto = false;
        for (j = i; j < Codigo.length(); j++) {
            if (Codigo.charAt(j) == '"' && Codigo.charAt(j - 1) != '\\') {
                AspasAberto = !AspasAberto;
            }
            if (Codigo.charAt(j) == '\'' && Codigo.charAt(j - 1) != '\\') {
                PlicasAberto = !PlicasAberto;
            }

            if (!AspasAberto && !PlicasAberto) {
                if (Codigo.charAt(j) == ')') {
                    if (--numParentesesAbertos == 0) {
                        break;
                    }
                }
            }
        }
        j--;

        //retira espacos do fim condicao ate )
        for (; j >= 0; j--) {
            if (Codigo.charAt(j) != ' ') {
                break;
            }

        }

        Condicao = new Statement(Codigo.substring(i, j + 1), t);

        this.ParaAnalise = Codigo.substring(0, j + 1);
        return Codigo.substring(j + 1);

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
            if(PosicaoPrimeiraChaveta == 1)
            {
                return;
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
        
    }
}
