package View;

import Controller.Controller;
import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;

public class AnalisaConverteView extends JFrame implements Observer {

    Controller Controller;
    AnalisaConvertePanel panel;
    Image Image;

    public AnalisaConverteView(Controller o) {

        super("KSmasher");
        
        Controller = o;
        Controller.addObserver(this);
        

        panel = new AnalisaConvertePanel(Controller);

        addComponents();

        setVisible(true);

        this.setSize(700, 500);
        this.setMinimumSize(new Dimension(650, 450));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        validate();

    }

    public void addComponents() {
//        setTransferHandler(new FileListTransferHandler(DnDFile));
        add(panel);

    }

    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }

}
