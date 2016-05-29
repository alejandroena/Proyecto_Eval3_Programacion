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
import modelo.modelo_altaProducto;
import vista.panel_altaProductos;

/**
 *
 * @author Alejandro Ena Encuentra
 */
public class controlador_altaProducto {
    private panel_altaProductos vista;
    private modelo_altaProducto modelo;
    private conexionBD conexionBD;
    
    public controlador_altaProducto(panel_altaProductos vista, modelo_altaProducto modelo, conexionBD conexionBD){
        this.vista = vista;
        this.modelo = modelo;
        this.conexionBD = conexionBD;
        this.vista.ListenerBoton(new CalcularListener());
    }
    public class CalcularListener implements ActionListener{
        String nombre, familia;
        int stock;
        float precio;
        
        @Override
        public void actionPerformed(ActionEvent e) {
            Object obj = e.getSource();
            
            if(obj.equals(vista.getBtnAñadir())){
                try {
                    nombre = vista.getTxtNombre();
                    familia = vista.getTxtFamilia();
                    stock = vista.getTxtStock();
                    precio = vista.getTxtPrecio();
                    
                    if(nombre.equals("") | familia.equals("") | stock==0 | precio==0){
                        vista.mostrarAlerta("Faltan campos por rellenar");
                    }else{
                    
                        conexionBD.abrirConexion();
                        modelo.alta(nombre, familia, stock, precio, conexionBD);
                        vista.borrarDatos();
                        conexionBD.cerrarConexion();
                
                        if(modelo.getCompletado() == false){
                            vista.mostrarAlerta("no se ha podido dar de alta el producto");
                        }
                    }
                } catch (ClassNotFoundException | SQLException ex) {
                    vista.mostrarAlerta("Ha ocurrido un error al intentar dar de alta el producto");
                } catch (NumberFormatException ex){
                    vista.mostrarAlerta("La cantidad y el precio deben ser numeros");
                }
            }
            else if(obj.equals(vista.getBtnCancelar())){
                vista.borrarDatos();
            }
        }
    }
}
