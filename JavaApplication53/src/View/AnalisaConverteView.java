/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Controller;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

/**
 *
 * @author Tiago Coutinho
 */
public class AnalisaConverteView extends JFrame implements Observer {

    Controller Controller;
    AnalisaConvertePanel panel;
    Image Image;
    File DnDFile;

    public AnalisaConverteView(Controller o) {

        super("KSmasher");
        
        Controller = o;
        Controller.addObserver(this);
        DnDFile = null;

        panel = new AnalisaConvertePanel(Controller, DnDFile);

        addComponents();

        setVisible(true);

        this.setSize(700, 500);
        this.setMinimumSize(new Dimension(650, 450));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        validate();

    }

    public void addComponents() {
        setTransferHandler(new FileListTransferHandler(DnDFile));
        add(panel);

    }

    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }

}
