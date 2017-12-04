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
public class Inicializacao_EP 
{
    private int EspacosBrancoVariavelIgual, EspacosBrancoIgualValor;

    public Inicializacao_EP(int EspacosBrancoVariavelIgual, int EspacosBrancoIgualValor) {
        this.EspacosBrancoVariavelIgual = EspacosBrancoVariavelIgual;
        this.EspacosBrancoIgualValor = EspacosBrancoIgualValor;
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
    
    
}
