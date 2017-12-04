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
            
    public void Regista()
    {
        
    }
    
    public void Login()
    {
        
    }
    
    public void Analisa(String NomeFicheiro)
    {
        Model.Analisa(NomeFicheiro);
    }
    
    public void Converte()
    {
        
    }
}
