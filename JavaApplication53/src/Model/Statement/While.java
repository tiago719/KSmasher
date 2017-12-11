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
public class While extends Statement {

    private boolean PosicaoPrimeiraChaveta, ChavetaUmStatementDentroWhile;
    private int LinhasEmBrancoDepoisChavetaAberta, LinhasEmBrancoDepoisChavetaFechada,
            EspacosWhileParentesAberto, EspacosParentesesAbertoCondicao, EspacosCondicaoParentesFechado;

    private Statement Condicao;

    public While(String codigo, Texto t) {
        super(codigo, t);
    }

    @Override
    public String RetiraDados(String Codigo, Texto t) {
        int i, j;

        //retira espacos entre while e (
        for (i = 5; i < Codigo.length(); i++) {
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

        //procura fim do while
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
                if (Codigo.charAt(j) == '(') {
                    numParentesesAbertos++;
                }
                if (Codigo.charAt(j) == ')') {
                    if (--numParentesesAbertos == 0) {
                        break;
                    }
                }
            }
        }
        j--;
        char a = Codigo.charAt(j);

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

    public boolean isPosicaoPrimeiraChaveta() {
        return PosicaoPrimeiraChaveta;
    }

    public void setPosicaoPrimeiraChaveta(boolean PosicaoPrimeiraChaveta) {
        this.PosicaoPrimeiraChaveta = PosicaoPrimeiraChaveta;
    }

    public boolean isChavetaUmStatementDentroWhile() {
        return ChavetaUmStatementDentroWhile;
    }

    public void setChavetaUmStatementDentroWhile(boolean ChavetaUmStatementDentroWhile) {
        this.ChavetaUmStatementDentroWhile = ChavetaUmStatementDentroWhile;
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

    public int getEspacosWhileParentesAberto() {
        return EspacosWhileParentesAberto;
    }

    public void setEspacosWhileParentesAberto(int EspacosWhileParentesAberto) {
        this.EspacosWhileParentesAberto = EspacosWhileParentesAberto;
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
        for (int i = 0; i < ParaAnalise.length(); i++) {
//            if (isWhile()) {
//                
//            }
        }
    }

    @Override
    public void converteStatement() {

    }
}
