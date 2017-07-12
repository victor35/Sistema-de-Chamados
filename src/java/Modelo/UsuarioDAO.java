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
public class UsuarioDAO extends DataBaseDAO{
    
    public void inserir(Usuario u) throws Exception {
        this.conectar();
        String sql = "INSERT INTO usuario (nome,login,senha,telefone,email,id_unidade,id_perfil) VALUES (?,?,?,?,?,?,?)";
        PreparedStatement pstm = cnn.prepareStatement(sql);
        pstm.setString(1, u.getNome());
        pstm.setString(2, u.getLogin());
        pstm.setString(3, u.getSenha());
        pstm.setString(4, u.getTelefone());
        pstm.setString(5, u.getEmail());
        pstm.setInt(6, u.getUnidade().getId());
        pstm.setInt(7, u.getPerfil().getId());
        pstm.execute();
        this.desconectar();
    }

    public void alterar(Usuario u) throws Exception {
        this.conectar();
        String sql = "UPDATE usuario SET  nome=?, login=?, senha=?, telefone=?, email=?,id_unidade=?, id_perfil=? WHERE id=? ";
        PreparedStatement pstm = cnn.prepareStatement(sql);
        pstm.setString(1, u.getNome());
        pstm.setString(2, u.getLogin());
        pstm.setString(3, u.getSenha());
        pstm.setString(4, u.getTelefone());
        pstm.setString(5, u.getEmail());
        pstm.setInt(6, u.getUnidade().getId());
        pstm.setInt(7, u.getPerfil().getId());
        pstm.setInt(8, u.getId());
        pstm.execute();
        this.desconectar();
    }

    public void excluir(Usuario u) throws Exception {
        this.conectar();
        String sql = "DELETE FROM usuario WHERE id=?";
        PreparedStatement pstm = cnn.prepareStatement(sql);
        pstm.setInt(1, u.getId());
        pstm.executeUpdate();
        this.desconectar();
    }

    public ArrayList<Usuario> listar(int id) throws Exception {
        this.conectar();
        ArrayList<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuario WHERE id_unidade=? ";
        PreparedStatement pstm = cnn.prepareStatement(sql);
        pstm.setInt(1, id);
        ResultSet rs;
        rs = pstm.executeQuery();
        while (rs.next()) {
            Usuario u = new Usuario();
            u.setId(rs.getInt("id"));
            u.setNome(rs.getString("nome"));
            u.setLogin(rs.getString("login"));
            u.setSenha(rs.getString("senha"));
            u.setTelefone(rs.getString("telefone"));
            u.setEmail(rs.getString("email"));
            UnidadeDAO uDAO = new UnidadeDAO();
            u.setUnidade(uDAO.carregarPorId(rs.getInt("id_unidade")));
            PerfilDAO pDAO = new PerfilDAO();
            u.setPerfil(pDAO.carregarPorId(rs.getInt("id_perfil")));
            
            lista.add(u);
        }
        this.desconectar();
        return lista;
    }

    public Usuario carregarPorId(int id) throws Exception {
        this.conectar();
        Usuario u = new Usuario();
        String sql = "SELECT * FROM usuario WHERE id=?";
        PreparedStatement pstm = cnn.prepareStatement(sql);
        pstm.setInt(1, id);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            u.setId(rs.getInt("id"));
            u.setNome(rs.getString("nome"));
            u.setLogin(rs.getString("login"));
            u.setSenha(rs.getString("senha"));
            u.setTelefone(rs.getString("telefone"));
            u.setEmail(rs.getString("email"));
            UnidadeDAO uDAO = new UnidadeDAO();
            u.setUnidade(uDAO.carregarPorId(rs.getInt("id_unidade")));
            PerfilDAO pDAO = new PerfilDAO();
            u.setPerfil(pDAO.carregarPorId(rs.getInt("id_perfil")));

        }
        this.desconectar();
        return u;
    }

    public Usuario logar(String login, String senha) throws Exception {
        Usuario u = new Usuario();
        this.conectar();
        String sql = "SELECT * FROM usuario WHERE login=?";
        PreparedStatement pstm = cnn.prepareStatement(sql);
        pstm.setString(1, login);
        ResultSet rs;
        rs = pstm.executeQuery();
        if (rs.next()) {
            if (rs.getString("senha").equals(senha)) {
                u.setId(rs.getInt("id"));
                u.setNome(rs.getString("nome"));
                u.setLogin(rs.getString("login"));
                u.setSenha(rs.getString("senha"));
                UnidadeDAO uDAO = new UnidadeDAO();
                u.setUnidade(uDAO.carregarPorId(rs.getInt("id_unidade")));
                PerfilDAO pDAO = new PerfilDAO();
                u.setPerfil(pDAO.carregarPorId(rs.getInt("id_perfil")));
            }

        }
        this.desconectar();
        return u;
    }
}
