/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Controller;
import static View.Constants.DIM_X_ANALISA;
import static View.Constants.DIM_X_CONVERTE;
import static View.Constants.DIM_X_LOGIN;
import static View.Constants.DIM_X_REGISTO;
import static View.Constants.DIM_Y_ANALISA;
import static View.Constants.DIM_Y_CONVERTE;
import static View.Constants.DIM_Y_LOGIN;
import static View.Constants.DIM_Y_REGISTO;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.File;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

/**
 *
 * @author Tiago Coutinho
 */
public class AnalisaConvertePanel extends JPanel implements Observer
{
    Controller Controller;
    AnalisarFicheiro AnalisarFicheiroPanel;
    ConverterDiretoria ConverterDiretoriaPanel;
    
    public AnalisaConvertePanel(Controller C)
    {
        Controller=C;
        setupComponents();
        setupLayout();
    }
    
    public void setupComponents()
    {
        AnalisarFicheiroPanel=new AnalisarFicheiro(Controller);
        AnalisarFicheiroPanel.start();
        ConverterDiretoriaPanel=new ConverterDiretoria(Controller);
    }
    
    public void setupLayout()
    {   
        JPanel pEste = new JPanel();
        pEste.setMaximumSize(new Dimension(DIM_X_ANALISA, DIM_Y_ANALISA));
        pEste.setMinimumSize(new Dimension(DIM_X_ANALISA, DIM_Y_ANALISA));
        pEste.setPreferredSize(new Dimension(DIM_X_ANALISA, DIM_Y_ANALISA));
        pEste.add(AnalisarFicheiroPanel);
        
//        JPanel pOeste=new JPanel();
//        pOeste.setMaximumSize(new Dimension(DIM_X_CONVERTE, DIM_Y_CONVERTE));
//        pOeste.setMinimumSize(new Dimension(DIM_Y_CONVERTE, DIM_Y_CONVERTE));
//        pOeste.setPreferredSize(new Dimension(DIM_Y_CONVERTE, DIM_Y_CONVERTE));
//        pOeste.add(ConverterDiretoriaPanel);

        JPanel center=new JPanel(new BorderLayout(0,0));
        center.add(pEste, BorderLayout.CENTER);
//        center.add(pEste, BorderLayout.EAST);
        
        add(center);
        
        validate();
        
    }
    
    @Override
    public void update(Observable o, Object arg)
    {
        repaint();
    }
    
}
