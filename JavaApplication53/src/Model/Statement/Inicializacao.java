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
public class Inicializacao extends Statement {

    private int EspacosBrancoVariavelIgual, EspacosBrancoIgualValor;

    public Inicializacao()
    {
        
    }
    
    public Inicializacao(String Codigo) {
        
        String aux = Codigo;
        int Conta=0;
        EspacosBrancoVariavelIgual = 0;
        EspacosBrancoIgualValor = 0;
        
         while (aux.charAt(Conta) != '=') {
            Conta++;
        } 
        
         /////CONTAR ESPAÇOS DA Variavel até ao IGUAL
        for (int i = Conta - 1; i >= 0; i--) {
            if (aux.charAt(Conta) == ' ') {
                EspacosBrancoVariavelIgual++;
            }
        }
        aux = aux.substring(Conta+1);

        /////CONTAR ESPAÇOS DO = ATÈ AO VALOR
        for (int i = 0; i < aux.length(); i++) {
            if (aux.charAt(i) == ' ') {
                EspacosBrancoIgualValor++;
            } else {
                break;
            }
        }
    }

    public int getEspacosBrancoVariavelIgual() {
        return EspacosBrancoVariavelIgual;
    }

    public void setEspacosBrancoVariavelIgual(int EspacosBrancoVariavelIgual) {
        this.EspacosBrancoVariavelIgual = EspacosBrancoVariavelIgual;
    }

    public int getEspacosBrancoIgualValor() {
        return EspacosBrancoIgualValor;
    }

    public void setEspacosBrancoIgualValor(int EspacosBrancoIgualValor) {
        this.EspacosBrancoIgualValor = EspacosBrancoIgualValor;
    }

    @Override
    public void analisaStatement() {

    }

    @Override
    public void converteStatement() {

    }
}
