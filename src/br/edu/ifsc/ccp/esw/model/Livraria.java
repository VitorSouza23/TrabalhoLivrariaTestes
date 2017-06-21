/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.ccp.esw.model;

import br.edu.ifsc.ccp.esw.abstracts.AbstractProduto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class Livraria {
    private List<AbstractProduto> estoque;
    private List<ItemVenda> itensDaVenda;

    public Livraria() {
        this.estoque = new ArrayList<>();
        this.itensDaVenda = new ArrayList<>();
    }
    
    
 
    public boolean adicionarProdutoAoEstoque(AbstractProduto produto){
        if(produto == null){
            throw new IllegalArgumentException("Não pode haver Produto nulo!");
        }
        return this.estoque.add(produto);
    }
    
    public boolean adicionarProdutoAListaDeItensDeVenda(int index, int quantidade){
        if(index < 0){
            throw new IllegalArgumentException("Não pode haver índice negativo!");
        }
        if(index > this.estoque.size() - 1){
            throw new IllegalArgumentException("Não há produto com esse índice!");
        }
        AbstractProduto produto = this.estoque.get(index);
        if(this.verificarProdutosIguais(produto)){
            throw new Error("Não pode haver dois produtos iguais na mesma venda!");
        }
        
        return this.itensDaVenda.add(new ItemVenda(produto, quantidade));
    }
    
    public boolean adicionarProdutoAListaDeItensDeVenda(int index, int quantidade, double desconto){
        if(index < 0){
            throw new IllegalArgumentException("Não pode haver índice negativo!");
        }
        if(index > this.estoque.size() - 1){
            throw new IllegalArgumentException("Não há produto com esse índice!");
        }
        AbstractProduto produto = this.estoque.get(index);
        if(this.verificarProdutosIguais(produto)){
            throw new Error("Não pode haver dois produtos iguais na mesma venda!");
        }
        
        return this.itensDaVenda.add(new ItemVenda(produto, quantidade, desconto));
    }
    
    public boolean verificarProdutosIguais(AbstractProduto produto){
        for(ItemVenda item : this.itensDaVenda){
            if(item.getProduto().equals(produto)){
                return true;
            }
        }
        return false;
    }
    
    public double realizarVenda(){
        Venda venda = new Venda();
        return venda.realizarVenda(this.itensDaVenda);
    }
    
    public double realizarVenda(int desconto){
        Venda venda = new Venda();
        return venda.realizarVenda(this.itensDaVenda, desconto);
    }

    /**
     * @return the estoque
     */
    public List<AbstractProduto> getEstoque() {
        return estoque;
    }

    /**
     * @param estoque the estoque to set
     */
    public void setEstoque(List<AbstractProduto> estoque) {
        this.estoque = estoque;
    }

    /**
     * @return the itensDaVenda
     */
    public List<ItemVenda> getItensDaVenda() {
        return itensDaVenda;
    }

    /**
     * @param itensDaVenda the itensDaVenda to set
     */
    public void setItensDaVenda(List<ItemVenda> itensDaVenda) {
        this.itensDaVenda = itensDaVenda;
    }
    
}
