/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Statement;

import java.util.ArrayList;

/**
 *
 * @author Tiago Coutinho
 */
public class Statement
{
    protected ArrayList<Statement> ListaStatements;
    protected String Statement;
    
    public Statement()
    {
        ListaStatements=new ArrayList<Statement>();
    }
    
    public void analisaStatement()
    {
        
    }
    
    public void converteStatement()
    {
        
    }

    @Override
    public String toString()
    {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
