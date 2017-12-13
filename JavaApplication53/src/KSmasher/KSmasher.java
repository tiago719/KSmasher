package KSmasher;

import Model.Texto;

public class KSmasher {

    public static void main(String[] args){
        Texto t = new Texto("int main()\n" +
"{\n" +
"    float b_a=500, b_b=1500, t_a=5.2, t_b=1.8;\n" +
"    int anos=0;\n" +
"    while (b_a < b_b){\n" +
"        b_a += (t_a/100)*b_a;\n" +
"        b_b += (t_b/100)*b_b;\n" +
"        anos++;\n" +
"\n" +
"        printf(\"b_a: %.2f\\tb_b: %.2f\\n\",b_a,b_b);\n" +
"    }\n" +
"\n" +
"    printf(\"Anos: %d\",anos);\n" +
"\n" +
"}");
        System.out.println(t);
    }
    
}
