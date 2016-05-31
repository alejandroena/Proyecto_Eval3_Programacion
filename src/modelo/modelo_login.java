/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * modelo del login
 * @see controlador.controlador_login
 * @see vista.vista_login
 * @author Alejandro Ena Encuentra
 */
public class modelo_login {
    private boolean conectar;
    
    /**
     * busca en la base de datos un usuario con estos datos
     * @param usuario
     * @param contraseña
     * @param conexionBD
     * @throws SQLException 
     */
    public void conectar(String usuario, String contraseña, conexionBD conexionBD) throws SQLException{
        String sentenciaSQL ="SELECT * FROM usuarios WHERE usuario ='"+usuario+"' AND contraseña ='"+contraseña+"';";
        ResultSet rs = conexionBD.ejecutaQuery(sentenciaSQL);
        rs.last();
        
        if(rs.getRow()<1){
            conectar = false;
        }else{
            conectar = true;
        }
    }
    
    /**
     * devuelve boolean para saber si ha encontrado un usuario o no
     * @return boolean
     */
    public boolean getConectar(){
        return conectar;
    }
}
