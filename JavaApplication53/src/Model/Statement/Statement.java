package Model.Statement;

import Model.EstiloProgramacao.EstiloProgramacao;
import Model.Texto;
import java.util.ArrayList;

public class Statement {

    protected ArrayList<Statement> StatmentsFilhos = null;
    String ParaAnalise;
    String Codigo;
    Texto Texto;
    int NumCarateresAvancar;
    int Nivel;

    public Statement(String Codigo, Texto T) {
        this.Codigo = Codigo;
        this.ParaAnalise = Codigo;
        Texto = T;
        String Aux = RetiraDados(Codigo, T);
        Nivel = T.getNivel();
        if (Aux != null) {
            try {
                T.setNivel((T.getNivel() + 1));
                StatmentsFilhos = T.Cataloga(Aux, this);
                T.setNivel((T.getNivel() - 1));
            } catch (Exception e) {

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
//        if (hasFilhos()) {
//            for (Statement StatmentsFilho : StatmentsFilhos) {
//                if (!(StatmentsFilho instanceof Statement)) {
//                    StatmentsFilho.converteStatement(estilo);
//                }
//            }
//        }

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

        
    private int precisaChaveta(ArrayList<Statement> Filhos)
    {
        int a=0;
        for(int i=0;i<Filhos.size();i++)
        {
            if(Filhos.get(i).hasFilhos())
                a=precisaChaveta(Filhos.get(i).getStatementsFilhos());
            if(Filhos.get(i).Codigo.contains(";"))
                a++;
            if(a==2)
                break;
        }
        return a;
    }
    
    protected boolean precisaChaveta()
    {
        if(precisaChaveta(StatmentsFilhos)>0)
            return true;
        else 
            return false;  
    }
}
