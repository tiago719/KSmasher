/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Statement;

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
 * @author edu_f
 */
public class IfTest {
    
    public ArrayList<If> lista;

    public IfTest() {
        
        lista=new ArrayList<>();
        lista.add(new If("if (   ola = 5  ){ int a = 5; } else {    }", new Texto()));
        
        for(If S : lista)
            S.analisaStatement();
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
        
        assertEquals(2, lista.get(0).getEspacosCondicaoParentesFechado());
        assertEquals(1, lista.get(0).getEspacosIfParentesAberto());
        assertEquals(3, lista.get(0).getEspacosParentesesAbertoCondicao());
        assertEquals(0, lista.get(0).getLinhasEmBrancoDepoisChavetaAberta());
        assertEquals(0, lista.get(0).getLinhasEmBrancoDepoisChavetaFechada());
        assertEquals(1, lista.get(0).isChavetaUmStatementDentroIf());
        assertEquals(0, lista.get(0).getPrimeiraChavetaNovaLinha());

    }
}
