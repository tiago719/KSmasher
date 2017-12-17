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
    ArrayList<Integer> DoWhileLinhasEmBrancoDepoisChavetaAbertaList;
    ArrayList<Integer> DoWhileLinhasEmBrancoDepoisChavetaFechadaList;
    ArrayList<Integer> DoWhileEspacosWhileParentesesAbertoList;
    ArrayList<Integer> DoWhileEspacosParentesesAbertoCondicaoList;
    ArrayList<Integer> DoWhileEspacosCondicaoParentesFechadoList;
    ArrayList<Integer> DoWhilePrimeiraChavetaNovaLinhaList;

    //operador
    ArrayList<Integer> OperadorEspacosOperadorVariavelList = new ArrayList<>();
    ArrayList<Integer> OperadorEspacosVariavelOperadorList = new ArrayList<>();

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
    ArrayList<Integer> EspacosForParentesAbertoList = new ArrayList<>();
    ArrayList<Integer> EspacosParentesesAbertoCondicaoInicializacaoList = new ArrayList<>();
    ArrayList<Integer> EspacosInicializacaoPontoVirgulaList = new ArrayList<>();
    ArrayList<Integer> EspacosPontoVirgulaCondicaoList = new ArrayList<>();
    ArrayList<Integer> EspacosCondicaoPontoVirgulaList = new ArrayList<>();
    ArrayList<Integer> EspacosPontoVirgulaIncrementacaoList = new ArrayList<>();
    ArrayList<Integer> EspacosIncrementacaoParentesesFechadoList = new ArrayList<>();
    ArrayList<Integer> LinhasEmBrancoDepoisChavetaAbertaList = new ArrayList<>();
    ArrayList<Integer> LinhasEmBrancoDepoisChavetaFechadaList = new ArrayList<>();

    //FUNCOES
    int AntesMain;
    ArrayList<Boolean> AntesMainList = new ArrayList<>();

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
        } catch (IllegalArgumentException e) {
            IfEspacosParentesesAbertoCondicao = 0;
        }

        total = 0;

        for (int i = 0; i < IfEspacosIfParentesAbertoList.size(); i++) {
            total += IfEspacosIfParentesAbertoList.get(i);
        }
        try {
            IfEspacosIfParentesAberto = total / IfEspacosIfParentesAbertoList.size();
        } catch (IllegalArgumentException e) {
            IfEspacosIfParentesAberto = 0;
        }

        total = 0;

        for (int i = 0; i < IfEspacosCondicaoParentesFechadoList.size(); i++) {
            total += IfEspacosCondicaoParentesFechadoList.get(i);
        }
        try {
            IfEspacosCondicaoParentesFechado = total / IfEspacosCondicaoParentesFechadoList.size();
        } catch (IllegalArgumentException e) {
            IfEspacosCondicaoParentesFechado = 0;
        }
        total = 0;

        for (int i = 0; i < IfLinhasEmBrancoDepoisChavetaAbertaList.size(); i++) {
            total += IfLinhasEmBrancoDepoisChavetaAbertaList.get(i);
        }

        try {
            IfLinhasEmBrancoDepoisChavetaAberta = total / IfLinhasEmBrancoDepoisChavetaAbertaList.size();
        } catch (IllegalArgumentException e) {
            IfLinhasEmBrancoDepoisChavetaAberta = 0;
        }
        total = 0;

        for (int i = 0; i < IfLinhasEmBrancoDepoisChavetaFechadaList.size(); i++) {
            total += IfLinhasEmBrancoDepoisChavetaFechadaList.get(i);
        }

        try {
            IfLinhasEmBrancoDepoisChavetaFechada = total / IfLinhasEmBrancoDepoisChavetaFechadaList.size();
        } catch (IllegalArgumentException e) {
            IfLinhasEmBrancoDepoisChavetaFechada = 0;
        }
        total = 0;

        for (int i = 0; i < IfChavetaUmStatementDentroIfList.size(); i++) {
            total += IfChavetaUmStatementDentroIfList.get(i);
        }

        try {
            IfChavetaUmStatementDentroIf = total / IfChavetaUmStatementDentroIfList.size();
        } catch (IllegalArgumentException e) {
            IfChavetaUmStatementDentroIf = 0;
        }
        total = 0;

        for (int i = 0; i < IfPrimeiraChavetaNovaLinhaList.size(); i++) {
            total += IfPrimeiraChavetaNovaLinhaList.get(i);
        }
        try {
            IfPrimeiraChavetaNovaLinha = total / IfPrimeiraChavetaNovaLinhaList.size();
        } catch (IllegalArgumentException e) {
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
        } catch (IllegalArgumentException e) {
            ElseLinhasEmBrancoDepoisChavetaAberta = 0;
        }
        total = 0;

        for (int i = 0; i < ElseLinhasEmBrancoDepoisChavetaFechadaList.size(); i++) {
            total += ElseLinhasEmBrancoDepoisChavetaFechadaList.get(i);
        }

        try {
            ElseLinhasEmBrancoDepoisChavetaFechada = total / ElseLinhasEmBrancoDepoisChavetaFechadaList.size();
        } catch (IllegalArgumentException e) {
            ElseLinhasEmBrancoDepoisChavetaFechada = 0;
        }
        total = 0;

        for (int i = 0; i < ElsePrimeiraChavetaNovaLinhaList.size(); i++) {
            total += ElsePrimeiraChavetaNovaLinhaList.get(i);
        }
        try {
            ElsePrimeiraChavetaNovaLinha = total / ElsePrimeiraChavetaNovaLinhaList.size();
        } catch (IllegalArgumentException e) {
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
        } catch (IllegalArgumentException e) {
            WhileEspacosParentesesAbertoCondicao = 0;
        }

        total = 0;

        for (int i = 0; i < WhileEspacosWhileParentesAbertoList.size(); i++) {
            total += WhileEspacosWhileParentesAbertoList.get(i);
        }

        try {
            WhileEspacosWhileParentesAberto = total / WhileEspacosWhileParentesAbertoList.size();
        } catch (IllegalArgumentException e) {
            WhileEspacosWhileParentesAberto = 0;
        }
        total = 0;

        for (int i = 0; i < WhileEspacosCondicaoParentesFechadoList.size(); i++) {
            total += WhileEspacosCondicaoParentesFechadoList.get(i);
        }
        try {
            WhileEspacosCondicaoParentesFechado = total / WhileEspacosCondicaoParentesFechadoList.size();
        } catch (IllegalArgumentException e) {
            WhileEspacosCondicaoParentesFechado = 0;
        }
        total = 0;

        for (int i = 0; i < WhileLinhasEmBrancoDepoisChavetaAbertaList.size(); i++) {
            total += WhileLinhasEmBrancoDepoisChavetaAbertaList.get(i);
        }
        try {
            WhileLinhasEmBrancoDepoisChavetaAberta = total / WhileLinhasEmBrancoDepoisChavetaAbertaList.size();
        } catch (IllegalArgumentException e) {
            WhileLinhasEmBrancoDepoisChavetaAberta = 0;
        }
        total = 0;

        for (int i = 0; i < WhileLinhasEmBrancoDepoisChavetaFechadaList.size(); i++) {
            total += WhileLinhasEmBrancoDepoisChavetaFechadaList.get(i);
        }
        try {
            WhileLinhasEmBrancoDepoisChavetaFechada = total / WhileLinhasEmBrancoDepoisChavetaFechadaList.size();
        } catch (IllegalArgumentException e) {
            WhileLinhasEmBrancoDepoisChavetaFechada = 0;
        }
        total = 0;

        for (int i = 0; i < WhileChavetaUmStatementDentroWhileList.size(); i++) {
            total += WhileChavetaUmStatementDentroWhileList.get(i);
        }

        try {
            WhileChavetaUmStatementDentroWhile = total / WhileChavetaUmStatementDentroWhileList.size();
        } catch (IllegalArgumentException e) {
            WhileChavetaUmStatementDentroWhile = 0;
        }
        total = 0;

        for (int i = 0; i < WhilePrimeiraChavetaNovaLinhaList.size(); i++) {
            total += WhilePrimeiraChavetaNovaLinhaList.get(i);
        }
        try {
            WhilePrimeiraChavetaNovaLinha = total / WhilePrimeiraChavetaNovaLinhaList.size();
        } catch (IllegalArgumentException e) {
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
        } catch (IllegalArgumentException e) {
            DoWhileEspacosParentesesAbertoCondicao = 0;
        }

        total = 0;

        for (int i = 0; i < DoWhileEspacosWhileParentesesAbertoList.size(); i++) {
            total += DoWhileEspacosWhileParentesesAbertoList.get(i);
        }

        try {
            DoWhileEspacosWhileParentesesAberto = total / DoWhileEspacosWhileParentesesAbertoList.size();
        } catch (IllegalArgumentException e) {
            DoWhileEspacosWhileParentesesAberto = 0;
        }
        total = 0;

        for (int i = 0; i < DoWhileEspacosCondicaoParentesFechadoList.size(); i++) {
            total += DoWhileEspacosCondicaoParentesFechadoList.get(i);
        }
        try {
            DoWhileEspacosCondicaoParentesFechado = total / DoWhileEspacosCondicaoParentesFechadoList.size();
        } catch (IllegalArgumentException e) {
            DoWhileEspacosCondicaoParentesFechado = 0;
        }
        total = 0;

        for (int i = 0; i < DoWhileLinhasEmBrancoDepoisChavetaAbertaList.size(); i++) {
            total += DoWhileLinhasEmBrancoDepoisChavetaAbertaList.get(i);
        }
        try {
            DoWhileLinhasEmBrancoDepoisChavetaAberta = total / DoWhileLinhasEmBrancoDepoisChavetaAbertaList.size();
        } catch (IllegalArgumentException e) {
            DoWhileLinhasEmBrancoDepoisChavetaAberta = 0;
        }
        total = 0;

        for (int i = 0; i < DoWhileLinhasEmBrancoDepoisChavetaFechadaList.size(); i++) {
            total += DoWhileLinhasEmBrancoDepoisChavetaFechadaList.get(i);
        }
        try {
            DoWhileLinhasEmBrancoDepoisChavetaFechada = total / DoWhileLinhasEmBrancoDepoisChavetaFechadaList.size();
        } catch (IllegalArgumentException e) {
            DoWhileLinhasEmBrancoDepoisChavetaFechada = 0;
        }
        total = 0;

        for (int i = 0; i < DoWhilePrimeiraChavetaNovaLinhaList.size(); i++) {
            total += DoWhilePrimeiraChavetaNovaLinhaList.get(i);
        }
        try {
            DoWhilePrimeiraChavetaNovaLinha = total / DoWhilePrimeiraChavetaNovaLinhaList.size();
        } catch (IllegalArgumentException e) {
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
        } catch (IllegalArgumentException e) {
            OperadorEspacosOperadorVariavel = 0;
        }
        total = 0;

        for (int i = 0; i < OperadorEspacosVariavelOperadorList.size(); i++) {
            total += OperadorEspacosVariavelOperadorList.get(i);
        }
        try {
            OperadorEspacosVariavelOperador = total / OperadorEspacosVariavelOperadorList.size();
        } catch (IllegalArgumentException e) {
            OperadorEspacosVariavelOperador = 0;
        }
    }

    public void fazMedias(ArrayList<Statement> Codigo) {
        Statement S;
        for (int i = 0; i < Codigo.size(); i++) {
            if ((S = Codigo.get(i)).hasFilhos()) {
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
        For_EP ForEp = null;

        //funcoes
        Funcoes_EP FuncoesEp = null;

        return new EstiloProgramacao(NomeEstilo, Permite, CastEp, DoWhileEp, ElseEp, ForEp, FuncoesEp, IfEp, OperadorEp, WhileEp);
    }

    public void FazMediaFor() {
        int total = 0;

        for (int i = 0; i < EspacosForParentesAbertoList.size(); i++) {
            total += EspacosForParentesAbertoList.get(i);
        }
        EspacosForParentesAberto = total / EspacosForParentesAbertoList.size();

        total = 0;
        for (int i = 0; i < EspacosParentesesAbertoCondicaoInicializacaoList.size(); i++) {
            total += EspacosParentesesAbertoCondicaoInicializacaoList.get(i);
        }
        EspacosParentesesAbertoCondicaoInicializacao = total / EspacosParentesesAbertoCondicaoInicializacaoList.size();

        total = 0;
        for (int i = 0; i < EspacosInicializacaoPontoVirgulaList.size(); i++) {
            total += EspacosInicializacaoPontoVirgulaList.get(i);
        }
        EspacosInicializacaoPontoVirgula = total / EspacosInicializacaoPontoVirgulaList.size();

        total = 0;
        for (int i = 0; i < EspacosPontoVirgulaCondicaoList.size(); i++) {
            total += EspacosPontoVirgulaCondicaoList.get(i);
        }
        EspacosPontoVirgulaCondicao = total / EspacosPontoVirgulaCondicaoList.size();

        total = 0;
        for (int i = 0; i < EspacosCondicaoPontoVirgulaList.size(); i++) {
            total += EspacosCondicaoPontoVirgulaList.get(i);
        }
        EspacosCondicaoPontoVirgula = total / EspacosCondicaoPontoVirgulaList.size();

        total = 0;
        for (int i = 0; i < EspacosPontoVirgulaIncrementacaoList.size(); i++) {
            total += EspacosPontoVirgulaIncrementacaoList.get(i);
        }
        EspacosPontoVirgulaIncrementacao = total / EspacosPontoVirgulaIncrementacaoList.size();

        total = 0;
        for (int i = 0; i < EspacosIncrementacaoParentesesFechadoList.size(); i++) {
            total += EspacosIncrementacaoParentesesFechadoList.get(i);
        }
        EspacosIncrementacaoParentesesFechado = total / EspacosIncrementacaoParentesesFechadoList.size();

        total = 0;
        for (int i = 0; i < LinhasEmBrancoDepoisChavetaAbertaList.size(); i++) {
            total += LinhasEmBrancoDepoisChavetaAbertaList.get(i);
        }
        LinhasEmBrancoDepoisChavetaAberta = total / LinhasEmBrancoDepoisChavetaAbertaList.size();

        total = 0;
        for (int i = 0; i < LinhasEmBrancoDepoisChavetaFechadaList.size(); i++) {
            total += LinhasEmBrancoDepoisChavetaFechadaList.get(i);
        }
        LinhasEmBrancoDepoisChavetaFechada = total / LinhasEmBrancoDepoisChavetaFechadaList.size();

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

        AntesMain = total / AntesMainList.size();
    }

}
