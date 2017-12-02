/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Statement;

/**
 *
 * @author Tiago Coutinho
 */
public class If extends Statement {

    private boolean PosicaoPrimeiraChaveta, ChavetaUmStatementDentroIf;
    private int EspacosIfParentesAberto, EspacosParentesesAbertoCondicao, EspacosCondicaoParentesFechado,
            LinhasEmBrancoDepoisChavetaAberta, LinhasEmBrancoDepoisChavetaFechada;

    private Statement Condicao;

    public If(String codigo) {
        boolean temChaveta = true;
        //-----------------condicao-----------------
        String aux = "", auxCondicao = "";
        int numParenteses = 1;
        EspacosIfParentesAberto = 0;

        //-------EspacosParentesesAbertoCondicao----------
        EspacosParentesesAbertoCondicao = 0;

        for (int i = 2; i < codigo.length(); i++) {
            if (codigo.charAt(i) != '(') {
                EspacosIfParentesAberto++;

            } else {
                break;
            }
        }
        aux = codigo.substring(EspacosIfParentesAberto);
        //----------------------

        //--EspacosParentesesAbertoCondicao-------------
        for (int i = 0; i < aux.length(); i++) {
            if (aux.charAt(i) == ' ') {
                EspacosParentesesAbertoCondicao++;

            } else {
                break;
            }
        }

        aux = aux.substring(EspacosParentesesAbertoCondicao);
        //------------------------------

        //--------------condicao e EspacosCondicaoParentesFechado----------------
        int ixUltimoCarater = 0, ixUltimoParenteses = 0;
        for (int i = 0; i < aux.length(); i++) {
            auxCondicao += aux.charAt(i);
            if (aux.charAt(i) == ')') {
                numParenteses--;
                if (numParenteses == 0) {
                    ixUltimoParenteses = i;
                    break;
                }
            } else if (aux.charAt(i) == '(') {
                numParenteses++;
            } else if (aux.charAt(i) != ' ') {
                ixUltimoCarater = i;
            }
        }
        EspacosCondicaoParentesFechado = (ixUltimoParenteses - 1) - ixUltimoCarater;
        Condicao.setStatement(auxCondicao.substring(ixUltimoCarater));
        //---------------------------
        aux = aux.substring(ixUltimoParenteses);

        int ixInicioIf = 0;
        for (int i = 0; i < aux.length(); i++) {
            if (aux.charAt(i) != ' ') {
                temChaveta = false;
                ixInicioIf = i;
                break;
            } else if (aux.charAt(i) != '{') {
                temChaveta = true;
                ixInicioIf = i;
                break;
            }
        }

        setNumComecar(ixInicioIf);

        //---------contar num de linhas ate 1º carater-------------
        LinhasEmBrancoDepoisChavetaAberta = 0;
        
        aux = aux.substring(ixInicioIf);
        
        for (int i = 0; i < aux.length(); i++) {
            if (aux.charAt(i) != ' '){
                aux = aux.substring(i);
                break;
            }
            else if (String.valueOf(aux.charAt(i)).matches("\n")) {
                LinhasEmBrancoDepoisChavetaAberta++;
            }
        }
        //--------------------------------------------------------
        
        //---------encontra fim do if -------
        int ixFimIF = 0;
        if (temChaveta) {
            int numChavetas = 1;
            for (int i = 0; i < aux.length(); i++) {
                if (numChavetas == 0) {
                    ixFimIF = i;
                    break;
                } else if (aux.charAt(i) == '{') {
                    numChavetas++;
                } else if (aux.charAt(i) == '}') {
                    numChavetas--;
                }

            }
        } else {
            //procurar o 1º ';'
            boolean AspasAberto, PlicasAberto;
            AspasAberto = PlicasAberto = false;
            for (int i = 0; i < aux.length(); i++) {
                if (aux.charAt(i) == ';' && !AspasAberto && !PlicasAberto) {
                    ixFimIF = i;
                } else if (aux.charAt(i) == '"' && aux.charAt(i - 1) != '\\') {
                    AspasAberto = !AspasAberto;
                } else if (aux.charAt(i) == '\'' && aux.charAt(i - 1) != '\\') {
                    PlicasAberto = !PlicasAberto;
                }
            }
        }

        aux = aux.substring(ixFimIF);
        //---------LinhasEmBrancoDepoisChavetaFechada -----------------
        LinhasEmBrancoDepoisChavetaFechada = 0;

        for (int i = 0; i < aux.length(); i++) {
            if (aux.charAt(i) != ' '){
                break;
            }
            else if (String.valueOf(aux.charAt(i)).matches("\n")) { // testar isto
                LinhasEmBrancoDepoisChavetaFechada++;
            }
        }
        //--------------------
    }

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

    public void analisaStatement() {

    }

    public void converteStatement() {

    }

}
