/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import static Model.Constantes.DIRETORIA_DESTINO;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.util.ArrayList;
import org.apache.commons.io.FileUtils;


public class Model {
    private Utilizador Utilizador;

    public Model() 
    {

    }   
    
    public boolean ExisteUsername(String nome)
    {
        return Utilizador.ExisteUsername(nome);
    }
    
    public boolean ExisteEmail(String email)
    {
        return Utilizador.ExisteEmail(email);
    }
    
    public void Regista(String username, String email, String password)
    {
        Utilizador.AdicionaUtilizador(email, email, username);
        Utilizador.AdicionaEstiloPorDefeito();
    }
    
    public boolean Login(String username, String password)
    {
        return Utilizador.VerificaLogin(username, password);
    }
    
    public void Analisa(String NomeFicheiro) 
    {
        Ficheiros F=new Ficheiros();
        BufferedReader in=null;
        in = F.abreFObjectosLeitura(NomeFicheiro);
        
        Texto Texto=new Texto(in);
    }
    
    private void listaDiretoria(String NomeDiretoria, String DiretoriaDestino)
    {
        String proxDiretoria=DiretoriaDestino;
        File Diretoria=new File(NomeDiretoria);
        
        File[] fList=Diretoria.listFiles();
        
        for(File file : fList)
        {
            if(file.isFile())
            {
                if(file.getName().contains(".c"))
                    ConverteFicheiro(file.getName(), proxDiretoria, NomeDiretoria);
                else
                    CopiaFicheiro(file.getName(), proxDiretoria, NomeDiretoria);
            }
            else if(file.isDirectory())
            {  
                listaDiretoria(file.getName(), file.getAbsolutePath());
            }
        }      
    }
    
    public void ConverteFicheiro(String Nome, String DiretoriaDestino, String DiretoriaAtual)
    {
        Ficheiros F=new Ficheiros();
        File source = new File(DiretoriaAtual + Nome);
        
        BufferedWriter out = F.abreFObjectosEscrita(DiretoriaDestino+Nome);
        
        Texto Texto=new Texto(out);
    }
    
    public void CopiaFicheiro(String Nome, String DiretoriaDestino, String DiretoriaAtual)
    {
        File source = new File(DiretoriaAtual + Nome);
        File dest = new File(DiretoriaDestino + "//" + Nome);
        
        try
        {
            FileUtils.copyDirectory(source, dest);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public void Converte(String Diretoria)
    {
        listaDiretoria(Diretoria,DIRETORIA_DESTINO);
    }
}
