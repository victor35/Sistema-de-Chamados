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
public class MenuDAO extends DataBaseDAO {
 
    public void inserir(Menu m) throws Exception{
       this.conectar();
       String sql = "INSERT INTO menu (link,titulo) VALUES (?,?)";
       PreparedStatement pstm = cnn.prepareStatement(sql);
       pstm.setString(1, m.getLink());
       pstm.setString(2, m.getTitulo());
       
       pstm.execute();
       this.desconectar();
    }
    
    public void alterar(Menu m) throws Exception{
        this.conectar();
        String sql = "UPDATE menu SET  link=?, titulo=? WHERE id=? ";
        PreparedStatement pstm = cnn.prepareStatement(sql);
        pstm.setString(1, m.getLink());
        pstm.setString(2, m.getTitulo());
        
        pstm.setInt(3, m.getId());
        pstm.execute();
        this.desconectar();
    }
    public void excluir(Menu m) throws Exception{
        this.conectar();
        String sql = "DELETE FROM menu WHERE id=?";
        PreparedStatement pstm = cnn.prepareStatement(sql);
        pstm.setInt(1, m.getId());
        pstm.execute();
        desconectar();
    }
    
    public ArrayList<Menu> listar() throws Exception {
        this.conectar();
        ArrayList<Menu> lista = new ArrayList<>();
        String sql ="SELECT * FROM menu";
        PreparedStatement pstm = cnn.prepareStatement(sql);
        ResultSet rs;
        rs = pstm.executeQuery();
        while(rs.next()){
            Menu m = new Menu();
            m.setId(rs.getInt("id"));
            m.setTitulo(rs.getString("titulo"));
            m.setLink(rs.getString("link"));
            
            lista.add(m);
        }
        return lista;
    }
    
    public Menu carregarPorid(int id) throws Exception{
        Menu m = new Menu();
        this.conectar();
        String sql = "SELECT * FROM menu WHERE id=?";
        PreparedStatement pstm = cnn.prepareStatement(sql);
        pstm.setInt(1,id);
        ResultSet rs;
        rs = pstm.executeQuery();
        if(rs.next()){
            m.setId(rs.getInt("id"));
           
            m.setLink(rs.getString("link"));
            m.setTitulo(rs.getString("titulo"));
            
        }
        this.desconectar();
        return m;
    }
    
    
    
    
}
    
    
    

