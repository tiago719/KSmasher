package Model.Statement;

import Model.EstiloProgramacao.EstiloProgramacao;
import Model.EstiloProgramacao.For_EP;
import Model.EstiloProgramacao.If_EP;
import Model.Texto;
import java.util.ArrayList;

public class For extends Statement {

    private boolean PosicaoPrimeiraChaveta, ChavetaUmStatementDentroFor;
    private int EspacosForParentesAberto, EspacosParentesesAbertoCondicaoInicializacao,
            EspacosInicializacaoPontoVirgula, EspacosPontoVirgulaCondicao, EspacosCondicaoPontoVirgula,
            EspacosPontoVirgulaIncrementacao, EspacosIncrementacaoParentesesFechado,
            LinhasEmBrancoDepoisChavetaAberta, LinhasEmBrancoDepoisChavetaFechada;

    private Statement PInicializacao, Condicao, Incrementacao;
    private boolean temChaveta;

    public For(String codigo, Texto t, Statement Pai) {
        super(codigo, t, Pai);

    }

    public boolean isPosicaoPrimeiraChaveta() {
        return PosicaoPrimeiraChaveta;
    }

    public void setPosicaoPrimeiraChaveta(boolean PosicaoPrimeiraChaveta) {
        this.PosicaoPrimeiraChaveta = PosicaoPrimeiraChaveta;
    }

    public boolean isChavetaUmStatementDentroFor() {
        return ChavetaUmStatementDentroFor;
    }

    public void setChavetaUmStatementDentroFor(boolean ChavetaUmStatementDentroFor) {
        this.ChavetaUmStatementDentroFor = ChavetaUmStatementDentroFor;
    }

    public int getEspacosForParentesAberto() {
        return EspacosForParentesAberto;
    }

    public void setEspacosForParentesAberto(int EspacosForParentesAberto) {
        this.EspacosForParentesAberto = EspacosForParentesAberto;
    }

    public int getEspacosParentesesAbertoCondicaoInicializacao() {
        return EspacosParentesesAbertoCondicaoInicializacao;
    }

    public void setEspacosParentesesAbertoCondicaoInicializacao(int EspacosParentesesAbertoCondicaoInicializacao) {
        this.EspacosParentesesAbertoCondicaoInicializacao = EspacosParentesesAbertoCondicaoInicializacao;
    }

    public int getEspacosInicializacaoPontoVirgula() {
        return EspacosInicializacaoPontoVirgula;
    }

    public void setEspacosInicializacaoPontoVirgula(int EspacosInicializacaoPontoVirgula) {
        this.EspacosInicializacaoPontoVirgula = EspacosInicializacaoPontoVirgula;
    }

    public int getEspacosPontoVirgulaCondicao() {
        return EspacosPontoVirgulaCondicao;
    }

    public void setEspacosPontoVirgulaCondicao(int EspacosPontoVirgulaCondicao) {
        this.EspacosPontoVirgulaCondicao = EspacosPontoVirgulaCondicao;
    }

    public int getEspacosCondicaoPontoVirgula() {
        return EspacosCondicaoPontoVirgula;
    }

    public void setEspacosCondicaoPontoVirgula(int EspacosCondicaoPontoVirgula) {
        this.EspacosCondicaoPontoVirgula = EspacosCondicaoPontoVirgula;
    }

    public int getEspacosPontoVirgulaIncrementacao() {
        return EspacosPontoVirgulaIncrementacao;
    }

    public void setEspacosPontoVirgulaIncrementacao(int EspacosPontoVirgulaIncrementacao) {
        this.EspacosPontoVirgulaIncrementacao = EspacosPontoVirgulaIncrementacao;
    }

    public int getEspacosIncrementacaoParentesesFechado() {
        return EspacosIncrementacaoParentesesFechado;
    }

