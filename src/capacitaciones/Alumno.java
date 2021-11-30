package capacitaciones;

import java.util.ArrayList;

public class Alumno extends Usuario {
	
	private ArrayList<Certificado> certificados;
	private ArrayList<Curso> cursos = new ArrayList<Curso>();
	
	public Alumno() {
		
	}
	
	
	public Alumno(int id, String nombre_usuario, String email, int telefono, String clave, String nombre,
			String apellido) {
		super(id, nombre_usuario, email, telefono, clave,nombre,apellido);

				
	}

	public Alumno(int id, String nombre_usuario, String email, int telefono, String clave, String nombre,
			String apellido, ArrayList<Curso> cursos,ArrayList<Certificado> certificados) {
		super(id, nombre_usuario, email, telefono, clave,nombre,apellido);
	
		this.cursos = cursos;
		this.certificados = certificados;
	}
	
	@Override
	public void accion(int index) {
		Curso curso = getCursos().get(index-1);
		System.out.println("Cursando " + curso.getTitulo()+".");
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("\nClase finalizada.");
		
	}

	public void agregarCertificado(Certificado c){		
		certificados.add(c);
	}	
	
	public ArrayList<Certificado> getCertificados() {
		return certificados;
	}
	
	public void setCertificados(ArrayList<Certificado> certificados) {
		this.certificados = certificados;
	}
	


	public void agregarCurso(Curso c){		
		cursos.add(c);
	}	


	public ArrayList<Curso> getCursos() {
		return cursos;
	}


	public void setCursos(ArrayList<Curso> cursos) {
		this.cursos = cursos;
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
	
	public void imprimirCertificados(){
		int i = 1;
		for(Certificado certificado:certificados){	        			
			System.out.println(i +"- "+ certificado.getCurso().getTitulo());
			System.out.println( certificado.getAlumno().getNombre()+ " " + certificado.getAlumno().getApellido()+"."+ "Finalizó con exito el curso de " + certificado.getCurso().getTitulo());
			
			System.out.println("de nivel "+certificado.getCurso().getDificultad()+ " el dia  "+ certificado.getFechaEmision() +".");			
			
			i++;
		}
	}
	
	public Curso encontrarCurso(int index){
		Curso c = cursos.get(index);
		return c;
	}
	

	@Override
	public String toString() {
		return "Alumno [certificados=" + certificados + ", cursos=" + cursos + ", id=" + id + ", nombre_usuario="
				+ nombre_usuario + ", email=" + email + ", telefono=" + telefono + ", clave=" + clave + ", nombre="
				+ nombre + ", apellido=" + apellido + "]";
	}




		

	

	
	
	
}
