package Model.Statement;

import Model.EstiloProgramacao.EstiloProgramacao;
import Model.Texto;

public class Funcao extends Statement {

    private boolean AntesMain;
    private String nomeFuncao;

    public Funcao(String codigo, Texto t) {
        super(codigo, t);
    }

    @Override
    public String RetiraDados(String Codigo, Texto t) {
        int i, j, PosInicioCodigoFuncao = 0, PosFimCodigoFuncao = 0;
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

        this.Codigo = Codigo.substring(0, PosInicioCodigoFuncao);
        if (PosFimCodigoFuncao + 1 > Codigo.length()) {
            this.ParaAnalise = Codigo.substring(PosInicioCodigoFuncao, PosFimCodigoFuncao);
        } else {
            this.ParaAnalise = Codigo.substring(PosInicioCodigoFuncao, PosFimCodigoFuncao + 1);
        }
        this.NumCarateresAvancar = PosFimCodigoFuncao + 1;
        return Codigo.substring(PosInicioCodigoFuncao, PosFimCodigoFuncao + 1);

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

    public void setAntesMain(boolean AntesMain) {
        this.AntesMain = AntesMain;
    }

    public void analisaStatement() {
        String aux = ParaAnalise;
        String linha = "";

        if (!aux.contains("main")) {
            AntesMain = true; /// PORQUE SE NAO TEM MAIN É SÓ PARA DEIXAR COMO ESTAO AS FUNÇOES NAO È NECESSARIO CRIAR CABEÇALHO
            return;
        }

        int posmain = aux.indexOf("main");
        int nchaveta = 0;
        for (int i = posmain; i < aux.length(); i++) {
            if (aux.charAt(i) == '{') {
                nchaveta++;
            } else if (aux.charAt(i) == '}') {
                if (nchaveta == 0) {
                    posmain = i;
                    break;
                } else {
                    nchaveta--;
                }
            }
        }
        aux.substring(posmain);

        if (aux.contains(nomeFuncao)) {
            AntesMain = false;
        }
        {
            AntesMain = true;
        }

    }
    @Override
    public void converteStatement(EstiloProgramacao estilo) {
        super.converteStatement(estilo);
    }
}
