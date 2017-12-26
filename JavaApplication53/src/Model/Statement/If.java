package Model.Statement;

import Model.EstiloProgramacao.EstiloProgramacao;
import Model.EstiloProgramacao.For_EP;
import Model.EstiloProgramacao.If_EP;
import Model.Texto;
import java.util.ArrayList;

public class If extends Statement {

    private int EspacosIfParentesAberto, EspacosParentesesAbertoCondicao, EspacosCondicaoParentesFechado,
            LinhasEmBrancoDepoisChavetaAberta, LinhasEmBrancoDepoisChavetaFechada,
            ChavetaUmStatementIf, PrimeiraChavetaNovaLinha;

    private Statement Condicao;
    private boolean TemChaveta;

    public If(String codigo, Texto t) {
        super(codigo, t);
    }

    public Statement getCondicao() {
        return Condicao;
    }

    @Override
    public String RetiraDados(String Codigo, Texto T) {
        int i, j, k, m, n;

        //retira espacos entre if e (
        for (i = 2; i < Codigo.length(); i++) {
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

        //procura fim do if
        int NumParentesesAbertos = 1;
        boolean AspasAberto = false, PlicasAberto = false;
        for (j = i; j < Codigo.length(); j++) {
            if (Codigo.charAt(j) == '"' && Codigo.charAt(j - 1) != '\\') {
                AspasAberto = !AspasAberto;
                continue;
            } else if (Codigo.charAt(j) == '\'' && Codigo.charAt(j - 1) != '\\') {
                PlicasAberto = !PlicasAberto;
                continue;
            }

            if (!AspasAberto && !PlicasAberto) {
                if (Codigo.charAt(j) == '(') {
                    NumParentesesAbertos++;
                } else if (Codigo.charAt(j) == ')') {
                    if (--NumParentesesAbertos == 0) {
                        break;
                    }
                }
            }
        }

        //retira espacos do fim condicao ate )
        for (k = j; k >= 0; k--) {
            if (!Character.isWhitespace(Codigo.charAt(k))) {
                break;
            }

        }

        int a;
        char c;
        AspasAberto = PlicasAberto = false;
        //procurar {
        for (a = j + 1; a < Codigo.length(); a++) {
            if ((c = Codigo.charAt(a)) == '"' && Codigo.charAt(a - 1) != '\\') {
                AspasAberto = !AspasAberto;
                continue;
            } else if (Codigo.charAt(a) == '\'' && Codigo.charAt(a - 1) != '\\') {
                PlicasAberto = !PlicasAberto;
                continue;
            }
            if (PlicasAberto || AspasAberto) {
                continue;
            }

            if (Codigo.charAt(a) == '{') {
                TemChaveta = true;
                break;
            } else if (Codigo.charAt(a) == ';') {
                TemChaveta = false;
                break;
            }
        }
        if (TemChaveta) {
            NumParentesesAbertos = 1;
            AspasAberto = PlicasAberto = false;

            for (m = a + 1; m < Codigo.length(); m++) {
                if (Codigo.charAt(m) == '"' && Codigo.charAt(m - 1) != '\\') {
                    AspasAberto = !AspasAberto;
                    continue;
                } else if (Codigo.charAt(m) == '\'' && Codigo.charAt(m - 1) != '\\') {
                    PlicasAberto = !PlicasAberto;
                    continue;
                }
                if (Codigo.charAt(m) == '{') {
                    NumParentesesAbertos++;
                } else if (Codigo.charAt(m) == '}') {
                    if (--NumParentesesAbertos == 0) {
                        break;
                    }
                }
            }
        } else {
            m = a;
        }
        for (n = m + 1; n < Codigo.length(); n++) {
            if (!Character.isWhitespace(Codigo.charAt(n))) {
                break;
            }
        }

        try {
            Condicao = new Statement(Codigo.substring(i, j), T);
        } catch (Exception e) {
        }
        if (j + 1 > Codigo.length()) {
            this.Codigo = Codigo.substring(0, 1 + j - (j - Codigo.length()));
        } else {
            this.Codigo = Codigo.substring(0, j + 1);
        }

        if (n + 1 > Codigo.length()) {
            this.ParaAnalise = Codigo.substring(0, n - (n - Codigo.length()));
        } else {
            this.ParaAnalise = Codigo.substring(0, n + 1);
        }

        if (m + 1 > Codigo.length()) {
            this.NumCarateresAvancar = m - (m - Codigo.length());
            return Codigo.substring(a + 1, m - (m - Codigo.length()));
        } else {
            this.NumCarateresAvancar = m + 2;
            return Codigo.substring(a+1, m + 1);
        }

    }

    public int getPrimeiraChavetaNovaLinha() {
        return PrimeiraChavetaNovaLinha;
    }

    public void setPrimeiraChavetaNovaLinha(int PosicaoPrimeiraChaveta) {
        this.ChavetaUmStatementIf = PosicaoPrimeiraChaveta;
    }

    public int isChavetaUmStatementDentroIf() {
        return ChavetaUmStatementIf;
    }

    public void setChavetaUmStatementDentroIf(int ChavetaUmStatementDentroIf) {
        this.PrimeiraChavetaNovaLinha = ChavetaUmStatementDentroIf;
    }

    public int getEspacosIfParentesAberto() {
        return EspacosIfParentesAberto;
    }

    public void setEspacosIfParentesAberto(int EspacosIfParentesAberto) {
        this.EspacosIfParentesAberto = EspacosIfParentesAberto;
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

    private boolean isIf(char A[]) {
        if (A[0] == 'i' && A[1] == 'f' && (A[2] == '(' || Character.isWhitespace(A[2]))) {
            return true;
        }
        return false;
    }

    @Override
    public void analisaStatement() {

        EspacosParentesesAbertoCondicao = 0;
        EspacosIfParentesAberto = 0;
        EspacosCondicaoParentesFechado = 0;
        PrimeiraChavetaNovaLinha = -1;
        ChavetaUmStatementIf= -1;
        LinhasEmBrancoDepoisChavetaAberta = -1;
        LinhasEmBrancoDepoisChavetaFechada = -1;
        int contParenteses = 0, indexParenteses = -1, i, aux, a, contPontoVirgula = 0;

        for (i = 0; i < ParaAnalise.length(); i++) {
            try {
                if (isIf(new char[]{ParaAnalise.charAt(i), ParaAnalise.charAt(i + 1), ParaAnalise.charAt(i + 2)})) {
                    i += 2;
                } else {
                    continue;
                }
            } catch (Exception e) {
            }
            for (; i < ParaAnalise.length(); i++) {
                if (ParaAnalise.charAt(i) != '(') {
                    EspacosIfParentesAberto++;
                } else {
                    break;
                }
            }

            for (++i; i < ParaAnalise.length(); i++) {
                if (ParaAnalise.charAt(i) == ' ') {
                    EspacosParentesesAbertoCondicao++;
                } else {
                    break;
                }
            }
            while (++i < ParaAnalise.length()) {
                if (ParaAnalise.charAt(i) == ')') {
                    if (contParenteses == 0) {
                        indexParenteses = i;
                        break;
                    } else {
                        contParenteses--;
                    }
                }
                if (ParaAnalise.charAt(i) == '(') {
                    contParenteses++;
                }
            }
            for (indexParenteses--; indexParenteses > 0; indexParenteses--) {
                if (ParaAnalise.charAt(indexParenteses) == ' ') {
                    EspacosCondicaoParentesFechado++;
                } else {
                    break;
                }
            }
            break;
        }

        aux = i;
        boolean temChaveta = false;
        char c;

        for (a = aux + 1; a < ParaAnalise.length(); a++) {
            if ((c = ParaAnalise.charAt(a)) == '{') {
                temChaveta = true;
                break;
            } else if (!Character.isWhitespace(ParaAnalise.charAt(a))) {
                break;
            }
        }
        
        contPontoVirgula=0;
        
        for(++a;a<ParaAnalise.length();a++)
        {
            if(ParaAnalise.charAt(a)==';')
                if(++contPontoVirgula>=2)
                {
                    ChavetaUmStatementIf=-1;
                    break;
                }
        }

        if (temChaveta) {
            for (++i; i < ParaAnalise.length(); i++) {
                if (!Character.isWhitespace(ParaAnalise.charAt(i))) {
                    break;
                }
            }
            if (ParaAnalise.charAt(i) == '{' && contPontoVirgula<2) 
            {
                ChavetaUmStatementIf = 1;
            } 
            else if(contPontoVirgula<2) 
            {
                ChavetaUmStatementIf = 0;
                PrimeiraChavetaNovaLinha = -1;
            }
            else
                PrimeiraChavetaNovaLinha = -1;
            
        } else {
            ChavetaUmStatementIf = 0;
        }
        boolean primeiro = true;

        if (ChavetaUmStatementIf == 1 || ChavetaUmStatementIf == -1) {
            PrimeiraChavetaNovaLinha = 0;
            LinhasEmBrancoDepoisChavetaAberta = 0;
            LinhasEmBrancoDepoisChavetaFechada = 0;
            for (i = indexParenteses + 1; i < ParaAnalise.length(); i++) {
                if (ParaAnalise.charAt(i) == '\n') {
                    PrimeiraChavetaNovaLinha = 1;
                }
                if (ParaAnalise.charAt(i) == '{') {
                    for (i += 1; i < ParaAnalise.length(); i++) {
                        if (ParaAnalise.charAt(i) == '\n') {
                            if (primeiro) {
                                primeiro = false;
                            } else {
                                LinhasEmBrancoDepoisChavetaAberta++;
                            }
                        } else if (Character.isWhitespace(ParaAnalise.charAt(i))) {
                            continue;
                        } else {
                            break;
                        }
                    }
                    break;
                }
            }
            aux = 0;
            for (i += 1; i < ParaAnalise.length(); i++) {
                if (ParaAnalise.charAt(i) == '{') {
                    aux++;
                }
                if (ParaAnalise.charAt(i) == '}') {
                    if (aux <= 0) {
                        break;
                    } else {
                        aux--;
                    }
                }
            }
            primeiro = true;
            for (i++; i < ParaAnalise.length(); i++) {
                if (ParaAnalise.charAt(i) == '\n') {
                    if (primeiro) {
                        primeiro = false;
                    } else {
                        LinhasEmBrancoDepoisChavetaFechada++;
                    }
                } else if (Character.isWhitespace(ParaAnalise.charAt(i))) {
                    continue;
                } else {
                    break;
                }
            }
        }
    }

    @Override
    public void converteStatement(EstiloProgramacao estilo) {
//        String aux= this.ParaAnalise;
//        StringBuilder build = new StringBuilder(aux); 
//        char espacos[] = { ' ', ' ', ' ', ' ', ' ', ' ', ' ' };
//        char linhas[] = { '\n', '\n', '\n', '\n', '\n', '\n', '\n' };
//        int conta=0;
//       
//            for (int i = 0; i < aux.length(); i++) {
//                if(aux.charAt(i)=='(')
//                {
//                   build.insert(i, espacos, 0, estilo.getIfs().getEspacosIfParentesAberto());
//                   build.insert(i+1+estilo.getIfs().getEspacosIfParentesAberto(), espacos, 0, estilo.getIfs().getEspacosParentesesAbertoCondicao());
//                }
//                if(aux.charAt(i)==')')
//                {
//                   conta+=estilo.getIfs().getEspacosIfParentesAberto()+estilo.getIfs().getEspacosParentesesAbertoCondicao();
//                   
//                   build.insert(i+conta, espacos, 0, estilo.getIfs().getEspacosCondicaoParentesFechado());
//                }
//                if(aux.charAt(i)=='{')
//                {
//                    conta+=estilo.getIfs().getEspacosCondicaoParentesFechado();
//                    
//                   build.insert(i+1+conta, linhas, 0, estilo.getIfs().getLinhasEmBrancoDepoisChavetaAberta());
//                }
//                 if(aux.charAt(i)=='}')
//                {
//                    conta+=estilo.getIfs().getLinhasEmBrancoDepoisChavetaAberta();
//                    
//                   build.insert(i+conta, linhas, 0, estilo.getIfs().getLinhasEmBrancoDepoisChavetaFechada()-1);
//                }
//                if(aux.charAt(i)==';')
//                {
//                    conta+=estilo.getIfs().getLinhasEmBrancoDepoisChavetaAberta();
//                    
//                   build.insert(i+1+conta, linhas, 0, 1);
//                }
//               
//        }
//            this.Codigo=build.toString();
        TemChaveta=false;
        String Aux = "";
        
        for(int i=0;i<getNivel();i++)
            Aux+="\t";
        Aux+="if";
        If_EP ep = estilo.getIfs();
        for (int i = 0; i < ep.getEspacosIfParentesAberto(); i++) {
            Aux += " ";
        }
        Aux += "(";

        for (int i = 0; i < ep.getEspacosParentesesAbertoCondicao(); i++) {
            Aux += " ";
        }

        this.Condicao.converteStatement(estilo);
        Aux += this.Condicao.Codigo;

        for (int i = 0; i < ep.getEspacosCondicaoParentesFechado(); i++) {
            Aux += " ";
        }
        Aux += ")";
        
        if(ep.isPosicaoPrimeiraChaveta() && ep.isChavetaUmStatementDentroIf())
        {
            Aux+="\n";
            for(int i=0;i<getNivel();i++)
                Aux+="\t";
            Aux+="{";
            TemChaveta=true;
        }
        else if(!ep.isPosicaoPrimeiraChaveta() && ep.isChavetaUmStatementDentroIf())
        {
            Aux+="{";
            TemChaveta=true;
        }
        else if(!ep.isChavetaUmStatementDentroIf() && precisaChaveta() && ep.isPosicaoPrimeiraChaveta())
        {
            Aux+="\n{";
        }
        else if(!ep.isChavetaUmStatementDentroIf() && precisaChaveta() && !ep.isPosicaoPrimeiraChaveta())
        {
            Aux+="{\n";
        }
        if(TemChaveta)
        {
            for(int a=0;a<ep.getLinhasEmBrancoDepoisChavetaAberta();a++)
            {
                Aux+="\n";
            }

            for(int a=0;a<ep.getLinhasEmBrancoDepoisChavetaFechada();a++)
            {
                StatmentsFilhos.get(StatmentsFilhos.size()-1).Codigo+="\n";
            }
        }
        this.Codigo = Aux;
    }
}
