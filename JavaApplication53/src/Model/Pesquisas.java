/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.EstiloProgramacao.*;
import Model.EstiloProgramacao.EstiloProgramacao;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;
import java.util.logging.*;
import javax.xml.bind.DatatypeConverter;

public class Pesquisas {

    private BaseDados bd;

    public Pesquisas() {

    }

    public void AdicionaUtilizador(String Nome, String Email, String PalavraChave) {
        bd = new BaseDados();

        try {
            bd.Modifica("INSERT INTO utilizador(IDUTILIZADOR, NOME, EMAIL, PASSWORD) VALUES ( null,'" + Nome.trim() + "','" + Email.trim() + "','" + SHA1(PalavraChave) + "');");
        } catch (NoSuchAlgorithmException ex) {

        }

        bd.CloseConnection();
    }

    static String SHA1(String input) throws NoSuchAlgorithmException {
        MessageDigest mDigest = MessageDigest.getInstance("SHA1");
        byte[] result = mDigest.digest(input.getBytes());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < result.length; i++) {
            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        }

        return sb.toString();
    }

    public boolean ExisteUsername(String Username) throws SQLException {
        bd = new BaseDados();
        ResultSet Rt;

        Rt = bd.Le("SELECT * FROM utilizador WHERE NOME = '" + Username + "';");

        if (Rt.next()) {
            bd.CloseConnection();
            return true;
        } else {
            bd.CloseConnection();
            return false;
        }

    }

    public boolean ExisteEmail(String Email) throws SQLException {
        bd = new BaseDados();
        ResultSet Rt;

        Rt = bd.Le("SELECT * FROM utilizador WHERE EMAIL = '" + Email + "'");

        if (Rt.next()) {
            bd.CloseConnection();
            return true;
        } else {
            bd.CloseConnection();
            return false;
        }
    }

    public boolean VerificaLogin(String Username, String Password) throws SQLException {
        bd = new BaseDados();
        ResultSet Rt = null;
        boolean existe = false;
        try {
            Rt = bd.Le("SELECT * FROM utilizador WHERE NOME = '" + Username + "' and PASSWORD = '" + SHA1(Password) + "';");
        } catch (NoSuchAlgorithmException ex) {

        }
        if (Rt.next()) {
            bd.CloseConnection();
            return true;
        } else {
            bd.CloseConnection();
            return false;
        }
    }

    public Utilizador getUser(String Username) throws SQLException {
        bd = new BaseDados();
        ResultSet Rt = bd.Le("SELECT * FROM utilizador WHERE NOME = '" + Username + "'");

        if (Rt.next()) {
            bd.CloseConnection();
            return new Utilizador(Rt.getString("NOME"), Rt.getString("EMAIL"), Rt.getString("PASSWORD"));
        } else {
            bd.CloseConnection();
            return null;
        }

    }

    //// VAI DEVOLVER UM ARRAY DE ESTILOS DE PROGRAMAÇAO MAS SÒ COM O NOME E O ID DO ESTILO
    public ArrayList<EstiloProgramacao> DevolveEstiloProgramacao(String nome) {
        ArrayList<EstiloProgramacao> Estilos = new ArrayList<>();
        bd = new BaseDados();
        EstiloProgramacao est;
        ResultSet Rt = null;

        Rt = bd.Le("SELECT * FROM estilos WHERE NOMEESTILO = '" + nome + "' and PARTILHAESTILO = 1;");

        try {
            while (Rt.next()) {
                est = new EstiloProgramacao(Rt.getInt("IDESTILO"), Rt.getString("NOMEESTILO"));
                Estilos.add(est);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Pesquisas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Estilos;
    }

    public void AdicionaEstilo(EstiloProgramacao est, Utilizador util, int Partilha) {
        bd = new BaseDados();
        ResultSet Rt = null;
        int id;
        id = bd.Modifica("INSERT INTO `estilos`(`IDESTILO`, `IDUTILIZADOR`, `NOMEESTILO`, `PARTILHAESTILO`) VALUES (null,'" + util.getId() + "','" + est.getNome() + "','" + Partilha + "');");

        Rt = bd.Le("SELECT * FROM estilos WHERE IDUTILIZADOR = " + util.getId() + " AND NOMEESTILO = '" + est.getNome() + "';");

        try {
            if (Rt.next()) {
                id = Rt.getInt("IDESTILO");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Pesquisas.class.getName()).log(Level.SEVERE, null, ex);
        }

        bd.Modifica("INSERT INTO `casts`(`IDCASTS`, `IDESTILO`, `ESPACOSCASTVARIAVEL`) VALUES (null," + id + "," + est.getCast().getEspacosEntreCastVariavel() + ")");

        bd.Modifica("INSERT INTO `do_while`(`IDDOWHILE`, `IDESTILO`, `DOWHILEPOSPRIMEIRA_`, `DOWHILELINHASDEPOIS_`, `DOWHILELINHASANTES_`, `DOWHILELINHAS_WHILE`, `DOWHILEESPACOSWHILE_`, `DOWHILEESPACOS_CONDICAO`, `DOWHILECONDICAO_`) VALUES "
                + "(null," + id + " ," + est.getDowhile().isPosicaoPrimeiraChaveta() + "," + est.getDowhile().getLinhasEmBrancoDepoisChavetaAberta() + "," + est.getDowhile().getLinhasEmBrancoDepoisChavetaFechada() + "," + est.getDowhile().getEspacosWhileParentesesAberto()
                + "," + est.getDowhile().getEspacosWhileParentesesAberto() + "," + est.getDowhile().getEspacosWhileParentesesAberto() + "," + est.getDowhile().getEspacosCondicaoParentesFechado() + " )");

        bd.Modifica("INSERT INTO `funcoes`(`IDFUNCOES`, `IDESTILO`, `FUNCOESPREVIAMENTEDECLARADAS`) VALUES (null," + id + "," + est.getFuncoes().isAntesMain() + ")");

        bd.Modifica("INSERT INTO `operadores`(`IDOPERADORES`, `IDESTILO`, `ESPACOSOPERADORVARIAVEL`, `ESPACOSOPERADORSEGUINTE`) VALUES (null," + id + "," + est.getOperador().getEspacosOperadorVariavel() + "," + est.getOperador().getEspacosVariavelOperador() + ")");

        bd.Modifica("INSERT INTO `t_else`(`IDELSES`, `IDESTILO`, `ELSELINHASIFELSE`, `ELSEPOSPRIMEIRA_`, `ELSELINHASDEPOIS_`, `ELSELINHASANTES_`) VALUES (null," + id + ", 0 ," + est.getElses().isPosicaoPrimeiraChaveta() + "," + est.getElses().getLinhasEmBrancoDepoisChavetaAberta() + "," + est.getElses().getLinhasEmBrancoDepoisChavetaFechada() + ");");

        bd.Modifica("INSERT INTO `t_for`(`IDFOR`, `IDESTILO`, `FOR_COM1STATEMENT`, `FORESPACOSFOR_`, `FORESPACOS_INICIALIZACAO`, `FORESPACOSINICIALIZACAO_`, `FORESPACOS_CONDICAO`, `FORESPACOSCONDICAO_`, `FORESPACOS_INCREMENTACAO`, `FORESPACOSINCREMENTACAO_`, `FORPOSPRIMEIRA_`, `FORLINHASDEPOIS_`, `FORLINHASANTES_`)"
                + "VALUES (null," + id + "," + est.getFors().isPosicaoPrimeiraChaveta() + "," + est.getFors().isChavetaUmStatementDentroFor() + "," + est.getFors().getEspacosForParentesAberto() + "," + est.getFors().getEspacosParentesesAbertoCondicaoInicializacao() + "," + est.getFors().getEspacosInicializacaoPontoVirgula() + "," + est.getFors().getEspacosPontoVirgulaCondicao() + "," + est.getFors().getEspacosCondicaoPontoVirgula() + "," + est.getFors().getEspacosPontoVirgulaIncrementacao() + "," + est.getFors().getEspacosIncrementacaoParentesesFechado() + "," + est.getFors().getLinhasEmBrancoDepoisChavetaAberta() + "," + est.getFors().getLinhasEmBrancoDepoisChavetaFechada() + ")");

        bd.Modifica("INSERT INTO `t_if`(`IDIF`, `IDESTILO`, `IFPOSPRIMEIRA_`, `IF_COM1STATEMENT`, `IFESPACOSIF_`, `IFESPACOS_CONDICAO`, `IFESPACOSCONDICAO_`, `IFLINHASDEPOIS_`, `IFLINHASANTES_`) "
                + "VALUES (null," + id + "," + est.getIfs().isPosicaoPrimeiraChaveta() + "," + est.getIfs().isChavetaUmStatementDentroIf() + " ," + est.getIfs().getEspacosIfParentesAberto() + "," + est.getIfs().getEspacosParentesesAbertoCondicao() + "," + est.getIfs().getEspacosCondicaoParentesFechado() + "," + est.getIfs().getLinhasEmBrancoDepoisChavetaAberta() + "," + est.getIfs().getLinhasEmBrancoDepoisChavetaFechada() + ");");

        bd.Modifica("INSERT INTO `t_while`(`IDWHILE`, `IDESTILO`, `WHILEPOSPRIMEIRA_`, `WHILEESPACOSWHILE_`, `WHILEESPACOS_CONDICAO`, `WHILEESPACOSCONDICAO_`, `WHILELINHASDEPOIS_`, `WHILELINHASANTES_`)"
                + "VALUES (null," + id + "," + est.getWhiles().isPosicaoPrimeiraChaveta() + "," + est.getIfs().isChavetaUmStatementDentroIf() + "," + est.getIfs().getEspacosParentesesAbertoCondicao() + ", " + est.getIfs().getEspacosCondicaoParentesFechado() + " ," + est.getIfs().getLinhasEmBrancoDepoisChavetaAberta() + "," + est.getIfs().getLinhasEmBrancoDepoisChavetaFechada() + ")");
        bd.CloseConnection();
    }

    public boolean VerificaNomeEstilo(String nome) {
        bd = new BaseDados();

        ResultSet Rt = null;

        Rt = bd.Le("SELECT * FROM estilos WHERE NOMEESTILO = '" + nome + "';");

        try {
            if (Rt.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Pesquisas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public EstiloProgramacao DevolveEstiloUtilizador(int id) throws SQLException {
        bd = new BaseDados();
        ResultSet Rt = null;
        Cast_EP castep;
        DoWhile_EP dowhileep;
        Else_EP elseep;
        For_EP forep;
        Funcoes_EP funcoesep;
        If_EP ifep;
        Operador_EP operadorep;
        While_EP whilep;
        int idestilo;

        Rt = bd.Le("SELECT * FROM estilos WHERE IDUTILIZAODR = " + id + ";");

        if (Rt.next()) {
            idestilo = Rt.getInt("IDESTILO");
        } else {
            return null;
        }

        Rt = bd.Le("SELECT * FROM casts WHERE IDESTILO = " + idestilo + ";");

        if (Rt.next()) {
            castep = new Cast_EP(Rt.getInt("ESPACOSCASTVARIAVEL"));
        } else {
            return null;
        }

        Rt = bd.Le("SELECT * FROM do_while WHERE IDESTILO = " + idestilo + ";");

        if (Rt.next()) {
            boolean pos;
            if (Rt.getInt("DOWHILEPOSPRIMEIRA_") == 1) {
                pos = true;
            } else {
                pos = false;
            }
            dowhileep = new DoWhile_EP(pos, Rt.getInt("DOWHILELINHASDEPOIS_"), Rt.getInt("DOWHILELINHASANTES_"),
                    Rt.getInt("DOWHILEESPACOSWHILE_"), Rt.getInt("DOWHILEESPACOS_CONDICAO"), Rt.getInt("DOWHILECONDICAO_"));
        } else {
            return null;
        }

        Rt = bd.Le("SELECT * FROM funcoes WHERE IDESTILO = " + idestilo + ";");

        if (Rt.next()) {
            funcoesep = new Funcoes_EP(Rt.getBoolean("FUNCOESPREVIAMENTEDECLARADAS"));
        } else {
            return null;
        }

        Rt = bd.Le("SELECT * FROM operadores WHERE IDESTILO = " + idestilo + ";");

        if (Rt.next()) {
            operadorep = new Operador_EP(Rt.getInt("ESPACOSOPERADORVARIAVEL"), Rt.getInt("ESPACOSOPERADORSEGUINTE"));
        } else {
            return null;
        }

        Rt = bd.Le("SELECT * FROM t_else WHERE IDESTILO = " + idestilo + ";");

        if (Rt.next()) {
            boolean pos;
            if (Rt.getInt("ELSEPOSPRIMEIRA_") == 1) {
                pos = true;
            } else {
                pos = false;
            }
            elseep = new Else_EP(pos, Rt.getInt("ELSELINHASDEPOIS"), Rt.getInt("ELSELINHASANTES"));
        } else {
            return null;
        }

        Rt = bd.Le("SELECT * FROM t_for WHERE IDESTILO = " + idestilo + ";");

        if (Rt.next()) {
            boolean pos;
            if (Rt.getInt("FORPOSPRIMEIRA_") == 1) {
                pos = true;
            } else {
                pos = false;
            }
            forep = new For_EP(pos, Rt.getInt("FORESPACOSFOR"), Rt.getInt("FORESPACOS_INICIALIZACAO "), Rt.getInt("FORESPACOSINICIALIZACAO_"),
                    Rt.getInt("FORESPACOS_CONDICAO"), Rt.getInt("FORESPACOSCONDICAO_"), Rt.getInt("FORESPACOS_INCREMENTACAO"), Rt.getInt("FORESPACOSINCREMENTACAO_"),
                    Rt.getInt("FORLINHASDEPOIS_"), Rt.getInt("FORLINHASANTES_"));
        } else {
            return null;
        }

        Rt = bd.Le("SELECT * FROM t_if WHERE IDESTILO = " + idestilo + ";");

        if (Rt.next()) {
            boolean pos;
            if (Rt.getInt("IFPOSPRIMEIRA_") == 1) {
                pos = true;
            } else {
                pos = false;
            }
            ifep = new If_EP(pos, Rt.getInt("IFESPACOSIF_"), Rt.getInt("IFESPACOS_CONDICAO"), Rt.getInt("IFESPACOSCONDICAO_"),
                    Rt.getInt("IFLINHASDEPOIS_"), Rt.getInt("IFLINHASANTES_"));
        } else {
            return null;
        }

        Rt = bd.Le("SELECT * FROM t_while WHERE IDESTILO = " + idestilo + ";");

        if (Rt.next()) {
            boolean pos;
            if (Rt.getInt("WHILEPOSPRIMEIRA_") == 1) {
                pos = true;
            } else {
                pos = false;
            }
            whilep = new While_EP(pos, Rt.getInt("WHILEESPACOSWHILE_"), Rt.getInt("WHILEESPACOS_CONDICAO"), Rt.getInt("WHILEESPACOSCONDICAO_"),
                    Rt.getInt("WHILELINHASDEPOIS_"), Rt.getInt("WHILELINHASANTES_"));
        } else {
            return null;
        }
        Rt = bd.Le("SELECT * FROM estilos WHERE IDESTILO = " + idestilo + ";");
        String nome = Rt.getString("NOMEESTILO");
        boolean permite = Rt.getBoolean("PARTILHAESTILO");
        return new EstiloProgramacao(id, nome, permite, castep, dowhileep, elseep, forep, funcoesep, ifep, operadorep, whilep);
    }

    public EstiloProgramacao DevolveEstiloAcede(int id) throws SQLException {
        bd = new BaseDados();
        ResultSet Rt = null;
        Cast_EP castep;
        DoWhile_EP dowhileep;
        Else_EP elseep;
        For_EP forep;
        Funcoes_EP funcoesep;
        If_EP ifep;
        Operador_EP operadorep;
        While_EP whilep;
        int idestilo;

        Rt = bd.Le("SELECT * FROM acede WHERE IDUTILIZADOR = " + id + ";");

        if (Rt.next()) {
            idestilo = Rt.getInt("IDESTILO");
        } else {
            return null;
        }

        Rt = bd.Le("SELECT * FROM casts WHERE IDESTILO = " + idestilo + ";");

        if (Rt.next()) {
            castep = new Cast_EP(Rt.getInt("ESPACOSCASTVARIAVEL"));
        } else {
            return null;
        }

        Rt = bd.Le("SELECT * FROM do_while WHERE IDESTILO = " + idestilo + ";");

        if (Rt.next()) {
            boolean pos;
            if (Rt.getInt("DOWHILEPOSPRIMEIRA_") == 1) {
                pos = true;
            } else {
                pos = false;
            }
            dowhileep = new DoWhile_EP(pos, Rt.getInt("DOWHILELINHASDEPOIS_"), Rt.getInt("DOWHILELINHASANTES_"),
                    Rt.getInt("DOWHILEESPACOSWHILE_"), Rt.getInt("DOWHILEESPACOS_CONDICAO"), Rt.getInt("DOWHILECONDICAO_"));
        } else {
            return null;
        }

        Rt = bd.Le("SELECT * FROM funcoes WHERE IDESTILO = " + idestilo + ";");

        if (Rt.next()) {
            funcoesep = new Funcoes_EP(Rt.getBoolean("FUNCOESPREVIAMENTEDECLARADAS"));
        } else {
            return null;
        }

        Rt = bd.Le("SELECT * FROM operadores WHERE IDESTILO = " + idestilo + ";");

        if (Rt.next()) {
            operadorep = new Operador_EP(Rt.getInt("ESPACOSOPERADORVARIAVEL"), Rt.getInt("ESPACOSOPERADORSEGUINTE"));
        } else {
            return null;
        }

        Rt = bd.Le("SELECT * FROM t_else WHERE IDESTILO = " + idestilo + ";");

        if (Rt.next()) {
            boolean pos;
            if (Rt.getInt("ELSEPOSPRIMEIRA_") == 1) {
                pos = true;
            } else {
                pos = false;
            }
            elseep = new Else_EP(pos, Rt.getInt("ELSELINHASDEPOIS"), Rt.getInt("ELSELINHASANTES"));
        } else {
            return null;
        }

        Rt = bd.Le("SELECT * FROM t_for WHERE IDESTILO = " + idestilo + ";");

        if (Rt.next()) {
            boolean pos;
            if (Rt.getInt("FORPOSPRIMEIRA_") == 1) {
                pos = true;
            } else {
                pos = false;
            }
            forep = new For_EP(pos, Rt.getInt("FORESPACOSFOR"), Rt.getInt("FORESPACOS_INICIALIZACAO "), Rt.getInt("FORESPACOSINICIALIZACAO_"),
                    Rt.getInt("FORESPACOS_CONDICAO"), Rt.getInt("FORESPACOSCONDICAO_"), Rt.getInt("FORESPACOS_INCREMENTACAO"), Rt.getInt("FORESPACOSINCREMENTACAO_"),
                    Rt.getInt("FORLINHASDEPOIS_"), Rt.getInt("FORLINHASANTES_"));
        } else {
            return null;
        }

        Rt = bd.Le("SELECT * FROM t_if WHERE IDESTILO = " + idestilo + ";");

        if (Rt.next()) {
            boolean pos;
            if (Rt.getInt("IFPOSPRIMEIRA_") == 1) {
                pos = true;
            } else {
                pos = false;
            }
            ifep = new If_EP(pos, Rt.getInt("IFESPACOSIF_"), Rt.getInt("IFESPACOS_CONDICAO"), Rt.getInt("IFESPACOSCONDICAO_"),
                    Rt.getInt("IFLINHASDEPOIS_"), Rt.getInt("IFLINHASANTES_"));
        } else {
            return null;
        }

        Rt = bd.Le("SELECT * FROM t_while WHERE IDESTILO = " + idestilo + ";");

        if (Rt.next()) {
            boolean pos;
            if (Rt.getInt("WHILEPOSPRIMEIRA_") == 1) {
                pos = true;
            } else {
                pos = false;
            }
            whilep = new While_EP(pos, Rt.getInt("WHILEESPACOSWHILE_"), Rt.getInt("WHILEESPACOS_CONDICAO"), Rt.getInt("WHILEESPACOSCONDICAO_"),
                    Rt.getInt("WHILELINHASDEPOIS_"), Rt.getInt("WHILELINHASANTES_"));
        } else {
            return null;
        }
        Rt = bd.Le("SELECT * FROM estilos WHERE IDESTILO = " + idestilo + ";");
        String nome = Rt.getString("NOMEESTILO");
        boolean permite = Rt.getBoolean("PARTILHAESTILO");
        return new EstiloProgramacao(id, nome, permite, castep, dowhileep, elseep, forep, funcoesep, ifep, operadorep, whilep);
    }
    
     public void getEstilos(Utilizador ut)
     {
         try
         {
         ut.NovoEstilo(DevolveEstiloUtilizador(ut.getId()));
         }catch(SQLException se)
         {
             System.out.println("Model.Pesquisas.getEstilos()");
         }
     }
}
