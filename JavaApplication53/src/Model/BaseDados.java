package Model;



import java.sql.*;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author André
 */
public class BaseDados {

    private Connection Con;
    private Statement St;
    private ResultSet Rs;
    private String BDName = "ksmasherdb";
    private String User = "root";
    private String Pass = "";
    
    public BaseDados()
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            
            Con = DriverManager.getConnection("jdbc:mysql://localhost/" + BDName,User,Pass);
            St = Con.createStatement();
        }catch(Exception ex)
        {
            System.out.println("Erro: " + ex);
        }
    }
    
    public int Modifica (String q)
    {
        int resposta = 0;
        try{
            resposta = St.executeUpdate(q);
            
            return resposta;
        }catch(Exception ex)
        {
            System.out.println("Erro: " + ex);
        }
        return resposta;
    }
    
    public ResultSet Le(String q)
    {
        try{
            Rs = St.executeQuery(q);
            
            return Rs;
        }catch(Exception ex)
        {
            System.out.println("Erro: " + ex);
        }
        return null;
    }
    public void CloseConnection()
    {
        try {
            Con.close();

        } catch (SQLException e) {

        }
    }
}
