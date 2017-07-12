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
public class EquipamentosDAO extends DataBaseDAO {
    
    public void inserir(Equipamentos e) throws Exception{
       this.conectar();
       String sql = "INSERT INTO equipamentos (nome,descricao,tipo,id_unidade) VALUES (?,?,?,?)";
       PreparedStatement pstm = cnn.prepareStatement(sql);
       pstm.setString(1, e.getNome());
       pstm.setString(2, e.getDescricao());
       pstm.setString(3, e.getTipo());
       pstm.setInt(4, e.getUnidade().getId());
       pstm.execute();
       this.desconectar();
    }
    
    public void alterar(Equipamentos e) throws Exception{
       this.conectar();
       String sql = "UPDATE equipamentos SET nome=?,descricao=?,tipo=? WHERE id=?";
       PreparedStatement pstm = cnn.prepareStatement(sql);
       pstm.setString(1, e.getNome());
       pstm.setString(2, e.getDescricao());
       pstm.setString(3, e.getTipo());
       pstm.setInt(4,e.getId());
       pstm.execute();
       this.desconectar();
    }
    
    public void excluir(Equipamentos e) throws Exception{
        this.conectar();
        String sql = "DELETE FROM equipamentos WHERE id=?";
        PreparedStatement pstm = cnn.prepareStatement(sql);
        pstm.setInt(1, e.getId());
        pstm.execute();
        this.desconectar();
    }
    
    public ArrayList<Equipamentos> listar(int id) throws Exception {
        this.conectar();
        ArrayList<Equipamentos> lista = new ArrayList<>();
        String sql ="SELECT * FROM equipamentos WHERE id_unidade=?";
        PreparedStatement pstm = cnn.prepareStatement(sql);
        pstm.setInt(1, id);
        ResultSet rs;
        rs = pstm.executeQuery();
        while(rs.next()){
            Equipamentos e = new Equipamentos();
            e.setId(rs.getInt("id"));
            e.setNome(rs.getString("nome"));
            e.setDescricao(rs.getString("descricao"));
            e.setTipo(rs.getString("tipo"));
            UnidadeDAO uDAO= new UnidadeDAO();
            e.setUnidade(uDAO.carregarPorId(rs.getInt("id_unidade")));
            lista.add(e);
        }
        this.desconectar();
        return lista;
    }
    
    public Equipamentos carregarPorId(int id) throws Exception{
        this.conectar();
        Equipamentos e = new Equipamentos();     
        String sql = "SELECT * FROM equipamentos WHERE id=?";
        PreparedStatement pstm = cnn.prepareStatement(sql);
        pstm.setInt(1, id);
        ResultSet rs = pstm.executeQuery();
        if(rs.next()){
            e.setId(rs.getInt("id"));
            e.setNome(rs.getString("nome"));
            e.setDescricao(rs.getString("descricao"));
            e.setTipo(rs.getString("tipo"));
            UnidadeDAO uDAO = new UnidadeDAO();
            e.setUnidade(uDAO.carregarPorId(rs.getInt("id_unidade")));
        }
        this.desconectar();
        return e;
    }
    
}
