package Model;

public interface Constantes {

    public static final String[] TIPO_DADOS = { "int", "float","char", "double", "unsigned", "signed", "short", "long"};

    public static final char[] OPERADORES_1 = {'=', '+', '-', '/', '%', '<', '>',  '&', '|', '^', '?'};

    public static final String[] OPERADORES_2 = {"++", "+=", "--", "-=", "*=", "/=", "%=", "<=", ">*", ">=", "!=", "==", "&&", "||", "<<",
        ">>", "&=", "|="};

    public static final String[] OPERADORES_3 = {"<<=", ">>="};

    public static final String DIRETORIA_DESTINO = "..\\..\\DiretoriasConvertidas";
    
    public static final String[] FLUXO_CONTROLO={"do", "while", "if", "else"};
}
