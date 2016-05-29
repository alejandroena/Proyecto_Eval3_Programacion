/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import modelo.conexionBD;
import modelo.modelo_añadirUsuario;
import vista.vista_añadirUsuario;

/**
 *
 * @author Alejandro
 */
public class controlador_añadirUsuario {
    private vista_añadirUsuario vista;
    private modelo_añadirUsuario modelo;
    private conexionBD conexionBD;
    
    public controlador_añadirUsuario(vista_añadirUsuario vista, modelo_añadirUsuario modelo, conexionBD conexionBD){
        this.vista = vista;
        this.modelo = modelo;
        this.conexionBD = conexionBD;
        this.vista.ListenerBoton(new ComportamientoBoton());
    }
    
    public class ComportamientoBoton implements ActionListener{
        String usuario, contra1, contra2;
        
        @Override
        public void actionPerformed(ActionEvent e) {
            Object obj = e.getSource();
            
            if(obj.equals(vista.getBtnAceptar())){
                usuario = vista.getTxtNombre();
                contra1 = vista.getTxtContraseña();
                contra2 = vista.getTxtReContraseña();
                
                if(usuario.length()<4){
                    vista.setLabelError("El usuario debe contener al menos 4 caracteres");
                }
                else if(modelo.comprobarUsuario(usuario)==false){
                    vista.setLabelError("El usuario no puede ser un numero");
                }
                else{
                    if(contra1.equals(contra2)==false){
                        vista.setLabelError("Las contraseñas no coinciden");
                    }
                    else if(modelo.comprobarContraseña(contra1)==false){
                        vista.setLabelError("La contraseña no cumple los requisitos");
                    }
                    else{
                        try {
                            conexionBD.abrirConexion();
                            modelo.añadir(usuario, contra1, conexionBD);
                            vista.borrarDatos();
                            vista.setVisible(false);
                            conexionBD.cerrarConexion();
                        } catch (SQLException | ClassNotFoundException ex) {
                            vista.mostrarError("No se ha podido contactar con la base de datos");
                        }
                    }
                }
            }
            else if(obj.equals(vista.getBtnCancelar())){
                vista.borrarDatos();
                vista.setVisible(false);
            }
        }
    }
}
