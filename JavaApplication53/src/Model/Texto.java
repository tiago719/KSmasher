/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.Statement.Cast;
import Model.Statement.If;
import Model.Statement.Operador;
import Model.Statement.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 *
 * @author Tiago Coutinho
 */
public class Texto
{
    private ArrayList<Statement> ListaStatements;
    Utilizador Utilizador;//TODO:Falta meter aqui o otuilzador
    int ix;
    String Codigo;
    
    public Texto(String Codigo)
    {
        ListaStatements=new ArrayList<Statement>();
        ix=0;
        this.Codigo=Codigo;
    }

    public ArrayList<Statement> getListaStatements() {
        return ListaStatements;
    }
    
    private boolean isIF(char a[]) {
        boolean ret = true;
        if (a[0] == 'i' && a[1] == 'f') {
            ret = true;
        }

        return ret;
    }
    
    private boolean isOperador(char A[])
    {
        if(A[0]=='+' || A[0]=='-')
            return true;
        else if(A[0]=='/' && A[1]!='*')
            return true;
        
        return false;
    }
    
    private boolean isCast(char A[])
    {
        if(A[0]=='(' && A[1]=='i' && A[2]=='n' && A[3]=='t' && A[4]==')')
            return true;
        else if(A[0]=='(' && A[1]=='f' && A[2]=='l' && A[3]=='o' && A[4]=='a' && A[5]=='t' && A[6]==')')
            return true;
        else if(A[0]=='(' && A[1]=='d' && A[2]=='o' && A[3]=='u' && A[4]=='b' && A[5]=='l' && A[6]=='e' && A[7]==')')
            return true;
        else if(A[0]=='(' && A[1]=='c' && A[2]=='h' && A[3]=='a' && A[4]=='r' && A[4]==')')
            return true;
        
        return false;
    }
    
      private boolean IsFOR(char a[]) {
        boolean ret = false;
        if (a[0] == 'f' && a[1] == 'o' && a[2] == 'r') {
            ret = true;
        }
        return ret;
    }

    public void AdicionaNovoPai(PriorityQueue<ArrayList<Statement>> fp, PriorityQueue<Integer> tc, Statement add){
        fp.add(add.getListaStatements());
        tc.add(add.getNumCarateresCodigoStatment() + ix);
    }
    
    public void Cataloga() {
        PriorityQueue<ArrayList<Statement>> filaPais = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> TotalCarateres = new PriorityQueue<>(Collections.reverseOrder());
        ArrayList<Statement> Pai = ListaStatements;
        boolean AspasAberto = false, PlicasAberto = false;

        for (; ix < Codigo.length(); ix++) {
            if (Codigo.charAt(ix) == '"')
                AspasAberto = !AspasAberto;
            else if (Codigo.charAt(ix) == '\'')
                PlicasAberto = !PlicasAberto;
            else if(!AspasAberto && !PlicasAberto){
                try
                {
                    if (isIF(new char[]{Codigo.charAt(ix), Codigo.charAt(ix + 1)})) {
                        If add = new If(Codigo.substring(ix));
                        Pai.add(add);

                        ix += add.getNumComecar();//para comecar a ler depois do if

                        AdicionaNovoPai(filaPais, TotalCarateres, add);

                    }   
                    if(isOperador(new char[]{Codigo.charAt(ix), Codigo.charAt(ix + 1)}))
                    {
                        Operador add=new Operador();
                        char a='a';

                        while(a!=';')
                        {
                            if(ix+1<Codigo.length())
                                a=Codigo.charAt(++ix);
                            else
                                break;
                        }

                        AdicionaNovoPai(filaPais, TotalCarateres, add);
                    }
                    if(isCast(new char[]{Codigo.charAt(ix), Codigo.charAt(ix+1), Codigo.charAt(ix+2), 
                        Codigo.charAt(ix+3), Codigo.charAt(ix+4), Codigo.charAt(ix+5), Codigo.charAt(ix+6),
                        Codigo.charAt(ix+7)}))
                    {
                        Cast add=new Cast();

                        char a='a';

                        while(a!=';')
                        {
                            if(ix+1<Codigo.length())
                                a=Codigo.charAt(++ix);
                            else
                                break;
                        }

                        AdicionaNovoPai(filaPais, TotalCarateres, add);
                    }
                     if (IsFOR(new char[]{Codigo.charAt(ix), Codigo.charAt(ix + 1), Codigo.charAt(ix + 2)})) {
                              For add = new For(Codigo.substring(ix));
                             Pai.add(add);

                              ix += add.getNumComecar();//para comecar a ler depois do if

                              AdicionaNovoPai(filaPais, TotalCarateres, add);
                    }
                }
                catch(Exception e)
                {
                    
                }           
            }
            if (TotalCarateres.peek() != null && TotalCarateres.peek() == ix) {
                TotalCarateres.remove();
                if (filaPais.peek() != ListaStatements) {
                    Pai = filaPais.remove();
                } else {
                    Pai = ListaStatements;
                }
            }
        }
    }
    
    @Override
    public String toString() 
    { 
        String S="";
        for(int i=0;i<ListaStatements.size();i++)
            S+=ListaStatements.get(i).toString();
        return S;
        
        
        
        
        
    } 
}
