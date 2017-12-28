package Model.Statement;

import Model.Texto;
import java.util.ArrayList;
import Model.EstiloProgramacao.EstiloProgramacao;

public class Cast extends Statement {

    private int EspacosEntreCastVariavel;

    public Cast(String codigo, Texto t, Statement Pai) {
        super(codigo, t, Pai);
    }

    @Override
    public String RetiraDados(String Codigo, Texto t) {
        int i, j, k;
        char c;

        for (i = 0; i < Codigo.length(); i++) {
            if (Codigo.charAt(i) == '(') {
                break;
            }
        }

        for (k = i + 1; k < Codigo.length(); k++) {
            if ((c = Codigo.charAt(k)) == ')') {
                break;
            }
        }

        for (j = k + 1; j < Codigo.length(); j++) {
            if ((c = Codigo.charAt(j)) != ' ' && Codigo.charAt(j) != '\n') {
                break;
            }
        }
        NumCarateresAvancar = k;
        if (k + 1 > Codigo.length()) {
            this.Codigo = Codigo.substring(i, k);
        } else {
            this.Codigo = Codigo.substring(i, k + 1);
        }

        if (j + 1 > Codigo.length()) {
            this.ParaAnalise = Codigo.substring(0, j);
        } else {
            this.ParaAnalise = Codigo.substring(0, j + 1);
        }
        return null;
    }

    public int getEspacosEntreCastVariavel() {
        return EspacosEntreCastVariavel;
    }

    public void setEspacosEntreCastVariavel(int EspacosEntreCastVariavel) {
        this.EspacosEntreCastVariavel = EspacosEntreCastVariavel;
    }

    @Override
    public void analisaStatement() {
        EspacosEntreCastVariavel = 0;

        try {
            for (int i = 0; i < ParaAnalise.length(); i++) {
                if (ParaAnalise.charAt(i) == ')') {
                    i++;
                    while (ParaAnalise.charAt(i) == ' ') {
                        EspacosEntreCastVariavel++;
                        i++;
                    }
                }
            }
        } catch (Exception e) {

        }
    }

    @Override
    public void converteStatement(EstiloProgramacao estilo) {
        int i=0,a=0, b=0;
        String aux1;
        for(i=0;i<Pai.getStatementsFilhos().size();i++)
        {
            if(Pai.getStatementsFilhos().get(i)==this)
                break;
        }
        try
        {
            aux1=Pai.getStatementsFilhos().get(i-1).Codigo;
            
            for(a=aux1.length()-1;a>0;a--)
            {
                if(aux1.charAt(a)!=' ')
                    break;
            }
            Pai.getStatementsFilhos().get(i-1).Codigo=aux1.substring(0, a+1);
        }
        catch(Exception e){}
        
        try
        {
            aux1=Pai.getStatementsFilhos().get(i+1).Codigo;
            
            for(b=0;b<aux1.length();b++)
            {
                if(aux1.charAt(b)!=' ')
                    break;
            }
            
            Pai.getStatementsFilhos().get(i+1).Codigo=aux1.substring(b);
        }
        catch(Exception e){}
        StringBuilder novastring = new StringBuilder();

        novastring.append(Codigo);
        for (int j = 0; j < estilo.getCast().getEspacosEntreCastVariavel(); j++) {
            novastring.append(' ');
        }

        this.Codigo = novastring.toString();
    }
}
