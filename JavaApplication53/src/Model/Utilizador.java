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
    
    public void AdicionaUtilizador(String Nome, String Email, String PalavraChave) throws SQLException
    {
        BaseDados bd = new BaseDados();
        ResultSet Rt;
        
        bd.Modifica("INSERT INTO utilizador(IDUTILIZADOR, NOME, EMAIL, PASSWORD) VALUES ( null,'" + Nome +"','" + Email + "','" +PalavraChave + "');");
        
        Rt = bd.Le("SELECT * FROM utilizadores;");
        
        while(Rt.next())
        {
            String nome = Rt.getString("NOME");
            
        }
        
        bd.CloseConnection();
    }
}
