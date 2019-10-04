/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Revista;

import DBManager.Insertable;
import java.io.Serializable;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author DANIEL
 */
public class Revista implements Insertable, Serializable{
    
    private int id;
    private String nombre;
    private String editor;
    private String categoria;
    private String descripcion;
    private double suscripcionMes;
    private double costoDiario;

    public Revista(HttpServletRequest req) {
 //       System.out.println(req.getParameter("nombre"));
        this.nombre = req.getParameter("nombre");
        this.categoria = req.getParameter("categoria");
        this.editor = "test";
        this.descripcion = req.getParameter("descripcion");
        this.suscripcionMes = Double.parseDouble(req.getParameter("suscripcionMes"));
    }

    public Revista() {
    }
    
    

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEditor() {
        return editor;
    }
    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getSuscripcionMes() {
        return suscripcionMes;
    }
    public void setSuscripcionMes(double suscripcionMes) {
        this.suscripcionMes = suscripcionMes;
    }

    public double getCostoDiario() {
        return costoDiario;
    }
    public void setCostoDiario(double costoDiario) {
        this.costoDiario = costoDiario;
    }

    public String insert() {
        return String.format("'%s','%s','%s','%s',%f",
                this.nombre, this.editor,this.categoria, this.descripcion,this.suscripcionMes);
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
        return String.valueOf(this.id);
    }

    @Override
    public String columns() {
        return "Nombre, Editor, Categoria, Descripcion, SuscripcionMes";
    }
    
}
