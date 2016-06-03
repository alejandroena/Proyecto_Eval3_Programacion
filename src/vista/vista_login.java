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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 * @args vista de login del programa
 * @see modelo.modelo_login
 * @see controlador.controlador_login
 * @author Alejandro Ena Encuentra
 */
public class vista_login extends JFrame{
    private JLabel labelLogo;
    private JLabel labelUsuario;
    private JLabel labelContraseña;
    private JTextField txtUsuario;
    private JTextField txtContraseña;
    private JButton btnConectar;
    
    public vista_login(){
        
        this.setTitle("Login - Proyecto Eval3");
        this.setBounds(700, 450, 600, 400);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        
        labelLogo = new JLabel("Proyecto Eval3");
        labelUsuario = new JLabel("Usuario: ");
        labelContraseña = new JLabel("Contraseña: ");
        txtUsuario = new JTextField();
            txtUsuario.setColumns(8);
        txtContraseña = new JPasswordField();
            txtContraseña.setColumns(8);
        btnConectar = new JButton("Conectar");
        
        this.getContentPane().setLayout (new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
       
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        constraints.weighty = 1.0;
        this.getContentPane().add(labelLogo, constraints);
        constraints.weighty = 0.0;
        
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        this.getContentPane().add(labelUsuario, constraints);
        
        constraints.gridx = 2;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        this.getContentPane().add(txtUsuario, constraints);
        
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        this.getContentPane().add(labelContraseña, constraints);
        
        constraints.gridx = 2;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        this.getContentPane().add(txtContraseña, constraints);
        
        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        constraints.weighty = 1.0;
        this.getContentPane().add(btnConectar, constraints);
        constraints.weighty = 0.0;
    }
    
    /**
     * @return el nombre de usuario
     */
    public String getTxtUsuario(){
        return txtUsuario.getText();
    }
    
    /**
     * @return la contraseña
     */
    public String getTxtContraseña(){
        return txtContraseña.getText();
    }
    
    /**
     * borra los detos de los textField
     */
    public void borrarDatos(){
        txtUsuario.setText("");
        txtContraseña.setText("");
    }
    
    /**
     * @args le da comportamiento a los botones
     * @param escucharBoton action listener del boton
     */
    public void añadirListener(ActionListener escucharBoton){
        btnConectar.addActionListener(escucharBoton);
    }
    
    /**
     * @args muestra el mensage de error
     * @param mensage mensage de error
     */
    public void mostrarAlerta(String mensage){
       JOptionPane.showMessageDialog(this, mensage);
    }
}
