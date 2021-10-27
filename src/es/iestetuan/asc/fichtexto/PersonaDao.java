package es.iestetuan.asc.fichtexto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import es.iestetuan.asc.vo.Alumno;
import ies.tetuan.asc.dao.IPersona;

public class PersonaDao implements IPersona {

	@Override
	public Alumno getAlumno(long nia) {
		// TODO Auto-generated method stub
		FileReader fr = null;
		try {
			fr = new FileReader("C:\\Users\\User\\Desktop\\aadd\\recursos\\alumnos-dam2-nuevos.txt",Charset.forName("UTF-8"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader br = new BufferedReader(fr);
		String linea;
		Alumno nuevo =  new Alumno();
		boolean primera =true;
		try {
			while ((linea=br.readLine())!=null) {
				if (primera) {
					primera=false;
				}else {
					String [] partes = linea.split(",");
					int id = Integer.parseInt(partes[0]);
					if (nia==id) {
						if (linea.length()==3) {
							nuevo.setNia(nia);
							nuevo.setNombre(partes[1]);
							nuevo.setApellido1(partes[2]);
							break;
						}else {
							nuevo.setNia(nia);
							nuevo.setNombre(partes[1]);
							nuevo.setApellido1(partes[2]);
							nuevo.setApellido2(partes[3]);
							break;
						}
						
						
					}
				}
			}
			br.close();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return nuevo;
	}

	
	public List <Alumno> getAlumnos() {
		// TODO Auto-generated method stub
	
		List <Alumno>alumnos = new ArrayList<Alumno>();
		
		
		
		FileReader fr = null;
		try {
			fr = new FileReader("C:\\\\Users\\\\User\\\\Desktop\\\\aadd\\\\recursos\\\\alumnos-dam2-nuevos.txt",Charset.forName("UTF-8"));
			BufferedReader br = new BufferedReader(fr);
			String linea;
			boolean sig=true;
			
			while ((linea=br.readLine())!=null) {
			String[]partes = linea.split(",");
			if (sig) {
				sig=false;
			}else if(partes.length==3){
				Alumno a1 = new Alumno();
				a1.setApellido1(partes[2]);
				a1.setNombre(partes[1]);
				alumnos.add(a1);
				
			}else {
				Alumno a1 = new Alumno();
				a1.setApellido1(partes[2]);
				a1.setNombre(partes[1]);
				a1.setApellido2(partes[3]);
				alumnos.add(a1);
			}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		return alumnos;
	}


	@Override
	public void guardarUsuario(List<Alumno> lista) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void altaAlumno(Alumno alumno) {
		// TODO Auto-generated method stub
		
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
