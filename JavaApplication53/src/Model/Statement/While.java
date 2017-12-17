
package Model.Statement;

import Model.Texto;
import java.util.ArrayList;


public class While extends Statement
{
    private int LinhasEmBrancoDepoisChavetaAberta, LinhasEmBrancoDepoisChavetaFechada,
        EspacosWhileParentesAberto, EspacosParentesesAbertoCondicao, EspacosCondicaoParentesFechado,
            ChavetaUmStatementDentroWhile, PrimeiraChavetaNovaLinha;
    
    private Statement Condicao;
    private boolean TemChaveta;

    public While(String codigo, Texto t)
    {
        super(codigo, t);
    }

    @Override
    public String RetiraDados(String Codigo, Texto t) {
        int i, j, z, l, m, n;

        //retira espacos entre while e (
        for (i = 5; i < Codigo.length(); i++) {
            char qq = Codigo.charAt(i);
            if (Codigo.charAt(i) != ' ' && Codigo.charAt(i) != '\n') {
                break;
            }
        }

        i++;//fica depois do (

        //retira espacos ate condicao
        for (; i < Codigo.length(); i++) {
            if (Codigo.charAt(i) != ' ' && Codigo.charAt(i) != '\n') {
                break;
            }
        }

        //procura fim do while
        int numParentesesAbertos = 1;
        boolean AspasAberto = false, PlicasAberto = false;
        for (j = i; j < Codigo.length(); j++) {
            if (Codigo.charAt(j) == '"' && Codigo.charAt(j - 1) != '\\') {
                AspasAberto = !AspasAberto;
            }
            if (Codigo.charAt(j) == '\'' && Codigo.charAt(j - 1) != '\\') {
                PlicasAberto = !PlicasAberto;
            }

            if (!AspasAberto && !PlicasAberto) {
                if (Codigo.charAt(j) == '(') {
                    numParentesesAbertos++;
                }
                if (Codigo.charAt(j) == ')') {
                    if (--numParentesesAbertos == 0) {
                        break;
                    }
                }
            }
        }

        //retira espacos do fim condicao ate )
        for (z = j - 1; z >= 0; z--) {
            if (Codigo.charAt(z) != ' ' && Codigo.charAt(j) != '\n') {
                break;
            }

        }
                
        Condicao = new Statement(Codigo.substring(i, z+1), t);
        
        AspasAberto = PlicasAberto = false;
        //procurar {
        for (l = j + 1; l < Codigo.length(); l++) {
            if (Codigo.charAt(l) == '"' && Codigo.charAt(l - 1) != '\\') {
                AspasAberto = !AspasAberto;
                continue;
            } else if (Codigo.charAt(l) == '\'' && Codigo.charAt(l - 1) != '\\') {
                PlicasAberto = !PlicasAberto;
                continue;
            }
            if (Codigo.charAt(l) == '{') {
                TemChaveta = true;
                break;
            } else if (Codigo.charAt(l) == ';') {
                TemChaveta = false;
                break;
            }
        }
        if (TemChaveta) {
            int NumParentesesAbertos = 1;
            AspasAberto = PlicasAberto = false;
            
            for (m = l + 1; m < Codigo.length(); m++) {
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
                }
                else if(Codigo.charAt(m) == '}') {
                    if (--NumParentesesAbertos == 0){
                        break;
                    }
                }
            }
        } else {
            m = l;
        }
        for (n = m + 1; n < Codigo.length(); n++) {
            if (Codigo.charAt(n) != ' ' && Codigo.charAt(n) != '\n')
                break;
        }
        try
        {
            this.ParaAnalise = Codigo.substring(0, n + 1);
        }
        catch(Exception e)
        {
            this.ParaAnalise=Codigo;
        }
            
