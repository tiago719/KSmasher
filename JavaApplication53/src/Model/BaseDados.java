package Model;



import java.sql.*;


public class BaseDados {

    private Connection Con;
    private Statement St;
    private ResultSet Rs;
    private String BDName = "ksmasherdb";
    private String User = "root";
    private String Pass = "";
    private boolean Operacional = false;
    public BaseDados()
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            
            Con = DriverManager.getConnection("jdbc:mysql://localhost/" + BDName,User,Pass);
            St = Con.createStatement();
            Operacional = true;
        }catch(Exception ex)
        {
            System.out.println("Erro: " + ex);
            Operacional = false;
        }
    }

    public boolean isOperacional() {
        return Operacional;
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
