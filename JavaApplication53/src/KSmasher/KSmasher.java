/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KSmasher;

import Model.BaseDados;
import Model.Utilizador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class KSmasher {

    public static void main(String[] args) throws SQLException{
       Utilizador ut = new Utilizador();
       
       ut.AdicionaUtilizador("André", "andre@gmail.com", "12345");
    }
    
}
