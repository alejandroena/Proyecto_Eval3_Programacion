/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 * @args vista de ventas realizadas
 * @author Alejandro Ena Encuentra
 */
public class panel_visualizarVentas extends JPanel{
    JLabel labelTxt1;
    JLabel labelTxt2;
    JDateChooser fechaInicial;
    JDateChooser fechaFinal;
    JLabel labelFiltro;
    JRadioButton radioNinguno;
    JRadioButton radioCodigo;
    JRadioButton radioFamilia;
    ButtonGroup grupo;
    JTextField txtCodigo;
    JTextField txtFamilia;
    JButton btnBuscar;
    JTable datos;
    JLabel labelTotal;
    
    public panel_visualizarVentas(){
        labelTxt1 = new JLabel("De     ");
        labelTxt2 = new JLabel("a");
        fechaInicial = new JDateChooser();
        fechaFinal = new JDateChooser();
        labelFiltro = new JLabel("Filtros:");
        radioNinguno = new JRadioButton("Ninguno",true);
        radioCodigo = new JRadioButton("Codigo producto: ",false);
        radioFamilia = new JRadioButton("Familia del producto: ",false);
        grupo = new ButtonGroup();
        txtCodigo = new JTextField();
            txtCodigo.setColumns(10);
            txtCodigo.setEditable(false);
        txtFamilia = new JTextField();
            txtFamilia.setEditable(false);
            txtFamilia.setColumns(10);
        btnBuscar = new JButton("Buscar");
        datos = new JTable();
        
        grupo.add(radioNinguno);
        grupo.add(radioCodigo);
        grupo.add(radioFamilia);
        
        this.setLayout(new GridLayout(2,1,3,3));
        
        JPanel form = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        form.add(labelTxt1, constraints);
        
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        form.add(fechaInicial, constraints);
        
        constraints.gridx = 3;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        form.add(labelTxt2, constraints);
        
        constraints.gridx = 4;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weighty = 1.0;
        form.add(fechaFinal, constraints);
        constraints.weighty = 0.0;
        
        constraints.gridx = 3;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        form.add(labelFiltro, constraints);
        
        constraints.gridx = 4;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        form.add(radioNinguno, constraints);
        
        constraints.gridx = 4;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        form.add(radioCodigo, constraints);
        
        constraints.gridx = 5;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        form.add(txtCodigo, constraints);
        
        constraints.gridx = 4;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        form.add(radioFamilia, constraints);
        
        constraints.gridx = 5;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        form.add(txtFamilia, constraints);
        
        constraints.gridx = 2;
        constraints.gridy = 4;
        constraints.gridwidth = 3;
        constraints.gridheight = 1;
        constraints.weighty = 1.0;
        form.add(btnBuscar, constraints);
        constraints.weighty = 0.0;
        
        this.add(form);
        
        JPanel tabla = new JPanel(new BorderLayout());
        
        datos = new JTable();
        labelTotal = new JLabel();
            
        tabla.add(datos, BorderLayout.CENTER);
        tabla.add(labelTotal, BorderLayout.SOUTH);
        
        this.add(tabla);
    }
    
    /**
     * @return el codigo del producto
     */
    public String getTxtCodigo(){
        return txtCodigo.getText();
    }
    
    /**
     * @return la familia del producto
     */
    public String getTxtFamilia(){
        return txtFamilia.getText();
    }
    
    /**
     * @args le asigna valores a la tabla
     * @param datos datos de la tabla
     */
    public void setDatos(JTable datos){
        this.datos = datos;
    }
    
    public void setTotal(int total){
        this.labelTotal.setText("Total: " + total);
    }
    
    /**
     * @return la fecha inicial
     */
    public String getFechaInicial(){
        return fechaInicial.getDateFormatString();
    }
    
    /**
     * @return la fecha final
     */
    public String getFechaFinal(){
        return fechaFinal.getDateFormatString();
    }
    
    /**
     * @args le asigna comportamiento al boton
     * @param escucharBoton comportamiento del boton
     */
    public void ListenerBoton(ActionListener escucharBoton){
        btnBuscar.addActionListener(escucharBoton);
    }
    
    /**
     * @args le asigna comportamiento a los radioButton
     * @param escucharRadio comportamiento de los radioButton
     */
    public void ListenerRadio(ActionListener escucharRadio){
        radioCodigo.addActionListener(escucharRadio);
        radioFamilia.addActionListener(escucharRadio);
    }
}
