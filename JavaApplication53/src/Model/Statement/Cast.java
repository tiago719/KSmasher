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
public class Cast extends Statement
{
    private int EspacosEntreCastVariavel;
    
    public Cast(String Statement)
    {
//        this.Statement=Statement;
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
