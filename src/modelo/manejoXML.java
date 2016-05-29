/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.FileWriter;
import java.io.IOException;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;



/**
 *
 * @author Alumno
 */
public class manejoXML {
    
    public void crearXML(Articulo[] lista, String arNom, String ruta) throws IOException{
        try{
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
                
                Element cantidad = new Element("cantidad");
                cantidad.setText(Integer.toString(lista[i].getCantidad()));
                
                articulo.addContent(nombre);
                articulo.addContent(familia);
                articulo.addContent(precio);
                articulo.addContent(cantidad);
                
                doc.getRootElement().addContent(articulo);
            }
            
            XMLOutputter xmloutput = new XMLOutputter();
            
            xmloutput.setFormat(Format.getPrettyFormat());
            xmloutput.output(doc, new FileWriter(ruta+"\\"+arNom+".xml"));
        } catch (IOException ex) {
           throw ex;
        }
    }
}
