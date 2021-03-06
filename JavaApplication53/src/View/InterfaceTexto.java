
package View;

import Controller.Controller;
import Model.EstiloProgramacao.Cast_EP;
import Model.EstiloProgramacao.DoWhile_EP;
import Model.EstiloProgramacao.Else_EP;
import Model.EstiloProgramacao.EstiloProgramacao;
import Model.EstiloProgramacao.For_EP;
import Model.EstiloProgramacao.Funcoes_EP;
import Model.EstiloProgramacao.If_EP;
import Model.EstiloProgramacao.Operador_EP;
import Model.EstiloProgramacao.While_EP;
import Model.Utilizador;
import java.sql.SQLException;
import java.util.Scanner;


public class InterfaceTexto
{
    private Controller Controller;
    
    public InterfaceTexto(Controller C)
    {
        Controller=C;
        
    }
    
    public void Regista(){
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

        if (pass.equals(conf)) 
        {
            boolean  checkEmail;
            int checkname;


            checkname = 1;//Controller.ExisteUsername(user);
            checkEmail = false;//Controller.ExisteEmail(email);

            if (checkname==1 || checkEmail) {
                if (checkname==1) {
                    System.out.println("Username já está em uso, tente outro");
                }
                if (checkEmail) {
                    System.out.println("Email já está em uso, tente outro");
                }
            } else {
                Controller.Regista(user,email,pass);
                System.out.println("Registo feito com sucesso");
            }
        } else {
            System.out.println("Password e Confirmacao nao correspondem!");
        }
    }
    
    public void Login()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("LOGIN");
        System.out.printf("Username: ");
        String user = input.next();
        System.out.printf("Password: ");
        String pass = input.next();

        boolean existelogin = Controller.Login(user, pass);
        if (existelogin) {
            System.out.println("Login feito com sucesso!");
        } else {
            System.out.println("Dados incorretos, tente de novo!");
        }
    }
}
