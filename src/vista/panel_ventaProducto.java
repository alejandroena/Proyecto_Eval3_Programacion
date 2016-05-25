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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Alumno
 */
public class panel_ventaProducto extends JPanel{
    JTextArea informacion;
    JLabel labelCodigo;
    JLabel labelCantidad;
    JTextField txtCodigo;
    JTextField txtCantidad;
    JButton btnAñadir;
    JButton btnVender;
    
    public panel_ventaProducto(){
        informacion = new JTextArea();
            informacion.setEditable(false);
        labelCodigo = new JLabel("Codigo");
        labelCantidad = new JLabel("Cantidad");
        txtCodigo = new JTextField();
            txtCodigo.setColumns(10);
        txtCantidad = new JTextField();
            txtCantidad.setColumns(10);
        btnAñadir = new JButton("Añadir");
        btnVender = new JButton("Vender");
        
        this.setLayout(new BorderLayout());
        
        this.add(informacion, BorderLayout.WEST);
        informacion.setColumns(30);
        JPanel form = new JPanel(new BorderLayout());
        
        JPanel añadir = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        añadir.add(labelCodigo, constraints);
        
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        añadir.add(labelCantidad, constraints);
        
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        añadir.add(txtCodigo, constraints);
        
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        añadir.add(txtCantidad, constraints);
        
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        añadir.add(btnAñadir, constraints);
        
        form.add(añadir, BorderLayout.CENTER);
        form.add(btnVender, BorderLayout.SOUTH);
        
        this.add(form, BorderLayout.EAST);
    }
    /**
     * @return codigo del producto
     */
    public String getTxtCodigo(){
        return txtCodigo.getText();
    }
    
    /**
     * @return cantidad del producto
     */
    public String getTxtCantidad(){
        return txtCantidad.getText();                
    }
    
    /**
     * @args informacion de la venta
     * @param texto a escribir
     */
    public void setInformacion(String texto){
        informacion.setText("\n"+texto);
    }
    
    /**
     * @args le asigna comportamiento al boton
     * @param escucharBoton comportamiento del boton
     */
    public void ListenerBoton(ActionListener escucharBoton){
        btnAñadir.addActionListener(escucharBoton);
        btnVender.addActionListener(escucharBoton);
    }
            
}
