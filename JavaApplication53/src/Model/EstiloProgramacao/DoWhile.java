/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.EstiloProgramacao;

/**
 *
 * @author Tiago Coutinho
 */
public class DoWhile
{
    private boolean PosicaoPrimeiraChaveta;
    private int LinhasEmBrancoDepoisChavetaAberta, LinhasEmBrancoDepoisChavetaFechada, 
            LinhasEmBrancoEntreChavetaFechadaWhile, EspacosWhileParentesesAberto, 
            EspacosParentesesAbertoCondicao, EspacosCondicaoParentesFechado;

    public DoWhile(boolean PosicaoPrimeiraChaveta, int LinhasEmBrancoDepoisChavetaAberta, int LinhasEmBrancoDepoisChavetaFechada, int LinhasEmBrancoEntreChavetaFechadaWhile, int EspacosWhileParentesesAberto, int EspacosParentesesAbertoCondicao, int EspacosCondicaoParentesFechado) {
        this.PosicaoPrimeiraChaveta = PosicaoPrimeiraChaveta;
        this.LinhasEmBrancoDepoisChavetaAberta = LinhasEmBrancoDepoisChavetaAberta;
        this.LinhasEmBrancoDepoisChavetaFechada = LinhasEmBrancoDepoisChavetaFechada;
        this.LinhasEmBrancoEntreChavetaFechadaWhile = LinhasEmBrancoEntreChavetaFechadaWhile;
        this.EspacosWhileParentesesAberto = EspacosWhileParentesesAberto;
        this.EspacosParentesesAbertoCondicao = EspacosParentesesAbertoCondicao;
        this.EspacosCondicaoParentesFechado = EspacosCondicaoParentesFechado;
    }

    public boolean isPosicaoPrimeiraChaveta()
    {
        return PosicaoPrimeiraChaveta;
    }

    public void setPosicaoPrimeiraChaveta(boolean PosicaoPrimeiraChaveta)
    {
        this.PosicaoPrimeiraChaveta = PosicaoPrimeiraChaveta;
    }

    public int getLinhasEmBrancoDepoisChavetaAberta()
    {
        return LinhasEmBrancoDepoisChavetaAberta;
    }

    public void setLinhasEmBrancoDepoisChavetaAberta(int LinhasEmBrancoDepoisChavetaAberta)
    {
        this.LinhasEmBrancoDepoisChavetaAberta = LinhasEmBrancoDepoisChavetaAberta;
    }

    public int getLinhasEmBrancoDepoisChavetaFechada()
    {
        return LinhasEmBrancoDepoisChavetaFechada;
    }

    public void setLinhasEmBrancoDepoisChavetaFechada(int LinhasEmBrancoDepoisChavetaFechada)
    {
        this.LinhasEmBrancoDepoisChavetaFechada = LinhasEmBrancoDepoisChavetaFechada;
    }

    public int getLinhasEmBrancoEntreChavetaFechadaWhile()
    {
        return LinhasEmBrancoEntreChavetaFechadaWhile;
    }

    public void setLinhasEmBrancoEntreChavetaFechadaWhile(int LinhasEmBrancoEntreChavetaFechadaWhile)
    {
        this.LinhasEmBrancoEntreChavetaFechadaWhile = LinhasEmBrancoEntreChavetaFechadaWhile;
    }

    public int getEspacosWhileParentesesAberto()
    {
        return EspacosWhileParentesesAberto;
    }

    public void setEspacosWhileParentesesAberto(int EspacosWhileParentesesAberto)
    {
        this.EspacosWhileParentesesAberto = EspacosWhileParentesesAberto;
    }

    public int getEspacosParentesesAbertoCondicao()
    {
        return EspacosParentesesAbertoCondicao;
    }

    public void setEspacosParentesesAbertoCondicao(int EspacosParentesesAbertoCondicao)
    {
        this.EspacosParentesesAbertoCondicao = EspacosParentesesAbertoCondicao;
    }

    public int getEspacosCondicaoParentesFechado()
    {
        return EspacosCondicaoParentesFechado;
    }

    public void setEspacosCondicaoParentesFechado(int EspacosCondicaoParentesFechado)
    {
        this.EspacosCondicaoParentesFechado = EspacosCondicaoParentesFechado;
    }
    
    
}
