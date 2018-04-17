/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.orientacaoweb2;

import com.mycompany.orientacaoweb2.dao.UsuarioDAO;
import com.mycompany.orientacaoweb2.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author joao
 */
@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.getRequestDispatcher("login.jsp").include(request, response);
    }

   protected void doPost(HttpServletRequest request, HttpServletResponse response)  
                    throws ServletException, IOException {  
       
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        
        Usuario usuario = null;
        try {
            usuario = usuarioDAO.buscarPorEmailESenha(email, senha);
            HttpSession session = request.getSession();
            session.setAttribute("nome", usuario.getNome());
            session.setAttribute("id", usuario.getId());
            response.sendRedirect("");
        } catch (Exception e) {
            response.getWriter().write("<h4>Usuário ou senha inválido!</h4>");
            request.getRequestDispatcher("login.jsp").include(request, response);
            e.printStackTrace();
        }
        
        out.close();
    }

}
