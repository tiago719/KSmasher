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
    protected int numComecar;//numero de carateres desde inicio do if ate onde comeca o codigo do if

    public void setNumComecar(int numComecar) {
        this.numComecar = numComecar;
    }

    public int getNumComecar() {
        return numComecar;
    }
    
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

    public ArrayList<Statement> getListaStatements() {
        return ListaStatements;
    }

    public void setStatement(String Statement) {
        this.Statement = Statement;
    }

    @Override
    public String toString()
    {
        return super.toString();
    }

    public String getStatement() {
        return Statement;
    }
    
    
    
    
}
