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
 * @author victor
 */
public class UnidadeDAO extends DataBaseDAO {
    
    public void inserir(Unidade u) throws Exception {
        this.conectar();
        String sql="INSERT INTO unidade (unidade,endereco,telefone,cep) VALUES (?,?,?,?)";
        PreparedStatement pstm = cnn.prepareStatement(sql);
        pstm.setString(1,u.getUnidade());
        pstm.setString(2,u.getEndereco());
        pstm.setString(3,u.getTelefone());
        pstm.setString(4,u.getCep());
        pstm.execute();
    }
    
    public ArrayList<Unidade> listar() throws Exception{
        this.conectar();
        ArrayList<Unidade>lista = new ArrayList<>();
        String sql = "SELECT * FROM unidade";
        PreparedStatement pstm = cnn.prepareStatement(sql);
        ResultSet rs =pstm.executeQuery();
        while(rs.next()){
            Unidade u = new Unidade();
            u.setId(rs.getInt("id"));
            u.setUnidade(rs.getString("unidade"));
            u.setEndereco(rs.getString("endereco"));
            u.setTelefone(rs.getString("telefone"));
            u.setCep(rs.getString("cep"));
            lista.add(u);
        }
        this.desconectar();
        return lista;
    }
     public void alterar(Unidade u) throws Exception {
        this.conectar();
        String sql="UPDATE unidade SET unidade=?, endereco=?, telefone=?,cep=? WHERE id=? ";
        PreparedStatement pstm = cnn.prepareStatement(sql);
        pstm.setString(1,u.getUnidade());
        pstm.setString(2,u.getEndereco());
        pstm.setString(3,u.getTelefone());
        pstm.setString(4,u.getCep());
        pstm.setInt(5, u.getId());
        pstm.execute();
        this.desconectar();
    }
     
     public void excluir(Unidade u) throws Exception {
        this.conectar();
        String sql="DELETE FROM unidade WHERE id=? ";
        PreparedStatement pstm = cnn.prepareStatement(sql);
        pstm.setInt(1,u.getId());
        pstm.execute();
        this.desconectar();
    }
     
     public Unidade carregarPorId(int id) throws Exception{
         Unidade u = new Unidade();
         this.conectar();
         String sql = "SELECT * FROM unidade WHERE id=?";
         PreparedStatement pstm = cnn.prepareStatement(sql);
         pstm.setInt(1, id);
         ResultSet rs =pstm.executeQuery();
         if(rs.next()){
           
            u.setId(rs.getInt("id"));
            u.setUnidade(rs.getString("unidade"));
            u.setEndereco(rs.getString("endereco"));
            u.setTelefone(rs.getString("telefone"));
            u.setCep(rs.getString("cep"));
           
        }
        this.desconectar();
        return u;
         
     }
     
     
     
     
}
