/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Articulo;
import modelo.conexionBD;
import modelo.manejoXML;
import modelo.modelo_visualizarProductos;
import vista.panel_visualizarProductos;
import vista.vista_exportarXML;

/**
 *
 * @author Alejandro
 */
public class controlador_visualizarProductos {
    private panel_visualizarProductos vista;
    private modelo_visualizarProductos modelo;
    private conexionBD conexionBD;
    
    public controlador_visualizarProductos(panel_visualizarProductos vista, modelo_visualizarProductos modelo, conexionBD conexionBD){
        this.vista = vista;
        this.modelo = modelo;
        this.conexionBD = conexionBD;
        this.vista.ListenerRadio(new ComportamientoRadio());
        this.vista.ListenerBoton(new ComportamientoBoton());
    }
    
    public class ComportamientoRadio implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e) {
            Object obj = e.getSource();
            
            if(obj.equals(vista.getRadioNinguno())){
                vista.setEnableCodigo(false);
                vista.setTxtCodigo();
                vista.setEnableFamilia(false);
                vista.setTxtFamilia();
            }
            else if(obj.equals(vista.getRadioCodigo())){
                vista.setEnableCodigo(true);
                vista.setEnableFamilia(false);
                vista.setTxtFamilia();
            }
            else if(obj.equals(vista.getRadioFamilia())){
                vista.setEnableFamilia(true);
                vista.setEnableCodigo(false);
                vista.setTxtCodigo();
            }
        }
    }
    
    public class ComportamientoBoton implements ActionListener{
        int codigo;
        String familia;
        boolean ordenar;
        ResultSet rs;
        
        @Override
        public void actionPerformed(ActionEvent e) {
            Object obj = e.getSource();
            if(obj.equals(vista.getBtnBuscar())){
                try {
                    codigo = vista.getTxtCodigo();
                    familia = vista.getTxtFamilia();
                    ordenar = vista.getCheckBox().isSelected();
                
                    conexionBD.abrirConexion();
                    vista.borrarTabla();
                    rs = modelo.cogerDatos(codigo, familia, ordenar, conexionBD);
                    crearTabla();
                    conexionBD.cerrarConexion();
                } catch (SQLException | ClassNotFoundException ex) {
                    vista.mostrarError("no se ha podido contactar con la base de datos");
                } catch (NumberFormatException ex){
                    vista.mostrarError("el codigo debe ser un numero");
                }
            }
            else if(obj.equals(vista.getBtnExportar())){
                try {
                    manejoXML manejo = new manejoXML();
                    vista_exportarXML vistaXML = new vista_exportarXML();
                    controlador_exportarXML conXML = new controlador_exportarXML(vistaXML, manejo, cogerArticulos());
                    vistaXML.setVisible(true);
                } catch(NullPointerException ex){
                    vista.mostrarError("No se ha realizado ninguna busqueda");
                }
            }
            
        }
        
        public void crearTabla() throws SQLException{

            Object datos[] = new Object[5];
            
            while(rs.next()){
                for(int i=0; i<5; i++){
                    datos[i] = rs.getObject(i+1);
                }
                vista.actualizarTabla(datos);
            }
            rs.close();
        }
        
        public Articulo[] cogerArticulos(){
            Articulo articulos[] = new Articulo[vista.getFilas()];
            
            for(int i=0;i<vista.getFilas();i++){
                Articulo articulo = new Articulo();
                articulo.setCodigo((int) vista.getDatos(i,0));
                articulo.setNombre((String) vista.getDatos(i,1));
                articulo.setFamilia((String) vista.getDatos(i,2));
                articulo.setCantidad((int) vista.getDatos(i,3));
                articulo.setPrecio((float) vista.getDatos(i,4));
                articulos[i] = articulo;
            }

            return articulos;
        }
    }
}
