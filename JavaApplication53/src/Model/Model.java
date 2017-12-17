/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import static Model.Constantes.DIRETORIA_DESTINO;
import Model.Statement.Statement;
import Model.Statement.While;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;


public class Model {
    private Utilizador Utilizador;
    private Pesquisas Pesquisas;

    public Model() 
    {
        Pesquisas=new Pesquisas();
    }   
    
    public boolean ExisteUsername(String nome)
    {
        try {
            return Pesquisas.ExisteUsername(nome);
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean ExisteEmail(String email)
    {
        try {
            return Pesquisas.ExisteEmail(email);
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public void Regista(String username, String email, String password)
    {
        Utilizador = new Utilizador();
        Utilizador.AdicionaUtilizador(username, email, password);
        Utilizador.AdicionaEstiloPorDefeito();
       Pesquisas.AdicionaUtilizador(email, email, username);
        
    }
    
    public boolean Login(String username, String password)
    {
        boolean resultado = false;
        try {
            resultado = Pesquisas.VerificaLogin(username, password);
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(!resultado)
            return false;
        else
        {
            try {
                Utilizador=Pesquisas.getUser(username);
            } catch (SQLException ex) {
                Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            }
            Utilizador.AdicionaEstiloPorDefeito();
            return true;
        }
    }
    
    public void Analisa(String NomeFicheiro) 
    {
        Ficheiros F=new Ficheiros();
        BufferedReader in=null;
        in = F.abreFObjectosLeitura(NomeFicheiro);
        
        Texto Texto=new Texto(in, null);
        Texto.ComecaCataloga();
        Texto.ComecaAnalisa();
        
        ArrayList<Statement> codigo=Texto.getListaStatements();
        Medias Medias=new Medias();
        //Utilizador.NovoEstilo(Medias.NovoEstilo(codigo, NomeFicheiro));
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
                try {
                    if(FilenameUtils.getExtension(file.getCanonicalPath()).equals("c"))
                        ConverteFicheiro(file.getName(), proxDiretoria, NomeDiretoria);
                    else
                        CopiaFicheiro(file.getName(), proxDiretoria, NomeDiretoria);
                } catch (IOException ex) {
                    
                }
            }
            else if(file.isDirectory())
            {  
                listaDiretoria(file.getAbsolutePath(), proxDiretoria + "//"+ file.getName());
            }
        }      
    }
    
    public void ConverteFicheiro(String Nome, String DiretoriaDestino, String DiretoriaAtual)
    {
        Ficheiros F=new Ficheiros();
        File source = new File(DiretoriaAtual + Nome);
        
        BufferedReader in=F.abreFObjectosLeitura(source.getName());
        BufferedWriter out = F.abreFObjectosEscrita(DiretoriaDestino+Nome);
        
        Texto Texto=new Texto(in,out);
        Texto.ComecaCataloga();
        Texto.ComecaConverte();
    }
    
    public void CopiaFicheiro(String Nome, String DiretoriaDestino, String DiretoriaAtual)
    {
        File source = new File(DiretoriaAtual + "//" + Nome);
        File dest = new File(DiretoriaDestino + "//" + Nome);
        
        try
        {
            FileUtils.copyFile(source, dest);
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
