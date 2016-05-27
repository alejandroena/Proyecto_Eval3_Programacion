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
import modelo.modelo_bajaProducto;
import vista.panel_bajaProductos;

/**
 *
 * @author Alumno
 */
public class controlador_bajaProducto {
    private panel_bajaProductos vista;
    private modelo_bajaProducto modelo;
    private conexionBD conexionBD;
    
    public controlador_bajaProducto(panel_bajaProductos vista, modelo_bajaProducto modelo, conexionBD conexionBD){
        this.vista = vista;
        this.modelo = modelo;
        this.conexionBD = conexionBD;
        this.vista.ListenerBoton(new calcularListenerBoton());
        this.vista.ListenerRadio(new calcularListenerRadio());
    }
    public class calcularListenerBoton implements ActionListener{
        int codigo;
        String nombre;
        
        @Override
        public void actionPerformed(ActionEvent e) {
            
            try {
                codigo = vista.getTxtCodigo();
                nombre = vista.getTxtNombre();
                
                conexionBD.abrirConexion();
                modelo.baja(codigo, nombre, conexionBD);
                conexionBD.cerrarConexion();
                
                if(modelo.getCompletado() == false){
                    vista.mostrarAlerta("no se ha podido dar de baja el producto");
                }
            } catch (ClassNotFoundException | SQLException ex) {
                vista.mostrarAlerta("Ha ocurrido un error al intentar dar de baja el producto");
            }
        }
    }
    
    public class calcularListenerRadio implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Object obj = e.getSource();
            if(obj.equals(vista.getRadioCodigo())){
                vista.enableTxtCodigo(true);
                vista.enableTxtNombre(false);
            }
            else if(obj.equals(vista.getRadioNombre())){
                vista.enableTxtCodigo(false);
                vista.enableTxtNombre(true);
            }
        }
        
    }
}
