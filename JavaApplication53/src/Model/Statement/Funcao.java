package Model.Statement;

import Model.EstiloProgramacao.EstiloProgramacao;
import Model.Texto;

public class Funcao extends Statement {

    private boolean AntesMain;
    private String nomeFuncao;

    public Funcao(String codigo, Texto t, Statement Pai) {
        super(codigo, t, Pai);
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
            
            if(Codigo.charAt(j)==';')
            {
                this.Codigo = Codigo.substring(0, j);
                this.NumCarateresAvancar=j;
                this.ParaAnalise=Codigo;
                return this.Codigo;
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

        if (this.Codigo.contains(";")) {
            this.Codigo = Codigo.substring(0, Codigo.indexOf(";"));
        }
        this.ParaAnalise = Codigo;
        if (PosFimCodigoFuncao + 1 > Codigo.length()) {
            this.NumCarateresAvancar = PosFimCodigoFuncao - (PosFimCodigoFuncao - Codigo.length());
            return Codigo.substring(PosInicioCodigoFuncao, PosFimCodigoFuncao  - (PosFimCodigoFuncao - Codigo.length()));
        }
        else
        {
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

    public void setAntesMain(boolean AntesMain) {
        this.AntesMain = AntesMain;
    }

    @Override
    public void analisaStatement() {
        String aux = ParaAnalise;

        if (!aux.contains(" main(")) {
            AntesMain = true; /// PORQUE SE NAO TEM MAIN É SÓ PARA DEIXAR COMO ESTAO AS FUNÇOES NAO È NECESSARIO CRIAR CABEÇALHO
        } else {
            AntesMain = !Codigo.contains(";");
        }

    }
    @Override
    public void converteStatement(EstiloProgramacao estilo) {
        
        if(estilo.getFuncoes()== null)
        {
            return;
        }
        
//        super.converteStatement(estilo);
//        System.out.println(this.ParaAnalise);
//        System.out.print(this.Codigo);
//        String aux=this.ParaAnalise;
//        
//        if(!AntesMain){
//              int posmain = aux.indexOf("main");
//        int nchaveta = 0;
//        for (int i = posmain; i < aux.length(); i++) {
//            if (aux.charAt(i) == '{') {
//                nchaveta++;
//            } else if (aux.charAt(i) == '}') {
//                if (nchaveta == 0) {
//                    posmain = i;
//                    break;
//                } else {
//                    nchaveta--;
//                }
//            }
//        }
//        }else
//            return;
    }
}
