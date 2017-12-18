/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.EstiloProgramacao.Cast_EP;
import Model.EstiloProgramacao.DoWhile_EP;
import Model.EstiloProgramacao.Else_EP;
import Model.EstiloProgramacao.EstiloProgramacao;
import Model.EstiloProgramacao.For_EP;
import Model.EstiloProgramacao.Funcoes_EP;
import Model.EstiloProgramacao.If_EP;
import Model.EstiloProgramacao.Operador_EP;
import Model.EstiloProgramacao.While_EP;
import Model.Statement.DoWhile;
import Model.Statement.Else;
import Model.Statement.For;
import Model.Statement.Funcao;
import Model.Statement.If;
import Model.Statement.Operador;
import Model.Statement.Statement;
import Model.Statement.While;
import java.util.ArrayList;

/**
 *
 * @author Tiago Coutinho
 */
public class Medias {

    //else
    ArrayList<Integer> ElseLinhasEmBrancoDepoisChavetaAbertaList = new ArrayList<>();
    ArrayList<Integer> ElseLinhasEmBrancoDepoisChavetaFechadaList = new ArrayList<>();
    ArrayList<Integer> ElsePrimeiraChavetaNovaLinhaList = new ArrayList<>();

    //if
    ArrayList<Integer> IfEspacosParentesesAbertoCondicaoList = new ArrayList<>();
    ArrayList<Integer> IfEspacosIfParentesAbertoList = new ArrayList<>();
    ArrayList<Integer> IfEspacosCondicaoParentesFechadoList = new ArrayList<>();
    ArrayList<Integer> IfLinhasEmBrancoDepoisChavetaAbertaList = new ArrayList<>();
    ArrayList<Integer> IfLinhasEmBrancoDepoisChavetaFechadaList = new ArrayList<>();
    ArrayList<Integer> IfChavetaUmStatementDentroIfList = new ArrayList<>();
    ArrayList<Integer> IfPrimeiraChavetaNovaLinhaList = new ArrayList<>();

    //while
    ArrayList<Integer> WhileEspacosParentesesAbertoCondicaoList = new ArrayList<>();
    ArrayList<Integer> WhileEspacosWhileParentesAbertoList = new ArrayList<>();
    ArrayList<Integer> WhileEspacosCondicaoParentesFechadoList = new ArrayList<>();
    ArrayList<Integer> WhileLinhasEmBrancoDepoisChavetaAbertaList = new ArrayList<>();
    ArrayList<Integer> WhileLinhasEmBrancoDepoisChavetaFechadaList = new ArrayList<>();
    ArrayList<Integer> WhileChavetaUmStatementDentroWhileList = new ArrayList<>();
    ArrayList<Integer> WhilePrimeiraChavetaNovaLinhaList = new ArrayList<>();

    //do-while
    ArrayList<Integer> DoWhileLinhasEmBrancoDepoisChavetaAbertaList = new ArrayList<>();
    ArrayList<Integer> DoWhileLinhasEmBrancoDepoisChavetaFechadaList = new ArrayList<>();
    ArrayList<Integer> DoWhileEspacosWhileParentesesAbertoList = new ArrayList<>();
    ArrayList<Integer> DoWhileEspacosParentesesAbertoCondicaoList = new ArrayList<>();
    ArrayList<Integer> DoWhileEspacosCondicaoParentesFechadoList = new ArrayList<>();
    ArrayList<Integer> DoWhilePrimeiraChavetaNovaLinhaList = new ArrayList<>();

    //operador
    ArrayList<Integer> OperadorEspacosOperadorVariavelList = new ArrayList<>();
    ArrayList<Integer> OperadorEspacosVariavelOperadorList = new ArrayList<>();

    //FOR
    ArrayList<Integer> PosicaoPrimeiraChavetaList = new ArrayList<>();
    ArrayList<Integer> EspacosForParentesAbertoList = new ArrayList<>();
    ArrayList<Integer> EspacosParentesesAbertoCondicaoInicializacaoList = new ArrayList<>();
    ArrayList<Integer> EspacosInicializacaoPontoVirgulaList = new ArrayList<>();
    ArrayList<Integer> EspacosPontoVirgulaCondicaoList = new ArrayList<>();
    ArrayList<Integer> EspacosCondicaoPontoVirgulaList = new ArrayList<>();
    ArrayList<Integer> EspacosPontoVirgulaIncrementacaoList = new ArrayList<>();
    ArrayList<Integer> EspacosIncrementacaoParentesesFechadoList = new ArrayList<>();
    ArrayList<Integer> LinhasEmBrancoDepoisChavetaAbertaList = new ArrayList<>();
    ArrayList<Integer> LinhasEmBrancoDepoisChavetaFechadaList = new ArrayList<>();

