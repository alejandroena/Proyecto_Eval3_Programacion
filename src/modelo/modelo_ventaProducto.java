/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Alumno
 */
public class modelo_ventaProducto {
    
    boolean suficiente;
    boolean encontrado;
    String sentenciaVender ="";
    String sentenciaVentas ="";
    float precio;
    String nombre;
    
    public void añadir(int codigo, int cantidad, conexionBD conexionBD) throws SQLException{
        String sentenciaCantidad = "SELECT * FROM articulos WHERE cod_articulo="+codigo;
        ResultSet rs = conexionBD.ejecutaQuery(sentenciaCantidad);
        try {
            
            if(!rs.next()){
                encontrado = false;
            } else{
                
                int n = rs.getInt("cantidad");
                encontrado = true;  
                
                if(n>=cantidad){
                    suficiente = true;
                    int c = n-cantidad;
                    sentenciaVender = sentenciaVender.concat("UPDATE articulos SET cantidad="+c+" WHERE cod_articulo ="+codigo+";:");
                    
                    nombre = rs.getString("nombre");
                    
                    precio = rs.getFloat("precio");
                    precio = precio * cantidad;
                    sentenciaVentas = sentenciaVentas.concat("INSERT INTO ventas(cod_articulo, cantidad) "
                    + "VALUES("+codigo+", "+cantidad+");:");
                }
                else{
                    suficiente = false;
                }
                
            }
            
        } catch (SQLException ex) {
            throw ex;
        }
    }
    
    public void vender(conexionBD conexionBD) throws SQLException{
        try {
            
            String[] vender = sentenciaVender.split(":");
            for(int i=0;i<vender.length;i++){
                conexionBD.ejecutaUpdate(vender[i]);
            }
            
            String[] ventas = sentenciaVentas.split(":");
            for(int j=0;j<ventas.length;j++){
                conexionBD.ejecutaUpdate(ventas[j]);
            }
            
        } catch (SQLException ex) {
            throw ex;
        }
        
    }
    
    public void borrar(){
        sentenciaVender = "";
        sentenciaVentas = "";
        precio = 0;
        nombre = "";
    }
    
    public boolean getSuficiente(){
        return suficiente;
    }
    
    public boolean getEncontrado(){
        return encontrado;
    }
    
    public float getPrecio(){
        return precio;
    }
    
    public String getNombre(){
        return nombre;
    }
}
