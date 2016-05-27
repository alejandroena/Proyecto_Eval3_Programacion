/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alumno
 */
public class modelo_ventaProducto {
    
    boolean suficiente;
    String sentenciaVender;
    String sentenciaVentas;
    float precio;
    String nombre;
    
    public void añadir(int codigo, int cantidad, conexionBD conexionBD) throws SQLException{
        String sentenciaCantidad = "SELECT stock FROM articulos WHERE codigo = "+codigo+";";
        ResultSet rs = null;
        try {
            int n = rs.getInt(sentenciaCantidad);
       
            if(n>=cantidad){
                suficiente = true;
                sentenciaVender = sentenciaVender.concat("UPDATE articulos SET stock="+(n-cantidad)+"WHERE codigo ="+codigo+";");
                nombre = rs.getString("SELECT nombre FROM articulos WHERE codigo ="+codigo+";");
                precio = rs.getFloat("SELECT precio FROM articulos WHERE codigo ="+codigo+";");
                precio = precio * cantidad;
                sentenciaVentas = sentenciaVentas.concat("INSERT INTO ventas( codigo, nombre, precio, cantidad, fecha) "
                + "VALUES('"+codigo+"', '"+nombre+"', '"+precio+"', '"+cantidad+"', SYSDATE);");
            }
            else{
                suficiente = false;
            }
        } catch (SQLException ex) {
            throw ex;
        }
    }
    
    public void vender(conexionBD conexionBD) throws SQLException{
        try {
            conexionBD.ejecutaUpdate(sentenciaVender);
            conexionBD.ejecutaUpdate(sentenciaVentas);
        } catch (SQLException ex) {
            throw ex;
        }
        
    }
    
    public boolean getSuficiente(){
        return suficiente;
    }
    
    public float getPrecio(){
        return precio;
    }
    
    public String getNombre(){
        return nombre;
    }
}
