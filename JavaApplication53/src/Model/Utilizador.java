
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


public class Utilizador
{
    private String Username, Email, Password;
    private int IdUtilizador;
    private ArrayList<EstiloProgramacao> EstilosProgramacao;

    public String getUsername()
    {
        return Username;
    }

    public void setUsername(String Username)
    {
        this.Username = Username;
    }

    public String getEmail()
    {
        return Email;
    }
    
    public int getId()
    {
        return IdUtilizador;
    }

    public void setEmail(String Email)
    {
        this.Email = Email;
    }
    
    public Utilizador(){
        EstilosProgramacao=new ArrayList<EstiloProgramacao>();
    }
    
    public void AdicionaEstiloPorDefeito()
    {
        EstilosProgramacao.add(new EstiloProgramacao(0,"EstiloDefeito",false,
                                new Cast_EP(1),
                                new DoWhile_EP(true, 1, 0, 1, 1, 1),
                                new Else_EP(true, 1, 1),
                                new For_EP(true, 1, 1, 0, 1, 0, 1, 0, 1, 1),
                                new Funcoes_EP(false),
                                new If_EP(true, 1, 1, 1, 1, 1),
                                new Operador_EP(1, 1),
                                new While_EP(true, 1, 1, 1, 1, 1)));

    }

    public void NovoEstilo(EstiloProgramacao EP) {
        EstilosProgramacao.add(EP);

    }   
    
    public ArrayList<EstiloProgramacao> getEstilos()
    {
        return EstilosProgramacao;
    }
    
    public EstiloProgramacao getEstilo(String NomeEstilo)
    {
        for(EstiloProgramacao EP : EstilosProgramacao)
            if(EP.getNome().equals(NomeEstilo))
                return EP;
        return null;
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
}
