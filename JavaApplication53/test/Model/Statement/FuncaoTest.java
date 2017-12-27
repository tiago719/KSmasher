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
 * @author Diogo´Viana
 */

public class FuncaoTest {
    
    public ArrayList<Funcao> lista;
    
    public FuncaoTest() {
         /* 
        lista=new ArrayList<>();
      
        lista.add(new Funcao("int main(ghj){gg}int sum(intx,inty){}", new Texto()));
      
        
        EstiloProgramacao estilo=new EstiloProgramacao("EstiloDefeito",false,
                                new Cast_EP(1),
                                new DoWhile_EP(true, 1, 0, 1, 1, 1),
                                new Else_EP(true, 1, 1),
                                new For_EP(true, false, 1, 1, 0, 1, 0, 1, 0, 1, 1),
                                new Funcoes_EP(false),
                                new If_EP(true, false, 1, 1, 1, 1, 1),
                                new Operador_EP(1, 1),
                                new While_EP(true, false, 1, 1, 1, 1, 1));
        
       
        for(Funcao S : lista)
            S.converteStatement(estilo);
        */
    }
  
  /*
public class FuncaoTest {
    Funcao f1;
    public FuncaoTest() {
         f1 =new Funcao("void Soma1(); void main(){} void Soma1(){\\\\nint x;\\\\n}void Soma2(){}", new Texto());
         f1.analisaStatement();
    }
    

    /**
     * Test of isAntesMain method, of class Funcao.

    @Test
    public void testAnalisaStatement() {
        System.out.println("analisaStatement");
      
        assertEquals(true, f1.isAntesMain());    
    }
*/
}
