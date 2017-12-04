/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Tiago Coutinho
 */
public class Ficheiros
{
    public ObjectOutputStream abreFObjectosEscrita(String nome) throws IOException {
        try {
             ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nome));
            return out;
        } catch (IOException e) {
            System.out.println("Erro ao abrir o ficheiro " + nome);
            throw e;
        }
    }

    public ObjectInputStream abreFObjectosLeitura(String nome) throws IOException {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("main.c"));
            return in;
        } catch (IOException e) {
            System.out.println(e);
            throw e;
        }
    }

    ObjectInputStream abreFObjectosLeitura(File file) throws IOException {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file.getAbsolutePath()));
            return in;
        } catch (IOException e) {
            throw e;
        }
    }

    ObjectOutputStream abreFObjectosEscrita(File file) throws IOException {
        try {
             ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file.getAbsolutePath()));
            return out;
        } catch (IOException e) {
            throw e;
        }
    }
}
