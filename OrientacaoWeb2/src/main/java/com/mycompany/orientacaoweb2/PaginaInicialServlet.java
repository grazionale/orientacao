package com.mycompany.orientacaoweb2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "")
public class PaginaInicialServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.getAttribute("nome");
        if(session.getAttribute("nome") == null) {
            response.sendRedirect("/praticaum/login");
            return;
        }
        request.setAttribute("nome", session.getAttribute("nome"));
        request.getRequestDispatcher("index.jsp").include(request,response);

    }

}
