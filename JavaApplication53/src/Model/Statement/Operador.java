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
public class Operador extends Statement
{
    private int EspacosOperadorVariavel, EspacosVariavelOperador;
    
    public Operador()
    {
        
    }

    public int getEspacosOperadorVariavel()
    {
        return EspacosOperadorVariavel;
    }

    public void setEspacosOperadorVariavel(int EspacosOperadorVariavel)
    {
        this.EspacosOperadorVariavel = EspacosOperadorVariavel;
    }

    public int getEspacosVariavelOperador()
    {
        return EspacosVariavelOperador;
    }

    public void setEspacosVariavelOperador(int EspacosVariavelOperador)
    {
        this.EspacosVariavelOperador = EspacosVariavelOperador;
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
