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
import Model.Statement.Operador;
import Model.Statement.Statement;
import Model.Statement.While;
import java.util.ArrayList;

/**
 *
 * @author Tiago Coutinho
 */
public class Medias
{
    //while
    ArrayList<Integer> WhileEspacosParentesesAbertoCondicaoList=new ArrayList<>();
    ArrayList<Integer> WhileEspacosWhileParentesAbertoList=new ArrayList<>();
    ArrayList<Integer> WhileEspacosCondicaoParentesFechadoList=new ArrayList<>();
    ArrayList<Integer> WhileLinhasEmBrancoDepoisChavetaAbertaList=new ArrayList<>();
    ArrayList<Integer> WhileLinhasEmBrancoDepoisChavetaFechadaList=new ArrayList<>();
    ArrayList<Integer> WhileChavetaUmStatementDentroWhileList=new ArrayList<>();
    ArrayList<Integer> WhilePrimeiraChavetaNovaLinhaList=new ArrayList<>();
    
    //operador
    ArrayList<Integer> OperadorEspacosOperadorVariavelList=new ArrayList<>();
    ArrayList<Integer> OperadorEspacosVariavelOperadorList=new ArrayList<>();
    
    //while
    int WhileEspacosParentesesAbertoCondicao;
    int WhileEspacosWhileParentesAberto;
    int WhileEspacosCondicaoParentesFechado;
    int WhileLinhasEmBrancoDepoisChavetaAberta;
    int WhileLinhasEmBrancoDepoisChavetaFechada;
    int WhileChavetaUmStatementDentroWhile;
    int WhilePrimeiraChavetaNovaLinha;
    
    //operador
    int OperadorEspacosOperadorVariavel;
    int OperadorEspacosVariavelOperador;
    
    public Medias(){}
    
    public void RetiraDadosWhile(While S)
    {
        int aux;
        WhileEspacosParentesesAbertoCondicaoList.add(S.getEspacosParentesesAbertoCondicao());
        WhileEspacosWhileParentesAbertoList.add(S.getEspacosWhileParentesAberto());
        WhileEspacosCondicaoParentesFechadoList.add(((While)S).getEspacosCondicaoParentesFechado());
        if((aux=S.getLinhasEmBrancoDepoisChavetaAberta())!=-1)
            WhileLinhasEmBrancoDepoisChavetaAbertaList.add(aux);
        if((aux=S.getLinhasEmBrancoDepoisChavetaFechada())!=-1)
            WhileLinhasEmBrancoDepoisChavetaFechadaList.add(aux);
        if((aux=S.isChavetaUmStatementDentroWhile())!=-1)
            WhileChavetaUmStatementDentroWhileList.add(aux);
        if((aux=S.isPrimeiraChavetaNovaLinha())!=-1)
            WhilePrimeiraChavetaNovaLinhaList.add(aux);
    }
    
    public void RetiraDadosOperador(Operador S)
    {
        OperadorEspacosOperadorVariavelList.add(S.getEspacosOperadorVariavel());
        OperadorEspacosVariavelOperadorList.add(S.getEspacosVariavelOperador());
    }
    