    //FUNÇÕES
    ArrayList<Boolean> AntesMainList = new ArrayList<>();

    //else
    int ElseLinhasEmBrancoDepoisChavetaFechada;
    int ElseLinhasEmBrancoDepoisChavetaAberta;
    int ElsePrimeiraChavetaNovaLinha;

    //if
    int IfEspacosParentesesAbertoCondicao;
    int IfEspacosIfParentesAberto;
    int IfEspacosCondicaoParentesFechado;
    int IfLinhasEmBrancoDepoisChavetaAberta;
    int IfLinhasEmBrancoDepoisChavetaFechada;
    int IfChavetaUmStatementDentroIf;
    int IfPrimeiraChavetaNovaLinha;

    //while
    int WhileEspacosParentesesAbertoCondicao;
    int WhileEspacosWhileParentesAberto;
    int WhileEspacosCondicaoParentesFechado;
    int WhileLinhasEmBrancoDepoisChavetaAberta;
    int WhileLinhasEmBrancoDepoisChavetaFechada;
    int WhileChavetaUmStatementDentroWhile;
    int WhilePrimeiraChavetaNovaLinha;

    //do-while
    int DoWhileLinhasEmBrancoDepoisChavetaAberta;
    int DoWhileLinhasEmBrancoDepoisChavetaFechada;
    int DoWhileEspacosWhileParentesesAberto;
    int DoWhileEspacosParentesesAbertoCondicao;
    int DoWhileEspacosCondicaoParentesFechado;
    int DoWhilePrimeiraChavetaNovaLinha;

    //operador
    int OperadorEspacosOperadorVariavel;
    int OperadorEspacosVariavelOperador;

    //FOR
    int EspacosForParentesAberto;
    int EspacosParentesesAbertoCondicaoInicializacao;
    int EspacosInicializacaoPontoVirgula;
    int EspacosPontoVirgulaCondicao;
    int EspacosCondicaoPontoVirgula;
    int EspacosPontoVirgulaIncrementacao;
    int EspacosIncrementacaoParentesesFechado;
    int LinhasEmBrancoDepoisChavetaAberta;
    int LinhasEmBrancoDepoisChavetaFechada;
    int PosicaoPrimeiraChaveta;

    //FUNCOES
    int AntesMain;

    public Medias() {
    }

    public void RetiraDadosWhile(While S) {
        int aux;
        WhileEspacosParentesesAbertoCondicaoList.add(S.getEspacosParentesesAbertoCondicao());
        WhileEspacosWhileParentesAbertoList.add(S.getEspacosWhileParentesAberto());
        WhileEspacosCondicaoParentesFechadoList.add(((While) S).getEspacosCondicaoParentesFechado());
        if ((aux = S.getLinhasEmBrancoDepoisChavetaAberta()) != -1) {
            WhileLinhasEmBrancoDepoisChavetaAbertaList.add(aux);
        }
        if ((aux = S.getLinhasEmBrancoDepoisChavetaFechada()) != -1) {
            WhileLinhasEmBrancoDepoisChavetaFechadaList.add(aux);
        }
        if ((aux = S.isChavetaUmStatementDentroWhile()) != -1) {
            WhileChavetaUmStatementDentroWhileList.add(aux);
        }
        if ((aux = S.isPrimeiraChavetaNovaLinha()) != -1) {
            WhilePrimeiraChavetaNovaLinhaList.add(aux);
        }
    }

    public void RetiraDadosDoWhile(DoWhile S) {
        int aux;
        DoWhileEspacosParentesesAbertoCondicaoList.add(S.getEspacosParentesesAbertoCondicao());
        DoWhileEspacosWhileParentesesAbertoList.add(S.getEspacosWhileParentesesAberto());
        DoWhileEspacosCondicaoParentesFechadoList.add(S.getEspacosCondicaoParentesFechado());
        if ((aux = S.getLinhasEmBrancoDepoisChavetaAberta()) != -1) {
            DoWhileLinhasEmBrancoDepoisChavetaAbertaList.add(aux);
        }
        if ((aux = S.getLinhasEmBrancoDepoisChavetaFechada()) != -1) {
            DoWhileLinhasEmBrancoDepoisChavetaFechadaList.add(aux);
        }
        if ((aux = S.getPrimeiraChavetaNovaLinha()) != -1) {
            DoWhilePrimeiraChavetaNovaLinhaList.add(aux);
        }
    }

