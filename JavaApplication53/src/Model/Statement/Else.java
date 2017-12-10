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
public class Else extends Statement
{
    
    private int LinhasEmBrancoEntreIfElse,LinhasEmBrancoDepoisChavetaAberta, LinhasEmBrancoDepoisChavetaFechada,
            PosicaoPrimeiraChaveta;

    public Else(String codigo, Texto t)
    {
        super(codigo, t);
    }
    
     @Override
    public String RetiraDados(String Codigo, Texto t){
        int i, j;
        boolean temChaveta = false;
        
        for(i = 4; i < Codigo.length(); i++){
            if(Codigo.charAt(i)=='{'){
                temChaveta = true;
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
        }
        
        else {
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
       
                
        return Codigo;
    }
            
    public int isPosicaoPrimeiraChaveta()
    {
        return PosicaoPrimeiraChaveta;
    }

    public void setPosicaoPrimeiraChaveta(int PosicaoPrimeiraChaveta)
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
            
    
    @Override
    public void analisaStatement()
    {
        LinhasEmBrancoEntreIfElse = 0;
        LinhasEmBrancoDepoisChavetaAberta = 0;
        LinhasEmBrancoDepoisChavetaFechada = 0;
        PosicaoPrimeiraChaveta = 0;
        
        int i;
        for(i = 0; i < ParaAnalise.length(); i++){
            if(Texto.IsElse(new char[]{ParaAnalise.charAt(i),ParaAnalise.charAt(i+1),ParaAnalise.charAt(i+2),ParaAnalise.charAt(i+3)}))
                {
                    i+=4;
                }
            while(ParaAnalise.charAt(i)!='{')
            {
                if(ParaAnalise.charAt(i)=='\n')
                {
                    LinhasEmBrancoDepoisChavetaAberta++;
                }
                else if(ParaAnalise.charAt(i)==';')
                {
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
            while(ParaAnalise.charAt(i)!='}'){
                if(ParaAnalise.charAt(i)=='\n')
                    LinhasEmBrancoDepoisChavetaFechada++;
                i++;
            }        
        }
    }
    
    @Override
    public void converteStatement()
    {
        
    }
}
