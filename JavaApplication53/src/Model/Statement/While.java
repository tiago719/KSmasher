package Model.Statement;

import Model.EstiloProgramacao.EstiloProgramacao;
import Model.EstiloProgramacao.For_EP;
import Model.EstiloProgramacao.If_EP;
import Model.EstiloProgramacao.While_EP;
import Model.Texto;
import java.util.ArrayList;

public class While extends Statement {

    private int LinhasEmBrancoDepoisChavetaAberta, LinhasEmBrancoDepoisChavetaFechada,
            EspacosWhileParentesAberto, EspacosParentesesAbertoCondicao, EspacosCondicaoParentesFechado,
            ChavetaUmStatementDentroWhile, PrimeiraChavetaNovaLinha;

    private Statement Condicao;
    private boolean TemChaveta;

    public While(String codigo, Texto T, Statement Pai) {
        super(codigo, T, Pai);
    }

    @Override
    public String RetiraDados(String Codigo, Texto T) {
        int i, j, k, m, n;

        //retira espacos entre while e (
        for (i = 5; i < Codigo.length(); i++) {
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
            if (!Character.isWhitespace(Codigo.charAt(k))) {
                break;
            }

        }

        int a;
        AspasAberto = PlicasAberto = false;
        //procurar {
        for (a = j + 1; a < Codigo.length(); a++) {
            if (Codigo.charAt(a) == '"' && Codigo.charAt(a - 1) != '\\') {
                AspasAberto = !AspasAberto;
                continue;
            } else if (Codigo.charAt(a) == '\'' && Codigo.charAt(a - 1) != '\\') {
                PlicasAberto = !PlicasAberto;
                continue;
            }
            if (PlicasAberto || AspasAberto) {
                continue;
            }

            if (Codigo.charAt(a) == '{') {
                TemChaveta = true;
                break;
            } else if (Codigo.charAt(a) == ';') {
                TemChaveta = false;
                break;
            }
        }
        a = k;
        boolean ultimo = false;
        boolean comentAberto = false;
        for (++a; a < Codigo.length(); a++) {
            try {
                if (Codigo.charAt(a) == '/' && Codigo.charAt(a + 1) == '/') {
                    comentAberto = true;
                }
            } catch (Exception e) {
            }
            if (Codigo.charAt(a) == '\t' || Codigo.charAt(a) == ' ') {
                ultimo = false;
                continue;
            } else if (Codigo.charAt(a) == '{') {
                ultimo = true;
                continue;
            }
            if (Codigo.charAt(a) == '\n') {
                comentAberto = false;
            } else if (Codigo.charAt(a) != '\n' && Codigo.charAt(a) != '\r' && !comentAberto) {
                ultimo = true;
                break;
            }
        }
        if (ultimo) {
            for (--a; a > 0; a--) {
                if (Codigo.charAt(a) != '\t' && Codigo.charAt(a) != ' ') {
                    break;
                }
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
                } else if (Codigo.charAt(m) == '}') {
                    if (--NumParentesesAbertos == 0) {
                        break;
                    }
                }
            }
        } else {
            m = a;
        }

        for (n = m + 1; n < Codigo.length(); n++) {
            if (!Character.isWhitespace(Codigo.charAt(n))) {
                break;
            }
        }
        int r = n;

        if (TemChaveta) {
            boolean primeiro = true;
            for (--r; r > 0; r--) {
                if (Codigo.charAt(r) == '\t' || Codigo.charAt(r) == ' ') {
                    continue;
                } else if (Codigo.charAt(r) == '}' && primeiro) {
                    primeiro = false;
                    continue;
                } else if (Codigo.charAt(r) != '\n' && Codigo.charAt(r) != '\r') {
                    break;
                }
            }
        }
        else{
            for (;  r < Codigo.length(); r++) {
                if (Codigo.charAt(r) == ';')
                    break;
            }
        }
        this.NumCarateresAvancar = m + 2;

        try {
            Condicao = new Statement(Codigo.substring(i, j), T, this);
        } catch (Exception e) {
        }

        if (j + 1 > Codigo.length()) {
            this.Codigo = Codigo.substring(0, 1 + j - (j - Codigo.length()));
        } else {
            this.Codigo = Codigo.substring(0, j + 1);
        }

