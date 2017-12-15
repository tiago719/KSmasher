/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Statement;

import Model.Texto;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author andre
 */
public class ForTest {
    
    For for1;
    
    public ForTest() {
        for1 =new For("for(i=0; i<6 ; i++) int ola;\n int adues;", new Texto());
        for1.analisaStatement();
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
    

    @Test
    public void testAnalisaStatement() {
        System.out.println("analisaStatement");
        
        
        
        assertEquals(0, for1.getEspacosParentesesAbertoCondicaoInicializacao());
        assertEquals(1, for1.getEspacosInicializacaoPontoVirgula());
        assertEquals(1, for1.getEspacosPontoVirgulaCondicao());
        assertEquals(1, for1.getEspacosCondicaoPontoVirgula());
        assertEquals(1, for1.getEspacosPontoVirgulaIncrementacao());
        assertEquals(0, for1.getEspacosIncrementacaoParentesesFechado());
        assertEquals(-1, for1.getLinhasEmBrancoDepoisChavetaAberta());
        assertEquals(-1, for1.getLinhasEmBrancoDepoisChavetaFechada());
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of converteStatement method, of class For.
     */
    @Test
    public void testConverteStatement() {
        System.out.println("converteStatement");
        For instance = null;
        instance.converteStatement();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of RetiraDados method, of class For.
     */
    @Test
    public void testRetiraDados() {
        System.out.println("RetiraDados");
        String Codigo = "";
        Texto t = null;
        For instance = null;
        String expResult = "";
        String result = instance.RetiraDados(Codigo, t);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
