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
public class Livro extends AbstractProduto{

    private String isbn;

    public Livro() {
    }

    public Livro(String isbn, String codigo, String descricao, String autor, int quantidadeEstoque, double preco) {
        super(codigo, descricao, autor, quantidadeEstoque, preco);
        this.isbn = isbn;
    }
    
    /**
     * @return the isbn
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * @param isbn the isbn to set
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
