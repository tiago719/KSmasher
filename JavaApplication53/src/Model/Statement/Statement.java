package Model.Statement;

import Model.EstiloProgramacao.EstiloProgramacao;
import Model.Texto;
import java.util.ArrayList;

public class Statement {

    protected ArrayList<Statement> StatmentsFilhos = null;
    protected Statement Pai;
    String ParaAnalise;
    String Codigo;
    Texto Texto;
    int NumCarateresAvancar;
    int Nivel;

    public Statement(String Codigo, Texto T, Statement Pai) {
        this.Codigo = Codigo;
        this.ParaAnalise = Codigo;
        this.Pai=Pai;
        Texto = T;
        String Aux = RetiraDados(Codigo, T);
        Nivel = T.getNivel();
        if (Aux != null) {
            try {
                T.setNivel((T.getNivel() + 1));
                StatmentsFilhos = T.Cataloga(Aux, this);
                T.setNivel((T.getNivel() - 1));
            } catch (Exception e) {
                T.setNivel((T.getNivel() - 1));
            }
        }
    }

    public boolean hasFilhos() {
        if (StatmentsFilhos == null) {
            return false;
        }
        return StatmentsFilhos.size() > 0;
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

    public Statement() {
        StatmentsFilhos = new ArrayList<Statement>();
    }

    public void analisaStatement() {

    }

    public void converteStatement(EstiloProgramacao estilo) {

    }

    public ArrayList<Statement> getStatementsFilhos() {
        return StatmentsFilhos;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    //Metedo a ser usado pelos filhos de statment (Override)
    public String RetiraDados(String Codigo, Texto T) {
        return ParaAnalise;

    }

    public int getNumCarateresAvancar() {
        return NumCarateresAvancar;
    }

    public int getNivel() {
        return Nivel;
    }
    
    private Statement getLastSon(ArrayList<Statement> Lista)
    {
        if(Lista.get(Lista.size()-1).hasFilhos())
            return getLastSon(Lista.get(Lista.size()-1).getStatementsFilhos());
        else
            return Lista.get(Lista.size()-1);
    }
    
    public Statement getLastSon()
    {
        return getLastSon(StatmentsFilhos);
    }
}
