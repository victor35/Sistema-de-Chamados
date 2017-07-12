/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;

/**
 *
 * @author Administrador
 */
public class Chamado {
    
    private int id;
    private String descricao;
    private String local;
    private String requisitante;
    private String responsavel;
    private String prioridade;
    private String status;
    private String solucoes;
    private String dataDeAbertura;
    private String dataDeFechamento;
    
    private Equipamentos equipamentos;
    private Usuario usuario;
    private Unidade unidade;
    
    public Chamado(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getRequisitante() {
        return requisitante;
    }

    public void setRequisitante(String requisitante) {
        this.requisitante = requisitante;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSolucoes() {
        return solucoes;
    }

    public void setSolucoes(String solucoes) {
        this.solucoes = solucoes;
    }

    public Equipamentos getEquipamentos() {
        return equipamentos;
    }

    public void setEquipamentos(Equipamentos equipamentos) {
        this.equipamentos = equipamentos;
    }

    

    public String getDataDeAbertura() {
        return dataDeAbertura;
    }

    public void setDataDeAbertura(String dataDeAbertura) {
        this.dataDeAbertura = dataDeAbertura;
    }

    public String getDataDeFechamento() {
        return dataDeFechamento;
    }

    public void setDataDeFechamento(String dataDeFechamento) {
        this.dataDeFechamento = dataDeFechamento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }
    
    
    
}
