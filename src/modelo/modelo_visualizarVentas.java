/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * modelo de visulizar ventas
 * @see controlador.controlador_visualizarVentas
 * @see vista.panel_visualizarVentas
 * @author Alejandro Ena Encuentra
 */
public class modelo_visualizarVentas {
    
    /**
     * devuelve los datos de las ventas
     * @param codigo
     * @param familia
     * @param fechaInicio
     * @param fechaFinal
     * @param conexionBD
     * @return el ResultSet con los datos
     * @throws SQLException 
     */
    public ResultSet cogerDatos(int codigo, String familia, String fechaInicio, String fechaFinal, conexionBD conexionBD) throws SQLException{
        String sentenciaSQL = "SELECT a.cod_articulo, a.nombre, a.familia, v.cantidad, (a.precio*v.cantidad), v.fecha_venta FROM ventas v, articulos a "
                + "WHERE a.cod_articulo = v.cod_articulo and CAST(fecha_venta as date)>='"+fechaInicio+"' and CAST(fecha_venta as date)<='"+fechaFinal+"'";
        ResultSet rs= null;
        
        if(codigo!=0){
            sentenciaSQL = sentenciaSQL.concat(" AND v.cod_articulo = "+codigo);
        }
        else if(familia.equals("")==false){
            sentenciaSQL = sentenciaSQL.concat(" AND a.familia = '"+familia+"'");
        }
        
        rs = conexionBD.ejecutaQuery(sentenciaSQL+";");
        
        return rs;
    }
}
