package KSmasher;

import Controller.Controller;
import Model.EstiloProgramacao.EstiloProgramacao;
import Model.Texto;
import View.AnalisaConverteView;
import View.KSmasherView;

public class KSmasher {

    public static void main(String[] args)
    {

        //KSmasherView view=new KSmasherView(new Controller()); 
        Controller controller=new Controller();
        controller.Converte("C:\\Users\\edu_f\\Google Drive\\ISEC\\1 ano\\1 semestre\\IP\\ficha 6\\6.6", "EstiloDefeito", "tiago");
    }
    
}
