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

    private int PrimeiraChavetaNovaLinha;
    private int LinhasEmBrancoDepoisChavetaAberta, LinhasEmBrancoDepoisChavetaFechada;
    private boolean temChaveta;

    public Else(String codigo, Texto t) {
        super(codigo, t);
    }

    @Override
    public String RetiraDados(String Codigo, Texto t) {

        int i, m;
        boolean AspasAberto = false, PlicasAberto = false;

        this.Codigo = "else";
        this.NumCarateresAvancar = 5;

        for (i = 4; i < Codigo.charAt(i); i++) {
            if (Character.isWhitespace(Codigo.charAt(i))) {
                break;
            }
        }

         for (--i; i < Codigo.length(); i++) {
            if (Codigo.charAt(i) == '"' && Codigo.charAt(i - 1) != '\\') {
                AspasAberto = !AspasAberto;
                continue;
            } else if (Codigo.charAt(i) == '\'' && Codigo.charAt(i - 1) != '\\') {
                PlicasAberto = !PlicasAberto;
                continue;
            }
            if (Codigo.charAt(i) == '{') {
                temChaveta = true;
                break;
            } else if (Codigo.charAt(i) == ';') {
                temChaveta = false;
                break;
            }
        }

        if (temChaveta) {
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
        
        for(++m;m<Codigo.length();m++)
            if(!Character.isWhitespace(Codigo.charAt(m)))
                break;

        if(m+1>ParaAnalise.length())
            this.ParaAnalise = Codigo.substring(0, m);
        else
            this.ParaAnalise = Codigo.substring(0, m+1);

        if(m+1>Codigo.length())
            return Codigo.substring(5, m -(m-Codigo.length()));
        else
            return Codigo.substring(5,m+1);
    }
            
    public int getPrimeiraChavetaNovaLinha()
    {
        return PrimeiraChavetaNovaLinha;
    }

    public void setPrimeiraChavetaNovaLinha(int PrimeiraChavetaNovaLinha)
    {
        this.PrimeiraChavetaNovaLinha = PrimeiraChavetaNovaLinha;
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

    private boolean isElse(char A[])
    {
        if (A[0] == 'e' && A[1] == 'l' && A[2] == 's' && A[3] == 'e' && (A[4]=='{' || Character.isWhitespace(A[2]))) 
            return true;
        return false;
    }
    
    @Override
    public void analisaStatement()
    {
        LinhasEmBrancoDepoisChavetaAberta = -1;
        LinhasEmBrancoDepoisChavetaFechada = -1;
        PrimeiraChavetaNovaLinha = -1;
        boolean encontrou=false;
        
        int i;
        for(i = 0; i < ParaAnalise.length(); i++)
        {
            try
            {
                if(isElse(new char[]{ParaAnalise.charAt(i),ParaAnalise.charAt(i+1),ParaAnalise.charAt(i+2),ParaAnalise.charAt(i+3)}))
                {
                    i+=4;
                }
            }
            catch(Exception e){}
            
            for(++i;i<ParaAnalise.length();i++)
            {
                if(ParaAnalise.charAt(i)=='{')
                {
                    if(!encontrou)
                        PrimeiraChavetaNovaLinha = 0;
                    for(++i;i<ParaAnalise.length();i++)
                    {
                        if(ParaAnalise.charAt(i)=='\n')
                            LinhasEmBrancoDepoisChavetaAberta++;
                        else if(Character.isWhitespace(ParaAnalise.charAt(i)))
                            continue;
                        else 
                            break;
                    }
                    break;
                }
                else if(ParaAnalise.charAt(i)=='\n')
                {
                    PrimeiraChavetaNovaLinha = 1;
                    encontrou=true;
                }
            }
            break;
        }
        
        if(PrimeiraChavetaNovaLinha==-1)
            return;
        
        for(i=ParaAnalise.length()-1;i>0;i--)
        {
            if(ParaAnalise.charAt(i)=='}')
            {
                for(++i;i<ParaAnalise.length();i++)
                {
                    if(ParaAnalise.charAt(i)=='\n')
                        LinhasEmBrancoDepoisChavetaFechada++;
                    else
                        break;
                }
                break;
            }
        }
        
        if(LinhasEmBrancoDepoisChavetaAberta<0)
            LinhasEmBrancoDepoisChavetaAberta=0;
        
        if(LinhasEmBrancoDepoisChavetaFechada<0)
            LinhasEmBrancoDepoisChavetaFechada=0;
    }

    @Override
    public void converteStatement(EstiloProgramacao estilo) {
        super.converteStatement(estilo);
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
}
