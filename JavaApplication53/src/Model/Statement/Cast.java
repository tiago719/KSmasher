/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Statement;

import Model.Texto;
import java.util.ArrayList;

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
        char c;
        
        for(i=0;i<Codigo.length();i++)
        {
            if(Codigo.charAt(i)=='(')
                break;
        }

        for (k = i+1; k < Codigo.length(); k++) {
            if ((c=Codigo.charAt(k)) == ')') {
                break;
            }
        }
        
        for(j=k+1;j<Codigo.length();j++)
        {
            if((c=Codigo.charAt(j))!=' ' && Codigo.charAt(j) != '\n')
                break;
        }
        NumCarateresAvancar=k;
        this.Codigo = Codigo.substring(i, k+1);
        this.ParaAnalise = Codigo.substring(0, j+1);
        return null;
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
