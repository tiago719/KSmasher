/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Statement;

import Model.EstiloProgramacao.Else_EP;
import Model.Texto;
import Model.EstiloProgramacao.EstiloProgramacao;
/**
 *
 * @author Tiago Coutinho
 */
public class Else extends Statement {

    private int PrimeiraChavetaNovaLinha;
    private int LinhasEmBrancoDepoisChavetaAberta, LinhasEmBrancoDepoisChavetaFechada;
    private boolean temChaveta;

    public Else(String codigo, Texto t, Statement Pai) {
        super(codigo, t, Pai);
    }

    @Override
    public String RetiraDados(String Codigo, Texto t) {

        int i, m=0, j;
        boolean AspasAberto = false, PlicasAberto = false;

        this.Codigo = "else";
        

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
                m = i;
                break;
            }
        }
         
        int a=i;
        boolean ultimo=false;
        boolean primeiro=true;
        boolean comentAberto=false;
        for(++a;a<Codigo.length();a++)
        {
            try
            {
                if(Codigo.charAt(a)=='/' && Codigo.charAt(a+1)=='/')
                {
                    comentAberto=true;
                }
            }
            catch(Exception e){}
            if(Codigo.charAt(a)=='\t' || Codigo.charAt(a)==' ')
            {
                ultimo=false;
                continue;
            }
            else if(Codigo.charAt(a)=='{'&& primeiro)
            {
                primeiro=false;
                ultimo=true;
                continue;
            }
            if(Codigo.charAt(a)=='\n')
            {
                comentAberto=false;
            }
            else if(Codigo.charAt(a)!='\n' && Codigo.charAt(a)!='\r' && !comentAberto)
            {
                ultimo=true;
                break;
            }
        }
        if(ultimo)
        {
            for(--a;a>0;a--)
               if(Codigo.charAt(a)!='\t' && Codigo.charAt(a)!=' ')
                   break;
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
                } else if (Codigo.charAt(m) == '}') {
                    if (--NumParentesesAbertos == 0) {
                        break;
                    }  
                }
            }
        } 
        j = m;
   
        this.NumCarateresAvancar = j+2;
        for(++m;m<Codigo.length();m++)
            if(!Character.isWhitespace(Codigo.charAt(m)))
                break;
        
        int r=m;
        primeiro=true;
        for(--r;r>0;r--)
        {
            if(Codigo.charAt(r)=='\t' || Codigo.charAt(r)==' ')
            {
                continue;
            }
            else if(Codigo.charAt(r)=='}' && primeiro)
            {
                primeiro=false;
                continue;
            }
            else if(Codigo.charAt(r)!='\n' && Codigo.charAt(r)!='\r')
            {
                break;
            }
        }

        if(m+1>ParaAnalise.length())
            this.ParaAnalise = Codigo.substring(0, m - (m - Codigo.length()));
        else
            this.ParaAnalise = Codigo.substring(0, m+1);

        if(r+1>Codigo.length())
            return Codigo.substring(a+1, r -(r-Codigo.length()));
        else
         return Codigo.substring(a+1, r + 1);

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
        int parentesesAberto=1;
        
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
        
        for(;i<ParaAnalise.length();i++)
        {
            if(ParaAnalise.charAt(i)=='{')
                parentesesAberto++;
            else if(ParaAnalise.charAt(i)=='}')
                if(--parentesesAberto==0)
                {
                    for(++i;i<ParaAnalise.length();i++)
                        if(ParaAnalise.charAt(i)=='\n')
                            LinhasEmBrancoDepoisChavetaFechada++;
                        else if(!Character.isWhitespace(ParaAnalise.charAt(i)))
                            break;
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
        if(estilo.getElses() == null)
        {
            return;
        }
        String Aux = "";
        Statement Last=null;
        Statement ultimoFilho=getLastSon();
        
        if (Pai != null) {
            for (Statement s : Pai.getStatementsFilhos()) {
                if (s == this) {
                    break;
                }
                Last = s;
            }

            if (Last != null) {
                int i;
                for (i = Last.getCodigo().length() - 1; i > 0; i--) {
                    if (Last.getCodigo().charAt(i) != '\t' && Last.getCodigo().charAt(i) != ' ') {
                        break;
                    }
                }
                try {
                    Last.Codigo = Last.getCodigo().substring(0, i);
                } catch (Exception e) {
                }
            }
        }
        Else_EP ep = estilo.getElses();
        
        for(int i=0;i<getNivel();i++)
            Aux+="\t";
        Aux+="else";
        
        if(ep.isPosicaoPrimeiraChaveta())
        {
            Aux+="\n";
            for(int i=0;i<getNivel();i++)
                Aux+="\t";

            Aux+="{";
        }
        else
        {
            Aux+="{";
        }
        for(int a=0;a<ep.getLinhasEmBrancoDepoisChavetaAberta()+1;a++)
        {
            Aux+="\n";
        }
         ultimoFilho.Codigo+="\n";
        for(int a=0;a<getNivel();a++)
        {
            ultimoFilho.Codigo+="\t";
        }
        ultimoFilho.Codigo+="}";
        for(int a=0;a<ep.getLinhasEmBrancoDepoisChavetaFechada();a++)
        {
            ultimoFilho.Codigo+="\n";
        }
         this.Codigo = Aux;
    }
}
