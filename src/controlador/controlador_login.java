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
import vista.vista_comercial;
import vista.vista_gerente;
import vista.vista_login;

/**
 *
 * @author Alejandro
 */
public class controlador_login {
    private vista_login vistaLog;
    private modelo_login modelo;
    private conexionBD conexionBD;
    private vista_gerente vistaGen;
    private vista_comercial vistaCom;
    
    public controlador_login(vista_login vista, modelo_login modelo, conexionBD conexionBD, vista_gerente vistaGen, vista_comercial vistaCom){
        this.vistaLog = vista;
        this.modelo = modelo;
        this.conexionBD = conexionBD;
        this.vistaLog.añadirListener(new CalcularListener());
    }
    public class CalcularListener implements ActionListener{
        String usuario, contraseña;
        
        @Override
        public void actionPerformed(ActionEvent e) {
            
            try {
                usuario = vistaLog.getTxtUsuario();
                contraseña = vistaLog.getTxtContraseña();
                
                conexionBD.abrirConexion();
                modelo.conectar(usuario, contraseña, conexionBD);
                conexionBD.cerrarConexion();
                
                if(modelo.getConectar()){
                    vistaLog.setVisible(false);
                    AlejandroEna_Proyecto_Eval3.iniciarUsuario(usuario);
                }
                else{
                    vistaLog.mostrarAlerta("Usuario o contraseña incorrectos");
                }
            } catch (SQLException ex) {
                vistaLog.mostrarAlerta("Ha ocurrido un error al intentar comunicarse con la base de datos");
            } catch (ClassNotFoundException ex) {
                vistaLog.mostrarAlerta("Ha ocurrido un error al intentar comunicarse con la base de datos");
            }
        }
    } 
}