        if (n + 1 > Codigo.length()) {
            this.ParaAnalise = Codigo.substring(0, n - (n - Codigo.length()));
        } else {
            this.ParaAnalise = Codigo.substring(0, n + 1);
        }

        if (r + 1 > Codigo.length()) {
            return Codigo.substring(a + 1, r - (r - Codigo.length()));
        } else {

            return Codigo.substring(a + 1, r + 1);
        }

    }

    public int isPrimeiraChavetaNovaLinha() {
        return PrimeiraChavetaNovaLinha;
    }

    public void setPosicaoPrimeiraChaveta(int PosicaoPrimeiraChaveta) {
        this.PrimeiraChavetaNovaLinha = PosicaoPrimeiraChaveta;
    }

    public int isChavetaUmStatementDentroWhile() {
        return ChavetaUmStatementDentroWhile;
    }

    public void setChavetaUmStatementDentroWhile(int ChavetaUmStatementDentroWhile) {
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

    private boolean isWhile(char A[]) {
        if (A[0] == 'w' && A[1] == 'h' && A[2] == 'i' && A[3] == 'l' && A[4] == 'e' && (A[5] == '(' || Character.isWhitespace(A[5]))) {
            return true;
        }
        return false;
    }

    @Override
    public void analisaStatement() {
        EspacosParentesesAbertoCondicao = 0;
        EspacosWhileParentesAberto = 0;
        EspacosCondicaoParentesFechado = 0;
        PrimeiraChavetaNovaLinha = -1;
        ChavetaUmStatementDentroWhile = -1;
        LinhasEmBrancoDepoisChavetaAberta = -1;
        LinhasEmBrancoDepoisChavetaFechada = -1;
        int contParenteses = 0, indexParenteses = -1, i, aux, a, contPontoVirgula = 0;

        for (i = 0; i < ParaAnalise.length(); i++) {
            try {
                if (isWhile(new char[]{ParaAnalise.charAt(i), ParaAnalise.charAt(i + 1), ParaAnalise.charAt(i + 2), ParaAnalise.charAt(i + 3), ParaAnalise.charAt(i + 4), ParaAnalise.charAt(i + 5)})) {
                    i += 5;
                } else {
                    continue;
                }
            } catch (Exception e) {
            }
            for (; i < ParaAnalise.length(); i++) {
                if (ParaAnalise.charAt(i) != '(') {
                    EspacosWhileParentesAberto++;
                } else {
                    break;
                }
            }

            for (++i; i < ParaAnalise.length(); i++) {
                if (ParaAnalise.charAt(i) == ' ') {
                    EspacosParentesesAbertoCondicao++;
                } else {
                    break;
                }
            }
            while (++i < ParaAnalise.length()) {
                if (ParaAnalise.charAt(i) == ')') {
                    if (contParenteses == 0) {
                        indexParenteses = i;
                        break;
                    } else {
                        contParenteses--;
                    }
                }
                if (ParaAnalise.charAt(i) == '(') {
                    contParenteses++;
                }
            }
            for (indexParenteses--; indexParenteses > 0; indexParenteses--) {
                if (ParaAnalise.charAt(indexParenteses) == ' ') {
                    EspacosCondicaoParentesFechado++;
                } else {
                    break;
                }
            }
            break;
        }

        aux = i;
        boolean temChaveta = false;
        char c;

        for (a = aux + 1; a < ParaAnalise.length(); a++) {
            if ((c = ParaAnalise.charAt(a)) == '{') {
                temChaveta = true;
                break;
            } else if (!Character.isWhitespace(ParaAnalise.charAt(a))) {
                break;
            }
        }

        contPontoVirgula = 0;

        for (++a; a < ParaAnalise.length(); a++) {
            if (ParaAnalise.charAt(a) == ';') {
                if (++contPontoVirgula >= 2) {
                    ChavetaUmStatementDentroWhile = -1;
                    break;
                }
            }
        }

        if (temChaveta) {
            for (++i; i < ParaAnalise.length(); i++) {
                if (!Character.isWhitespace(ParaAnalise.charAt(i))) {
                    break;
                }
            }
            if (ParaAnalise.charAt(i) == '{' && contPontoVirgula < 2) {
                ChavetaUmStatementDentroWhile = 1;
            } else if (contPontoVirgula < 2) {
                ChavetaUmStatementDentroWhile = 0;
                PrimeiraChavetaNovaLinha = -1;
            } else {
                PrimeiraChavetaNovaLinha = -1;
            }

        } else {
            ChavetaUmStatementDentroWhile = 0;
        }
        boolean primeiro = true;

        if (ChavetaUmStatementDentroWhile == 1 || ChavetaUmStatementDentroWhile == -1) {
            PrimeiraChavetaNovaLinha = 0;
            LinhasEmBrancoDepoisChavetaAberta = 0;
            LinhasEmBrancoDepoisChavetaFechada = 0;
            for (i = indexParenteses + 1; i < ParaAnalise.length(); i++) {
                if (ParaAnalise.charAt(i) == '\n') {
                    PrimeiraChavetaNovaLinha = 1;
                }
                if (ParaAnalise.charAt(i) == '{') {
                    for (i += 1; i < ParaAnalise.length(); i++) {
                        if (ParaAnalise.charAt(i) == '\n') {
                            if (primeiro) {
                                primeiro = false;
                            } else {
                                LinhasEmBrancoDepoisChavetaAberta++;
                            }
                        } else if (Character.isWhitespace(ParaAnalise.charAt(i))) {
                            continue;
                        } else {
                            break;
                        }
                    }
                    break;
                }
            }
            aux = 0;
            for (i += 1; i < ParaAnalise.length(); i++) {
                if (ParaAnalise.charAt(i) == '{') {
                    aux++;
                }
                if (ParaAnalise.charAt(i) == '}') {
                    if (aux <= 0) {
                        break;
                    } else {
                        aux--;
                    }
                }
            }
            primeiro = true;
            for (i++; i < ParaAnalise.length(); i++) {
                if (ParaAnalise.charAt(i) == '\n') {
                    if (primeiro) {
                        primeiro = false;
                    } else {
                        LinhasEmBrancoDepoisChavetaFechada++;
                    }
                } else if (Character.isWhitespace(ParaAnalise.charAt(i))) {
                    continue;
                } else {
                    break;
                }
            }
        }
    }

    @Override
    public void converteStatement(EstiloProgramacao estilo) {
        if (estilo.getWhiles() == null) {
            return;
        }

        String Aux = "";
        Statement Last = null;
        Statement ultimoFilho = getLastSon();

        if (Pai != null) {
            for (Statement s : Pai.getStatementsFilhos()) {
                if (s == this) {
                    break;
                }
                Last = s;
            }

            if (Last != null) {
                int i = 1;
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
        for (int i = 0; i < getNivel(); i++) {
            Aux += "\t";
        }
        Aux += "while";
        While_EP ep = estilo.getWhiles();
        for (int i = 0; i < ep.getEspacosWhileParentesAberto(); i++) {
            Aux += " ";
        }
        Aux += "(";

        for (int i = 0; i < ep.getEspacosParentesesAbertoCondicao(); i++) {
            Aux += " ";
        }

        if (Condicao.hasFilhos()) {
            for (Statement S : Condicao.getStatementsFilhos()) {
                S.converteStatement(estilo);
            }
            for (Statement S : Condicao.getStatementsFilhos()) {
                Aux += S.getCodigo();
            }
        } else {
            Aux += Condicao.getCodigo();
        }
        for (int i = 0; i < ep.getEspacosCondicaoParentesFechado(); i++) {
            Aux += " ";
        }
        Aux += ")";

        if (Texto.precisaChavetaP(StatmentsFilhos) || ep.isChavetaUmStatementDentroWhile()) {
            if (ep.isPosicaoPrimeiraChaveta()) {
                Aux += "\n";
                for (int i = 0; i < getNivel(); i++) {
                    Aux += "\t";
                }
                Aux += "{";
            } else {
                Aux += "{";
            }

            for (int a = 0; a < ep.getLinhasEmBrancoDepoisChavetaAberta() + 1; a++) {
                Aux += "\n";
            }
            ultimoFilho.Codigo += "\n";
            for (int a = 0; a < getNivel(); a++) {
                ultimoFilho.Codigo += "\t";
            }
            ultimoFilho.Codigo += "}";
            for (int a = 0; a < ep.getLinhasEmBrancoDepoisChavetaFechada(); a++) {
                ultimoFilho.Codigo += "\n";
            }
        } else {
            Aux += "\n";
        }
        this.Codigo = Aux;
    }
}
