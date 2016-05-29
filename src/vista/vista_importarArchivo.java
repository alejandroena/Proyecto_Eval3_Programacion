/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author Alumno
 */
public class vista_importarArchivo extends JFrame{
    JLabel labelRuta;
    JTextField txtRuta;
    JButton btnExaminar;
    JButton btnCancelar;
    JButton btnAceptar;
    ImageIcon imgBuscar;
    JLabel labelError;
    
    public vista_importarArchivo(){
        this.setTitle("img_importar archivo");
        this.setBounds(700, 450, 400, 150);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        
        labelRuta = new JLabel("Ruta: ");
        txtRuta = new JTextField();
            txtRuta.setColumns(15);
        imgBuscar = new ImageIcon("src/libreria/buscar_archivo.png");
        btnExaminar = new JButton(imgBuscar);
        btnCancelar = new JButton("Cancelar");
        btnAceptar = new JButton("Aceptar");
        labelError = new JLabel();
            labelError.setForeground(Color.red);
            
        this.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        this.add(labelRuta, constraints);
        
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        this.add(txtRuta, constraints);
        
        constraints.gridx = 3;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        this.add(btnExaminar, constraints);
        
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        this.add(btnCancelar, constraints);
        
        constraints.gridx = 2;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        this.add(btnAceptar, constraints);
        
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 10;
        constraints.gridheight = 1;
        this.add(labelError, constraints);
        
    }
    
    /**
     * @args establece la ruta del archivo
     * @param ruta del archivo
     */
    public void setTxtRuta(String ruta){
        txtRuta.setText(ruta);
    }
    
    /**
     * @return la ruta del archivo
     */
    public String getTxtRuta(){
        return txtRuta.getText();
    }
    
    /**
     * @args añade comportamiento a los botones
     * @param escucharBoton comportamiento del boton
     */
    public void ListenerBoton(ActionListener escucharBoton){
        btnExaminar.addActionListener(escucharBoton);
        btnCancelar.addActionListener(escucharBoton);
        btnAceptar.addActionListener(escucharBoton);
    }
    
    public void setLabelError(String texto){
         labelError.setText(texto);
     }
}
