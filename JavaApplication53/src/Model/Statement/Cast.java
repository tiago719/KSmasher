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
    
    public Cast()
    {
        
    }

    public int getEspacosEntreCastVariavel()
    {
        return EspacosEntreCastVariavel;
    }

    public void setEspacosEntreCastVariavel(int EspacosEntreCastVariavel)
    {
        this.EspacosEntreCastVariavel = EspacosEntreCastVariavel;
    }
    
    @Override
    public void analisaStatement()
    {
        
    }
    
    @Override
    public void converteStatement()
    {
        
    }
}
