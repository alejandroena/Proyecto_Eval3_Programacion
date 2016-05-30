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
        
        crearTabla();
    }
    
    /**
     * modelo de la tabla
     */
    public class ModeloTabla extends DefaultTableModel{
        
        public ModeloTabla(){
            String columna[] = new String[]{"Nombre","Familia","Cantidad","Precio"};
            DefaultTableModel tabla = new DefaultTableModel(null, columna);
        
            MaskFormatter mf1= null;
            MaskFormatter mf2= null;
            MaskFormatter mf3= null;
            MaskFormatter mf4= null;
            try {
                mf1= new MaskFormatter("????????????????????????????????????????");
                //mf1.setPlaceholderCharacter('_');
                
                mf2= new MaskFormatter("????????????????????");
                //mf2.setPlaceholderCharacter('_');
                
                mf3= new MaskFormatter("####");
                //mf3.setPlaceholderCharacter('_');
                
                mf4= new MaskFormatter("####.##");
                //mf4.setPlaceholderCharacter('_');
            } catch (ParseException ex) {
                vista.mostrarError("error de formato");
            }
            
            JTable table= new JTable(tabla);
            DefaultTableColumnModel dcm=(DefaultTableColumnModel)table.getColumnModel();
            
            JFormattedTextField ftf1= new JFormattedTextField(mf1);
            JFormattedTextField ftf2= new JFormattedTextField(mf2);
            JFormattedTextField ftf3= new JFormattedTextField(mf3);
            JFormattedTextField ftf4= new JFormattedTextField(mf4);
            
            dcm.getColumn(1).setCellEditor(new DefaultCellEditor(ftf1));
            dcm.getColumn(2).setCellEditor(new DefaultCellEditor(ftf2));
            dcm.getColumn(3).setCellEditor(new DefaultCellEditor(ftf3));
            dcm.getColumn(4).setCellEditor(new DefaultCellEditor(ftf4));
        }
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
            try {
                conexionBD.abrirConexion();
            } catch (ClassNotFoundException ex) {
                vista.mostrarError("Error al contactar con la bse de datos");
            }
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
    
    /**
     * guardado de los dats modificados en la base de datos
     */
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
            rs.close();
        } catch (SQLException ex) {
            vista.mostrarError("Error al guardar la tabla");
        }   
    }    
}
