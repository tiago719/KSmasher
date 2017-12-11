/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Statement;

import Model.Texto;

public class Funcao extends Statement
{
    private boolean AntesMain;
    private String nomeFuncao;
    
    public Funcao(String codigo, Texto t)
    {
        super(codigo, t);
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
        String aux = ParaAnalise;
        String linha = "";
        
        if(!aux.contains("main"))
        {
            AntesMain = true; /// PORQUE SE NAO TEM MAIN É SÓ PARA DEIXAR COMO ESTAO AS FUNÇOES NAO È NECESSARIO CRIAR CABEÇALHO
            return;
        }
        
        int posmain = aux.indexOf("main");
        int nchaveta=0;
        for(int i = posmain;i< aux.length();i++)
        {
            if(aux.charAt(i) == '{')
                nchaveta++;
            else
                if(aux.charAt(i) == '}')
                {
                    if(nchaveta == 0)
                    {
                        posmain = i;
                        break;
                    }else
                    {
                       nchaveta--; 
                    }
                }
        }
        aux.substring(posmain);
        
        if(aux.contains(nomeFuncao))
        {
            AntesMain = false;
        }
        {
            AntesMain = true;
        }
        
  
        
        
    }
    
    public void converteStatement()
    {
        
    }
}
