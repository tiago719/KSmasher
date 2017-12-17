package Model.Statement;


import Model.EstiloProgramacao.EstiloProgramacao;
import Model.Texto;
import java.util.ArrayList;

public class If extends Statement {

    private int EspacosIfParentesAberto, EspacosParentesesAbertoCondicao, EspacosCondicaoParentesFechado,
            LinhasEmBrancoDepoisChavetaAberta, LinhasEmBrancoDepoisChavetaFechada,
            ChavetaUmStatementIf, PrimeiraChavetaNovaLinha;

    private Statement Condicao;
    private boolean TemChaveta;

    public If(String codigo, Texto t) {
        super(codigo, t);
    }

    public Statement getCondicao() {
        return Condicao;
    }

    @Override
    public String RetiraDados(String Codigo, Texto T) {
        int i, j, k, m, n;

        //retira espacos entre if e (
        for (i = 2; i < Codigo.length(); i++) {
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

        //procura fim do if
        int NumParentesesAbertos = 1;
        boolean AspasAberto = false, PlicasAberto = false;
        for (j = i; j < Codigo.length(); j++) {
            if (Codigo.charAt(j) == '"' && Codigo.charAt(j - 1) != '\\') {
                AspasAberto = !AspasAberto;
                continue;
            } else if (Codigo.charAt(j) == '\'' && Codigo.charAt(j - 1) != '\\') {
                PlicasAberto = !PlicasAberto;
                continue;
            }

            if (!AspasAberto && !PlicasAberto) {
                if (Codigo.charAt(j) == '(') {
                    NumParentesesAbertos++;
                } else if (Codigo.charAt(j) == ')') {
                    if (--NumParentesesAbertos == 0) {
                        break;
                    }
                }
            }
        }
        
        //retira espacos do fim condicao ate )
        for (k = j; k >= 0; k--) {
            if (Codigo.charAt(k) != ' ' && Codigo.charAt(k) != '\n') {
                break;
            }

        }

        
        int a;
        char c;
        AspasAberto = PlicasAberto = false;
        //procurar {
        for (a = j + 1; a < Codigo.length(); a++) {
            if ((c=Codigo.charAt(a)) == '"' && Codigo.charAt(a - 1) != '\\') {
                AspasAberto = !AspasAberto;
                continue;
            } else if (Codigo.charAt(a) == '\'' && Codigo.charAt(a - 1) != '\\') {
                PlicasAberto = !PlicasAberto;
                continue;
            }
            if (PlicasAberto || AspasAberto)
                continue;
            
            if (Codigo.charAt(a) == '{') {
                TemChaveta = true;
                break;
            } else if (Codigo.charAt(a) == ';') {
                TemChaveta = false;
                break;
            }
        }
        if (TemChaveta) {
            NumParentesesAbertos = 1;
            AspasAberto = PlicasAberto = false;
            
            for (m = a + 1; m < Codigo.length(); m++) {
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
            m = a;
        }
        for (n = m + 1; n < Codigo.length(); n++) {
            if (Codigo.charAt(n) != ' ' && Codigo.charAt(n) != '\n')
                break;
        }

        try {
            Condicao = new Statement(Codigo.substring(i, j), T);
        } catch (Exception e) {
        }
        this.Codigo = Codigo.substring(0, j + 1);
        if (n+1 > Codigo.length())
            this.ParaAnalise = Codigo.substring(0, n);
        else
            this.ParaAnalise = Codigo.substring(0, n + 1);
        
        this.NumCarateresAvancar = m + 1;
        return Codigo.substring(j, m + 1);

    }

//    public If(String codigo) {
//        int contadorCarateres = 2;
//        temChaveta = true;
//        String aux = "", auxCondicao = "";
//        int numParenteses = 1;
//        EspacosIfParentesAberto = 0;
//
//        //-------EspacosParentesesAbertoCondicao----------
//        EspacosParentesesAbertoCondicao = 0;
//
//        for (int i = 2; i < codigo.length(); i++) {
//            if (codigo.charAt(i) != '(') {
//                EspacosIfParentesAberto++;
//
//            } else {
//                break;
//            }
//            contadorCarateres++;
//        }
//        aux = codigo.substring(EspacosIfParentesAberto+1);
//        //----------------------
//
//        //--EspacosParentesesAbertoCondicao-------------
//        for (int i = 0; i < aux.length(); i++) {
//            if (aux.charAt(i) == ' ') {
//                EspacosParentesesAbertoCondicao++;
//
//            } else {
//                break;
//            }
//            contadorCarateres++;
//        }
//
//        aux = aux.substring(EspacosParentesesAbertoCondicao+1);
//        //------------------------------
//
//        //--------------condicao e EspacosCondicaoParentesFechado----------------
//        int ixUltimoCarater = 0, ixUltimoParenteses = 0;
//        for (int i = 0; i < aux.length(); i++) {
//            auxCondicao += aux.charAt(i);
//            if (aux.charAt(i) == ')') {
//                numParenteses--;
//                if (numParenteses == 0) {
//                    ixUltimoParenteses = i;
//                    break;
//                }
//            } else if (aux.charAt(i) == '(') {
//                numParenteses++;
//            } else if (aux.charAt(i) != ' ') {
//                ixUltimoCarater = i;
//            }
//            contadorCarateres++;
//        }
//        EspacosCondicaoParentesFechado = (ixUltimoParenteses - 1) - ixUltimoCarater;
//        Condicao.setStatement(auxCondicao.substring(0, ixUltimoCarater));
//        //---------------------------
//        aux = aux.substring(ixUltimoParenteses);
//
//        int ixInicioIf = 0;
//        for (int i = 0; i < aux.length(); i++) {
//            if (aux.charAt(i) != ' ') {
//                temChaveta = false;
//                ixInicioIf = i;
//                break;
//            } else if (aux.charAt(i) != '{') {
//                temChaveta = true;
//                ixInicioIf = i;
//                break;
//            }
//            contadorCarateres++;
//        }
//
//        setNumComecar(ixInicioIf);
//
//        //---------contar num de linhas ate 1º carater-------------
//        LinhasEmBrancoDepoisChavetaAberta = 0;
//        
//        aux = aux.substring(ixInicioIf);
//        
//        for (int i = 0; i < aux.length(); i++) {
//            if (aux.charAt(i) != ' '){
//                aux = aux.substring(i);
//                break;
//            }
//            else if (String.valueOf(aux.charAt(i)).matches("\n")) {
//                LinhasEmBrancoDepoisChavetaAberta++;
//            }
//            contadorCarateres++;
//        }
//        //--------------------------------------------------------
//        
//        //---------encontra fim do if -------
//        int ixFimIF = 0;
//        if (temChaveta) {
//            int numChavetas = 1;
//            for (int i = 0; i < aux.length(); i++) {
//                if (numChavetas == 0) {
//                    ixFimIF = i;
//                    break;
//                } else if (aux.charAt(i) == '{') {
//                    numChavetas++;
//                } else if (aux.charAt(i) == '}') {
//                    numChavetas--;
//                }
//                contadorCarateres++;
//
//            }
//        } else {
//            //procurar o 1º ';'
//            boolean AspasAberto, PlicasAberto;
//            AspasAberto = PlicasAberto = false;
//            for (int i = 0; i < aux.length(); i++) {
//                if (aux.charAt(i) == ';' && !AspasAberto && !PlicasAberto) {
//                    ixFimIF = i;
//                } else if (aux.charAt(i) == '"' && aux.charAt(i - 1) != '\\') {
//                    AspasAberto = !AspasAberto;
//                } else if (aux.charAt(i) == '\'' && aux.charAt(i - 1) != '\\') {
//                    PlicasAberto = !PlicasAberto;
//                }
//                contadorCarateres++;
//            }
//        }
//
//        aux = aux.substring(ixFimIF);
//        //---------LinhasEmBrancoDepoisChavetaFechada -----------------
//        LinhasEmBrancoDepoisChavetaFechada = 0;
//
//        for (int i = 0; i < aux.length(); i++) {
//            if (aux.charAt(i) != ' '){
//                break;
//            }
//            else if (String.valueOf(aux.charAt(i)).matches("\n")) { // testar isto
//                LinhasEmBrancoDepoisChavetaFechada++;
//            }
//            contadorCarateres++;
//        }
//        //--------------------
//        
//        numCarateresCodigoStatment = contadorCarateres;
//    }
    public int getPrimeiraChavetaNovaLinha() {
        return PrimeiraChavetaNovaLinha;
    }

    public void setPrimeiraChavetaNovaLinha(int PosicaoPrimeiraChaveta) {
        this.ChavetaUmStatementIf = PosicaoPrimeiraChaveta;
    }

    public int isChavetaUmStatementDentroIf() {
        return ChavetaUmStatementIf;
    }

    public void setChavetaUmStatementDentroIf(int ChavetaUmStatementDentroIf) {
        this.PrimeiraChavetaNovaLinha = ChavetaUmStatementDentroIf;
    }

    public int getEspacosIfParentesAberto() {
        return EspacosIfParentesAberto;
    }

    public void setEspacosIfParentesAberto(int EspacosIfParentesAberto) {
        this.EspacosIfParentesAberto = EspacosIfParentesAberto;
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
    
    private boolean isIf(char A[])
    {
        if (A[0] == 'i' && A[1] == 'f' && (A[2]=='(' || Character.isWhitespace(A[2]))) 
            return true;
        return false;
    }

    @Override
    public void analisaStatement() {
        EspacosParentesesAbertoCondicao=0;
        EspacosIfParentesAberto=0;
        EspacosCondicaoParentesFechado=0;
        PrimeiraChavetaNovaLinha=-1;
        ChavetaUmStatementIf=-1;
        LinhasEmBrancoDepoisChavetaAberta=-1;
        LinhasEmBrancoDepoisChavetaFechada=-1;
        int contParenteses=0, indexParenteses=-1,i, aux,a, contPontoVirgula=0;
        char c;
        
        for(i=0;i<ParaAnalise.length();i++)
        { 
            try
            {
                if(isIf(new char[]{ParaAnalise.charAt(i),ParaAnalise.charAt(i+1),ParaAnalise.charAt(i+2)}))
                {
                    i+=2;
                }
                else
                    continue;
            }
            catch(Exception e){}
            for(;i<ParaAnalise.length();i++)
            {
                if(ParaAnalise.charAt(i)!='(')
                    EspacosIfParentesAberto++;
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
                ChavetaUmStatementIf=1;
            else
            {
                ChavetaUmStatementIf=0;
                PrimeiraChavetaNovaLinha=-1;
            }
        }        
        boolean primeiro=true;

        if(ChavetaUmStatementIf!=0)
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
    }

     @Override
    public void converteStatement(EstiloProgramacao estilo) {
        String aux= this.Codigo;
        StringBuilder build = new StringBuilder(aux); 
        char espacos[] = { ' ', ' ', ' ', ' ', ' ', ' ', ' ' };
        char linhas[] = { '\n', '\n', '\n', '\n', '\n', '\n', '\n' };
        int conta=0;
       
            for (int i = 0; i < aux.length(); i++) {
                if(aux.charAt(i)=='(')
                {
                   build.insert(i, espacos, 0, estilo.getIfs().getEspacosIfParentesAberto());
                   build.insert(i+1+estilo.getIfs().getEspacosIfParentesAberto(), espacos, 0, estilo.getIfs().getEspacosParentesesAbertoCondicao());
                }
                if(aux.charAt(i)==')')
                {
                   conta+=estilo.getIfs().getEspacosIfParentesAberto()+estilo.getIfs().getEspacosParentesesAbertoCondicao();
                   
                   build.insert(i+conta, espacos, 0, estilo.getIfs().getEspacosCondicaoParentesFechado());
                }
                if(aux.charAt(i)=='{')
                {
                    conta+=estilo.getIfs().getEspacosCondicaoParentesFechado();
                    
                   build.insert(i+1+conta, linhas, 0, estilo.getIfs().getLinhasEmBrancoDepoisChavetaAberta());
                }
                 if(aux.charAt(i)=='}')
                {
                    conta+=estilo.getIfs().getLinhasEmBrancoDepoisChavetaAberta();
                    
                   build.insert(i+conta, linhas, 0, estilo.getIfs().getLinhasEmBrancoDepoisChavetaFechada());
                }
               
        }
        this.Codigo=build.toString();
    }
}
