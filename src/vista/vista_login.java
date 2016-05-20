/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

/**
 *
 * @author Alejandro Ena Encuentra
 * @args vista de login del programa
 */
public class vista_login extends JFrame{
    static JLabel labelLogo;
    static JLabel labelUsuario;
    static JLabel labelContraseña;
    static JTextArea txtUsuario;
    static JTextArea txtContraseña;
    static JButton btnConectar;
    
    public vista_login(){
        JPanel panel = new JPanel();
        
        //this.setName("Login - Proyecto Eval3");
        //this.setBounds(700, 450, 300, 300);
        //this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //this.setResizable(false);
        
        labelLogo = new JLabel("Proyecto Eval3");
        //labelLogo.setSize(null);
        
        labelUsuario = new JLabel("Usuario: ");
        //labelUsuario.setSize(null);
        
        labelContraseña = new JLabel("Contraseña: ");
        //labelContraseña.setSize(null);
        
        txtUsuario = new JTextArea();
        //txtUsuario.setSize(null);
        
        txtContraseña = new JTextArea();
        //txtContraseña.setSize(null);
        
        btnConectar = new JButton("Conectar");
        //btnConectar.setSize(null);
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
     * @args le da comportamiento a los botones
     * @param escucharBoton action listener del boton
     */
    public void addListener(ActionListener escucharBoton){
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
