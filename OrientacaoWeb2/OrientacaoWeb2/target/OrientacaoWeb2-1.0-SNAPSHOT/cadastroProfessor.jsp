<%-- 
    Document   : cadastroProfessor
    Created on : 10/04/2018, 19:48:14
    Author     : gabri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Bem Vindo a Tela de Cadastro de Professores!</h1>
        
        <form method="POST" name="cadastrarProfessores">
            <input type="text" name="nomeProfessor">
            <button type="submite" value="Cadastrar"></button>
        </form>
        
        <div><h4>${msgSucesso}</h4></div>
    </body>
</html>
