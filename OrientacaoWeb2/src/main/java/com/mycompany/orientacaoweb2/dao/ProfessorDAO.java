package com.mycompany.orientacaoweb2.dao;

import com.mycompany.orientacaoweb2.model.Professor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProfessorDAO {
    private final Connection con;
    private PreparedStatement pst;
    
    public ProfessorDAO() {
        this.con = new Conexao().Conector();
    }
    
    public void criar(Professor professor) throws Exception {
                
        String sql = "INSERT INTO professor (nomeProfessor) VALUES (?);";

        try {
            PreparedStatement pst = this.con.prepareStatement(sql);
            pst.setString(1, professor.getNomeProfessor());
            pst.execute();
            
        } catch (Exception e) {
            throw new RuntimeException(e);              
        }
    }
    
    public ArrayList<Professor> listarTodos() throws Exception{
        PreparedStatement ps = con.prepareStatement("select * from professor;");
        ResultSet rs = ps.executeQuery();
        ArrayList<Professor> profArray = new ArrayList<>();
        Professor p;        
        
            while(rs.next()){
                p = new Professor();

                p.setIdProfessor(rs.getInt("idProfessor"));
                p.setNomeProfessor(rs.getString("nomeProfessor"));
                profArray.add(p);
            }   

            rs.close();
            return profArray.size() > 0 ? profArray : null;
    }
}
