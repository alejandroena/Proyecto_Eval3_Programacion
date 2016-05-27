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
 *
 * @author Alumno
 */
public class conexionBD {
    String bd;
    String usuario;
    String contraseña;
    String servidor;
    
    Connection conexion;
    
    public conexionBD(String bd, String usuario, String contraseña, String servidor){
        this.bd = bd;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.servidor = servidor;
    }
    
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
    
    public void cerrarConexion() throws SQLException{
        try {
            conexion.close();
        } catch (SQLException ex) {
            throw ex;
        }
    }
    
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
