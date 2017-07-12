/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Administrador
 */
public class Perfil {
    
    private int id;
    private String nome;
    private String descricao;
    private ArrayList<Menu> menusPerfil;
    
    public Perfil(){}

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

    public ArrayList<Menu> getMenusPerfil() {
        return menusPerfil;
    }

    public void setMenusPerfil(ArrayList<Menu> menusPerfil) {
        this.menusPerfil = menusPerfil;
    }
    
   /* public void inserir() throws Exception{
     PerfilDAO pDAO = new PerfilDAO();
     pDAO.inserir(this);
    }
     public void alterar() throws Exception{
     PerfilDAO pDAO = new PerfilDAO();
     pDAO.alterar(this);
    }
      public void excluir() throws Exception{
      PerfilDAO pDAO = new PerfilDAO();
      pDAO.excluir(this);
    }
       public ArrayList<Perfil> listar() throws Exception{
       PerfilDAO pDAO = new PerfilDAO();
       return pDAO.listar();
    }
    public void carregarPorId(int id_perfil) throws Exception{
        PerfilDAO pDAO = new PerfilDAO();
        this.id= pDAO.carregarPorId(id_perfil).getId();
        this.nome= pDAO.carregarPorId( id_perfil).getNome();
        this.descricao = pDAO.carregarPorId(id_perfil).getDescricao();
        this.listaMenu = pDAO.carregarMenusNaoPerfil(id_perfil);
      
    }
    public ArrayList<Menu> carregarMenusNaoPerfil(int id_perfil) throws Exception{
        PerfilDAO pDAO = new PerfilDAO();
       return  pDAO.carregarMenusNaoPerfil(id_perfil);
        
    } 
    public void vincularMenu(int id_perfil,int id_menu) throws Exception{
        PerfilDAO pDAO = new PerfilDAO();
        pDAO.vincularMenu(id_perfil, id_menu);
    }
     public void desvincularMenu(int id_perfil,int id_menu) throws Exception{
        PerfilDAO pDAO = new PerfilDAO();
        pDAO.desvincularMenu( id_perfil, id_menu);
    }
/******/
    
}
