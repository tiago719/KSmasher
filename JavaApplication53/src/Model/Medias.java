/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.Statement.Statement;
import Model.Statement.While;
import Model.Statement.Else;
import Model.Statement.DoWhile;
import java.util.ArrayList;

/**
 *
 * @author Tiago Coutinho
 */
public class Medias
{
    //while
    ArrayList<Integer> WhilesEspacosParentesesAbertoCondicao=new ArrayList<>();
    ArrayList<Integer> WhilesEspacosWhileParentesAberto=new ArrayList<>();
    ArrayList<Integer> WhilesEspacosCondicaoParentesFechado=new ArrayList<>();
    ArrayList<Integer> WhilesLinhasEmBrancoDepoisChavetaAberta=new ArrayList<>();
    ArrayList<Integer> WhilesLinhasEmBrancoDepoisChavetaFechada=new ArrayList<>();
    ArrayList<Integer> WhilesChavetaUmStatementDentroWhile=new ArrayList<>();
    ArrayList<Integer> WhilesPosicaoPrimeiraChaveta=new ArrayList<>();
    
    //while
    int EspacosParentesesAbertoCondicao;
    int EspacosWhileParentesAberto;
    int EspacosCondicaoParentesFechado;
    int LinhasEmBrancoDepoisChavetaAberta;
    int LinhasEmBrancoDepoisChavetaFechada;
    int ChavetaUmStatementDentroWhile;
    int PosicaoPrimeiraChaveta;
    
    //else
    
    ArrayList<Integer> ElsesLinhasEmBrancoEntreIfElse=new ArrayList<>();
    ArrayList<Integer> ElsesLinhasEmBrancoDepoisChavetaAberta=new ArrayList<>();
    ArrayList<Integer> ElsesLinhasEmBrancoDepoisChavetaFechada=new ArrayList<>();
    ArrayList<Integer> ElsesPosicaoPrimeiraChaveta=new ArrayList<>();
    
    //else
    
    int ElseLinhasEmBrancoEntreIfElse;
    int ElseLinhasEmBrancoDepoisChavetaAberta;
    int ElseLinhasEmBrancoDepoisChavetaFechada;
    int ElsePosicaoPrimeiraChaveta;
    
    //do-while
    
    ArrayList<Integer> DoWhilesLinhasEmBrancoDepoisChavetaAberta=new ArrayList<>();
    ArrayList<Integer> DoWhilesLinhasEmBrancoDepoisChavetaFechada=new ArrayList<>();
    ArrayList<Integer> DoWhilesLinhasEmBrancoEntreChavetaFechadaWhile=new ArrayList<>();
    ArrayList<Integer> DoWhilesEspacosWhileParentesesAberto=new ArrayList<>();
    ArrayList<Integer> DoWhilesEspacosParentesesAbertoCondicao=new ArrayList<>();
    ArrayList<Integer> DoWhilesEspacosCondicaoParentesFechado=new ArrayList<>();
    ArrayList<Integer> DoWhilesPosicaoPrimeiraChaveta=new ArrayList<>();
    
    
    //do-while
    
    int DoWhileLinhasEmBrancoDepoisChavetaAberta;
    int DoWhileLinhasEmBrancoDepoisChavetaFechada;
    int DoWhileLinhasEmBrancoEntreChavetaFechadaWhile;
    int DoWhileEspacosWhileParentesesAberto;
    int DoWhileEspacosParentesesAbertoCondicao;
    int DoWhileEspacosCondicaoParentesFechado;
    int DoWhilePosicaoPrimeiraChaveta;
    
    public Medias(){}
    
