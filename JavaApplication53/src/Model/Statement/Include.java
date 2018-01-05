package Model.Statement;

import Model.Texto;

/**
 *
 * @author edu_f
 */
public class Include extends Statement {

    public Include(String codigo, Texto t, Statement Pai) {
        super(codigo, t, Pai);
    }

    @Override
    public String RetiraDados(String Codigo, Texto T) {
        int i;
        for (i = 0; i < Codigo.length(); i++) {
            if (Codigo.charAt(i) == '\n' || Codigo.charAt(i) == '\r') {
                break;
            }
        }
        if (Codigo.length() < i + 1) {
            this.Codigo = Codigo;
        } else {
            this.Codigo = Codigo.substring(0, i + 1);
        }
        this.ParaAnalise = null;
        this.NumCarateresAvancar = i;
        return null;
    }

}
