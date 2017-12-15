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
 * @author Tiago Coutinho
 */
public class OperadorTest
{
    public ArrayList<Operador> lista;
    public OperadorTest()
    {
        
        lista=new ArrayList<>();
        lista.add(new Operador("a    <=   b + c  ", new Texto()));
      
       for(int i=0;i<lista.size();i++)
            lista.get(i).analisaStatement();
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
    /**
     * Test of analisaStatement method, of class Operador.
     */
    @Test
    public void verificaContaEspacos()
    {
        assertEquals(4, lista.get(0).getEspacosVariavelOperador());
        assertEquals(3, lista.get(0).getEspacosOperadorVariavel());
    }    
}
