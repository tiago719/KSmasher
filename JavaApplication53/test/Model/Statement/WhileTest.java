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
public class WhileTest
{
    public ArrayList<While> lista;
    
    public WhileTest()
    {
        lista=new ArrayList<>();
        lista.add(new While("while ( true ) \na++;", new Texto()));
        
        for(While S : lista)
            S.analisaStatement();
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
    public void verificaAnalisa()
    {
        assertEquals(0,lista.get(0).isChavetaUmStatementDentroWhile());
        assertEquals(-1,lista.get(0).isPosicaoPrimeiraChaveta());
        assertEquals(0,lista.get(0).getEspacosWhileParentesAberto());
        assertEquals(0,lista.get(0).getEspacosParentesesAbertoCondicao());
        assertEquals(0,lista.get(0).getEspacosCondicaoParentesFechado());
        assertEquals(-1,lista.get(0).getLinhasEmBrancoDepoisChavetaAberta());

    }
}
