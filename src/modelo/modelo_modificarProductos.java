/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * modelo de modificar productos
 * @see controlador.controlador_modificarProductos
 * @see vista.panel_visualizarProductos
 * @author Alejandro ena Encuentra
 */
public class modelo_modificarProductos {
    private conexionBD conexionBD;
    
    /**
     * recoge todos los articulos de la base de datos
     * @param conexionBD
     * @return
     * @throws SQLException 
     */
    public ResultSet cogerDatos(conexionBD conexionBD) throws SQLException{
        this.conexionBD = conexionBD;
        String sentenciaSQL = "SELECT * FROM articulos";
        ResultSet rs = this.conexionBD.ejecutaQuery(sentenciaSQL);
        return rs;
    }
    
    /**
     * modifica el nombre del articulo por el especificado
     * @param nombre
     * @param codigo
     * @throws SQLException 
     */
    public void guardarNombre(String nombre, int codigo) throws SQLException{
        String sentenciaSQL = "UPDATE articulos SET nombre='"+nombre+"' WHERE cod_articulo = "+codigo;
        conexionBD.ejecutaUpdate(sentenciaSQL);
    }
    
    /**
     * modifica la familia del articulo por la especificada
     * @param familia
     * @param codigo
     * @throws SQLException 
     */
    public void guardarFamilia(String familia, int codigo) throws SQLException{
        String sentenciaSQL = "UPDATE articulos SET familia='"+familia+"' WHERE cod_articulo = "+codigo;
        conexionBD.ejecutaUpdate(sentenciaSQL);
    }
    
    /**
     * modifica la cantidad del articulo por la especificada
     * @param cantidad
     * @param codigo
     * @throws SQLException 
     */
    public void guardarCantidad(int cantidad, int codigo) throws SQLException{
        String sentenciaSQL = "UPDATE articulos SET cantidad="+cantidad+" WHERE cod_articulo = "+codigo;
        conexionBD.ejecutaUpdate(sentenciaSQL);
    }
    
    /**
     * modifica el precio del articulo por el especificado
     * @param precio
     * @param codigo
     * @throws SQLException 
     */
    public void guardarPrecio(float precio, int codigo) throws SQLException{
        String sentenciaSQL = "UPDATE articulos SET precio="+precio+" WHERE cod_articulo = "+codigo;
        conexionBD.ejecutaUpdate(sentenciaSQL);
    }
    
}
