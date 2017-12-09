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
public class Utilizador
{
    String Username, Email, Password;
    int IdUtilizador;
    ArrayList<EstiloProgramacao> EstilosProgramacao;
    
    public Utilizador()
    {
        EstilosProgramacao=new ArrayList<EstiloProgramacao>();
    }
    
    public void AdicionaEstiloPorDefeito()
    {
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
    
    public void AdicionaUtilizador(String Nome, String Email, String PalavraChave)
    {
        BaseDados bd = new BaseDados();

        try {
            bd.Modifica("INSERT INTO utilizador(IDUTILIZADOR, NOME, EMAIL, PASSWORD) VALUES ( null,'" + Nome +"','" + Email + "','" +SHA1(PalavraChave) + "');");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Utilizador.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        bd.CloseConnection();
    }
    
       static String SHA1(String input) throws NoSuchAlgorithmException {
        MessageDigest mDigest = MessageDigest.getInstance("SHA1");
        byte[] result = mDigest.digest(input.getBytes());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < result.length; i++) {
            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        }
         
        return sb.toString();
    }
    
     public boolean ExisteUsername(String Username)
    {
        BaseDados bd = new BaseDados();
        ResultSet Rt;
        boolean existe=false;
        
        Rt = bd.Le("SELECT * FROM utilizador WHERE NOME = '" + Username + "'");
        
        try
        {
            existe = Rt.next();
        } catch (SQLException ex)
        {
            Logger.getLogger(Utilizador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        bd.CloseConnection();
        return existe;  
    }
      public boolean ExisteEmail(String Email)
    {
        BaseDados bd = new BaseDados();
        ResultSet Rt;
        boolean existe=false;
        
        Rt = bd.Le("SELECT * FROM utilizador WHERE EMAIL = '" + Email + "'");

        try
        {
            existe = Rt.next();
        } catch (SQLException ex)
        {
            Logger.getLogger(Utilizador.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        bd.CloseConnection();
        return existe;  
    }
      
      public boolean VerificaLogin(String Username, String Password)
    {
        BaseDados bd = new BaseDados();
        ResultSet Rt;
        boolean existe=false;
        
        Rt = bd.Le("SELECT * FROM utilizador WHERE NOME = '" + Username + "' and PASSWORD = '" + Password + "'");
        
        try
        {
            existe = Rt.next();
        } catch (SQLException ex)
        {
            Logger.getLogger(Utilizador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        bd.CloseConnection();
        return existe;  
    }
}
