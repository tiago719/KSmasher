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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.tree.DefaultMutableTreeNode;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import Model.FicheirosAlterasdos;
import java.awt.Color;

public class Model {

    private Utilizador Utilizador;
    private Pesquisas Pesquisas;
    String Diretoria;
    String DiretoriaDestino;

    public void LimpaDiretoria() {
        Diretoria = null;
        DiretoriaDestino = null;
    }

    public String getDiretoria() {
        return Diretoria;
    }

    public String getDiretoriaDestino() {
        return DiretoriaDestino;
    }

    public Model() {
        Utilizador = new Utilizador();
        Pesquisas = new Pesquisas();
    }

    public boolean ExisteUsername(String nome) {
        try {
            return Pesquisas.ExisteUsername(nome);
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean ExisteEmail(String email) {
        try {
            return Pesquisas.ExisteEmail(email);
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void Regista(String username, String email, String password) {
        Utilizador = new Utilizador();
        Utilizador.AdicionaUtilizador(username, email, password);
        Utilizador.AdicionaEstiloPorDefeito();
        Pesquisas.AdicionaUtilizador(username, email, password);

    }

    public String DevolveFicheiroAntigo(String Caminho, String Nome) {
        Ficheiros F = new Ficheiros();
        File source = new File(Caminho + "//" + Nome + ".c");

        BufferedReader in = null;

        try {
            in = F.abreFObjectosLeitura(source.getCanonicalPath());
        } catch (IOException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            return org.apache.commons.io.IOUtils.toString(in);
        } catch (IOException ex) {
            return null;
        }
    }

    public boolean Login(String username, String password) {
        boolean resultado = false;
        try {
            resultado = Pesquisas.VerificaLogin(username, password);
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (!resultado) {
            return false;
        } else {
            try {
                Utilizador = Pesquisas.getUser(username);
            } catch (SQLException ex) {
                Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            }
            Utilizador.AdicionaEstiloPorDefeito(); 

            return true;
        }
    }

    public void Analisa(String NomeFicheiro, boolean Permite, String NomeEstilo) {
        Ficheiros F = new Ficheiros();
        BufferedReader in = null;
        in = F.abreFObjectosLeitura(NomeFicheiro);

        Texto Texto = new Texto(in, null);
        Texto.ComecaCataloga();
        Texto.ComecaAnalisa();

        ArrayList<Statement> codigo = Texto.getListaStatements();
        Medias Medias = new Medias();
        Utilizador.NovoEstilo(Medias.NovoEstilo(codigo, NomeEstilo, Permite));
    }

    private void listaDiretoria(String NomeDiretoria, String DiretoriaDestino, int IdEstilo) {
        if (this.DiretoriaDestino == null || this.Diretoria == null) {
            this.DiretoriaDestino = DiretoriaDestino;
            this.Diretoria = NomeDiretoria;
        }

        String proxDiretoria = DiretoriaDestino;
        File Diretoria = new File(NomeDiretoria);
        File someFile=new File(DiretoriaDestino);
        someFile.mkdir();

        File[] fList = Diretoria.listFiles();
        for (File file : fList) {
            if (file.isFile()) {

                try {
                    if (FilenameUtils.getExtension(file.getCanonicalPath()).equals("c")) {
                        ConverteFicheiro(file.getName(), proxDiretoria, NomeDiretoria, IdEstilo);
                    } else {
                        CopiaFicheiro(file.getName(), proxDiretoria, NomeDiretoria);
                    }
                } catch (IOException ex) {

                }
            } else if (file.isDirectory()) {
                listaDiretoria(file.getAbsolutePath(), proxDiretoria + "//" + file.getName(), IdEstilo);
            }

        }
    }

    public ArrayList<FicheirosAlterasdos> DevolveListaFicheiros() {
        return DevolveListaCamdada(Diretoria, DiretoriaDestino);
    }

    private ArrayList<FicheirosAlterasdos> DevolveListaCamdada(String NomeDiretoria, String DiretoriaDestino) {
        if (this.DiretoriaDestino == null || this.Diretoria == null) {
            this.DiretoriaDestino = DiretoriaDestino;
            this.Diretoria = NomeDiretoria;
        }
        if (NomeDiretoria == null || DiretoriaDestino == null) {
            return null;
        }
        String proxDiretoria = DiretoriaDestino;
        File fDiretoria = new File(NomeDiretoria);
        DefaultMutableTreeNode root;
        ArrayList<FicheirosAlterasdos> array = new ArrayList<>();

        File[] fList = fDiretoria.listFiles();
        for (File file : fList) {
            if (file.isFile()) {
                try {
                    if (FilenameUtils.getExtension(file.getCanonicalPath()).equals("c")) {
                        array.add(new FicheirosAlterasdos(FilenameUtils.getBaseName(file.getCanonicalPath()), FilenameUtils.getFullPath(file.getCanonicalPath())));
                    } else {
                        // array.add(new FicheirosAlterasdos(FilenameUtils.getBaseName(file.getCanonicalPath()),Color.black));
                    }
                } catch (IOException ex) {

                }
            } else if (file.isDirectory()) {
                array.addAll(DevolveListaCamdada(file.getAbsolutePath(), proxDiretoria + "//" + file.getName()));
            }
        }

        return array;
    }

    public void ConverteFicheiro(String Nome, String DiretoriaDestino, String DiretoriaAtual, int idEstilo) {
        Ficheiros F = new Ficheiros();
        File source = new File(DiretoriaAtual + "\\" + Nome);

        BufferedReader in = null;
        try {
            in = F.abreFObjectosLeitura(source.getCanonicalPath());
        } catch (IOException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedWriter out = F.abreFObjectosEscrita(DiretoriaDestino + "\\" + Nome);

        Texto Texto = new Texto(in, out);
        Texto.ComecaCataloga();

        EstiloProgramacao Estilo = Utilizador.getEstiloID(idEstilo);
        Texto.ComecaConverte(Estilo);

        try {
            out.write(Texto.toString(), 0, Texto.toString().length());
            out.flush();
        } catch (IOException ex) {
            System.out.println("Erro a escrever para o novo ficheiro");
        }
    }

    public void CopiaFicheiro(String Nome, String DiretoriaDestino, String DiretoriaAtual) {
        File source = new File(DiretoriaAtual + "\\" + Nome);
        File dest = new File(DiretoriaDestino + "\\" + Nome);

        try {
            FileUtils.copyFile(source, dest);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void Converte(String Diretoria, int IdEstilo, String NomeUtilizador) {

        listaDiretoria(Diretoria, DIRETORIA_DESTINO, IdEstilo);
    }

    public void Converte2(String Diretoria, int IdEstilo, String NomeUtilizador) {
        listaDiretoria(Diretoria, DIRETORIA_DESTINO, IdEstilo);
        Pesquisas p = new Pesquisas();

        p.AssociaNovoEstilo(Utilizador.getId(), IdEstilo);
    }

    public ArrayList<EstiloProgramacao> getEstilosUtilizador() {
        return Utilizador.getEstilos();
    }

    public ArrayList<EstiloProgramacao> UtilizadorEstilos(String NomeUser) {
        if (!ExisteUsername(NomeUser)) {
            return null;
        }
        Pesquisas p = new Pesquisas();

        return p.DevolveEstilosProgramacao(NomeUser);
        //TODO: Verificar se o utilizador tem estilos disponiveis (nao esquecer verificar a flag dos estilos
    }

    public String getUtilizadorAtualNome() {
        return Utilizador.getUsername();
    }

    public boolean TemEstilo(String NomeEstilo) {
        return Utilizador.getEstilo(NomeEstilo) != null;
    }

    public boolean TemEstiloID(int IdEstilo) {

        return Utilizador.getEstiloID(IdEstilo) != null;
    }
}
