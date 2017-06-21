/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.ccp.esw.model;

import java.util.List;

/**
 *
 * @author Aluno
 */
public class Venda {
    
    public double realizarVenda(List<ItemVenda> produtos){
        if(produtos == null || produtos.isEmpty()){
            throw new IllegalArgumentException("A lista de produtos não pode ser vazia!");
        }
        double valorVenda = 0;
        System.out.println("=== Informações da Venda ===\n");
        for(ItemVenda itemVenda : produtos){
            valorVenda += itemVenda.calcularValorVenda();
            System.out.println("\n");
            itemVenda.exibirInfo();
            System.out.println("\n");
        }
        System.out.println("\n");
        System.out.println("Valor Total: " + valorVenda);
        return valorVenda;
    }
    
    public double realizarVenda(List<ItemVenda> produtos, double desconto){
        if(desconto < 0 || desconto > 100){
            throw new IllegalArgumentException("Valor do desconto fora dos limites!(deve ser entre 0 a 100)");
        }
        double valorVenda = this.realizarVenda(produtos);
        double valorComDesocnto = valorVenda - (valorVenda * (desconto/100));
        System.out.println("Valor com Desconto: " + valorComDesocnto);
        return valorComDesocnto;
    }
}