    public void FazMediaWhile()
    {
        int total=0;
        for(int i=0;i<WhileEspacosParentesesAbertoCondicaoList.size();i++)
        {
            total+=WhileEspacosParentesesAbertoCondicaoList.get(i);
        }
        WhileEspacosParentesesAbertoCondicao=total/WhileEspacosParentesesAbertoCondicaoList.size();
        
        total=0;
        
        for(int i=0;i<WhileEspacosWhileParentesAbertoList.size();i++)
        {
            total+=WhileEspacosWhileParentesAbertoList.get(i);
        }
        WhileEspacosWhileParentesAberto=total/WhileEspacosWhileParentesAbertoList.size();
        
        total=0;
        
        for(int i=0;i<WhileEspacosCondicaoParentesFechadoList.size();i++)
        {
            total+=WhileEspacosCondicaoParentesFechadoList.get(i);
        }
        WhileEspacosCondicaoParentesFechado=total/WhileEspacosCondicaoParentesFechadoList.size();
        
        total=0;
        
        for(int i=0;i<WhileLinhasEmBrancoDepoisChavetaAbertaList.size();i++)
        {
            total+=WhileLinhasEmBrancoDepoisChavetaAbertaList.get(i);
        }
        WhileLinhasEmBrancoDepoisChavetaAberta=total/WhileLinhasEmBrancoDepoisChavetaAbertaList.size();
        
        total=0;
        
        for(int i=0;i<WhileLinhasEmBrancoDepoisChavetaFechadaList.size();i++)
        {
            total+=WhileLinhasEmBrancoDepoisChavetaFechadaList.get(i);
        }
        WhileLinhasEmBrancoDepoisChavetaFechada=total/WhileLinhasEmBrancoDepoisChavetaFechadaList.size();
        
        total=0;
        
        for(int i=0;i<WhileChavetaUmStatementDentroWhileList.size();i++)
        {
            total+=WhileChavetaUmStatementDentroWhileList.get(i);
        }
        WhileChavetaUmStatementDentroWhile=total/WhileChavetaUmStatementDentroWhileList.size();
        
        total=0;
        
        for(int i=0;i<WhilePrimeiraChavetaNovaLinhaList.size();i++)
        {
            total+=WhilePrimeiraChavetaNovaLinhaList.get(i);
        }
        WhilePrimeiraChavetaNovaLinha=total/WhilePrimeiraChavetaNovaLinhaList.size();
                
    }
    
    public void FazMediasOperador()
    {
        int total=0;
        
        for(int i=0;i<OperadorEspacosOperadorVariavelList.size();i++)
        {
            total+=OperadorEspacosOperadorVariavelList.get(i);
        }
        OperadorEspacosOperadorVariavel=total/OperadorEspacosOperadorVariavelList.size();
        
        total=0;
        
        for(int i=0;i<OperadorEspacosVariavelOperadorList.size();i++)
        {
            total+=OperadorEspacosVariavelOperadorList.get(i);
        }
        OperadorEspacosVariavelOperador=total/OperadorEspacosVariavelOperadorList.size();
    }
    
    public void fazMedias(ArrayList<Statement> Codigo)
    {
        Statement S;
        int aux, total=0;
        for(int i=0;i<Codigo.size();i++)
        {
            if((S=Codigo.get(i)).hasFilhos())
                fazMedias(Codigo.get(i).getStatementsFilhos());
            
            if(S instanceof While)
                RetiraDadosWhile((While)S);
            else if(S instanceof Operador)
                RetiraDadosOperador((Operador)S);                
        }
        
        FazMediaWhile();
        FazMediasOperador();
    }
    
    public EstiloProgramacao NovoEstilo(ArrayList<Statement> Codigo, String NomeEstilo)
    {
        fazMedias(Codigo);
        
        //while
        
        boolean aux1, aux2;
        if(WhilePrimeiraChavetaNovaLinha==1)
            aux1=true;
        else
            aux1=false;
        
        if(WhileChavetaUmStatementDentroWhile==1)
            aux2=true;
        else
            aux2=false;
        
        if(WhileLinhasEmBrancoDepoisChavetaAberta<0)
            WhileLinhasEmBrancoDepoisChavetaAberta=0;
        
        if(WhileLinhasEmBrancoDepoisChavetaFechada<0)
            WhileLinhasEmBrancoDepoisChavetaFechada=0;
        
        While_EP WhileEp = new While_EP(aux1,aux2, WhileLinhasEmBrancoDepoisChavetaAberta, WhileLinhasEmBrancoDepoisChavetaFechada,WhileEspacosWhileParentesAberto, WhileEspacosParentesesAbertoCondicao, WhileEspacosCondicaoParentesFechado);
        
        //operador
        
        Operador_EP OperadorEp=new Operador_EP(OperadorEspacosOperadorVariavel,OperadorEspacosVariavelOperador);
        
        //if
        
        If_EP IfEp = null;
        
        //else
        
        Else_EP ElseEp = null;
        
        //cats
        
        Cast_EP CastEp = null;
        
        //doWhile
        
        DoWhile_EP DoWhileEp = null;
        
        //for
        
        For_EP ForEp = null;
        
        //funcoes
        
        Funcoes_EP FuncoesEp = null;
        
        return new EstiloProgramacao(NomeEstilo, CastEp, DoWhileEp, ElseEp, ForEp, FuncoesEp, IfEp, OperadorEp, WhileEp);
    }
        
}
