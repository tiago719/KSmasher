/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.BufferedReader;


public class Model {
    private Texto Texto;
    private Utilizador Utilizador;
    private OperadoresLibrary OperadoresLibrary; 

    public Model() 
    {
        OperadoresLibrary=new OperadoresLibrary();
    }   
    
    public void Regista()
    {
        
    }
    
    public void Login()
    {
        
    }
    
    public void Analisa(String NomeFicheiro) 
    {
        Ficheiros F=new Ficheiros();
        BufferedReader in=null;
        try
        {
            in = F.abreFObjectosLeitura(NomeFicheiro);
        } catch (Exception ex)
        {
            return;
        }
        Texto=new Texto(in, OperadoresLibrary);
        Texto.Cataloga();
        Texto.fazMedia();
    }
    
    public void Converte()
    {
        
    }
}
