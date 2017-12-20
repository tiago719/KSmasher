
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


/*public class ForTest {
    
    public ArrayList<For> lista;
    
    public ForTest() {
        
        /*
        lista=new ArrayList<>();
      
        lista.add(new For("for(i=0;i<dscf;i++){gddfhg;fggdsf;fedsc;}e", new Texto()));
      
        
        EstiloProgramacao estilo=new EstiloProgramacao("EstiloDefeito",false,
                                new Cast_EP(1),
                                new DoWhile_EP(true, 1, 0, 1, 1, 1),
                                new Else_EP(true, 1, 1),
                                new For_EP(true, false, 1, 1, 0, 1, 0, 1, 0, 1, 1),
                                new Funcoes_EP(false),
                                new If_EP(true, false, 1, 1, 1, 1, 1),
                                new Operador_EP(1, 1),
                                new While_EP(true, false, 1, 1, 1, 1, 1));
        
        for(For S : lista)
            S.converteStatement(estilo);
        */
   /* }
    
    @Test
    public void testConverteStatement() {
        assertEquals("for ( i=0; i<dscf; i++){\ngddfhg;\nfggdsf;\nfedsc;\n}e",lista.get(0).Codigo);
    }
    */
/*
 * @author andre
 */
 
public class ForTest {
    
    For for1, for2;
    
    public ForTest() {
        for1 =new For("for(;i<6;i++) a;{...}", new Texto());
        for1 =new For("for  (;;){\n\n\n a;}\n\n\n}", new Texto());
        for1.analisaStatement();
        for2.analisaStatement();
    }

    @Test
    public void testAnalisaStatement() {
        System.out.println("analisaStatement");
        
        assertEquals(0, for1.getEspacosForParentesAberto());
        assertEquals(-1, for1.getEspacosParentesesAbertoCondicaoInicializacao());
        assertEquals(-1, for1.getEspacosInicializacaoPontoVirgula());
        assertEquals(0, for1.getEspacosPontoVirgulaCondicao());
        assertEquals(0, for1.getEspacosCondicaoPontoVirgula());
        assertEquals(0, for1.getEspacosPontoVirgulaIncrementacao());
        assertEquals(0, for1.getEspacosIncrementacaoParentesesFechado());
        assertEquals(-1, for1.getLinhasEmBrancoDepoisChavetaAberta());
        assertEquals(-1, for1.getLinhasEmBrancoDepoisChavetaFechada());
        assertEquals(-1, for1.isPosicaoPrimeiraChaveta());
        assertEquals(0,for1.isChavetaUmStatementDentroFor());
        
        assertEquals(2, for2.getEspacosForParentesAberto());
        assertEquals(-1, for2.getEspacosParentesesAbertoCondicaoInicializacao());
        assertEquals(-1, for2.getEspacosInicializacaoPontoVirgula());
        assertEquals(-1, for2.getEspacosPontoVirgulaCondicao());
        assertEquals(-1, for2.getEspacosCondicaoPontoVirgula());
        assertEquals(-1, for2.getEspacosPontoVirgulaIncrementacao());
        assertEquals(-1, for2.getEspacosIncrementacaoParentesesFechado());
        assertEquals(2, for2.getLinhasEmBrancoDepoisChavetaAberta());
        assertEquals(2, for2.getLinhasEmBrancoDepoisChavetaFechada());
        assertEquals(0, for2.isPosicaoPrimeiraChaveta());
        assertEquals(1,for2.isChavetaUmStatementDentroFor());
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of converteStatement method, of class For.
     */
   /* @Test
    public void testConverteStatement() {
        System.out.println("converteStatement");
        For instance = null;
        instance.converteStatement();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
    
}
