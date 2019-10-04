/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Revista;

/**
 *
 * @author DANIEL
 */
import DBManager.Insertable;
import DBManager.connectionManager;
import java.io.Serializable;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;


public class Edicion implements Insertable, Serializable{
    private int revista;
    private int numero;
    private String nombreEdicion;
    private String path;
    private Date fechaCreacion;
    private boolean comentable;
    private boolean likeable;

    public Edicion() {
        try {
            ResultSet n = connectionManager.query("SELECT IFNULL(MAX(NUMERO),0) FROM Edicion");
            n.first();
            this.numero = n.getInt(1)+1;
        } catch (SQLException ex) {
            Logger.getLogger(Edicion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Edicion(HttpServletRequest req) {
 //       System.out.println(req.getParameter("nombreEdicion"));
        this.revista = Integer.parseInt(req.getParameter("revista"));
        this.nombreEdicion = req.getParameter("nombreEdicion");
        this.path = req.getParameter("path");
        this.fechaCreacion = Date.valueOf(req.getParameter("fecahCreacion"));
        this.comentable = Boolean.valueOf(req.getParameter("comentable"));
        this.likeable = Boolean.valueOf(req.getParameter("likeable"));
    
    }

    
    
    public int getRevista() {
        return revista;
    }
    public void setRevista(int revista) {
        this.revista = revista;
    }
    public void setRevista(String revista) {
        this.revista = Integer.valueOf(revista);
    }

    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombreEdicion() {
        return nombreEdicion;
    }
    public void setNombreEdicion(String nombreEdicion) {
        this.nombreEdicion = nombreEdicion;
    }

    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public boolean isComentable() {
        return comentable;
    }
    public void setComentable(boolean comentable) {
        this.comentable = comentable;
    }
    public void setComentable(String comentable) {
        this.comentable = comentable.equals("on");
    }

    public boolean isLikeable() {
        return likeable;
    }
    public void setLikeable(boolean likeable) {
        this.likeable = likeable;
    }
    public void setLikeable(String likeable) {
        this.likeable = likeable.equals("on");
    }

    @Override
    public String insert() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String columns() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String select(String[] fields) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String where(String[] fields) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String update(String[] fields) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String table() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String primaryKey() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
