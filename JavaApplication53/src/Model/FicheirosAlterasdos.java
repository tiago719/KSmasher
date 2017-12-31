/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Color;

/**
 *
 * @author andre
 */
public class FicheirosAlterasdos {
    String nome;
    String caminho;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCaminho(String c) {
        this.caminho = c;
    }

    public FicheirosAlterasdos(String nome, String caminho) {
        this.nome = nome;
        this.caminho = caminho;
    }

    public String getNome() {
        return nome;
    }

    public String getCaminho() {
        return caminho;
    }
}
