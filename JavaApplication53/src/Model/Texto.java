package Model;

import java.io.BufferedReader;
import Model.Statement.*;
import java.io.BufferedWriter;
import java.util.ArrayList;

public class Texto {

    private ArrayList<Statement> ListaStatements;
    int Ix;
    BufferedReader TextoBR;
    BufferedWriter TextoBW;

    /**
     * Para Analizar
     *
     * @param In
     */
    public Texto(BufferedReader In) {
        ListaStatements = new ArrayList<Statement>();
        Ix = 0;
        TextoBR = In;
    }

    /**
     * Para Converter
     *
     * @param Out
     */
    public Texto(BufferedWriter Out) {
        ListaStatements = new ArrayList<Statement>();
        Ix = 0;
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

    public void fazMedia() {
        /*
        ArrayList<Integer> EspacosOperadorVariavel=new ArrayList<Integer>();
        ArrayList<Integer> EspacosVariavelOperador=new ArrayList<Integer>();
        
        for(int i=0;i<ListaStatements.size();i++)
        {
            if(ListaStatements.get(i) instanceof Operador)
            {
                Operador S=(Operador)ListaStatements.get(i);
                EspacosOperadorVariavel.add(S.getEspacosOperadorVariavel());
                EspacosVariavelOperador.add(S.getEspacosVariavelOperador());
            }                
        }*/
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

    private boolean IsWhile(char A[]) {
        boolean Ret = false;
        if (A[0] == 'w' && A[1] == 'h' && A[2] == 'i' && A[3] == 'l' && A[4] == 'e') {
            Ret = true;
        }

        return Ret;
    }

    private boolean IsOperador(String S) {

        if (S.charAt(0) == ' ') {
            return false;
        }

        for (String operador : Constantes.OPERADORES) {
            if (S.contains(operador)) {
                return true;
            }
        }
        return false;
    }

    private boolean IsCast(String S) {

        if (S.charAt(0) != '(') {
            return false;
        }

        String aux = S.substring(0, 18);
        for (String TipoDado : Constantes.OPERADORES) {
            if (TipoDado.contains(aux)) {
                return true;
            }
        }
        return false;
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

    public ArrayList<Statement> Cataloga(String Codigo) {
        if (Codigo.length() <= 0)
            return null;
        
        ArrayList<Statement> Novo = new ArrayList<>();
        Statement Add = null;
        int IxUltimoCarater = 0;
        boolean AspasAberto = false, PlicasAberto = false;
        String Aux = "";

        for (; Ix < Codigo.length(); Ix++) {
            Aux += Codigo.charAt(Ix);
            if (Codigo.charAt(Ix) == '"' && Codigo.charAt(Ix - 1) != '\\') {
                AspasAberto = !AspasAberto;
                continue;
            } else if (Codigo.charAt(Ix) == '\'' && Codigo.charAt(Ix - 1) != '\\') {
                PlicasAberto = !PlicasAberto;
                continue;
            }

            if (AspasAberto || PlicasAberto) {
                continue;
            }

            if (Codigo.charAt(Ix) != ' ') {
                IxUltimoCarater = Ix;
            }
            try {
                if (isIF(new char[]{Codigo.charAt(Ix), Codigo.charAt(Ix + 1)})) {
                    NovoStatment(Aux, Novo);
                    Add = new If(Codigo.substring(Ix), this);
                    break;
                }
            } catch (Exception e) {
            }
            try {
                if (IsFor(new char[]{Codigo.charAt(Ix), Codigo.charAt(Ix + 1), Codigo.charAt(Ix + 2)})) {
                    NovoStatment(Aux, Novo);
                    Add = new For(Codigo.substring(Ix), this);
                    break;
                }
            } catch (Exception e) {
            }

            try {
                if (IsWhile(new char[]{Codigo.charAt(Ix), Codigo.charAt(Ix + 1), Codigo.charAt(Ix + 2), Codigo.charAt(Ix + 3), Codigo.charAt(Ix + 4), Codigo.charAt(Ix + 5)})) {
                    NovoStatment(Aux, Novo);
                    Add = new While(Codigo.substring(Ix), this);
                    break;
                }
            } catch (Exception e) {
            }

            try {
                if (IsDoWhile(new char[]{Codigo.charAt(Ix), Codigo.charAt(Ix + 1)})) {
                    NovoStatment(Aux, Novo);
                    Add = new DoWhile(Codigo.substring(Ix), this);
                    break;
                }
            } catch (Exception e) {
            }

            try {
                if (IsFuncao(Codigo.substring(Ix))) {
                    NovoStatment(Aux, Novo);
                    Add = new Funcao(Codigo.substring(Ix), this);
                    break;
                }
            } catch (Exception e) {
            }

            try {
                if (IsOperador(Codigo.substring(Ix))) {
                    NovoStatment(Aux, Novo);
                    Add = new Operador(Codigo.substring(IxUltimoCarater), this);
                    break;
                }
            } catch (Exception e) {
            }

            try {
                if (IsCast(Codigo.substring(Ix))) {
                    NovoStatment(Aux, Novo);
                    Add = new Cast(Codigo.substring(IxUltimoCarater), this);
                    break;
                }
            } catch (Exception e) {
            }

        }
        if (Add != null) {
            Novo.add(Add);
        }
        return Novo;
    }

    @Override
    public String toString() {
        String S = "";
        for (int i = 0; i < ListaStatements.size(); i++) {
            S += ListaStatements.get(i).toString();
        }
        return S;
    }

    private void NovoStatment(String Aux, ArrayList<Statement> Novo) {
        if (!"".equals(Aux)) {
            Novo.add(new Statement(Aux, this));
        }
    }
}
