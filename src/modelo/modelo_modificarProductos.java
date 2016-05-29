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
 * @author Alejandro
 */
public class modelo_modificarProductos {
    conexionBD conexionBD;
    public ResultSet cogerDatos(conexionBD conexionBD) throws SQLException{
        this.conexionBD = conexionBD;
        String sentenciaSQL = "SELECT * FROM articulos";
        ResultSet rs = conexionBD.ejecutaQuery(sentenciaSQL);
        return rs;
    }
    
    public void guardarNombre(String nombre, int codigo) throws SQLException{
        String sentenciaSQL = "UPDATE articulos SET nombre='"+nombre+"' WHERE cod_articulo = "+codigo;
        ResultSet rs = conexionBD.ejecutaQuery(sentenciaSQL);
    }
    public void guardarFamilia(String familia, int codigo) throws SQLException{
        String sentenciaSQL = "UPDATE articulos SET familia='"+familia+"' WHERE cod_articulo = "+codigo;
        ResultSet rs = conexionBD.ejecutaQuery(sentenciaSQL);
    }
    public void guardarCantidad(int cantidad, int codigo) throws SQLException{
        String sentenciaSQL = "UPDATE articulos SET cantidad="+cantidad+" WHERE cod_articulo = "+codigo;
        ResultSet rs = conexionBD.ejecutaQuery(sentenciaSQL);
    }
    public void guardarPrecio(float precio, int codigo) throws SQLException{
        String sentenciaSQL = "UPDATE articulos SET precio="+precio+" WHERE cod_articulo = "+codigo;
        ResultSet rs = conexionBD.ejecutaQuery(sentenciaSQL);
    }
}
