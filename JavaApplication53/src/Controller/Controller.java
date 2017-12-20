package Controller;

import Model.EstiloProgramacao.EstiloProgramacao;
import Model.Model;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.io.FilenameUtils;

public class Controller extends Observable {

    private Model Model;

    private File DnDFile;

    public File getDnDFile() {
        return DnDFile;
    }

    public void setDnDFile(File DnDFile) {
        this.DnDFile = DnDFile;
    }

    public Controller() {
        Model = new Model();
    }
    //-1: tamanho errado
    //-2: caracteres especiais
    //-3: utilizador ja existe
    //1: utilizador não existe

    public int ExisteUsername(String nome) 
    {
  
        if (nome.length() > 15 || nome.length() < 7) {
            return -1;
        }

        Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(nome);

        if (m.find()) {
            return -2;
        }

        if (Model.ExisteUsername(nome)) {
            return -3;
        } else {
            return 1;
        }
    }

    //1: Existe email
    //-1: Não existe email
    //-2:Email invalido
    public int ExisteEmail(String email) {
        if(email.length() == 0) return 0;
        if (!email.contains(".") || !email.contains(".")) {
            return -2;
        }

        if (Model.ExisteEmail(email)) {
            return 1;
        } else {
            return -1;
        }
    }

    public void Regista(String username, String email, String password) {
        Model.Regista(username, email, password);
    }

    public boolean Login(String username, String password) {
        return Model.Login(username, password);
    }

    public boolean Analisa(String NomeFicheiro, boolean Permite, String NomeEstilo) {
        if ("c".equals(FilenameUtils.getExtension(NomeFicheiro)) || "h".equals(FilenameUtils.getExtension(NomeFicheiro))) {
            Model.Analisa(NomeFicheiro, Permite, NomeEstilo);
            return true;
        }
        return false;
    }

    public void Converte(String Diretoria, String NomeEstilo, String NomeUtilizador) {
        Model.Converte(Diretoria, NomeEstilo, NomeUtilizador);
    }

    public boolean ExisteNomeEstilo(String NomeEstilo) {
        return Model.TemEstilo(NomeEstilo);
    }

    public boolean isValidFile(String NomeFicheiro) {
        return FilenameUtils.getExtension(NomeFicheiro).equals("c");
    }

    public ArrayList<EstiloProgramacao> getEstilosUtilizador() {
        return Model.getEstilosUtilizador();
    }

    public ArrayList<EstiloProgramacao> UtilizadorEstilos(String NomeUser) {
        return Model.UtilizadorEstilos(NomeUser);
    }

    public String getUtilizadorAtualNome() {
        return Model.getUtilizadorAtualNome();
    }
}
