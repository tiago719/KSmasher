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
public class DoWhile extends Statement {

    private boolean PosicaoPrimeiraChaveta;
    private int LinhasEmBrancoDepoisChavetaAberta, LinhasEmBrancoDepoisChavetaFechada,
            LinhasEmBrancoEntreChavetaFechadaWhile, EspacosWhileParentesesAberto,
            EspacosParentesesAbertoCondicao, EspacosCondicaoParentesFechado;

    private Statement Condicao;

    public DoWhile(String codigo) {
//        boolean temChaveta = false;
//        int ixPrimeiroCarater = 0;
        int ixInicioWhile = 0;

//        for (int i = 2; i < codigo.length(); i++) {
//            if (codigo.charAt(i) != ' ') {
//                ixPrimeiroCarater = i;
//                if (codigo.charAt(i) != '{') {
//                    temChaveta = true;
//                } else {
//                    temChaveta = false;
//                }
//            }
//        }
//        String aux = codigo.substring(ixPrimeiroCarater);

//        if (temChaveta){
        for (int i = 2; i < codigo.length(); i+=4) {
            if (codigo.charAt(i) == 'w' && codigo.charAt(i+1) == 'h' 
                    && codigo.charAt(i+2) == 'i' && codigo.charAt(i+3) == 'l'
                    && codigo.charAt(i+4) == 'e'){
                ixInicioWhile = i+4;
                break;
            }
        }
//        }
    }

    public boolean isPosicaoPrimeiraChaveta() {
        return PosicaoPrimeiraChaveta;
    }

    public void setPosicaoPrimeiraChaveta(boolean PosicaoPrimeiraChaveta) {
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

    }

    @Override
    public void converteStatement() {

    }
}