    public void RetiraDadosElse(Else S) {
        int aux;
        if ((aux = S.getLinhasEmBrancoDepoisChavetaAberta()) != -1) {
            ElseLinhasEmBrancoDepoisChavetaAbertaList.add(aux);
        }
        if ((aux = S.getLinhasEmBrancoDepoisChavetaFechada()) != -1) {
            ElseLinhasEmBrancoDepoisChavetaFechadaList.add(aux);
        }
        if ((aux = S.getPrimeiraChavetaNovaLinha()) != -1) {
            ElsePrimeiraChavetaNovaLinhaList.add(aux);
        }
    }

    public void RetiraDadosOperador(Operador S) {
        OperadorEspacosOperadorVariavelList.add(S.getEspacosOperadorVariavel());
        OperadorEspacosVariavelOperadorList.add(S.getEspacosVariavelOperador());
    }

    public void RetiraDadosIf(If S) {
        int aux;
        IfEspacosParentesesAbertoCondicaoList.add(S.getEspacosParentesesAbertoCondicao());
        IfEspacosIfParentesAbertoList.add(S.getEspacosIfParentesAberto());
        IfEspacosCondicaoParentesFechadoList.add(((If) S).getEspacosCondicaoParentesFechado());
        if ((aux = S.getLinhasEmBrancoDepoisChavetaAberta()) != -1) {
            IfLinhasEmBrancoDepoisChavetaAbertaList.add(aux);
        }
        if ((aux = S.getLinhasEmBrancoDepoisChavetaFechada()) != -1) {
            IfLinhasEmBrancoDepoisChavetaFechadaList.add(aux);
        }
        if ((aux = S.isChavetaUmStatementDentroIf()) != -1) {
            IfChavetaUmStatementDentroIfList.add(aux);
        }
        if ((aux = S.getPrimeiraChavetaNovaLinha()) != -1) {
            IfPrimeiraChavetaNovaLinhaList.add(aux);
        }
    }

    public void RetiraDadosFor(For S) {
        int aux;
        EspacosForParentesAbertoList.add(S.getEspacosForParentesAberto());

        if (S.isPosicaoPrimeiraChaveta() == false) {
            EspacosForParentesAbertoList.add(0);
        } else {
            EspacosForParentesAbertoList.add(1);
        }
        if ((aux = S.getEspacosParentesesAbertoCondicaoInicializacao()) != -1) {
            EspacosParentesesAbertoCondicaoInicializacaoList.add(aux);
        }
        if ((aux = S.getEspacosInicializacaoPontoVirgula()) != -1) {
            EspacosInicializacaoPontoVirgulaList.add(aux);
        }
        if ((aux = S.getEspacosCondicaoPontoVirgula()) != -1) {
            EspacosCondicaoPontoVirgulaList.add(aux);
        }
        if ((aux = S.getEspacosPontoVirgulaIncrementacao()) != -1) {
            EspacosPontoVirgulaIncrementacaoList.add(aux);
        }
        if ((aux = S.getEspacosIncrementacaoParentesesFechado()) != -1) {
            EspacosIncrementacaoParentesesFechadoList.add(aux);
        }
        if ((aux = S.getEspacosIncrementacaoParentesesFechado()) != -1) {
            EspacosIncrementacaoParentesesFechadoList.add(aux);
        }
        if ((aux = S.getLinhasEmBrancoDepoisChavetaAberta()) != -1) {
            LinhasEmBrancoDepoisChavetaAbertaList.add(aux);
        }
        if ((aux = S.getLinhasEmBrancoDepoisChavetaFechada()) != -1) {
            LinhasEmBrancoDepoisChavetaFechadaList.add(aux);
        }

    }

    public void RetiraDadosFuncoes(Funcao S) {
        AntesMainList.add(S.isAntesMain());
    }

