/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * modelo de importar archivo
 * @see controlador.controlador_gerente
 * @author Alejandro Ena Encuentra
 */
public class modelo_importarArchivo {
    
    
    File fichero;
    
    /**
     * lee los articulos almacenados en un fichero de texto
     * @return array de articulos
     */
    public Articulo[] leerFichero(){
        ArrayList<Articulo> articulos = new ArrayList();
        
        return (Articulo[]) articulos.toArray();
    }
    
    /**
     * añade los articulos del fichero a la base de datos
     * @param fichero
     * @param conexionBD
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public void añadirArticulo(File fichero, conexionBD conexionBD) throws ClassNotFoundException, SQLException{
        this.fichero = fichero;
        String sentenciaSQL;
        Articulo articulos[] = leerFichero();
        conexionBD.abrirConexion();
        for(int i=0;i<articulos.length;i++){
            sentenciaSQL = "INSERT INTO articulos (nombre, familia, cantidad, precio)"
                    + " VALUES('"+articulos[i].getNombre()+"', '"+articulos[i].getFamilia()+"', "+articulos[i].getCantidad()+", "+articulos[i].getPrecio()+");";
        }
        conexionBD.cerrarConexion();;
    }
}
