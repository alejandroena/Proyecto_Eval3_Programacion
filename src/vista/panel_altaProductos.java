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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * vista de alta productos
 * @see modelo.modelo_altaProducto
 * @see controlador.controlador_altaProducto
 * @author Alejandro Ena Encuentra
 */
public class panel_altaProductos extends JPanel{
    private JLabel labelNombre;
    private JLabel labelFamilia;
    private JLabel labelStock;
    private JLabel labelPrecio;
    private JTextField txtNombre;
    private JTextField txtFamilia;
    private JTextField txtStock;
    private JTextField txtPrecio;
    private JButton btnCancelar;
    private JButton btnAñadir;
    
    
    public panel_altaProductos(){
        labelNombre = new JLabel("Nombre: ");
        labelFamilia = new JLabel("Familia: ");
        labelStock = new JLabel("Cantidad: ");
        labelPrecio = new JLabel("Precio: ");
        txtNombre = new JTextField();
            txtNombre.setColumns(10);
        txtFamilia = new JTextField();
            txtFamilia.setColumns(10);
        txtStock = new JTextField();
            txtStock.setColumns(10);
        txtPrecio = new JTextField();
            txtPrecio.setColumns(10);
        btnAñadir = new JButton("Añadir");
        btnCancelar = new JButton("Cancelar");
        
        this.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        //spring layout
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        this.add(labelNombre, constraints);
        
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        this.add(txtNombre, constraints);
        
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        this.add(labelFamilia, constraints);
        
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        this.add(txtFamilia, constraints);
        
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        this.add(labelStock, constraints);
        
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        this.add(txtStock, constraints);
        
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        this.add(labelPrecio, constraints);
        
        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        this.add(txtPrecio, constraints);
        
        constraints.gridx = 1;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        this.add(btnAñadir, constraints);
        
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        this.add(btnCancelar, constraints);
    }
    /**
     * @return el nombre del producto
     */
    public String getTxtNombre(){
        return txtNombre.getText();
    }
    
    /**
     * @return la familia del producto
     */
    public String getTxtFamilia(){
        return txtFamilia.getText();
    }
    
    /**
     * @return la cantidad del producto
     */
    public int getTxtStock(){
        if(txtStock.getText().equals("")){
            return 0;
        }else{
            return Integer.parseInt(txtStock.getText());
        }
    }
    
    /**
     * @return el precio del producto
     */
    public float getTxtPrecio(){
        if(txtPrecio.getText().equals("")){
            return 0;
        }else{
            String[] numeros = txtPrecio.getText().split(",");
            if(numeros.length>0){
                String precio = (numeros[0]+"."+numeros[1]);
                return Float.parseFloat(precio);
            }else{
                return Float.parseFloat(txtPrecio.getText());
            }    
        }
    }
    
    /**
     * borra los datos de los textField
     */
    public void borrarDatos(){
        txtNombre.setText("");
        txtFamilia.setText("");
        txtStock.setText("");
        txtPrecio.setText("");
    }
    
    /**
     * @return el boton añadir
     */
    public JButton getBtnAñadir(){
        return btnAñadir;
    }
    
    /**
     * @return el boton cancelar
     */
    public JButton getBtnCancelar(){
        return btnCancelar;
    }
    
    /**
     * @args añade comportamiento al boton
     * @param escucharBoton comportamiento del boton
     */
    public void ListenerBoton(ActionListener escucharBoton){
        btnAñadir.addActionListener(escucharBoton);
        btnCancelar.addActionListener(escucharBoton);
    }
    /**
     * @args muestra una alerta
     * @param mensage de alerta
     */
    public void mostrarAlerta(String mensage){
       JOptionPane.showMessageDialog(this.getParent(), mensage);
    }
}
