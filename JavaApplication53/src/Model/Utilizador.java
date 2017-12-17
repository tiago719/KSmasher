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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tiago Coutinho
 */
public class Utilizador {

    String Username, Email, Password;
    int IdUtilizador;
    ArrayList<EstiloProgramacao> EstilosProgramacao;

    public Utilizador() {
        EstilosProgramacao = new ArrayList<EstiloProgramacao>();
    }

    public Utilizador(String User, String Em, String Pass) {
        Username = User;
        Email = Em;
        Password = Pass;
    }

    public void AdicionaUtilizador(String User, String Em, String Pass) {
        Username = User;
        Email = Em;
        Password = Pass;
    }

    public void AdicionaEstiloPorDefeito() {
        EstilosProgramacao.add(new EstiloProgramacao("EstiloDefeito",
                new Cast_EP(1),
                new DoWhile_EP(true, 1, 0, 0, 1, 1, 1),
                new Else_EP(true, 1, 1, 1),
                new For_EP(true, false, 1, 1, 0, 1, 0, 1, 0, 1, 1),
                new Funcoes_EP(false),
                new If_EP(true, false, 1, 1, 1, 1, 1),
                new Operador_EP(1, 1),
                new While_EP(true, false, 1, 1, 1, 1, 1)));
    }

    public void NovoEstilo(EstiloProgramacao EP) {
        EstilosProgramacao.add(EP);
    }
}
