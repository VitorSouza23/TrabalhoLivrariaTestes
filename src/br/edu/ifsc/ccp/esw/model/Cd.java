/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.ccp.esw.model;

/**
 *
 * @author Aluno
 */
public class Cd {
    private int numeroFaixas;

    public Cd() {
    }

    public Cd(int numeroFaixas) {
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
}
