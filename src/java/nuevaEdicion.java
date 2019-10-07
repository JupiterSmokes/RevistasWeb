/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DBManager.connectionManager;
import static DBManager.connectionManager.select;
import Revista.Edicion;
import Revista.Revista;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author DANIEL
 */
@MultipartConfig
@WebServlet(urlPatterns = {"/e/nuevaEdicion"})
public class nuevaEdicion extends HttpServlet {

private Part archivo;   
private InputStream input;
private FileOutputStream out;
private  String path = ".."+File.separator+"Upload"+File.separator;
private int parte;
private Revista r = new Revista();
String nombreR;
private Edicion nueva = new Edicion();
private String uploadPath;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        nueva = new Edicion(request);
        r.setId(nueva.getRevista());
        ResultSet revista = connectionManager.select(r, new String[] {"Nombre"}, new String[] {"Id"});
        try {
            revista.first();
            nombreR = revista.getString("Nombre");
        } catch (Exception e) {
            System.out.println("Revista inexistente");
        } finally {
            connectionManager.close();
        }
        
        uploadPath = path + nombreR + File.separator;
        archivo = request.getPart("file");
        File dir = new File(uploadPath);
        dir.mkdirs();
        input = archivo.getInputStream();
        uploadPath += nueva.getNumero()+".pdf";
        out = new FileOutputStream(uploadPath);
        parte = input.read();
        while (parte!=-1) {            
            out.write(parte);
            parte=input.read();
        }
        System.out.println("File uploaded to " + uploadPath);
        nueva.setPath(uploadPath);
        out.close();
        connectionManager.insert(nueva);
    }

   
}
