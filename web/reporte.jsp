<%-- 
    Document   : reporte
    Created on : Oct 6, 2019, 8:10:09 PM
    Author     : DANIEL
--%>

<%@page import="java.sql.Date"%>
<%@page import="DBManager.connectionManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="Interaccion.Interaccion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
           //Recibir un request con el tipo de reporte y las fechas de comparación
           Date fechaI = Date.valueOf("1000-01-01"), fechaF = Date.valueOf("9999-12-31");
           if (request.getParameter("fechaI") != null)fechaI = Date.valueOf(request.getParameter("FechaI"));
           if (request.getParameter("fechaF") != null) fechaF = Date.valueOf(request.getParameter("FechaF"));
           String[] col = null;
           String tabla="";
           ResultSet consulta = null;
           String campos = "I.Fecha, I.Revista, I.Usuario ";
           switch (request.getParameter("tipo")){
               case "suscripciones":
                   tabla = "Suscripcion";
                   col = new String[] {"Fecha", "Revista", "Usuario"};
                   break;
                   case "comentarios":
                       tabla = "Comentario";
                       col = new String[] {"Fecha", "Revista", "Usuario", "Texto"};
                       campos += ",Comentario.Texto";
                       break;
           }     
            if(tabla != ""){ consulta = connectionManager.query("SELECT "
                           + campos
                           + " FROM Interaccion I "
                           + "INNER JOIN " + tabla
                           + " ON I.Cod = "+tabla+".Cod"
                                   + "WHERE Fecha>'"+fechaI+"' "
                                   + "AND Fecha<'"+fechaF+"'");
                    }else {
                col = null;
            }
           if (col!=null) {
                   out.println("<table>");
                   out.println("<tr>");
                   for (String elem : col) {
                            out.println("<th>");
                           out.println(elem);
                            out.println("</th>");
                       }
                   out.println("</tr>");
                   
                   while (consulta.next()) {
                        out.println("<tr>");
                        for (String elem : col) {
                                 out.println("<td>");
                                 String valor = consulta.getString(elem);
                                 out.println(valor);
                                 out.println("</td>");
                        }
                        out.println("</tr>");
                   }
                   out.println("</table>");
               }
        %>
    </body>
</html>
