/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Statement;

import Model.EstiloProgramacao.EstiloProgramacao;
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
 * @author Diogo´Viana
 */
public class CastTest {
    
     public ArrayList<Cast> lista;
     
    public CastTest() {
        
        
        lista=new ArrayList<>();
        lista.add(new Cast("( int )o", new Texto()));
        
        for(Cast S : lista)
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
    
    @Test
    public void testAnalisaStatement() {
        
       assertEquals(0,lista.get(0).getEspacosEntreCastVariavel());
      
    }

    
}
