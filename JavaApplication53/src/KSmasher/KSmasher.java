/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KSmasher;

import Controller.Controller;
import Model.Texto;
import java.io.BufferedReader;

public class KSmasher {

    public static void main(String[] args){

        Texto t = new Texto("for(a = 0; a < 5; a++){ int a = 5;  }   else {    }");
        System.out.println(t);
    }
    
}
