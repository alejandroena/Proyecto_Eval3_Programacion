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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

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
    final JTable datos;
    ImageIcon imgExportar;
    DefaultTableModel tabla;
    JScrollPane scrollPane;
        
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
        String columna[] = new String[]{"Codigo","Nombre","Familia","Cantidad","Precio"};
        tabla = new DefaultTableModel(null, columna);
        datos = new JTable(tabla);
            datos.setEnabled(false);
        scrollPane = new JScrollPane(datos);   
        
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
        this.add(scrollPane, BorderLayout.CENTER);
    }
    
    public int getTxtCodigo(){
        if(txtCodigo.getText().equals("")){
            return 0;
        }
        else{
            return Integer.parseInt(txtCodigo.getText());
        }
    }
    
    public String getTxtFamilia(){
        return txtFamilia.getText();
    }
    
    public void setTxtCodigo(){
        txtCodigo.setText("");
    }
    
    public void setTxtFamilia(){
        txtFamilia.setText("");
    }
    
    public JButton getBtnBuscar(){
        return btnBuscar;
    }
    
    public JButton getBtnExportar(){
        return btnExportar;
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
    
    public JRadioButton getRadioNinguno(){
        return radioNinguno;
    }
    
    public JRadioButton getRadioCodigo(){
        return radioCodigo;
    }
    
    public JRadioButton getRadioFamilia(){
        return radioFamilia;
    }
    
    public void setEnableCodigo(boolean enable){
        txtCodigo.setEditable(enable);
    }
    
    public void setEnableFamilia(boolean enable){
        txtFamilia.setEditable(enable);
    }
    
    public JCheckBox getCheckBox(){
        return checkBox;
    }
    
    public void actualizarTabla(Object datos[]){
        tabla.addRow(datos);
    }
    
    public void borrarTabla(){
        tabla.setNumRows(0);
    }
    
    public int getFilas(){
        return datos.getRowCount();
    }
    
    public Object getDatos(int fila, int columna){
        return datos.getValueAt(fila, columna);
    }
    
    public void mostrarError(String mensage){
        JOptionPane.showMessageDialog(this.getParent(), mensage);
    }
}
