/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.Statement.*;
import java.util.ArrayList;

/**
 *
 * @author Tiago Coutinho
 */
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
        ArrayList<Statement> Pai = ListaStatements;
        for (; ix < Codigo.length(); ix++) {
            if (isIF(new char[]{Codigo.charAt(ix), Codigo.charAt(ix + 1)})) {
                If add = new If(Codigo.substring(ix));
                Pai.add(add);
                ix += add.getNumComecar();
                
                Pai = add.getListaStatements();
            }

        }
        char a[] = new char[]{'a', 'a'};
    }
}
