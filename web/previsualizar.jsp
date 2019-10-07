<%-- 
    Document   : previsualizar
    Created on : Oct 4, 2019, 11:26:38 AM
    Author     : DANIEL
--%>

<%@page import="java.sql.ResultSet"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.sql.Date"%>
<%@page import="DBManager.connectionManager"%>
<%@page import="Funciones.Funciones"%>
<%@page import="Revista.Revista"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="./css/previsualizarRev.css">
</head>
<%
String titulo = request.getParameter("titulo");
Revista r = new Revista(titulo);
r = (Revista) Funciones.recuperar(connectionManager.select(r,new String[] {"*"}, new String[] {"nombre"}), r.getClass().getSimpleName());
if(r==null) r= new Revista();
ResultSet consultaSuscripcion = connectionManager.query("SELECT Interaccion.Usuario FROM "
        + "Suscripcion INNER JOIN Interaccion ON Suscripcion.Cod=Interaccion.Cod"
        + "WHERE Interaccion.Revista = " + r.getId());
%>

<c:if test='<%=!connectionManager.checkStatement("SELECT Interaccion.Usuario FROM "
        + "Interaccion INNER JOIN Suscripcion ON Interaccion.Cod=Suscripcion.Cod"
        + "WHERE Interaccion.Revista = " + r.getId()) %>'>
<body>
    <div class="row" id="io113h"
        <div class="cell" id="i1pchj">
            <section id="etiquetas" class="bdg-sect">
                <h1 id="titulo" class="heading"><%=r.getNombre()%> </h1>
                <div id="meGusta">[Me gusta]</div>
                <p id="descripcion" class="paragraph"><%=r.getDescripcion()%></p>
                <div id="categoria"><%=r.getCategoria()%></div>
                <div id="autor"><%=r.getEditor()%></div>
                <div id="itxpk5">
                    <div>[Etiquetas]</div>
                </div>
                <div class="form-group"><button type="button" class="button"
                                                onclick="">
                        Suscribirse</button></div>
            </section>
        </div>
    </div>
    
</body>
</c:if>
<c:if test='<%=connectionManager.checkStatement("SELECT Interaccion.Usuario FROM "
        + "Interaccion INNER JOIN Suscripcion ON Interaccion.Cod=Suscripcion.Cod"
        + "WHERE Interaccion.Revista = " + r.getId()) %>'>
    
        </c:if>
<html>
