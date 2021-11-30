package capacitaciones;

import java.util.ArrayList;

public class Docente extends Usuario {
	

	private String especializacion;
	private ArrayList<Curso> cursos = new ArrayList<Curso>();
	
	public Docente(){
		
	}	


	public Docente(int id, String nombre_usuario, String email, int telefono, String clave, String nombre,
			String apellido, String especializacion) {
		super(id, nombre_usuario, email, telefono, clave,nombre,apellido);

		this.especializacion = especializacion;	
	}



	public Docente(int id, String nombre_usuario, String email, int telefono, String clave, String nombre,
			String apellido, String especializacion, ArrayList<Curso> cursos) {
		super(id, nombre_usuario, email, telefono, clave,nombre,apellido);
		this.especializacion = especializacion;
		this.cursos = cursos;
	}

	
	@Override
	public void accion(int index) {
		Curso curso = getCursos().get(index-1);
		System.out.println("Dando clases de " + curso.getTitulo()+".");
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("\nClase finalizada.");
		
	}
	
	public String getEspecializacion() {
		return especializacion;
	}

	public void setEspecializacion(String especializacion) {
		this.especializacion = especializacion;
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
		if(!cursos.isEmpty()) {
		for(Curso curso:cursos){	        			
			System.out.println(i +"- "+ curso.getTitulo());
			System.out.println("nivel : "+curso.getDificultad()+".");
			System.out.println("tematica: " + curso.getTematica()+".");
			System.out.println("descripcion: "+ curso.getDescripcion()+".");
			i++;
		}
		}else {
			System.out.println("No está inscripto a ningún curso.");
		}
	}

	@Override
	public String toString() {
		return "Docente [especializacion=" + especializacion + ", cursos=" + cursos + ", id=" + id + ", nombre_usuario="
				+ nombre_usuario + ", email=" + email + ", telefono=" + telefono + ", clave=" + clave + ", nombre="
				+ nombre + ", apellido=" + apellido + "]";
	}


	
	
	
	
}
