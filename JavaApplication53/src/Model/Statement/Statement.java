package Model.Statement;

import java.util.ArrayList;

public class Statement
{
    protected ArrayList<Statement> ListaStatements;
    protected String Statement;
    protected int numComecar;//numero de carateres desde inicio do if ate onde comeca o codigo do if
    protected int numCarateresCodigoStatment; //numer de carateres do codigo deste if, while, ... para saber quando acabou
    
    public void setNumComecar(int numComecar) {
        this.numComecar = numComecar;
    }

    public int getNumCarateresCodigoStatment() {
        return numCarateresCodigoStatment;
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
