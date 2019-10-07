/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones;

import DBManager.Insertable;
import DBManager.connectionManager;
import Interaccion.Interaccion;
import Revista.Revista;
import java.sql.Date;
import java.sql.ResultSet;

/**
 *
 * @author DANIEL
 */
public class Funciones {
    public static String nuevaInteraccion(int rev, int ed, String usr,Date fecha, int tipo){
        Interaccion nueva = new Interaccion(rev, tipo, usr, fecha);
        connectionManager.insert(nueva);
        nueva.setTipo(tipo);
        return "Correcto";
    }
    
    public static Insertable recuperar(ResultSet select, String table){
        Insertable buscado = null;
        
        try {
            if (select.first()) {
                switch (table.toLowerCase()){
                    case "revista":
                        buscado = new Revista(
                                select.getInt("id"),
                                select.getString("nombre"),
                                select.getString("editor"),
                                select.getString("categoria"),
                                select.getString("descripcion"),
                                select.getDouble("suscripcionMes"),
                                select.getDouble("costoDia")
                        );

                }
             }
        } catch (Exception e) {
        }
        return buscado;
    }
    
}
