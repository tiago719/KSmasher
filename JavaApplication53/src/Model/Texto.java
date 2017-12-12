package Model;

import Model.EstiloProgramacao.*;
import java.io.BufferedReader;
import java.sql.SQLException;
import Model.Statement.*;
import java.io.BufferedWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Texto {

    private ArrayList<Statement> ListaStatements;
    int ix;
    BufferedReader TextoBR;
    BufferedWriter TextoBW;
    
    public Texto()
    {
        //TODO: So para os testes, apagar depois
    }
    
    public Texto(BufferedReader In) {
        ListaStatements = new ArrayList<Statement>();
        ix = 0;
        TextoBR = In;
    }
    
    public Texto(BufferedWriter Out) {
        ListaStatements = new ArrayList<Statement>();
        ix = 0;
        TextoBW = Out;
    }

    public void ComecaCataloga() 
    {
        //TODO:Passar o IN ou OUT para string
        //ListaStatements = Cataloga(Codigo);
    }
    
    public void ComecaAnalisa()
    {
        Analisa(ListaStatements);
    }
    
    private void Analisa(ArrayList<Statement> Lista)
    {
        for(Statement s : Lista)
        {
            if(s.hasFilhos())
                Analisa(s.getStatmentsFilhos());
            else
                s.analisaStatement();
        }
    }
    
    public void ComecaConverte()
    {
        Converte(ListaStatements);
    }
    
    private void Converte(ArrayList<Statement> Lista)
    {
        for(Statement s : Lista)
        {
            if(s.hasFilhos())
                Converte(s.getStatmentsFilhos());
            else
                s.analisaStatement();
        }
    }

    public ArrayList<Statement> getListaStatements() {
        return ListaStatements;
    }

    private boolean isIF(char a[]) {
        boolean ret = false;
        if (a[0] == 'i' && a[1] == 'f') {
            ret = true;
        }

        return ret;
    }

    private boolean IsDoWhile(char a[]) {
        boolean ret = false;
        if (a[0] == 'd' && a[1] == 'o') {
            ret = true;
        }

        return ret;
    }

    public boolean IsWhile(char a[]) {
        boolean ret = false;
        if (a[0] == 'w' && a[1] == 'h' && a[2] == 'i' && a[3] == 'l' && a[4] == 'e') {
            ret = true;
        }

        return ret;
    }

    private boolean IsOperador(String s) {

        if (s.charAt(0) == ' ') {
            return false;
        }
        
        for(String operador : Constantes.Operadores)
            if(s.contains(operador))
                return true;
        return false;
    }

    private boolean IsCast(String s) {

        if (s.charAt(0) != '(') {
            return false;
        }

        String aux = s.substring(0, 18);
        for (String TipoDado : Constantes.Operadores) {
            if (TipoDado.contains(aux)) {
                return true;
            }
        }
        return false;
    }

    private boolean IsFor(char a[]) {
        boolean ret = false;
        if (a[0] == 'f' && a[1] == 'o' && a[2] == 'r') {
            ret = true;
        }
        return ret;
    }

    private boolean IsFuncao(String s) {
        boolean ret = false;
        boolean TemIgual = false, TemParenteses = false;

        if (s.charAt(0) == ' ') {
            return ret;
        }

        String q[] = s.substring(0, 18).split(" ");
        for (String TipoDado : Constantes.TipoDados) {
            if (TipoDado.contains(q[0])) {

                OUTER:
                for (int i = 0; i < s.length(); i++) {
                    switch (s.charAt(i)) {
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
            ret = true;
        }

        return ret;
    }

    public ArrayList<Statement> Cataloga(String codigo) {
        ArrayList<Statement> Novo = new ArrayList<>();
        Statement Add = null;
        int ixUltimoCarater = 0;

        for (; ix < codigo.length(); ix++) {
            if (codigo.charAt(ix) != ' ') {
                ixUltimoCarater = ix;
            }
            try
            {
                if (isIF(new char[]{codigo.charAt(ix), codigo.charAt(ix + 1)})) {
                    Add = new If(codigo.substring(ix), this);
                    break;
                } 
            }
            catch(Exception e){}
            try
            {
                if (IsFor(new char[]{codigo.charAt(ix), codigo.charAt(ix + 1), codigo.charAt(ix + 2)})) {
                    Add = new For(codigo.substring(ix), this);
                    break;
                } 
            }
            catch(Exception e){}
                
            try
            {
                if (IsWhile(new char[]{codigo.charAt(ix), codigo.charAt(ix + 1), codigo.charAt(ix + 2), codigo.charAt(ix + 3), codigo.charAt(ix + 4), codigo.charAt(ix + 5)})) {
                    Add = new While(codigo.substring(ix), this);
                    break;
                } 
            }
            catch(Exception e){}
            
            try
            {
                if (IsDoWhile(new char[]{codigo.charAt(ix), codigo.charAt(ix + 1)})) {
                    Add = new DoWhile(codigo.substring(ix), this);
                    break;
                } 
            }
            catch(Exception e){}
                
            try
            {
                if (IsFuncao(codigo.substring(ix))) {
                    Add = new Funcao(codigo.substring(ix), this);
                    break;
                } 
            }
            catch(Exception e){}
            
            try
            {
                if (IsOperador(codigo.substring(ix))) {
                    Add = new Operador(codigo.substring(ixUltimoCarater), this);
                    break;
                } 
            }
            catch(Exception e){}
            
            try
            {
                if (IsCast(codigo.substring(ix))) {
                    Add = new Cast(codigo.substring(ixUltimoCarater), this);
                    break;
                }
            }
            catch(Exception e){}
        }
        Novo.add(Add);
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
}
