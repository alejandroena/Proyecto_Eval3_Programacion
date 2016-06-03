/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * modelo de visualizar productos
 * @see controlador.controlador_visualizarProductos
 * @see vista.panel_visualizarProductos
 * @author Alejandro Ena Encuentra
 */
public class modelo_visualizarProductos {
    
    /**
     * recoge los articulos de la base de datos
     * @param codigo
     * @param familia
     * @param ordenar
     * @param conexionBD
     * @return los articulos encontrados
     * @throws SQLException 
     */
    public ResultSet cogerDatos(int codigo, String familia, boolean ordenar, conexionBD conexionBD) throws SQLException{
        String sentenciaSQL = "SELECT * FROM articulos";
        ResultSet rs= null;
        
        if(codigo!=0){
            sentenciaSQL = sentenciaSQL.concat(" WHERE cod_articulo = "+codigo);
        }
        else if(familia!=null){
            sentenciaSQL = sentenciaSQL.concat(" WHERE familia = '"+familia+"'");
        }
        
        if(ordenar){
            sentenciaSQL = sentenciaSQL.concat(" ORDER BY cantidad DESC");
        }
        
        rs = conexionBD.ejecutaQuery(sentenciaSQL+";");
        
        return rs;
    }
    
    /**
     * coge los distintos tipos de familia de los productos
     * @param conexionBD
     * @return
     * @throws SQLException 
     */
    public ResultSet cogerFamilia(conexionBD conexionBD) throws SQLException{
        String sentenciaSQL ="SELECT distinct(familia) FROM articulos";
        ResultSet rs = conexionBD.ejecutaQuery(sentenciaSQL);

        return rs;
    }
}
