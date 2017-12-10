/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

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
    
    public Medias(){}
    
    public void fazMedias(ArrayList<Statement> Codigo)
    {
        int aux, total=0;
        for(int i=0;i<Codigo.size();i++)
        {
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
     
    }
        
}
