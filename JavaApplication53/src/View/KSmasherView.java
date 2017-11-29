/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Controller;
import static View.Constants.DIM_X_FRAME;
import static View.Constants.DIM_Y_FRAME;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;

/**
 *
 * @author Tiago Coutinho
 */
public class KSmasherView extends JFrame implements Observer
{
    Controller Controller;
    KSmasherPanel Panel;
    
    public KSmasherView(Controller C)
    {
        this(C, 0, 0, DIM_X_FRAME, DIM_Y_FRAME);
    }
    
    public KSmasherView(Controller C, int X, int Y, int Width, int Height)
    {
        super("KSmasher");
        
        Controller=C;
        
        Controller.addObserver(this);
    }
    
    @Override
    public void update(Observable O, Object Arg)
    {
        repaint();
    }
    
}
