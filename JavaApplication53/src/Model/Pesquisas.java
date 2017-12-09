/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tiago Coutinho
 */
public class Pesquisas
{
    private BaseDados bd;
    
    public Pesquisas()
    {
        BaseDados bd = new BaseDados();
    }
    public void AdicionaUtilizador(String Nome, String Email, String PalavraChave)
    {
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
      
      public Utilizador getUser(String Username)
      {
          ResultSet Rt=bd.Le("SELECT * FROM utilizador WHERE NOME = '" + Username+ "'");
          return new Utilizador();//TODO: Meter aqui os parametros
      }
}
