/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.EstiloProgramacao.EstiloProgramacao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
    
    public void novoEstilo()
    {
        
    }
    
    public void AdicionaUtilizador(String Nome, String Email, String PalavraChave)
    {
        BaseDados bd = new BaseDados();

        bd.Modifica("INSERT INTO utilizador(IDUTILIZADOR, NOME, EMAIL, PASSWORD) VALUES ( null,'" + Nome +"','" + Email + "','" +PalavraChave + "');");

        
        bd.CloseConnection();
    }
     public boolean ExisteUsername(String Username) throws SQLException
    {
        BaseDados bd = new BaseDados();
        ResultSet Rt;
        boolean existe;
        
        Rt = bd.Le("SELECT * FROM utilizador WHERE NOME = '" + Username + "'");
        
        if(Rt.next())
            existe= true;
        else
            existe=false;
        
        bd.CloseConnection();
        return existe;  
    }
      public boolean ExisteEmail(String Email) throws SQLException
    {
        BaseDados bd = new BaseDados();
        ResultSet Rt;
        boolean existe;
        
        Rt = bd.Le("SELECT * FROM utilizador WHERE EMAIL = '" + Email + "'");
        
        if(Rt.next())
            existe= true;
        else
            existe=false;
        
        bd.CloseConnection();
        return existe;  
    }
      
      public boolean VerificaLogin(String Username, String Password) throws SQLException
    {
        BaseDados bd = new BaseDados();
        ResultSet Rt;
        boolean existe;
        
        Rt = bd.Le("SELECT * FROM utilizador WHERE NOME = '" + Username + "' and PASSWORD = '" + Password + "'");
        
        if(Rt.next())
            existe= true;
        else
            existe=false;
        
        bd.CloseConnection();
        return existe;  
    }
}
