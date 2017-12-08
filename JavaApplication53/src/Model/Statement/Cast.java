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
public class Cast extends Statement
{
    private int EspacosEntreCastVariavel;
    
    public Cast(String codigo, Texto t) {
        super(codigo, t);
    }
    
    @Override
    public String RetiraDados(String Codigo, Texto t) {
        int i, j, k;

        for (i = 0; i < Codigo.length(); i++) {
            if (Codigo.charAt(i) == ')') {
                break;
            }
        }
        i++;
        for (j = i; j < Codigo.length(); j++) {
            if (Codigo.charAt(i) != ' ') {
                break;
            }
        }
        j++;
        
        this.Codigo = Codigo.substring(0, i);
        this.ParaAnalise = Codigo.substring(0, j);
        return Codigo.substring(i);
    }

    public int getEspacosEntreCastVariavel()
    {
        return EspacosEntreCastVariavel;
    }

    public void setEspacosEntreCastVariavel(int EspacosEntreCastVariavel)
    {
        this.EspacosEntreCastVariavel = EspacosEntreCastVariavel;
    }
    
    private int PosFimCast()
    {
        //TODO: Depois do dicionário estar feito
        return 5;
    }
    
    @Override
    public void analisaStatement()
    {
        EspacosEntreCastVariavel=0;
        
        try
        {

        }
        catch(Exception e)
        {
            
        }
    }
    
    @Override
    public void converteStatement()
    {
        
    }
}
