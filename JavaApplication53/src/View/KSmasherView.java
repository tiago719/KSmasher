/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Controller;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Tiago Coutinho
 */
public class KSmasherView extends JFrame implements Observer
{
    Controller Controller;
    JPanel PainelPrincipal;
    AnalisaConvertePanel AnalisaConvertePanel;
    RegistoLoginPanel RegistoLoginPanel;
    
    public KSmasherView(Controller o)
    {
        super("KSmasher");
        Controller=o;
        Controller.addObserver(this);
                
        AnalisaConvertePanel=new AnalisaConvertePanel(Controller,null);
        RegistoLoginPanel=new RegistoLoginPanel(Controller);
        CardLayout cl;
        
        PainelPrincipal=new JPanel(cl=new CardLayout());
        PainelPrincipal.add(RegistoLoginPanel, "RegistoLogin");
        PainelPrincipal.add(AnalisaConvertePanel, "AnalisaConverte");
        cl.first(PainelPrincipal);
        
        RegistoLoginPanel.setCardPanel(PainelPrincipal);
        
        addComponents();
        
        setVisible(true);
        
        this.setSize(700, 500);
        this.setMinimumSize(new Dimension(650, 450));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        validate();

    }
    
    public void addComponents()
    {
        Container cp=getContentPane();
        
        cp.setLayout(new BorderLayout());
        cp.add(PainelPrincipal,BorderLayout.CENTER);
    }

    @Override
    public void update(Observable o, Object arg)
    {
        repaint();
    }
}
