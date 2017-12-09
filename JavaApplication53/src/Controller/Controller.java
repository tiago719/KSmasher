package Controller;

import Model.Model;
import java.io.FileInputStream;
import java.util.Observable;

public class Controller extends Observable
{
    private Model Model;
    
    public Controller()
    {
        Model=new Model();
    }
       
    public boolean ExisteUsername(String nome)
    {
        return Model.ExisteUsername(nome);
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
        return Model.Login(username, password);
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
