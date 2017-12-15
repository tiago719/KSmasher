/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Tiago Coutinho
 */
public class Ficheiros
{

    public BufferedReader abreFObjectosLeitura(String nome){
        try {
            BufferedReader in = new BufferedReader(new FileReader(nome));
            return in;
        } catch (IOException e) {
            System.out.println(e);
        }
        return null;
    }
    
    public BufferedWriter abreFObjectosEscrita(String nome)
    {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(nome));
            return out;
        } catch (IOException e) {
            System.out.println(e);
        }
        return null;
    }
}
