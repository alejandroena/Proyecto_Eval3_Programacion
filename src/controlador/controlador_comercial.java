/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import alejandroena_proyecto_eval3.AlejandroEna_Proyecto_Eval3;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.conexionBD;
import modelo.modelo_ventaProducto;
import modelo.modelo_visualizarProductos;
import vista.panel_ventaProducto;
import vista.panel_visualizarProductos;
import vista.vista_comercial;

/**
 * controlador del usuario comercial, da comportamiento a esta funcion
 * @see vista.vista_comercial
 * @author Alejandro Ena Encuentra
 */
public class controlador_comercial {
    
    private vista_comercial vista;
    private conexionBD conexionBD;
    private AlejandroEna_Proyecto_Eval3 main;
    private modelo_visualizarProductos mVisualizar;
    private panel_visualizarProductos pVisualizar;
    private controlador_visualizarProductos cVisualizar;
    private modelo_ventaProducto mVenta;
    private panel_ventaProducto pVenta;
    private controlador_ventaProducto cVenta;
    
    /**
     * constructor de la clase
     * @param vista
     * @param conexionBD 
     */
    public controlador_comercial(vista_comercial vista, conexionBD conexionBD){
        this.vista = vista;
        this.conexionBD = conexionBD;
        this.vista.añadirListener(new ComportamientoBoton());
        main = new AlejandroEna_Proyecto_Eval3();
        iniciarTabs();
    }
    
    /**
     * comportamiento de los botones
     */
    public class ComportamientoBoton implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            vista.setVisible(false);
            main.cerrarSesion();
        }
    }
    
    /**
     * distintas funciones disponibles para el comercial
     * @see controlador.controlador_visualizarProductos
     * @see controlador.controlador_ventaProducto
     */
    public void iniciarTabs(){
        mVisualizar = new modelo_visualizarProductos();
        pVisualizar = new panel_visualizarProductos();
        cVisualizar = new controlador_visualizarProductos(pVisualizar, mVisualizar, conexionBD);
        this.vista.tabVisualizar(pVisualizar);
        
        mVenta = new modelo_ventaProducto();
        pVenta = new panel_ventaProducto();
        cVenta = new controlador_ventaProducto(pVenta, mVenta, conexionBD);
        this.vista.tabVender(pVenta);
    }
}
