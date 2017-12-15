/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Controller;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Tiago Coutinho
 */
public class LoginPanel extends JPanel implements Observer
{
    Controller Controller;
    JTextField usernameF;
    JLabel tituloL,  usernameL, passwordL;
    JPasswordField passwordF;
    JButton login;
    
    public LoginPanel(Controller o)
    {
        Controller=o;
        
        o.addObserver(this);
        
        setupComponents();
        setupLayout();
        
        setBackground(Color.WHITE);
    }
    
    public void setupComponents()
    {
        usernameF=new JTextField();
        usernameF.setPreferredSize(new Dimension(Constants.DIM_Y_TEXT_FIELD, Constants.DIM_X_TEXT_FIELD));   
        passwordF=new JPasswordField();
        passwordF.setPreferredSize(new Dimension(Constants.DIM_Y_TEXT_FIELD, Constants.DIM_X_TEXT_FIELD)); 
        
        tituloL=new JLabel("Login");
        tituloL.setFont(new Font("Serif", Font.BOLD, 25));
        usernameL=new JLabel("Nome de Utilizador:");
        passwordL=new JLabel("Palavra-Passe:");
        
        login=new JButton("Entrar");
    }
    
    public void setupLayout()
    {
        setLayout(new BorderLayout());
        
        Box box=Box.createVerticalBox();
        
        box.add(tituloL);
        box.add(usernameL);
        box.add(usernameF);
        box.add(passwordL);
        box.add(passwordF);
        box.add(login);
        
        add(box);
        validate();

    }
    
    @Override
    public void update(Observable o, Object arg)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
