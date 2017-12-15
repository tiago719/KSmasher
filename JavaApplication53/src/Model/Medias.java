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
import Model.Statement.If;
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
    //if
    ArrayList<Integer> IfEspacosParentesesAbertoCondicaoList=new ArrayList<>();
    ArrayList<Integer> IfEspacosIfParentesAbertoList=new ArrayList<>();
    ArrayList<Integer> IfEspacosCondicaoParentesFechadoList=new ArrayList<>();
    ArrayList<Integer> IfLinhasEmBrancoDepoisChavetaAbertaList=new ArrayList<>();
    ArrayList<Integer> IfLinhasEmBrancoDepoisChavetaFechadaList=new ArrayList<>();
    ArrayList<Integer> IfChavetaUmStatementDentroIfList=new ArrayList<>();
    ArrayList<Integer> IfPrimeiraChavetaNovaLinhaList=new ArrayList<>();
    
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
    
    public void RetiraDadosIf(If S)
    {
        int aux;
        IfEspacosParentesesAbertoCondicaoList.add(S.getEspacosParentesesAbertoCondicao());
        IfEspacosIfParentesAbertoList.add(S.getEspacosIfParentesAberto());
        IfEspacosCondicaoParentesFechadoList.add(((If)S).getEspacosCondicaoParentesFechado());
        if((aux=S.getLinhasEmBrancoDepoisChavetaAberta())!=-1)
            IfLinhasEmBrancoDepoisChavetaAbertaList.add(aux);
        if((aux=S.getLinhasEmBrancoDepoisChavetaFechada())!=-1)
            IfLinhasEmBrancoDepoisChavetaFechadaList.add(aux);
        if((aux=S.isChavetaUmStatementDentroIf())!=-1)
            IfChavetaUmStatementDentroIfList.add(aux);
        if((aux=S.getPrimeiraChavetaNovaLinha())!=-1)
            IfPrimeiraChavetaNovaLinhaList.add(aux);
    }
    
    public void FazMediaIf()
    {
        int total=0;
        for(int i=0;i<IfEspacosParentesesAbertoCondicaoList.size();i++)
        {
            total+=IfEspacosParentesesAbertoCondicaoList.get(i);
        }
        try
        {
            IfEspacosParentesesAbertoCondicao=total/IfEspacosParentesesAbertoCondicaoList.size();
        }
        catch(IllegalArgumentException e)
        {
            IfEspacosParentesesAbertoCondicao=0;
        }
        
        total=0;
        
        for(int i=0;i<IfEspacosIfParentesAbertoList.size();i++)
        {
            total+=IfEspacosIfParentesAbertoList.get(i);
        }
        try
        {
            IfEspacosIfParentesAberto=total/IfEspacosIfParentesAbertoList.size();
        }
        catch(IllegalArgumentException e)
        {
            IfEspacosIfParentesAberto=0;
        }
        
        total=0;
        
        for(int i=0;i<IfEspacosCondicaoParentesFechadoList.size();i++)
        {
            total+=IfEspacosCondicaoParentesFechadoList.get(i);
        }
        try
        {
            IfEspacosCondicaoParentesFechado=total/IfEspacosCondicaoParentesFechadoList.size();
        }
        catch(IllegalArgumentException e)
        {
            IfEspacosCondicaoParentesFechado=0;
        }
        total=0;
        
        for(int i=0;i<IfLinhasEmBrancoDepoisChavetaAbertaList.size();i++)
        {
            total+=IfLinhasEmBrancoDepoisChavetaAbertaList.get(i);
        }
        
        try
        {
            IfLinhasEmBrancoDepoisChavetaAberta=total/IfLinhasEmBrancoDepoisChavetaAbertaList.size();
        }
        catch(IllegalArgumentException e)
        {
            IfLinhasEmBrancoDepoisChavetaAberta=0;
        }
        total=0;
        
        for(int i=0;i<IfLinhasEmBrancoDepoisChavetaFechadaList.size();i++)
        {
            total+=IfLinhasEmBrancoDepoisChavetaFechadaList.get(i);
        }
        
        try
        {
            IfLinhasEmBrancoDepoisChavetaFechada=total/IfLinhasEmBrancoDepoisChavetaFechadaList.size();
        }
        catch(IllegalArgumentException e)
        {
            IfLinhasEmBrancoDepoisChavetaFechada=0;
        }
        total=0;
        
        for(int i=0;i<IfChavetaUmStatementDentroIfList.size();i++)
        {
            total+=IfChavetaUmStatementDentroIfList.get(i);
        }
        
        try
        {
            IfChavetaUmStatementDentroIf=total/IfChavetaUmStatementDentroIfList.size();
        }
        catch(IllegalArgumentException e)
        {
            IfChavetaUmStatementDentroIf=0;
        }
        total=0;
        
        for(int i=0;i<IfPrimeiraChavetaNovaLinhaList.size();i++)
        {
            total+=IfPrimeiraChavetaNovaLinhaList.get(i);
        }
        try
        {
            IfPrimeiraChavetaNovaLinha=total/IfPrimeiraChavetaNovaLinhaList.size();
        }
        catch(IllegalArgumentException e)
        {
            IfPrimeiraChavetaNovaLinha=0;
        }
    }
    
    public void FazMediaWhile()
    {
        int total=0;
        for(int i=0;i<WhileEspacosParentesesAbertoCondicaoList.size();i++)
        {
            total+=WhileEspacosParentesesAbertoCondicaoList.get(i);
        }
        try
        {
            WhileEspacosParentesesAbertoCondicao=total/WhileEspacosParentesesAbertoCondicaoList.size();
        }
        catch(IllegalArgumentException e)
        {
            WhileEspacosParentesesAbertoCondicao=0;
        }
        
        total=0;
        
        for(int i=0;i<WhileEspacosWhileParentesAbertoList.size();i++)
        {
            total+=WhileEspacosWhileParentesAbertoList.get(i);
        }
        
        try
        {
            WhileEspacosWhileParentesAberto=total/WhileEspacosWhileParentesAbertoList.size();
        }
        catch(IllegalArgumentException e)
        {
            WhileEspacosWhileParentesAberto=0;
        }
        total=0;
        
        for(int i=0;i<WhileEspacosCondicaoParentesFechadoList.size();i++)
        {
            total+=WhileEspacosCondicaoParentesFechadoList.get(i);
        }
        try
        {
            WhileEspacosCondicaoParentesFechado=total/WhileEspacosCondicaoParentesFechadoList.size();
        }
        catch(IllegalArgumentException e)
        {
            WhileEspacosCondicaoParentesFechado=0;
        }
        total=0;
        
        for(int i=0;i<WhileLinhasEmBrancoDepoisChavetaAbertaList.size();i++)
        {
            total+=WhileLinhasEmBrancoDepoisChavetaAbertaList.get(i);
        }
        try
        {
            WhileLinhasEmBrancoDepoisChavetaAberta=total/WhileLinhasEmBrancoDepoisChavetaAbertaList.size();
        }
        catch(IllegalArgumentException e)
        {
            WhileLinhasEmBrancoDepoisChavetaAberta=0;
        }
        total=0;
        
        for(int i=0;i<WhileLinhasEmBrancoDepoisChavetaFechadaList.size();i++)
        {
            total+=WhileLinhasEmBrancoDepoisChavetaFechadaList.get(i);
        }
        try
        {
            WhileLinhasEmBrancoDepoisChavetaFechada=total/WhileLinhasEmBrancoDepoisChavetaFechadaList.size();
        }
        catch(IllegalArgumentException e)
        {
            WhileLinhasEmBrancoDepoisChavetaFechada=0;
        }
        total=0;
        
        for(int i=0;i<WhileChavetaUmStatementDentroWhileList.size();i++)
        {
            total+=WhileChavetaUmStatementDentroWhileList.get(i);
        }
        
        try
        {
            WhileChavetaUmStatementDentroWhile=total/WhileChavetaUmStatementDentroWhileList.size();
        }
        catch(IllegalArgumentException e)
        {
            WhileChavetaUmStatementDentroWhile=0;
        }
        total=0;
        
        for(int i=0;i<WhilePrimeiraChavetaNovaLinhaList.size();i++)
        {
            total+=WhilePrimeiraChavetaNovaLinhaList.get(i);
        }
        try
        {
            WhilePrimeiraChavetaNovaLinha=total/WhilePrimeiraChavetaNovaLinhaList.size();
        }
        catch(IllegalArgumentException e)
        {
            WhilePrimeiraChavetaNovaLinha=0;
        }
    }
    
    public void FazMediasOperador()
    {
        int total=0;
        
        for(int i=0;i<OperadorEspacosOperadorVariavelList.size();i++)
        {
            total+=OperadorEspacosOperadorVariavelList.get(i);
        }
        try
        {
            OperadorEspacosOperadorVariavel=total/OperadorEspacosOperadorVariavelList.size();
        }
        catch(IllegalArgumentException e)
        {
            OperadorEspacosOperadorVariavel=0;
        }
        total=0;
        
        for(int i=0;i<OperadorEspacosVariavelOperadorList.size();i++)
        {
            total+=OperadorEspacosVariavelOperadorList.get(i);
        }
        try
        {
            OperadorEspacosVariavelOperador=total/OperadorEspacosVariavelOperadorList.size();
        }
        catch(IllegalArgumentException e)
        {
            OperadorEspacosVariavelOperador=0;
        }
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
            else if(S instanceof If)
                RetiraDadosIf((If) S);
        }
        
        FazMediaWhile();
        FazMediasOperador();
        FazMediaIf();
    }
    
    public EstiloProgramacao NovoEstilo(ArrayList<Statement> Codigo, String NomeEstilo, boolean Permite)
    {
        fazMedias(Codigo);
        
        //while
        
        boolean aux1, aux2;
        aux1 = WhilePrimeiraChavetaNovaLinha==1;
        
        aux2 = WhileChavetaUmStatementDentroWhile==1;
        
        if(WhileLinhasEmBrancoDepoisChavetaAberta<0)
            WhileLinhasEmBrancoDepoisChavetaAberta=0;
        
        if(WhileLinhasEmBrancoDepoisChavetaFechada<0)
            WhileLinhasEmBrancoDepoisChavetaFechada=0;
        
        While_EP WhileEp = new While_EP(aux1,aux2, WhileLinhasEmBrancoDepoisChavetaAberta, WhileLinhasEmBrancoDepoisChavetaFechada,WhileEspacosWhileParentesAberto, WhileEspacosParentesesAbertoCondicao, WhileEspacosCondicaoParentesFechado);
        
        //operador
        
        Operador_EP OperadorEp=new Operador_EP(OperadorEspacosOperadorVariavel,OperadorEspacosVariavelOperador);
        
        //if
        aux1 = IfPrimeiraChavetaNovaLinha==1;
        
        aux2 = IfChavetaUmStatementDentroIf==1;
        
        if(IfLinhasEmBrancoDepoisChavetaAberta<0)
            IfLinhasEmBrancoDepoisChavetaAberta=0;
        
        if(IfLinhasEmBrancoDepoisChavetaFechada<0)
            IfLinhasEmBrancoDepoisChavetaFechada=0;
        
        If_EP IfEp = new If_EP(aux1,aux2, IfLinhasEmBrancoDepoisChavetaAberta, IfLinhasEmBrancoDepoisChavetaFechada,IfEspacosIfParentesAberto, IfEspacosParentesesAbertoCondicao, IfEspacosCondicaoParentesFechado);
        
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
        
        return new EstiloProgramacao(NomeEstilo,Permite, CastEp, DoWhileEp, ElseEp, ForEp, FuncoesEp, IfEp, OperadorEp, WhileEp);
    }
        
}
