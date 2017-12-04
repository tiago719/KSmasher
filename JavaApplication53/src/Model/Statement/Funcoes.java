/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Statement;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Tiago Coutinho
 */
public class Funcoes extends Statement
{
    private boolean AntesMain;
    private String nomeFuncao;
    
    public Funcoes(String codigo, ArrayList<Statement> raiz)
    {
        
        //-------------AntesMain-----------------------
        int posMain = -1, posThis = -1, posAtual = 0;
        for (Statement next : raiz) {
            if(next instanceof Funcoes){
                if (next == this){
                    posThis = posAtual;
                    break;
                }
                if ("main".equals(((Funcoes) next).nomeFuncao)){
                    posMain = posAtual;
                }
                posAtual ++;
            }
        }
        if (posMain == -1)
            AntesMain = true;
        else if (posMain>posThis)
            AntesMain = true;
        else
            AntesMain = false;
        
        //----------------------------------------
        String aux = "";
        for (int i = 0; i < codigo.length(); i++) {
            if(codigo.charAt(i) == '('){
                aux = codigo.substring(0, i);
                break;
            }
        }
        
        String[] split= aux.split(" ");
        nomeFuncao = split[split.length-1]; 
        
        
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
