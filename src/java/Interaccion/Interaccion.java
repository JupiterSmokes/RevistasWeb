/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interaccion;

import DBManager.Insertable;
import DBManager.connectionManager;
import java.sql.Date;

/**
 *
 * @author DANIEL
 */
public class Interaccion implements Insertable{
    public interface Interactable{
        
    } 
    
    class Suscripcion implements Insertable, Interactable {
        private int cod;

        public Suscripcion(int cod) {
            this.cod = cod;
        }

        public int getCod() {
            return cod;
        }
        public void setCod(int cod) {
            this.cod = cod;
        }

        @Override
        public String insert() {
            return String.format("%d",this.cod);
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
    
    private int cod;
    private int revista;
    private int edicion;
    private String usuario;
    private Date fecha;
    
    @Override
    public String insert() {
    return String.format("%d,%d,'%s','%s'",
            this.revista, this.edicion, this.usuario, this.fecha);
    }

    @Override
    public String columns() {
           return "Revista, Edicion, Usuario, Fecha";
    }

    @Override
    public String select(String[] fields) {
        String select = "";
        for (String field : fields) {
            switch (field.toLowerCase()){
                case "cod": select += ", Cod";break;
                case "revista": select += ", Revista";break;
                case "edicion": select += ", Edicion";break;
                case "usuario": select += ", Usuario";break;
                case "fecha": select += ", Fecha";break;
                case "*": select = "*";break;
            }
        }
           if (select.charAt(0) == ',') select = select.replaceFirst(",", "");
        return select;
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

    public Interaccion() {
        
    }

    public Interaccion(int cod, int revista, int edicion, String usuario, Date fecha) {
        this.cod = cod;
        this.revista = revista;
        this.edicion = edicion;
        this.usuario = usuario;
        this.fecha = fecha;
    }
    
    public Interaccion(int revista, int edicion, String usuario, Date fecha) {
        this.revista = revista;
        this.edicion = edicion;
        this.usuario = usuario;
        this.fecha = fecha;
    }
    
    public void setTipo(int tipo){
        switch (tipo){
            case 1: connectionManager.insert(new Suscripcion(this.cod)); break;
            
        }
    }
    
    public int getCod() {
        return cod;
    }
    public void setCod(int cod) {
        this.cod = cod;
    }

    public int getRevista() {
        return revista;
    }
    public void setRevista(int revista) {
        this.revista = revista;
    }

    public int getEdicion() {
        return edicion;
    }
    public void setEdicion(int edicion) {
        this.edicion = edicion;
    }

    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    

}
