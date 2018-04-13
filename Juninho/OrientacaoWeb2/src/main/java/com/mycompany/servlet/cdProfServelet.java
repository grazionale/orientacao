package com.mycompany.orientacaoweb2;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "cdProfServelet", urlPatterns = {"/cdProfServlet"})
public class cdProfServelet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
       
        request.getRequestDispatcher("cadastroProfessor.jsp").forward(request, response); 

    }
    
     protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
         
        try{
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                } catch (ClassNotFoundException ex) {
                    
                }
                java.sql.Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/orientacaoweb?autoReconnect=true&useSSL=false", "root", "utfpr");

                PreparedStatement ps = conexao.prepareStatement("INSERT INTO professor (nomeProfessor) VALUES (?);");
                ps.setString(1, request.getParameter("nomeProfessor"));
                ps.execute();
                
                conexao.close();
            }catch(SQLException e){ 
                e.printStackTrace();
            }
        String msg = "Professor Cadastrado com Sucesso";
        request.setAttribute("msgSucesso", msg);
        request.getRequestDispatcher("cadastroProfessor.jsp").forward(request, response); 
 
     }
}
