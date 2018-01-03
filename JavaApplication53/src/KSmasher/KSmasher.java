package KSmasher;

import Controller.Controller;
import Model.EstiloProgramacao.EstiloProgramacao;
import Model.Texto;
import View.KSmasherView;

public class KSmasher {

    public static void main(String[] args)
    {
        KSmasherView view=new KSmasherView(new Controller()); 
//        Controller c=new Controller();
//        c.Converte("C:\\Users\\edu_f\\Desktop\\converter", 0, "tiago");
    }
    
}
