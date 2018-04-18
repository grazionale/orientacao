package com.mycompany.orientacaoweb2;
import com.mycompany.orientacaoweb2.dao.OrientacaoDAO;
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
import com.mycompany.orientacaoweb2.model.Orientacao;
import javax.servlet.http.HttpSession;


@WebServlet(name = "ListaProfOrientacao", urlPatterns = {"/lista"})
public class ListaProfOrientacao extends HttpServlet {
    
    OrientacaoDAO oriDao = new OrientacaoDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        session.getAttribute("nome");
        
        if(session.getAttribute("nome") == null) {
            response.sendRedirect("/praticaum/login");
            return;
        }
        
        ArrayList<Orientacao> arrays = new ArrayList<>();
        try {
            arrays = oriDao.listar(request.getParameter("inputNome"));
        } catch (Exception ex) {
            Logger.getLogger(CadOrientacao.class.getName()).log(Level.SEVERE, null, ex);
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