/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import modelo.Articulo;
import modelo.manejoXML;
import vista.vista_exportarXML;

/**
 * controlador de la funcion exportar xml, da comportamiento a esta funcion
 * @see modelo.manejoXML
 * @see vista.vista_exportarXML
 * @author Alejandro Ena Encuentra
 */
public class controlador_exportarXML {
    private vista_exportarXML vista;
    private manejoXML manejo;
    private Articulo[] articulos;
    
    /**
     * constructor de la clase
     * @param vista
     * @param manejo
     * @param articulos 
     */
    public controlador_exportarXML(vista_exportarXML vista, manejoXML manejo, Articulo[] articulos){
        this.vista = vista;
        this.manejo = manejo;
        this.articulos = articulos;
        this.vista.ListenerBoton(new ComportamientoBotones());
    }
    
    /**
     * comportamiento de los botones
     */
    public class ComportamientoBotones implements ActionListener{
        String nombre, ruta;
        JFileChooser fc;
        @Override
        public void actionPerformed(ActionEvent e) {
            Object obj = e.getSource();
            nombre = vista.getTxtNombre();
            ruta = vista.getTxtRuta();
            
            if(obj.equals(vista.getBtnCancelar())){
                vista.setVisible(false);
            }
            else if(obj.equals(vista.getBtnAceptar())){
                if(nombre.equals("")){
                    vista.setLabelError("Falta el nombre del archivo");
                }
                else if(ruta.equals("")){
                    vista.setLabelError("Falta la ruta del archivo");
                }
                else{
                    try {
                        manejo.crearXML(articulos, nombre, ruta);
                        vista.setVisible(false);
                    } catch (IOException ex) {
                        vista.setLabelError("no se ha encontrado la ruta");
                    }
                }
            }
            else if(obj.equals(vista.getBtnExaminar())){
                fc = new JFileChooser();
                fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                
                int respuesta = fc.showSaveDialog(vista);
                if (respuesta == JFileChooser.APPROVE_OPTION) {
                    File file = fc.getSelectedFile();
                    vista.setTxtRuta(file.getAbsolutePath());
                }
            }     
        }
    }
}
