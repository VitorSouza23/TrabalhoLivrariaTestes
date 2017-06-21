/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.ccp.esw.model;

import br.edu.ifsc.ccp.esw.abstracts.AbstractProduto;
import java.util.ArrayList;
import java.util.List;
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
public class VendaTest {
    private AbstractProduto livro1;
    private AbstractProduto livro2;
    private AbstractProduto cd1;
    private AbstractProduto cd2;
    private List<ItemVenda> itens;
    public VendaTest() {
        this.itens = new ArrayList<>();
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.livro1 = new Livro("34345", "567657", "Jocecreide: A abduzida de Taubaté", "Jose fina", 6, 10);
        this.livro2 = new Livro("56456", "5675676", "Zuleide e a Pedra Fisolofil", "J.K.ebradas", 80, 20);
        this.cd1 = new Cd(10, "345345", "Melodramas Brasileiros Vol.36", "Duplas Sertanjas", 100, 5);
        this.cd2 = new Cd(20, "4545645", "Furador de Timpano", "ExCalipso", 15, 1);
        this.itens.add(new ItemVenda(livro1, 5));
        this.itens.add(new ItemVenda(livro2, 10, 10));
        this.itens.add(new ItemVenda(cd1, 5));
        this.itens.add(new ItemVenda(cd2, 1, 90));
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of realizarVenda method, of class Venda.
     */
    @Test
    public void testRealizarVenda_List() {
        Venda venda = new Venda();
        assertEquals(255.1, venda.realizarVenda(itens), 0);
    }

    /**
     * Test of realizarVenda method, of class Venda.
     */
    @Test
    public void testRealizarVenda_List_double() {
        Venda venda = new Venda();
        assertEquals(229.59, venda.realizarVenda(itens, 10), 0);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testRealizarVenda_ListComListaNula() {
        Venda venda = new Venda();
        venda.realizarVenda(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testRealizarVenda_ListComListaNulaComDesconto() {
        Venda venda = new Venda();
        venda.realizarVenda(null, 10);
    }
    
    
    @Test(expected = IllegalArgumentException.class)
    public void testRealizarVenda_ListComListaVazia() {
        Venda venda = new Venda();
        venda.realizarVenda(new ArrayList<>());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testRealizarVenda_ListComListaVaziaComDesconto() {
        Venda venda = new Venda();
        venda.realizarVenda(new ArrayList<>(), 10);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testRealizarVenda_ListComDescontoMenorQueZero() {
        Venda venda = new Venda();
        venda.realizarVenda(this.itens, -1);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testRealizarVenda_ListComDescontoMaiorQueCem() {
        Venda venda = new Venda();
        venda.realizarVenda(this.itens, 101);
    }
    
}
