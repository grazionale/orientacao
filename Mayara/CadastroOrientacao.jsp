<%-- 
    Document   : cadastroOrientacao
    Created on : 12/04/2018, 19:48:14
    Author     : mayara
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Cadastrar de Orientação:</h1>
        
        <form method="POST" name="cadastrarOrientacao">
            <input type="text" name="descricaoOrientacao">
            <input type="text" name="orientadoOrientacao">
              <!--  <select name="pergunta1" class="frmCmb1"> -->
                    <option value="">Selecione o Professor</option>
                    <c:forEach var="objetoDaVez" items="${objetoRecebido}">
                        <option name="option" value="${objetoDaVez.idDoObjeto}">
                            ${objetoDaVez.nomeObjeto}
                        </option>
                    </c:forEach>
                <!-- </select> -->
            <button type="submite" value="Cadastrar"></button>
        </form>
        
        <div><h4>${msgSucesso}</h4></div>
    </body>
</html>
