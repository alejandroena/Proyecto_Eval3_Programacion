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
public class vista_exportarXML extends JFrame{
    JLabel labelNombre;
    JTextField txtNombre;
    JLabel labelRuta;
    JTextField txtRuta;
    JButton btnExaminar;
    JButton btnCancelar;
    JButton btnAceptar;
    ImageIcon imgBuscar;
    JLabel labelError;
    
    public vista_exportarXML(){
        this.setTitle("Exportar vista");
        this.setBounds(700, 450, 400, 150);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        
        labelNombre = new JLabel("Nombre: ");
        txtNombre = new JTextField();
            txtNombre.setColumns(15);
        labelRuta = new JLabel("Ruta: ");
        txtRuta = new JTextField();
            txtRuta.setColumns(15);
        imgBuscar = new ImageIcon("src/lib/img_buscar_archivo.png");
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
        this.add(labelNombre, constraints);
        
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        this.add(txtNombre, constraints);
        
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        this.add(labelRuta, constraints);
        
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        this.add(txtRuta, constraints);
        
        constraints.gridx = 3;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        this.add(btnExaminar, constraints);
        
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        this.add(btnCancelar, constraints);
        
        constraints.gridx = 2;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        this.add(btnAceptar, constraints);
        
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 10;
        constraints.gridheight = 1;
        this.add(labelError, constraints);
    }
    
    public void setTxtRuta(String ruta){
        txtRuta.setText(ruta);
    }
    
    public String getTxtRuta(){
        return txtRuta.getText();
    }
    
    public String getTxtNombre(){
        return txtNombre.getText();
    }
    
     public void ListenerBoton(ActionListener escucharBoton){
        btnExaminar.addActionListener(escucharBoton);
        btnCancelar.addActionListener(escucharBoton);
        btnAceptar.addActionListener(escucharBoton);
    }
     
    public void setLabelError(String texto){
        labelError.setText(texto);
    }
}