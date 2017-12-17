/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Statement;

import Model.Texto;

/**
 *
 * @author edu_f
 */
public class Comentario extends Statement {

    /*
    * Tipo true -> //
    * Tipo false -> /*
     */
    boolean TipoComentario;

    public Comentario(String codigo, Texto t) {
        super(codigo, t);
    }

    @Override
    public String RetiraDados(String Codigo, Texto T) {
        int i;
        if (Codigo.charAt(1) == '*') {
            TipoComentario = false;
        } else if (Codigo.charAt(1) == '/') {
            TipoComentario = true;
        }

        if (TipoComentario) {
            for (i = 2; i < Codigo.length(); i++) {
                if (Codigo.charAt(i) == '\r' || Codigo.charAt(i) == '\n') {
                    break;
                }
            }
        } else {
            for (i = 2; i < Codigo.length(); i++) {
                if (Codigo.charAt(i) == '*' && Codigo.charAt(i + 1) == '/') {
                    break;
                }
            }
            i++;
        }

        if (i + 1 > Codigo.length()) {
            this.Codigo = Codigo.substring(0, i);
        } else {
            this.Codigo = Codigo.substring(0, i + 1);
        }
        this.ParaAnalise = null;
        this.NumCarateresAvancar = i;
        return null;
    }

}
