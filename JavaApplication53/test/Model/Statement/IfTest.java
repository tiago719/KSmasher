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
 * @author edu_f
 */
public class IfTest {

    If instance;
    Texto T;

    public IfTest() {
        String Codigo = "if (   ola = 5  (((())))    ){ int a = 5; /*testar*/ }   else {    }";
        T = null;
        instance = new If(Codigo, T);
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
     * Test of RetiraDados method, of class If.
     */
    @Test
    public void testRetiraDados() {
        System.out.println("RetiraDados");


        assertEquals("if (   ola = 5  (((())))    ){ int a = 5; /*testar*/ }   else {    }", instance.ParaAnalise);
        assertEquals("if (   ola = 5  (((())))    )", instance.Codigo);
        
        assertEquals("if (   ola = 5  (((())))    )", instance.Codigo);
    }

    /**
     * Test of getCondicao method, of class If.
     */
    @Test
    public void testGetCondicao() {
        System.out.println("getCondicao");
        Statement expResult = new Statement("ola = 5", T);
        Statement result = instance.getCondicao();
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
