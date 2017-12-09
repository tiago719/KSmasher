package Model.Statement;

import Model.Constantes;
import Model.Texto;

public class Operador extends Statement {

    private int EspacosOperadorVariavel, EspacosVariavelOperador;

    public Operador(String codigo, Texto t) {
        super(codigo, t);
    }

    @Override
    public String RetiraDados(String Codigo, Texto t) {
        int i, j, k;

        for (i = 0; i < Codigo.length(); i++) {
            if (Codigo.charAt(i) != ' ') {
                break;
            }
        }
        for (j = i; j < Codigo.length(); j++) {
            if (Codigo.charAt(j) == ' ') {
                break;
            }
        }
        for (k = j; k < Codigo.length(); k++) {
            if (Codigo.charAt(k) != ' ') {
                break;
            }
        }
        this.ParaAnalise = Codigo.substring(0, k);
        this.Codigo = Codigo.substring(i, j);
        return Codigo.substring(k+1);
    }

    public int getEspacosOperadorVariavel() {
        return EspacosOperadorVariavel;
    }

    public void setEspacosOperadorVariavel(int EspacosOperadorVariavel) {
        this.EspacosOperadorVariavel = EspacosOperadorVariavel;
    }

    public int getEspacosVariavelOperador() {
        return EspacosVariavelOperador;
    }

    public void setEspacosVariavelOperador(int EspacosVariavelOperador) {
        this.EspacosVariavelOperador = EspacosVariavelOperador;
    }
    
    private boolean isOperador(String Linha)
    {
        for(String s : Constantes.OPERADORES)
            if(Linha.contains(s))
                return true;
        return false;
    }

    @Override
    public void analisaStatement() {
        EspacosOperadorVariavel=0;
        EspacosVariavelOperador=0;
        int i;
        
        for(i=0;i<ParaAnalise.length();i++)
        {
            try
            {
                int posicaoOperador=i;
                if(!isOperador(ParaAnalise))
                    continue;

                while(ParaAnalise.charAt(++i)!=' ')
                    
                while(ParaAnalise.charAt(++i)==' ')
                    EspacosOperadorVariavel++;

                while(ParaAnalise.charAt(--posicaoOperador)==' ')
                    EspacosVariavelOperador++;

                break;
            }
            catch(Exception e)
            {
                
            }
        }
    }

    @Override
    public void converteStatement() {

    }
}
