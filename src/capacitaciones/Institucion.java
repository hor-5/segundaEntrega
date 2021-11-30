package capacitaciones;

import java.util.ArrayList;

public class Institucion {
	
	private String nombre;
	private String email;
	private String telefono;
	private ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
	private ArrayList<Docente> docentes = new ArrayList<Docente>();
	private ArrayList<Curso> cursos = new ArrayList<Curso>();
	private ArrayList<Administrativo> administrativos = new ArrayList<Administrativo>();
	
	public Institucion(){
		
	}
	public Institucion(String nombre, String email, String telefono){
		this.nombre = nombre;
		this.email = email;
		this.telefono = telefono;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public ArrayList<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(Alumno alumno) {		
		alumnos.add(alumno);
	}

	public ArrayList<Docente> getDocentes() {		
		return docentes;
	}

	public void setDocentes(Docente docente) {		
		docentes.add(docente);
	}

	public ArrayList<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(Curso curso) {		
		cursos.add(curso);
	}
	
	public ArrayList<Administrativo> getAdministrativos() {
		return administrativos;
	}

	public void setAdministrativos(Administrativo admin) {		
		administrativos.add(admin);
	}
	public void imprimirCursos(){
		int i = 1;
		for(Curso curso:cursos){	        			
			System.out.println(i +"- "+ curso.getTitulo());
			System.out.println("nivel : "+curso.getDificultad()+".");
			System.out.println("tematica: " + curso.getTematica()+".");
			System.out.println("descripcion: "+ curso.getDescripcion()+".");
			i++;
		}
	}
	
	public void imprimirAlumnos(){
		int i = 1;
		for(Alumno alumno:alumnos){	        			
			System.out.println(i +"- "+ alumno.getNombre() + " " + alumno.getApellido());
			System.out.println("cursos :");
			alumno.imprimirCursos();
			System.out.println("certificados: ");
			alumno.imprimirCertificados();
			System.out.println("contacto: " + alumno.getTelefono() + " " + alumno.getEmail());
			i++;
		}
	}
	
	public void imprimirDocentes(){
		int i = 1;
		for(Docente prof:docentes){	        			
			System.out.println(i +"- "+ prof.getNombre() + " " + prof.getApellido());
			System.out.println("cursos :" );
			prof.imprimirCursos();
			System.out.println("especializacion: " + prof.getEspecializacion());
			System.out.println("contacto: " + prof.getTelefono() + " " + prof.getEmail());
			i++;
		}
	}
	
	public Alumno encontrarAlumno(int id){		
		for(Alumno alumno:alumnos){	   
			if(id == alumno.getId()) {				
				return alumno;				
			}		
	
		}		
		return null;		
	}
	
	public Docente encontrarDocente(int id){		
		for(Docente docente:docentes){	   
			if(id == docente.getId()) {				
				return docente;				
			}		
	
		}		
		return null;
	}
	
	public Administrativo encontrarAdministrativo(int id){		
		for(Administrativo administrativo:administrativos){	   
			if(id == administrativo.getId()) {				
				return administrativo;				
			}		
	
		}		
		return null;
	}
	@Override
	public String toString() {
		return "Institucion [nombre=" + nombre + ", email=" + email + ", telefono=" + telefono + ", alumnos=" + alumnos
				+ ", docentes=" + docentes + ", cursos=" + cursos + ", administrativos=" + administrativos + "]";
	}




	
	

}
