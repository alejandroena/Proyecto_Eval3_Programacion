/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * vista de modificar productos
 * @see modelo.modelo_modificarProductos
 * @see controlador.controlador_modificarProductos
 * @author Alejandro ena Encuentra
 */
public class panel_modificarProductos extends JPanel{
    JTable datos;
    JButton btnGuardar;
    JButton btnCancelar;
    DefaultTableModel tabla;
    JScrollPane scrollPane;
    
    public panel_modificarProductos(){
        datos = new JTable();
        btnGuardar = new JButton("Guardar");
        btnCancelar = new JButton("Cancelar");

        datos = new JTable();
        scrollPane = new JScrollPane(datos); 
        
        this.setLayout(new BorderLayout());
 
        this.add(scrollPane, BorderLayout.CENTER);
        
        JPanel botones = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        botones.add(btnGuardar, constraints);
        
        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        botones.add(btnCancelar, constraints);
        
        this.add(botones, BorderLayout.SOUTH);
    }
    
    /**
     * @return el boton guardar
     */
    public JButton getBtnGuardar(){
        return btnGuardar;
    }
    
    /**
     * @return el boton cancelar
     */
    public JButton getBtnCancelar(){
        return btnCancelar;
    }
    
    /**
     * actualiza la tabla con los datos
     * @param datos de la fila
     */
    public void actualizarTabla(Object datos[]){
        tabla.addRow(datos);
    }
    
    /**
     * borra las filas de la tabla
     */
    public void borrarTabla(){
        tabla.setNumRows(0);
    }
    
    /**
     * @return el numero de filas de la tabla
     */
    public int getFilas(){
        return datos.getRowCount();
    }
    
    /**
     * @param fila
     * @param columna
     * @return el dato en la fila y columna espedificada
     */
    public Object getDatos(int fila, int columna){
        return datos.getValueAt(fila, columna);
    }
    
    /**
     * establace el modelo de la tabla
     * @param modelo de la tabla
     */
    public void modeloTabla(DefaultTableModel modelo){
        datos.setModel(modelo);
    }
    
    /**
     * da comportamiento a los botones
     * @param escucharBoton comportamiento de los botones
     */
    public void ListenerBoton(ActionListener escucharBoton){
        btnGuardar.addActionListener(escucharBoton);
        btnCancelar.addActionListener(escucharBoton);
    }
    
    /**
     * muestra el mensage de error
     * @param mensage de error
     */
    public void mostrarError(String mensage){
        JOptionPane.showMessageDialog(this.getParent(), mensage);
    }
}
