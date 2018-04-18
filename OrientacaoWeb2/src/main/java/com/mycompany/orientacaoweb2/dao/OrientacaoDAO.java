/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.orientacaoweb2.dao;

import com.mycompany.orientacaoweb2.model.Orientacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author gabri
 */
public class OrientacaoDAO {
    private final Connection con;
    private PreparedStatement pst;
    
    public OrientacaoDAO() {
        this.con = new Conexao().Conector();
    }
    
    public void inserir(Orientacao orientacao) throws Exception{
                pst = con.prepareStatement("insert into orientacao (descricaoOrientacao, orientadoOrientacao, idProfessorOrientacao) VALUES (?, ?, ?);");
                pst.setString(1, orientacao.getDescricaoOrientacao());
                pst.setString(2, orientacao.getOrientadoOrientacao());
                pst.setInt(3, orientacao.getProfessor().getIdProfessor());
                pst.execute();
    }
    
    public ArrayList<Orientacao> listar(String nome) throws Exception{
        PreparedStatement ps = con.prepareStatement("SELECT professor.*, orientacao.* FROM orientacao INNER JOIN professor ON "
                + "orientacao.idProfessorOrientacao = professor.idProfessor WHERE professor.nomeProfessor LIKE'%"+nome+"%'");
        
        ResultSet rs = ps.executeQuery();
        ArrayList<Orientacao> oriArray = new ArrayList<>();
        Orientacao orientacao;       
        
            while(rs.next()){
                orientacao = new Orientacao();

                orientacao.setIdOrientacao(rs.getInt("idOrientacao"));
                orientacao.setDescricaoOrientacao(rs.getString("descricaoOrientacao"));
                orientacao.setOrientadoOrientacao(rs.getString("orientadoOrientacao"));
                orientacao.getProfessor().setIdProfessor(rs.getInt("idProfessor"));
                orientacao.getProfessor().setNomeProfessor(rs.getString("nomeProfessor"));
            }   

            rs.close();
            return oriArray.size() > 0 ? oriArray : null;
    }
}
