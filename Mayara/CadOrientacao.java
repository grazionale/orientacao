package com.mycompany.orientacaoweb2;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Professor;

@WebServlet(name = "CadOrientacao", urlPatterns = {"/CadOrientacao"})
public class CadOrientacao extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        ArrayList<Professor> prof = new ArrayList<>();
        Professor p;
        
        try{        
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                } catch (ClassNotFoundException ex) {
                    
                }
 
                java.sql.Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/orientacaoweb?autoReconnect=true&useSSL=false", "root", "utfpr");

                PreparedStatement ps = conexao.prepareStatement("select * professor;");
                ResultSet rs = ps.executeQuery();
                
                while(rs.next()){
                    p = new Professor();
                    
                    p.setIdProfessor(rs.getInt("idProfessor"));
                    p.setNomeProfessor(rs.getString("nomeProfessor"));
                    prof.add(p);
                }   
                
                rs.close();
                conexao.close();
            }catch(SQLException e){
                e.printStackTrace();
                String msg = "Erro ao localizar professores.";
                request.setAttribute("msgErro", msg);
            }
        request.setAttribute("objetoRecebido", prof);
        request.getRequestDispatcher("cadastroOrientacao.jsp").forward(request, response);  
    }
    
     protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
         
        try{
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                } catch (ClassNotFoundException ex) {
                    
                }
                java.sql.Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/orientacaoweb?autoReconnect=true&useSSL=false", "root", "utfpr");

                PreparedStatement ps = conexao.prepareStatement("insert into orientacao (descricaoOrientacao, orientadoOrientacao, idProfessorOrientacao) VALUES (?, ?, ?);");
                ps.setString(1, request.getParameter("descricaoOrientacao"));
                ps.setString(2, request.getParameter("orientadoOrientacao"));
                ps.setInt(3, Integer.parseInt(request.getParameter("option")));
                ps.execute();
                
                conexao.close();
            }catch(SQLException e){ 
                e.printStackTrace();
                String msg = "Erro ao localizar inserir orientação.";
                request.setAttribute("msgErro", msg);
            }
        String msg = "Orientação Cadastrada com Sucesso";
        request.setAttribute("msgSucesso", msg);
        request.getRequestDispatcher("cadastroOrientacao.jsp").forward(request, response); 
 
     }
}
