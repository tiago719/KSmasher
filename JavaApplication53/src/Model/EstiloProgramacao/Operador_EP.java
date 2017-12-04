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
public class Operador_EP
{
    private int EspacosOperadorVariavel, EspacosVariavelOperador;

    public Operador_EP(int EspacosOperadorVariavel, int EspacosVariavelOperador) {
        this.EspacosOperadorVariavel = EspacosOperadorVariavel;
        this.EspacosVariavelOperador = EspacosVariavelOperador;
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
    
    
}
