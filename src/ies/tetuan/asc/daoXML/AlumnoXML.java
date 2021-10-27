package ies.tetuan.asc.daoXML;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

import es.iestetuan.asc.vo.Alumno;
import ies.tetuan.asc.dao.IPersona;

public class AlumnoXML implements IPersona {

	

	public Alumno getAlumno(long nia) throws IOException {
		
		File xml = new File("recursos/alumnos-dam2-nuevos.xml");
		
		Alumno alumno = new Alumno();
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newDefaultInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document documento = db.parse(xml);
			
			documento.getDocumentElement().normalize();
			
			NodeList nodos = documento.getElementsByTagName("alumno");
			
			
			for (int i=0;i<nodos.getLength();i++) {
				Node nodo = nodos.item(i);
				
				
				
				Element elemento = (Element) nodo;
					
				long id = Long.parseLong(elemento.getAttribute("id"));
				
				
				if (id==nia) {
					
					alumno.setNombre(elemento.getElementsByTagName("nombre").item(0).getTextContent());
					alumno.setApellido1(elemento.getElementsByTagName("apellido1").item(0).getTextContent());
					alumno.setApellido2(elemento.getElementsByTagName("apellido2").item(0).getTextContent());
					break;
				
					}
				}
			
			
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		return alumno;
	}

	public List<Alumno> getAlumnos() {
		
		List<Alumno> lista = new ArrayList<Alumno>();
		
		File xml = new File("recursos/alumnos-dam2-nuevos.xml");
	
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newDefaultInstance();
			DocumentBuilder db;
			
			
			try {
				db = dbf.newDocumentBuilder();
			
			Document documento;
			
				documento = db.parse(xml);
			
			
		NodeList nodos =	 documento.getElementsByTagName("alumno");
			
			
			for (int i=0;i<nodos.getLength();i++) {
				Alumno alumno = new Alumno();
				Node nodo = nodos.item(i);
				Element elemento = (Element)nodo;
				
			
				
				alumno.setNia(Long.parseLong(elemento.getAttribute("id")));
				alumno.setNombre(elemento.getElementsByTagName("nombre").item(0).getTextContent());
				alumno.setApellido1(elemento.getElementsByTagName("apellido1").item(0).getTextContent());
				alumno.setApellido2(elemento.getElementsByTagName("apellido2").item(0).getTextContent());
				
				lista.add(alumno);
			}
			
			
			
			
			} catch (SAXException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		

		return lista;
	}

	@Override
	public void guardarUsuario(List<Alumno> lista) {

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			
			DOMImplementation domImp = db.getDOMImplementation();
			Document documento = domImp.createDocument(null, "xml", null);
			
			
			Element raiz = null; Element hijo=null; Element dato = null;
			Attr id;
			Text texto; 
			
			
			raiz = documento.createElement("alumnos");
			documento.getDocumentElement().appendChild(raiz);
			
			for (Alumno al : lista) {
				
				
				hijo = documento.createElement("alumno");
				raiz.appendChild(hijo);
				
				//crear atributo
				String ids = String.valueOf(al.getNia().toString());
				id = documento.createAttribute("nia");
				hijo.setAttributeNode(id);
				id.setTextContent(ids);
				
				//hijos de alumno
				
				dato = documento.createElement("nombre");
				hijo.appendChild(dato);
				texto = documento.createTextNode(al.getNombre());
				dato.appendChild(texto);
				
				dato = documento.createElement("apellido1");
				hijo.appendChild(dato);
				texto = documento.createTextNode(al.getApellido1());
				dato.appendChild(texto);
				
				dato = documento.createElement("apellido2");
				hijo.appendChild(dato);
				texto = documento.createTextNode(al.getApellido2());
				dato.appendChild(texto);
				
				
			
				
				
				
			}
			
			
			
			Properties prop = new Properties();
			
			InputStream input = new FileInputStream("recursos/rutas.properties");
			
			prop.load(input);
			 
			
				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				  Transformer transformer;
				transformer = transformerFactory.newTransformer();
				 DOMSource source = new DOMSource(documento);
				  StreamResult result = new StreamResult(new File(prop.getProperty("destino")));
				  transformer.transform(source, result);

			} catch (TransformerConfigurationException e) {
				
				e.printStackTrace();
			
			 
			  
				
			} catch (TransformerException e) {
				
				e.printStackTrace();
			}
			
			 catch (ParserConfigurationException e) {
			
			e.printStackTrace();
		} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void altaAlumno(Alumno alumno) {
	
		
		
	}

	@Override
	public void borrarAlumno(int nia) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarAlumno(Alumno alumno) {
		// TODO Auto-generated method stub
		
	}



	
	
}
