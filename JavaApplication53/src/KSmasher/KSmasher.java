/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KSmasher;

import Controller.Controller;
import Model.Model;
import Model.Texto;
import Model.Utilizador;
import View.InterfaceTexto;
import java.sql.SQLException;

public class KSmasher {

    public static void main(String[] args){
      /*Utilizador ut = new Utilizador();
       
        try {
            ut.AdicionaUtilizador("André", "andre@gmail.com", "12345");
        } catch (SQLException ex) {

        }*/
      
      InterfaceTexto Ui= new InterfaceTexto(new Controller());
    }
    
}
