/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Statement;

import Model.EstiloProgramacao.EstiloProgramacao;
import Model.Texto;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tiago Coutinho
 */
public class ElseTest
{
    Else instance;
    public ElseTest()
    {
        instance= new Else("Else{a++;}", new Texto());
        
        instance.analisaStatement();
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }
    
    @Before
    public void setUp()
    {
    }
    
    @After
    public void tearDown()
    {
    }

   @Test
   public void testAnalisa() 
   {
       assertEquals(0, instance.getLinhasEmBrancoDepoisChavetaAberta());
       assertEquals(0, instance.getLinhasEmBrancoDepoisChavetaFechada());
       assertEquals(0, instance.getPrimeiraChavetaNovaLinha());

   }
}
