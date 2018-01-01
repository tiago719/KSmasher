package Model;

import static Model.Constantes.FLUXO_CONTROLO;
import Model.EstiloProgramacao.EstiloProgramacao;
import Model.Statement.Comentario;
import java.io.BufferedReader;
import Model.Statement.*;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Texto {

    private ArrayList<Statement> ListaStatements;
    BufferedReader TextoBR;
    BufferedWriter TextoBW;
    int Nivel, contPontoVirgula, contChavetaAberta;

    public Map<Funcao, Funcao> Cabecalhos_Funcoes;
    boolean FuncaoDepoisMain;
    Funcao Main;

    EstiloProgramacao EstiloProgramacao;

    /**
     * Para Analizar
     *
     * @param In
     */
    public Texto() {
        Cabecalhos_Funcoes = new HashMap<>();
        FuncaoDepoisMain = false;
    }

    public Texto(BufferedReader In, BufferedWriter Out) {
        ListaStatements = new ArrayList<Statement>();
        TextoBR = In;
        TextoBW = Out;
        Cabecalhos_Funcoes = new HashMap<>();
        FuncaoDepoisMain = false;
    }

    public Texto(String Codigo) {
        ListaStatements = new ArrayList<Statement>();
        ListaStatements = Cataloga(Codigo, null);
        Cabecalhos_Funcoes = new HashMap<>();
        FuncaoDepoisMain = false;

    }

    public void ComecaCataloga() {
        String Codigo = null;

        try {
            Codigo = org.apache.commons.io.IOUtils.toString(TextoBR);
        } catch (IOException ex) {
            System.out.println("Deu erro a passar o bufferedReader para string");
        }
        ListaStatements = Cataloga(Codigo, null);
        int a = 0;
    }

    public void ComecaCataloga(String t) {
        String Codigo = null;

        Codigo = t;

        ListaStatements = Cataloga(Codigo, null);
        int a = 0;

        a = 5;
    }

    public void ComecaAnalisa() {
        Analisa(ListaStatements);
    }

    public int getNivel() {
        return Nivel;
    }

    public void setNivel(int nivel) {
        this.Nivel = nivel;
    }

    private void Analisa(ArrayList<Statement> Lista) {
        for (Statement s : Lista) {
            if (s.hasFilhos()) {
                Analisa(s.getStatementsFilhos());
                s.analisaStatement();
            } else {
                s.analisaStatement();
            }
        }
    }

    public void ComecaConverte(EstiloProgramacao EstiloProgramacao) {
        ArrayList<Statement> ListaSemLixo = new ArrayList<Statement>();
        for (Statement ListaStatement : ListaStatements) {
            if ((ListaStatement instanceof Include)) {
                ListaSemLixo.add(ListaStatement);
            }
        }
        ListaStatements = ListaSemLixo;

        if (EstiloProgramacao.getFuncoes().isAntesMain()) {//funcoes antes da main (sem cabecalhos)

            for (Map.Entry<Funcao, Funcao> entry : Cabecalhos_Funcoes.entrySet()) {
                //Funcao Cabecalho = entry.getKey();
                Funcao Funcao = entry.getValue();
                
                Funcao.setCodigo("\n\n" + Funcao.getCodigo());
                                
                ListaStatements.add(Funcao);
            }
            ListaStatements.add(Main);

        } else {
            for (Map.Entry<Funcao, Funcao> entry : Cabecalhos_Funcoes.entrySet()) {
                Funcao Cabecalho = entry.getKey();
                //Funcao Funcao = entry.getValue();
                Cabecalho.setCodigo("\n\n" + Cabecalho.getCodigo());
                ListaStatements.add(Cabecalho);
            }
            Main.setCodigo("\n\n" + Main.getCodigo());
            ListaStatements.add(Main);
            for (Map.Entry<Funcao, Funcao> entry : Cabecalhos_Funcoes.entrySet()) {
//                Funcao Cabecalho = entry.getKey();
                Funcao Funcao = entry.getValue();
                Funcao.setCodigo("\n\n" + Funcao.getCodigo());
                ListaStatements.add(Funcao);
            }

        }
        System.out.println(this);
        Converte(ListaStatements, EstiloProgramacao);
    }

    public void Converte(ArrayList<Statement> Lista, EstiloProgramacao EstiloProgramacao) {
        for (Statement S : Lista) {
            if (S.hasFilhos()) {
                Converte(S.getStatementsFilhos(), EstiloProgramacao);
            }
            if(EstiloProgramacao != null){
                S.converteStatement(EstiloProgramacao);
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
        if (Character.isWhitespace(A[0]) && A[1] == 'i' && A[2] == 'f' && (A[3] == '(' || Character.isWhitespace(A[3]))) {
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

        int i, a, parentesesAbertos = 0;
        for (i = 0; i < S.length(); i++) {
            if (!Character.isWhitespace(S.charAt(i))) {
                break;
            }
        }

        for (a = 0; a < S.length(); a++) {
            if (S.charAt(a) == '(') {
                parentesesAbertos++;
            } else if (S.charAt(a) == ')') {
                if (--parentesesAbertos == 0) {
                    break;
                }
            }
        }

        String Aux = S.substring(i + 1, a);
        char c;
        for (String TipoDado : Constantes.TIPO_DADOS) {
            if (Aux.contains(TipoDado)) {
                for (i = 0; i < S.length(); i++) {
                    if (!Character.isWhitespace(S.charAt(i))) {
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

    private boolean IsFuncao(String S) {
        int i;

        if (Nivel > 0) {
            return false;
        }

        if (Character.isWhitespace(S.charAt(0))) {
            return false;
        }

        for (i = 1; i < S.length(); i++) {
            if (!Character.isWhitespace(S.charAt(i))) {
                break;
            }
        }
        if (S.charAt(i) == '(') {
            return true;
        }
        return false;
    }

    private int EncontraInicioFuncao(int i, String Codigo) {
        for (; i >= 0; i--) {
            if (Character.isWhitespace(Codigo.charAt(i))) {
                for (--i; i >= 0; i--) {
                    if (!Character.isWhitespace(Codigo.charAt(i))) {
                        for (--i; i >= 0; i--) {
                            if (Character.isWhitespace(Codigo.charAt(i))) {
                                break;
                            }
                        }
                        break;
                    }
                }
                break;
            }
        }
        return i + 1;
    }

    private boolean isControloFluxo(String S) {
        for (String FluxoControlo : FLUXO_CONTROLO) {
            if (S.contains(FluxoControlo)) {
                return true;
            }
        }
        return false;
    }

    private void precisaChaveta(ArrayList<Statement> Filhos) {
        --contPontoVirgula;
        for (int i = 0; i < Filhos.size(); i++) {
            if (Filhos.get(i).hasFilhos()) {
                precisaChaveta(Filhos.get(i).getStatementsFilhos());
            }
            String Codigo = Filhos.get(i).getCodigo();
            if (Codigo.contains(" for ") || Codigo.contains(" for(") || Codigo.contains("\tfor ") || Codigo.contains("\tfor(")) {
                contPontoVirgula++;
                continue;
            }
            for (int a = 0; a < Codigo.length(); a++) {
                if (Codigo.charAt(a) == ';') {
                    if (++contPontoVirgula > 1) {
                        break;
                    }
                }
            }
            if (isControloFluxo(Codigo)) {
                contPontoVirgula++;
            }
            if (contPontoVirgula == 2) {
                break;
            }
            if (Codigo.contains("{")) {
                contChavetaAberta++;
            }
            if (Codigo.contains("}")) {
                if (--contChavetaAberta == 0) {
                    break;
                }
            }
        }
    }

    public boolean precisaChavetaP(ArrayList<Statement> Lista) {
        contPontoVirgula = 1;
        contChavetaAberta = 0;
        precisaChaveta(Lista);
        if (contPontoVirgula > 1) {
            return true;
        } else {
            return false;
        }
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
            if (Codigo.charAt(i) == '"' && Codigo.charAt(i - 1) != '\\') {
                AspasAberto = !AspasAberto;
                Aux += Codigo.charAt(i);
                continue;
            } else if (Codigo.charAt(i) == '\'' && Codigo.charAt(i - 1) != '\\') {
                PlicasAberto = !PlicasAberto;
                Aux += Codigo.charAt(i);
                continue;
            }

            if (AspasAberto || PlicasAberto) {
                Aux += Codigo.charAt(i);
                continue;
            }

            try {
                if (IsInclude(Codigo.charAt(i))) {
                    Aux = NovoStatement(Aux, Novo, Pai);

                    Add = new Include(Codigo.substring(i), this, Pai);
                    i += Add.getNumCarateresAvancar();
                    Novo.add(Add);
                    continue;
                }
            } catch (Exception e) {
            }

            try {
                if (IsComentario(new char[]{Codigo.charAt(i), Codigo.charAt(i + 1)})) {
                    Aux = NovoStatement(Aux, Novo, Pai);

                    Add = new Comentario(Codigo.substring(i), this, Pai);
                    i += Add.getNumCarateresAvancar();
                    Novo.add(Add);
                    continue;
                }
            } catch (Exception e) {
            }

            try {
                if (IsIF(new char[]{Codigo.charAt(i), Codigo.charAt(i + 1), Codigo.charAt(i + 2), Codigo.charAt(i + 3)})) {
                    Aux = NovoStatement(Aux, Novo, Pai);

                    Add = new If(Codigo.substring(i + 1), this, Pai);
                    i += Add.getNumCarateresAvancar() - 1;
                    Novo.add(Add);
                    continue;
                }
            } catch (Exception e) {
            }

            try {
                if (IsElse(new char[]{Codigo.charAt(i), Codigo.charAt(i + 1), Codigo.charAt(i + 2), Codigo.charAt(i + 3), Codigo.charAt(i + 4), Codigo.charAt(i + 5)})) {
                    Aux = NovoStatement(Aux, Novo, Pai);

                    Add = new Else(Codigo.substring(i + 1), this, Pai);
                    i += Add.getNumCarateresAvancar() - 1;
                    Novo.add(Add);
                    continue;
                }
            } catch (Exception e) {
            }
            try {
                if (IsFor(new char[]{Codigo.charAt(i), Codigo.charAt(i + 1), Codigo.charAt(i + 2), Codigo.charAt(i + 3), Codigo.charAt(i + 4)})) {
                    Aux = NovoStatement(Aux, Novo, Pai);

                    Add = new For(Codigo.substring(i + 1), this, Pai);
                    i += Add.getNumCarateresAvancar() - 1;
                    Novo.add(Add);
                    continue;
                }
            } catch (Exception e) {
            }

            try {
                if (IsWhile(new char[]{Codigo.charAt(i), Codigo.charAt(i + 1), Codigo.charAt(i + 2), Codigo.charAt(i + 3), Codigo.charAt(i + 4), Codigo.charAt(i + 5), Codigo.charAt(i + 6), Codigo.charAt(i + 7)})) {
                    Aux = NovoStatement(Aux, Novo, Pai);
                    Add = new While(Codigo.substring(i + 1), this, Pai);
                    i += Add.getNumCarateresAvancar() - 1;
                    Novo.add(Add);
                    continue;
                }
            } catch (Exception e) {
            }

            try {
                if (IsDoWhile(new char[]{Codigo.charAt(i), Codigo.charAt(i + 1), Codigo.charAt(i + 2), Codigo.charAt(i + 3)})) {
                    Aux = NovoStatement(Aux, Novo, Pai);
                    Add = new DoWhile(Codigo.substring(i + 1), this, Pai);
                    i += Add.getNumCarateresAvancar() - 1;
                    Novo.add(Add);
                    continue;
                }
            } catch (Exception e) {
            }

            try {
                if (IsFuncao(Codigo.substring(i))) {
                    int InicioFuncao = EncontraInicioFuncao(i, Codigo);
                    int conta = Aux.length() - (i - InicioFuncao);
                    Aux = NovoStatement(Aux.substring(0, conta), Novo, Pai);
                    Funcao F;

                    F = new Funcao(Codigo.substring(InicioFuncao), this, Pai, FuncaoDepoisMain);
                    i += F.getNumCarateresAvancar() - 1 - (i - InicioFuncao);
                    if ((F.getCodigo().contains(" main ")
                            || F.getCodigo().contains(" main("))) {
                        FuncaoDepoisMain = true;
                        Main = F;
                    }
//                    Novo.add(Add);
                    continue;
                }
            } catch (Exception e) {
            }

            try {

                if (IsOperador3(Codigo.substring(i, i + 3))) {
                    int PrevCarater = 0, NextCarater = 0;
                    OUTER1:
                    for (int j = i - 1; j >= 0; j--) {
                        if (!Character.isWhitespace(Codigo.charAt(j))) {
                            PrevCarater = j;
                            break OUTER1;
                        }
                    }
                    OUTER2:
                    for (int j = i + 3; j < Codigo.length(); j++) {
                        if (!Character.isWhitespace(Codigo.charAt(j))) {
                            NextCarater = j + 1;
                            break OUTER2;
                        }
                    }

                    Aux = NovoStatement(Aux, Novo, Pai);
                    Add = new Operador(Codigo.substring(PrevCarater, NextCarater), this, Pai);
                    i += 2;
                    Novo.add(Add);
                    continue;
                }
            } catch (Exception e) {
            }
            try {
                if (IsOperador2(Codigo.substring(i, i + 2))) {
                    int PrevCarater = 0, NextCarater = 0;

                    for (int j = i - 1; j >= 0; j--) {
                        if (!Character.isWhitespace(Codigo.charAt(j))) {
                            PrevCarater = j;
                            break;
                        }
                    }

                    for (int j = i + 2; j < Codigo.length(); j++) {
                        if (!Character.isWhitespace(Codigo.charAt(j))) {
                            NextCarater = j + 1;
                            break;
                        }
                    }

                    Aux = NovoStatement(Aux, Novo, Pai);
                    try {
                        Add = new Operador(Codigo.substring(PrevCarater, NextCarater), this, Pai);
                        Novo.add(Add);
                    } catch (Exception e) {
                        Add = new Operador(Codigo.substring(1), this, Pai);
                        Novo.add(Add);
                    }

                    i += 1;
                    continue;
                }
            } catch (Exception e) {
            }
            try {
                if (IsOperador1(Codigo.charAt(i))) {
                    int PrevCarater = 0, NextCarater = 0;

                    try {
                        if (Codigo.charAt(i - 1) == '-' && Codigo.charAt(i) == '>') {
                            Aux += Codigo.charAt(i);
                            continue;
                        } else if (Codigo.charAt(i) == '-' && Codigo.charAt(i + 1) == '>') {
                            Aux += Codigo.charAt(i);
                            continue;
                        }
                    } catch (Exception e) {
                    }
                    for (int j = i - 1; j >= 0; j--) {
                        if (!Character.isWhitespace(Codigo.charAt(j))) {
                            PrevCarater = j;

                            break;
                        }
                    }

                    for (int j = i + 1; j < Codigo.length(); j++) {
                        if (!Character.isWhitespace(Codigo.charAt(j))) {
                            NextCarater = j + 1;
                            break;
                        }
                    }

                    Aux = NovoStatement(Aux, Novo, Pai);
                    Add = new Operador(Codigo.substring(PrevCarater, NextCarater), this, Pai);
                    Novo.add(Add);
                    continue;
                }
            } catch (Exception e) {
            }

            try {
                int NumCarCast = IsCast(Codigo.substring(i));
                int PrevCarater = 0, NextCarater = 0;
                if (NumCarCast != -1) {

                    for (int j = i - 1; j >= 0; j--) {
                        if (!Character.isWhitespace(Codigo.charAt(i))) {
                            PrevCarater = j;
                            break;
                        }
                    }

                    for (int j = i + NumCarCast; j < Codigo.length(); j++) {
                        if (!Character.isWhitespace(Codigo.charAt(i))) {
                            NextCarater = j + 1;
                            break;
                        }
                    }
                    Aux = NovoStatement(Aux, Novo, Pai);
                    Add = new Cast(Codigo.substring(PrevCarater, NextCarater), this, Pai);
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
            Ret += S.getCodigo();
            if (S.hasFilhos()) {
                Ret += ImprimeCodigo(S.getStatementsFilhos());
            }
        }
        return Ret;
    }

    private String NovoStatement(String Aux, ArrayList<Statement> Novo, Statement Pai) {
        if (!"".equals(Aux)) {
            if (Pai != null && !Aux.equals(Pai.getCodigo())) {

                Novo.add(new Statement(Aux, this, Pai));
            } else if (Pai == null) {
                Novo.add(new Statement(Aux, this, Pai));
            }

        }
        return "";
    }
}
