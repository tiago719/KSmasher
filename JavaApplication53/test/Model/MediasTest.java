/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.EstiloProgramacao.EstiloProgramacao;
import Model.Statement.DoWhile;
import Model.Statement.Else;
import Model.Statement.For;
import Model.Statement.Funcao;
import Model.Statement.If;
import Model.Statement.Operador;
import Model.Statement.Statement;
import Model.Statement.While;
import java.util.ArrayList;
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
public class MediasTest
{
    
    public MediasTest()
    {
        Model m=new Model();
        
        m.Analisa("C:\\Users\\Tiago Coutinho\\Desktop\\Tiago Coutinho\\medias.c", true, "Medias");
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
   public void teste1()
   {
   }
}
