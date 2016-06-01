/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alejandroena_proyecto_eval3;

import controlador.controlador_comercial;
import controlador.controlador_gerente;
import controlador.controlador_login;
import modelo.conexionBD;;
import modelo.modelo_login;
import vista.vista_comercial;
import vista.vista_gerente;
import vista.vista_login;

/**
 * @author Alejandro Ena Encuentra
 */
public class AlejandroEna_Proyecto_Eval3 {

    /**
     * @param args inicia el login del programa
     */
    
    static conexionBD conexionBD;
    static modelo_login mLogin;
    static vista_login vLogin;
    static controlador_login cLogin;
    
    public static void main(String[] args) {
        
        conexionBD = new conexionBD("programacioneval3", "user", "1234", "jdbc:mysql://localhost/");
        mLogin = new modelo_login();
        vLogin = new vista_login();
        cLogin = new controlador_login(vLogin, mLogin, conexionBD);
        vLogin.setVisible(true);
        
    }
    
    /**
     * @args inicia la vista del usuario
     * @param usuario conectado
     */
    public static void iniciarUsuario(String usuario){
        
        if(usuario.equals("Gerente")){
            vista_gerente vGerente = new vista_gerente();
            controlador_gerente cGerente = new controlador_gerente(vGerente, conexionBD);
            vGerente.setVisible(true);
        }else{
            vista_comercial vComercial = new vista_comercial();
            controlador_comercial cComercial = new controlador_comercial(vComercial, conexionBD);
            vComercial.setVisible(true);
        }
    }
    
    /**
     * @args muestra el login
     */
    public static void cerrarSesion(){
        vLogin.setVisible(true);
    }
    
}
