/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.EstiloProgramacao;

/**
 *
 * @author Tiago Coutinho
 */
public class EstiloProgramacao
{
    private int id;
    private String nome;
    private Cast_EP cast;
    private DoWhile_EP dowhile;
    private Else_EP elses;
    private For_EP fors;
    private Funcoes_EP funcoes;
    private If_EP ifs;
    private Operador_EP operador;
    private While_EP whiles;
    private boolean Permite;

     public EstiloProgramacao(int id, String nome)
     {
        this.nome = nome;
        this.id = id;
    }
     
    public EstiloProgramacao(String nome,boolean Permite, Cast_EP cast, DoWhile_EP dowhile, Else_EP elses, For_EP fors, Funcoes_EP funcoes, If_EP ifs, Operador_EP operador, While_EP whiles) {
        this.nome = nome;
        this.cast = cast;
        this.dowhile = dowhile;
        this.elses = elses;
        this.fors = fors;
        this.funcoes = funcoes;
        this.ifs = ifs;
        this.operador = operador;
        this.whiles = whiles;
        this.Permite=Permite;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cast_EP getCast() {
        return cast;
    }

    public void setCast(Cast_EP cast) {
        this.cast = cast;
    }

    public DoWhile_EP getDowhile() {
        return dowhile;
    }

    public void setDowhile(DoWhile_EP dowhile) {
        this.dowhile = dowhile;
    }

    public Else_EP getElses() {
        return elses;
    }

    public void setElses(Else_EP elses) {
        this.elses = elses;
    }

    public For_EP getFors() {
        return fors;
    }

    public void setFors(For_EP fors) {
        this.fors = fors;
    }

    public Funcoes_EP getFuncoes() {
        return funcoes;
    }

    public void setFuncoes(Funcoes_EP funcoes) {
        this.funcoes = funcoes;
    }

    public If_EP getIfs() {
        return ifs;
    }

    public void setIfs(If_EP ifs) {
        this.ifs = ifs;
    }

    public Operador_EP getOperador() {
        return operador;
    }

    public void setOperador(Operador_EP operador) {
        this.operador = operador;
    }

    public While_EP getWhiles() {
        return whiles;
    }

    public void setWhiles(While_EP whiles) {
        this.whiles = whiles;
    }
}
