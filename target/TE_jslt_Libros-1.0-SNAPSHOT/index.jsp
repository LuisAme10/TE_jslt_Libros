<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.emergentes.modelo.Libros"%>
<%@page import="com.emergentes.modelo.GestorLibros"%>


<%
    if (session.getAttribute("biblio") == null) {
        GestorLibros objeto1 = new GestorLibros();

        objeto1.insertarLibro(new Libros(1, "noche", "willian Blake", "poemas", "fisico"));

        session.setAttribute("biblio", objeto1);
    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Lista de Libros</h1>
        <a href="Controller?op=nuevo">Nuevo</a>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>titulo</th>
                <th>autor</th>
                <th>resumen</th>
                <th>medio</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach var="item" items="${sessionScope.biblio.getLista()}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.titulo}</td>
                    <td>${item.autor}</td>
                    <td>${item.resumen}</td>
                    <td>${item.medio}</td>
                    <td><a href="Controller?op=modificar&id=${item.id }">Modificar</a></td>
                    <td><a href="Controller?op=eliminar&id=${item.id}">Eliminar</a></td>
                    <td></td>
                </tr>
            </c:forEach>

        </table>
    </body>
</html>
