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
//         EstiloProgramacao estilo=new EstiloProgramacao(1,"EstiloDefeito",false,
//                                new Cast_EP(5),
//                                new DoWhile_EP(true, 1, 0, 1, 1, 2),
//                                new Else_EP(true, 1, 1),
//                                new For_EP(true, true,1, 1, 0, 1, 0, 1, 0, 1, 1),
//                                new Funcoes_EP(false),
//                                new If_EP(true, true,1, 1, 1, 1, 1),
//                                new Operador_EP(3, 2),
//                                new While_EP(true, true,1, 1, 1, 1, 1));
//         
//        instance= new Else("else\n" +
//"		{\n" +
//"			\n" +
//"			c  =  (int) 4.0 ;\n" +
//"		}\n" +
//"		\n" +
//"		\n" +
//"	}\n" +
//"	\n" +
//"	do\n" +
//"	{\n" +
//"		while(true)\n" +
//"			b  ++  ;\n" +
//"\n" +
//"	}while(true);\n" +
//"}\n" +
//"\n" +
//"int funcA()\n" +
//"{\n" +
//"	a  ++  ;\n" +
//"}\n" +
//"int funcB()\n" +
//"{\n" +
//"	b  ++  ;\n" +
//"}\n" +
//"int funcC()\n" +
//"{\n" +
//"	c  ++  ;\n" +
//"}", new Texto());
//        
//        instance.analisaStatement();
//        //instance.converteStatement(estilo);
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
//       assertEquals(1, instance.getLinhasEmBrancoDepoisChavetaAberta());
//       assertEquals(2, instance.getLinhasEmBrancoDepoisChavetaFechada());
//       assertEquals(1, instance.getPrimeiraChavetaNovaLinha());
//       
//       assertEquals("else\n" +
//"		{\n" +
//"			\n" +
//"			c  =  (int) 4.0 ;\n" +
//"		}\n" +
//"		\n" +
//"		\n" +
//"	}\n",instance.getCodigo());

   }
}
