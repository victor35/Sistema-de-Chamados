/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Administrador
 */
public class Equipamentos {
    
    private int id;
    private String nome;
    private String descricao;
    private String tipo;
    
    private Unidade Unidade;
    
    public Equipamentos(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Unidade getUnidade() {
        return Unidade;
    }

    public void setUnidade(Unidade Unidade) {
        this.Unidade = Unidade;
    }
    
    
    
    
    
}
