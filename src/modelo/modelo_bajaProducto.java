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
public class modelo_bajaProducto {
    boolean completado;
    
    public void baja(int codigo, String nombre, conexionBD conexionBD) throws SQLException{
        String sentenciaSQL;
        int n = 0;
        if(codigo != 0){
            sentenciaSQL = "DELETE FROM articulos WHERE codigo = '"+codigo+"';";
            n = conexionBD.ejecutaUpdate(sentenciaSQL);
        }else if(nombre!=null){
            sentenciaSQL = "DELETE FROM articulos WHERE nombre = '"+nombre+"';";
            n = conexionBD.ejecutaUpdate(sentenciaSQL);
        }

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
