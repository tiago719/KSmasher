package KSmasher;

import Controller.Controller;
import Model.Texto;
import View.RegistoLoginView;

public class KSmasher {

    public static void main(String[] args)
    {
        RegistoLoginView view=new RegistoLoginView(new Controller());
    }
    
}