    public void fazMedias(ArrayList<Statement> Codigo)
    {
        int aux, total=0;
        for(int i=0;i<Codigo.size();i++)
        {
            if(Codigo.get(i).hasFilhos())
                fazMedias(Codigo.get(i).getStatmentsFilhos());
            
            if(Codigo.get(i) instanceof While)
            {
                WhilesEspacosParentesesAbertoCondicao.add(((While)Codigo.get(i)).getEspacosParentesesAbertoCondicao());
                WhilesEspacosWhileParentesAberto.add(((While)Codigo.get(i)).getEspacosWhileParentesAberto());
                WhilesEspacosCondicaoParentesFechado.add(((While)Codigo.get(i)).getEspacosCondicaoParentesFechado());
                WhilesLinhasEmBrancoDepoisChavetaAberta.add(((While)Codigo.get(i)).getLinhasEmBrancoDepoisChavetaAberta());
                WhilesLinhasEmBrancoDepoisChavetaFechada.add(((While)Codigo.get(i)).getLinhasEmBrancoDepoisChavetaFechada());
                if((aux=((While)Codigo.get(i)).isChavetaUmStatementDentroWhile())!=-1)
                    WhilesChavetaUmStatementDentroWhile.add(aux);
                if((aux=((While)Codigo.get(i)).isPosicaoPrimeiraChaveta())!=-1)
                    WhilesPosicaoPrimeiraChaveta.add(aux);
            }
            if(Codigo.get(i) instanceof Else)
            {
                ElsesLinhasEmBrancoEntreIfElse.add(((Else)Codigo.get(i)).getLinhasEmBrancoEntreIfElse());
                ElsesLinhasEmBrancoDepoisChavetaAberta.add(((Else)Codigo.get(i)).getLinhasEmBrancoDepoisChavetaAberta());
                ElsesLinhasEmBrancoDepoisChavetaFechada.add(((Else)Codigo.get(i)).getLinhasEmBrancoDepoisChavetaFechada());
                if((aux=((Else)Codigo.get(i)).isPosicaoPrimeiraChaveta())!=-1)
                    ElsesPosicaoPrimeiraChaveta.add(aux);              
            }
            if(Codigo.get(i) instanceof DoWhile)
            {
                DoWhilesLinhasEmBrancoDepoisChavetaAberta.add(((DoWhile)Codigo.get(i)).getLinhasEmBrancoDepoisChavetaAberta());
                DoWhilesLinhasEmBrancoDepoisChavetaFechada.add(((DoWhile)Codigo.get(i)).getLinhasEmBrancoDepoisChavetaFechada());
                DoWhilesLinhasEmBrancoEntreChavetaFechadaWhile.add(((DoWhile)Codigo.get(i)).getLinhasEmBrancoEntreChavetaFechadaWhile());
                DoWhilesEspacosWhileParentesesAberto.add(((DoWhile)Codigo.get(i)).getEspacosWhileParentesesAberto());
                DoWhilesEspacosParentesesAbertoCondicao.add(((DoWhile)Codigo.get(i)).getEspacosParentesesAbertoCondicao());
                DoWhilesEspacosCondicaoParentesFechado.add(((DoWhile)Codigo.get(i)).getEspacosCondicaoParentesFechado());
                if((aux=((DoWhile)Codigo.get(i)).isPosicaoPrimeiraChaveta())!=-1)
                    DoWhilesPosicaoPrimeiraChaveta.add(aux);                
            }
        }
        
        for(int i=0;i<WhilesEspacosParentesesAbertoCondicao.size();i++)
        {
            total+=WhilesEspacosParentesesAbertoCondicao.get(i);
        }
        EspacosParentesesAbertoCondicao=total/WhilesEspacosParentesesAbertoCondicao.size();
        
        total=0;
        
        for(int i=0;i<WhilesEspacosWhileParentesAberto.size();i++)
        {
            total+=WhilesEspacosWhileParentesAberto.get(i);
        }
        EspacosWhileParentesAberto=total/WhilesEspacosWhileParentesAberto.size();
        
        total=0;
        
        for(int i=0;i<WhilesEspacosCondicaoParentesFechado.size();i++)
        {
            total+=WhilesEspacosCondicaoParentesFechado.get(i);
        }
        EspacosCondicaoParentesFechado=total/WhilesEspacosCondicaoParentesFechado.size();
        
        total=0;
        
        for(int i=0;i<WhilesLinhasEmBrancoDepoisChavetaAberta.size();i++)
        {
            total+=WhilesLinhasEmBrancoDepoisChavetaAberta.get(i);
        }
        LinhasEmBrancoDepoisChavetaAberta=total/WhilesLinhasEmBrancoDepoisChavetaAberta.size();
        
        total=0;
        
        for(int i=0;i<WhilesLinhasEmBrancoDepoisChavetaFechada.size();i++)
        {
            total+=WhilesLinhasEmBrancoDepoisChavetaFechada.get(i);
        }
        LinhasEmBrancoDepoisChavetaFechada=total/WhilesLinhasEmBrancoDepoisChavetaFechada.size();
        
        total=0;
        
        for(int i=0;i<WhilesChavetaUmStatementDentroWhile.size();i++)
        {
            total+=WhilesChavetaUmStatementDentroWhile.get(i);
        }
        ChavetaUmStatementDentroWhile=total/WhilesChavetaUmStatementDentroWhile.size();
        
        total=0;
        
        for(int i=0;i<WhilesPosicaoPrimeiraChaveta.size();i++)
        {
            total+=WhilesPosicaoPrimeiraChaveta.get(i);
        }
        PosicaoPrimeiraChaveta=total/WhilesPosicaoPrimeiraChaveta.size();
        
        total=0;
        
        for(int i=0; i<ElsesLinhasEmBrancoEntreIfElse.size();i++)
        {
            total+=ElsesLinhasEmBrancoEntreIfElse.get(i);
        }
        ElseLinhasEmBrancoEntreIfElse=total/ElsesLinhasEmBrancoEntreIfElse.size();
        
        total=0;
        
        for(int i=0; i<ElsesLinhasEmBrancoDepoisChavetaAberta.size();i++)
        {
            total+=ElsesLinhasEmBrancoDepoisChavetaAberta.get(i);
        }
        ElseLinhasEmBrancoDepoisChavetaAberta=total/ElsesLinhasEmBrancoDepoisChavetaAberta.size();
        
        total=0;
        
        for(int i=0; i<ElsesLinhasEmBrancoDepoisChavetaFechada.size();i++)
        {
            total+=ElsesLinhasEmBrancoDepoisChavetaFechada.get(i);
        }
        ElseLinhasEmBrancoDepoisChavetaFechada=total/ElsesLinhasEmBrancoDepoisChavetaFechada.size();
        
        total=0;
        
        for(int i=0; i<ElsesPosicaoPrimeiraChaveta.size();i++)
        {
            total+=ElsesPosicaoPrimeiraChaveta.get(i);
        }
        ElsePosicaoPrimeiraChaveta=total/ElsesPosicaoPrimeiraChaveta.size();
        
        total=0;
        
        for(int i=0; i<DoWhilesLinhasEmBrancoDepoisChavetaAberta.size();i++)
        {
            total+=DoWhilesLinhasEmBrancoDepoisChavetaAberta.get(i);
        }
        DoWhileLinhasEmBrancoDepoisChavetaAberta=total/DoWhilesLinhasEmBrancoDepoisChavetaAberta.size();
        
        total=0;
        
        for(int i=0; i<DoWhilesLinhasEmBrancoDepoisChavetaFechada.size();i++)
        {
            total+=DoWhilesLinhasEmBrancoDepoisChavetaFechada.get(i);
        }
        DoWhileLinhasEmBrancoDepoisChavetaFechada=total/DoWhilesLinhasEmBrancoDepoisChavetaFechada.size();
        
        total=0;
        
        for(int i=0; i<DoWhilesLinhasEmBrancoEntreChavetaFechadaWhile.size();i++)
        {
            total+=DoWhilesLinhasEmBrancoEntreChavetaFechadaWhile.get(i);
        }
        DoWhileLinhasEmBrancoEntreChavetaFechadaWhile=total/DoWhilesLinhasEmBrancoEntreChavetaFechadaWhile.size();
        
        total=0;
        
        for(int i=0; i<DoWhilesEspacosWhileParentesesAberto.size();i++)
        {
            total+=DoWhilesEspacosWhileParentesesAberto.get(i);
        }
        DoWhileEspacosWhileParentesesAberto=total/DoWhilesEspacosWhileParentesesAberto.size();
        
        total=0;
        
        for(int i=0; i<DoWhilesEspacosParentesesAbertoCondicao.size();i++)
        {
            total+=DoWhilesEspacosParentesesAbertoCondicao.get(i);
        }
        DoWhileEspacosParentesesAbertoCondicao=total/DoWhilesEspacosParentesesAbertoCondicao.size();
        
        total=0;
        
        for(int i=0; i<DoWhilesEspacosCondicaoParentesFechado.size();i++)
        {
            total+=DoWhilesEspacosCondicaoParentesFechado.get(i);
        }
        DoWhileEspacosCondicaoParentesFechado=total/DoWhilesEspacosCondicaoParentesFechado.size();
        
        total=0;
        
        for(int i=0; i<DoWhilesPosicaoPrimeiraChaveta.size();i++)
        {
            total+=DoWhilesPosicaoPrimeiraChaveta.get(i);
        }
        DoWhilePosicaoPrimeiraChaveta=total/DoWhilesPosicaoPrimeiraChaveta.size();
        
        total=0;
     
    }
        
}
