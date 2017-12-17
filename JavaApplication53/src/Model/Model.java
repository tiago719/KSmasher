package Model;

import static Model.Constantes.DIRETORIA_DESTINO;
import Model.EstiloProgramacao.EstiloProgramacao;
import Model.Statement.Statement;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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
    
    public void Analisa(String NomeFicheiro, boolean Permite, String NomeEstilo) 
    {
        Ficheiros F=new Ficheiros();
        BufferedReader in=null;
        in = F.abreFObjectosLeitura(NomeFicheiro);
        
        Texto Texto=new Texto(in, null);
        Texto.ComecaCataloga();
        Texto.ComecaAnalisa();
        
        ArrayList<Statement> codigo=Texto.getListaStatements();
        Medias Medias=new Medias();
        Utilizador.NovoEstilo(Medias.NovoEstilo(codigo, NomeEstilo, Permite));
    }
    
    private void listaDiretoria(String NomeDiretoria, String DiretoriaDestino,String NomeEstilo)
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
                        ConverteFicheiro(file.getName(), proxDiretoria, NomeDiretoria, NomeEstilo);
                    else
                        CopiaFicheiro(file.getName(), proxDiretoria, NomeDiretoria);
                } catch (IOException ex) {
                    
                }
            }
            else if(file.isDirectory())
            {  
                listaDiretoria(file.getAbsolutePath(), proxDiretoria + "//"+ file.getName(), NomeEstilo);
            }
        }      
    }
    
    public void ConverteFicheiro(String Nome, String DiretoriaDestino, String DiretoriaAtual,String NomeEstilo)
    {
        Ficheiros F=new Ficheiros();
        File source = new File(DiretoriaAtual + Nome);
        
        BufferedReader in=F.abreFObjectosLeitura(source.getName());
        BufferedWriter out = F.abreFObjectosEscrita(DiretoriaDestino+Nome);
        
        Texto Texto=new Texto(in,out);
        Texto.ComecaCataloga();
        
        EstiloProgramacao Estilo=Utilizador.getEstilo(NomeEstilo);
        Texto.ComecaConverte(Estilo);
        
        try
        {
            out.write(Texto.toString());
        } catch (IOException ex)
        {
            System.out.println("Erro a escrever para o novo ficheiro");
        }
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
    
    public void Converte(String Diretoria, String NomeEstilo, String NomeUtilizador)
    {
        listaDiretoria(Diretoria,DIRETORIA_DESTINO, NomeEstilo);
    }
    
    public ArrayList<EstiloProgramacao> getEstilosUtilizador()
    {
        return Utilizador.getEstilos();
    }
    
    public ArrayList<EstiloProgramacao> UtilizadorEstilos(String NomeUser)
    {
        if(!ExisteUsername(NomeUser))
            return null;
        
        throw new UnsupportedOperationException("Funcionalidade nao implementada");
        //TODO: Verificar se o utilizador tem estilos disponiveis (nao esquecer verificar a flag dos estilos
    }
    
    public String getUtilizadorAtualNome()
    {
        return Utilizador.getUsername();
    }
}
