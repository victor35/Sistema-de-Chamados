/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import java.util.ArrayList;


/**
 *
 * @author victor
 */
public class ChamadoDAO extends DataBaseDAO {

    public void inserir(Chamado c) throws Exception {
        this.conectar();
        String sql = "INSERT INTO chamado (descricao,local,responsavel,requisitante,prioridade,status,solucoes,dataDeAbertura,dataDeFechamento,id_usuario,id_equipamentos,id_unidade) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pstm = cnn.prepareStatement(sql);
        pstm.setString(1, c.getDescricao());
        pstm.setString(2, c.getLocal());
        pstm.setString(3, c.getResponsavel());
        pstm.setString(4, c.getRequisitante());
        pstm.setString(5, c.getPrioridade());
        pstm.setString(6, c.getStatus());
        pstm.setString(7, c.getSolucoes());
        pstm.setString(8, c.getDataDeAbertura());
        pstm.setString(9, c.getDataDeFechamento());
        pstm.setInt(10, c.getUsuario().getId());
        pstm.setInt(11, c.getEquipamentos().getId());
        pstm.setInt(12, c.getUnidade().getId());   
        pstm.execute();
        this.desconectar();
    }

    public void alterar(Chamado c) throws Exception {
        this.conectar();
        String sql = "UPDATE chamado SET descricao=?,local=?,requisitante=?,prioridade=?,dataDeAbertura=?,id_usuario=?,id_equipamentos=? WHERE id=?";
        PreparedStatement pstm = cnn.prepareStatement(sql);
        pstm.setString(1, c.getDescricao());
        pstm.setString(2, c.getLocal());
        pstm.setString(3, c.getRequisitante());
        pstm.setString(4, c.getPrioridade());
        pstm.setString(5, c.getDataDeAbertura());
        pstm.setInt(6, c.getUsuario().getId());
        pstm.setInt(7, c.getEquipamentos().getId());
        pstm.setInt(8, c.getId());
        pstm.execute();
        this.desconectar();
    }
    public void excluir(Chamado c) throws Exception {
        this.conectar();
        String sql = "DELETE FROM chamado WHERE id=?";
        PreparedStatement pstm = cnn.prepareStatement(sql);
        pstm.setInt(1, c.getId());
        pstm.execute();
        this.desconectar();
    }

    public ArrayList<Chamado> listar(int id) throws Exception {
        this.conectar();
        ArrayList<Chamado> lista = new ArrayList<>();
        String sql = "SELECT * FROM chamado  WHERE id_unidade=?";
        PreparedStatement pstm = cnn.prepareStatement(sql);
        pstm.setInt(1, id);
        ResultSet rs;
        rs = pstm.executeQuery();
        while (rs.next()) {
            Chamado c = new Chamado();
            c.setId(rs.getInt("id"));
            c.setDescricao(rs.getString("descricao"));
            c.setLocal(rs.getString("local"));
            c.setRequisitante(rs.getString("requisitante"));
            c.setResponsavel(rs.getString("responsavel"));
            c.setPrioridade(rs.getString("prioridade"));
            c.setStatus(rs.getString("status"));
            c.setSolucoes(rs.getString("solucoes"));
            c.setDataDeAbertura(rs.getString("dataDeAbertura"));
            c.setDataDeFechamento(rs.getString("dataDeFechamento"));
            UsuarioDAO uDAO = new UsuarioDAO();
            c.setUsuario(uDAO.carregarPorId(rs.getInt("id_usuario")));
            EquipamentosDAO eDAO = new EquipamentosDAO();
            c.setEquipamentos(eDAO.carregarPorId(rs.getInt("id_equipamentos")));
            
            lista.add(c);
        }
        this.desconectar();
        return lista;
    }

    public Chamado carregarPorId(int id) throws Exception {
        this.conectar();
        Chamado c = new Chamado();
        String sql = "SELECT * FROM chamado WHERE id=?";
        PreparedStatement pstm = cnn.prepareStatement(sql);
        pstm.setInt(1, id);
        ResultSet rs;
        rs = pstm.executeQuery();
        if (rs.next()) {
            c.setId(rs.getInt("id"));
            c.setDescricao(rs.getString("descricao"));
            c.setLocal(rs.getString("local"));
            c.setRequisitante(rs.getString("requisitante"));
            c.setResponsavel(rs.getString("responsavel"));
            c.setPrioridade(rs.getString("prioridade"));
            c.setStatus(rs.getString("status"));
            c.setSolucoes(rs.getString("solucoes"));
            c.setDataDeAbertura(rs.getString("dataDeAbertura"));
            c.setDataDeFechamento(rs.getString("dataDeFechamento"));
            UsuarioDAO uDAO = new UsuarioDAO();
            c.setUsuario(uDAO.carregarPorId(rs.getInt("id_usuario")));
            EquipamentosDAO eDAO = new EquipamentosDAO();
            c.setEquipamentos(eDAO.carregarPorId(rs.getInt("id_equipamentos")));
        }
        this.desconectar();
        return c;
    }
    public void atenderChamado(Chamado ch) throws Exception {
        this.conectar();
        String sql = "UPDATE chamado SET status = 'em atendimento', responsavel=? WHERE id=?";
        PreparedStatement pstm = cnn.prepareStatement(sql);
        pstm.setString(1, ch.getResponsavel());
        pstm.setInt(2, ch.getId());
        pstm.execute();
        this.desconectar();
    }
    public void concluirChamado(Chamado ch) throws Exception{
        this.conectar();
        String sql = "UPDATE chamado SET status = 'concluido', solucoes=?, dataDeFechamento=? WHERE id=?";
        PreparedStatement pstm = cnn.prepareStatement(sql);
        pstm.setString(1,ch.getSolucoes());
        pstm.setString(2, ch.getDataDeFechamento());
        pstm.setInt(3, ch.getId());
        
        pstm.execute();
        this.desconectar();
    }
    public void cancelarChamado(Chamado ch) throws Exception{
        this.conectar();
        String sql = "UPDATE chamado SET status = 'cancelado' WHERE id=?";
        PreparedStatement pstm = cnn.prepareStatement(sql);
        pstm.setInt(1, ch.getId());
        pstm.execute();
        this.desconectar();
    }
    
    }
    


