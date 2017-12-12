package Model;

import java.io.BufferedReader;
import Model.Statement.*;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Texto {

    private ArrayList<Statement> ListaStatements;
    BufferedReader TextoBR;
    BufferedWriter TextoBW;
    /**
     * Para Analizar
     *
     * @param In
     */
    
    public Texto()
    {
        //TODO: So para os testes, apagar depois
    }
    
    public Texto(BufferedReader In) {
        ListaStatements = new ArrayList<Statement>();
        TextoBR = In;
    }

    //TODO: PARA TESTES
    public Texto(String Codigo) {
        ListaStatements = new ArrayList<Statement>();
        ListaStatements = Cataloga(Codigo, null);

    }

    /**
     * Para Converter
     *
     * @param Out
     */
    public Texto(BufferedWriter Out) {
        ListaStatements = new ArrayList<Statement>();
        TextoBW = Out;
    }

    public void ComecaCataloga() {
        //TODO:Passar o IN ou OUT para string
        //ListaStatements = Cataloga(Codigo);
    }

    public void ComecaAnalisa() {
        Analisa(ListaStatements);
    }

    private void Analisa(ArrayList<Statement> Lista) {
        for (Statement s : Lista) {
            if (s.hasFilhos()) {
                Analisa(s.getStatmentsFilhos());
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
                Converte(S.getStatmentsFilhos());
            } else {
                S.analisaStatement();
            }
        }
    }

    public ArrayList<Statement> getListaStatements() {
        return ListaStatements;
    }
    private boolean isIF(char A[]) {
        boolean Ret = false;
        if (A[0] == 'i' && A[1] == 'f') {
            Ret = true;
        }

        return Ret;
    }

    private boolean IsDoWhile(char A[]) {
        boolean Ret = false;
        if (A[0] == 'd' && A[1] == 'o') {
            Ret = true;
        }

        return Ret;
    }

    public boolean IsWhile(char A[]) {
        boolean Ret = false;
        if (A[0] == 'w' && A[1] == 'h' && A[2] == 'i' && A[3] == 'l' && A[4] == 'e') {
            Ret = true;
        }

        return Ret;
    }

    private boolean IsOperador1(char S) {

        if (S == ' ') {
            return false;
        }

        for (char Operador : Constantes.OPERADORES_1) {
            if (S == Operador) {
                return true;
            }
        }
        return false;
    }

    private boolean IsOperador2(String S) {

        if (S.charAt(0) == ' ') {
            return false;
        }

        for (String Operador : Constantes.OPERADORES_2) {
            if (S.equals(Operador)) {
                return true;
            }
        }
        return false;
    }

    private boolean IsOperador3(String S) {

        if (S.charAt(0) == ' ') {
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
            if (S.charAt(i) != ' ') {
                break;
            }
        }
        String Aux = S.substring(i);

        for (String TipoDado : Constantes.TIPO_DADOS) {
            if (TipoDado.contains(Aux)) {
                for (i = 0; i < S.length(); i++) {
                    if (S.charAt(i) != ' ') {
                        if (S.charAt(i) == ')') {
                            return TipoDado.length();
                        } else {
                            return -1;
                        }
                    }
                }
            }
        }
        return -1;
    }

    private boolean IsFor(char A[]) {
        boolean ret = false;
        if (A[0] == 'f' && A[1] == 'o' && A[2] == 'r') {
            ret = true;
        }
        return ret;
    }

    private boolean IsFuncao(String S) {
        boolean Ret = false;
        boolean TemIgual = false, TemParenteses = false;

        if (S.charAt(0) == ' ') {
            return Ret;
        }

        String StringSplited[] = S.substring(0, 18).split(" ");
        for (String TipoDado : Constantes.TIPO_DADOS) {
            if (TipoDado.contains(StringSplited[0])) {
                OUTER:
                for (int i = 0; i < S.length(); i++) {
                    switch (S.charAt(i)) {
                        case ';':
                        case '{':
                            break OUTER;
                        case '(':
                            TemParenteses = true;
                            break;
                        case '=':
                            TemIgual = true;
                            break OUTER;
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

    public ArrayList<Statement> Cataloga(String Codigo, Statement Pai) {
        if (Codigo.length() <= 0) {
            return null;
        }

        ArrayList<Statement> Novo = new ArrayList<>();
        Statement Add = null;
        int iUltimoCarater = 0;
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
                if (isIF(new char[]{Codigo.charAt(i), Codigo.charAt(i + 1)})) {
                    Aux = NovoStatment(Aux, Novo, Pai);
                    
                    Add = new If(Codigo.substring(i), this);
                    i += Add.getNumCarateresAvancar() - 1;
                    Novo.add(Add);
                    continue;
                }
            } catch (Exception e) {
            }
            try {
                if (IsFor(new char[]{Codigo.charAt(i), Codigo.charAt(i + 1), Codigo.charAt(i + 2)})) {
                    Aux = NovoStatment(Aux, Novo, Pai);
                    Add = new For(Codigo.substring(i), this);
                    i += Add.getNumCarateresAvancar() - 1;
                    Novo.add(Add);
                    continue;
                }
            } catch (Exception e) {
            }

            try {
                if (IsWhile(new char[]{Codigo.charAt(i), Codigo.charAt(i + 1), Codigo.charAt(i + 2), Codigo.charAt(i + 3), Codigo.charAt(i + 4), Codigo.charAt(i + 5)})) {
                    Aux = NovoStatment(Aux, Novo, Pai);
                    Add = new While(Codigo.substring(i), this);
                    i += Add.getNumCarateresAvancar() - 1;
                    Novo.add(Add);
                    continue;
                }
            } catch (Exception e) {
            }

            try {
                if (IsDoWhile(new char[]{Codigo.charAt(i), Codigo.charAt(i + 1)})) {
                    Aux = NovoStatment(Aux, Novo, Pai);
                    Add = new DoWhile(Codigo.substring(i), this);
                    i += Add.getNumCarateresAvancar() - 1;
                    Novo.add(Add);
                    continue;
                }
            } catch (Exception e) {
            }

            try {
                if (IsFuncao(Codigo.substring(i))) {
                    Aux = NovoStatment(Aux, Novo, Pai);
                    Add = new Funcao(Codigo.substring(i), this);
                    i += Add.getNumCarateresAvancar() - 1;
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
                        if (Codigo.charAt(j) != ' ') {
                            PrevCarater = j;
                            break OUTER1;
                        }
                    }
                    OUTER2:
                    for (int j = i + 3; j < Codigo.length(); j++) {
                        if (Codigo.charAt(j) != ' ') {
                            NextCarater = j;
                            break OUTER2;
                        }
                    }

                    Aux = NovoStatment(Aux, Novo, Pai);
                    Add = new Operador(Codigo.substring(PrevCarater, NextCarater), this);
                    i += 2;
                    Novo.add(Add);
                    continue;
                }
                if (IsOperador2(Codigo.substring(i, i + 2))) {
                    int PrevCarater = 0, NextCarater = 0;

                    for (int j = i - 1; j >= 0; j--) {
                        if (Codigo.charAt(j) != ' ') {
                            PrevCarater = j;
                            break;
                        }
                    }

                    for (int j = i + 2; j < Codigo.length(); j++) {
                        if (Codigo.charAt(j) != ' ') {
                            NextCarater = j + 1;
                            break;
                        }
                    }

                    Aux = NovoStatment(Aux, Novo, Pai);
                    Add = new Operador(Codigo.substring(PrevCarater, NextCarater), this);
                    i += 1;
                    Novo.add(Add);
                    continue;
                }
                if (IsOperador1(Codigo.charAt(i))) {
                    int PrevCarater = 0, NextCarater = 0;

                    for (int j = i - 1; j >= 0; j--) {
                        if (Codigo.charAt(j) != ' ') {
                            PrevCarater = j;
                            break;
                        }
                    }

                    for (int j = i + 1; j < Codigo.length(); j++) {
                        if (Codigo.charAt(j) != ' ') {
                            NextCarater = j + 1;
                            break;
                        }
                    }

                    Aux = NovoStatment(Aux, Novo, Pai);
                    Add = new Operador(Codigo.substring(PrevCarater, NextCarater), this);
                    Novo.add(Add);
                    continue;
                }
            } catch (Exception e) { }

            try {
                int NumCarCast = IsCast(Codigo.substring(i));
                int PrevCarater = 0, NextCarater = 0;
                if (NumCarCast != -1) {
                    Aux = NovoStatment(Aux, Novo, Pai);

                    for (int j = i - 1; j >= 0; j--) {
                        if (Codigo.charAt(j) != ' ') {
                            PrevCarater = j;
                        }
                    }

                    for (int j = i + NumCarCast; j < Codigo.length(); j++) {
                        if (Codigo.charAt(j) != ' ') {
                            NextCarater = j + 1;
                        }
                    }

                    Add = new Cast(Codigo.substring(PrevCarater, NextCarater), this);
                    Novo.add(Add);
                    break;
                }
            } catch (Exception e) {
            }

            if (Codigo.charAt(i) != ' ') {
                iUltimoCarater = i;
            }
            Aux += Codigo.charAt(i);
        }
        NovoStatment(Aux, Novo, Pai);
//        if (Add != null) {
//
//            Novo.add(Add);
//        }
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
                for (Statement statmentsFilho : ((If) S).getCondicao().getStatmentsFilhos()) {
                    Ret += statmentsFilho.getCodigo();

                }
            }
            else
                Ret += S.getCodigo();

            if (S.hasFilhos()) {
                Ret += ImprimeCodigo(S.getStatmentsFilhos());
            }
        }
        return Ret;
    }

    private String NovoStatment(String Aux, ArrayList<Statement> Novo, Statement Pai) {

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
