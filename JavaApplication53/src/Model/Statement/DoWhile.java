package Model.Statement;

import Model.EstiloProgramacao.EstiloProgramacao;
import Model.Texto;
import Model.EstiloProgramacao.EstiloProgramacao;

public class DoWhile extends Statement
{

    private int LinhasEmBrancoDepoisChavetaAberta, LinhasEmBrancoDepoisChavetaFechada,
            EspacosWhileParentesesAberto, EspacosParentesesAbertoCondicao,
            EspacosCondicaoParentesFechado, PrimeiraChavetaNovaLinha;

    private Statement Condicao;
    private boolean TemChaveta;

    public DoWhile(String codigo, Texto t)
    {
        super(codigo, t);
    }

    @Override
    public String RetiraDados(String Codigo, Texto t)
    {
        int i, j, y = 0, PosWhile = 0;
        boolean AspasAberto = false, PlicasAberto = false;

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
        PosWhile = i;
        //retira espacos entre }/; e while
        for (++i; i < Codigo.length(); i++)
        {
            if (!Character.isWhitespace(Codigo.charAt(i)))
            {
                break;
            }
        }

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

        //retira espacos ate condicao
        for (; i < Codigo.length(); i++)
        {
            if (!Character.isWhitespace(Codigo.charAt(i)))
            {
                break;
            }
        }

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
        int z;
        char c;
        //procura ;
        for (z = j; z < Codigo.length(); z++)
        {
            if (!Character.isWhitespace(c=Codigo.charAt(z)))
            {
                break;
            }
        }

        //retira espacos do fim condicao ate )
        for (--j; j >= 0; j--)
        {
            if (!Character.isWhitespace(Codigo.charAt(i)))
            {
                break;
            }
        }

        Condicao = new Statement(Codigo.substring(i, j + 1), t);

        this.Codigo = null;
        if (z + 2 > Codigo.length()) {
            this.ParaAnalise = Codigo.substring(0, z - (z - Codigo.length()));
        } else {

            this.ParaAnalise = Codigo.substring(0, z + 2);
        }

        if (z + 1 > Codigo.length()) {
            this.NumCarateresAvancar = z - (z - Codigo.length());
        } else {

            this.NumCarateresAvancar = z + 1;
        }
        if (PosWhile + 1 > Codigo.length()) {
            return Codigo.substring(y, PosWhile - (PosWhile - Codigo.length()));
        } else {
            return Codigo.substring(y, PosWhile + 1);
        }
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
        super.converteStatement(estilo);
        //adicionar no inicio "do ..." e no final "while ( <condicao> );"

        String aux = this.Codigo;
        StringBuilder build = new StringBuilder(aux);
        char espacos[] =
        {
            ' ', ' ', ' ', ' ', ' ', ' ', ' '
        };
        char linhas[] =
        {
            '\n', '\n', '\n', '\n', '\n', '\n', '\n'
        };
        int conta = 0;

        for (int i = 0; i < aux.length(); i++)
        {
            if (aux.charAt(i) == '{')
            {
                build.insert(i + 1, linhas, 0, estilo.getDowhile().getLinhasEmBrancoDepoisChavetaAberta());
            }
            if (aux.charAt(i) == '}')
            {
                conta += estilo.getDowhile().getLinhasEmBrancoDepoisChavetaAberta();

                build.insert(i + conta, linhas, 0, estilo.getDowhile().getLinhasEmBrancoDepoisChavetaAberta());
                build.insert(i + conta + 1 + estilo.getDowhile().getLinhasEmBrancoDepoisChavetaAberta(), linhas, 0, estilo.getDowhile().getLinhasEmBrancoDepoisChavetaFechada());
            }
            if (aux.charAt(i) == '(')
            {
                conta += estilo.getDowhile().getLinhasEmBrancoDepoisChavetaAberta() + estilo.getDowhile().getLinhasEmBrancoDepoisChavetaFechada();

                build.insert(i + conta, espacos, 0, estilo.getDowhile().getEspacosWhileParentesesAberto());
                build.insert(i + conta + 1 + estilo.getDowhile().getEspacosWhileParentesesAberto(), espacos, 0, estilo.getDowhile().getEspacosParentesesAbertoCondicao());
            }
            if (aux.charAt(i) == ')')
            {
                conta += estilo.getDowhile().getEspacosWhileParentesesAberto() + estilo.getDowhile().getEspacosParentesesAbertoCondicao();

                build.insert(i + conta, espacos, 0, estilo.getDowhile().getEspacosCondicaoParentesFechado());

            }
        }
        this.Codigo = build.toString();
    }
}
