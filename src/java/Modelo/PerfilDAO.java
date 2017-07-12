/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Administrador
 */
public class PerfilDAO extends DataBaseDAO {
    
    public void inserir(Perfil p) throws Exception{
       this.conectar();
       String sql = "INSERT INTO perfil (nome,descricao) VALUES (?,?)";
       PreparedStatement pstm = cnn.prepareStatement(sql);
       pstm.setString(1, p.getNome());
       pstm.setString(2, p.getDescricao());
       pstm.execute();
       this.desconectar();
    }
    
    public void alterar(Perfil p) throws Exception{
        this.conectar();
        String sql = "UPDATE perfil SET  nome=?, descricao=? WHERE id=? ";
        PreparedStatement pstm = cnn.prepareStatement(sql);
        pstm.setString(1, p.getNome());
        pstm.setString(2, p.getDescricao());
        pstm.setInt(3, p.getId());
        pstm.execute();
        this.desconectar();
    }
    public void excluir(Perfil p) throws Exception{
        this.conectar();
        String sql = "DELETE FROM perfil WHERE id=?";
        PreparedStatement pstm = cnn.prepareStatement(sql);
        pstm.setInt(1, p.getId());
        pstm.execute();
        this.desconectar();
    }
    
    public ArrayList<Perfil> listar() throws Exception {
        this.conectar();
        ArrayList<Perfil> lista = new ArrayList<>();
        String sql ="SELECT * FROM perfil";
        PreparedStatement pstm = cnn.prepareStatement(sql);
        ResultSet rs;
        rs = pstm.executeQuery();
        while(rs.next()){
            Perfil p = new Perfil();
            p.setId(rs.getInt("id"));
            p.setNome(rs.getString("nome"));
            p.setDescricao(rs.getString("descricao"));
            lista.add(p);
        }
        this.desconectar();
        return lista;
    }
    
    public Perfil carregarPorId( int id) throws Exception{
        this.conectar();
        Perfil p = new Perfil();
        String sql = "SELECT * FROM perfil WHERE id=?";
        PreparedStatement pstm = cnn.prepareStatement(sql);
        pstm.setInt(1, id);
        ResultSet rs;
        rs = pstm.executeQuery();
        if(rs.next()){
            p.setId(rs.getInt("id"));
            p.setNome(rs.getString("nome"));
            p.setDescricao(rs.getString("descricao"));
            p.setMenusPerfil(this.carregarMenusPerfil(id));
        }
        this.desconectar();
        return p;
    }
    
    public ArrayList<Menu> carregarMenusPerfil(int id_perfil) throws Exception{
        this.conectar();
        ArrayList<Menu> lista = new ArrayList<>();
        String sql = "SELECT m.* FROM menu as m, menu_perfil as mp WHERE m.id=mp.id_menu AND mp.id_perfil=?";
        PreparedStatement pstm = cnn.prepareStatement(sql);
        pstm.setInt(1, id_perfil);
        ResultSet rs;
        rs = pstm.executeQuery();
        while(rs.next()){
            Menu m = new Menu();
            m.setId(rs.getInt("id"));
            m.setTitulo(rs.getString("titulo"));
            m.setLink(rs.getString("link"));
          
            lista.add(m);
        }
        this.desconectar();
        return lista;
    }
    
    public ArrayList<Menu> carregarMenusNaoPerfil(int id_perfil) throws Exception{
        ArrayList<Menu> lista = new ArrayList<>();
        this.conectar();
        String sql = "SELECT * FROM menu WHERE id NOT IN(SELECT id_menu FROM menu_perfil WHERE id_perfil=?)";
        PreparedStatement pstm = cnn.prepareStatement(sql);
        pstm.setInt(1, id_perfil);
        ResultSet rs;
        rs = pstm.executeQuery();
        while(rs.next()){
            Menu m = new Menu();
            m.setId(rs.getInt("id"));
            m.setTitulo(rs.getString("titulo"));
            m.setLink(rs.getString("link"));
          
            lista.add(m);
        }
        this.desconectar();
        return lista;
    }
    
    public void vincularMenu(int id_menu, int id_perfil) throws Exception{
        this.conectar();
        String sql = "INSERT INTO menu_perfil (id_menu,id_perfil) VALUES (?,?)";
        PreparedStatement pstm = cnn.prepareStatement(sql);
        pstm.setInt(1,id_menu);
        pstm.setInt(2,id_perfil);
        pstm.execute();
        this.desconectar();
    }
    
    public void desvincularMenu(int id_menu, int id_perfil) throws Exception{
        this.conectar();
        String sql = "DELETE FROM menu_perfil WHERE id_menu=? AND id_perfil=?";
        PreparedStatement pstm = cnn.prepareStatement(sql);
        pstm.setInt(1, id_menu);
        pstm.setInt(2,id_perfil);
        pstm.execute();
        this.desconectar();
    }
    
    
}
