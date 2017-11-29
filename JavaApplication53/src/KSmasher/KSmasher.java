/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KSmasher;

import Model.BaseDados;
import java.sql.SQLException;

public class KSmasher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
           BaseDados.getConexaoMySQL();
       BaseDados.Query("insert into ");
       BaseDados.FecharConexao();
    }
    
}
