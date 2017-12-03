/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.Statement.*;
import java.util.ArrayList;
import java.util.Collections;
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
        boolean ret = false;
        if (a[0] == 'i' && a[1] == 'f') {
            ret = true;
        }
        return ret;
    }

    public void AdicionaNovoPai(PriorityQueue<ArrayList<Statement>> fp, PriorityQueue<Integer> tc, Statement add) {
        fp.add(add.getListaStatements());
        tc.add(add.getNumCarateresCodigoStatment() + ix);
    }

    public void Cataloga() {
        PriorityQueue<ArrayList<Statement>> filaPais = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> TotalCarateres = new PriorityQueue<>(Collections.reverseOrder());
        ArrayList<Statement> Pai = ListaStatements;
        boolean AspasAberto = false, PlicasAberto = false;

        for (; ix < Codigo.length(); ix++) {
            if (Codigo.charAt(ix) == '"') {
                AspasAberto = !AspasAberto;
            } else if (Codigo.charAt(ix) == '\'') {
                PlicasAberto = !PlicasAberto;
            } else if (!AspasAberto && !PlicasAberto) {
                try {
                    if (isIF(new char[]{Codigo.charAt(ix), Codigo.charAt(ix + 1)})) {
                        If add = new If(Codigo.substring(ix));
                        Pai.add(add);

                        ix += add.getNumComecar();//para comecar a ler depois do if

                        AdicionaNovoPai(filaPais, TotalCarateres, add);

                    }
                } catch (Exception e) {

                }
            }

            if (TotalCarateres.peek() != null && TotalCarateres.peek() >= ix) {
                TotalCarateres.remove();
                if (filaPais.peek() != ListaStatements) {
                    Pai = filaPais.remove();
                } else {
                    Pai = ListaStatements;
                }
            }
        }
    }
}
