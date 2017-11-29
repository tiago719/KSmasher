package Controller;

import Model.Model;
import java.util.Observable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tiago Coutinho
 */
public class Controller extends Observable
{
    Model Model;
    
    public Controller()
    {
        Model=new Model();
    }            
}
