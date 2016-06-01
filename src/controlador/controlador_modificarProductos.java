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
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import modelo.conexionBD;
import modelo.modelo_modificarProductos;
import vista.panel_modificarProductos;

/**
 * controlador de modificar productos
 * @see modelo.modelo_modificarProductos
 * @see vista.panel_modificarProductos
 * @author Alejandro Ena Encuentra
 */
public class controlador_modificarProductos {
    
    private modelo_modificarProductos modelo;
    private panel_modificarProductos vista;
    private conexionBD conexionBD;
    ResultSet rs;
    
    /**
     * constructor de la clase
     * @param modelo
     * @param vista
     * @param conexionBD 
     */
    public controlador_modificarProductos(modelo_modificarProductos modelo, panel_modificarProductos vista, conexionBD conexionBD){
        this.vista = vista;
        this.modelo = modelo;
        this.conexionBD = conexionBD;
        this.vista.ListenerBoton(new ComportamientoBotones());
        ModeloTabla();
        crearTabla();
    }
    
    /**
     * modelo de la tabla
     */
        
        public void ModeloTabla(){

            MaskFormatter mf1= null;
            MaskFormatter mf2= null;
            
            try {
                mf1= new MaskFormatter("####");
                
                mf2= new MaskFormatter("######");

            } catch (ParseException ex) {
                vista.mostrarError("error de formato");
            }
            
            DefaultTableColumnModel dcm=(DefaultTableColumnModel)vista.getTabla().getColumnModel();

            JFormattedTextField ftf1= new JFormattedTextField(mf1);
            JFormattedTextField ftf2= new JFormattedTextField(mf2);
            
            dcm.getColumn(3).setCellEditor(new DefaultCellEditor(ftf1));
            dcm.getColumn(4).setCellEditor(new DefaultCellEditor(ftf2));
        }
    
    /**
     * comportamiento de los botones
     */
    public class ComportamientoBotones implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Object obj = e.getSource();
            
            if(obj.equals(vista.getBtnCancelar())){
                vista.borrarTabla();
                crearTabla();
            }
            else if(obj.equals(vista.getBtnGuardar())){
                vista.getTabla();
                guardarTabla();
                vista.borrarTabla();
                crearTabla();
            }
        }
    }
    
    /**
     * creacion de la tabla
     */
    public void crearTabla(){
            
        try {
            conexionBD.abrirConexion();
            
            rs = this.modelo.cogerDatos(conexionBD);
            Object datos[] = new Object[5];
            
            while(rs.next()){
                for(int i=0; i<5; i++){
                    datos[i] = rs.getObject(i+1);
                }
                vista.actualizarTabla(datos);
            }
            
        } catch (SQLException | ClassNotFoundException ex) {
            vista.mostrarError("Error al crear la tabla");
        }    
    }
    
    /**
     * guardado de los dats modificados en la base de datos
     */
    public void guardarTabla(){
        try {
            for(int i=0;i<vista.getTabla().getRowCount();i++){
               
                String nombre = (String)vista.getDatos(i, 1);
                
                String familia = (String)vista.getDatos(i, 2);
                
                int cantidad;
                try{
                    cantidad = (int)vista.getDatos(i, 3);
                }catch(ClassCastException ex){
                    try{
                        String cant = (String)vista.getDatos(i, 3);
                        cantidad = Integer.parseInt(cant.replace(" ", ""));
                    }catch(NumberFormatException es){
                        cantidad = -1;
                    }
                }

                float precio;
                try{
                    precio = (float)vista.getDatos(i, 4);
                }catch(ClassCastException ex){
                    try{
                        String pre = (String)vista.getDatos(i, 4);
                        precio = Float.parseFloat(pre.replace(" ", ""));  
                    }catch(NumberFormatException es){
                        precio = -1;
                    }
                }
                    
                int codigo = (int)vista.getDatos(i, 0);
                
                if(nombre.equals("")==false){
                    modelo.guardarNombre(nombre, codigo);
                }
                if(familia.equals("")==false){
                    modelo.guardarFamilia(familia, codigo);
                }
                if(cantidad>0){
                    modelo.guardarCantidad(cantidad, codigo);
                }
                if(precio>0){
                    modelo.guardarPrecio(precio, codigo);
                }
            }
             
        } catch (SQLException ex) {
            vista.mostrarError("Error al guardar la tabla");
        }   
    }    
}
