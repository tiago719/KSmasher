package Model.Statement;

import Model.Texto;
import java.util.ArrayList;

public class If extends Statement {

    private boolean PosicaoPrimeiraChaveta, ChavetaUmStatementDentroIf;
    private int EspacosIfParentesAberto, EspacosParentesesAbertoCondicao, EspacosCondicaoParentesFechado,
            LinhasEmBrancoDepoisChavetaAberta, LinhasEmBrancoDepoisChavetaFechada;

    private Statement Condicao;
    private boolean temChaveta;

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
            if (Codigo.charAt(k) != ' ') {
                break;
            }

        }

        
        int l;
        AspasAberto = PlicasAberto = false;
        //procurar {
        for (l = j + 1; l < Codigo.length(); l++) {
            if (Codigo.charAt(l) == '"' && Codigo.charAt(l - 1) != '\\') {
                AspasAberto = !AspasAberto;
                continue;
            } else if (Codigo.charAt(l) == '\'' && Codigo.charAt(l - 1) != '\\') {
                PlicasAberto = !PlicasAberto;
                continue;
            }
            if (Codigo.charAt(l) == '{') {
                temChaveta = true;
                break;
            } else if (Codigo.charAt(l) == ';') {
                temChaveta = false;
                break;
            }
        }
        if (temChaveta) {
            NumParentesesAbertos = 1;
            AspasAberto = PlicasAberto = false;
            
            for (m = l + 1; m < Codigo.length(); m++) {
                if (Codigo.charAt(m) == '"' && Codigo.charAt(m - 1) != '\\') {
                    AspasAberto = !AspasAberto;
                    continue;
                } else if (Codigo.charAt(m) == '\'' && Codigo.charAt(m - 1) != '\\') {
                    PlicasAberto = !PlicasAberto;
                    continue;
                }
                if (Codigo.charAt(m) == '{') {
                    NumParentesesAbertos++;
                    break;
                }
                else if(Codigo.charAt(m) == '}') {
                    if (--NumParentesesAbertos == 0){
                        break;
                    }
                }
            }
        } else {
            m = l;
        }
        for (n = m + 1; n < Codigo.length(); n++) {
            char qqq = Codigo.charAt(n);
            if (Codigo.charAt(n) != ' ')
                break;
        }

        try {
            Condicao = new Statement(Codigo.substring(i, j + 1), T);
        } catch (Exception e) {
        }
        this.Codigo = Codigo.substring(0, j + 1);
        this.ParaAnalise = Codigo.substring(0, n + 1);
        this.NumCarateresAvancar = m + 1;
        return Codigo.substring(l, m + 1);

    }

