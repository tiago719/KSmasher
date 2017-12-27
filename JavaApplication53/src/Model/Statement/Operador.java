package Model.Statement;

import Model.Constantes;
import Model.Texto;
import java.util.ArrayList;
import Model.EstiloProgramacao.EstiloProgramacao;

public class Operador extends Statement {

    private int EspacosOperadorVariavel, EspacosVariavelOperador;

    public Operador(String codigo, Texto t, Statement Pai) {
        super(codigo, t, Pai);
    }

    @Override
    public String RetiraDados(String Codigo, Texto t) {
        int i = 0, j = 0;

        for (i = 1; i < Codigo.length(); i++) {
            if (!Character.isWhitespace(Codigo.charAt(i))) {
                break;
            }
        }

        for (j = Codigo.length() - 2; j >= 0; j--) {
            if (!Character.isWhitespace(Codigo.charAt(i))) {
                break;
            }
        }

        this.ParaAnalise = Codigo;
        if (j + 1 > Codigo.length()) {
            this.Codigo = Codigo.substring(i, j - (j - Codigo.length()));
        } else {
            this.Codigo = Codigo.substring(i, j + 1);
        }
        this.Codigo=this.Codigo.trim();

        return null;
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

    @Override
    public void analisaStatement() {
        EspacosOperadorVariavel = 0;
        EspacosVariavelOperador = 0;
        int i, posicaoOperador = -1, tipo = 0;

        for (i = 0; i < ParaAnalise.length(); i++) {
            posicaoOperador = i;
            try {
                if (Texto.IsOperador3(ParaAnalise.substring(i, i + 3))) {
                    tipo = 3;
                    break;
                }
            } catch (Exception e) {
            }
            try {
                if (Texto.IsOperador2(ParaAnalise.substring(i, i + 2))) {
                    tipo = 2;
                    break;
                }
            } catch (Exception e) {
            }
            try {
                if (Texto.IsOperador1(ParaAnalise.charAt(i))) {
                    tipo = 1;
                    break;
                }
            } catch (Exception e) {
            }
        }

        for (i += tipo; i < ParaAnalise.length(); i++) {
            if (ParaAnalise.charAt(i) == ' ') {
                EspacosOperadorVariavel++;
            } else {
                break;
            }
        }
        for (--posicaoOperador; posicaoOperador > 0; posicaoOperador--) {
            if (ParaAnalise.charAt(posicaoOperador) == ' ') {
                EspacosVariavelOperador++;
            } else {
                break;
            }
        }
    }

    @Override
    public void converteStatement(EstiloProgramacao estilo) {
        String aux1;
        int i=0,a=0, b=0;
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
                char c=aux1.charAt(a);
                if(aux1.charAt(a)!=' ')
                    break;
            }
            Pai.getStatementsFilhos().get(i-1).Codigo=aux1.substring(0, a-1);
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

        for (int j = 0; j < estilo.getOperador().getEspacosVariavelOperador(); j++) {
            novastring.append(' ');
        }

        novastring.append(Codigo);
        
        for (int j = 0; j < estilo.getOperador().getEspacosOperadorVariavel(); j++) {
            novastring.append(' ');
        }
        
        this.Codigo = novastring.toString();
    }
}
