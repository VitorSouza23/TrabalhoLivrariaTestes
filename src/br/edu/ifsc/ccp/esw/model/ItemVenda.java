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
public class ItemVenda {
    private AbstractProduto produto;
    private int quantidade;
    private double desconto;

   
    public ItemVenda(AbstractProduto produto, int quantidade) {
        this.produto = produto;
        if(quantidade < 0){
            throw new IllegalArgumentException("A quantidade não pode ser negativa!");
        }
        this.quantidade = quantidade;
        this.desconto = 0;
        this.decrementarDoEstoque();
    }

    public ItemVenda(AbstractProduto produto, int quantidade, double desconto) {
        this(produto, quantidade);
        this.setDesconto(desconto);
    }
    
    
    private void decrementarDoEstoque(){
        int novoValor = this.produto.getQuantidadeEstoque() - this.quantidade;
        if(novoValor < 0 ){
            throw new IllegalArgumentException("Não há itens suficientes no estoque do produto: "+ this.produto.getDescricao() +"!");
        }else{
            this.produto.setQuantidadeEstoque(novoValor);
        }
    }

    /**
     * @return the produto
     */
    public AbstractProduto getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(AbstractProduto produto) {
        this.produto = produto;
    }

    /**
     * @return the quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    /**
     * @return the desconto
     */
    public double getDesconto() {
        return desconto;
    }

    /**
     * @param desconto the desconto to set
     */
    public void setDesconto(double desconto) {
        if(desconto < 0 || desconto > 100){
            throw new IllegalArgumentException("Valor do desconto fora dos limites!(deve ser entre 0 a 100)");
        }
        this.desconto = desconto;
    }
    
     public void exibirInfo(){
        this.produto.exibirInfo();
        System.out.println("Quantidade: " + this.quantidade + "\n");
        System.out.println("Desconto: " + this.desconto + "\n");
        System.out.println("Valor Total: " + this.calcularValorVenda());
        
    }
    
    public double calcularValorVenda(){
        double valor = this.quantidade * this.produto.getPreco();
        if(this.desconto == 0){
            return valor;
        }else{
            return valor - (valor * (this.desconto/100));
        }
        
    }
}
