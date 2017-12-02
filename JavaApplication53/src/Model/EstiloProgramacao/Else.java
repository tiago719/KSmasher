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
public class Else 
{
    private boolean PosicaoPrimeiraChaveta;
    private int LinhasEmBrancoEntreIfElse,LinhasEmBrancoDepoisChavetaAberta,
        LinhasEmBrancoDepoisChavetaFechada;

    public Else(boolean PosicaoPrimeiraChaveta, int LinhasEmBrancoEntreIfElse, int LinhasEmBrancoDepoisChavetaAberta, int LinhasEmBrancoDepoisChavetaFechada) {
        this.PosicaoPrimeiraChaveta = PosicaoPrimeiraChaveta;
        this.LinhasEmBrancoEntreIfElse = LinhasEmBrancoEntreIfElse;
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

    public int getLinhasEmBrancoEntreIfElse()
    {
        return LinhasEmBrancoEntreIfElse;
    }

    public void setLinhasEmBrancoEntreIfElse(int LinhasEmBrancoEntreIfElse)
    {
        this.LinhasEmBrancoEntreIfElse = LinhasEmBrancoEntreIfElse;
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
