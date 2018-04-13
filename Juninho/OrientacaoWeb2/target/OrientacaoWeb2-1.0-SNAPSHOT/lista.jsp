

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <title>JSP Page</title>
    </head>
    <style>
        ul {
            display: block;
        }
    </style>
    <body>
        <div>
            <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
            <fieldset> <legend>Listagem</legend>        
                <form method="GET" action="lista" accept-charset="iso-8859-1">
                    <button onclick="mostrar()">Clique para listar ou esconder</button>            
                </form>
                <ul id="lista">
                    <c:forEach items="${orientacoes}" var="array">
                        <li>${array.professor.getNomeProfessor()}
                            <ul id="lista">
                                <li>Descrição da orientação: ${array.getDescricaoOrientacao()}  </li> 
                                <li>Orientado: ${array.getOrientadoOrientacao()}</li>
                            </ul>                    
                        </li>
                    </c:forEach>
                </ul>
            </fieldset>
        </div>        
    </body>
    
    <script>
        function mostrar(){
            var x = document.getElementsById("lista");
            if(x.style.display === "none"){
                x.style.display = "block";
            }
            else{
                x.style.display = "none";
            }
        }
    </script>
</html>
