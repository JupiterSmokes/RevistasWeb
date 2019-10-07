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
    private int comentable;
    private int likeable;

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
        try {
            ResultSet n = connectionManager.query("SELECT IFNULL(MAX(NUMERO),0) FROM Edicion");
            n.first();
            this.numero = n.getInt(1)+1;
        } catch (SQLException ex) {
            Logger.getLogger(Edicion.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connectionManager.close();
        }
        this.nombreEdicion = req.getParameter("nombreEdicion");
        this.fechaCreacion = Date.valueOf(req.getParameter("fechaCreacion"));
        this.setComentable(req.getParameter("comentable"));
        this.setLikeable(req.getParameter("likeable"));
    
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
        this.path = path.replace("\\","\\\\");
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    public void setFechaCreacion(String fecha) {
        this.fechaCreacion = Date.valueOf(fecha);
    }

    public int isComentable() {
        return comentable;
    }
    public void setComentable(int comentable) {
        this.comentable = comentable;
    }
    public void setComentable(String comentable) {
        if(!(comentable == null) && comentable.equals("on")) {
            this.comentable = 1;
        } else {
            this.comentable = 0;
        }
    }

    public int isLikeable() {
        return likeable;
    }
    public void setLikeable(int likeable) {
        this.likeable = likeable;
    }
    public void setLikeable(String likeable) {
        if(!(likeable == null) && likeable.equals("on")){ 
            this.likeable = 1;
        } else {
            this.likeable = 0;
        }
    }

    @Override
    public String insert() {
           return String.format("%d,%d,'%s','%s','%s',%d,%d",
                this.revista, this.numero,this.nombreEdicion, this.path, this.fechaCreacion,this.comentable, this.likeable);
    }

    @Override
    public String columns() {
        return "";
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
        return this.getClass().getSimpleName();
    }

    @Override
    public String primaryKey() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
