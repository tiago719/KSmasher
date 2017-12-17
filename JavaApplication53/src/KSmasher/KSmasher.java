package KSmasher;

import Controller.Controller;
import View.AnalisaConverteView;
import View.KSmasherView;

public class KSmasher {

    public static void main(String[] args)
    {
        //new AnalisaConverteView(new Controller());
        KSmasherView view=new KSmasherView(new Controller());
    }
    
}
