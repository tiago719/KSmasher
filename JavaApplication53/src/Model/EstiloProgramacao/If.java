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
public class If 
{
    private boolean PosicaoPrimeiraChaveta, ChavetaUmStatementDentroIf;
    private int EspacosIfParentesAberto, EspacosParentesesAbertoCondicao, EspacosCondicaoParentesFechado, 
            LinhasEmBrancoDepoisChavetaAberta, LinhasEmBrancoDepoisChavetaFechada;

    public If(boolean PosicaoPrimeiraChaveta, boolean ChavetaUmStatementDentroIf, int EspacosIfParentesAberto, int EspacosParentesesAbertoCondicao, int EspacosCondicaoParentesFechado, int LinhasEmBrancoDepoisChavetaAberta, int LinhasEmBrancoDepoisChavetaFechada) {
        this.PosicaoPrimeiraChaveta = PosicaoPrimeiraChaveta;
        this.ChavetaUmStatementDentroIf = ChavetaUmStatementDentroIf;
        this.EspacosIfParentesAberto = EspacosIfParentesAberto;
        this.EspacosParentesesAbertoCondicao = EspacosParentesesAbertoCondicao;
        this.EspacosCondicaoParentesFechado = EspacosCondicaoParentesFechado;
        this.LinhasEmBrancoDepoisChavetaAberta = LinhasEmBrancoDepoisChavetaAberta;
        this.LinhasEmBrancoDepoisChavetaFechada = LinhasEmBrancoDepoisChavetaFechada;
    }

    public boolean isPosicaoPrimeiraChaveta()
    {
        return PosicaoPrimeiraChaveta;
    }

    public void setPosicaoPrimeiraChaveta(boolean PosicaoPrimeiraChaveta)
    {
        this.PosicaoPrimeiraChaveta = PosicaoPrimeiraChaveta;
    }

    public boolean isChavetaUmStatementDentroIf()
    {
        return ChavetaUmStatementDentroIf;
    }

    public void setChavetaUmStatementDentroIf(boolean ChavetaUmStatementDentroIf)
    {
        this.ChavetaUmStatementDentroIf = ChavetaUmStatementDentroIf;
    }

    public int getEspacosIfParentesAberto()
    {
        return EspacosIfParentesAberto;
    }

    public void setEspacosIfParentesAberto(int EspacosIfParentesAberto)
    {
        this.EspacosIfParentesAberto = EspacosIfParentesAberto;
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
    
    
}
