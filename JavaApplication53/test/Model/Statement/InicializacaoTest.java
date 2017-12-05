/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Statement;

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
public class InicializacaoTest
{
    public ArrayList<Inicializacao> lista;    
    
    public InicializacaoTest()
    {
        lista=new ArrayList<>();
        lista.add(new Inicializacao("int a=0;"));
        lista.add(new Inicializacao("int a   =0;"));
        lista.add(new Inicializacao("int a   = 0;"));

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
                
        assertEquals(0,lista.get(0).getEspacosBrancoVariavelIgual());
        assertEquals(0,lista.get(0).getEspacosBrancoIgualValor());
        
        assertEquals(3,lista.get(1).getEspacosBrancoVariavelIgual());
        assertEquals(0,lista.get(1).getEspacosBrancoIgualValor());
        
        assertEquals(3,lista.get(2).getEspacosBrancoVariavelIgual());
        assertEquals(1,lista.get(2).getEspacosBrancoIgualValor());
    }
    
    @After
    public void tearDown()
    {
    }
}
