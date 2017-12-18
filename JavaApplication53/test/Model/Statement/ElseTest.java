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
        instance= new Else("else\n" +
"		{\n" +
"			\n" +
"			c  =  (int) 4.0 ;\n" +
"		}\n" +
"		\n" +
"		\n" +
"	}\n" +
"	\n" +
"	do\n" +
"	{\n" +
"		while(true)\n" +
"			b  ++  ;\n" +
"\n" +
"	}while(true);\n" +
"}\n" +
"\n" +
"int funcA()\n" +
"{\n" +
"	a  ++  ;\n" +
"}\n" +
"int funcB()\n" +
"{\n" +
"	b  ++  ;\n" +
"}\n" +
"int funcC()\n" +
"{\n" +
"	c  ++  ;\n" +
"}", new Texto());
        
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
       assertEquals(1, instance.getLinhasEmBrancoDepoisChavetaAberta());
       assertEquals(2, instance.getLinhasEmBrancoDepoisChavetaFechada());
       assertEquals(1, instance.getPrimeiraChavetaNovaLinha());

   }
}
