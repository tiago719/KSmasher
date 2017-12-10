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

    public For(String codigo, Texto t, ArrayList<Statement> MesmoNivel) {
        super(codigo, t, MesmoNivel);

    }

//    public For(String codigo) {
//        String aux = "";
//        numCarateresCodigoStatment = 0;
//        //CONTA OS ESPAÇOS ATÉ AO PRIMEIRO (
//        for (int i = 3; i < codigo.length(); i++) {
//            if (codigo.charAt(i) != '(') {
//                EspacosForParentesAberto++;
//
//            } else {
//                break;
//            }
//            numCarateresCodigoStatment++;
//        }
//        aux = codigo.substring(EspacosForParentesAberto);
//        ///--------------------------
//
//        // CONTA ESPAÇOS DO ( do FOR até Á Inicializacao
//        for (int i = 0; i < aux.length(); i++) {
//            if (aux.charAt(i) == ' ') {
//                EspacosParentesesAbertoCondicaoInicializacao++;
//
//            } else {
//                break;
//            }
//            numCarateresCodigoStatment++;
//        }
//
//        aux = aux.substring(EspacosParentesesAbertoCondicaoInicializacao);
//        //------------------------------
//
//        //GUARDA INICIALIZAÇAO
//        int Conta = 0;
//        int EspacosBrancoVariavelIgual = 0;
//        int EspacosBrancoIgualValor = 0;
//
//        ////PREVER CASO O FOR SEJA for(;i<9;i++)
//        while (aux.charAt(Conta) != '=') {
//            if (aux.charAt(Conta) == ';') {
//                EspacosBrancoVariavelIgual = -1;
//                EspacosBrancoIgualValor = -1;
//                aux = aux.substring(Conta);
//                break;
//            }
//            Conta++;
//        }
//
//        if (aux.charAt(Conta) == '=') {
//            PInicializacao = new Inicializacao(aux);
//            numCarateresCodigoStatment = PInicializacao.getNumCarateresCodigoStatment();
//        } else {
//            PInicializacao = new Inicializacao();
//            numCarateresCodigoStatment++;
//            ((Inicializacao) PInicializacao).setEspacosBrancoIgualValor(EspacosBrancoIgualValor);
//            ((Inicializacao) PInicializacao).setEspacosBrancoVariavelIgual(EspacosBrancoVariavelIgual);
//
//        }
//        //---------------------
//
//        // CONTA ESPAÇOS DA Inicializacao ATÉ AO ;
//        for (int i = 0; i < aux.length(); i++) {
//            if (aux.charAt(i) == ' ') {
//                EspacosInicializacaoPontoVirgula++;
//
//            } else {
//                break;
//            }
//            numCarateresCodigoStatment++;
//        }
//
//        aux = aux.substring(EspacosInicializacaoPontoVirgula);
//        //------------------------------
//
//        ///CONTA ESPAÇOS DO ; ATÈ Á CONDIÇAO
//        for (int i = 1; i < aux.length(); i++) {
//            if (aux.charAt(i) == ' ') {
//                EspacosPontoVirgulaCondicao++;
//            } else {
//                break;
//            }
//            numCarateresCodigoStatment++;
//        }
//        aux = aux.substring(EspacosPontoVirgulaCondicao);
//
//        ///--------------------------------------------
//        //TRATA CONDIÇAo
//        String auxCondicao = "";
//        int contacond=0;
//        for (int i = 1; i < aux.length(); i++) {
//            if (aux.charAt(i) == ';') {
//                break;
//            } else {
//                auxCondicao += aux.charAt(i);
//            }
//            contacond++;
//        }
//         Condicao = new Statement();
//         
//         Condicao.setStatement(Statement);
//         Condicao.setNumComecar(contacond);
//         ////-------------------------------
//         
//         ///ESPAÇO ENTRE ; CONDICAO
//          for (int i = 1; i < aux.length(); i++) {
//            if (aux.charAt(i) == ' ') {
//               EspacosPontoVirgulaCondicao++;
//            } else {
//                break;
//            }
//            numCarateresCodigoStatment++;
//        }
//
//        ///-------------------------------------------
//        ///ESPAÇOS CONDIÇAO ATÈ ;
//        Conta = 0;
//
//        while (aux.charAt(Conta) != ';') {
//            Conta++;
//        }
//
//        for (int i = Conta - 1; i >= 0; i--) {
//            if (aux.charAt(Conta) == ' ') {
//                EspacosCondicaoPontoVirgula++;
//            } else if (aux.charAt(Conta) == ';') {
//                break;
//            }
//            numCarateresCodigoStatment++;
//        }
//
//        aux = aux.substring(EspacosCondicaoPontoVirgula);
//        /// ------------------------------------------------
//
//        numCarateresCodigoStatment = numCarateresCodigoStatment;
//    }
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

    }

    @Override
    public void converteStatement() {

    }

    @Override
    public String RetiraDados(String Codigo, Texto t) {
        int i, j;
        boolean AspasAberto = true, PlicasAberto = true;

        //retira espacos entre if e (
        for (i = 3; i < Codigo.length(); i++) {
            if (Codigo.charAt(i) != ' ') {
                break;
            }
        }

        i++;//fica depois do (

        //retira espacos ate inicializacao
        for (; i < Codigo.length(); i++) {
            if (Codigo.charAt(i) != ' ') {
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

        PInicializacao = new Statement(Codigo.substring(j + 1), t, StatementsMesmoNivel);


        //retirar espacos entre Inicializacao; ate condicao
        for (i = j; i < Codigo.length(); i++) {
            if (Codigo.charAt(i) != ' ') {
                break;
            }
        }

        //encontrar fim de condicao
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
        
        Condicao = new Statement(Codigo.substring(i, j+1), t,StatementsMesmoNivel);
        
        
        //retirar espacos entre Condicao; ate incrementacao
        for (i = j; i < Codigo.length(); i++) {
            if (Codigo.charAt(i) != ' ') {
                break;
            }
        }
        
        //encontrar fim de incrementacao
       int numParentesesAbertos = 0;
        for (j = i; j < Codigo.length(); j++) {
            if (Codigo.charAt(j) == '"' && Codigo.charAt(j-1) != '\\')
                AspasAberto = !AspasAberto;
            if (Codigo.charAt(j) == '\'' && Codigo.charAt(j-1) != '\\')
                PlicasAberto = !PlicasAberto;
            
            if (!AspasAberto && !PlicasAberto){
                if (Codigo.charAt(j) == ')'){
                    if (--numParentesesAbertos == 0){
                        break;
                    }
                }
            }
        }
        
        Incrementacao = new Statement(Codigo.substring(i, j+1), t, StatementsMesmoNivel);
        

        return Codigo.substring(j+1);

    }
}
