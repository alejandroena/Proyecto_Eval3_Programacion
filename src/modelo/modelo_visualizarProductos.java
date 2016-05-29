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
public class modelo_visualizarProductos {
    
    
    public ResultSet cogerDatos(int codigo, String familia, boolean ordenar, conexionBD conexionBD) throws SQLException{
        String sentenciaSQL = "SELECT * FROM articulos";
        ResultSet rs= null;
        
        if(codigo!=0){
            sentenciaSQL = sentenciaSQL.concat(" WHERE cod_articulo = "+codigo);
        }
        else if(familia.equals("")==false){
            sentenciaSQL = sentenciaSQL.concat(" WHERE familia = '"+familia+"'");
        }
        
        if(ordenar){
            sentenciaSQL = sentenciaSQL.concat(" ORDER BY cantidad DESC");
        }
        
        rs = conexionBD.ejecutaQuery(sentenciaSQL+";");
        
        return rs;
    }
}
