<%-- 
    Document   : professor
    Created on : 10/04/2018, 19:31:36
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
        
        <div>
            ${batata_msg}
        </div>
        
        <form method="post" action="batata" name="formBatata">
            <input type="text" name="nome" />
            
            <input type="text" name="descricao" />
            
            <button type="submit"></button>
        </form>
    </body>
</html>
