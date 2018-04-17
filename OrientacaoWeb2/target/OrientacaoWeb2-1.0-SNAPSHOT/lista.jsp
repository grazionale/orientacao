

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <title>JSP Page</title>
    </head>
    <style>
        .invisivel{
            display: none;
        }
        .doLadinho{
            display: inline;
        }
    </style>
    <body>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <fieldset> <legend>Busca de professor e listagem</legend>        
            <form method="GET" action="lista" accept-charset="iso-8859-1" class="doLadinho">
                <p>Pesquise o professor</p>
                <input required name="inputNome"/>
                <button type="submit">Pesquisar</button>
            </form>
            <form method="GET" action="lista" accept-charset="iso-8859-1" class="doLadinho">
                <input class="invisivel" name="inputNome"/>
                <button type="submit">Listar tudo</button>
            </form>
            <ul>
                <c:forEach items="${orientacoes}" var="array">
                    <li>${array.professor.getNomeProfessor()}
                        <ul>
                            <li>Descrição da orientação: ${array.getDescricaoOrientacao()}</li> 
                            <li>Orientado: ${array.getOrientadoOrientacao()}</li>
                        </ul>                    
                    </li>
                </c:forEach>
            </ul>
        </fieldset>
    </body>
</html>
