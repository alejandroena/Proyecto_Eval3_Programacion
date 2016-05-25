/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Alejandro
 */
public class panel_visualizarProductos extends JPanel{
    JLabel labelFiltro;
    ButtonGroup grupo;
    JRadioButton radioNinguno;
    JRadioButton radioCodigo;
    JTextField txtCodigo;
    JRadioButton radioFamilia;
    JTextField txtFamilia;
    JButton btnBuscar;
    JCheckBox checkBox;
    JTable tabla;
    
    public panel_visualizarProductos(){
        this.setLayout(new GridLayout(1,2,3,3));
        
        labelFiltro = new JLabel("Filtros:");
        radioNinguno = new JRadioButton("Ninguno", true);
        radioCodigo = new JRadioButton("Codigo de Producto", false);
        txtCodigo = new JTextField();
            txtCodigo.setEnabled(false);
            txtCodigo.setColumns(10);
        radioFamilia = new JRadioButton("Familia de productos", false);
        txtFamilia = new JTextField();
            txtFamilia.setColumns(10);
            txtFamilia.setEnabled(false);
        
        btnBuscar = new JButton("Realizar Busqueda");
        checkBox = new JCheckBox("Ordenar por Stock");
        grupo = new ButtonGroup();
        grupo.add(radioNinguno);
        grupo.add(radioCodigo);
        grupo.add(radioFamilia);
        
        JPanel form = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        this.add(labelFiltro, constraints);
        
        constraints.gridx = 2;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        this.add(radioNinguno, constraints);
        
        constraints.gridx = 2;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        this.add(radioCodigo, constraints);
        
        constraints.gridx = 4;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        this.add(txtCodigo, constraints);
        
        constraints.gridx = 2;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        this.add(radioFamilia, constraints);
        
        constraints.gridx = 4;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        this.add(txtFamilia, constraints);
        
        constraints.gridx = 2;
        constraints.gridy = 4;
        constraints.gridwidth = 3;
        constraints.gridheight = 1;
        this.add(btnBuscar, constraints);
        
        constraints.gridx = 4;
        constraints.gridy = 4;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        this.add(checkBox, constraints);
        
        this.add(form);
        
    }
}
