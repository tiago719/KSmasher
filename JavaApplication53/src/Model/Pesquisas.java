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
        bd = new BaseDados();
    }

    @Override
    protected void finalize() {
        
        try {
            super.finalize();
        } catch (Throwable ex) {
            Logger.getLogger(Pesquisas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void AdicionaUtilizador(String Nome, String Email, String PalavraChave) {

        java.sql.Statement s = bd.getStatement();
        try {
            bd.Modifica("INSERT INTO utilizador(IDUTILIZADOR, NOME, EMAIL, PASSWORD) VALUES ( null,'" + Nome.trim() + "','" + Email.trim() + "','" + SHA1(PalavraChave) + "');", s);
        } catch (NoSuchAlgorithmException ex) {

        }

        
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
        java.sql.Statement s = bd.getStatement();
        ResultSet Rt;

        Rt = bd.Le("SELECT * FROM utilizador WHERE NOME = '" + Username + "';", s);

        if (Rt.next()) {
            
            return true;
        } else {
            
            return false;
        }

    }

    public void AssociaNovoEstilo(int IdUtilizador, int IdEstilo) {
        java.sql.Statement s = bd.getStatement();
        ResultSet Rt;
        try {
            bd.Modifica("INSERT INTO `acede`(`IDUTILIZADOR`, `IDESTILO`) VALUES (" + IdUtilizador + ", " + IdEstilo + ");", s);
        } catch (Exception ex) {

        }
    }

    public boolean ExisteEmail(String Email) throws SQLException {
        java.sql.Statement s = bd.getStatement();
        ResultSet Rt;

        Rt = bd.Le("SELECT * FROM utilizador WHERE EMAIL = '" + Email + "'", s);

        if (Rt.next()) {
            
            return true;
        } else {
            
            return false;
        }
    }

    public boolean VerificaLogin(String Username, String Password) throws SQLException {
        java.sql.Statement s = bd.getStatement();
        ResultSet Rt = null;
        boolean existe = false;
        try {
            Rt = bd.Le("SELECT * FROM utilizador WHERE NOME = '" + Username + "' and PASSWORD = '" + SHA1(Password) + "';", s);
        } catch (NoSuchAlgorithmException ex) {

        }
        if (Rt.next()) {
            
            return true;
        } else {
            
            return false;
        }
    }

    public Utilizador getUser(String Username) throws SQLException {
        java.sql.Statement s = bd.getStatement();
        ResultSet Rt = bd.Le("SELECT * FROM utilizador WHERE NOME = '" + Username + "'", s);

        if (Rt.next()) {
            Utilizador util = new Utilizador(Rt.getInt("IDUTILIZADOR"), Rt.getString("NOME"), Rt.getString("EMAIL"), Rt.getString("PASSWORD"));
            
            return util;
        } else {
            
            return null;
        }

    }

    //// VAI DEVOLVER UM ARRAY DE ESTILOS DE PROGRAMAÇAO MAS SÒ COM O NOME E O ID DO ESTILO
    public ArrayList<EstiloProgramacao> DevolveEstilosProgramacao(String nome) {
        java.sql.Statement s = bd.getStatement();
        ArrayList<EstiloProgramacao> Estilos = new ArrayList<>();

        EstiloProgramacao est;
        ResultSet Rt = null;
        ResultSet Rt1 = null;

        Rt1 = bd.Le("SELECT * FROM utilizador WHERE NOME = '" + nome + "';", s);

        try {
            if (Rt1.next()) {
                try {
                    Rt = bd.Le("SELECT * FROM estilos WHERE IDUTILIZADOR = '" + Rt1.getInt("IDUTILIZADOR") + "' and PARTILHAESTILO = 1;", s);
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
        java.sql.Statement s = bd.getStatement();
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

        Rt = bd.Le("SELECT * FROM acede WHERE IDUTILIZADOR = '" + Id + "';", s);

        try {
            while (Rt.next()) {
                idEstilo = Rt.getInt("IDESTILO");
                Rt = bd.Le("SELECT * FROM estilos WHERE IDESTILO = '" + idEstilo + "';", s);

                if (Rt.next()) {
                    NomeEstilo = Rt.getString("NOMEESTILO");
                    permite = Rt.getBoolean("PARTILHAESTILO");
                    ///CAST
                    Rt = bd.Le("SELECT * FROM casts WHERE IDESTILO = " + idEstilo + ";", s);

                    if (Rt.next()) {
                        castep = new Cast_EP(Rt.getInt("ESPACOSCASTVARIAVEL"));
                    } else {
                        castep = null;
                    }

                    ///DO_WHILE
                    Rt = bd.Le("SELECT * FROM do_while WHERE IDESTILO = " + idEstilo + ";", s);

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
                    Rt = bd.Le("SELECT * FROM funcoes WHERE IDESTILO = " + idEstilo + ";", s);

                    if (Rt.next()) {
                        funcoesep = new Funcoes_EP(Rt.getBoolean("AntesMain"));
                    } else {
                        funcoesep = null;
                    }

                    ///OPERADORES
                    Rt = bd.Le("SELECT * FROM operadores WHERE IDESTILO = " + idEstilo + ";", s);

                    if (Rt.next()) {
                        operadorep = new Operador_EP(Rt.getInt("EspacosOperadorVariavel"), Rt.getInt("EspacosVariavelOperador"));
                    } else {
                        operadorep = null;
                    }

                    //ELSE
                    Rt = bd.Le("SELECT * FROM t_else WHERE IDESTILO = " + idEstilo + ";", s);

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
                    Rt = bd.Le("SELECT * FROM t_for WHERE IDESTILO = " + idEstilo + ";", s);

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
                    Rt = bd.Le("SELECT * FROM t_if WHERE IDESTILO = " + idEstilo + ";", s);

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
                    Rt = bd.Le("SELECT * FROM t_while WHERE IDESTILO = " + idEstilo + ";", s);

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
    
    public EstiloProgramacao getEstiloById(int Id) {

        java.sql.Statement s = bd.getStatement();
        EstiloProgramacao est = null;
        ResultSet Rt = null;
        int idEstilo = 0;
        Cast_EP castep;
        DoWhile_EP dowhileep;
        Else_EP elseep;
        For_EP forep;
        Funcoes_EP funcoesep;
        If_EP ifep;
        Operador_EP operadorep;
        While_EP whilep;

        try {
            idEstilo = Id;
            ///CAST
            Rt = bd.Le("SELECT * FROM casts WHERE IDESTILO = " + idEstilo + ";",s);

            if (Rt.next()) {
                castep = new Cast_EP(Rt.getInt("ESPACOSCASTVARIAVEL"));
            } else {
                castep = null;
            }

            ///DO_WHILE
            Rt = bd.Le("SELECT * FROM do_while WHERE IDESTILO = " + idEstilo + ";",s);

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
            Rt = bd.Le("SELECT * FROM funcoes WHERE IDESTILO = " + idEstilo + ";",s);

            if (Rt.next()) {
                funcoesep = new Funcoes_EP(Rt.getBoolean("AntesMain"));
            } else {
                funcoesep = null;
            }

            ///OPERADORES
            Rt = bd.Le("SELECT * FROM operadores WHERE IDESTILO = " + idEstilo + ";",s);

            if (Rt.next()) {
                operadorep = new Operador_EP(Rt.getInt("EspacosOperadorVariavel"), Rt.getInt("EspacosVariavelOperador"));
            } else {
                operadorep = null;
            }

            //ELSE
            Rt = bd.Le("SELECT * FROM t_else WHERE IDESTILO = " + idEstilo + ";",s);

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
            Rt = bd.Le("SELECT * FROM t_for WHERE IDESTILO = " + idEstilo + ";",s);

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
            Rt = bd.Le("SELECT * FROM t_if WHERE IDESTILO = " + idEstilo + ";",s);

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
            Rt = bd.Le("SELECT * FROM t_while WHERE IDESTILO = " + idEstilo + ";",s);

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

            est = new EstiloProgramacao(idEstilo, "", true, castep,
                    dowhileep, elseep, forep, funcoesep, ifep, operadorep,
                    whilep);

        } catch (SQLException ex) {
            Logger.getLogger(Pesquisas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return est;
    }

    /// DEVOLVE OS ESTILO DE UM UTILIZADOR
    public ArrayList<EstiloProgramacao> DevolveEstilosProgramacaoUtilizador(int Id) {
        ArrayList<EstiloProgramacao> Estilos = new ArrayList<>();
        java.sql.Statement s = bd.getStatement();
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

        Rt = bd.Le("SELECT * FROM estilos WHERE IDUTILIZADOR = '" + Id + "';", s);

        try {
            while (Rt.next()) {
                idEstilo = Rt.getInt("IDESTILO");
                NomeEstilo = Rt.getString("NOMEESTILO");
                permite = Rt.getBoolean("PARTILHAESTILO");
                ///CAST
                Rt = bd.Le("SELECT * FROM casts WHERE IDESTILO = " + idEstilo + ";", s);

                if (Rt.next()) {
                    castep = new Cast_EP(Rt.getInt("ESPACOSCASTVARIAVEL"));
                } else {
                    castep = null;
                }

                ///DO_WHILE
                Rt = bd.Le("SELECT * FROM do_while WHERE IDESTILO = " + idEstilo + ";", s);

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
                Rt = bd.Le("SELECT * FROM funcoes WHERE IDESTILO = " + idEstilo + ";", s);

                if (Rt.next()) {
                    funcoesep = new Funcoes_EP(Rt.getBoolean("AntesMain"));
                } else {
                    funcoesep = null;
                }

                ///OPERADORES
                Rt = bd.Le("SELECT * FROM operadores WHERE IDESTILO = " + idEstilo + ";", s);

                if (Rt.next()) {
                    operadorep = new Operador_EP(Rt.getInt("EspacosOperadorVariavel"), Rt.getInt("EspacosVariavelOperador"));
                } else {
                    operadorep = null;
                }

                //ELSE
                Rt = bd.Le("SELECT * FROM t_else WHERE IDESTILO = " + idEstilo + ";", s);

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
                Rt = bd.Le("SELECT * FROM t_for WHERE IDESTILO = " + idEstilo + ";", s);

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
                Rt = bd.Le("SELECT * FROM t_if WHERE IDESTILO = " + idEstilo + ";", s);

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
                Rt = bd.Le("SELECT * FROM t_while WHERE IDESTILO = " + idEstilo + ";", s);

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
        java.sql.Statement s = bd.getStatement();
        ResultSet Rt = null;
        int id;
        id = bd.Modifica("INSERT INTO `estilos`(`IDESTILO`, `IDUTILIZADOR`, "
                + "`NOMEESTILO`, `PARTILHAESTILO`) VALUES (null,'" 
                + util.getId() + "','" + est.getNome() + "','" 
                + Partilha + "');",s);

        Rt = bd.Le("SELECT * FROM estilos WHERE IDUTILIZADOR = " + util.getId() + " AND NOMEESTILO = '" + est.getNome() + "';", s);

        try {
            if (Rt.next()) {
                id = Rt.getInt("IDESTILO");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Pesquisas.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (est.getCast() != null) {
            bd.Modifica("INSERT INTO `casts`(`IDCASTS`, `IDESTILO`, `ESPACOSCASTVARIAVEL`) VALUES (null," + id + "," + est.getCast().getEspacosEntreCastVariavel() + ")", s);
        }

        if (est.getDowhile() != null) {
            bd.Modifica("INSERT INTO `do_while`(`IDDOWHILE`, `IDESTILO`, `PosicaoPrimeiraChaveta`, `LinhasEmBrancoDepoisChavetaAberta`, `LinhasEmBrancoDepoisChavetaFechada`, `EspacosWhileParentesesAberto`, `EspacosParentesesAbertoCondicao`, `EspacosCondicaoParentesFechado`) VALUES "
                    + "(null," + id + " ," + est.getDowhile().isPosicaoPrimeiraChaveta() + "," + est.getDowhile().getLinhasEmBrancoDepoisChavetaAberta() + "," + est.getDowhile().getLinhasEmBrancoDepoisChavetaFechada() + "," + est.getDowhile().getEspacosWhileParentesesAberto()
                    + "," + est.getDowhile().getEspacosParentesesAbertoCondicao() + "," + est.getDowhile().getEspacosCondicaoParentesFechado() + ")", s);
        }

        if (est.getFuncoes() != null) {
            bd.Modifica("INSERT INTO `funcoes`(`IDFUNCOES`, `IDESTILO`, `AntesMain`) VALUES (null," + id + "," + est.getFuncoes().isAntesMain() + ")", s);
        }

        if (est.getOperador() != null) {
            bd.Modifica("INSERT INTO `operadores`(`IDOPERADORES`, `IDESTILO`, `EspacosOperadorVariavel`, `EspacosVariavelOperador`) VALUES (null," + id + "," + est.getOperador().getEspacosOperadorVariavel() + "," + est.getOperador().getEspacosVariavelOperador() + ")", s);
        }

        if (est.getElses() != null) {
            bd.Modifica("INSERT INTO `t_else`(`IDELSES`, `IDESTILO`, `PosicaoPrimeiraChaveta`, `LinhasEmBrancoEntreIfElse`, `LinhasEmBrancoDepoisChavetaAberta`, `LinhasEmBrancoDepoisChavetaFechada`) VALUES (null," + id + ", 0 ," + est.getElses().isPosicaoPrimeiraChaveta() + "," + est.getElses().getLinhasEmBrancoDepoisChavetaAberta() + "," + est.getElses().getLinhasEmBrancoDepoisChavetaFechada() + ");", s);
        }

        if (est.getFors() != null) {
            String x = ("INSERT INTO `t_for`(`IDFOR`, `IDESTILO`, `PosicaoPrimeiraChaveta`, `ChavetaUmStatementDentroFor`, `EspacosForParentesAberto`, `EspacosParentesesAbertoCondicaoInicializacao`, `EspacosInicializacaoPontoVirgula`, `EspacosPontoVirgulaCondicao`, `EspacosCondicaoPontoVirgula`, `EspacosPontoVirgulaIncrementacao`, `EspacosIncrementacaoParentesesFechado`, `LinhasEmBrancoDepoisChavetaAberta`, `LinhasEmBrancoDepoisChavetaFechada`)"
                    + "VALUES (null," + id + ","
                    + est.getFors().isPosicaoPrimeiraChaveta()
                    + "," + est.getFors().isChavetaUmStatementDentroFor()
                    + "," + est.getFors().getEspacosForParentesAberto()
                    + "," + est.getFors().getEspacosParentesesAbertoCondicaoInicializacao()
                    + "," + est.getFors().getEspacosInicializacaoPontoVirgula()
                    + "," + est.getFors().getEspacosPontoVirgulaCondicao()
                    + "," + est.getFors().getEspacosCondicaoPontoVirgula()
                    + "," + est.getFors().getEspacosPontoVirgulaIncrementacao()
                    + "," + 0
                    + "," + est.getFors().getLinhasEmBrancoDepoisChavetaAberta()
                    + "," + est.getFors().getLinhasEmBrancoDepoisChavetaFechada() + ")");

            bd.Modifica(x, s);
        }

        if (est.getIfs() != null) {
            bd.Modifica("INSERT INTO `t_if`(`IDIF`, `IDESTILO`, `PosicaoPrimeiraChaveta`, `ChavetaUmStatementDentroIf`, `EspacosIfParentesAberto`, `EspacosParentesesAbertoCondicao`, `EspacosCondicaoParentesFechado`, `LinhasEmBrancoDepoisChavetaAberta`, `LinhasEmBrancoDepoisChavetaFechada`) "
                    + "VALUES (null," + id + "," + est.getIfs().isPosicaoPrimeiraChaveta() + "," + est.getIfs().isChavetaUmStatementDentroIf() + " ," + est.getIfs().getEspacosIfParentesAberto() + "," + est.getIfs().getEspacosParentesesAbertoCondicao() + "," + est.getIfs().getEspacosCondicaoParentesFechado() + "," + est.getIfs().getLinhasEmBrancoDepoisChavetaAberta() + "," + est.getIfs().getLinhasEmBrancoDepoisChavetaFechada() + ");", s);
        }

        if (est.getWhiles() != null) {
            bd.Modifica("INSERT INTO `t_while`(`IDWHILE`, `IDESTILO`, `PrimeiraChavetaNovaLinha`, `ChavetaUmStatementDentroWhile`, `LinhasEmBrancoDepoisChavetaAberta`, `LinhasEmBrancoDepoisChavetaFechada`, `EspacosWhileParentesAberto`, `EspacosParentesesAbertoCondicao`,`EspacosCondicaoParentesFechado`)"
                    + "VALUES (null," + id + ","
                    + est.getWhiles().isPosicaoPrimeiraChaveta()
                    + "," + est.getWhiles().isChavetaUmStatementDentroWhile()
                    + "," + est.getWhiles().getLinhasEmBrancoDepoisChavetaAberta()
                    + " ," + est.getWhiles().getLinhasEmBrancoDepoisChavetaFechada()
                    + "," + est.getWhiles().getEspacosWhileParentesAberto()
                    + ", " + est.getWhiles().getEspacosParentesesAbertoCondicao()

                    + ", " + est.getWhiles().getEspacosCondicaoParentesFechado() + ")", s);

        }
        
    }

    public boolean VerificaNomeEstilo(String nome) {
        java.sql.Statement s = bd.getStatement();

        ResultSet Rt = null;

        Rt = bd.Le("SELECT * FROM estilos WHERE NOMEESTILO = '" + nome + "';", s);

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
