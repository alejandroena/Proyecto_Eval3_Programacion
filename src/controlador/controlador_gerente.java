/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import alejandroena_proyecto_eval3.AlejandroEna_Proyecto_Eval3;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import modelo.conexionBD;
import modelo.modelo_altaProducto;
import modelo.modelo_añadirUsuario;
import modelo.modelo_bajaProducto;
import modelo.modelo_importarArchivo;
import modelo.modelo_modificarProductos;
import modelo.modelo_ventaProducto;
import modelo.modelo_visualizarProductos;
import modelo.modelo_visualizarVentas;
import vista.panel_altaProductos;
import vista.panel_bajaProductos;
import vista.panel_modificarProductos;
import vista.panel_ventaProducto;
import vista.panel_visualizarProductos;
import vista.panel_visualizarVentas;
import vista.vista_añadirUsuario;
import vista.vista_gerente;

/**
 * controlador del empleado gerente, da comportamiento a esta funcion
 * @see vista.vista_gerente
 * @author Alejandro Ena Encuentra
 */
public class controlador_gerente {
    private vista_gerente vista;
    private conexionBD conexionBD;
    private vista_añadirUsuario vAñadir;
    private modelo_añadirUsuario mAñadir;
    private controlador_añadirUsuario cAñadir;
    
    private modelo_altaProducto mAlta;
    private panel_altaProductos pAlta;
    private controlador_altaProducto cAlta;
    private modelo_bajaProducto mBaja;
    private panel_bajaProductos pBaja;
    private controlador_bajaProducto cBaja;
    private modelo_visualizarVentas mVentas;
    private panel_visualizarVentas pVentas;
    private controlador_visualizarVentas cVentas;
    private modelo_modificarProductos mModificar;
    private panel_modificarProductos pModificar;
    private controlador_modificarProductos cModificar;
    private AlejandroEna_Proyecto_Eval3 main;
    private modelo_visualizarProductos mVisualizar;
    private panel_visualizarProductos pVisualizar;
    private controlador_visualizarProductos cVisualizar;
    private modelo_ventaProducto mVenta;
    private panel_ventaProducto pVenta;
    private controlador_ventaProducto cVenta;
    private modelo_importarArchivo mImportar;
    
    /**
     * constructor de la clase
     * @param vista
     * @param conexionBD 
     */
    public controlador_gerente(vista_gerente vista, conexionBD conexionBD){
        this.vista = vista;
        this.conexionBD = conexionBD;
        this.vista.añadirListener(new ComportamientoBoton());
        main = new AlejandroEna_Proyecto_Eval3();
        iniciarTabs();
    }
    
    /**
     * comportamiento de los botones
     * @see controlador.controlador_añadirUsuario
     * @see modelo.modelo_importarArchivo
     */
    public class ComportamientoBoton implements ActionListener{
        
        public void actionPerformed(ActionEvent e) {
            Object obj = e.getSource();
            if(obj.equals(vista.getBtnSalir())){
                vista.setVisible(false);
                main.cerrarSesion();
            }
            else if(obj.equals(vista.getBtnCrear())){
                vAñadir = new vista_añadirUsuario();
                mAñadir = new modelo_añadirUsuario();
                cAñadir = new controlador_añadirUsuario(vAñadir, mAñadir, conexionBD);
                vAñadir.setVisible(true);
            }
            else if(obj.equals(vista.getBtnImportar())){
                JFileChooser fc = new JFileChooser();
                fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
                
                int respuesta = fc.showSaveDialog(vista);
                if (respuesta == JFileChooser.APPROVE_OPTION) {
                    File file = fc.getSelectedFile();
                    mImportar = new modelo_importarArchivo();
                    try {
                        mImportar.añadirArticulo(file, conexionBD);
                        vista.mostrarAlerta("Atchivo importado");
                    } catch (ClassNotFoundException | SQLException ex) {
                        vista.mostrarAlerta("Error al importar el archivo");
                    } catch (IOException ex) {
                        vista.mostrarAlerta("Error al leer el archivo");
                    } catch(NumberFormatException ex){
                        vista.mostrarAlerta("El archivo no cumple la estructura requerida");
                    }
                }
            }
        }
    }
    
    /**
     * crea las distintas funciones del gerente
     * @see controlador.controlador_visualizarProductos
     * @see controlador.controlador_ventaProducto
     * @see controlador.controlador_altaProducto
     * @see controlador.controlador_bajaProducto
     * @see controlador.controlador_visualizarVentas
     * @see controlador.controlador_modificarProductos
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
        
        mAlta = new modelo_altaProducto();
        pAlta = new panel_altaProductos();
        cAlta = new controlador_altaProducto(pAlta, mAlta, conexionBD);
        this.vista.tabAlta(pAlta);
        
        mBaja = new modelo_bajaProducto();
        pBaja = new panel_bajaProductos();
        cBaja = new controlador_bajaProducto(pBaja, mBaja, conexionBD);
        this.vista.tabBaja(pBaja);
        
        mVentas = new modelo_visualizarVentas();
        pVentas = new panel_visualizarVentas();
        cVentas = new controlador_visualizarVentas(mVentas, pVentas, conexionBD);
        this.vista.tabVentas(pVentas);
        
        mModificar = new modelo_modificarProductos();
        pModificar = new panel_modificarProductos();
        cModificar = new controlador_modificarProductos(mModificar, pModificar, conexionBD);
        this.vista.tabModificar(pModificar);
    }
}
