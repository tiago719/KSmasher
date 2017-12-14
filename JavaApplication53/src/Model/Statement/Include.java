package Model.Statement;

import Model.Texto;

/**
 *
 * @author edu_f
 */
public class Include extends Statement {

    public Include(String codigo, Texto t) {
        super(codigo, t);
    }

    @Override
    public String RetiraDados(String Codigo, Texto T) {
        int i;
        for (i = 0; i < Codigo.length(); i++) {
            if (Codigo.charAt(i) == '\n' || Codigo.charAt(i) == '\r') {
                break;
            }
        }

        this.Codigo = Codigo.substring(0, i);
        this.ParaAnalise = null;
        this.NumCarateresAvancar = i;
        return null;
    }

}
