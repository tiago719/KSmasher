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
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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
        lista.add(new While("while (   ola = 5  )           { int a = 5;       }   else {    }", new Texto()));
        lista.add(new While("while (   ola = 5  )int a = 5;  else {    }", new Texto()));
        lista.add(new While("while (   ola = 5  )\n{int a = 5;}\n\n\n  else {    }", new Texto()));

        for(While S : lista)
            S.analisaStatement();
    }
    /*
    @Test
    public void VerificaconverteStatement()
    {
       EstiloProgramacao es = new EstiloProgramacao(0,"EstiloDefeito",false,
                                new Cast_EP(1),
                                new DoWhile_EP(true, 1, 0, 1, 1, 1),
                                new Else_EP(true, 1, 1),
                                new For_EP(true, 1, 1, 0, 1, 0, 1, 0, 1, 1),
                                new Funcoes_EP(false),
                                new If_EP(true, 1, 1, 1, 1, 1),
                                new Operador_EP(1, 1),
                                new While_EP(true, 1, 1, 1, 1, 1));
        w.converteStatement(es);

//        assertEquals(3, lista.get(0).getEspacosParentesesAbertoCondicao());
        */
    @Test
    public void VerificaconverteStatement()
    {
        assertEquals(1,lista.get(0).isChavetaUmStatementDentroWhile());
        assertEquals(0,lista.get(0).isPrimeiraChavetaNovaLinha());
        assertEquals(1,lista.get(0).getEspacosWhileParentesAberto());
        assertEquals(3,lista.get(0).getEspacosParentesesAbertoCondicao());
        assertEquals(2,lista.get(0).getEspacosCondicaoParentesFechado());
        assertEquals(0,lista.get(0).getLinhasEmBrancoDepoisChavetaAberta());
        assertEquals(0, lista.get(0).getLinhasEmBrancoDepoisChavetaFechada());
        
        assertEquals(0,lista.get(1).isChavetaUmStatementDentroWhile());
        assertEquals(-1,lista.get(1).isPrimeiraChavetaNovaLinha());
        assertEquals(1,lista.get(1).getEspacosWhileParentesAberto());
        assertEquals(3,lista.get(1).getEspacosParentesesAbertoCondicao());
        assertEquals(2,lista.get(1).getEspacosCondicaoParentesFechado());
        assertEquals(-1,lista.get(1).getLinhasEmBrancoDepoisChavetaAberta());
        assertEquals(-1, lista.get(1).getLinhasEmBrancoDepoisChavetaFechada());
        
        assertEquals(1,lista.get(2).isChavetaUmStatementDentroWhile());
        assertEquals(1,lista.get(2).isPrimeiraChavetaNovaLinha());
        assertEquals(1,lista.get(2).getEspacosWhileParentesAberto());
        assertEquals(3,lista.get(2).getEspacosParentesesAbertoCondicao());
        assertEquals(2,lista.get(2).getEspacosCondicaoParentesFechado());
        assertEquals(0,lista.get(2).getLinhasEmBrancoDepoisChavetaAberta());
        assertEquals(2, lista.get(2).getLinhasEmBrancoDepoisChavetaFechada());
    }
}
