package Model.Statement;

import Model.EstiloProgramacao.DoWhile_EP;
import Model.EstiloProgramacao.EstiloProgramacao;
import Model.Texto;
import Model.EstiloProgramacao.EstiloProgramacao;
import Model.EstiloProgramacao.While_EP;

public class DoWhile extends Statement
{
    private int LinhasEmBrancoDepoisChavetaAberta, LinhasEmBrancoDepoisChavetaFechada,
            EspacosWhileParentesesAberto, EspacosParentesesAbertoCondicao,
            EspacosCondicaoParentesFechado, PrimeiraChavetaNovaLinha;

    private Statement Condicao;
    private boolean TemChaveta;

    public DoWhile(String codigo, Texto t, Statement Pai)
    {
        super(codigo, t, Pai);
    }

    @Override
    public String RetiraDados(String Codigo, Texto t)
    {
        int i, j, y = 0, PosWhile = 0;
        boolean AspasAberto = false, PlicasAberto = false;

        int a=2;
        boolean ultimo=false;
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
            else if(Codigo.charAt(a)=='{')
            {
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
        //procura se tem { ou nao
        for (i = 2; i < Codigo.length(); i++)
        {
            if (!Character.isWhitespace(Codigo.charAt(i)))
            {
                break;
            }
        }
        int numChavetasAbertos = 1;

        for (++i; i < Codigo.length(); i++)
        {
            if (Codigo.charAt(i) == '"' && Codigo.charAt(i - 1) != '\\')
            {
                AspasAberto = !AspasAberto;
            }
            if (Codigo.charAt(i) == '\'' && Codigo.charAt(i - 1) != '\\')
            {
                PlicasAberto = !PlicasAberto;
            }

            if (!AspasAberto && !PlicasAberto)
            {
                if (Codigo.charAt(i) == '{')
                {
                    numChavetasAbertos++;
                } else if (Codigo.charAt(i) == '}')
                {
                    if (--numChavetasAbertos == 0)
                    {
                        break;
                    }
                }
            }
        }
        
        
        //retira espacos entre }/; e while
        for (++i; i < Codigo.length(); i++)
        {
            if (!Character.isWhitespace(Codigo.charAt(i)))
            {
                break;
            }
        }
         
        int r=i;
        boolean primeiro=true;
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
        PosWhile = i;
        
        i += 5; //depois do while

        //retira espacos entre while e (
        for (; i < Codigo.length(); i++)
        {
            if (!Character.isWhitespace(Codigo.charAt(i)))
            {
                break;
            }
        }

        i++;//fica depois do (
        char c;

        //retira espacos ate condicao
        for (; i < Codigo.length(); i++)
        {
            if (!Character.isWhitespace(c=Codigo.charAt(i)))
            {
                break;
            }
        }
        
        int InicioCondicao=i;

        //procura fim da condicao
        int numParentesesAbertos = 1;
        AspasAberto = false;
        PlicasAberto = false;
        for (j = ++i; j < Codigo.length(); j++)
        {
            if (Codigo.charAt(j) == '"' && Codigo.charAt(j - 1) != '\\')
            {
                AspasAberto = !AspasAberto;
            }
            if (Codigo.charAt(j) == '\'' && Codigo.charAt(j - 1) != '\\')
            {
                PlicasAberto = !PlicasAberto;
            }

            if (!AspasAberto && !PlicasAberto)
            {
                if (Codigo.charAt(j) == ')')
                {
                    if(--numParentesesAbertos==0)
                        break;
                }
            }
        }
        int fimCondicao=j;
        int d=j;
        for(--d;d>0;d--)
        {
            if(!Character.isWhitespace(Codigo.charAt(d)))
                break;
        }
        int z;
        //procura ;
        for (z = j+1; z < Codigo.length(); z++)
        {
            c=Codigo.charAt(z);
            if (!Character.isWhitespace(c))
            {
                break;
            }
        }

        Condicao = new Statement(Codigo.substring(InicioCondicao, fimCondicao), t, this);
        this.ParaAnalise = Codigo.substring(0, z+1);
        this.NumCarateresAvancar = z+2;
        this.Codigo="";
        return Codigo.substring(a+1,r+1);
    }

    public int getPrimeiraChavetaNovaLinha()
    {
        return PrimeiraChavetaNovaLinha;
    }

    public void setPrimeiraChavetaNovaLinha(int PrimeiraChavetaNovaLinha)
    {
        this.PrimeiraChavetaNovaLinha = PrimeiraChavetaNovaLinha;
    }

    public int getLinhasEmBrancoDepoisChavetaAberta()
    {
        return LinhasEmBrancoDepoisChavetaAberta;
    }

    public void setLinhasEmBrancoDepoisChavetaAberta(int LinhasEmBrancoDepoisChavetaAberta)
    {
        this.LinhasEmBrancoDepoisChavetaAberta = LinhasEmBrancoDepoisChavetaAberta;
    }

    public int getLinhasEmBrancoDepoisChavetaFechada()
    {
        return LinhasEmBrancoDepoisChavetaFechada;
    }

    public void setLinhasEmBrancoDepoisChavetaFechada(int LinhasEmBrancoDepoisChavetaFechada)
    {
        this.LinhasEmBrancoDepoisChavetaFechada = LinhasEmBrancoDepoisChavetaFechada;
    }

    public int getEspacosWhileParentesesAberto()
    {
        return EspacosWhileParentesesAberto;
    }

    public void setEspacosWhileParentesesAberto(int EspacosWhileParentesesAberto)
    {
        this.EspacosWhileParentesesAberto = EspacosWhileParentesesAberto;
    }

    public int getEspacosParentesesAbertoCondicao()
    {
        return EspacosParentesesAbertoCondicao;
    }

    public void setEspacosParentesesAbertoCondicao(int EspacosParentesesAbertoCondicao)
    {
        this.EspacosParentesesAbertoCondicao = EspacosParentesesAbertoCondicao;
    }

    public int getEspacosCondicaoParentesFechado()
    {
        return EspacosCondicaoParentesFechado;
    }

    public void setEspacosCondicaoParentesFechado(int EspacosCondicaoParentesFechado)
    {
        this.EspacosCondicaoParentesFechado = EspacosCondicaoParentesFechado;
    }

    private boolean isDoWhile(char A[])
    {
        if (A[0] == 'd' && A[1] == 'o' && (A[2] == '{' || Character.isWhitespace(A[2])))
            return true;
        else
            return false;
    }

    @Override
    public void analisaStatement()
    {
        LinhasEmBrancoDepoisChavetaAberta = -1;
        LinhasEmBrancoDepoisChavetaFechada = 0;
        EspacosWhileParentesesAberto = 0;
        EspacosParentesesAbertoCondicao = 0;
        EspacosCondicaoParentesFechado = 0;
        PrimeiraChavetaNovaLinha = 0;

        int i;

        for (i = 0; i < ParaAnalise.length(); i++)
        {
            try
            {
                if (isDoWhile(new char[]{ParaAnalise.charAt(i), ParaAnalise.charAt(i + 1), ParaAnalise.charAt(i+2)}))
                {
                    i += 2;
                }
                else
                    continue;
            }
            catch(Exception e){}
            
            for(;i<ParaAnalise.length();i++)
            {
                if(ParaAnalise.charAt(i)=='{')
                {
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
                    PrimeiraChavetaNovaLinha = 1;
            }
            break;
        }
        
         for(i=ParaAnalise.length()-1;i>0;i--)
            {
                if(ParaAnalise.charAt(i)==')')
                {
                    for(--i;i>0;i--)
                    {
                        if(ParaAnalise.charAt(i)==' ')
                            EspacosCondicaoParentesFechado++;
                        else
                            break;
                    }
                    break;
                }
            }
            
         int contParentesesFechados=0, indexParentesAberto=-1;
            for(;i>0;i--)
            {
                if(ParaAnalise.charAt(i)=='(')
                {
                    if(contParentesesFechados==0)
                    {
                        indexParentesAberto=i;
                        break;
                    }
                    else
                        contParentesesFechados--;
                }
                else if(ParaAnalise.charAt(i)==')')
                    contParentesesFechados++;
            }
            
            for(++indexParentesAberto;i<ParaAnalise.length();indexParentesAberto++)
            {
                if(ParaAnalise.charAt(indexParentesAberto)==' ')
                    EspacosParentesesAbertoCondicao++;
                else
                    break;
            }
            
            for(--i;i>0;i--)
            {
                if(ParaAnalise.charAt(i)==' ')
                    EspacosWhileParentesesAberto++;
                else
                    break;
            }
            
            for(;i>0;i--)
            {
                if(ParaAnalise.charAt(i)=='}')
                    break;
            }
            
            for(++i;i<ParaAnalise.length();i++)
            {
                if(ParaAnalise.charAt(i)=='\n')
                    LinhasEmBrancoDepoisChavetaFechada++;
                else if(Character.isWhitespace(ParaAnalise.charAt(i)))
                    continue;
                else 
                    break;
            }
        
        if(LinhasEmBrancoDepoisChavetaAberta<0)
            LinhasEmBrancoDepoisChavetaAberta=0;
    }

    @Override
    public void converteStatement(EstiloProgramacao estilo)
    {
        String Aux = "";
        Statement Last=null;
        Statement ultimoFilho=getLastSon();
        
        if(Pai!=null)
        {
            for(Statement s :Pai.getStatementsFilhos())
            {
                if(s==this)
                    break;
                Last=s;
            }

            if(Last!=null)
            {
                int i=1;
                for(i=Last.getCodigo().length()-1;i>0;i--)
                {
                    if(Last.getCodigo().charAt(i)!='\t' && Last.getCodigo().charAt(i)!=' ')
                        break;
                }
                try
                {
                    Last.Codigo=Last.getCodigo().substring(0,i);
                }
                catch(Exception e){}
            }
        }
        for(int i=0;i<getNivel();i++)
            Aux+="\t";
        Aux+="do";
        DoWhile_EP ep = estilo.getDowhile();
        
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
        int b=0;
        for(b=0;b<ep.getLinhasEmBrancoDepoisChavetaFechada();b++)
        {
            ultimoFilho.Codigo+="\n";
        }
        if(b!=0)
        {
            for(int a=0;a<getNivel();a++)
            {
                ultimoFilho.Codigo+="\t";
            }
        }
        ultimoFilho.Codigo+="while";
        
        for(int a=0;a<ep.getEspacosWhileParentesesAberto();a++)
        {
            ultimoFilho.Codigo+=" ";
        }
        ultimoFilho.Codigo+="(";
        
        for(int a=0;a<ep.getEspacosParentesesAbertoCondicao();a++)
        {
            ultimoFilho.Codigo+=" ";
        }
        
        if(Condicao.hasFilhos())
        {
            for(Statement S : Condicao.getStatementsFilhos())
            {
                S.converteStatement(estilo);
            }
            for(Statement S : Condicao.getStatementsFilhos())
            {
                ultimoFilho.Codigo+=S.getCodigo();
            }
        }
        else
            ultimoFilho.Codigo+=Condicao.getCodigo();
        
        for(int a=0;a<ep.getEspacosCondicaoParentesFechado();a++)
        {
            ultimoFilho.Codigo+=" ";
        }
        ultimoFilho.Codigo+=");";
        this.Codigo = Aux;
    }
}
