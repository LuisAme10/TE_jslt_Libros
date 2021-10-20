<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
            <c:if test="${requestScope.op =='nuevo'}" var="res" scope="request">
                Registro de
            </c:if>
            <c:if test="${requestScope.op=='modificar'}" var="res" scope="request">
                modificar

            </c:if>
            libro
        </h1>
        <jsp:useBean id="miLibro" scope="request" class="com.emergentes.modelo.Libros" />
        <form action="Controller" method="post">
            <table>
                <tr>
                    <td>Id</td>
                    <td><input type="text" name="id" 
                               value="<jsp:getProperty name="miLibro" property="id" />"></td>
                </tr>
                <tr>
                    <td>Titulo</td>
                    <td><input type="text" name="titulo" value =" "
                               value="<jsp:getProperty  name="miLibro" property="titulo"/>"></td>
                </tr>
                <tr>
                    <td>autor</td>
                    <td><input type="text" name="autor" value =" "
                               value="<jsp:getProperty  name="miLibro" property="autor"/>"></td>
                </tr>
                <tr>
                    <td>resumen</td>
                    <td><textarea name="resumen" rows="10" cols="40" value="<jsp:getProperty 
                                      name="miLibro" property="resumen"/>"></textarea></td>
                </tr>
                
                <tr>
                    <td>medio</td>
                    <td><input type="radio" name="medio" value="fisico" 
                               <c:if test="${miLibro.medio=='fisico'}" 
                                     var="res" scope="request">selected
                               </c:if> >fisico</td>
                    <td><input type="radio" name="medio" value="digital" 
                               <c:if test="${miLibro.medio=='digital'}" 
                                     var="res" scope="request">selected
                               </c:if> >digital</td>
                </tr>
                 <tr>
                    <td>
                        <input type="hidden" name="opg" value="${requestScope.op}" />
                        <input type="hidden" name="op" value="grabar" />
                    </td>
                    <td><input type="submit" value="Enviar" /></td>
                </tr>
            </table>
        </form>
        
        
    </body>
</html>
