package com.mycompany.orientacaoweb2.dao;

import com.mycompany.orientacaoweb2.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO {
      
    private final Connection con;
    private PreparedStatement pst;
    
    public UsuarioDAO() {
        this.con = new Conexao().Conector();
    }
    
    public void criar(Usuario usuario) throws Exception {
                
        String sql = "INSERT INTO usuario(nomeUsuario, emailUsuario, senhaUsuario) VALUES (?, ?, ?);";

        try {
            PreparedStatement pst = this.con.prepareStatement(sql);
            pst.setString(1, usuario.getNome());
            pst.setString(2, usuario.getEmail());
            pst.setString(3, usuario.getSenha());
           
            pst.executeUpdate();
            pst.close();
            
        } catch (Exception e) {
            throw new RuntimeException(e);              
        }
    }
    
    public Usuario buscarPorEmailESenha(String email, String senha) throws Exception {
        
        String sql = "SELECT * FROM usuario WHERE emailUsuario = ? AND senhaUsuario = ?;";
        
        PreparedStatement ps = this.con.prepareStatement(sql);
        ps.setString(1, email);
        ps.setString(2, senha);
        ResultSet rs = ps.executeQuery();
        
        Usuario u = new Usuario();
        
        if (rs.next()) {
            u.setId(rs.getInt("idUsuario"));
            u.setEmail(rs.getString("emailUsuario"));
            u.setNome(rs.getString("nomeUsuario"));
            u.setSenha(rs.getString("senhaUsuario"));
            return u;
        } else {
            return null;
        }
    }

}
