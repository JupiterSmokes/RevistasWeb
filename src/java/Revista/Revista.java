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

    public Revista(int id, String nombre, String editor, String categoria, String descripcion, double suscripcionMes, double costoDiario) {
        this.id = id;
        this.nombre = nombre;
        this.editor = editor;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.suscripcionMes = suscripcionMes;
        this.costoDiario = costoDiario;
    }

    public Revista(String nombre) {
        this.nombre = nombre;
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
    String select = "";
        for (String field : fields) {
            switch (field.toLowerCase()){
                case "id": select += ", Id"; break;
                case "nombre": select += ", Nombre"; break;
                case "editor": select += ", Editor"; break;
                case "categoria": select += ", Categoria"; break;
                case "descripcion": select += ", Descripcion"; break;
                case "suscripcion": select += ", SuscripcionMes"; break;
                case "costo": select += ", Costo"; break;
                default: select = "*"; break;
            }
        }
        if (select.charAt(0) == ',') select = select.replaceFirst(",", "");
    return select;
    }
    public String select(String fields){
        return select(fields.split(","));
    }
    
    @Override
    public String where(String[] fields) {
    String condition = "";
        for (String field : fields) {
            switch (field.toLowerCase()){
                case "id": condition += " AND Id=" + this.id;
                break;
                case "nombre": condition += " AND Nombre='" + this.nombre +"'";
                break;
                case "editor": condition += " AND Editor='" + this.editor + "'";
                break;
                case "categoria": condition += " AND Categoria='" + this.categoria + "'";
                break;
                case "descripcion": condition += " AND Descripcion='" + this.descripcion + "'";
                break;
                case "suscripcion": condition += " AND SuscripcionMes=" + this.suscripcionMes;
                break;
                case "costo": condition += " AND Costo=" + this.costoDiario;
                break;
            }
        }
        condition=condition.replaceFirst("AND", "");
    return condition;
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
