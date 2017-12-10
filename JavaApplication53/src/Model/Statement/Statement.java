package Model.Statement;

import Model.Texto;
import java.util.ArrayList;

public class Statement
{
    protected ArrayList<Statement> StatmentsFilhos;
    protected ArrayList<Statement> StatementsMesmoNivel;
    String ParaAnalise;
    String Codigo;
    Texto Texto;
    
    public Statement(String Codigo, Texto t, ArrayList<Statement> MesmoNivel){
        this.Codigo = Codigo;
        this.ParaAnalise = Codigo;
        Texto=t;
        String aux = RetiraDados(Codigo, t);
        StatementsMesmoNivel=MesmoNivel;
        StatmentsFilhos = t.Cataloga(aux);
    }
    
    public boolean hasFilhos()
    {
        return StatmentsFilhos.size()>0;
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
