/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.HashMap;

/**
 *
 * @author Tiago Coutinho
 */
public class OperadoresLibrary
{
    private HashMap<Integer,String> OperadoresLibrary;
    
    public OperadoresLibrary()
    {
        int key=0;
        OperadoresLibrary=new HashMap<>();
        
        OperadoresLibrary.put(key++, "+");
        OperadoresLibrary.put(key++, "++");
        OperadoresLibrary.put(key++, "-");
        OperadoresLibrary.put(key++, "+=");
        OperadoresLibrary.put(key++, "--");
        OperadoresLibrary.put(key++, "-=");
        OperadoresLibrary.put(key++, "*=");
        OperadoresLibrary.put(key++, "/");
        OperadoresLibrary.put(key++, "/=");
        OperadoresLibrary.put(key++, "%");
        OperadoresLibrary.put(key++, "%=");
        OperadoresLibrary.put(key++, "<");
        OperadoresLibrary.put(key++, "<=");
        OperadoresLibrary.put(key++, ">*");
        OperadoresLibrary.put(key++, ">=");
        OperadoresLibrary.put(key++, "!=");
        OperadoresLibrary.put(key++, "==");
        OperadoresLibrary.put(key++, "!");
        OperadoresLibrary.put(key++, "&&");
        OperadoresLibrary.put(key++, "||");
        OperadoresLibrary.put(key++, "<<");
        OperadoresLibrary.put(key++, "<<=");
        OperadoresLibrary.put(key++, ">>");
        OperadoresLibrary.put(key++, ">>=");
        OperadoresLibrary.put(key++, "&");
        OperadoresLibrary.put(key++, "&=");
        OperadoresLibrary.put(key++, "|");
        OperadoresLibrary.put(key++, "|=");
        OperadoresLibrary.put(key++, "^");
        OperadoresLibrary.put(key++, ",");
        OperadoresLibrary.put(key++, "?");
        OperadoresLibrary.put(key++, ":");
        OperadoresLibrary.put(key++, "*");
    }

    public HashMap<Integer, String> getOperadoresLibrary()
    {
        return OperadoresLibrary;
    }    
}
