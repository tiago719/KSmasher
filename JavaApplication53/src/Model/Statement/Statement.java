package Model.Statement;

import Model.Texto;
import java.util.ArrayList;

public class Statement
{
    protected ArrayList<Statement> StatmentsFilhos;
    String ParaAnalise;
    String Codigo;
    
    
//    protected int numComecar;//numero de carateres desde inicio do if ate onde comeca o codigo do if
//    protected int numCarateresCodigoStatment; //numer de carateres do codigo deste if, while, ... para saber quando acabou
    
    public Statement(String Codigo, Texto t){
        this.Codigo = Codigo;
        this.ParaAnalise = Codigo;
        String aux = RetiraDados(Codigo, t);
        StatmentsFilhos = t.Cataloga(aux);
    }

    public String getParaAnalise() {
        return ParaAnalise;
    }

    public void setParaAnalise(String ParaAnalise) {
        this.ParaAnalise = ParaAnalise;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }
    
    
//    public void setNumComecar(int numComecar) {
//        this.numComecar = numComecar;
//    }
//
//    public int getNumCarateresCodigoStatment() {
//        return numCarateresCodigoStatment;
//    }
//
//    public int getNumComecar() {
//        return numComecar;
//    }
    
    public Statement()
    {
        StatmentsFilhos=new ArrayList<Statement>();
    }
    
    public void analisaStatement()
    {
        
    }
    
    public void converteStatement()
    {
        
    }

    public ArrayList<Statement> getStatmentsFilhos() {
        return StatmentsFilhos;
    }


    @Override
    public String toString()
    {
        return super.toString();
    }

    public String RetiraDados(String codigo, Texto t ){
        return "";
    }

    
}
