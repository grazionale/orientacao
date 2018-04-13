

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">        
    </head>
    <body>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        
                <div id="content1">
                    <ul>
                        <c:forEach items="${orientacoes}" var="array">
                            <li>
                                <c:out value="${array.idOrientacao}"/>
                                <c:out value="${array.descricaoOrientacao}"/>
                                <c:out value="${array.orientadoOrientacao}"/>
                                <c:out value="${array.getProfessor().idProfessor}"/>
                                <c:out value="${array.getProfessor().nomeProfessor}"/>
                            </li>
                        </c:forEach>
                    </ul>
                </div>

        
    </body>
</html>

