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
 * @author edu_f
 */
public class IfTest {
    
    public ArrayList<If> lista;
    public ArrayList<If> lista2;
    If instance1, instance2, instance3;

    public IfTest() 
    {
        
        lista=new ArrayList<>();
        //lista2=new ArrayList<>();
        lista.add(new If("if (   ola = 5  ){ int a = 5; } else {    }", new Texto()));
        
                for(If S : lista)
            S.analisaStatement();
                
        instance1 = new If("if ( ola==5 )int a++; else{} ", new Texto());
        instance1.analisaStatement();
        instance2= new If("if ( ola==5 )\n{\n\n\n\nint a++;}\n\n\n\n else{} ", new Texto());
        instance2.analisaStatement();
        instance3= new If("if  (  a  ==  0  )\n" +
"	{\n" +
"		\n" +
"		\n" +
"		int a;\n" +
"	}", new Texto());
        
        instance3.analisaStatement();
                
        //lista2.add(new If("if(ola = 5){ int a = 5; int x=6; } else {    }", new Texto()));
        /*
        
        EstiloProgramacao estilo=new EstiloProgramacao("EstiloDefeito",false,
                                new Cast_EP(1),
                                new DoWhile_EP(true, 1, 0, 1, 1, 1),
                                new Else_EP(true, 1, 1),
                                new For_EP(true, false, 1, 1, 0, 1, 0, 1, 0, 1, 1),
                                new Funcoes_EP(false),
                                new If_EP(true, false, 1, 1, 1, 1, 1),
                                new Operador_EP(1, 1),
                                new While_EP(true, false, 1, 1, 1, 1, 1));
        

        for(If S : lista2)
            S.converteStatement(estilo);
        
        instance = new If("if( a  ==  0 )\n" +
"	{\n" +
"		while( a == 0 )\n" +
"		{\n" +
"			a  ++  ;\n" +
"		}\n" +
"		else\n" +
"		{\n" +
"			c  =  (int) 4.0 ;\n" +
"		}\n" +
"	}\n" +
"	do\n" +
"	{\n" +
"		while(true)\n" +
"			b  ++  ;\n" +
"\n" +
"	}while(true);", new Texto());
        
        instance.analisaStatement();
        */
    }

    @Test
    public void testRetiraDados() {
        System.out.println("RetiraDados");
        
        assertEquals(2, lista.get(0).getEspacosCondicaoParentesFechado());
        assertEquals(1, lista.get(0).getEspacosIfParentesAberto());
        assertEquals(3, lista.get(0).getEspacosParentesesAbertoCondicao());
        assertEquals(0, lista.get(0).getLinhasEmBrancoDepoisChavetaAberta());
        assertEquals(0, lista.get(0).getLinhasEmBrancoDepoisChavetaFechada());
        assertEquals(1, lista.get(0).isChavetaUmStatementDentroIf());
        assertEquals(0, lista.get(0).getPrimeiraChavetaNovaLinha());
        
        assertEquals(1, instance1.getEspacosCondicaoParentesFechado());
        assertEquals(1, instance1.getEspacosIfParentesAberto());
        assertEquals(1, instance1.getEspacosParentesesAbertoCondicao());
        assertEquals(-1, instance1.getLinhasEmBrancoDepoisChavetaAberta());
        assertEquals(-1, instance1.getLinhasEmBrancoDepoisChavetaFechada());
        assertEquals(0, instance1.isChavetaUmStatementDentroIf());
        assertEquals(-1, instance1.getPrimeiraChavetaNovaLinha());
        
        assertEquals(1, instance2.getEspacosCondicaoParentesFechado());
        assertEquals(1, instance2.getEspacosIfParentesAberto());
        assertEquals(1, instance2.getEspacosParentesesAbertoCondicao());
        assertEquals(3, instance2.getLinhasEmBrancoDepoisChavetaAberta());
        assertEquals(3, instance2.getLinhasEmBrancoDepoisChavetaFechada());
        assertEquals(1, instance2.isChavetaUmStatementDentroIf());
        assertEquals(1, instance2.getPrimeiraChavetaNovaLinha());
        
        assertEquals(2, instance3.getEspacosCondicaoParentesFechado());
        assertEquals(2, instance3.getEspacosIfParentesAberto());
        assertEquals(2, instance3.getEspacosParentesesAbertoCondicao());
        assertEquals(2, instance3.getLinhasEmBrancoDepoisChavetaAberta());
        assertEquals(0, instance3.getLinhasEmBrancoDepoisChavetaFechada());
        assertEquals(1, instance3.isChavetaUmStatementDentroIf());
        assertEquals(1, instance3.getPrimeiraChavetaNovaLinha());
    }
    /* @Test
    public void testconverte() {
         //assertEquals("if ( ola = 5 ){\n int a = 5;\n int x=6;\n } e",lista2.get(0).Codigo);
    }*/
}
