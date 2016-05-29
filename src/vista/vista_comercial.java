/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.BorderLayout;
import java.awt.Color;
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
public class vista_comercial extends JFrame{
    
    JButton btnSalir;
    ImageIcon imagen;
    JTabbedPane contenido;
    
    public vista_comercial(){
        this.setTitle("Comercial - Proyecto Eval3");
        this.setBounds(700, 450, 600, 400);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        
        imagen = new ImageIcon("src/libreria/img_desconectar.jpg");
        btnSalir = new JButton(imagen);
            btnSalir.setBackground(Color.WHITE);
        contenido = new JTabbedPane();
        
        this.getContentPane().setLayout(new BorderLayout());
        
        JPanel menu = new JPanel(new BorderLayout());
        menu.add(btnSalir, BorderLayout.EAST);
        this.getContentPane().add(menu, BorderLayout.NORTH);

        this.getContentPane().add(contenido, BorderLayout.CENTER);
    }
    
    /**
     * @args le da comportamiento a los botones
     * @param escucharBoton action listener del boton
     */
    public void añadirListener(ActionListener escucharBoton){
        btnSalir.addActionListener(escucharBoton);
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
    
}
