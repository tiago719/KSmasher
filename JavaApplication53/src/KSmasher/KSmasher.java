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
        controller.Converte("C:\\Users\\Tiago Coutinho\\Desktop\\Trabalho Prático", "EstiloDefeito", "tiago");
    }
    
}