    public void FazMediaIf() {
        int total = 0;
        for (int i = 0; i < IfEspacosParentesesAbertoCondicaoList.size(); i++) {
            total += IfEspacosParentesesAbertoCondicaoList.get(i);
        }
        try {
            IfEspacosParentesesAbertoCondicao = total / IfEspacosParentesesAbertoCondicaoList.size();
        } catch (Exception e) {
            IfEspacosParentesesAbertoCondicao = 0;
        }

        total = 0;

        for (int i = 0; i < IfEspacosIfParentesAbertoList.size(); i++) {
            total += IfEspacosIfParentesAbertoList.get(i);
        }
        try {
            IfEspacosIfParentesAberto = total / IfEspacosIfParentesAbertoList.size();
        } catch (Exception e) {
            IfEspacosIfParentesAberto = 0;
        }

        total = 0;

        for (int i = 0; i < IfEspacosCondicaoParentesFechadoList.size(); i++) {
            total += IfEspacosCondicaoParentesFechadoList.get(i);
        }
        try {
            IfEspacosCondicaoParentesFechado = total / IfEspacosCondicaoParentesFechadoList.size();
        } catch (Exception e) {
            IfEspacosCondicaoParentesFechado = 0;
        }
        total = 0;

        for (int i = 0; i < IfLinhasEmBrancoDepoisChavetaAbertaList.size(); i++) {
            total += IfLinhasEmBrancoDepoisChavetaAbertaList.get(i);
        }

        try {
            IfLinhasEmBrancoDepoisChavetaAberta = total / IfLinhasEmBrancoDepoisChavetaAbertaList.size();
        } catch (Exception e) {
            IfLinhasEmBrancoDepoisChavetaAberta = 0;
        }
        total = 0;

        for (int i = 0; i < IfLinhasEmBrancoDepoisChavetaFechadaList.size(); i++) {
            total += IfLinhasEmBrancoDepoisChavetaFechadaList.get(i);
        }

        try {
            IfLinhasEmBrancoDepoisChavetaFechada = total / IfLinhasEmBrancoDepoisChavetaFechadaList.size();
        } catch (Exception e) {
            IfLinhasEmBrancoDepoisChavetaFechada = 0;
        }
        total = 0;

        for (int i = 0; i < IfChavetaUmStatementDentroIfList.size(); i++) {
            total += IfChavetaUmStatementDentroIfList.get(i);
        }

        try {
            IfChavetaUmStatementDentroIf = total / IfChavetaUmStatementDentroIfList.size();
        } catch (Exception e) {
            IfChavetaUmStatementDentroIf = 0;
        }
        total = 0;

        for (int i = 0; i < IfPrimeiraChavetaNovaLinhaList.size(); i++) {
            total += IfPrimeiraChavetaNovaLinhaList.get(i);
        }
        try {
            IfPrimeiraChavetaNovaLinha = total / IfPrimeiraChavetaNovaLinhaList.size();
        } catch (Exception e) {
            IfPrimeiraChavetaNovaLinha = 0;
        }
    }

    public void FazMediaElse() {
        int total = 0;

        for (int i = 0; i < ElseLinhasEmBrancoDepoisChavetaAbertaList.size(); i++) {
            total += ElseLinhasEmBrancoDepoisChavetaAbertaList.get(i);
        }

        try {
            ElseLinhasEmBrancoDepoisChavetaAberta = total / ElseLinhasEmBrancoDepoisChavetaAbertaList.size();
        } catch (Exception e) {
            ElseLinhasEmBrancoDepoisChavetaAberta = 0;
        }
        total = 0;

        for (int i = 0; i < ElseLinhasEmBrancoDepoisChavetaFechadaList.size(); i++) {
            total += ElseLinhasEmBrancoDepoisChavetaFechadaList.get(i);
        }

        try {
            ElseLinhasEmBrancoDepoisChavetaFechada = total / ElseLinhasEmBrancoDepoisChavetaFechadaList.size();
        } catch (Exception e) {
            ElseLinhasEmBrancoDepoisChavetaFechada = 0;
        }
        total = 0;

        for (int i = 0; i < ElsePrimeiraChavetaNovaLinhaList.size(); i++) {
            total += ElsePrimeiraChavetaNovaLinhaList.get(i);
        }
        try {
            ElsePrimeiraChavetaNovaLinha = total / ElsePrimeiraChavetaNovaLinhaList.size();
        } catch (Exception e) {
            ElsePrimeiraChavetaNovaLinha = 0;
        }
    }

