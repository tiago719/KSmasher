package Model.Statement;

import Model.EstiloProgramacao.EstiloProgramacao;
import Model.Texto;
import java.util.Map;

public class Funcao extends Statement {

    private boolean AntesMain, Cabecalho;
    private String nomeFuncao;

    public Funcao(String codigo, Texto t, Statement Pai, boolean FuncaoDepoisMain) {
        super(codigo, t, Pai);
        AntesMain = !FuncaoDepoisMain;
    }

    @Override
    public String RetiraDados(String Codigo, Texto t) {
        int j, PosInicioCodigoFuncao = 0, PosFimCodigoFuncao = 0;
        boolean AspasAberto = false, PlicasAberto = false;

        //procura {
        for (j = 0; j < Codigo.length(); j++) {
            if (Codigo.charAt(j) == '"' && Codigo.charAt(j - 1) != '\\') {
                AspasAberto = !AspasAberto;
                continue;
            } else if (Codigo.charAt(j) == '\'' && Codigo.charAt(j - 1) != '\\') {
                PlicasAberto = !PlicasAberto;
                continue;
            }
            if (PlicasAberto || AspasAberto) {
                continue;
            }

            if (Codigo.charAt(j) == '{') {
                PosInicioCodigoFuncao = j;
                break;
            } else if (Codigo.charAt(j) == ';') {
                Cabecalho = true;

                if (Codigo.length() < j + 1) {
                    this.Codigo ="\n\n"+ Codigo;
                } else {
                    this.Codigo ="\n\n" + Codigo.substring(0, j + 1);
                }

                this.NumCarateresAvancar = j;
                this.ParaAnalise = Codigo;

                Texto.Cabecalhos_Funcoes.put(this, null);
                EncontraNomeFuncao(this.Codigo);
                return null;
            }
        }

        int NumAspasAbertos = 1;
        for (++j; j < Codigo.length(); j++) {
            if (Codigo.charAt(j) == '"' && Codigo.charAt(j - 1) != '\\') {
                AspasAberto = !AspasAberto;
                continue;
            } else if (Codigo.charAt(j) == '\'' && Codigo.charAt(j - 1) != '\\') {
                PlicasAberto = !PlicasAberto;
                continue;
            }
            if (PlicasAberto || AspasAberto) {
                continue;
            }

            if (Codigo.charAt(j) == '{') {
                NumAspasAbertos++;
            } else if (Codigo.charAt(j) == '}') {
                if (--NumAspasAbertos == 0) {
                    PosFimCodigoFuncao = j;
                    break;
                }
            }
        }
        this.Codigo ="\n\n" + Codigo.substring(0, PosInicioCodigoFuncao);
        if (this.Codigo.contains(";")) {
            this.Codigo = Codigo.substring(0, Codigo.indexOf(";"));
        }

        EncontraNomeFuncao(this.Codigo);

//        this.ParaAnalise = Codigo;
        if (!(this.Codigo.contains(" main ") || this.Codigo.contains(" main("))) {//se nao é a main

            boolean flag = false;
            for (Map.Entry<Funcao, Funcao> entry : Texto.Cabecalhos_Funcoes.entrySet()) {//prcura cabecalho desta funcao
                Funcao cabecalho = entry.getKey();

                if (cabecalho.nomeFuncao.equals(this.nomeFuncao)) {
                    entry.setValue(this);
                    flag = true;
                }
            }

            if (!flag) {//se nao tem cabecalho definido
                Texto.Cabecalhos_Funcoes.put(new Funcao(this.Codigo + ";", Texto, null, true), this);
            }
        }

        if (PosFimCodigoFuncao + 1 > Codigo.length()) {
            this.NumCarateresAvancar = PosFimCodigoFuncao - (PosFimCodigoFuncao - Codigo.length());
            return Codigo.substring(PosInicioCodigoFuncao, PosFimCodigoFuncao - (PosFimCodigoFuncao - Codigo.length()));
        } else {
            this.NumCarateresAvancar = PosFimCodigoFuncao + 1;
            return Codigo.substring(PosInicioCodigoFuncao, PosFimCodigoFuncao + 1);
        }

    }

    public String getNomeFuncao() {
        return nomeFuncao;
    }

    public void setNomeFuncao(String nomeFuncao) {
        this.nomeFuncao = nomeFuncao;
    }

    public boolean isAntesMain() {
        return AntesMain;
    }

    @Override
    public void analisaStatement() {

    }

    @Override
    public void converteStatement(EstiloProgramacao estilo) {

    }

    private void EncontraNomeFuncao(String Codigo) {
        for (int i = 0; i < Codigo.length(); i++) {//encontra nome funcao
            if (Codigo.charAt(i) == '(') {
                int k;
                for (k = i; k >= 0; k--) {
                    if (Codigo.charAt(k) == ' ') {
                        break;
                    }
                }
                nomeFuncao = Codigo.substring(k, i);
                break;
            }
        }
    }
}
