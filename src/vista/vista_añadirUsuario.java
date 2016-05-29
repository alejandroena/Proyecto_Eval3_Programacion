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
import javax.swing.WindowConstants;

/**
 *
 * @author Alumno
 */
public class vista_añadirUsuario extends JFrame{
    JLabel labelNombre;
    JLabel labelContraseña;
    JLabel labelReContraseña;
    JTextField txtNombre;
    JTextField txtContraseña;
    JTextField txtReContraseña;
    JButton btnCancelar;
    JButton btnAceptar;
    JLabel labelError;
    
    public vista_añadirUsuario(){
        this.setTitle("Añadir usuario");
        this.setBounds(700, 450, 400, 300);
        this.setResizable(false);
        
        labelNombre = new JLabel("Usuario");
        labelContraseña = new JLabel("Contraseña");
        labelReContraseña = new JLabel("Repite Contraseña");
        txtNombre = new JTextField();
            txtNombre.setColumns(15);
        txtContraseña = new JPasswordField();
            txtContraseña.setColumns(15);
        txtReContraseña = new JPasswordField();
            txtReContraseña.setColumns(15);
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
        form.add(labelContraseña, constraints);
        
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        form.add(txtContraseña, constraints);
        
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        form.add(labelReContraseña, constraints);
        
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        form.add(txtReContraseña, constraints);
        
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
    
    public String getTxtNombre(){
        return txtNombre.getText();
    }
    
    public String getTxtContraseña(){
        return txtContraseña.getText();
    }
    
    public String getTxtReContraseña(){
        return txtReContraseña.getText();
    }
    
    public void borrarDatos(){
        txtNombre.setText("");
        txtContraseña.setText("");
        txtReContraseña.setText("");
    }
    
    public JButton getBtnAceptar(){
        return btnAceptar;
    }
    
    public JButton getBtnCancelar(){
        return btnCancelar;
    }
    
     public void ListenerBoton(ActionListener escucharBoton){
        btnCancelar.addActionListener(escucharBoton);
        btnAceptar.addActionListener(escucharBoton);
    }
     
    public void setLabelError(String texto){
        labelError.setText(texto);
    }
    
    public void mostrarError(String mensage){
        JOptionPane.showMessageDialog(this, mensage);
    }
}
