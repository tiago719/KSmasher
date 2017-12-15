package Model.Statement;

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

    public For(String codigo, Texto t) {
        super(codigo, t);

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
        //CONTA OS ESPAÇOS ATÉ AO PRIMEIRO (
        for (int i = 3; i < aux.length(); i++) {
            if (aux.charAt(i) != '(') {
                EspacosForParentesAberto++;

            } else {
                break;
            }
        }
        aux = aux.substring(EspacosForParentesAberto);
        ///--------------------------

        // CONTA ESPAÇOS DO ( do FOR até Á Inicializacao
        for (int i = 0; i < aux.length(); i++) {
            if (aux.charAt(i) == ' ' && Codigo.charAt(i) != '\n') {
                EspacosParentesesAbertoCondicaoInicializacao++;

            } else {
                break;
            }
        }

        aux = aux.substring(EspacosParentesesAbertoCondicaoInicializacao);

        /// ESPAÇOS ENTRE A INICIALIZAÇÃO E O ;
        int Conta = 0;

        while (aux.charAt(Conta) != ';') {
            Conta++;
        }

        EspacosInicializacaoPontoVirgula = 0;
        for (int i = Conta - 1; i >= 0; i--) {
            if (aux.charAt(i) != ' ' && Codigo.charAt(i) != '\n') {
                break;
            }
            EspacosInicializacaoPontoVirgula++;
        }
        aux = aux.substring(Conta);

        //ESPAÇOS ENTRE ; E CONDIÇAO
        EspacosPontoVirgulaCondicao = 0;
        for (int i = 0; i > aux.length(); i++) {
            if (aux.charAt(i) != ' ' && Codigo.charAt(i) != '\n') {
                break;
            }
            EspacosPontoVirgulaCondicao++;
        }
        aux = aux.substring(EspacosPontoVirgulaCondicao);

        //ESPAÇOS ENTRE CONDIÇAO ;
        Conta = 0;

        while (aux.charAt(Conta) != ';') {
            Conta++;
        }
        EspacosCondicaoPontoVirgula = 0;

        for (int i = Conta - 1; i >= 0; i--) {
            if (aux.charAt(i) != ' ' && Codigo.charAt(i) != '\n') {
                break;
            }
            EspacosCondicaoPontoVirgula++;
        }
        aux = aux.substring(Conta);

        // ESPAÇOS ; INCREMENTACAO
        EspacosPontoVirgulaIncrementacao = 0;
        for (int i = 0; i > aux.length(); i++) {
            if (aux.charAt(i) != ' ' && Codigo.charAt(i) != '\n') {
                break;
            }
            EspacosPontoVirgulaIncrementacao++;
        }
        aux = aux.substring(EspacosPontoVirgulaIncrementacao);

        // ESPAÇOS INCREMENTACAO )      
        Conta = 0;
        int nabertos = 0;
        while (true) {
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

        for (int i = Conta - 1; i >= 0; i--) {
            if (aux.charAt(i) != ' ' && Codigo.charAt(i) != '\n') {
                break;
            }
            EspacosIncrementacaoParentesesFechado++;
        }
        aux = aux.substring(Conta);

        //ESPAÇOS EM BRANCO DEPOIS DA CHAVETA ABERTA;
        Conta = 0;

        while (aux.charAt(Conta) != '{') {
            Conta++;
        }
        LinhasEmBrancoDepoisChavetaAberta = 0;
        for (int i = Conta - 1; i >= 0; i--) {
            if (aux.charAt(i) != ' ' && Codigo.charAt(i) != '\n') {
                break;
            }
            LinhasEmBrancoDepoisChavetaAberta++;
        }
        aux = aux.substring(Conta);

        //ESPAÇOS EM BRANCO DEPOIS DA CHAVETA FECHADA
        while (true) {
            if (aux.charAt(Conta) == '{') {
                nabertos++;
            }

            if (aux.charAt(Conta) == '}') {
                if (nabertos != 0) {
                    nabertos--;
                } else {
                    break;
                }
            }

            Conta++;
        }

        for (int i = Conta - 1; i >= 0; i--) {
            if (aux.charAt(i) != ' ' && Codigo.charAt(i) != '\n') {
                break;
            }
            LinhasEmBrancoDepoisChavetaFechada++;
        }
    }

    @Override
    public void converteStatement() {

    }

    @Override
    public String RetiraDados(String Codigo, Texto t) {
        int i, j;
        boolean AspasAberto = false, PlicasAberto = false;

        //retira espacos entre if e (
        for (i = 3; i < Codigo.length(); i++) {
            char qqqq = Codigo.charAt(i);
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

        PInicializacao = new Statement(Codigo.substring(i, j + 1), t);

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

        Condicao = new Statement(Codigo.substring(i, j + 1), t);

        //retirar espacos entre Condicao; ate incrementacao
        for (i = j; i < Codigo.length(); i++) {
            if (Codigo.charAt(i) != ' ' && Codigo.charAt(i) != '\n') {
                break;
            }
        }

        //encontrar fim de incrementacao
        int NumParentesesAbertos = 1;
        for (j = ++i; j < Codigo.length(); j++) {
            char qqq = Codigo.charAt(j);
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
        Incrementacao = new Statement(Codigo.substring(i, j), t);

        int l, k, m, n;

        //procurar {
        for (l = j + 1; l < Codigo.length(); l++) {
            char qqq = Codigo.charAt(l);
            if (Codigo.charAt(l) == '"' && Codigo.charAt(l - 1) != '\\') {
                AspasAberto = !AspasAberto;
                continue;
            } else if (Codigo.charAt(l) == '\'' && Codigo.charAt(l - 1) != '\\') {
                PlicasAberto = !PlicasAberto;
                continue;
            }
            if (Codigo.charAt(l) == '{') {
                break;
            }
        }

        for (l = j + 1; l < Codigo.length(); l++) {
            if (Codigo.charAt(l) == '"' && Codigo.charAt(l - 1) != '\\') {
                AspasAberto = !AspasAberto;
                continue;
            } else if (Codigo.charAt(l) == '\'' && Codigo.charAt(l - 1) != '\\') {
                PlicasAberto = !PlicasAberto;
                continue;
            }
            if (Codigo.charAt(l) == '{') {
                temChaveta = true;
                break;
            } else if (Codigo.charAt(l) == ';') {
                temChaveta = false;
                break;
            }
        }
        if (temChaveta) {
            NumParentesesAbertos = 1;
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
                } else if (Codigo.charAt(m) == '}') {
                    if (--NumParentesesAbertos == 0) {
                        break;
                    }
                }
            }
        } else {
            m = l;
        }
        for (n = m + 1; n < Codigo.length(); n++) {
            if (Codigo.charAt(n) != ' ' && Codigo.charAt(n) != '\n') {
                break;
            }
        }

        this.Codigo = Codigo.substring(0, j + 1);
        this.ParaAnalise = Codigo.substring(0, n + 1);
        this.NumCarateresAvancar = m + 1;
        return Codigo.substring(l, m + 1);

    }
}
