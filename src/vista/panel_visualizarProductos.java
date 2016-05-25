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
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Alumno
 */
public class panel_visualizarProductos extends JPanel{
    JLabel labelFiltro;
    JRadioButton radioNinguno;
    JRadioButton radioCodigo;
    JTextField txtCodigo;
    JRadioButton radioFamilia;
    JTextField txtFamilia;
    ButtonGroup grupo;
    JButton btnBuscar;
    JCheckBox checkBox;
    JButton btnExportar;
    JTable datos;
    ImageIcon imgExportar;
    
    public panel_visualizarProductos(){
        labelFiltro = new JLabel("Filtros: ");
        radioNinguno = new JRadioButton("Ninguno", true);
        radioCodigo = new JRadioButton("Codigo: ", false);
        radioFamilia = new JRadioButton("Familia: ", false);
        txtCodigo = new JTextField();
            txtCodigo.setColumns(10);
            txtCodigo.setEditable(false);
        txtFamilia = new JTextField();
            txtFamilia.setEditable(false);
            txtFamilia.setColumns(10);
        grupo = new ButtonGroup();
            grupo.add(radioNinguno);
            grupo.add(radioCodigo);
            grupo.add(radioFamilia);
        btnBuscar = new JButton("Buscar");
        imgExportar = new ImageIcon("src/libreria/img_exportar_xml.png");
        btnExportar = new JButton(imgExportar);
            btnExportar.setBackground(Color.WHITE);
        checkBox = new JCheckBox("Ordenar por Stock", false);
        datos = new JTable();
        
        this.setLayout(new BorderLayout());
        
        JPanel form = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        
        constraints.gridx = 10;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weighty = 1.0;
        form.add(btnExportar, constraints);
        constraints.weighty = 0.0;
        
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        form.add(labelFiltro, constraints);
        
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        form.add(radioNinguno, constraints);
        
        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        form.add(radioCodigo, constraints);
        
        constraints.gridx = 2;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        form.add(txtCodigo, constraints);
        
        constraints.gridx = 1;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        form.add(radioFamilia, constraints);
        
        constraints.gridx = 2;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        form.add(txtFamilia, constraints);
        
        constraints.gridx = 2;
        constraints.gridy = 5;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        form.add(btnBuscar, constraints);
        
        constraints.gridx = 4;
        constraints.gridy = 5;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        form.add(checkBox, constraints);
        
        this.add(form, BorderLayout.NORTH);
        this.add(datos, BorderLayout.SOUTH);
    }
    
    public String getTxtCodigo(){
        return txtCodigo.getText();
    }
    
    public String getTxtFamilia(){
        return txtFamilia.getText();
    }
    
    public void ListenerBoton(ActionListener escucharBoton){
        btnBuscar.addActionListener(escucharBoton);
        btnExportar.addActionListener(escucharBoton);
    }
    
    public void ListenerRadio(ActionListener escucharRadio){
        radioNinguno.addActionListener(escucharRadio);
        radioCodigo.addActionListener(escucharRadio);
        radioFamilia.addActionListener(escucharRadio);
    }
    
    public void ListenerCheckBox(ActionListener escucharCheckBox){
        checkBox.addActionListener(escucharCheckBox);
    }
    
    public void actualizarTabla(JTable tabla){
        datos = tabla;
    }
}