//    public If(String codigo) {
//        int contadorCarateres = 2;
//        temChaveta = true;
//        String aux = "", auxCondicao = "";
//        int numParenteses = 1;
//        EspacosIfParentesAberto = 0;
//
//        //-------EspacosParentesesAbertoCondicao----------
//        EspacosParentesesAbertoCondicao = 0;
//
//        for (int i = 2; i < codigo.length(); i++) {
//            if (codigo.charAt(i) != '(') {
//                EspacosIfParentesAberto++;
//
//            } else {
//                break;
//            }
//            contadorCarateres++;
//        }
//        aux = codigo.substring(EspacosIfParentesAberto+1);
//        //----------------------
//
//        //--EspacosParentesesAbertoCondicao-------------
//        for (int i = 0; i < aux.length(); i++) {
//            if (aux.charAt(i) == ' ') {
//                EspacosParentesesAbertoCondicao++;
//
//            } else {
//                break;
//            }
//            contadorCarateres++;
//        }
//
//        aux = aux.substring(EspacosParentesesAbertoCondicao+1);
//        //------------------------------
//
//        //--------------condicao e EspacosCondicaoParentesFechado----------------
//        int ixUltimoCarater = 0, ixUltimoParenteses = 0;
//        for (int i = 0; i < aux.length(); i++) {
//            auxCondicao += aux.charAt(i);
//            if (aux.charAt(i) == ')') {
//                numParenteses--;
//                if (numParenteses == 0) {
//                    ixUltimoParenteses = i;
//                    break;
//                }
//            } else if (aux.charAt(i) == '(') {
//                numParenteses++;
//            } else if (aux.charAt(i) != ' ') {
//                ixUltimoCarater = i;
//            }
//            contadorCarateres++;
//        }
//        EspacosCondicaoParentesFechado = (ixUltimoParenteses - 1) - ixUltimoCarater;
//        Condicao.setStatement(auxCondicao.substring(0, ixUltimoCarater));
//        //---------------------------
//        aux = aux.substring(ixUltimoParenteses);
//
//        int ixInicioIf = 0;
//        for (int i = 0; i < aux.length(); i++) {
//            if (aux.charAt(i) != ' ') {
//                temChaveta = false;
//                ixInicioIf = i;
//                break;
//            } else if (aux.charAt(i) != '{') {
//                temChaveta = true;
//                ixInicioIf = i;
//                break;
//            }
//            contadorCarateres++;
//        }
//
//        setNumComecar(ixInicioIf);
//
//        //---------contar num de linhas ate 1º carater-------------
//        LinhasEmBrancoDepoisChavetaAberta = 0;
//        
//        aux = aux.substring(ixInicioIf);
//        
//        for (int i = 0; i < aux.length(); i++) {
//            if (aux.charAt(i) != ' '){
//                aux = aux.substring(i);
//                break;
//            }
//            else if (String.valueOf(aux.charAt(i)).matches("\n")) {
//                LinhasEmBrancoDepoisChavetaAberta++;
//            }
//            contadorCarateres++;
//        }
//        //--------------------------------------------------------
//        
//        //---------encontra fim do if -------
//        int ixFimIF = 0;
//        if (temChaveta) {
//            int numChavetas = 1;
//            for (int i = 0; i < aux.length(); i++) {
//                if (numChavetas == 0) {
//                    ixFimIF = i;
//                    break;
//                } else if (aux.charAt(i) == '{') {
//                    numChavetas++;
//                } else if (aux.charAt(i) == '}') {
//                    numChavetas--;
//                }
//                contadorCarateres++;
//
//            }
//        } else {
//            //procurar o 1º ';'
//            boolean AspasAberto, PlicasAberto;
//            AspasAberto = PlicasAberto = false;
//            for (int i = 0; i < aux.length(); i++) {
//                if (aux.charAt(i) == ';' && !AspasAberto && !PlicasAberto) {
//                    ixFimIF = i;
//                } else if (aux.charAt(i) == '"' && aux.charAt(i - 1) != '\\') {
//                    AspasAberto = !AspasAberto;
//                } else if (aux.charAt(i) == '\'' && aux.charAt(i - 1) != '\\') {
//                    PlicasAberto = !PlicasAberto;
//                }
//                contadorCarateres++;
//            }
//        }
//
//        aux = aux.substring(ixFimIF);
//        //---------LinhasEmBrancoDepoisChavetaFechada -----------------
//        LinhasEmBrancoDepoisChavetaFechada = 0;
//
//        for (int i = 0; i < aux.length(); i++) {
//            if (aux.charAt(i) != ' '){
//                break;
//            }
//            else if (String.valueOf(aux.charAt(i)).matches("\n")) { // testar isto
//                LinhasEmBrancoDepoisChavetaFechada++;
//            }
//            contadorCarateres++;
//        }
//        //--------------------
//        
//        numCarateresCodigoStatment = contadorCarateres;
//    }
    public boolean isPosicaoPrimeiraChaveta() {
        return PosicaoPrimeiraChaveta;
    }

    public void setPosicaoPrimeiraChaveta(boolean PosicaoPrimeiraChaveta) {
        this.PosicaoPrimeiraChaveta = PosicaoPrimeiraChaveta;
    }

    public boolean isChavetaUmStatementDentroIf() {
        return ChavetaUmStatementDentroIf;
    }

    public void setChavetaUmStatementDentroIf(boolean ChavetaUmStatementDentroIf) {
        this.ChavetaUmStatementDentroIf = ChavetaUmStatementDentroIf;
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

    @Override
    public void analisaStatement() {

    }

    @Override
    public void converteStatement() {

    }

}
