/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Alumno
 */
public class panel_altaProductos extends JPanel{
    JLabel labelNombre;
    JLabel labelFamilia;
    JLabel labelStock;
    JLabel labelPrecio;
    JTextField txtNombre;
    JTextField txtFamilia;
    JTextField txtStock;
    JTextField txtPrecio;
    JButton btnAñadir;
    
    public panel_altaProductos(){
        labelNombre = new JLabel("Nombre: ");
        labelFamilia = new JLabel("Familia: ");
        labelStock = new JLabel("Cantidad: ");
        labelPrecio = new JLabel("Precio: ");
        txtNombre = new JTextField();
            txtNombre.setColumns(10);
        txtFamilia = new JTextField();
            txtFamilia.setColumns(10);
        txtStock = new JTextField();
            txtStock.setColumns(10);
        txtPrecio = new JTextField();
            txtPrecio.setColumns(10);
        btnAñadir = new JButton("Añadir");
        
        this.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        //spring layout
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        this.add(labelNombre, constraints);
        
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        this.add(txtNombre, constraints);
        
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        this.add(labelFamilia, constraints);
        
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        this.add(txtFamilia, constraints);
        
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        this.add(labelStock, constraints);
        
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        this.add(txtStock, constraints);
        
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        this.add(labelPrecio, constraints);
        
        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        this.add(txtPrecio, constraints);
        
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        this.add(btnAñadir, constraints);
    }
    /**
     * @return el nombre del producto
     */
    public String getTxtNombre(){
        return txtNombre.getText();
    }
    
    /**
     * @return la familia del producto
     */
    public String getTxtFamilia(){
        return txtFamilia.getText();
    }
    
    /**
     * @return la cantidad del producto
     */
    public int getTxtStock(){
        return Integer.parseInt(txtStock.getText());
    }
    
    /**
     * @return el precio del producto
     */
    public double getTxtPrecio(){
        return Float.parseFloat(txtPrecio.getText());
    }
    
    /**
     * @args añade comportamiento al boton
     * @param escucharBoton comportamiento del boton
     */
    public void ListenerBoton(ActionListener escucharBoton){
        btnAñadir.addActionListener(escucharBoton);
    }
}
