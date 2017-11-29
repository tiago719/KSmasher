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
public class Inicializacao extends Statement
{
    private int EspacosBrancoVariavelIgual, EspacosBrancoIgualValor;
    
    public Inicializacao()
    {
        
    }

    public int getEspacosBrancoVariavelIgual()
    {
        return EspacosBrancoVariavelIgual;
    }

    public void setEspacosBrancoVariavelIgual(int EspacosBrancoVariavelIgual)
    {
        this.EspacosBrancoVariavelIgual = EspacosBrancoVariavelIgual;
    }

    public int getEspacosBrancoIgualValor()
    {
        return EspacosBrancoIgualValor;
    }

    public void setEspacosBrancoIgualValor(int EspacosBrancoIgualValor)
    {
        this.EspacosBrancoIgualValor = EspacosBrancoIgualValor;
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
