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

    public void AssociaNovoEstilo(int IdUtilizador, int IdEstilo) {
        bd = new BaseDados();
        ResultSet Rt;
        try {
            bd.Modifica("INSERT INTO `acede`(`IDUTILIZADOR`, `IDESTILO`) VALUES (" + IdUtilizador + ", " + IdEstilo + ");");
        } catch (Exception ex) {

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
            Utilizador util = new Utilizador(Rt.getInt("IDUTILIZADOR"), Rt.getString("NOME"), Rt.getString("EMAIL"), Rt.getString("PASSWORD"));
            bd.CloseConnection();
            return util;
        } else {
            bd.CloseConnection();
            return null;
        }

    }

    //// VAI DEVOLVER UM ARRAY DE ESTILOS DE PROGRAMAÇAO MAS SÒ COM O NOME E O ID DO ESTILO
    public ArrayList<EstiloProgramacao> DevolveEstilosProgramacao(String nome) {
        ArrayList<EstiloProgramacao> Estilos = new ArrayList<>();
        bd = new BaseDados();
        EstiloProgramacao est;
        ResultSet Rt = null;
        ResultSet Rt1 = null;

        Rt1 = bd.Le("SELECT * FROM utilizador WHERE NOME = '" + nome + "';");

        try {
            if (Rt1.next()) {
                try {
                    Rt = bd.Le("SELECT * FROM estilos WHERE IDUTILIZADOR = '" + Rt1.getInt("IDUTILIZADOR") + "' and PARTILHAESTILO = 1;");
                } catch (SQLException ex) {
                    Logger.getLogger(Pesquisas.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                return Estilos;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Pesquisas.class.getName()).log(Level.SEVERE, null, ex);
        }

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

    public ArrayList<EstiloProgramacao> DevolveEstilosImportados(int Id) {
        ArrayList<EstiloProgramacao> Estilos = new ArrayList<>();
        bd = new BaseDados();
        EstiloProgramacao est;
        ResultSet Rt = null;
        int idEstilo = 0;
        boolean permite;
        String NomeEstilo;
        Cast_EP castep;
        DoWhile_EP dowhileep;
        Else_EP elseep;
        For_EP forep;
        Funcoes_EP funcoesep;
        If_EP ifep;
        Operador_EP operadorep;
        While_EP whilep;

        Rt = bd.Le("SELECT * FROM acede WHERE IDUTILIZADOR = '" + Id + "';");

        try {
            while (Rt.next()) {
                idEstilo = Rt.getInt("IDESTILO");
                Rt = bd.Le("SELECT * FROM estilos WHERE IDESTILO = '" + idEstilo + "';");

                if (Rt.next()) {
                    NomeEstilo = Rt.getString("NOMEESTILO");
                    permite = Rt.getBoolean("PARTILHAESTILO");
                    ///CAST
                    Rt = bd.Le("SELECT * FROM casts WHERE IDESTILO = " + idEstilo + ";");

                    if (Rt.next()) {
                        castep = new Cast_EP(Rt.getInt("EspacosEntreCastVariavel"));
                    } else {
                        castep = null;
                    }

                    ///DO_WHILE
                    Rt = bd.Le("SELECT * FROM do_while WHERE IDESTILO = " + idEstilo + ";");

                    if (Rt.next()) {
                        boolean pos;
                        if (Rt.getInt("PosicaoPrimeiraChaveta") == 1) {
                            pos = true;
                        } else {
                            pos = false;
                        }
                        dowhileep = new DoWhile_EP(pos, Rt.getInt("LinhasEmBrancoDepoisChavetaAberta"), Rt.getInt("LinhasEmBrancoDepoisChavetaFechada"),
                                Rt.getInt("EspacosWhileParentesesAberto"), Rt.getInt("EspacosParentesesAbertoCondicao"), Rt.getInt("EspacosCondicaoParentesFechado"));
                    } else {
                        dowhileep = null;
                    }

                    ///FUNÇÕES
                    Rt = bd.Le("SELECT * FROM funcoes WHERE IDESTILO = " + idEstilo + ";");

                    if (Rt.next()) {
                        funcoesep = new Funcoes_EP(Rt.getBoolean("AntesMain"));
                    } else {
                        funcoesep = null;
                    }

                    ///OPERADORES
                    Rt = bd.Le("SELECT * FROM operadores WHERE IDESTILO = " + idEstilo + ";");

                    if (Rt.next()) {
                        operadorep = new Operador_EP(Rt.getInt("EspacosOperadorVariavel"), Rt.getInt("EspacosVariavelOperador"));
                    } else {
                        operadorep = null;
                    }

                    //ELSE
                    Rt = bd.Le("SELECT * FROM t_else WHERE IDESTILO = " + idEstilo + ";");

                    if (Rt.next()) {
                        boolean pos;
                        if (Rt.getInt("PosicaoPrimeiraChaveta") == 1) {
                            pos = true;
                        } else {
                            pos = false;
                        }
                        elseep = new Else_EP(pos, Rt.getInt("LinhasEmBrancoDepoisChavetaAberta"), Rt.getInt("LinhasEmBrancoDepoisChavetaFechada"));
                    } else {
                        elseep = null;
                    }

                    //FOR
                    Rt = bd.Le("SELECT * FROM t_for WHERE IDESTILO = " + idEstilo + ";");

                    if (Rt.next()) {
                        boolean pos, pos2;
                        if (Rt.getInt("PosicaoPrimeiraChaveta") == 1) {
                            pos = true;
                        } else {
                            pos = false;
                        }
                        if (Rt.getInt("ChavetaUmStatementDentroFor") == 1) {
                            pos2 = true;
                        } else {
                            pos2 = false;
                        }

                        forep = new For_EP(pos, pos2, Rt.getInt("EspacosForParentesAberto"), Rt.getInt("EspacosParentesesAbertoCondicaoInicializacao"), Rt.getInt("EspacosInicializacaoPontoVirgula"),
                                Rt.getInt("EspacosPontoVirgulaCondicao"), Rt.getInt("EspacosCondicaoPontoVirgula"), Rt.getInt("EspacosPontoVirgulaIncrementacao"),
                                Rt.getInt("LinhasEmBrancoDepoisChavetaAberta"), Rt.getInt("LinhasEmBrancoDepoisChavetaFechada"));
                    } else {
                        forep = null;
                    }

                    //IF
                    Rt = bd.Le("SELECT * FROM t_if WHERE IDESTILO = " + idEstilo + ";");

                    if (Rt.next()) {
                        boolean pos, pos2;
                        if (Rt.getInt("PosicaoPrimeiraChaveta") == 1) {
                            pos = true;
                        } else {
                            pos = false;
                        }
                        if (Rt.getInt("ChavetaUmStatementDentroIf") == 1) {
                            pos2 = true;
                        } else {
                            pos2 = false;
                        }

                        ifep = new If_EP(pos, pos2, Rt.getInt("EspacosIfParentesAberto"), Rt.getInt("EspacosParentesesAbertoCondicao"), Rt.getInt("EspacosCondicaoParentesFechado"),
                                Rt.getInt("LinhasEmBrancoDepoisChavetaAberta"), Rt.getInt("LinhasEmBrancoDepoisChavetaFechada"));
                    } else {
                        ifep = null;
                    }

                    //WHILE
                    Rt = bd.Le("SELECT * FROM t_while WHERE IDESTILO = " + idEstilo + ";");

                    if (Rt.next()) {
                        boolean pos, pos2;
                        if (Rt.getInt("PrimeiraChavetaNovaLinha") == 1) {
                            pos = true;
                        } else {
                            pos = false;
                        }
                        if (Rt.getInt("ChavetaUmStatementDentroWhile") == 1) {
                            pos2 = true;
                        } else {
                            pos2 = false;
                        }

                        whilep = new While_EP(pos, pos2, Rt.getInt("LinhasEmBrancoDepoisChavetaAberta"), Rt.getInt("LinhasEmBrancoDepoisChavetaFechada"), Rt.getInt("EspacosWhileParentesAberto"),
                                Rt.getInt("EspacosParentesesAbertoCondicao"), Rt.getInt("EspacosCondicaoParentesFechado"));
                    } else {
                        whilep = null;
                    }

                    est = new EstiloProgramacao(idEstilo, NomeEstilo, permite, castep, dowhileep, elseep, forep, funcoesep, ifep, operadorep, whilep);
                    Estilos.add(est);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Pesquisas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Estilos;
    }

    /// DEVOLVE OS ESTILO DE UM UTILIZADOR
    public ArrayList<EstiloProgramacao> DevolveEstilosProgramacaoUtilizador(int Id) {
        ArrayList<EstiloProgramacao> Estilos = new ArrayList<>();
        bd = new BaseDados();
        EstiloProgramacao est;
        ResultSet Rt = null;
        int idEstilo = 0;
        boolean permite;
        String NomeEstilo;
        Cast_EP castep;
        DoWhile_EP dowhileep;
        Else_EP elseep;
        For_EP forep;
        Funcoes_EP funcoesep;
        If_EP ifep;
        Operador_EP operadorep;
        While_EP whilep;

        Rt = bd.Le("SELECT * FROM estilos WHERE IDUTILIZADOR = '" + Id + "';");

        try {
            while (Rt.next()) {
                idEstilo = Rt.getInt("IDESTILO");
                NomeEstilo = Rt.getString("NOMEESTILO");
                permite = Rt.getBoolean("PARTILHAESTILO");
                ///CAST
                Rt = bd.Le("SELECT * FROM casts WHERE IDESTILO = " + idEstilo + ";");

                if (Rt.next()) {
                    castep = new Cast_EP(Rt.getInt("ESPACOSCASTVARIAVEL"));
                } else {
                    castep = null;
                }

                ///DO_WHILE
                Rt = bd.Le("SELECT * FROM do_while WHERE IDESTILO = " + idEstilo + ";");

                if (Rt.next()) {
                    boolean pos;
                    if (Rt.getInt("PosicaoPrimeiraChaveta") == 1) {
                        pos = true;
                    } else {
                        pos = false;
                    }
                    dowhileep = new DoWhile_EP(pos, Rt.getInt("LinhasEmBrancoDepoisChavetaAberta"), Rt.getInt("LinhasEmBrancoDepoisChavetaFechada"),
                            Rt.getInt("EspacosWhileParentesesAberto"), Rt.getInt("EspacosParentesesAbertoCondicao"), Rt.getInt("EspacosCondicaoParentesFechado"));
                } else {
                    dowhileep = null;
                }

                ///FUNÇÕES
                Rt = bd.Le("SELECT * FROM funcoes WHERE IDESTILO = " + idEstilo + ";");

                if (Rt.next()) {
                    funcoesep = new Funcoes_EP(Rt.getBoolean("AntesMain"));
                } else {
                    funcoesep = null;
                }

                ///OPERADORES
                Rt = bd.Le("SELECT * FROM operadores WHERE IDESTILO = " + idEstilo + ";");

                if (Rt.next()) {
                    operadorep = new Operador_EP(Rt.getInt("EspacosOperadorVariavel"), Rt.getInt("EspacosVariavelOperador"));
                } else {
                    operadorep = null;
                }

                //ELSE
                Rt = bd.Le("SELECT * FROM t_else WHERE IDESTILO = " + idEstilo + ";");

                if (Rt.next()) {
                    boolean pos;
                    if (Rt.getInt("PosicaoPrimeiraChaveta") == 1) {
                        pos = true;
                    } else {
                        pos = false;
                    }
                    elseep = new Else_EP(pos, Rt.getInt("LinhasEmBrancoDepoisChavetaAberta"), Rt.getInt("LinhasEmBrancoDepoisChavetaFechada"));
                } else {
                    elseep = null;
                }

                //FOR
                Rt = bd.Le("SELECT * FROM t_for WHERE IDESTILO = " + idEstilo + ";");

                if (Rt.next()) {
                    boolean pos, pos2;
                    if (Rt.getInt("PosicaoPrimeiraChaveta") == 1) {
                        pos = true;
                    } else {
                        pos = false;
                    }
                    if (Rt.getInt("ChavetaUmStatementDentroFor") == 1) {
                        pos2 = true;
                    } else {
                        pos2 = false;
                    }

                    forep = new For_EP(pos, pos2, Rt.getInt("EspacosForParentesAberto"), Rt.getInt("EspacosParentesesAbertoCondicaoInicializacao"), Rt.getInt("EspacosInicializacaoPontoVirgula"),
                            Rt.getInt("EspacosPontoVirgulaCondicao"), Rt.getInt("EspacosCondicaoPontoVirgula"), Rt.getInt("EspacosPontoVirgulaIncrementacao"),
                            Rt.getInt("LinhasEmBrancoDepoisChavetaAberta"), Rt.getInt("LinhasEmBrancoDepoisChavetaFechada"));
                } else {
                    forep = null;
                }

                //IF
                Rt = bd.Le("SELECT * FROM t_if WHERE IDESTILO = " + idEstilo + ";");

                if (Rt.next()) {
                    boolean pos, pos2;
                    if (Rt.getInt("PosicaoPrimeiraChaveta") == 1) {
                        pos = true;
                    } else {
                        pos = false;
                    }
                    if (Rt.getInt("ChavetaUmStatementDentroIf") == 1) {
                        pos2 = true;
                    } else {
                        pos2 = false;
                    }

                    ifep = new If_EP(pos, pos2, Rt.getInt("EspacosIfParentesAberto"), Rt.getInt("EspacosParentesesAbertoCondicao"), Rt.getInt("EspacosCondicaoParentesFechado"),
                            Rt.getInt("LinhasEmBrancoDepoisChavetaAberta"), Rt.getInt("LinhasEmBrancoDepoisChavetaFechada"));
                } else {
                    ifep = null;
                }

                //WHILE
                Rt = bd.Le("SELECT * FROM t_while WHERE IDESTILO = " + idEstilo + ";");

                if (Rt.next()) {
                    boolean pos, pos2;
                    if (Rt.getInt("PrimeiraChavetaNovaLinha") == 1) {
                        pos = true;
                    } else {
                        pos = false;
                    }
                    if (Rt.getInt("ChavetaUmStatementDentroWhile") == 1) {
                        pos2 = true;
                    } else {
                        pos2 = false;
                    }

                    whilep = new While_EP(pos, pos2, Rt.getInt("LinhasEmBrancoDepoisChavetaAberta"), Rt.getInt("LinhasEmBrancoDepoisChavetaFechada"), Rt.getInt("EspacosWhileParentesAberto"),
                            Rt.getInt("EspacosParentesesAbertoCondicao"), Rt.getInt("EspacosCondicaoParentesFechado"));
                } else {
                    whilep = null;
                }

                est = new EstiloProgramacao(idEstilo, NomeEstilo, permite, castep, dowhileep, elseep, forep, funcoesep, ifep, operadorep, whilep);
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

        if (est.getCast() != null) {
            bd.Modifica("INSERT INTO `casts`(`IDCASTS`, `IDESTILO`, `ESPACOSCASTVARIAVEL`) VALUES (null," + id + "," + est.getCast().getEspacosEntreCastVariavel() + ")");
        }

        if (est.getDowhile() != null) {
            bd.Modifica("INSERT INTO `do_while`(`IDDOWHILE`, `IDESTILO`, `PosicaoPrimeiraChaveta`, `LinhasEmBrancoDepoisChavetaAberta`, `LinhasEmBrancoDepoisChavetaFechada`, `EspacosWhileParentesesAberto`, `EspacosParentesesAbertoCondicao`, `EspacosCondicaoParentesFechado`) VALUES "
                    + "(null," + id + " ," + est.getDowhile().isPosicaoPrimeiraChaveta() + "," + est.getDowhile().getLinhasEmBrancoDepoisChavetaAberta() + "," + est.getDowhile().getLinhasEmBrancoDepoisChavetaFechada() + "," + est.getDowhile().getEspacosWhileParentesesAberto()
                    + "," + est.getDowhile().getEspacosParentesesAbertoCondicao() + "," + est.getDowhile().getEspacosCondicaoParentesFechado() + ")");
        }

        if (est.getFuncoes() != null) {
            bd.Modifica("INSERT INTO `funcoes`(`IDFUNCOES`, `IDESTILO`, `AntesMain`) VALUES (null," + id + "," + est.getFuncoes().isAntesMain() + ")");
        }

        if (est.getOperador() != null) {
            bd.Modifica("INSERT INTO `operadores`(`IDOPERADORES`, `IDESTILO`, `EspacosOperadorVariavel`, `EspacosVariavelOperador`) VALUES (null," + id + "," + est.getOperador().getEspacosOperadorVariavel() + "," + est.getOperador().getEspacosVariavelOperador() + ")");
        }

        if (est.getElses() != null) {
            bd.Modifica("INSERT INTO `t_else`(`IDELSES`, `IDESTILO`, `PosicaoPrimeiraChaveta`, `LinhasEmBrancoEntreIfElse`, `LinhasEmBrancoDepoisChavetaAberta`, `LinhasEmBrancoDepoisChavetaFechada`) VALUES (null," + id + ", 0 ," + est.getElses().isPosicaoPrimeiraChaveta() + "," + est.getElses().getLinhasEmBrancoDepoisChavetaAberta() + "," + est.getElses().getLinhasEmBrancoDepoisChavetaFechada() + ");");
        }

        if (est.getFors() != null) {
            bd.Modifica("INSERT INTO `t_for`(`IDFOR`, `IDESTILO`, `PosicaoPrimeiraChaveta`, `ChavetaUmStatementDentroFor`, `EspacosForParentesAberto`, `EspacosParentesesAbertoCondicaoInicializacao`, `EspacosInicializacaoPontoVirgula`, `EspacosPontoVirgulaCondicao`, `EspacosCondicaoPontoVirgula`, `EspacosPontoVirgulaIncrementacao`, `EspacosIncrementacaoParentesesFechado`, `LinhasEmBrancoDepoisChavetaAberta`, `LinhasEmBrancoDepoisChavetaFechada`)"
                    + "VALUES (null," + id + "," + est.getFors().isPosicaoPrimeiraChaveta() + "," + est.getFors().isChavetaUmStatementDentroFor() + "," + est.getFors().getEspacosForParentesAberto() + "," + est.getFors().getEspacosParentesesAbertoCondicaoInicializacao() + "," + est.getFors().getEspacosInicializacaoPontoVirgula() + "," + est.getFors().getEspacosPontoVirgulaCondicao() + "," + est.getFors().getEspacosCondicaoPontoVirgula() + "," + est.getFors().getEspacosPontoVirgulaIncrementacao() + "," + est.getFors().getLinhasEmBrancoDepoisChavetaAberta() + "," + est.getFors().getLinhasEmBrancoDepoisChavetaFechada() + ")");
        }

        if (est.getIfs() != null) {
            bd.Modifica("INSERT INTO `t_if`(`IDIF`, `IDESTILO`, `PosicaoPrimeiraChaveta`, `ChavetaUmStatementDentroIf`, `EspacosIfParentesAberto`, `EspacosParentesesAbertoCondicao`, `EspacosCondicaoParentesFechado`, `LinhasEmBrancoDepoisChavetaAberta`, `LinhasEmBrancoDepoisChavetaFechada`) "
                    + "VALUES (null," + id + "," + est.getIfs().isPosicaoPrimeiraChaveta() + "," + est.getIfs().isChavetaUmStatementDentroIf() + " ," + est.getIfs().getEspacosIfParentesAberto() + "," + est.getIfs().getEspacosParentesesAbertoCondicao() + "," + est.getIfs().getEspacosCondicaoParentesFechado() + "," + est.getIfs().getLinhasEmBrancoDepoisChavetaAberta() + "," + est.getIfs().getLinhasEmBrancoDepoisChavetaFechada() + ");");
        }

        if (est.getWhiles() != null) {
            bd.Modifica("INSERT INTO `t_while`(`IDWHILE`, `IDESTILO`, `PrimeiraChavetaNovaLinha`, `ChavetaUmStatementDentroWhile`, `LinhasEmBrancoDepoisChavetaAberta`, `LinhasEmBrancoDepoisChavetaFechada`, `EspacosWhileParentesAberto`, `EspacosParentesesAbertoCondicao`,`EspacosCondicaoParentesFechado`)"
                    + "VALUES (null," + id + "," + est.getWhiles().isPosicaoPrimeiraChaveta() + "," + est.getWhiles().isChavetaUmStatementDentroWhile() + "," + est.getWhiles().getLinhasEmBrancoDepoisChavetaAberta() + " ," + est.getWhiles().getLinhasEmBrancoDepoisChavetaFechada() + "," + est.getWhiles().getEspacosWhileParentesAberto() + ", " + est.getWhiles().getEspacosParentesesAbertoCondicao() + ", " + est.getWhiles().getEspacosCondicaoParentesFechado() + ")");
        }
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
}
