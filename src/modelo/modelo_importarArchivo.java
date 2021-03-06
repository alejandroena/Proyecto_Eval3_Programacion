/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * modelo de importar archivo
 * @see controlador.controlador_gerente
 * @author Alejandro Ena Encuentra
 */
public class modelo_importarArchivo {
    
    
    private File fichero;
    
    /**
     * lee los articulos almacenados en un fichero de texto
     * @return array de articulos
     * @throws java.io.FileNotFoundException
     */
    public ArrayList<Articulo> leerFichero() throws FileNotFoundException, IOException, NumberFormatException{
        ArrayList<Articulo> articulos = new ArrayList();
        String cadena;
        FileReader fr = new FileReader(fichero);
        BufferedReader br = new BufferedReader(fr);
        
        br.readLine();
        br.readLine();
        br.readLine();
        
        while((cadena=br.readLine())!=null){
            System.out.println(cadena);
            String[] datos = cadena.split(",");
            Articulo articulo = new Articulo();
            articulo.setCodigo(Integer.parseInt(datos[0]));
            articulo.setNombre(datos[1]);
            articulo.setFamilia(datos[2]);
            articulo.setCantidad(Integer.parseInt(datos[3]));
            articulo.setPrecio(Float.parseFloat(datos[4]));
            articulos.add(articulo);
            br.readLine();
        }
        br.close();
        return articulos;
    }
    
    /**
     * añade los articulos del fichero a la base de datos
     * @param fichero
     * @param conexionBD
     * @throws ClassNotFoundException
     * @throws SQLException 
     * @throws java.io.FileNotFoundException 
     */
    public void añadirArticulo(File fichero, conexionBD conexionBD) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException{
        this.fichero = fichero;
        String sentenciaSQL;
        ArrayList<Articulo> articulos = leerFichero();
        conexionBD.abrirConexion();
        for(int i=0;i<articulos.size();i++){
            sentenciaSQL = "INSERT INTO articulos (cod_articulo, nombre, familia, cantidad, precio)"
                    + " VALUES("+articulos.get(i).getCodigo()+", '"+articulos.get(i).getNombre()+"', '"
                    +articulos.get(i).getFamilia()+"', "+articulos.get(i).getCantidad()+", "+articulos.get(i).getPrecio()+");";
            conexionBD.ejecutaUpdate(sentenciaSQL);
        }
        conexionBD.cerrarConexion();
    }
}
