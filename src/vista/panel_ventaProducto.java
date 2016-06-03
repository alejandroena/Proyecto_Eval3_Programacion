/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * vista de venta productos
 * @see modelo.modelo_ventaProducto
 * @see controlador.controlador_ventaProducto
 * @author Alejandro Ena Encuentra
 */
public class panel_ventaProducto extends JPanel{
    private JTextArea informacion;
    private JLabel labelCodigo;
    private JLabel labelCantidad;
    private JLabel labelTotal;
    private JTextField txtCodigo;
    private JTextField txtCantidad;
    private JButton btnAñadir;
    private JButton btnVender;
    private JButton btnCancelar;
    
    public panel_ventaProducto(){
        informacion = new JTextArea();
            informacion.setEditable(false);
            informacion.setColumns(40);
        labelCodigo = new JLabel("Codigo");
        labelCantidad = new JLabel("Cantidad");
        txtCodigo = new JTextField();
            txtCodigo.setColumns(10);
        txtCantidad = new JTextField();
            txtCantidad.setColumns(10);
        btnAñadir = new JButton("Añadir");
        btnVender = new JButton("Vender");
        btnCancelar = new JButton("Cancelar");
        labelTotal = new JLabel();
        
        this.setLayout(new BorderLayout());
        
        JPanel info = new JPanel(new BorderLayout());
        info.add(informacion, BorderLayout.CENTER);
        info.add(labelTotal, BorderLayout.SOUTH);
        this.add(info, BorderLayout.WEST);

        JPanel form = new JPanel(new BorderLayout());
        
        JPanel añadir = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        añadir.add(labelCodigo, constraints);
        
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        añadir.add(labelCantidad, constraints);
        
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        añadir.add(txtCodigo, constraints);
        
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        añadir.add(txtCantidad, constraints);
        
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        añadir.add(btnAñadir, constraints);
        
        form.add(añadir, BorderLayout.CENTER);
        
        JPanel botones = new JPanel(new BorderLayout());
        botones.add(btnCancelar, BorderLayout.WEST);
        botones.add(btnVender, BorderLayout.EAST);
        
        form.add(botones, BorderLayout.SOUTH);
        
        this.add(form, BorderLayout.EAST);
    }
    
    /**
     * @return codigo del producto
     */
    public int getTxtCodigo(){
        return Integer.parseInt(txtCodigo.getText());
    }
    
    /**
     * @return cantidad del producto
     */
    public int getTxtCantidad(){
        return Integer.parseInt(txtCantidad.getText());                
    }
    
    /**
     * establece el total de la venta acumulada
     * @param cantidad precio total del nuevo producto
     */
    public void setTotal(float cantidad){
        try{
            String[] total = labelTotal.getText().split(":");
            float n = Float.parseFloat(total[1]);
            labelTotal.setText("Total:"+(n+cantidad));
        } catch(ArrayIndexOutOfBoundsException ex){
            labelTotal.setText("Total:"+cantidad);
        }
    }
    
    /**
     * @args informacion de la venta
     * @param texto a escribir
     */
    public void setInformacion(String texto){
        informacion.setText(informacion.getText()+"\n"+texto);
    }
    
    /**
     * @args borra la informacion del text area
     */
    public void borrarInformacion(){
        informacion.setText("");
        txtCodigo.setText("");
        txtCantidad.setText("");
        labelTotal.setText("");
    }
    
    /**
     * @return el boton
     */
    public JButton getBtnAñadir(){
        return btnAñadir;
    }
    
    /**
     * @return el boton
     */
    public JButton getBtnVender(){
        return btnVender;
    }
    
    /**
     * @return el boton
     */
    public JButton getBtnCancelar(){
        return btnCancelar;
    }
    
    /**
     * @args le asigna comportamiento al boton
     * @param escucharBoton comportamiento del boton
     */
    public void ListenerBoton(ActionListener escucharBoton){
        btnAñadir.addActionListener(escucharBoton);
        btnVender.addActionListener(escucharBoton);
        btnCancelar.addActionListener(escucharBoton);
    }
    
    /**
     * @args muestra un mensage de error
     * @param mensage de error
     */
    public void mostrarAlerta(String mensage){
       JOptionPane.showMessageDialog(this.getParent(), mensage);
    }
            
}