    public void FazMediaWhile() {
        int total = 0;
        for (int i = 0; i < WhileEspacosParentesesAbertoCondicaoList.size(); i++) {
            total += WhileEspacosParentesesAbertoCondicaoList.get(i);
        }
        try {
            WhileEspacosParentesesAbertoCondicao = total / WhileEspacosParentesesAbertoCondicaoList.size();
        } catch (Exception e) {
            WhileEspacosParentesesAbertoCondicao = 0;
        }

        total = 0;

        for (int i = 0; i < WhileEspacosWhileParentesAbertoList.size(); i++) {
            total += WhileEspacosWhileParentesAbertoList.get(i);
        }

        try {
            WhileEspacosWhileParentesAberto = total / WhileEspacosWhileParentesAbertoList.size();
        } catch (Exception e) {
            WhileEspacosWhileParentesAberto = 0;
        }
        total = 0;

        for (int i = 0; i < WhileEspacosCondicaoParentesFechadoList.size(); i++) {
            total += WhileEspacosCondicaoParentesFechadoList.get(i);
        }
        try {
            WhileEspacosCondicaoParentesFechado = total / WhileEspacosCondicaoParentesFechadoList.size();
        } catch (Exception e) {
            WhileEspacosCondicaoParentesFechado = 0;
        }
        total = 0;

        for (int i = 0; i < WhileLinhasEmBrancoDepoisChavetaAbertaList.size(); i++) {
            total += WhileLinhasEmBrancoDepoisChavetaAbertaList.get(i);
        }
        try {
            WhileLinhasEmBrancoDepoisChavetaAberta = total / WhileLinhasEmBrancoDepoisChavetaAbertaList.size();
        } catch (Exception e) {
            WhileLinhasEmBrancoDepoisChavetaAberta = 0;
        }
        total = 0;

        for (int i = 0; i < WhileLinhasEmBrancoDepoisChavetaFechadaList.size(); i++) {
            total += WhileLinhasEmBrancoDepoisChavetaFechadaList.get(i);
        }
        try {
            WhileLinhasEmBrancoDepoisChavetaFechada = total / WhileLinhasEmBrancoDepoisChavetaFechadaList.size();
        } catch (Exception e) {
            WhileLinhasEmBrancoDepoisChavetaFechada = 0;
        }
        total = 0;

        for (int i = 0; i < WhileChavetaUmStatementDentroWhileList.size(); i++) {
            total += WhileChavetaUmStatementDentroWhileList.get(i);
        }

        try {
            WhileChavetaUmStatementDentroWhile = total / WhileChavetaUmStatementDentroWhileList.size();
        } catch (Exception e) {
            WhileChavetaUmStatementDentroWhile = 0;
        }
        total = 0;

        for (int i = 0; i < WhilePrimeiraChavetaNovaLinhaList.size(); i++) {
            total += WhilePrimeiraChavetaNovaLinhaList.get(i);
        }
        try {
            WhilePrimeiraChavetaNovaLinha = total / WhilePrimeiraChavetaNovaLinhaList.size();
        } catch (Exception e) {
            WhilePrimeiraChavetaNovaLinha = 0;
        }
    }

    public void FazMediaDoWhile() {
        int total = 0;
        for (int i = 0; i < DoWhileEspacosParentesesAbertoCondicaoList.size(); i++) {
            total += DoWhileEspacosParentesesAbertoCondicaoList.get(i);
        }
        try {
            DoWhileEspacosParentesesAbertoCondicao = total / DoWhileEspacosParentesesAbertoCondicaoList.size();
        } catch (Exception e) {
            DoWhileEspacosParentesesAbertoCondicao = 0;
        }

        total = 0;

        for (int i = 0; i < DoWhileEspacosWhileParentesesAbertoList.size(); i++) {
            total += DoWhileEspacosWhileParentesesAbertoList.get(i);
        }

        try {
            DoWhileEspacosWhileParentesesAberto = total / DoWhileEspacosWhileParentesesAbertoList.size();
        } catch (Exception e) {
            DoWhileEspacosWhileParentesesAberto = 0;
        }
        total = 0;

        for (int i = 0; i < DoWhileEspacosCondicaoParentesFechadoList.size(); i++) {
            total += DoWhileEspacosCondicaoParentesFechadoList.get(i);
        }
        try {
            DoWhileEspacosCondicaoParentesFechado = total / DoWhileEspacosCondicaoParentesFechadoList.size();
        } catch (Exception e) {
            DoWhileEspacosCondicaoParentesFechado = 0;
        }
        total = 0;

        for (int i = 0; i < DoWhileLinhasEmBrancoDepoisChavetaAbertaList.size(); i++) {
            total += DoWhileLinhasEmBrancoDepoisChavetaAbertaList.get(i);
        }
        try {
            DoWhileLinhasEmBrancoDepoisChavetaAberta = total / DoWhileLinhasEmBrancoDepoisChavetaAbertaList.size();
        } catch (Exception e) {
            DoWhileLinhasEmBrancoDepoisChavetaAberta = 0;
        }
        total = 0;

        for (int i = 0; i < DoWhileLinhasEmBrancoDepoisChavetaFechadaList.size(); i++) {
            total += DoWhileLinhasEmBrancoDepoisChavetaFechadaList.get(i);
        }
        try {
            DoWhileLinhasEmBrancoDepoisChavetaFechada = total / DoWhileLinhasEmBrancoDepoisChavetaFechadaList.size();
        } catch (Exception e) {
            DoWhileLinhasEmBrancoDepoisChavetaFechada = 0;
        }
        total = 0;

        for (int i = 0; i < DoWhilePrimeiraChavetaNovaLinhaList.size(); i++) {
            total += DoWhilePrimeiraChavetaNovaLinhaList.get(i);
        }
        try {
            DoWhilePrimeiraChavetaNovaLinha = total / DoWhilePrimeiraChavetaNovaLinhaList.size();
        } catch (Exception e) {
            DoWhilePrimeiraChavetaNovaLinha = 0;
        }
    }

