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
import modelo.conexionBD;
import modelo.modelo_visualizarVentas;
import vista.panel_visualizarVentas;

/**
 *
 * @author Alejandro
 */
public class controlador_visualizarVentas {
    private modelo_visualizarVentas modelo;
    private panel_visualizarVentas vista;
    private conexionBD conexionBD;
    
    public controlador_visualizarVentas(modelo_visualizarVentas modelo, panel_visualizarVentas vista, conexionBD conexionBD){
        this.modelo = modelo;
        this.vista = vista;
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
        ResultSet rs;
        String fechaInicio, fechaFinal;
        
        @Override
        public void actionPerformed(ActionEvent e) {
            
                try {
                    codigo = vista.getTxtCodigo();
                    familia = vista.getTxtFamilia();
                    fechaInicio = vista.getFechaInicial();
                    fechaFinal = vista.getFechaFinal();

                    if(fechaInicio.equals("") | fechaFinal.equals("")){
                        vista.mostrarError("No has seleccionado las fechas");
                    }else{
                        conexionBD.abrirConexion();
                        vista.borrarTabla();
                        rs = modelo.cogerDatos(codigo, familia, fechaInicio, fechaFinal, conexionBD);
                        crearTabla();
                        conexionBD.cerrarConexion();
                    }
                    
                } catch (SQLException | ClassNotFoundException ex) {
                    vista.mostrarError("No se ha podido contactar con la base de datos");
                } catch (NumberFormatException ex){
                    vista.mostrarError("El codigo debe ser un numero");
                }
            }

        public void crearTabla() throws SQLException{

            Object datos[] = new Object[6];
            
            while(rs.next()){
                for(int i=0; i<6; i++){
                    datos[i] = rs.getObject(i+1);
                }
                vista.actualizarTabla(datos);
            }
            rs.close();
        }
    }
}
