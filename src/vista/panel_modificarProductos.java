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
import javax.swing.JPanel;
import javax.swing.JTable;

/**
 *
 * @author Alumno
 */
public class panel_modificarProductos extends JPanel{
    JTable datos;
    JButton btnGuardar;
    
    public panel_modificarProductos(){
        datos = new JTable();
        btnGuardar = new JButton("Guardar");
        
        this.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 9;
        constraints.gridheight = 1;
        this.add(datos, constraints);
        
        constraints.gridx = 4;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        this.add(btnGuardar, constraints);
    }
    
    public void setDatos(JTable tabla){
        datos = tabla;
    }
    public JTable getDatos(){
        return datos;
    }
    public void ListenerBoton(ActionListener escucharBoton){
        btnGuardar.addActionListener(escucharBoton);
    }
}
