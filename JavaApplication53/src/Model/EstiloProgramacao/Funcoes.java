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
public class Funcoes
{
    private boolean AntesMain;

    public Funcoes(boolean AntesMain) {
        this.AntesMain = AntesMain;
    }

    public boolean isAntesMain()
    {
        return AntesMain;
    }

    public void setAntesMain(boolean AntesMain)
    {
        this.AntesMain = AntesMain;
    }
    
    
}
