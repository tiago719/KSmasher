package KSmasher;

import Controller.Controller;
import Model.EstiloProgramacao.EstiloProgramacao;
import Model.Texto;
import View.AnalisaConverteView;
import View.KSmasherView;

public class KSmasher {

    public static void main(String[] args)
    {
//        KSmasherView view=new KSmasherView(new Controller());
        
        Controller c = new Controller();
        c.Analisa("C:\\Users\\edu_f\\Google Drive\\ISEC\\1 ano\\1 semestre\\IP\\ficha 6\\6.3\\main.c", true, "OLA");
        Texto t = new Texto("#include <stdio.h>\n" +
"#include <stdlib.h>\n" +
"\n" +
"//nao acabado\n" +
"\n" +
"void reuniao (int a[], int b[], int n, int r[]){\n" +
"    int i;\n" +
"\n" +
"    for (i = 0; i<n; i++){\n" +
"        if (a[i] || b[i])\n" +
"            r[i]=1;\n" +
"        else\n" +
"            r[i] = 0;\n" +
"    }\n" +
"\n" +
"}\n" +
"void intersecao (int a[], int b[], int n, int r[]){\n" +
"    int i;\n" +
"\n" +
"    for (i = 0; i<n; i++){\n" +
"        if (a[i] && b[i])\n" +
"            r[i]=1;\n" +
"        else\n" +
"            r[i] = 0;\n" +
"    }\n" +
"\n" +
"}\n" +
"\n" +
"void diferenca (int a[], int b[], int n, int r[]){\n" +
"    int i;\n" +
"\n" +
"    for (i = 0; i<n; i++){\n" +
"        if (a[i] && !b[i])\n" +
"            r[i]=1;\n" +
"        else\n" +
"            r[i] = 0;\n" +
"    }\n" +
"\n" +
"}\n" +
"\n" +
"int main()\n" +
"{\n" +
"    int a[n] = {1,0,0,0,1,1,0,0,1};\n" +
"    int b[n] = {1,0,0,0,0,0,0,0,1};\n" +
"    int c[n] ;\n" +
"\n" +
"    reuniao(a,b,n,c);\n" +
"    intersecao(a,b,n,c);\n" +
"    diferenca(a,b,n,c);\n" +
"\n" +
"\n" +
"}");
        
        t.ComecaConverte(c.getEstilosUtilizador().get(0));
        System.out.println(t);

    }
    
}
