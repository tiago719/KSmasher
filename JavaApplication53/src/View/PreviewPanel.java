
package View;

import Controller.Controller;
import static View.Constants.DIM_X_PREVIEW;
import static View.Constants.DIM_Y_PREVIEW;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;


public class PreviewPanel extends JPanel implements Observer {

    Controller Controller;
    PreviewResultados previewpanel;

    public PreviewPanel(Controller C) {
        Controller = C;
        setupComponents();
        setupLayout();

    }
    

    public void setupComponents() {
        previewpanel = new PreviewResultados(Controller);
    }

    public void setupLayout() {
        JPanel pEste = new JPanel();
        pEste.setMaximumSize(new Dimension(DIM_X_PREVIEW, DIM_Y_PREVIEW));
        pEste.setMinimumSize(new Dimension(DIM_X_PREVIEW, DIM_Y_PREVIEW));
        pEste.setPreferredSize(new Dimension(DIM_X_PREVIEW, DIM_Y_PREVIEW));
        pEste.add(previewpanel);
         
        JPanel center = new JPanel(new BorderLayout(0, 0));
        center.add(pEste, BorderLayout.CENTER);

        add(center);
       this.setSize(DIM_X_PREVIEW, DIM_Y_PREVIEW);
        validate();
    }

    @Override
    public void update(Observable o, Object o1) {
        repaint();
    }

}
