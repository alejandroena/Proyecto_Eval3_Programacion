/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Alumno
 */
public class panel_bajaProductos extends JPanel{
    JLabel labelTexto;
    JRadioButton radioCodigo;
    JRadioButton radioNombre;
    JTextField  txtCodigo;
    JTextField txtNombre;
    ButtonGroup grupo;
    JButton btnAceptar;
    
    public panel_bajaProductos(){
        labelTexto = new JLabel("Introduce el codigo o el nombre del producto");
        radioCodigo = new JRadioButton("Codigo: ",true);
        radioNombre = new JRadioButton("Nombre: ",false);
        txtCodigo = new JTextField();
            txtCodigo.setColumns(10);
            txtCodigo.setEditable(true);
        txtNombre = new JTextField();
            txtNombre.setColumns(10);
            txtNombre.setEditable(false);
        grupo = new ButtonGroup();
            grupo.add(radioCodigo);
            grupo.add(radioNombre);
        btnAceptar = new JButton("Aceptar");
        
        this.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 8;
        constraints.gridheight = 1;
        constraints.weighty = 1.0;
        this.add(labelTexto, constraints);
        constraints.weighty = 0.0;
        
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        this.add(radioCodigo, constraints);
        
        constraints.gridx = 2;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        this.add(txtCodigo, constraints);
        
        constraints.gridx = 4;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        this.add(radioNombre, constraints);
        
        
        constraints.gridx = 6;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        this.add(txtNombre, constraints);
        
        constraints.gridx = 4;
        constraints.gridy = 2;
        constraints.gridwidth = 3;
        constraints.gridheight = 1;
        constraints.weighty = 1.0;
        this.add(btnAceptar, constraints);
    }
    
    /**
     * @return codigo
     */
    public int getTxtCodigo(){
        return Integer.parseInt(txtCodigo.getText());
    }
    
    /**
     * @return nombre
     */
    public String getTxtNombre(){
        return txtNombre.getText();
    }
    
    /**
     * @args añade comportamiento al boton
     * @param escucharBoton comportamiento del boton
     */
    public void ListenerBoton(ActionListener escucharBoton){
        btnAceptar.addActionListener(escucharBoton);
    }
    
    /**
     * @args añade comportamiento a los radio button
     * @param escucharRadio comportamiento de los radio button
     */
    public void ListenerRadio(ActionListener escucharRadio){
        radioCodigo.addActionListener(escucharRadio);
        radioNombre.addActionListener(escucharRadio);
    }
    
    /** 
     * @return el radioButton
     */
    public JRadioButton getRadioCodigo(){
        return radioCodigo;
    }
    
    /** 
     * @return el radioButton
     */
    public JRadioButton getRadioNombre(){
        return radioNombre;
    }
    
    /**
     * @args activa o desactiva el campo de texto
     * @param enable boolean
     */
    public void enableTxtCodigo(boolean enable){
        txtCodigo.setEditable(enable);
    }
    
    /**
     * @args activa o desactiva el campo de texto
     * @param enable boolean
     */
    public void enableTxtNombre(boolean enable){
        txtNombre.setEditable(enable);
    }
    /**
     * @args muestra una alerta
     * @param mensage de alerta
     */
    public void mostrarAlerta(String mensage){
       JOptionPane.showMessageDialog(this.getParent(), mensage);
    }
}
