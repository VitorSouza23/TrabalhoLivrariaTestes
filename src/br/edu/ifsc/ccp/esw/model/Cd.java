/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.ccp.esw.model;

import br.edu.ifsc.ccp.esw.abstracts.AbstractProduto;

/**
 *
 * @author Aluno
 */
public class Cd extends AbstractProduto {

    private int numeroFaixas;

    public Cd() {
    }

    public Cd(int numeroFaixas, String codigo, String descricao, String autor, int quantidadeEstoque, double preco) {
        super(codigo, descricao, autor, quantidadeEstoque, preco);
        this.numeroFaixas = numeroFaixas;
    }

   
    /**
     * @return the numeroFaixas
     */
    public int getNumeroFaixas() {
        return numeroFaixas;
    }

    /**
     * @param numeroFaixas the numeroFaixas to set
     */
    public void setNumeroFaixas(int numeroFaixas) {
        this.numeroFaixas = numeroFaixas;
    }

    @Override
    public void exibirInfo() {
        System.out.println("Livro: " + this.descricao + "\n"
                + "Código: " + this.codigo + "\n"
                + "Autor: " + this.autor + "\n"
                + "Qtd. em Estoque: " + this.quantidadeEstoque + "\n"
                + "Nº de Faixas: " + this.numeroFaixas + "\n"
                + "Preço: " + this.preco + "\n");
    }
}
