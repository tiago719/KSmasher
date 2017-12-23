
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
                                new For_EP(true,true, 1, 1, 0, 1, 0, 1, 0, 1, 1),
                                new Funcoes_EP(false),
                                new If_EP(true,true, 1, 1, 1, 1, 1),
                                new Operador_EP(1, 1),
                                new While_EP(true,true, 1, 1, 1, 1, 1)));

    }

    public void NovoEstilo(EstiloProgramacao EP) {
        Pesquisas p = new Pesquisas();
        if(EP.isPermite())
            p.AdicionaEstilo(EP, this, 1);
        else
            p.AdicionaEstilo(EP, this, 0);
        
        EstilosProgramacao.add(EP);
      
    }   
    
    public ArrayList<EstiloProgramacao> getEstilos()
    {
        return EstilosProgramacao;
    }
    
    public EstiloProgramacao getEstilo(String NomeEstilo)
    {
        if(EstilosProgramacao == null)
        {
            return null;
        }
        for(EstiloProgramacao EP : EstilosProgramacao)
            if(EP.getNome().equals(NomeEstilo))
                return EP;
        return null;
    }
    
     public EstiloProgramacao getEstiloID(int idEstilo)
    {
        for(EstiloProgramacao EP : EstilosProgramacao)
            if(EP.getId() == idEstilo)
                return EP;
        return null;
    }
  
      public Utilizador(int id, String User, String Em, String Pass) {
        IdUtilizador = id;
        Username = User;
        Email = Em;
        Password = Pass;
        Pesquisas p = new Pesquisas();     
        EstilosProgramacao = p.DevolveEstilosProgramacaoUtilizador(IdUtilizador);
        if(EstilosProgramacao == null) EstilosProgramacao = new ArrayList<EstiloProgramacao>();
      }

    public void AdicionaUtilizador(String User, String Em, String Pass) {
        Username = User;
        Email = Em;
        Password = Pass;
    }
}
