package Model;

import Model.Statement.Comentario;
import java.io.BufferedReader;
import Model.Statement.*;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Texto {

    private ArrayList<Statement> ListaStatements;
    BufferedReader TextoBR;
    BufferedWriter TextoBW;

    int cont=0, Nivel;

    /**
     * Para Analizar
     *
     * @param In
     */
    public Texto() {
        //TODO: So para os testes, apagar depois
    }


    public Texto(BufferedReader In, BufferedWriter Out) {
        ListaStatements = new ArrayList<Statement>();
        TextoBR = In;
        TextoBW = Out;
    }

    //TODO: PARA TESTES
    public Texto(String Codigo) {
        ListaStatements = new ArrayList<Statement>();
        ListaStatements = Cataloga(Codigo, null);

    }

    public void ComecaCataloga() {
        String Codigo = null;

        try {
            Codigo = org.apache.commons.io.IOUtils.toString(TextoBR);
        } catch (IOException ex) {
            System.out.println("Deu erro a passar o bufferedReader para string");
        }
        ListaStatements = Cataloga(Codigo,null);
        int nivel=0;
    }

    public void ComecaAnalisa() {
        Analisa(ListaStatements);
    }
    
    public int getNivel()
    {
        return Nivel;
    }
    
    public void setNivel(int nivel)
    {
        this.Nivel=nivel;
    }

    private void Analisa(ArrayList<Statement> Lista) {
        for (Statement s : Lista) {
            if (s.hasFilhos()) {
                Analisa(s.getStatementsFilhos());
            } else {
                s.analisaStatement();
            }
        }
    }

    public void ComecaConverte() {
        Converte(ListaStatements);
    }

    private void Converte(ArrayList<Statement> Lista) {
        for (Statement S : Lista) {
            if (S.hasFilhos()) {
                Converte(S.getStatementsFilhos());
            } else {
                S.analisaStatement();
            }
        }
    }

    public ArrayList<Statement> getListaStatements() {
        return ListaStatements;
    }

    private boolean IsInclude(char A) {
        if (A == '#') {
            return true;
        }
        return false;
    }

    private boolean IsComentario(char A[]) {
        if ((A[0] == '/' && A[1] == '/') || (A[0] == '/' && A[1] == '*')) {
            return true;
        }
        return false;
    }

    private boolean IsCaracter(char A) {
        char c;

        if (Character.isDigit(A)) {
            return true;
        }

        return Character.toUpperCase(A) >= 'A' && Character.toUpperCase(A) <= 'Z';
    }

    private boolean IsIF(char A[]) {
        boolean Ret = false;
        if (!IsCaracter(A[0]) && A[1] == 'i' && A[2] == 'f' && (A[3] == '(' || Character.isWhitespace(A[3]))) {
            Ret = true;
        }

        return Ret;
    }


    private boolean IsElse(char A[]) {
        if (!(IsCaracter(A[0])) && A[1] == 'e' && A[2] == 'l' && A[3] == 's' && A[4] == 'e' && (A[5] == '{' || Character.isWhitespace(A[5]))) {

            return true;
        }
        return false;
    }

    public boolean IsDoWhile(char A[]) {
        boolean Ret = false;
        if (!IsCaracter(A[0]) && A[1] == 'd' && A[2] == 'o' && (A[3] == '{' || Character.isWhitespace(A[3]))) {
            Ret = true;
        }

        return Ret;
    }

    public boolean IsWhile(char A[]) {
        boolean Ret = false;
        if (!IsCaracter(A[0]) && A[1] == 'w' && A[2] == 'h' && A[3] == 'i' && A[4] == 'l' && A[5] == 'e' && (A[6] == '(' || Character.isWhitespace(A[6]))) {
            Ret = true;
        }

        return Ret;
    }

    public boolean IsOperador1(char S) {

        if (Character.isWhitespace(S)) {
            return false;
        }

        for (char Operador : Constantes.OPERADORES_1) {
            if (S == Operador) {
                return true;
            }
        }
        return false;
    }


    public boolean IsOperador2(String S) {

        if (Character.isWhitespace(S.charAt(0))) {
            return false;
        }

        for (String Operador : Constantes.OPERADORES_2) {
            if (S.equals(Operador)) {
                return true;
            }
        }
        return false;
    }

    public boolean IsOperador3(String S) {

        if (Character.isWhitespace(S.charAt(0))) {
            return false;
        }

        for (String Operador : Constantes.OPERADORES_3) {
            if (S.equals(Operador)) {
                return true;
            }
        }
        return false;
    }

    private int IsCast(String S) {

        if (S.charAt(0) != '(') {
            return -1;
        }

        int i;
        for (i = 0; i < S.length(); i++) {
            if (S.charAt(i) != ' ' || S.charAt(i) != '\n') {
                break;
            }
        }
        String Aux = S.substring(i);
        char c;
        for (String TipoDado : Constantes.TIPO_DADOS) {
            if (Aux.contains(TipoDado)) {
                for (i = 0; i < S.length(); i++) {
                    if ((c = S.charAt(i)) != ' ' || S.charAt(i) != '\n') {
                        if (S.charAt(i) == ')') {
                            return TipoDado.length() + 2;
                        }
                    }
                }
            }
        }
        return -1;
    }

    private boolean IsFor(char A[]) {
        boolean ret = false;
        if (!IsCaracter(A[0]) && A[1] == 'f' && A[2] == 'o' && A[3] == 'r' && (A[4] == '(' || Character.isWhitespace(A[4]))) {
            ret = true;
        }
        return ret;
    }
/*
    private boolean IsFuncao(String S) {
        boolean Ret = false;
        boolean TemIgual = false, TemParenteses = false;

        if (Character.isWhitespace(S.charAt(0))) {
            return Ret;
        }

        String StringSplited[] = S.substring(0, 18).split(" ");
        OUTER_FOR1:
        for (String TipoDado : Constantes.TIPO_DADOS) {
            if (TipoDado.contains(StringSplited[0])) {
                for (int i = 0; i < S.length(); i++) {
                    switch (S.charAt(i)) {
                        case ';':
                        case '{':
                            break OUTER_FOR1;
                        case '(':
                            TemParenteses = true;
                            break OUTER_FOR1;
                        case '=':
                            TemIgual = true;
                            break OUTER_FOR1;
                        default:
                            break;
                    }
                }
            }
        }
        if (!TemIgual && TemParenteses) {
            Ret = true;
        }
        return Ret;
    }
*/
    
    private boolean IsFuncao(String S)
    {
        int i;
        
        if(Nivel>0)
            return false;
        
        if(Character.isWhitespace(S.charAt(0)))
            return false;
        
        for(i=1;i<S.length();i++)
        {
            if(!Character.isWhitespace(S.charAt(i)))
                break;
        }
        if(S.charAt(i)=='(')
            return true;
        return false;
    }
    
    private int EncontraInicioFuncao(int i, String Codigo)
    {
        for(;i>0;i--)
        {
            if(Character.isWhitespace(Codigo.charAt(i)))
            {
                for(--i;i>0;i--)
                    if(!Character.isWhitespace(Codigo.charAt(i)))
                    {
                        for(--i;i>0;i--)
                        {
                            if(Character.isWhitespace(Codigo.charAt(i)))
                                break;
                        }
                        break;
                    }
                break;
            }
        }
        return i+1;
    }


    public ArrayList<Statement> Cataloga(String Codigo, Statement Pai) {
        if (Codigo.length() <= 0) {
            return null;
        }

        ArrayList<Statement> Novo = new ArrayList<>();
        Statement Add = null;
        boolean AspasAberto = false, PlicasAberto = false;
        String Aux = "";

        for (int i = 0; i < Codigo.length(); i++) {

            char Carater = Codigo.charAt(i);


            if (Codigo.charAt(i) == '"' && Codigo.charAt(i - 1) != '\\') {
                AspasAberto = !AspasAberto;
                continue;
            } else if (Codigo.charAt(i) == '\'' && Codigo.charAt(i - 1) != '\\') {
                PlicasAberto = !PlicasAberto;
                continue;
            }

            if (AspasAberto || PlicasAberto) {
                continue;
            }

            try {
                if (IsInclude(Codigo.charAt(i))) {
                    Aux = NovoStatement(Aux, Novo, Pai);

                    Add = new Include(Codigo.substring(i), this);
                    i += Add.getNumCarateresAvancar();
                    Novo.add(Add);
                    continue;
                }
            } catch (Exception e) {
            }

            try {
                if (IsComentario(new char[]{Codigo.charAt(i), Codigo.charAt(i + 1)})) {
                    Aux = NovoStatement(Aux, Novo, Pai);

                    Add = new Comentario(Codigo.substring(i), this);
                    i += Add.getNumCarateresAvancar();
                    Novo.add(Add);
                    continue;
                }
            } catch (Exception e) {
            }

            try {
                if (IsIF(new char[]{Codigo.charAt(i), Codigo.charAt(i + 1), Codigo.charAt(i + 2), Codigo.charAt(i + 3)})) {
                    Aux = NovoStatement(Aux, Novo, Pai);

                    Add = new If(Codigo.substring(i + 1), this);
                    i += Add.getNumCarateresAvancar() - 1;
                    Novo.add(Add);
                    continue;
                }
            } catch (Exception e) {
            }

            try {
                if (IsElse(new char[]{Codigo.charAt(i), Codigo.charAt(i + 1), Codigo.charAt(i + 2), Codigo.charAt(i + 3), Codigo.charAt(i + 4), Codigo.charAt(i + 5)})) {
                    Aux = NovoStatement(Aux, Novo, Pai);

                    Add = new Else(Codigo.substring(i + 1), this);
                    i += Add.getNumCarateresAvancar() - 1;
                    Novo.add(Add);
                    continue;
                }
            } catch (Exception e) {
            }
            try {
                if (IsFor(new char[]{Codigo.charAt(i), Codigo.charAt(i + 1), Codigo.charAt(i + 2), Codigo.charAt(i + 3), Codigo.charAt(i + 4)})) {
                    Aux = NovoStatement(Aux, Novo, Pai);

                    Add = new For(Codigo.substring(i + 1), this);
                    i += Add.getNumCarateresAvancar() - 1;
                    Novo.add(Add);
                    continue;
                }
            } catch (Exception e) {
            }

            try {
                if (IsWhile(new char[]{Codigo.charAt(i), Codigo.charAt(i + 1), Codigo.charAt(i + 2), Codigo.charAt(i + 3), Codigo.charAt(i + 4), Codigo.charAt(i + 5), Codigo.charAt(i + 6), Codigo.charAt(i + 7)})) {
                    Aux = NovoStatement(Aux, Novo, Pai);
                    Add = new While(Codigo.substring(i + 1), this);
                    i += Add.getNumCarateresAvancar() - 1;
                    Novo.add(Add);
                    continue;
                }
            } catch (Exception e) {
            }

            try {
                if (IsDoWhile(new char[]{Codigo.charAt(i), Codigo.charAt(i + 1), Codigo.charAt(i + 2), Codigo.charAt(i + 3)})) {
                    Aux = NovoStatement(Aux, Novo, Pai);
                    Add = new DoWhile(Codigo.substring(i + 1), this);
                    i += Add.getNumCarateresAvancar() - 1;
                    Novo.add(Add);
                    continue;
                }
            } catch (Exception e) {
            }


            try {
                if (IsFuncao(Codigo.substring(i))) 
                {
                    int InicioFuncao=EncontraInicioFuncao(i,Codigo);
                    int conta=Aux.length()-(i-InicioFuncao);
                    Aux = NovoStatement(Aux.substring(0,conta), Novo, Pai);
                    Add = new Funcao(Codigo.substring(InicioFuncao), this);
                    i += Add.getNumCarateresAvancar() - 1-(i-InicioFuncao);
                    Novo.add(Add);
                    continue;
                }
            } catch (Exception e) {
            }

            try {

                if (IsOperador3(Codigo.substring(i, i + 3))) {
                    int PrevCarater = 0, NextCarater = 0;
                    OUTER1:
                    for (int j = i - 1; j >= 0; j--) {
                        if (Codigo.charAt(j) != ' ' || Codigo.charAt(j) != '\n') {
                            PrevCarater = j;
                            break OUTER1;
                        }
                    }
                    OUTER2:
                    for (int j = i + 3; j < Codigo.length(); j++) {
                        if (Codigo.charAt(j) != ' ' || Codigo.charAt(j) != '\n') {
                            NextCarater = j;
                            break OUTER2;
                        }
                    }

                    Aux = NovoStatement(Aux, Novo, Pai);
                    Add = new Operador(Codigo.substring(PrevCarater, NextCarater), this);
                    i += 2;
                    Novo.add(Add);
                    continue;
                }

            }
            catch(Exception e){}
            try
            {

                if (IsOperador2(Codigo.substring(i, i + 2))) {
                    int PrevCarater = 0, NextCarater = 0;

                    for (int j = i - 1; j >= 0; j--) {
                        if (Codigo.charAt(j) != ' ' || Codigo.charAt(j) != '\n') {
                            PrevCarater = j;
                            break;
                        }
                    }

                    for (int j = i + 2; j < Codigo.length(); j++) {
                        if (Codigo.charAt(j) != ' ' || Codigo.charAt(j) != '\n') {
                            NextCarater = j + 1;
                            break;
                        }
                    }

                    Aux = NovoStatement(Aux, Novo, Pai);
                    Add = new Operador(Codigo.substring(PrevCarater, NextCarater), this);
                    i += 1;
                    Novo.add(Add);
                    continue;
                }
            }
            catch(Exception e){}
            try
            {
                if (IsOperador1(Codigo.charAt(i))) {
                    int PrevCarater = 0, NextCarater = 0;

                    for (int j = i - 1; j >= 0; j--) {
                        if (Codigo.charAt(j) != ' ' || Codigo.charAt(j) != '\n') {
                            PrevCarater = j;

                            break;
                        }
                    }


                    for (int j = i + 1; j < Codigo.length(); j++) {
                        if (Codigo.charAt(j) != ' ' || Codigo.charAt(j) != '\n') {
                            NextCarater = j + 1;
                            break;
                        }
                    }


                    Aux = NovoStatement(Aux, Novo, Pai);
                    Add = new Operador(Codigo.substring(PrevCarater, NextCarater), this);
                    Novo.add(Add);
                    continue;
                }

            } catch (Exception e){}



            try {
                int NumCarCast = IsCast(Codigo.substring(i));
                int PrevCarater = 0, NextCarater = 0;
                char c;
                if (NumCarCast != -1) {

                    for (int j = i - 1; j >= 0; j--) {
                        if ((c = Codigo.charAt(j)) != ' ' || Codigo.charAt(j) != '\n') {
                            PrevCarater = j;
                            break;
                        }
                    }

                    for (int j = i + NumCarCast; j < Codigo.length(); j++) {
                        if ((c = Codigo.charAt(j)) != ' ' || Codigo.charAt(j) != '\n') {
                            NextCarater = j + 1;
                            break;
                        }
                    }
                    Aux = NovoStatement(Aux, Novo, Pai);
                    Add = new Cast(Codigo.substring(PrevCarater, NextCarater), this);
                    Novo.add(Add);
                    i += Add.getNumCarateresAvancar() - 1;
                    continue;
                }
            } catch (Exception e) {
            }
            Aux += Codigo.charAt(i);
        }
        NovoStatement(Aux, Novo, Pai);

        return Novo;
    }

    @Override
    public String toString() {
        String S = new String();
        S += ImprimeCodigo(ListaStatements);
        return S;
    }

    public String ImprimeCodigo(ArrayList<Statement> AL) {
        String Ret = "";
        for (Statement S : AL) {

            if (S instanceof If) {
                Ret += "if(";
                for (Statement statementsFilho : ((If) S).getCondicao().getStatementsFilhos()) {
                    Ret += statementsFilho.getCodigo();

                }
            } else {
                Ret += S.getCodigo();
            }

            if (S.hasFilhos()) {
                Ret += ImprimeCodigo(S.getStatementsFilhos());
            }
        }
        return Ret;
    }

    private String NovoStatement(String Aux, ArrayList<Statement> Novo, Statement Pai) {

        if (!"".equals(Aux)) {
            if (Pai != null && !Aux.equals(Pai.getCodigo())) {

                Novo.add(new Statement(Aux, this));
            } else if (Pai == null) {
                Novo.add(new Statement(Aux, this));
            }

        }
        return "";
    }
}
