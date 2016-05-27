/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alejandroena_proyecto_eval3;

import controlador.controlador_bajaProducto;
import javax.swing.JFrame;
import modelo.conexionBD;
import modelo.modelo_bajaProducto;
import vista.panel_bajaProductos;
import vista.vista_comercial;
import vista.vista_gerente;
import vista.vista_login;

/**
 *
 * @author Alumno
 */
public class AlejandroEna_Proyecto_Eval3 {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        //conexionBD conexionBD = new conexionBD("programacioneval3", "user", "1234", "jdbc:mysql://localhost/");
        //modelo_login mLogin = new modelo_login();
        //vista_login vLogin = new vista_login();
        //controlador_login cLogin = new controlador_login(vLogin, mLogin, conexionBD);
        //vLogin.setVisible(true);
        
        
    }
    
    public static void iniciarUsuario(String usuario){
        //conexionBD conexionBD = new conexionBD();
        //(modelo no)modelo_usuario mUsuario = new modelo_usuario
        
        if(usuario.equals("Gerente")){
            vista_gerente vGerente = new vista_gerente();
            //controlador_gerente cGerente = new controlador_gerente(vGerente, mUsuario, conexionBD);
            vGerente.setVisible(true);
        }else{
            vista_comercial vComercial = new vista_comercial();
            //controlador_comercial cComercial = new controlador_comercial(vComercial, mUsuario, conexionBD)
            vComercial.setVisible(true);
        }
    }
    
    public static void cerrarSesion(){
        //conexionbd
        //modelo con conexionbd
        //
        vista_login login = new vista_login();
        //controlador
        login.setVisible(true);
    }
    
}