    public void FazMediasOperador() {
        int total = 0;

        for (int i = 0; i < OperadorEspacosOperadorVariavelList.size(); i++) {
            total += OperadorEspacosOperadorVariavelList.get(i);
        }
        try {
            OperadorEspacosOperadorVariavel = total / OperadorEspacosOperadorVariavelList.size();
        } catch (Exception e) {
            OperadorEspacosOperadorVariavel = 0;
        }
        total = 0;

        for (int i = 0; i < OperadorEspacosVariavelOperadorList.size(); i++) {
            total += OperadorEspacosVariavelOperadorList.get(i);
        }
        try {
            OperadorEspacosVariavelOperador = total / OperadorEspacosVariavelOperadorList.size();
        } catch (Exception e) {
            OperadorEspacosVariavelOperador = 0;
        }
    }

    public void FazMediaFor() {
        int total = 0;

        for (int i = 0; i < EspacosForParentesAbertoList.size(); i++) {
            total += EspacosForParentesAbertoList.get(i);
        }
        try {
            EspacosForParentesAberto = total / EspacosForParentesAbertoList.size();
        } catch (Exception e) {
            EspacosForParentesAberto = 0;
        }

        total = 0;
        for (int i = 0; i < EspacosParentesesAbertoCondicaoInicializacaoList.size(); i++) {
            total += EspacosParentesesAbertoCondicaoInicializacaoList.get(i);
        }
        try {
            EspacosParentesesAbertoCondicaoInicializacao = total / EspacosParentesesAbertoCondicaoInicializacaoList.size();
        } catch (Exception e) {
            EspacosForParentesAberto = 0;
        }
        total = 0;
        for (int i = 0; i < EspacosInicializacaoPontoVirgulaList.size(); i++) {
            total += EspacosInicializacaoPontoVirgulaList.get(i);
        }
        try {
            EspacosInicializacaoPontoVirgula = total / EspacosInicializacaoPontoVirgulaList.size();
        } catch (Exception e) {
            EspacosForParentesAberto = 0;
        }
        total = 0;
        for (int i = 0; i < EspacosPontoVirgulaCondicaoList.size(); i++) {
            total += EspacosPontoVirgulaCondicaoList.get(i);
        }
        try {
            EspacosPontoVirgulaCondicao = total / EspacosPontoVirgulaCondicaoList.size();
        } catch (Exception e) {
            EspacosForParentesAberto = 0;
        }
        total = 0;
        for (int i = 0; i < EspacosCondicaoPontoVirgulaList.size(); i++) {
            total += EspacosCondicaoPontoVirgulaList.get(i);
        }
        try {
            EspacosCondicaoPontoVirgula = total / EspacosCondicaoPontoVirgulaList.size();
        } catch (Exception e) {
            EspacosForParentesAberto = 0;
        }
        total = 0;
        for (int i = 0; i < EspacosPontoVirgulaIncrementacaoList.size(); i++) {
            total += EspacosPontoVirgulaIncrementacaoList.get(i);
        }
        try {
            EspacosPontoVirgulaIncrementacao = total / EspacosPontoVirgulaIncrementacaoList.size();
        } catch (Exception e) {
            EspacosForParentesAberto = 0;
        }
        total = 0;
        for (int i = 0; i < EspacosIncrementacaoParentesesFechadoList.size(); i++) {
            total += EspacosIncrementacaoParentesesFechadoList.get(i);
        }
        try {
            EspacosIncrementacaoParentesesFechado = total / EspacosIncrementacaoParentesesFechadoList.size();
        } catch (Exception e) {
            EspacosForParentesAberto = 0;
        }
        total = 0;
        for (int i = 0; i < LinhasEmBrancoDepoisChavetaAbertaList.size(); i++) {
            total += LinhasEmBrancoDepoisChavetaAbertaList.get(i);
        }
        try {
            LinhasEmBrancoDepoisChavetaAberta = total / LinhasEmBrancoDepoisChavetaAbertaList.size();
        } catch (Exception e) {
            EspacosForParentesAberto = 0;
        }
        total = 0;
        for (int i = 0; i < LinhasEmBrancoDepoisChavetaFechadaList.size(); i++) {
            total += LinhasEmBrancoDepoisChavetaFechadaList.get(i);
        }
        try {
            LinhasEmBrancoDepoisChavetaFechada = total / LinhasEmBrancoDepoisChavetaFechadaList.size();
        } catch (Exception e) {
            EspacosForParentesAberto = 0;
        }
        total = 0;

        for (int i = 0; i < PosicaoPrimeiraChavetaList.size(); i++) {
            total += PosicaoPrimeiraChavetaList.get(i);
        }
        try {
            PosicaoPrimeiraChaveta = total / PosicaoPrimeiraChavetaList.size();
        } catch (Exception e) {
            EspacosForParentesAberto = 0;
        }
    }

