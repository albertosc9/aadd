package ies.tetuan.asc.App;

import java.io.IOException;
import java.util.List;

import es.iestetuan.asc.fichtexto.PersonaDao;
import es.iestetuan.asc.vo.Alumno;
import ies.tetuan.asc.dao.IPersona;
import ies.tetuan.asc.daoXML.AlumnoXML;
import ies.tetuan.asc.daoXML.AlumnoXmls;

public class Aplicativo {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		IPersona a1 = new PersonaDao();
		List<Alumno> alumnos = a1.getAlumnos();
		IPersona alumno1 = new AlumnoXML();
		
		List<Alumno> alumno = alumno1.getAlumnos();
		
		
		
		alumno1.guardarUsuario(alumno);
		
		System.out.println(alumno1.getAlumno(171));
		
		
		
			for (Alumno al : alumno) {
				System.out.println("alumno con nia: "+al.getNia()+" "+al);
			}
		
			//aplicativo para AlumnoXMLs.java
			
			IPersona alumn = new AlumnoXmls();
			
			Alumno a2  = new Alumno();
			a2.setNia((long)171);
			a2.setNombre("Julia");
			a2.setApellido1("Sanz");
			a2.setApellido2("Martín");
			
			
			alumn.altaAlumno(a2);
			
			// 
		//	alumn.borrarAlumno(171);
			
			Alumno a4 = new Alumno();
			a4.setNia((long)171);
			a4.setNombre("juana");
			a4.setApellido1("pepe");
			a4.setApellido2("mimi");
			
			alumn.modificarAlumno(a4);
	}
	
	


	
}
