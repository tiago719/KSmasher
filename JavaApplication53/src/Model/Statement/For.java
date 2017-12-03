/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Statement;

/**
 *
 * @author Tiago Coutinho
 */
public class For extends Statement {

    private boolean PosicaoPrimeiraChaveta, ChavetaUmStatementDentroFor;
    private int EspacosForParentesAberto, EspacosParentesesAbertoCondicaoInicializacao,
            EspacosInicializacaoPontoVirgula, EspacosPontoVirgulaCondicao, EspacosCondicaoPontoVirgula,
            EspacosPontoVirgulaIncrementacao, EspacosIncrementacaoParentesesFechado,
            LinhasEmBrancoDepoisChavetaAberta, LinhasEmBrancoDepoisChavetaFechada;

    private Statement PInicializacao, Condicao, Incrementacao;

    public For(String codigo) {
        String aux = "";

        //CONTA OS ESPAÇOS ATÉ AO PRIMEIRO (
        for (int i = 3; i < codigo.length(); i++) {
            if (codigo.charAt(i) != '(') {
                EspacosForParentesAberto++;

            } else {
                break;
            }
        }
        aux = codigo.substring(EspacosForParentesAberto);
        ///--------------------------

        // CONTA ESPAÇOS DO ( do FOR até Á Inicializacao
        for (int i = 0; i < aux.length(); i++) {
            if (aux.charAt(i) == ' ') {
                EspacosParentesesAbertoCondicaoInicializacao++;

            } else {
                break;
            }
        }

        aux = aux.substring(EspacosParentesesAbertoCondicaoInicializacao);
        //------------------------------

        //GUARDA INICIALIZAÇAO
        int Conta = 0;
        int EspacosBrancoVariavelIgual = 0;
        int EspacosBrancoIgualValor = 0;

        ////PREVER CASO O FOR SEJA for(;i<9;i++)
        while (aux.charAt(Conta) != '=') {
            if (aux.charAt(Conta) == ';') {
                EspacosBrancoVariavelIgual = -1;
                EspacosBrancoIgualValor = -1;
                aux = aux.substring(Conta);
                break;
            }
            Conta++;
        }

        if (aux.charAt(Conta) == '=') {
            PInicializacao = new Inicializacao(aux);          
        }
        else
        {
            PInicializacao = new Inicializacao();
            ((Inicializacao)PInicializacao).setEspacosBrancoIgualValor(EspacosBrancoIgualValor);
            ((Inicializacao)PInicializacao).setEspacosBrancoVariavelIgual(EspacosBrancoVariavelIgual);
            
        }
        
        

        //---------------------

        // CONTA ESPAÇOS DA Inicializacao ATÉ AO ;
        for (int i = 0; i < aux.length(); i++) {
            if (aux.charAt(i) == ' ') {
                EspacosInicializacaoPontoVirgula++;

            } else {
                break;
            }
        }

        aux = aux.substring(EspacosInicializacaoPontoVirgula);
        //------------------------------

        ///CONTA ESPAÇOS DO ; ATÈ Á CONDIÇAO
        for (int i = 1; i < aux.length(); i++) {
            if (aux.charAt(i) == ' ') {
                EspacosPontoVirgulaCondicao++;
            } else {
                break;
            }
        }
        aux = aux.substring(EspacosPontoVirgulaCondicao);

        ///--------------------------------------------
        //TRATA CONDIÇAO
        ///TODO PARA FICAR BEM FEITO É NECESSARIO QUE SEJA UMA ESPECIE DE IF PARA TRATAR AS CONDIÇOES
        ///-------------------------------------------
        
        ///ESPAÇOS CONDIÇAO ATÈ ;
        Conta = 0;
        
        while(aux.charAt(Conta) != ';')
        {
            Conta++;
        }
        
        for (int i = Conta - 1; i >= 0; i--) {
            if (aux.charAt(Conta) == ' ') 
                    EspacosCondicaoPontoVirgula++;
            else
               if(aux.charAt(Conta) == ';')    
                   break;
                     
         }
        
        aux = aux.substring(EspacosCondicaoPontoVirgula);
        /// ------------------------------------------------
        
        
        
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

    }

    @Override
    public void converteStatement() {

    }
}
