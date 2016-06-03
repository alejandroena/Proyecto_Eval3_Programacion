/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.SQLException;

/**
 * modelo de baja de productos
 * @see controlador.controlador_bajaProducto
 * @see vista.panel_bajaProductos
 * @author Alejandro ena Encuentra
 */
public class modelo_bajaProducto {
    private boolean completado;
    
    /**
     * da de baja un producto en la base de datos
     * @param codigo
     * @param nombre
     * @param conexionBD
     * @throws SQLException 
     */
    public void baja(int codigo, String nombre, conexionBD conexionBD) throws SQLException{
        String sentenciaSQL;
        int n = 0;
        if(codigo != 0){
            sentenciaSQL = "DELETE FROM articulos WHERE cod_articulo = '"+codigo+"';";
            n = conexionBD.ejecutaUpdate(sentenciaSQL);
        }else if(nombre.equals("")==false){
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
    
    /**
     * devuelve un boolean para saber si se ha dado de baja el producto o no
     * @return boolean
     */
    public boolean getCompletado(){
        return completado;
    }
}
