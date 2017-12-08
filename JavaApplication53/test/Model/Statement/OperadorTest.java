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
        Texto t=new Texto();
        lista=new ArrayList<>();
        lista.add(new Operador("int a/  b  ;",t));
//        lista.add(new Operador("int a +b;",t));
//        lista.add(new Operador("int a  +b;",t));
//        lista.add(new Operador("int a     + b;",t));
//        lista.add(new Operador("int a   +     b;",t));
//        lista.add(new Operador("int a/  ;",t));
//        lista.add(new Operador("int   a   ++    ;",t));
//        lista.add(new Operador("int a+ b   + c;",t));
//        lista.add(new Operador("int a/ ",t));
//        
//
//        
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
        assertEquals(0,lista.get(0).getEspacosVariavelOperador());
        assertEquals(2,lista.get(0).getEspacosOperadorVariavel());
        
        /*assertEquals(0,lista.get(1).getEspacosOperadorVariavel());
        assertEquals(1,lista.get(1).getEspacosVariavelOperador());
        
        assertEquals(0,lista.get(2).getEspacosOperadorVariavel());
        assertEquals(2,lista.get(2).getEspacosVariavelOperador());
        
        assertEquals(1,lista.get(3).getEspacosOperadorVariavel());
        assertEquals(5,lista.get(3).getEspacosVariavelOperador());
        
        assertEquals(5,lista.get(4).getEspacosOperadorVariavel());
        assertEquals(3,lista.get(4).getEspacosVariavelOperador());
        
        assertEquals(2,lista.get(5).getEspacosOperadorVariavel());
        assertEquals(0,lista.get(5).getEspacosVariavelOperador());
        
        assertEquals(4,lista.get(6).getEspacosOperadorVariavel());
        assertEquals(3,lista.get(6).getEspacosVariavelOperador());
        
        assertEquals(1,lista.get(7).getEspacosOperadorVariavel());
        assertEquals(0,lista.get(7).getEspacosVariavelOperador());
        
        assertEquals(1,lista.get(8).getEspacosOperadorVariavel());
        assertEquals(0,lista.get(8).getEspacosVariavelOperador());
*/
    }    
}
