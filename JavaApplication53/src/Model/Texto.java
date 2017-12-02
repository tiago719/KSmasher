/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.Statement.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Tiago Coutinho
 */
public class Texto
{
    private ArrayList<Statement> ListaStatements;
    Utilizador Utilizador;
    
    public Texto()
    {
        ListaStatements=new ArrayList<Statement>();
    }
    public void Regista() throws SQLException
    {
        Utilizador utilizador = new Utilizador();
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
          
                    checkname = utilizador.ExisteUsername(user);
                    checkEmail = utilizador.ExisteEmail(email);
                                                     
                if (checkname || checkEmail){
                    if (checkname) System.out.println("Username já está em uso, tente outro");
                    if (checkEmail) System.out.println("Email já está em uso, tente outro");
                }else {
                    utilizador.AdicionaUtilizador(user, email, pass);
                    System.out.println("Registo feito com sucesso");                  
                }
            } 
            
         else 
            System.out.println("Password e Confirmacao nao correspondem!");
 }
  
 public void Login() throws SQLException
 {
        Utilizador utilizador = new Utilizador();
        Scanner input = new Scanner(System.in);
        System.out.println("LOGIN");
        System.out.printf("Username: ");
        String user = input.next(); 
        System.out.printf("Password: ");
        String pass = input.next();
        
        boolean existelogin = utilizador.VerificaLogin(user, pass);
        if (existelogin)
            System.out.println("Login feito com sucesso!");
        else
            System.out.println("Dados incorretos, tente de novo!");
   
 }
 
}
