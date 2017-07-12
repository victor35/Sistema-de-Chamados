/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author victor
 */
public class Unidade {
    
    private int id;
    private String unidade;
    private ArrayList<Chamado> listaChamado;
    private String endereco;
    private String telefone;
    private String cep;
    
    public ArrayList<Chamado> getListaChamado() {
        return listaChamado;
    }

    public void setListaChamado(ArrayList<Chamado> listaChamado) {
        this.listaChamado = listaChamado;
    }
       
    public Unidade(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
    
    
    
}
