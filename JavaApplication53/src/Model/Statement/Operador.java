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
        int i = 0, j = 0;

        for (String Operador : Constantes.OPERADORES) {
            if (Codigo.contains(Operador)) {
                i = Codigo.indexOf(Operador);
                j = Operador.length();
            }
        }
        
        this.ParaAnalise = Codigo;
        this.Codigo = Codigo.substring(i, i+j);
        return Codigo.substring(i+j+1);
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
