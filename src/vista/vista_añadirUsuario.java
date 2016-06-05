/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * vista de añadir usuario
 * @see modelo.modelo_añadirUsuario
 * @see controlador.controlador_añadirUsuario
 * @author Alejandro Ena Encuentra
 */
public class vista_añadirUsuario extends JFrame{
    private JLabel labelNombre;
    private JLabel labelContrasenia;
    private JLabel labelReContrasenia;
    private JTextField txtNombre;
    private JTextField txtContrasenia;
    private JTextField txtReContrasenia;
    private JButton btnCancelar;
    private JButton btnAceptar;
    private JLabel labelError;
    
    public vista_añadirUsuario(){
        this.setTitle("Añadir usuario");
        this.setBounds(700, 450, 400, 300);
        this.setResizable(false);
        
        labelNombre = new JLabel("Usuario");
        labelContrasenia = new JLabel("Contraseña");
        labelReContrasenia = new JLabel("Repite Contraseña");
        txtNombre = new JTextField();
            txtNombre.setColumns(15);
        txtContrasenia = new JPasswordField();
            txtContrasenia.setColumns(15);
        txtReContrasenia = new JPasswordField();
            txtReContrasenia.setColumns(15);
        btnCancelar = new JButton("Cancelar");
        btnAceptar = new JButton("Aceptar");
        labelError = new JLabel();
            labelError.setForeground(Color.red);
            
        this.setLayout(new BorderLayout());
        
        JPanel form = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        form.add(labelNombre, constraints);
        
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        form.add(txtNombre, constraints);
        
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        form.add(labelContrasenia, constraints);
        
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        form.add(txtContrasenia, constraints);
        
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        form.add(labelReContrasenia, constraints);
        
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        form.add(txtReContrasenia, constraints);
        
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        form.add(btnCancelar, constraints);
        
        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        form.add(btnAceptar, constraints);
 
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 10;
        constraints.gridheight = 1;
        form.add(labelError, constraints);
        
        this.add(form, BorderLayout.CENTER);
    }
    
    /**
     * @return nombre del usuario
     */
    public String getTxtNombre(){
        return txtNombre.getText();
    }
    
    /**
     * @return contraseña del usuario
     */
    public String getTxtContrasenia(){
        return txtContrasenia.getText();
    }
    
    /**
     * @return reContraseña del usuario
     */
    public String getTxtReContrasenia(){
        return txtReContrasenia.getText();
    }
    
    /**
     * borra los datos de los textField
     */
    public void borrarDatos(){
        txtNombre.setText("");
        txtContrasenia.setText("");
        txtReContrasenia.setText("");
    }
    
    /**
     * @return el boton aceptar
     */
    public JButton getBtnAceptar(){
        return btnAceptar;
    }
    
    /**
     * @return el boton cancelar
     */
    public JButton getBtnCancelar(){
        return btnCancelar;
    }
    
    /**
     * da comportamiento a los botones
     * @param escucharBoton comportamiento del boton
     */
    public void ListenerBoton(ActionListener escucharBoton){
        btnCancelar.addActionListener(escucharBoton);
        btnAceptar.addActionListener(escucharBoton);
    }
     
    /**
     * establece el texto de la label
     * @param texto 
     */
    public void setLabelError(String texto){
        labelError.setText(texto);
    }
    
    /**
     * muestra el mensage de error
     * @param mensage de error
     */
    public void mostrarError(String mensage){
        JOptionPane.showMessageDialog(this, mensage);
    }
}
