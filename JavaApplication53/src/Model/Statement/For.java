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
public class For extends Statement
{
    private boolean PosicaoPrimeiraChaveta, ChavetaUmStatementDentroFor;
    private int EspacosForParentesAberto, EspacosParentesesAbertoCondicaoInicializacao, 
            EspacosInicializacaoPontoVirgula, EspacosPontoVirgulaCondicao, EspacosCondicaoPontoVirgula,
            EspacosPontoVirgulaIncrementacao, EspacosIncrementacaoParentesesFechado, 
            LinhasEmBrancoDepoisChavetaAberta, LinhasEmBrancoDepoisChavetaFechada;
    
    private Statement PInicializacao,Condicao,Incrementacao;
    
    public For(String codigo)
    {
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
        int conta= 0 ;
        int EspacosBrancoVariavelIgual=0;
        int EspacosBrancoIgualValor=0;
         
        ////PREVER CASO O FOR SEJA for(;i<9;i++)
        while(aux.charAt(conta) != '=')
        {
            if(aux.charAt(conta) == ';')
            {
                EspacosBrancoVariavelIgual = -1;
                aux = aux.substring(conta);
                break;
            }
            conta++;
        }
        
        if(aux.charAt(conta) == '=')
        {
            for(int i=conta-1;i>=0;i--)
            {
                if(aux.charAt(conta) != ' ')
                {
                   EspacosBrancoVariavelIgual++;        
                }
            }
                
        }
        
        
        
        for (int i = 0; i < aux.length(); i++) {
            if (aux.charAt(i) = ' ') {
                  
            } else {
                break;
            }
        }
        
        PInicializacao.setNumComecar(numComecar);
        ((Inicializacao) PInicializacao).setEspacosBrancoIgualValor(2);
        aux = aux.substring(EspacosParentesesAbertoCondicaoInicializacao);
        
        //---------------------
        
         // CONTA ESPAÇOS DA Inicializacao ATÉ AO ;
        for (int i = 0; i < aux.length(); i++) {
            if (aux.charAt(i) == ' ') {
                EspacosInicializacaoPontoVirgula++;

            } else {
                break;
            }
        }

        aux = aux.substring(EspacosParentesesAbertoCondicaoInicializacao);
        //------------------------------
        
        
    }

    public boolean isPosicaoPrimeiraChaveta()
    {
        return PosicaoPrimeiraChaveta;
    }

    public void setPosicaoPrimeiraChaveta(boolean PosicaoPrimeiraChaveta)
    {
        this.PosicaoPrimeiraChaveta = PosicaoPrimeiraChaveta;
    }

    public boolean isChavetaUmStatementDentroFor()
    {
        return ChavetaUmStatementDentroFor;
    }

    public void setChavetaUmStatementDentroFor(boolean ChavetaUmStatementDentroFor)
    {
        this.ChavetaUmStatementDentroFor = ChavetaUmStatementDentroFor;
    }

    public int getEspacosForParentesAberto()
    {
        return EspacosForParentesAberto;
    }

    public void setEspacosForParentesAberto(int EspacosForParentesAberto)
    {
        this.EspacosForParentesAberto = EspacosForParentesAberto;
    }

    public int getEspacosParentesesAbertoCondicaoInicializacao()
    {
        return EspacosParentesesAbertoCondicaoInicializacao;
    }

    public void setEspacosParentesesAbertoCondicaoInicializacao(int EspacosParentesesAbertoCondicaoInicializacao)
    {
        this.EspacosParentesesAbertoCondicaoInicializacao = EspacosParentesesAbertoCondicaoInicializacao;
    }

    public int getEspacosInicializacaoPontoVirgula()
    {
        return EspacosInicializacaoPontoVirgula;
    }

    public void setEspacosInicializacaoPontoVirgula(int EspacosInicializacaoPontoVirgula)
    {
        this.EspacosInicializacaoPontoVirgula = EspacosInicializacaoPontoVirgula;
    }

    public int getEspacosPontoVirgulaCondicao()
    {
        return EspacosPontoVirgulaCondicao;
    }

    public void setEspacosPontoVirgulaCondicao(int EspacosPontoVirgulaCondicao)
    {
        this.EspacosPontoVirgulaCondicao = EspacosPontoVirgulaCondicao;
    }

    public int getEspacosCondicaoPontoVirgula()
    {
        return EspacosCondicaoPontoVirgula;
    }

    public void setEspacosCondicaoPontoVirgula(int EspacosCondicaoPontoVirgula)
    {
        this.EspacosCondicaoPontoVirgula = EspacosCondicaoPontoVirgula;
    }

    public int getEspacosPontoVirgulaIncrementacao()
    {
        return EspacosPontoVirgulaIncrementacao;
    }

    public void setEspacosPontoVirgulaIncrementacao(int EspacosPontoVirgulaIncrementacao)
    {
        this.EspacosPontoVirgulaIncrementacao = EspacosPontoVirgulaIncrementacao;
    }

    public int getEspacosIncrementacaoParentesesFechado()
    {
        return EspacosIncrementacaoParentesesFechado;
    }

    public void setEspacosIncrementacaoParentesesFechado(int EspacosIncrementacaoParentesesFechado)
    {
        this.EspacosIncrementacaoParentesesFechado = EspacosIncrementacaoParentesesFechado;
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
        
    @Override
    public void analisaStatement()
    {
        
    }
    
    @Override
    public void converteStatement()
    {
        
    }
}
