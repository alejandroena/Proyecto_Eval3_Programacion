/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Alejandro
 */
public class modelo_login {
    private boolean conectar;

    public void conectar(String usuario, String contraseña, conexionBD conexionBD) throws SQLException{
        String consulta ="SELECT * FROM users WHERE usuario ="+usuario+" AND contraseña ="+contraseña;
        ResultSet rs = null;
        
        Statement st = conexionBD.conexion.createStatement();
        rs = st.executeQuery(consulta);
        rs.last();
        
        if(rs.getRow()<1){
            conectar = false;
        }else{
            conectar = true;
        }
    }
    
    public boolean getConectar(){
        return conectar;
    }
}
