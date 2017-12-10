/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Statement;

import Model.Texto;
import java.util.ArrayList;

public class Funcao extends Statement
{
    private boolean AntesMain;
    private String nomeFuncao;
    
    public Funcao(String codigo, Texto t, ArrayList<Statement> MesmoNivel)
    {
        super(codigo, t, MesmoNivel);
    }

    @Override
    public String RetiraDados(String Codigo, Texto t){
        int i, j;
        
        //procura (
        for (j = 0; j < Codigo.length(); j++) {
            if (Codigo.charAt(j) == '(')
                break;
        }
        
        for (; j>= 0; j--) {
            if (Codigo.charAt(j) != ' ')
                break;
        }
        
        for (i=j; i>= 0; i--) {
            if (Codigo.charAt(j) == ' ')
                break;
        }
        
        nomeFuncao = Codigo.substring(i+1, j+1);
       
        this.ParaAnalise = Codigo.substring(0, j+1);
        return Codigo.substring(j+1);
        
        
    }

    public String getNomeFuncao() {
        return nomeFuncao;
    }

    public void setNomeFuncao(String nomeFuncao) {
        this.nomeFuncao = nomeFuncao;
    }
    
    
    public boolean isAntesMain()
    {
        return AntesMain;
    }

    public void setAntesMain(boolean AntesMain)
    {
        this.AntesMain = AntesMain;
    }
    
    public void analisaStatement()
    {
        
    }
    
    public void converteStatement()
    {
        
    }
}