    public void setEspacosIncrementacaoParentesesFechado(int EspacosIncrementacaoParentesesFechado) {
        this.EspacosIncrementacaoParentesesFechado = EspacosIncrementacaoParentesesFechado;
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
    public void analisaStatement() {

        String aux = ParaAnalise;
        EspacosForParentesAberto = 0;
        EspacosParentesesAbertoCondicaoInicializacao = 0;

        int i = 3;
        int Conta = 0;
        //CONTA OS ESPAÇOS ATÉ AO PRIMEIRO (
        for (; i < aux.length(); i++) {
            if (aux.charAt(i) != '(') {
                EspacosForParentesAberto++;

            } else {
                break;
            }
        }
        i++;
        ///--------------------------

        if (!PInicializacao.getCodigo().trim().equals("")) {

            // CONTA ESPAÇOS DO ( do FOR até Á Inicializacao
            for (; i < aux.length(); i++) {
                if (aux.charAt(i) == ' ' && Codigo.charAt(i) != '\n') {
                    EspacosParentesesAbertoCondicaoInicializacao++;

                } else {
                    break;
                }
            }
            aux = aux.substring(i + 1);
            i = 0;

            /// ESPAÇOS ENTRE A INICIALIZAÇÃO E O ;
            Conta = 0;

            for (i = 0; i < aux.length(); i++) {
                if (aux.charAt(Conta) != ';') {
                    Conta++;
                } else {
                    break;
                }
            }
            EspacosInicializacaoPontoVirgula = 0;
            for (i = Conta - 1; i >= 0; i--) {
                if (aux.charAt(i) != ' ' && Codigo.charAt(i) != '\n') {
                    break;
                }
                EspacosInicializacaoPontoVirgula++;
            }
            aux = aux.substring(Conta + 1);

        } else {
            EspacosParentesesAbertoCondicaoInicializacao = -1;
            EspacosInicializacaoPontoVirgula = -1;
            for (; i < aux.length(); i++) {
                if (aux.charAt(i) != ' ' && aux.charAt(i) != '\n') {
                    break;
                }
            }
            i++;
        }

        if (!Condicao.getCodigo().trim().equals("")) {
            //ESPAÇOS ENTRE ; E CONDIÇAO
            EspacosPontoVirgulaCondicao = 0;
            for (i = 0; i < aux.length(); i++) {
                if (aux.charAt(i) != ' ' && Codigo.charAt(i) != '\n') {
                    break;
                }
                EspacosPontoVirgulaCondicao++;
            }
            aux = aux.substring(EspacosPontoVirgulaCondicao);

            //ESPAÇOS ENTRE CONDIÇAO ;
            Conta = 0;

            for (i = 0; i < aux.length(); i++) {
                if (aux.charAt(i) == ';') {
                    break;
                }
                Conta++;
            }
            EspacosCondicaoPontoVirgula = 0;

            for (i = Conta - 1; i >= 0; i--) {
                if (aux.charAt(i) != ' ' && Codigo.charAt(i) != '\n') {
                    break;
                }
                EspacosCondicaoPontoVirgula++;
            }
            aux = aux.substring(Conta + 1);
        } else {
            i++;
            EspacosPontoVirgulaCondicao = -1;
            EspacosCondicaoPontoVirgula = -1;
            for (; i < aux.length(); i++) {
                if (aux.charAt(i) != ' ' && aux.charAt(i) != '\n') {
                    break;
                }
            }
            i++;
        }

        if (!Incrementacao.getCodigo().trim().equals("")) {
            // ESPAÇOS ; INCREMENTACAO
            EspacosPontoVirgulaIncrementacao = 0;
            for (i = 0; i < aux.length(); i++) {
                if (aux.charAt(i) != ' ' && Codigo.charAt(i) != '\n') {
                    break;
                }
                EspacosPontoVirgulaIncrementacao++;
            }
            aux = aux.substring(EspacosPontoVirgulaIncrementacao);

            // ESPAÇOS INCREMENTACAO )      
            Conta = 0;
            int nabertos = 0;
            for (i = 0; i < aux.length(); i++) {
                if (aux.charAt(Conta) == '(') {
                    nabertos++;
                }

                if (aux.charAt(Conta) == ')') {
                    if (nabertos != 0) {
                        nabertos--;
                    } else {
                        break;
                    }
                }

                Conta++;
            }
            EspacosIncrementacaoParentesesFechado = 0;

            for (i = Conta - 1; i >= 0; i--) {
                if (aux.charAt(i) != ' ' && Codigo.charAt(i) != '\n') {
                    break;
                }
                EspacosIncrementacaoParentesesFechado++;
            }

            aux = aux.substring(Conta + 1);
        } else {
            EspacosIncrementacaoParentesesFechado = -1;
            EspacosPontoVirgulaIncrementacao = -1;
            for (; i < aux.length(); i++) {
                if (!Character.isWhitespace(aux.charAt(i))) {
                    break;
                }
            }
            aux = aux.substring(i);
        }

        int temchaveta = 0;
        for (i = 0; i < aux.length(); i++) {
            if (aux.charAt(i) != ' ') {
                if (aux.charAt(i) == '{') {
                    temchaveta = 1;
                    break;
                } else {
                    temchaveta = 0;
                    ChavetaUmStatementDentroFor = false;
                    LinhasEmBrancoDepoisChavetaAberta = -1;
                    LinhasEmBrancoDepoisChavetaFechada = -1;
                    break;
                }

            }
        }
        int contPontoVirgula = 0;
        for (; i < aux.length(); i++) {
            if (aux.charAt(i) == ';') {
                if (++contPontoVirgula >= 2) {
                    break;
                }
            }
        }

        if (temchaveta == 1) {         //ESPAÇOS EM BRANCO DEPOIS DA {

            if (contPontoVirgula >= 2) {
                ChavetaUmStatementDentroFor = false;
            } else {
                ChavetaUmStatementDentroFor = true;
            }
            Conta = 0;
            aux = ParaAnalise;

            Conta = 0;
            for (i = 0; i < aux.length(); i++) {
                if (aux.charAt(Conta) != '{') {
                    Conta++;
                } else {
                    for (int x = Conta; x > 0; x--) {
                        if (aux.charAt(x) == ')') {
                            break;
                        } else {
                            if (aux.charAt(x) == '\n') {
                                PosicaoPrimeiraChaveta = false;
                            }
                        }
                    }
                    break;
                }
            }
            aux = aux.substring(Conta + 1);

            LinhasEmBrancoDepoisChavetaAberta = -1;
            for (i = 0; i < aux.length(); i++) {
                if (!Character.isWhitespace(aux.charAt(i))) {
                    break;
                } else {
                    if (aux.charAt(i) == '\n') {
                        LinhasEmBrancoDepoisChavetaAberta++;
                    }
                }

            }

            //ESPAÇOS EM BRANCO DEPOIS DA CHAVETA FECHADA
            Conta = 0;
            int nChaveta = 0;
            for (i = 0; i < aux.length(); i++) {
                if (aux.charAt(i) == '{') {
                    nChaveta++;
                } else {
                    if (aux.charAt(i) == '}') {
                        if (nChaveta == 0) {
                            break;
                        } else {
                            nChaveta--;
                        }
                    }

                }
            }
            if (i + 1 <= aux.length()) {
                aux = aux.substring(i + 1);
            } else {
                aux = aux.substring(i);
            }

            LinhasEmBrancoDepoisChavetaFechada = -1;
            for (i = 0; i < aux.length(); i++) {
                if (!Character.isWhitespace(aux.charAt(i))) {
                    break;
                } else {
                    if (aux.charAt(i) == '\n') {
                        LinhasEmBrancoDepoisChavetaFechada++;
                    }
                }

            }
        } else {
            ChavetaUmStatementDentroFor = false;
        }
    }

    @Override
    public String RetiraDados(String Codigo, Texto t) {
        int i, j;
        boolean AspasAberto = false, PlicasAberto = false;

        //retira espacos entre if e (
        for (i = 3; i < Codigo.length(); i++) {
            if (Codigo.charAt(i) != ' ' && Codigo.charAt(i) != '\n') {
                break;
            }
        }

        i++;//fica depois do (

        //retira espacos ate inicializacao
        for (; i < Codigo.length(); i++) {
            if (Codigo.charAt(i) != ' ' && Codigo.charAt(i) != '\n') {
                break;
            }
        }

        for (j = i; j < Codigo.length(); j++) {
            if (Codigo.charAt(j) == '"' && Codigo.charAt(j - 1) != '\\') {
                AspasAberto = !AspasAberto;
            }
            if (Codigo.charAt(j) == '\'' && Codigo.charAt(j - 1) != '\\') {
                PlicasAberto = !PlicasAberto;
            }

            if (!AspasAberto && !PlicasAberto) {
                if (Codigo.charAt(j) == ';') {
                    break;
                }
            }
        }

        PInicializacao = new Statement(Codigo.substring(i, j), t, this);

        //retirar espacos entre Inicializacao; ate condicao
        for (i = j; i < Codigo.length(); i++) {
            if (Codigo.charAt(i) != ' ' && Codigo.charAt(i) != '\n') {
                break;
            }
        }

        //encontrar fim de condicao
        for (j = ++i; j < Codigo.length(); j++) {
            if (Codigo.charAt(j) == '"' && Codigo.charAt(j - 1) != '\\') {
                AspasAberto = !AspasAberto;
            }
            if (Codigo.charAt(j) == '\'' && Codigo.charAt(j - 1) != '\\') {
                PlicasAberto = !PlicasAberto;
            }

            if (!AspasAberto && !PlicasAberto) {
                if (Codigo.charAt(j) == ';') {
                    break;
                }
            }
        }

        Condicao = new Statement(Codigo.substring(i, j), t, this);

        //retirar espacos entre Condicao; ate incrementacao
        for (i = j; i < Codigo.length(); i++) {
            if (!Character.isWhitespace(Codigo.charAt(i))) {
                break;
            }
        }

        //encontrar fim de incrementacao
        int NumParentesesAbertos = 1;
        for (j = ++i; j < Codigo.length(); j++) {
            if (Codigo.charAt(j) == '"' && Codigo.charAt(j - 1) != '\\') {
                AspasAberto = !AspasAberto;
                continue;
            }
            if (Codigo.charAt(j) == '\'' && Codigo.charAt(j - 1) != '\\') {
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
        Incrementacao = new Statement(Codigo.substring(i, j + 1), t, this);

        int a, m, n;

        //procurar {
        for (a = j + 1; a < Codigo.length(); a++) {
            if (Codigo.charAt(a) == '"' && Codigo.charAt(a - 1) != '\\') {
                AspasAberto = !AspasAberto;
                continue;
            } else if (Codigo.charAt(a) == '\'' && Codigo.charAt(a - 1) != '\\') {
                PlicasAberto = !PlicasAberto;
                continue;
            }
            if (Codigo.charAt(a) == '{') {
                temChaveta = true;
                break;
            } else if (Codigo.charAt(a) == ';') {
                temChaveta = false;
                break;
            }
        }

        a = j;
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
            }
            if (Codigo.charAt(a) != '\n' && Codigo.charAt(a) != '\r' && !comentAberto) {
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
        if (temChaveta) {
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

        this.Codigo = Codigo.substring(0, a);
        if (n + 1 > Codigo.length()) {
            this.ParaAnalise = Codigo.substring(0, n - (n - Codigo.length()));
        } else {
            this.ParaAnalise = Codigo.substring(0, n + 1);
        }

        this.NumCarateresAvancar = m + 2;

        if (r + 1 > Codigo.length()) {
            return Codigo.substring(a - 1, r - (r - Codigo.length()));
        } else {
            return Codigo.substring(a - 1, r + 1);
        }
    }

    @Override
    public void converteStatement(EstiloProgramacao estilo) {

        if (estilo.getFors() == null) {
            return;
        }

        Statement ultimoFilho = getLastSon();
        Statement Last = null;
        For_EP ep = estilo.getFors();

        String Aux = "";
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

        Aux += "for";

        for (int i = 0; i < ep.getEspacosForParentesAberto(); i++) {
            Aux += " ";
        }
        Aux += "(";

        for (int i = 0; i < ep.getEspacosParentesesAbertoCondicaoInicializacao(); i++) {
            Aux += " ";
        }

        if (PInicializacao.hasFilhos()) {
            for (Statement S : PInicializacao.getStatementsFilhos()) {
                S.converteStatement(estilo);
            }
            for (Statement S : PInicializacao.getStatementsFilhos()) {
                Aux += S.getCodigo();
            }
        } else {
            Aux += PInicializacao.getCodigo();
        }

        for (int i = 0; i < ep.getEspacosInicializacaoPontoVirgula(); i++) {
            Aux += " ";
        }
        Aux += ";";

        for (int i = 0; i < ep.getEspacosPontoVirgulaCondicao(); i++) {
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

        for (int i = 0; i < ep.getEspacosCondicaoPontoVirgula(); i++) {
            Aux += " ";
        }
        Aux += ";";

        for (int i = 0; i < ep.getEspacosPontoVirgulaIncrementacao(); i++) {
            Aux += " ";
        }
        if (Incrementacao.hasFilhos()) {
            for (Statement S : Incrementacao.getStatementsFilhos()) {
                S.converteStatement(estilo);
            }
            for (Statement S : Incrementacao.getStatementsFilhos()) {
                Aux += S.getCodigo();
            }
        } else {
            Aux += Incrementacao.getCodigo();
        }
        boolean precisaChaveta = Texto.precisaChavetaP(StatmentsFilhos) || ep.isChavetaUmStatementDentroFor();
        if (precisaChaveta) {
            if (ep.isPosicaoPrimeiraChaveta()) {
                Aux += "\n";
                for (int i = 0; i < getNivel(); i++) {
                    Aux += "\t";
                }
                Aux += "{";
            } else {
                Aux += "{";
            }

            for (int a = 0; a < ep.getLinhasEmBrancoDepoisChavetaAberta(); a++) {
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
        }

        this.Codigo = Aux;
    }
}
