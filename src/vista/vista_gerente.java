/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;



/**
 *
 * @author Alumno
 */
public class vista_gerente extends JFrame{
    JButton btnSalir;
    JButton btnCrear;
    JButton btnImportar;
    ImageIcon imgSalir;
    ImageIcon imgCrear;
    ImageIcon imgImportar;
    JTabbedPane contenido;
    
    public vista_gerente(){
        this.setTitle("Gerente - Proyecto Eval3");
        this.setBounds(700, 450, 800, 500);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        
        imgSalir = new ImageIcon("src/libreria/img_desconectar.jpg");
        btnSalir = new JButton(imgSalir);
            btnSalir.setBackground(Color.WHITE);
        imgCrear = new ImageIcon("src/libreria/img_añadir_usuario.png");
        btnCrear = new JButton(imgCrear);
            btnCrear.setBackground(Color.WHITE);
        imgImportar = new ImageIcon("src/libreria/img_importar_datos.png");
        btnImportar = new JButton(imgImportar);
            btnImportar.setBackground(Color.WHITE);
        contenido = new JTabbedPane();
        
        this.getContentPane().setLayout(new BorderLayout());
        
        JPanel menu = new JPanel(new BorderLayout());
        
        JPanel botones = new JPanel(new GridLayout(1,3));
        botones.add(btnImportar);
        botones.add(btnCrear);
        botones.add(btnSalir);
        
        menu.add(botones, BorderLayout.EAST);
        this.getContentPane().add(menu, BorderLayout.NORTH);

        this.getContentPane().add(contenido, BorderLayout.CENTER);
    }
    
    /**
     * @args le da comportamiento a los botones
     * @param escucharBoton action listener del boton
     */
    public void añadirListener(ActionListener escucharBoton){
        btnSalir.addActionListener(escucharBoton);
        btnImportar.addActionListener(escucharBoton);
        btnCrear.addActionListener(escucharBoton);
    }
    
    /**
     * @args muestra el mensage de error
     * @param mensage mensage de error
     */
    public void mostrarAlerta(String mensage){
       JOptionPane.showMessageDialog(this, mensage);
    }
    
    public void tabVisualizar(panel_visualizarProductos ver){
        contenido.addTab("Visualizar Productos", ver);
    }
    
    public void tabVender(panel_ventaProducto vender){
        contenido.addTab("Vender Productos", vender);
    }
    
    public void tabAlta(panel_altaProductos alta){
        contenido.addTab("Alta Productos", alta);
    }
    
    public void tabBaja(panel_bajaProductos baja){
        contenido.addTab("Baja Productos", baja);
    }
    
    public void tabVentas(panel_visualizarVentas venta){
        contenido.addTab("Visualizar Ventas", venta);
    }
    
    public void tabModificar(panel_modificarProductos modificar){
        contenido.addTab("Modificar Productos", modificar);
    }
    
    public JButton getBtnImportar(){
        return btnImportar;
    }
    
    public JButton getBtnCrear(){
        return btnCrear;
    }
    
    public JButton getBtnSalir(){
        return btnSalir;
    }
}
