/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.EstiloProgramacao.EstiloProgramacao;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class PesquisasTest {
    
     Pesquisas s;
    public PesquisasTest() {
       s = new Pesquisas();
    }
    
    //COMPLETA
    @Test
    public void testExisteUsername() throws Exception {
        System.out.println("ExisteUsername");
        String Username = "AndreMTrinade";
        boolean result = s.ExisteUsername(Username);
        assertEquals(true, result);
    }

    //COMPLETA
    @Test
    public void testExisteEmail() throws Exception {
        System.out.println("ExisteEmail");
        String Username = "andr";
        boolean result = s.ExisteEmail(Username);
        assertEquals(false, result);
    }

    ////Testar
    @Test
    public void testVerificaLogin() throws Exception {
        boolean result = s.VerificaLogin("asdas","asdasd");
        assertEquals(false, result);
    }

    ///COMPLETA
    @Test
    public void testGetUser() throws Exception {
        System.out.println("getUser");
         Utilizador result = s.getUser("AndreMTrinade");
        assertEquals(1, result.getId());
    }
    
    @Test 
    public void testDevolveEstilo()
    {
        System.out.println("getUser");
         ArrayList<EstiloProgramacao> result = s.DevolveEstilosProgramacaoUtilizador(1);
         assertEquals(3, result.size());
    }
}
