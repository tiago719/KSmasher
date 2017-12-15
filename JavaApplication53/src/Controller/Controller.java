package Controller;

import Model.Model;
import java.io.FileInputStream;
import java.util.Observable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller extends Observable
{
    private Model Model;
    
    public Controller()
    {
        Model=new Model();
    }
     //-1: tamanho errado
    //-2: caracteres especiais
    //-3: utilizador ja existe
    //1: utilizador não existe
    public int ExisteUsername(String nome)
    {
        if(nome.length()>15 || nome.length()<7)
            return -1;
        
        Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(nome);
        
        if(m.find())
            return -2;
        
        if(Model.ExisteUsername(nome))
            return 1;
        else 
            return -3;
    }
    
    public boolean ExisteEmail(String email)
    {
        return Model.ExisteEmail(email);
    }
    
    public void Regista(String username, String email, String password)
    {
       Model.Regista(username, email, password);
    }
    
    public boolean Login(String username, String password)
    {
        return false;
        //return Model.Login(username, password);
    }
    
    public void Analisa(String NomeFicheiro)
    {
        Model.Analisa(NomeFicheiro);
    }
    
    public void Converte(String Diretoria)
    {
        Model.Converte(Diretoria);
    }
}
