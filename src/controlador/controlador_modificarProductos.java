/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import modelo.conexionBD;
import modelo.modelo_modificarProductos;
import vista.panel_modificarProductos;

/**
 *
 * @author Alejandro
 */
public class controlador_modificarProductos {
    
    private modelo_modificarProductos modelo;
    private panel_modificarProductos vista;
    private conexionBD conexionBD;
    ResultSet rs;
    
    public controlador_modificarProductos(modelo_modificarProductos modelo, panel_modificarProductos vista, conexionBD conexionBD){
        this.vista = vista;
        this.modelo = modelo;
        this.conexionBD = conexionBD;
        this.vista.ListenerBoton(new ComportamientoBotones());
        crearTabla();
    }
    
    public class ComportamientoBotones implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Object obj = e.getSource();
            
            if(obj.equals(vista.getBtnCancelar())){
                vista.borrarTabla();
                crearTabla();
            }
            else if(obj.equals(vista.getBtnGuardar())){
                guardarTabla();
                vista.borrarTabla();
                crearTabla();
            }
        }
    }
    
    public void crearTabla(){
            
        try {
            rs = this.modelo.cogerDatos(conexionBD);
            Object datos[] = new Object[4];
            
            while(rs.next()){
                for(int i=0; i<4; i++){
                    datos[i] = rs.getObject(i+2);
                }
                vista.actualizarTabla(datos);
            }
            
        } catch (SQLException ex) {
            vista.mostrarError("Error al crear la tabla");
        }    
    }
    
    public void guardarTabla(){
        try {
            rs.first();
            int i=0;
            while(rs.next()){
                if(rs.getObject(2).equals(vista.getDatos(i, 0))==false){
                    modelo.guardarNombre((String)vista.getDatos(i, 0), (int)rs.getObject(1));
                }
                
                if(rs.getObject(3).equals(vista.getDatos(i, 1))==false){
                    modelo.guardarFamilia((String)vista.getDatos(i, 1), (int)rs.getObject(1));
                }
                
                if(rs.getObject(4).equals(vista.getDatos(i, 2))==false){
                    modelo.guardarCantidad((int)vista.getDatos(i, 2), (int)rs.getObject(1));
                }
                
                if(rs.getObject(5).equals(vista.getDatos(i, 3))==false){
                    modelo.guardarPrecio((float)vista.getDatos(i, 3), (int)rs.getObject(1));
                }
                
                i++;
            }
        } catch (SQLException ex) {
            vista.mostrarError("Error al guardar la tabla");
        }   
    }    
}
