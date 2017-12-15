package Model.Statement;

import Model.Constantes;
import Model.Texto;
import java.util.ArrayList;
import Model.EstiloProgramacao.EstiloProgramacao;

public class Operador extends Statement {

    private int EspacosOperadorVariavel, EspacosVariavelOperador;

    public Operador(String codigo, Texto t) {
        super(codigo, t);
    }

    @Override
    public String RetiraDados(String Codigo, Texto t) {
        int i = 0, j = 0;

        for (i = 1; i < Codigo.length(); i++) {
            if (Codigo.charAt(i) != ' ' && Codigo.charAt(i) != '\n') {
                break;
            }
        }

        for (j = Codigo.length() - 2; j >= 0; j--) {
            char qqq = Codigo.charAt(j);
            if (Codigo.charAt(j) != ' ' && Codigo.charAt(j) != '\n') {
                break;
            }
        }

        this.ParaAnalise = Codigo;
        this.Codigo = Codigo.substring(i, j + 1);

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
        int i, posicaoOperador=-1, tipo=0;

        for (i = 0; i < ParaAnalise.length(); i++) {
            posicaoOperador = i;
            try
            {
                if (Texto.IsOperador3(ParaAnalise.substring(i,i+3)))
                {
                    tipo=3;
                    break;
                }
            }
            catch(Exception e){}
            try
            {
                if (Texto.IsOperador2(ParaAnalise.substring(i,i+2)))
                {
                    tipo=2;
                    break;
                }
            }
            catch(Exception e){}
            try
            {
                if (Texto.IsOperador1(ParaAnalise.charAt(i)))
                {
                    tipo=1;
                    break;
                }
            }
            catch(Exception e){}
        }
            
        for(i+=tipo;i<ParaAnalise.length();i++)
        {
            if(ParaAnalise.charAt(i)==' ')
            {
                EspacosOperadorVariavel++;
            }
            else
                break;
        }
        for(--posicaoOperador;posicaoOperador>0;posicaoOperador--)
        {
            if (ParaAnalise.charAt(posicaoOperador) == ' ')
                EspacosVariavelOperador++;
            else
                break;
        }
    }

    //@Override
    public void converteStatement(EstiloProgramacao estilo) {
        StringBuilder novastring = new StringBuilder();
        for(int i=0; i<Codigo.length(); i++){
            if(i==0){
                for(int j=0;j<estilo.getOperador().getEspacosVariavelOperador();j++){
                    novastring.append(' ');
                }
            }
            else if(i==Codigo.length()-1){
                for(int j=0;j<estilo.getOperador().getEspacosOperadorVariavel();j++){
                    novastring.append(' ');
                }
            }
            else{
                novastring.append(Codigo.charAt(i));
            }
        }
        this.Codigo=novastring.toString();
    }
}
