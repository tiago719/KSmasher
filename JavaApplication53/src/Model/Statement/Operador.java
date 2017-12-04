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
    
    public Operador(String Statement)
    {
        this.Statement=Statement;
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
        EspacosOperadorVariavel=0;
        EspacosVariavelOperador=0;
        int i=0;
        char c;
        
        for(i=0;i<Statement.length();i++)
        {
            try
            {
                if((c='+')==Statement.charAt(i) || (c='-')==Statement.charAt(i) || ((c='/')==Statement.charAt(i) && '*'!=Statement.charAt(i+1)))
                {
                    if(Statement.charAt(i+1)=='+' || Statement.charAt(i+1)=='-')
                        i++;
                    
                    int posicaoOperador=i;
                    while(Statement.charAt(++i)==' ')
                        EspacosOperadorVariavel++;

                    while(Statement.charAt(--posicaoOperador)==' ')
                        EspacosOperadorVariavel++;

                    break;
                }
            }
            catch(Exception e)
            {
                
            }
        }
    }
    
    @Override
    public void converteStatement()
    {
        
    }
}
