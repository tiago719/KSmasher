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

        if (!PInicializacao.getCodigo().trim().equals(";")) {

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

        if (!Condicao.getCodigo().trim().equals(";")) {
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

        if (!Incrementacao.getCodigo().trim().equals(";")) {
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
                if (aux.charAt(i) != ' ' && aux.charAt(i) != '\n') {
                    break;
                }
            }
            i++;
            for (; i < aux.length(); i++) {
                if (aux.charAt(i) != ' ' && aux.charAt(i) != '\n') {
                    break;
                }
            }
            aux = aux.substring(i + 1);
        }

        int temchaveta = 0;
        for (i = 0; i < aux.length(); i++) {
            if (aux.charAt(i) != ' ') {
                if (aux.charAt(i) == '{') {
                    temchaveta = 1;
                    break;
                } else {
                    temchaveta = 0;
                    LinhasEmBrancoDepoisChavetaAberta = -1;
                    LinhasEmBrancoDepoisChavetaFechada = -1;
                    break;
                }

            }
        }

        if (temchaveta == 1) {         //ESPAÇOS EM BRANCO DEPOIS DA {

            Conta = 0;

            aux = ParaAnalise;

            Conta = 0;
            for (i = 0; i < aux.length(); i++) {
                if (aux.charAt(Conta) != '{') {
                    Conta++;
                } else {
                    break;
                }
            }
            aux = aux.substring(Conta + 1);

            LinhasEmBrancoDepoisChavetaAberta = 0;
            for (i = 0; i < aux.length(); i++) {
                if (aux.charAt(i) != '\n' && aux.charAt(i) != ' ') {
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
                if (aux.charAt(Conta) == '{') {
                    nChaveta++;
                } else {
                    if (aux.charAt(Conta) == '}') {
                        if (nChaveta == 0) {
                            break;
                        } else {
                            nChaveta--;
                        }
                    }

                }
            }
            aux = aux.substring(Conta + 1);

            LinhasEmBrancoDepoisChavetaFechada = 0;
            for (i = 0; i < aux.length(); i++) {
                if (aux.charAt(i) != ' ' && aux.charAt(i) != '\n') {
                    break;
                } else {
                    if (aux.charAt(i) == '\n') {
                        LinhasEmBrancoDepoisChavetaFechada++;
                    }
                }

            }
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
          if (n+1 > Codigo.length())
            this.ParaAnalise = Codigo.substring(0, n - (n - Codigo.length()));
        else
            this.ParaAnalise = Codigo.substring(0, n + 1);
          
        this.NumCarateresAvancar = m + 1;
        
        if(m+1 >Codigo.length())
            return Codigo.substring(l, m - (m - Codigo.length()));
        else
            return Codigo.substring(1, m +1);

    }
}
