
package com.mycompany.servlet;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Orientacao;


@WebServlet(name = "ListaProfOrientacao", urlPatterns = {"/lista"})
public class ListaProfOrientacao extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Orientacao> arrays = new ArrayList<>();
        
        try{
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                } catch (ClassNotFoundException ex) {
                    
                }
                java.sql.Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/orientacaoweb?autoReconnect=true&useSSL=false", "root", "utfpr");

                PreparedStatement ps = conexao.prepareStatement("SELECT * FROM professor, orientacao WHERE professor.idProfessor = orientacao.idProfessorOrientacao");
                ResultSet rs = ps.executeQuery();

                Orientacao orientacao;
                
                while(rs.next()){
                    orientacao = new Orientacao();
                    orientacao.setIdOrientacao(rs.getInt("idOrientacao"));
                    orientacao.setDescricaoOrientacao(rs.getString("descricaoOrientacao"));
                    orientacao.setOrientadoOrientacao(rs.getString("orientadoOrientacao"));
                    orientacao.getProfessor().setIdProfessor(rs.getInt("idProfessor"));
                    orientacao.getProfessor().setNomeProfessor(rs.getString("nomeProfessor"));
                    
                    arrays.add(orientacao);
                    System.out.println(orientacao);
                }
                conexao.close();
            }catch(SQLException e){ 
                e.printStackTrace();
            }
        
        request.setAttribute("orientacoes", arrays);
        request.getRequestDispatcher("lista.jsp").forward(request, response);
    }
    
   /* public void doPost (HttpServletRequest request, HttpServletResponse response){
            try{
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                } catch (ClassNotFoundException ex) {
                    
                }
                java.sql.Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/web2?autoReconnect=true&useSSL=false", "root", "utfpr");

                PreparedStatement ps = conexao.prepareStatement("INSERT INTO Municipio(Codigo, Nome, Uf) VALUES (1, ?, 'NA')");
                ps.setString(1, request.getParameter("inputNewCidade"));
                ps.executeUpdate();
                
                conexao.close();
                request.getRequestDispatcher("pesquisacidades.jsp").forward(request, response);
            }catch(SQLException e){ 
                e.printStackTrace();
            } catch (ServletException ex) {
            Logger.getLogger(ListaProfOrientacao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ListaProfOrientacao.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
        
    }/*
    
    */

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>


}
