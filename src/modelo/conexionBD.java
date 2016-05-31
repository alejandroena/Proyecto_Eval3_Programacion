/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * conexion del programa con la base de datos
 * @author Alejandro Ena Encuentra
 */
public class conexionBD {
    String bd;
    String usuario;
    String contraseña;
    String servidor;
    
    Connection conexion;
    
    /**
     * constructor de la clase
     * @param bd nombre de la base de datos
     * @param usuario de la base de datos
     * @param contraseña de la base de datos
     * @param servidor de la base de datos
     */
    public conexionBD(String bd, String usuario, String contraseña, String servidor){
        this.bd = bd;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.servidor = servidor;
    }
    
    /**
     * establace conexion con la base de datos
     * @return el estado de la conexion
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public boolean abrirConexion() throws ClassNotFoundException, SQLException{
        boolean estado = false;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(servidor + bd, usuario, contraseña);
            estado = true;
        }
        catch(ClassNotFoundException | SQLException ex){
            throw ex;
        }
        return estado;
    }
    
    /**
     * cierra la conexion con la base de datos
     * @throws SQLException 
     */
    public void cerrarConexion() throws SQLException{
        try {
            conexion.close();
        } catch (SQLException ex) {
            throw ex;
        }
    }
    
    /**
     * modifica los registros de la base de datos segun la sentencia sql
     * @param sentenciaSQL sentencia sql
     * @return el numero de filas modificadas
     * @throws SQLException 
     */
    public int ejecutaUpdate(String sentenciaSQL) throws SQLException{
        int n = 0;
        try{
            Statement st = conexion.createStatement();
            n = st.executeUpdate(sentenciaSQL);
        } catch(SQLException ex){
            throw ex;
        }
        return n;
    }
    
    /**
     * coge los registros de la base de datos especificados en la sentencia sql
     * @param SentenciaSQL sentencia sql
     * @return el ResultSet con los datos
     * @throws SQLException 
     */
    public ResultSet ejecutaQuery(String SentenciaSQL) throws SQLException{
        ResultSet rs = null;
        try{
            Statement st = conexion.createStatement();
            rs = st.executeQuery(SentenciaSQL);
        } catch(SQLException ex){
            throw ex;
        }
        return rs;
    }
}