    public void FazMediaFuncoes() {
        int total = 0;

        for (int i = 0; i < AntesMainList.size(); i++) {
            if (AntesMainList.get(i) == true) {
                total += 1;
            } else {
                total += 0;
            }
        }
        try {
            AntesMain = total / AntesMainList.size();
        } catch (Exception e) {
            AntesMain = 0;
        }
    }

    public void fazMedias(ArrayList<Statement> Codigo) {
        Statement S;
        for (int i = 0; i < Codigo.size(); i++) {
            S = Codigo.get(i);
            if (S.hasFilhos()) {
                fazMedias(Codigo.get(i).getStatementsFilhos());
            }

            if (S instanceof While) {
                RetiraDadosWhile((While) S);
            } else if (S instanceof Operador) {
                RetiraDadosOperador((Operador) S);
            } else if (S instanceof If) {
                RetiraDadosIf((If) S);
            } else if (S instanceof Else) {
                RetiraDadosElse((Else) S);
            } else if (S instanceof For) {
                RetiraDadosFor((For) S);
            } else if (S instanceof Funcao) {
                RetiraDadosFuncoes((Funcao) S);
            }
        }

        FazMediaWhile();
        FazMediasOperador();
        FazMediaIf();
        FazMediaElse();
        FazMediaDoWhile();

        FazMediaFor();
        FazMediaFuncoes();
    }

