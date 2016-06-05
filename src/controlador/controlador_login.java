/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import alejandroena_proyecto_eval3.AlejandroEna_Proyecto_Eval3;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import modelo.conexionBD;
import modelo.modelo_login;
import vista.vista_login;

/**
 * controlador de login, da comportamiento a esta funcion
 * @see modelo.modelo_login
 * @see vista.vista_login
 * @author Alejandro Ena Encuentra
 */
public class controlador_login {
    private vista_login vistaLog;
    private modelo_login modelo;
    private conexionBD conexionBD;
    private AlejandroEna_Proyecto_Eval3 main;
    
    /**
     * constructor de la clase
     * @param vista
     * @param modelo
     * @param conexionBD 
     */
    public controlador_login(vista_login vista, modelo_login modelo, conexionBD conexionBD){
        this.vistaLog = vista;
        this.modelo = modelo;
        this.conexionBD = conexionBD;
        this.vistaLog.añadirListener(new CalcularListener());
    }
    
    /**
     * comportamiento de los botones
     */
    public class CalcularListener implements ActionListener{
        String usuario, contrasenia;
        
        @Override
        public void actionPerformed(ActionEvent e) {
            
            try {
                usuario = vistaLog.getTxtUsuario();
                contrasenia = vistaLog.getTxtContrasenia();
                
                conexionBD.abrirConexion();
                modelo.conectar(usuario, contrasenia, conexionBD);
                conexionBD.cerrarConexion();
                
                if(modelo.getConectar()){
                    vistaLog.borrarDatos();
                    vistaLog.setVisible(false);
                    main.iniciarUsuario(usuario);
                }
                else{
                    vistaLog.mostrarAlerta("Usuario o contraseña incorrectos");
                }
            } catch (SQLException | ClassNotFoundException ex) {
                vistaLog.mostrarAlerta("Ha ocurrido un error al intentar comunicarse con la base de datos");
            }
        }
    } 
}
