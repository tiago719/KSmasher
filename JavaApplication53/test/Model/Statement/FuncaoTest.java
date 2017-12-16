/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Statement;

import Model.Texto;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author andre
 */
public class FuncaoTest {
    Funcao f1;
    public FuncaoTest() {
         f1 =new Funcao("void Soma1(); void main(){} void Soma1(){\\\\nint x;\\\\n}void Soma2(){}", new Texto());
         f1.analisaStatement();
    }
    

    /**
     * Test of isAntesMain method, of class Funcao.
     */
    @Test
    public void testAnalisaStatement() {
        System.out.println("analisaStatement");
      
        assertEquals(true, f1.isAntesMain());    
    }

}
