package ies.tetuan.asc.daoXML;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import es.iestetuan.asc.vo.Alumno;

public class Pruebas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Alumno nuevo = new Alumno();
		
		nuevo.setNia((long)171);
		
		File xml = new File("recursos/alumnos-dam2-nuevos.xml");
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		try {
			db = dbf.newDocumentBuilder();
			Document documento = db.parse(xml);
			
			documento.normalize();
			
			NodeList nodos = documento.getElementsByTagName("alumno");
			
			
			for (int nodo=0;nodo<nodos.getLength();nodo++) {
				
				Node datos = nodos.item(nodo);
				
				Element elemento = (Element)datos;
				
				
				if (nuevo.getNia()==Integer.parseInt(elemento.getAttribute("id"))) {
					System.out.println("el alumno está ya en la lista");
					
				}
				System.out.println(elemento.getAttribute("id"));
				
			
			
			
			
			
			
			
			}
			
			
			
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
