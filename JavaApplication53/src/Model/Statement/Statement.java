package Model.Statement;

import Model.Texto;
import java.util.ArrayList;

public class Statement {

    protected ArrayList<Statement> StatmentsFilhos;
    String ParaAnalise;
    String Codigo;
    Texto Texto;
    int NumCarateresAvancar;

    public Statement(String Codigo, Texto T) {
        this.Codigo = Codigo;
        this.ParaAnalise = Codigo;
        Texto = T;
        String Aux = RetiraDados(Codigo, T);
        if (Aux != null) {
            try {
                StatmentsFilhos = T.Cataloga(Aux, this);

            } catch (Exception e) {

            }
        }
    }

    public boolean hasFilhos() {
        if (StatmentsFilhos == null)
            return false;
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

    public void converteStatement() {

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

}
