/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.EstiloProgramacao.EstiloProgramacao;
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
}
