/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Controller;
import static View.Constants.DIM_X_LOGIN;
import static View.Constants.DIM_X_REGISTO;
import static View.Constants.DIM_Y_LOGIN;
import static View.Constants.DIM_Y_REGISTO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 *
 * @author Tiago Coutinho
 */
public class RegistoLoginPanel extends JPanel implements Observer
{
    Controller Controller;
    Registo registoPanel;
    Login loginPanel;
    
    public RegistoLoginPanel(Controller o)
    {
        Controller=o;
        
        setupComponents();
        setupLayout();
    }
    
    public void setupComponents()
    {
        registoPanel=new Registo(Controller);
        loginPanel=new Login(Controller);
    }
    
    public void setupLayout()
    {   
        JPanel pEste = new JPanel();
        pEste.setMaximumSize(new Dimension(DIM_X_LOGIN, DIM_Y_LOGIN));
        pEste.setMinimumSize(new Dimension(DIM_X_LOGIN, DIM_Y_LOGIN));
        pEste.setPreferredSize(new Dimension(DIM_X_LOGIN, DIM_Y_LOGIN));
        pEste.add(new Login(Controller));
        
        JPanel pOeste=new JPanel();
        pOeste.setMaximumSize(new Dimension(DIM_X_REGISTO, DIM_Y_REGISTO));
        pOeste.setMinimumSize(new Dimension(DIM_X_REGISTO, DIM_Y_REGISTO));
        pOeste.setPreferredSize(new Dimension(DIM_X_REGISTO, DIM_Y_REGISTO));
        pOeste.add(registoPanel);

        JPanel center=new JPanel(new BorderLayout(100,0));
        center.add(pOeste, BorderLayout.WEST);
        center.add(pEste, BorderLayout.EAST);
        
        add(center);
        
        validate();
        
    }

    @Override
    public void update(Observable o, Object arg)
    {
        repaint();
    }
}
