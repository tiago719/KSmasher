/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.Statement.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Model {

    String Codigo;
    int ix;
    ArrayList<Statement> ListaStatements;

    public Model(String codigo, ArrayList<Statement> ListaStatements) {
        this.Codigo = codigo;
        this.ListaStatements = ListaStatements;
        ix = 0;
    }

    private boolean isIF(char a[]) {
        boolean ret;
        if (a[0] == 'i' && a[1] == 'f') {
            ret = true;
        }
        return false;
    }

    public void Cataloga() {
        PriorityQueue<ArrayList<Statement>> filaPais = new PriorityQueue<>(Collections.reverseOrder());
        ArrayList<Statement> Pai = ListaStatements;
        for (; ix < Codigo.length(); ix++) {
            if (isIF(new char[]{Codigo.charAt(ix), Codigo.charAt(ix + 1)})) {
                If add = new If(Codigo.substring(ix));
                Pai.add(add);
                
                Pai.get(ix)
                filaPais.add(Pai);
                ix += add.getNumComecar();

            }
            
            
            if (filaPais.peek().)
            
            
            ArrayList<Statement> temp = filaPais.remove();
            if (temp == null){
                Pai  = temp;
            }
            else{
                Pai = ListaStatements;
            }
        }
    }
}
