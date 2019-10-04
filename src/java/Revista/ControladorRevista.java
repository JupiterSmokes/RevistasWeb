/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Revista;

import DBManager.connectionManager;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author DANIEL
 */
@WebServlet("/ControladorRevista")
public class ControladorRevista extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Revista r = new Revista(req);
        connectionManager.insert(r);
        
        resp.setContentType("text/html");
        String nueva = "edicion.html";
        resp.setStatus(resp.SC_MOVED_TEMPORARILY);
        resp.setHeader("Location", nueva);
    }
    
}
