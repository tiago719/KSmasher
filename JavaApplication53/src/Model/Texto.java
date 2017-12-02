/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.Statement.Statement;
import java.util.ArrayList;

/**
 *
 * @author Tiago Coutinho
 */
public class Texto
{
    private ArrayList<Statement> ListaStatements;
    Utilizador Utilizador;
    
    public Texto()
    {
        ListaStatements=new ArrayList<Statement>();
    }

    public ArrayList<Statement> getListaStatements() {
        return ListaStatements;
    }
    
    
}
