/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @args modelo creacion de usuarios
 * @see controlador.controlador_añadirUsuario
 * @see vista.vista_añadirUsuario
 * @author Alejandro Ena Encuentra
 */
public class modelo_añadirUsuario {
    
    private boolean completado;
    
    /**
     * añade un usuario a la base de datos
     * @param usuario
     * @param contrasenia
     * @param conexionBD
     * @throws SQLException 
     */
    public void añadir(String usuario, String contrasenia, conexionBD conexionBD) throws SQLException{
        String sentenciaSQL = "INSERT INTO usuarios(Usuario, Contraseña)"
                + "VALUES('"+usuario+"', '"+contrasenia+"');";
        
        int n = conexionBD.ejecutaUpdate(sentenciaSQL);
        
        if(n!=1){
            completado = false;
        }
        else{
            completado = true;
        }
    }
    
    /**
     * comprueba que el nombre de usuario no sea un numero
     * @param usuario
     * @return 
     */
    public boolean comprobarUsuario(String usuario){
        try{
            int n = Integer.parseInt(usuario);
            n = n/2;
            return false;
        } catch(NumberFormatException ex){
            return true;
        }
    }
    
    /**
     * comprueba si la contraseña cumple con los requisitos
     * @param contrasenia
     * @return 
     */
    public boolean comprobarContrasenia(String contrasenia){
        
        String patern = "^[A-Z]+[a-z]{2}[\\w]*[\\d]{2,}[$]$";
        
        Pattern pat = Pattern.compile(patern);
        Matcher mat = pat.matcher(contrasenia);
            
        if(mat.matches() && contrasenia.length()>7){
            return true;
        }
        else{
            return false;
        }
    }
}
