/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBManager;

/**
 *
 * @author DANIEL
 */
public interface Insertable {
    
    public  String insert();
    public String columns();
    public String select(String[] fields);
    public String where(String[] fields);
    public String update(String[] fields);
    public String table();
    public String primaryKey();
}
