/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * modelo de venta producto
 * @see controlador.controlador_ventaProducto
 * @see vista.panel_ventaProducto
 * @author Alejandro Ena Encuentra
 */
public class modelo_ventaProducto {
    
    private boolean suficiente;
    private boolean encontrado;
    private String sentenciaVender ="";
    private String sentenciaVentas ="";
    private float precio;
    private String nombre;
    
    /**
     * comprueba si existe el producto en la base de datos y lo añade a la lista
     * @param codigo
     * @param cantidad
     * @param conexionBD
     * @throws SQLException 
     */
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
    
    /**
     * vende todos los productos especificados en la lista y lo guarda en la tabla ventas
     * @param conexionBD
     * @throws SQLException 
     */
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
    
    /**
     * reestablece las sentencias sql
     */
    public void borrar(){
        sentenciaVender = "";
        sentenciaVentas = "";
        precio = 0;
        nombre = "";
    }
    
    /**
     * devuelve boolean para saber si hay sufuciente cantidad de ese articulo o no
     * @return boolean
     */
    public boolean getSuficiente(){
        return suficiente;
    }
    
    /**
     * devuelve boolean para saber si existe el producto o no
     * @return boolean
     */
    public boolean getEncontrado(){
        return encontrado;
    }
    
    /**
     * @return el precio del articulo
     */
    public float getPrecio(){
        return precio;
    }
    
    /**
     * @return el nombre del articulo
     */
    public String getNombre(){
        return nombre;
    }
}
