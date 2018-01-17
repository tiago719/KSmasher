/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.EstiloProgramacao.EstiloProgramacao;
import Model.Statement.*;
import Model.EstiloProgramacao.*;
import Model.Statement.Statement;
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
public class TextoIT {

    Texto t;

    public TextoIT() {

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

    /**
     * Test of ComecaCataloga method, of class Texto.
     */
    @Test
    public void testComecaCataloga_0args() {
        t = new Texto(new Ficheiros().
                abreFObjectosLeitura("C:\\Users\\edu_f\\Desktop\\main.c"),
                null);
        System.out.println("ComecaCataloga");
        t.ComecaCataloga();

        Texto instance1 = new Texto(new Ficheiros().
                abreFObjectosLeitura("C:\\Users\\edu_f\\Desktop\\main.c"),
                null);

        ArrayList<Statement> listaComparar = new ArrayList<>();
        listaComparar.add(new Include("#include <stdio.h>\r", instance1, null));
        listaComparar.add(new Statement("\n", instance1, null));
        listaComparar.add(new Include("#include <stdlib.h>\r"
                + "\n"
                + "int main()\n"
                + "{\n"
                + "    printf(\"Hello world!\\n\");\n"
                + "    return 0;\n"
                + "}", instance1, null));
        listaComparar.add(new Statement("\n\r\n", instance1, null));
        listaComparar.add(new Funcao("int main()\r\n"
                + "{\n"
                + "    printf(\"Hello world!\\n\");\n"
                + "    return 0;\n"
                + "}", instance1, null, false));
        listaComparar.add(new Statement("\r\n", instance1, null));

        ArrayList<Statement> ArrayGerado = t.getListaStatements();

        for (int i = 0; i < 6; i++) {
            String expected = listaComparar.get(i).getCodigo();
            String actual = ArrayGerado.get(i).getCodigo();
            assertEquals(expected, actual);
        }
    }

    @Test
    public void testComecaAnalisa() {
        t = new Texto(new Ficheiros().
                abreFObjectosLeitura("C:\\Users\\edu_f\\Desktop\\main1.c"),
                null);
        t.ComecaCataloga();
        t.ComecaAnalisa();

        Funcao main = ((Funcao) t.getListaStatements().get(4));

        assertEquals(main.isAntesMain(), true);

        If i = (If) main.getStatementsFilhos().get(1);
        assertEquals(i.getEspacosIfParentesAberto(), 1);
        assertEquals(i.getEspacosParentesesAbertoCondicao(), 5);
        assertEquals(i.getEspacosCondicaoParentesFechado(), 2);
        assertEquals(i.getLinhasEmBrancoDepoisChavetaAberta(), 0);
        assertEquals(i.getLinhasEmBrancoDepoisChavetaFechada(), 2);
        assertEquals(i.isChavetaUmStatementDentroIf(), 1);
        assertEquals(i.getPrimeiraChavetaNovaLinha(), 0);

    }

    @Test
    public void testConverte() {
        t = new Texto(new Ficheiros().
                abreFObjectosLeitura("C:\\Users\\edu_f\\Desktop\\main1.c"),
                null);
        t.ComecaCataloga();
        t.ComecaAnalisa();

        t.ComecaConverte(new EstiloProgramacao(99, "nome", true, new Cast_EP(0),
                new DoWhile_EP(true, 0, 0, 0, 0, 0),
                new Else_EP(true, 1, 1),
                new For_EP(true, true, 1, 0, 0, 1, 0, 1, 1, 1),
                new Funcoes_EP(true),
                new If_EP(true, true, 1, 5, 2, 1, 3),
                new Operador_EP(2, 2), new While_EP(true, true, 1, 3, 5, 5, 5)));
    }

}
