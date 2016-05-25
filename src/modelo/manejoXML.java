/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;



/**
 *
 * @author Alumno
 */
public class manejoXML {
    
    public void crearXML(Articulo[] lista){
        //try{
            Element articulos = new Element("Articulos");
            Document doc = new Document(articulos);
            
            for(int i=0;i<lista.length;i++){
                Element articulo = new Element("articulo");
                Attribute atributo = new Attribute("codigo", Integer.toString(lista[i].getCodigo()));
                articulo.setAttribute(atributo);
                
                Element nombre = new Element("nombre");
                nombre.setText(lista[i].getNombre());
                
                Element familia = new Element("familia");
                familia.setText(lista[i].getFamilia());
                
                Element precio = new Element("precio");
                precio.setText(Float.toString(lista[i].getPrecio()));
            }
       // }
    }
}
