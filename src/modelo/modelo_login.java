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
public class modelo_login {
    private boolean conectar;

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
   
    public boolean getConectar(){
        return conectar;
    }
}
