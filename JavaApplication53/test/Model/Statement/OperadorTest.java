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
        EstiloProgramacao estilo=new EstiloProgramacao(1,"EstiloDefeito",false,
                                new Cast_EP(1),
                                new DoWhile_EP(true, 1, 0, 1, 1, 2),
                                new Else_EP(true, 1, 1),
                                new For_EP(true, true,1, 1, 0, 1, 0, 1, 0, 1, 1),
                                new Funcoes_EP(false),
                                new If_EP(true, true,1, 1, 1, 1, 1),
                                new Operador_EP(3, 2),
                                new While_EP(true, true,1, 1, 1, 1, 1));
        
        lista=new ArrayList<>();
        lista.add(new Operador("a  ==  0", new Texto()));
        lista.add(new Operador("a<0", new Texto()));
        lista.add(new Operador("a          <<=     0", new Texto()));
      
       for(int i=0;i<lista.size();i++)
       {
            lista.get(i).analisaStatement();
            lista.get(i).converteStatement(estilo);
       }
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
        assertEquals(2, lista.get(0).getEspacosVariavelOperador());
        assertEquals(2, lista.get(0).getEspacosOperadorVariavel());
        assertEquals("a  ==  0", lista.get(0).ParaAnalise);
        
        assertEquals("  ==   ", lista.get(0).getCodigo());
        assertEquals("  <   ", lista.get(1).getCodigo());
        assertEquals("  <<=   ", lista.get(2).getCodigo());
    }    
}
