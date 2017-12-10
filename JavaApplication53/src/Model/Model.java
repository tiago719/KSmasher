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
import java.util.ArrayList;
import org.apache.commons.io.FileUtils;


public class Model {
    private Utilizador Utilizador;
    private Pesquisas Pesquisas;

    public Model() 
    {

    }   
    
    public boolean ExisteUsername(String nome)
    {
        return Pesquisas.ExisteUsername(nome);
    }
    
    public boolean ExisteEmail(String email)
    {
        return Pesquisas.ExisteEmail(email);
    }
    
    public void Regista(String username, String email, String password)
    {
        Pesquisas.AdicionaUtilizador(email, email, username);
        Utilizador.AdicionaEstiloPorDefeito();
    }
    
    public boolean Login(String username, String password)
    {
        boolean resultado= Pesquisas.VerificaLogin(username, password);
        
        if(!resultado)
            return false;
        else
        {
            Utilizador=Pesquisas.getUser(username);
            Utilizador.AdicionaEstiloPorDefeito();
            return true;
        }
    }
    
    public void Analisa(String NomeFicheiro) 
    {
        Ficheiros F=new Ficheiros();
        BufferedReader in=null;
        in = F.abreFObjectosLeitura(NomeFicheiro);
        
        Texto Texto=new Texto(in);
        Texto.ComecaCataloga();
        Texto.ComecaAnalisa();
        
        ArrayList<Statement> codigo=Texto.getListaStatements();
        Medias Medias=new Medias();
        Utilizador.NovoEstilo(Medias.NovoEstilo(codigo, NomeFicheiro));
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
                listaDiretoria(file.getAbsolutePath(), proxDiretoria + "//"+ file.getName());
            }
        }      
    }
    
    public void ConverteFicheiro(String Nome, String DiretoriaDestino, String DiretoriaAtual)
    {
        Ficheiros F=new Ficheiros();
        File source = new File(DiretoriaAtual + Nome);
        
        BufferedWriter out = F.abreFObjectosEscrita(DiretoriaDestino+Nome);
        
        Texto Texto=new Texto(out);
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
