/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.SQLException;

/**
 *
 * @author Alumno
 */
public class modelo_altaProducto {
    
    boolean completado;
    
    public void alta(String nombre, String familia, int Stock, float precio, conexionBD conexionBD) throws SQLException{
        String sentenciaSQL = "INSERT INTO articulos( nombre, familia, stock, cantidad) "
                + "VALUES('"+nombre+"', '"+familia+"', '"+Stock+"', '"+precio+"');";
        
        int n = conexionBD.ejecutaUpdate(sentenciaSQL);
        
        if(n!=1){
            completado = false;
        }
        else{
            completado = true;
        }
    }
    
    public boolean getCompletado(){
        return completado;
    }
}
