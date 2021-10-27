package actividad2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;











public class Director {

	static String ruta = "recursos//info-config.properties";
			
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		
		try {
			File xml = new File("recursos//info-conf.xml");
			
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuild = dbf.newDocumentBuilder();
			Document doc = dBuild.parse(xml);
			
			
			//lee elementos 
		
			NodeList nodos =	 doc.getElementsByTagName("rutas");
			
			for (int i=0;i<nodos.getLength();i++) {
				
				Node items = nodos.item(i);
				Element elemento = (Element) items;
				
				
				System.out.println(elemento.getElementsByTagName("ruta").item(i).getTextContent());
			}
			
			
			
			
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		

	
		
		
		
		Director dr = new Director();
		
		dr.Crear("ruta1");
		dr.Crear("ruta2");
		dr.Crear("ruta3");
		dr.Crear("ruta4");
		dr.Crear("ruta5");
		dr.Crear("ruta6");
		dr.Crear("ruta7");
		dr.Crear("ruta8");
		
		dir("C:\\DAM2\\AccesoDatos\\Ficheros\\00-tmp");
		borrar("C:\\DAM2\\AccesoDatos\\Ficheros\\00-tmp");
		xml();
		manejarGSON();
	}
	
	
	private void Crear(String clave) throws IOException {
		Properties prop = new Properties();
		InputStream input = null;
			
			
			input = new FileInputStream(ruta);
			
			prop.load(input);
			
			Path path = Paths.get(prop.getProperty(clave));
			if (!Files.exists(path)){
				Files.createDirectories(path);
			}else {
				System.out.println("existe");
			}
			
			
		
	}
	private static void dir(String ruta) throws IOException {
		
		String [] arch;
		
		File f = new File(ruta);
		
		arch = f.list();
		
		
		for (String archi : arch) {
			
			FileWriter fw = new FileWriter(ruta+"//"+archi.concat("//info-temporal.txt"));
			
		}
		
		
		
	}
	private static void borrar(String ruta) {
		File f = new File(ruta);
		File [] fs = f.listFiles();
		
		for (File direct : fs) {
			direct.delete();
				
			}
		}
	public static void leer(String ruta) throws IOException {
		
		File f = new File(ruta);
		String sfichero = "";
		
		 sfichero = new String(Files.readAllBytes(f.toPath()));
		
		
	}
	private static void xml() {
		try {
			File xml = new File("recursos//info-conf.xml");
			
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuild = dbf.newDocumentBuilder();
			Document doc = (Document) dBuild.parse(xml);
			
			
			//lee elementos 
		
			NodeList nodos =	 ((org.w3c.dom.Document) doc).getElementsByTagName("rutas");
			
			for (int i=0;i<nodos.getLength();i++) {
				Node items = nodos.item(i);
				Element elemento = (Element) items;
				
				System.out.println(elemento.getElementsByTagName(ruta));
			}
			
			
			
			
			
		}catch (Exception e) {
			
		}
		
	}
	public static void manejarGSON() {
		File fichero = new File("recursos/info-config.json");
		String sFichero = "";
		
		try {
			sFichero = new String(Files.readAllBytes(fichero.toPath()));
			
			JsonObject propiedades = JsonParser.parseString(sFichero).getAsJsonObject();
			String ruta1=propiedades.get("ruta1").getAsString();
			Files.createDirectories(Paths.get(ruta1));
			
			
			String ruta2=propiedades.get("ruta2").getAsString();
			
			
					
					
					
					
					
			
			
		}catch(Exception e) {
			
		}
	}
	}

