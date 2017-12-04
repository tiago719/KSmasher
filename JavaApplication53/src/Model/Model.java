/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.Statement.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Model {
    private Texto Texto;
    private Utilizador Utilizador;

    public Model() 
    {
        
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
        ObjectInputStream in=null;
        String Codigo=null;
        try
        {
            in = F.abreFObjectosLeitura(NomeFicheiro);
            Codigo=(String)in.readObject();
        } catch (Exception ex)
        {
            return;
        }
        Texto=new Texto(Codigo);
        Texto.Cataloga();
        System.out.println(Texto);
    }
    
    public void Converte()
    {
        
    }
}
