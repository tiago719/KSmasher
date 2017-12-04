package Model;

import Model.EstiloProgramacao.*;
import java.io.BufferedReader;
import java.sql.SQLException;
import Model.Statement.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.PriorityQueue;

public class Texto {
    private ArrayList<Statement> ListaStatements;
    Utilizador Utilizador;//TODO:Falta meter aqui o otuilzador
    int ix;
    String Codigo;
    
    public Texto(BufferedReader In)
    {
        ListaStatements=new ArrayList<Statement>();
        ix=0;
        //In=Codigo;
    }

    public void Regista() throws SQLException {
        Utilizador = new Utilizador();
        Scanner input = new Scanner(System.in);
        System.out.println("REGISTO");
        System.out.printf("Username: ");
        String user = input.next();
        System.out.printf("Email: ");
        String email = input.next();
        System.out.printf("Password: ");
        String pass = input.next();
        System.out.printf("Confirmar Password: ");
        String conf = input.next();

        if (pass.equals(conf)) {
            boolean checkname, checkEmail;

            checkname = Utilizador.ExisteUsername(user);
            checkEmail = Utilizador.ExisteEmail(email);

            if (checkname || checkEmail) {
                if (checkname) {
                    System.out.println("Username já está em uso, tente outro");
                }
                if (checkEmail) {
                    System.out.println("Email já está em uso, tente outro");
                }
            } else {
                Utilizador.AdicionaUtilizador(user, email, pass);
                Utilizador.EstilosProgramacao.add(
                        new EstiloProgramacao("EstiloDefeito", 
                                new Cast_EP(1), 
                                new DoWhile_EP(true, 1, 0, 0, 1, 1, 1), 
                                new Else_EP(true, 1, 1, 1), 
                                new For_EP(true, false, 1, 1, 0, 1, 0, 1, 0, 1, 1), 
                                new Funcoes_EP(false),
                                new If_EP(true, false, 1, 1, 1, 1, 1), 
                                new Inicializacao_EP(1, 1), new Operador_EP(1, 1), 
                                new While_EP(true, false, 1, 1, 1, 1, 1))
                );
                System.out.println("Registo feito com sucesso");
            }
        } else {
            System.out.println("Password e Confirmacao nao correspondem!");
        }
    }

    public void Login() throws SQLException {
        Utilizador utilizador = new Utilizador();
        Scanner input = new Scanner(System.in);
        System.out.println("LOGIN");
        System.out.printf("Username: ");
        String user = input.next();
        System.out.printf("Password: ");
        String pass = input.next();

        boolean existelogin = utilizador.VerificaLogin(user, pass);
        if (existelogin) {
            System.out.println("Login feito com sucesso!");
        } else {
            System.out.println("Dados incorretos, tente de novo!");
        }
    }

    public ArrayList<Statement> getListaStatements() {
        return ListaStatements;
    }

    private boolean isIF(char a[]) {
        boolean ret = true;
        if (a[0] == 'i' && a[1] == 'f') {
            ret = true;
        }

        return ret;
    }

    private boolean isOperador(char A[]) {
        if (A[0] == '+' || A[0] == '-') {
            return true;
        } else if (A[0] == '/' && A[1] != '*') {
            return true;
        }

        return false;
    }

    private boolean isCast(char A[]) {
        if (A[0] == '(' && A[1] == 'i' && A[2] == 'n' && A[3] == 't' && A[4] == ')') {
            return true;
        } else if (A[0] == '(' && A[1] == 'f' && A[2] == 'l' && A[3] == 'o' && A[4] == 'a' && A[5] == 't' && A[6] == ')') {
            return true;
        } else if (A[0] == '(' && A[1] == 'd' && A[2] == 'o' && A[3] == 'u' && A[4] == 'b' && A[5] == 'l' && A[6] == 'e' && A[7] == ')') {
            return true;
        } else if (A[0] == '(' && A[1] == 'c' && A[2] == 'h' && A[3] == 'a' && A[4] == 'r' && A[4] == ')') {
            return true;
        }

        return false;
    }

    private boolean IsFOR(char a[]) {
        boolean ret = false;
        if (a[0] == 'f' && a[1] == 'o' && a[2] == 'r') {
            ret = true;
        }
        return ret;
    }

    public void AdicionaNovoPai(PriorityQueue<ArrayList<Statement>> fp, PriorityQueue<Integer> tc, Statement add) {
        fp.add(add.getListaStatements());
        tc.add(add.getNumCarateresCodigoStatment() + ix);
    }

    public void Cataloga() {
        PriorityQueue<ArrayList<Statement>> filaPais = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> TotalCarateres = new PriorityQueue<>(Collections.reverseOrder());
        ArrayList<Statement> Pai = ListaStatements;
        boolean AspasAberto = false, PlicasAberto = false;

        for (; ix < Codigo.length(); ix++) {
            if (Codigo.charAt(ix) == '"') {
                AspasAberto = !AspasAberto;
            } else if (Codigo.charAt(ix) == '\'') {
                PlicasAberto = !PlicasAberto;
            } else if (!AspasAberto && !PlicasAberto) {
                try {
                    if (isIF(new char[]{Codigo.charAt(ix), Codigo.charAt(ix + 1)})) {
                        If add = new If(Codigo.substring(ix));
                        Pai.add(add);

                        ix += add.getNumComecar();//para comecar a ler depois do if

                        AdicionaNovoPai(filaPais, TotalCarateres, add);

                    }
                    if (isOperador(new char[]{Codigo.charAt(ix), Codigo.charAt(ix + 1)})) {
                        //Operador add = new Operador();
                        char a = 'a';

                        while (a != ';') {
                            if (ix + 1 < Codigo.length()) {
                                a = Codigo.charAt(++ix);
                            } else {
                                break;
                            }
                        }

                        //AdicionaNovoPai(filaPais, TotalCarateres, add);
                    }
                    if (isCast(new char[]{Codigo.charAt(ix), Codigo.charAt(ix + 1), Codigo.charAt(ix + 2),
                        Codigo.charAt(ix + 3), Codigo.charAt(ix + 4), Codigo.charAt(ix + 5), Codigo.charAt(ix + 6),
                        Codigo.charAt(ix + 7)})) {
                        //Cast add = new Cast();

                        char a = 'a';

                        while (a != ';') {
                            if (ix + 1 < Codigo.length()) {
                                a = Codigo.charAt(++ix);
                            } else {
                                break;
                            }
                        }

                        //AdicionaNovoPai(filaPais, TotalCarateres, add);
                    }
                    if (IsFOR(new char[]{Codigo.charAt(ix), Codigo.charAt(ix + 1), Codigo.charAt(ix + 2)})) {
                        For add = new For(Codigo.substring(ix));
                        Pai.add(add);

                        ix += add.getNumComecar();//para comecar a ler depois do if

                        AdicionaNovoPai(filaPais, TotalCarateres, add);
                    }
                } catch (Exception e) {

                }
            }
            if (TotalCarateres.peek() != null && TotalCarateres.peek() == ix) {
                TotalCarateres.remove();
                if (filaPais.peek() != ListaStatements) {
                    Pai = filaPais.remove();
                } else {
                    Pai = ListaStatements;
                }
            }
        }
    }

    @Override
    public String toString() {
        String S = "";
        for (int i = 0; i < ListaStatements.size(); i++) {
            S += ListaStatements.get(i).toString();
        }
        return S;

    }
}
