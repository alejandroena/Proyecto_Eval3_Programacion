/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.conexionBD;
import modelo.modelo_ventaProducto;
import vista.panel_ventaProducto;

/**
 *
 * @author Alumno
 */
public class controlador_ventaProducto {
    private panel_ventaProducto vista;
    private modelo_ventaProducto modelo;
    private conexionBD conexionBD;
    
    public controlador_ventaProducto(panel_ventaProducto vista, modelo_ventaProducto modelo, conexionBD conexionBD){
        this.vista = vista;
        this.modelo = modelo;
        this.conexionBD = conexionBD;
        this.vista.ListenerBoton(new CalcularListener());
    }
    
    public class CalcularListener implements ActionListener{
        int codigo, cantidad;
        
        @Override
        public void actionPerformed(ActionEvent e) {
            Object obj = e.getSource();
            
            if(obj.equals(vista.getBtnAñadir())){
                try {
                    codigo = vista.getTxtCodigo();
                    cantidad = vista.getTxtCantidad();
                
                    conexionBD.abrirConexion();
                    modelo.añadir(codigo, cantidad, conexionBD);
                    conexionBD.cerrarConexion();
                
                    if(modelo.getSuficiente()){
                        vista.setInformacion(codigo+" "+modelo.getNombre()+" x"+cantidad+"\t"+modelo.getPrecio()+"€");
                    }
                    else{
                        vista.mostrarAlerta("Cantidad del articulo insuficiente");
                    }
                } catch (ClassNotFoundException | SQLException ex) {
                    vista.mostrarAlerta("Error al encontrar el articulo");
                }
            }
            else if(obj.equals(vista.getBtnVender())){
                try {
                    modelo.vender(conexionBD);
                } catch (SQLException ex) {
                    vista.mostrarAlerta("Error al procesar la venta");
                }
            }
        }
    }
}
