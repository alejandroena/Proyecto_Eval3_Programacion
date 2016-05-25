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
 * @author Alejandro
 */
public class panel_venderProducto extends JPanel{
    JLabel labelCodigo;
    JTextField txtCodigo;
    JButton btnVender;
    
    public panel_venderProducto(){
        
        labelCodigo = new JLabel("Codigo del articulo: ");
        txtCodigo = new JTextField();
            txtCodigo.setColumns(10);
        btnVender = new JButton("Vender");
        
        this.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 4;
        constraints.gridheight = 1;
        //constraints.weighty = 1.5;
        this.add(labelCodigo, constraints);
        //constraints.weighty = 0.0;
        
        constraints.gridx = 4;
        constraints.gridy = 0;
        constraints.gridwidth = 4;
        constraints.gridheight = 1;
       // constraints.weighty = 1.5;
        this.add(txtCodigo, constraints);
        //constraints.weighty = 0.0;
        
        constraints.gridx = 3;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
       // constraints.weighty = 1.0;
        this.add(btnVender, constraints);
        
    }
    
    /**
     * @return el codigo del articulo
     */
    public String getTxtCodigo(){
        return txtCodigo.getText();
    }
    
    /**
     * @args le da comportamiento a los botones
     * @param escucharBoton action listener del boton
     */
    public void añadirListener(ActionListener escucharBoton){
        btnVender.addActionListener(escucharBoton);
    }
    
}
