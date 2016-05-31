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
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 * @args vista de ventas realizadas
 * @see modelo.modelo_visualizarVentas
 * @see controlador.controlador_visualizarVentas
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
    SimpleDateFormat formateador;
    DefaultTableModel tabla;
    JScrollPane scrollPane;
    
    public panel_visualizarVentas(){
        labelTxt1 = new JLabel("De     ");
        labelTxt2 = new JLabel("a");
        fechaInicial = new JDateChooser();
        fechaFinal = new JDateChooser();
        labelFiltro = new JLabel("Filtros:");
        radioNinguno = new JRadioButton("Ninguno",true);
        radioCodigo = new JRadioButton("Codigo: ",false);
        radioFamilia = new JRadioButton("Familia: ",false);
        grupo = new ButtonGroup();
        txtCodigo = new JTextField();
            txtCodigo.setColumns(10);
            txtCodigo.setEditable(false);
        txtFamilia = new JTextField();
            txtFamilia.setEditable(false);
            txtFamilia.setColumns(10);
        btnBuscar = new JButton("Buscar");
        
        grupo.add(radioNinguno);
        grupo.add(radioCodigo);
        grupo.add(radioFamilia);
        
        formateador = new SimpleDateFormat("yyyy-MM-dd");
        
        String columna[] = new String[]{"Codigo","Nombre","Familia","Cantidad","Precio","Fecha Venta"};
        tabla = new DefaultTableModel(null, columna);
        datos = new JTable(tabla);
            datos.setEnabled(false);
        scrollPane = new JScrollPane(datos);
        
        this.setLayout(new BorderLayout());
        
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
        
        this.add(form, BorderLayout.NORTH);

        this.add(scrollPane, BorderLayout.CENTER);
        
    }
    
    /**
     * @return el codigo del producto
     */
    public int getTxtCodigo(){
        if(txtCodigo.getText().equals("")){
            return 0;
        }else{
            return Integer.parseInt(txtCodigo.getText());
        }
    }
    
    /**
     * @return la familia del producto
     */
    public String getTxtFamilia(){
        return txtFamilia.getText();
    }
    
    /**
     * borra los datos del textField codigo
     */
    public void setTxtCodigo(){
        txtCodigo.setText("");
    }
    
    /**
     * borra lso datos del textField familia
     */
    public void setTxtFamilia(){
        txtFamilia.setText("");
    }
    
    /**
     * borra las filas de la tabla
     */
    public void borrarTabla(){
        tabla.setNumRows(0);
    }
    
    /**
     * añade a la tabla una fila con los datos
     * @param datos 
     */
    public void actualizarTabla(Object datos[]){
        tabla.addRow(datos);
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
     * @return la fecha inicial
     */
    public String getFechaInicial(){
        if(fechaInicial.getDate()!=null){
            return formateador.format(fechaInicial.getDate());
        }else{
            return "";
        }
    }
    
    /**
     * @return la fecha final
     */
    public String getFechaFinal(){
        if(fechaFinal.getDate()!=null){
            return formateador.format(fechaFinal.getDate());
        }else{
            return "";
        }
    }
    
    /**
     * activa o desactiva el textField codigo
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
        txtFamilia.setEditable(enable);
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
        radioNinguno.addActionListener(escucharRadio);
        radioCodigo.addActionListener(escucharRadio);
        radioFamilia.addActionListener(escucharRadio);
    }
    
    /**
     * muestra el mensage de error
     * @param mensage de error
     */
    public void mostrarError(String mensage){
        JOptionPane.showMessageDialog(this.getParent(), mensage);
    }
}
