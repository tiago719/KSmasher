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
public class DoWhileTest
{ 
    DoWhile instance;
    public DoWhileTest()
    {
        instance= new DoWhile("do\n\n\t\r{\n\n\n\nint a;\nint b;\n\n\n}\nwhile (   a>0  );\n\n\n\n\n\n\n\nfunca();}", new Texto());
        
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
       assertEquals(2, instance.getEspacosCondicaoParentesFechado());
       assertEquals(3, instance.getEspacosParentesesAbertoCondicao());
       assertEquals(1, instance.getEspacosWhileParentesesAberto());
       assertEquals(3, instance.getLinhasEmBrancoDepoisChavetaAberta());
       assertEquals(1, instance.getLinhasEmBrancoDepoisChavetaFechada());
       assertEquals(1, instance.getPrimeiraChavetaNovaLinha());

   }
    
}
