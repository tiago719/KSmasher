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
    private String nome;
    private Cast cast;
    private DoWhile dowhile;
    private Else elses;
    private For fors;
    private Funcoes funcoes;
    private If ifs;
    private Inicializacao inicializacao;
    private Operador operador;
    private While whiles;

    public EstiloProgramacao(String nome, Cast cast, DoWhile dowhile, Else elses, For fors, Funcoes funcoes, If ifs, Inicializacao inicializacao, Operador operador, While whiles) {
        this.nome = nome;
        this.cast = cast;
        this.dowhile = dowhile;
        this.elses = elses;
        this.fors = fors;
        this.funcoes = funcoes;
        this.ifs = ifs;
        this.inicializacao = inicializacao;
        this.operador = operador;
        this.whiles = whiles;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cast getCast() {
        return cast;
    }

    public void setCast(Cast cast) {
        this.cast = cast;
    }

    public DoWhile getDowhile() {
        return dowhile;
    }

    public void setDowhile(DoWhile dowhile) {
        this.dowhile = dowhile;
    }

    public Else getElses() {
        return elses;
    }

    public void setElses(Else elses) {
        this.elses = elses;
    }

    public For getFors() {
        return fors;
    }

    public void setFors(For fors) {
        this.fors = fors;
    }

    public Funcoes getFuncoes() {
        return funcoes;
    }

    public void setFuncoes(Funcoes funcoes) {
        this.funcoes = funcoes;
    }

    public If getIfs() {
        return ifs;
    }

    public void setIfs(If ifs) {
        this.ifs = ifs;
    }

    public Inicializacao getInicializacao() {
        return inicializacao;
    }

    public void setInicializacao(Inicializacao inicializacao) {
        this.inicializacao = inicializacao;
    }

    public Operador getOperador() {
        return operador;
    }

    public void setOperador(Operador operador) {
        this.operador = operador;
    }

    public While getWhiles() {
        return whiles;
    }

    public void setWhiles(While whiles) {
        this.whiles = whiles;
    }
    
    
}