    public EstiloProgramacao NovoEstilo(ArrayList<Statement> Codigo, String NomeEstilo, boolean Permite) {
        fazMedias(Codigo);

        //while
        boolean aux1, aux2;
        aux1 = WhilePrimeiraChavetaNovaLinha == 1;

        aux2 = WhileChavetaUmStatementDentroWhile == 1;

        if (WhileLinhasEmBrancoDepoisChavetaAberta < 0) {
            WhileLinhasEmBrancoDepoisChavetaAberta = 0;
        }

        if (WhileLinhasEmBrancoDepoisChavetaFechada < 0) {
            WhileLinhasEmBrancoDepoisChavetaFechada = 0;
        }

        While_EP WhileEp = new While_EP(aux1, aux2, WhileLinhasEmBrancoDepoisChavetaAberta, WhileLinhasEmBrancoDepoisChavetaFechada, WhileEspacosWhileParentesAberto, WhileEspacosParentesesAbertoCondicao, WhileEspacosCondicaoParentesFechado);

        //operador
        Operador_EP OperadorEp = new Operador_EP(OperadorEspacosOperadorVariavel, OperadorEspacosVariavelOperador);

        //if
        aux1 = IfPrimeiraChavetaNovaLinha == 1;

        aux2 = IfChavetaUmStatementDentroIf == 1;

        if (IfLinhasEmBrancoDepoisChavetaAberta < 0) {
            IfLinhasEmBrancoDepoisChavetaAberta = 0;
        }

        if (IfLinhasEmBrancoDepoisChavetaFechada < 0) {
            IfLinhasEmBrancoDepoisChavetaFechada = 0;
        }

        If_EP IfEp = new If_EP(aux1, aux2, IfLinhasEmBrancoDepoisChavetaAberta, IfLinhasEmBrancoDepoisChavetaFechada, IfEspacosIfParentesAberto, IfEspacosParentesesAbertoCondicao, IfEspacosCondicaoParentesFechado);

        //else
        aux1 = ElsePrimeiraChavetaNovaLinha == 1;
        if (ElseLinhasEmBrancoDepoisChavetaAberta < 0) {
            ElseLinhasEmBrancoDepoisChavetaAberta = 0;
        }

        if (ElseLinhasEmBrancoDepoisChavetaFechada < 0) {
            ElseLinhasEmBrancoDepoisChavetaFechada = 0;
        }

        Else_EP ElseEp = new Else_EP(aux1, ElseLinhasEmBrancoDepoisChavetaAberta, ElseLinhasEmBrancoDepoisChavetaFechada);

        //cats
        Cast_EP CastEp = null;

        //doWhile
        aux1 = DoWhilePrimeiraChavetaNovaLinha == 1;

        if (DoWhileLinhasEmBrancoDepoisChavetaAberta < 0) {
            DoWhileLinhasEmBrancoDepoisChavetaAberta = 0;
        }

        if (DoWhileLinhasEmBrancoDepoisChavetaFechada < 0) {
            DoWhileLinhasEmBrancoDepoisChavetaFechada = 0;
        }

        DoWhile_EP DoWhileEp = new DoWhile_EP(aux1, DoWhileLinhasEmBrancoDepoisChavetaAberta, DoWhileLinhasEmBrancoDepoisChavetaFechada, DoWhileEspacosWhileParentesesAberto, DoWhileEspacosParentesesAbertoCondicao, DoWhileEspacosCondicaoParentesFechado);

        //for
        if (EspacosForParentesAberto < 0) {
            EspacosForParentesAberto = 0;
        }
        if (EspacosParentesesAbertoCondicaoInicializacao < 0) {
            EspacosParentesesAbertoCondicaoInicializacao = 0;
        }
        if (EspacosInicializacaoPontoVirgula < 0) {
            EspacosInicializacaoPontoVirgula = 0;
        }
        if (EspacosPontoVirgulaCondicao < 0) {
            EspacosPontoVirgulaCondicao = 0;
        }
        if (EspacosPontoVirgulaCondicao < 0) {
            EspacosPontoVirgulaCondicao = 0;
        }
        if (EspacosCondicaoPontoVirgula < 0) {
            EspacosCondicaoPontoVirgula = 0;
        }
        if (EspacosPontoVirgulaIncrementacao < 0) {
            EspacosPontoVirgulaIncrementacao = 0;
        }
        if (EspacosIncrementacaoParentesesFechado < 0) {
            EspacosIncrementacaoParentesesFechado = 0;
        }
        if (LinhasEmBrancoDepoisChavetaAberta < 0) {
            LinhasEmBrancoDepoisChavetaAberta = 0;
        }
        if (LinhasEmBrancoDepoisChavetaFechada < 0) {
            LinhasEmBrancoDepoisChavetaFechada = 0;
        }

        For_EP ForEp;
        if (PosicaoPrimeiraChaveta > 0.5) {
            ForEp = new For_EP(false, true, EspacosForParentesAberto, EspacosParentesesAbertoCondicaoInicializacao, EspacosInicializacaoPontoVirgula, EspacosPontoVirgulaCondicao, EspacosCondicaoPontoVirgula, EspacosPontoVirgulaIncrementacao, EspacosIncrementacaoParentesesFechado, LinhasEmBrancoDepoisChavetaAberta, LinhasEmBrancoDepoisChavetaFechada);
        } else {
            ForEp = new For_EP(false, true, EspacosForParentesAberto, EspacosParentesesAbertoCondicaoInicializacao, EspacosInicializacaoPontoVirgula, EspacosPontoVirgulaCondicao, EspacosCondicaoPontoVirgula, EspacosPontoVirgulaIncrementacao, EspacosIncrementacaoParentesesFechado, LinhasEmBrancoDepoisChavetaAberta, LinhasEmBrancoDepoisChavetaFechada);
        }
        //funcoes
        Funcoes_EP FuncoesEp;
        if (PosicaoPrimeiraChaveta > 0.5) {
            FuncoesEp = new Funcoes_EP(true);
        } else {
            FuncoesEp = new Funcoes_EP(false);
        }

        return new EstiloProgramacao(NomeEstilo, Permite, CastEp, DoWhileEp, ElseEp, ForEp, FuncoesEp, IfEp, OperadorEp, WhileEp);
    }

}
