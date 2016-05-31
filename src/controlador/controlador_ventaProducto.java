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
import modelo.modelo_ventaProducto;
import vista.panel_ventaProducto;

/**
 * controlador de venta productos, da comportamiento a esta funcion
 * @see vista.panel_ventaProducto
 * @see modelo.modelo_ventaProducto
 * @author Alejandro Ena Encuentra
 */
public class controlador_ventaProducto {
    private panel_ventaProducto vista;
    private modelo_ventaProducto modelo;
    private conexionBD conexionBD;
    
    /**
     * constructorr de la clase
     * @param vista
     * @param modelo
     * @param conexionBD 
     */
    public controlador_ventaProducto(panel_ventaProducto vista, modelo_ventaProducto modelo, conexionBD conexionBD){
        this.vista = vista;
        this.modelo = modelo;
        this.conexionBD = conexionBD;
        this.vista.ListenerBoton(new CalcularListener());
    }
    
    /**
     * comportamiento de los botones
     */
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
                    if(modelo.getEncontrado()){
                        if(modelo.getSuficiente()){
                            vista.setInformacion(codigo+" "+modelo.getNombre()+"\t x"+cantidad+"\t"+modelo.getPrecio()+"€");
                            vista.setTotal(modelo.getPrecio());
                        }
                        else{
                            vista.mostrarAlerta("Cantidad del articulo insuficiente");
                        }
                    } else{
                        vista.mostrarAlerta("Articulo no encontrado");
                    }
                    
                } catch (ClassNotFoundException | SQLException ex) {
                    vista.mostrarAlerta("Error al encontrar el articulo");
                } catch(NumberFormatException ex){
                    vista.mostrarAlerta("el codigo y la cantidad deben ser numeros");
                }
            }
            else if(obj.equals(vista.getBtnVender())){
                try {
                    conexionBD.abrirConexion();
                    modelo.vender(conexionBD);
                    conexionBD.cerrarConexion();
                    modelo.borrar();
                    vista.borrarInformacion();
                } catch (SQLException | ClassNotFoundException ex) {
                    vista.mostrarAlerta("Error al procesar la venta");
                }
            }
            else if(obj.equals(vista.getBtnCancelar())){
                modelo.borrar();
                vista.borrarInformacion();
                
            }
        }
    }
}
