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
import javax.swing.event.CellEditorListener;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alumno
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
    
    
    public JButton getBtnGuardar(){
        return btnGuardar;
    }
    
    public JButton getBtnCancelar(){
        return btnCancelar;
    }
    
    public void actualizarTabla(Object datos[]){
        tabla.addRow(datos);
    }
    
    public void borrarTabla(){
        tabla.setNumRows(0);
    }
    
    public int getFilas(){
        return datos.getRowCount();
    }
    
    public Object getDatos(int fila, int columna){
        return datos.getValueAt(fila, columna);
    }
    
    public void modeloTabla(DefaultTableModel modelo){
        datos.setModel(modelo);
    }
    public void ListenerBoton(ActionListener escucharBoton){
        btnGuardar.addActionListener(escucharBoton);
        btnCancelar.addActionListener(escucharBoton);
    }
    
    public void mostrarError(String mensage){
        JOptionPane.showMessageDialog(this.getParent(), mensage);
    }
}
