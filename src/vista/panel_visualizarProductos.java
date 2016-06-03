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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 * vista de visualizar productos
 * @see controlador.controlador_visualizarProductos
 * @see modelo.modelo_visualizarProductos
 * @author Alejandor Ena Encuentra
 */
public class panel_visualizarProductos extends JPanel{
    private JLabel labelFiltro;
    private JRadioButton radioNinguno;
    private JRadioButton radioCodigo;
    private JTextField txtCodigo;
    private JRadioButton radioFamilia;
    private JComboBox txtFamilia;
    private ButtonGroup grupo;
    private JButton btnBuscar;
    private JCheckBox checkBox;
    private JButton btnExportar;
    private JTable datos;
    private ImageIcon imgExportar;
    private DefaultTableModel tabla;
    private JScrollPane scrollPane;
        
    public panel_visualizarProductos(){
        labelFiltro = new JLabel("Filtros: ");
        radioNinguno = new JRadioButton("Ninguno", true);
        radioCodigo = new JRadioButton("Codigo: ", false);
        radioFamilia = new JRadioButton("Familia: ", false);
        txtCodigo = new JTextField();
            txtCodigo.setColumns(10);
            txtCodigo.setEditable(false);
        txtFamilia = new JComboBox();
            txtFamilia.setEnabled(false);
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
    
    /**
     * @return el codigo
     */
    public int getTxtCodigo(){
        if(txtCodigo.getText().equals("")){
            return 0;
        }
        else{
            return Integer.parseInt(txtCodigo.getText());
        }
    }
    
    /**
     * @return la familia
     */
    public String getTxtFamilia(){
        return (String)txtFamilia.getSelectedItem();
    }
    
    /**
     * borra los datos del textField codigo
     */
    public void setTxtCodigo(){
        txtCodigo.setText("");
    }
    
    /**
     * borra los datos del TextField familia
     */
    public void setTxtFamilia(){
        txtFamilia.setSelectedItem(null);
    }
    
    /**
     * añade los objetos a la lista
     * @param datos 
     */
    public void setFamiliaDatos(Object datos){
        txtFamilia.addItem(datos);
        txtFamilia.setSelectedItem(null);
    }
    
    /**
     * @return el boton buscar
     */
    public JButton getBtnBuscar(){
        return btnBuscar;
    }
    
    /**
     * @return el boton exportar
     */
    public JButton getBtnExportar(){
        return btnExportar;
    }
    
    /**
     * le da comportamiento a los botones
     * @param escucharBoton comportamiento de los botones
     */
    public void ListenerBoton(ActionListener escucharBoton){
        btnBuscar.addActionListener(escucharBoton);
        btnExportar.addActionListener(escucharBoton);
    }
    
    /**
     * le da comportamiento a los radio button
     * @param escucharRadio comportamiento de los radio button
     */
    public void ListenerRadio(ActionListener escucharRadio){
        radioNinguno.addActionListener(escucharRadio);
        radioCodigo.addActionListener(escucharRadio);
        radioFamilia.addActionListener(escucharRadio);
    }
    
    /**
     * @return el radio button ninguno
     */
    public JRadioButton getRadioNinguno(){
        return radioNinguno;
    }
    
    /**
     * @return el radio button codigo
     */
    public JRadioButton getRadioCodigo(){
        return radioCodigo;
    }
    
    /**
     * @return el radio button familia
     */
    public JRadioButton getRadioFamilia(){
        return radioFamilia;
    }
    
    /**
     * activa o desactiva el textfield codigo
     * @param enable 
     */
    public void setEnableCodigo(boolean enable){
        txtCodigo.setEditable(enable);
    }
    
    /**
     * activa o desactiva el textField familia
     * @param enable 
     */
    public void setEnableFamilia(boolean enable){
        txtFamilia.setEnabled(enable);
    }
    
    /**
     * @return el checkBox
     */
    public JCheckBox getCheckBox(){
        return checkBox;
    }
    
    /**
     * añade a la tabla una fila con los datos
     * @param datos 
     */
    public void actualizarTabla(Object datos[]){
        tabla.addRow(datos);
    }
    
    /**
     * borra las filas de la tabla
     */
    public void borrarTabla(){
        tabla.setNumRows(0);
    }
    
    /**
     * @return el numero de filas de la tabla
     */
    public int getFilas(){
        return datos.getRowCount();
    }
    
    /**
     * @param fila
     * @param columna
     * @return el valor de la tabla en esa fila y columna
     */
    public Object getDatos(int fila, int columna){
        return datos.getValueAt(fila, columna);
    }
    
    /**
     * muestra un mensaje de error
     * @param mensage de error
     */
    public void mostrarError(String mensage){
        JOptionPane.showMessageDialog(this.getParent(), mensage);
    }
}
