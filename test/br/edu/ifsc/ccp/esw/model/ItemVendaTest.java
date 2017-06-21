/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.ccp.esw.model;

import br.edu.ifsc.ccp.esw.abstracts.AbstractProduto;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Aluno
 */
public class ItemVendaTest {
    private AbstractProduto produto;
    public ItemVendaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.produto = new Cd(10, "234234", "CD Destruidor", "Bem loko", 20, 10.50);
    }
    
    @After
    public void tearDown() {
    }

   
    /**
     * Test of setDesconto method, of class ItemVenda.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetDescontoMernorQueZero() {
        ItemVenda item = new ItemVenda(produto, 10, -1);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSetDescontoMaiorQue100() {
        ItemVenda item = new ItemVenda(produto, 10, 101);
    }

    /**
     * Test of calcularValorVenda method, of class ItemVenda.
     */
    @Test
    public void testCalcularValorVenda() {
        ItemVenda item = new ItemVenda(produto, 10);
        assertEquals(105.0, item.calcularValorVenda(), 0);
    }
    
    @Test
    public void testCalcularValorVendaComDesconto(){
        ItemVenda item = new ItemVenda(produto, 10, 10);
        assertEquals(94.5, item.calcularValorVenda(), 0);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testQuantidadeMaiorDoqueEstoque(){
       ItemVenda item = new ItemVenda(produto, 21);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testQuantidadeMaiorDoqueEstoqueComDesconto(){
       ItemVenda item = new ItemVenda(produto, 21, 10);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testQuantidadeNegativa(){
       ItemVenda item = new ItemVenda(produto, -10);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testQuantidadeNegativaComDesconto(){
       ItemVenda item = new ItemVenda(produto, -10, 10);
    }
    
}
