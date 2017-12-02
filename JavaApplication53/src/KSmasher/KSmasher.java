/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KSmasher;

import View.InterfaceTexto;
import Model.BaseDados;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KSmasher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            BaseDados.getConexaoMySQL();
            BaseDados.Query("insert into ");
            BaseDados.FecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(KSmasher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
