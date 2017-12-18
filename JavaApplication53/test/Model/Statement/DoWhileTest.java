/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Statement;

import Model.EstiloProgramacao.Cast_EP;
import Model.EstiloProgramacao.DoWhile_EP;
import Model.EstiloProgramacao.Else_EP;
import Model.EstiloProgramacao.EstiloProgramacao;
import Model.EstiloProgramacao.For_EP;
import Model.EstiloProgramacao.Funcoes_EP;
import Model.EstiloProgramacao.If_EP;
import Model.EstiloProgramacao.Operador_EP;
import Model.EstiloProgramacao.While_EP;
import Model.Texto;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Diogo´Viana
 */
public class DoWhileTest {
    
     public ArrayList<DoWhile> lista;
    
    public DoWhileTest() {
         lista=new ArrayList<>();
      
        lista.add(new DoWhile("f", new Texto()));
      
        
        EstiloProgramacao estilo=new EstiloProgramacao("EstiloDefeito",false,
                                new Cast_EP(1),
                                new DoWhile_EP(true, 1, 0, 1, 1, 1),
                                new Else_EP(true, 1, 1),
                                new For_EP(true, false, 1, 1, 0, 1, 0, 1, 0, 1, 1),
                                new Funcoes_EP(false),
                                new If_EP(true, false, 1, 1, 1, 1, 1),
                                new Operador_EP(1, 1),
                                new While_EP(true, false, 1, 1, 1, 1, 1));
        
       
        for(DoWhile S : lista)
            S.converteStatement(estilo);
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

   
    /**
     * Test of converteStatement method, of class DoWhile.
     */
    @Test
    public void testConverteStatement() {
       
    }
    
}
