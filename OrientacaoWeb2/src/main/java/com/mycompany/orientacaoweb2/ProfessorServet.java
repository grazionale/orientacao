package com.mycompany.orientacaoweb2;

import com.mycompany.orientacaoweb2.dao.ProfessorDAO;
import com.mycompany.orientacaoweb2.model.Professor;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "cdProfServelet", urlPatterns = {"/cdProfServlet"})
public class ProfessorServet extends HttpServlet {
    private ProfessorDAO profDao = new ProfessorDAO();
   
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.getAttribute("nome");
        if (session.getAttribute("nome") == null) {
            response.sendRedirect("/login");
            return;
        }
        request.getRequestDispatcher("cadastroProfessor.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Professor p = new Professor();
        p.setNomeProfessor(request.getParameter("nomeProfessor"));
        String msg = "";
        try {
            profDao.criar(p);
            msg = "Professor Cadastrado com Sucesso";
        } catch (Exception ex) {
            msg = "Não foi Possível Cadastrar Professor";
            Logger.getLogger(ProfessorServet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.setAttribute("msgSucesso", msg);
        request.getRequestDispatcher("cadastroProfessor.jsp").forward(request, response);

    }
}
