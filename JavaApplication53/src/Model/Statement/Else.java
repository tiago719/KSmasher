/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Statement;

import Model.Texto;
import java.util.ArrayList;
import Model.EstiloProgramacao.EstiloProgramacao;
/**
 *
 * @author Tiago Coutinho
 */
public class Else extends Statement {

    private int PosicaoPrimeiraChaveta;
    private int LinhasEmBrancoDepoisChavetaAberta, LinhasEmBrancoDepoisChavetaFechada;

    public Else(String codigo, Texto t) {
        super(codigo, t);
    }

    @Override
    public String RetiraDados(String Codigo, Texto t) {

        int i, m;
        boolean AspasAberto = false, PlicasAberto = false;

        this.Codigo = "else";
        this.NumCarateresAvancar = 5;

        for (i = 5; i < Codigo.charAt(i); i++) {
            if (Codigo.charAt(i) != ' ' && Codigo.charAt(i) != '\n') {
                break;
            }
        }
        String IsIF = Codigo.substring(i, i + 3);
        if (IsIF.charAt(0) == 'i' && IsIF.charAt(1) == 'f' && !(IsIF.charAt(2) >= 'A' && IsIF.charAt(2) <= 'z')) {
            this.ParaAnalise = "else";
            return null;
        }

        if (Codigo.charAt(i) == '{') {
            int NumParentesesAbertos = 1;

            for (m = i + 1; m < Codigo.length(); m++) {
                if (Codigo.charAt(m) == '"' && Codigo.charAt(m - 1) != '\\') {
                    AspasAberto = !AspasAberto;
                    continue;
                } else if (Codigo.charAt(m) == '\'' && Codigo.charAt(m - 1) != '\\') {
                    PlicasAberto = !PlicasAberto;
                    continue;
                }
                if (Codigo.charAt(m) == '{') {
                    NumParentesesAbertos++;
                    break;
                } else if (Codigo.charAt(m) == '}') {
                    if (--NumParentesesAbertos == 0) {
                        break;
                    }
                }
            }
        } else {
            for (m = i + 1; m < Codigo.length(); m++) {
                if (Codigo.charAt(m) == '"' && Codigo.charAt(m - 1) != '\\') {
                    AspasAberto = !AspasAberto;
                    continue;
                } else if (Codigo.charAt(m) == '\'' && Codigo.charAt(m - 1) != '\\') {
                    PlicasAberto = !PlicasAberto;
                    continue;
                }
                if (Codigo.charAt(m) == ';') {
                    break;
                }
            }
        }

        this.ParaAnalise = Codigo.substring(0, m + 1);

        return Codigo.substring(5, m + 1);
    }
            
    public int isPosicaoPrimeiraChaveta()
    {
        return PosicaoPrimeiraChaveta;
    }

    public void setPosicaoPrimeiraChaveta(int PosicaoPrimeiraChaveta)
    {
        this.PosicaoPrimeiraChaveta = PosicaoPrimeiraChaveta;
    }

    public int getLinhasEmBrancoDepoisChavetaAberta() {
        return LinhasEmBrancoDepoisChavetaAberta;
    }

    public void setLinhasEmBrancoDepoisChavetaAberta(int LinhasEmBrancoDepoisChavetaAberta) {
        this.LinhasEmBrancoDepoisChavetaAberta = LinhasEmBrancoDepoisChavetaAberta;
    }

    public int getLinhasEmBrancoDepoisChavetaFechada() {
        return LinhasEmBrancoDepoisChavetaFechada;
    }

    public void setLinhasEmBrancoDepoisChavetaFechada(int LinhasEmBrancoDepoisChavetaFechada) {
        this.LinhasEmBrancoDepoisChavetaFechada = LinhasEmBrancoDepoisChavetaFechada;
    }

    @Override
    public void analisaStatement()
    {
        
        LinhasEmBrancoDepoisChavetaAberta = 0;
        LinhasEmBrancoDepoisChavetaFechada = 0;
        PosicaoPrimeiraChaveta = 0;
        
        int i;
        for(i = 0; i < ParaAnalise.length(); i++){
//            if(Texto.IsElse(new char[]{ParaAnalise.charAt(i),ParaAnalise.charAt(i+1),ParaAnalise.charAt(i+2),ParaAnalise.charAt(i+3)}))
//                {
//                    i+=4;
//                }
            while(ParaAnalise.charAt(i)!='{')
            {
                if(ParaAnalise.charAt(i)=='\n')
                {
                    LinhasEmBrancoDepoisChavetaAberta++;
                }
                else if(ParaAnalise.charAt(i)==';')
                {
                    PosicaoPrimeiraChaveta = 1;
                    LinhasEmBrancoDepoisChavetaAberta = 0;
                    return;
                }
                i++;
            }            
            while(ParaAnalise.charAt(i)!='}'){
                if(ParaAnalise.charAt(i)=='\n')
                    LinhasEmBrancoDepoisChavetaFechada++;
                i++;
            }        
        }
    }


    @Override
    public String converteStatement() {
        return "";
    }
  /*

    //@Override
    public void converteStatement(EstiloProgramacao estilo) {       
        StringBuilder novastring = new StringBuilder();
        novastring.append("else");
        for(int i = 4; i<Codigo.length();i++){
            if(Codigo.charAt(i)=='{'){
                for(int j=0; j<estilo.getElses().getLinhasEmBrancoDepoisChavetaAberta();j++){
                    novastring.append("\n");
                }
                novastring.append('{');
            }
            if(Codigo.charAt(i)=='}'){
                for(int j = 0; j<estilo.getElses().getLinhasEmBrancoDepoisChavetaFechada();j++){
                    novastring.append("\n");
                }
                novastring.append('}');
            }
            novastring.append(Codigo.charAt(i));
        }
        this.Codigo=novastring.toString();

    }
    */
}
