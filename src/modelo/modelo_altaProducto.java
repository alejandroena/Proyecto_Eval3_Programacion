/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.SQLException;

/**
 * modelo de alta productos
 * @see controlador.controlador_altaProducto
 * @see vista.panel_altaProductos
 * @author Alejandro Ena Encuentra
 */
public class modelo_altaProducto {
    
    boolean completado;
    
    /**
     * da de alta el producto en la base de datos con los atributos especificados
     * @param nombre
     * @param familia
     * @param cantidad
     * @param precio
     * @param conexionBD
     * @throws SQLException 
     */
    public void alta(String nombre, String familia, int cantidad, float precio, conexionBD conexionBD) throws SQLException{
        String sentenciaSQL = "INSERT INTO articulos( nombre, familia, cantidad, precio) "
                + "VALUES('"+nombre+"', '"+familia+"', '"+cantidad+"', '"+precio+"');";
        
        int n = conexionBD.ejecutaUpdate(sentenciaSQL);
        
        if(n!=1){
            completado = false;
        }
        else{
            completado = true;
        }
    }

    /**
     * devuelve un boolean para saber si se ha dado de alta el producto o no
     * @return boolean
     */
    public boolean getCompletado(){
        return completado;
    }
}