        this.Codigo = Codigo.substring(0, j + 1);
        this.NumCarateresAvancar = m + 1;
        return Codigo.substring(l, m + 1);
    }
    
    public int isPrimeiraChavetaNovaLinha()
    {
        return PrimeiraChavetaNovaLinha;
    }

    public void setPosicaoPrimeiraChaveta(int PosicaoPrimeiraChaveta)
    {
        this.PrimeiraChavetaNovaLinha = PosicaoPrimeiraChaveta;
    }

    public int isChavetaUmStatementDentroWhile()
    {
        return ChavetaUmStatementDentroWhile;
    }

    public void setChavetaUmStatementDentroWhile(int ChavetaUmStatementDentroWhile)
    {
        this.ChavetaUmStatementDentroWhile = ChavetaUmStatementDentroWhile;
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

    public int getEspacosWhileParentesAberto() {
        return EspacosWhileParentesAberto;
    }

    public void setEspacosWhileParentesAberto(int EspacosWhileParentesAberto) {
        this.EspacosWhileParentesAberto = EspacosWhileParentesAberto;
    }

    public int getEspacosParentesesAbertoCondicao() {
        return EspacosParentesesAbertoCondicao;
    }

    public void setEspacosParentesesAbertoCondicao(int EspacosParentesesAbertoCondicao) {
        this.EspacosParentesesAbertoCondicao = EspacosParentesesAbertoCondicao;
    }

    public int getEspacosCondicaoParentesFechado() {
        return EspacosCondicaoParentesFechado;
    }

    public void setEspacosCondicaoParentesFechado(int EspacosCondicaoParentesFechado) {
        this.EspacosCondicaoParentesFechado = EspacosCondicaoParentesFechado;
    }
    
    private boolean isWhile(char A[])
    {
        if (A[0] == 'w' && A[1] == 'h' && A[2] == 'i' && A[3] == 'l' && A[4] == 'e' && (A[5]=='(' || Character.isWhitespace(A[5]))) {
            return true;
        }
        return false;
    }
    
    @Override
    public void analisaStatement()
    {
        EspacosParentesesAbertoCondicao=0;
        EspacosWhileParentesAberto=0;
        EspacosCondicaoParentesFechado=0;
        ChavetaUmStatementDentroWhile=-1;
        PrimeiraChavetaNovaLinha=-1;
        LinhasEmBrancoDepoisChavetaAberta=-1;
        LinhasEmBrancoDepoisChavetaFechada=-1;
        int contParenteses=0, indexParenteses=-1,i, aux,a, contPontoVirgula=0;
        char c;
        
        for(i=0;i<ParaAnalise.length();i++)
        { 
            try
            {
                if(isWhile(new char[]{ParaAnalise.charAt(i),ParaAnalise.charAt(i+1),ParaAnalise.charAt(i+2),ParaAnalise.charAt(i+3),ParaAnalise.charAt(i+4), ParaAnalise.charAt(i+5)}))
                {
                    i+=5;
                }
                else
                    continue;
            }
            catch(Exception e){}
            for(;i<ParaAnalise.length();i++)
            {
                if(ParaAnalise.charAt(i)!='(')
                    EspacosWhileParentesAberto++;
                else
                    break;
            }
            
            for(++i;i<ParaAnalise.length();i++)
            {
                if(ParaAnalise.charAt(i)==' ')
                    EspacosParentesesAbertoCondicao++;
                else
                    break;
            }
            while(++i<ParaAnalise.length())
            {
                if(ParaAnalise.charAt(i)==')')
                {
                    if(contParenteses==0)
                    {
                        indexParenteses=i;
                        break;
                    }
                    else
                        contParenteses--;
                }                      
                if(ParaAnalise.charAt(i)=='(')
                    contParenteses++;
            }
            for(indexParenteses--;indexParenteses>0;indexParenteses--)
            {
                if(ParaAnalise.charAt(indexParenteses)==' ')
                    EspacosCondicaoParentesFechado++;
                else
                    break;
            }
            break;
        }
        
        aux=i;
        
        for(a=indexParenteses+1;a<ParaAnalise.length();a++)
        {
            if(ParaAnalise.charAt(a)==';')
            {
                if(contPontoVirgula==2)
                    break;
                else
                    contPontoVirgula++;        
            }
        }
        
        if(contPontoVirgula<2)
        {     
            for(++i;i<ParaAnalise.length();i++)
            {
                if(Character.isWhitespace(ParaAnalise.charAt(i)))
                    continue;
                else 
                    break;
            }
            if(ParaAnalise.charAt(i)=='{')
                ChavetaUmStatementDentroWhile=1;
            else
            {
                ChavetaUmStatementDentroWhile=0;
                PrimeiraChavetaNovaLinha=-1;
            }
        }        
        boolean primeiro=true;

        if(ChavetaUmStatementDentroWhile!=0)
        {
            PrimeiraChavetaNovaLinha=0;
            LinhasEmBrancoDepoisChavetaAberta=0;
            LinhasEmBrancoDepoisChavetaFechada=0;
            for(i=indexParenteses+1;i<ParaAnalise.length();i++)
            {
                if(ParaAnalise.charAt(i)=='\n')
                    PrimeiraChavetaNovaLinha=1;
                if(ParaAnalise.charAt(i)=='{')
                {
                    for(i+=1;i<ParaAnalise.length();i++)
                    {
                        if(ParaAnalise.charAt(i)=='\n')
                        {
                            if(primeiro)
                                primeiro=false;
                            else
                                LinhasEmBrancoDepoisChavetaAberta++;  
                        }     
                        else if(Character.isWhitespace( ParaAnalise.charAt(i)))
                            continue;
                        else
                            break;
                    }
                    break;
                }
            }
            aux=0;
            for(i+=1;i<ParaAnalise.length();i++)
            {
                if(ParaAnalise.charAt(i)=='{')
                    aux++;
                if(ParaAnalise.charAt(i)=='}')
                {
                    if(aux<=0)
                        break;
                    else
                        aux--;
                }          
            }
            primeiro=true;
            for(i++;i<ParaAnalise.length();i++)
            {
               if(ParaAnalise.charAt(i)=='\n')
                {
                    if(primeiro)
                        primeiro=false;
                    else
                        LinhasEmBrancoDepoisChavetaFechada++;  
                }     
                else if(Character.isWhitespace( ParaAnalise.charAt(i)))
                    continue;
                else
                    break;
            }
        }
        if(ChavetaUmStatementDentroWhile!=0)
        {
            LinhasEmBrancoDepoisChavetaAberta=0;
            LinhasEmBrancoDepoisChavetaFechada=0;
            for(i=0;i<ParaAnalise.length();i++)
            {
                if(ParaAnalise.charAt(i)=='{')
                    while(ParaAnalise.charAt(++i)=='\n')
                        LinhasEmBrancoDepoisChavetaAberta++;                       
            }
            
            
        }
    }

    @Override
    public String converteStatement() {
        return "";
    }
}
