package capacitaciones;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Certificado {
	
	private Alumno alumno;
	private Curso curso;
	private String fechaEmision;
	
	public Certificado(){
		
	}
	
	public Certificado(Alumno alumno, Curso curso) {		
		this.alumno = alumno;
		this.curso = curso;
		try {
		 DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	     Calendar cal = Calendar.getInstance();
	     Date date = cal.getTime();
	     String todaysDate = dateFormat.format(date);   	 
	      
		this.fechaEmision = todaysDate;
		}catch(Exception e) {
			System.out.println(e);
		}		
		
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public String getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(String fechaEmision) {		
		this.fechaEmision = fechaEmision;
	}
	
	public void imprimirCertificado() {
		System.out.println("Certificamos que el alumno " + alumno.getNombre() +" " + alumno.getApellido()+".");
		System.out.println("Finalizó exitosamente el curso de "+ curso.getTitulo()+ " nivel "+ curso.getDificultad() );
		System.out.println("el dia " + fechaEmision);
	}

	@Override
	public String toString() {
		return "Certificado [alumno=" + alumno + ", curso=" + curso + ", fechaEmision=" + fechaEmision + "]";
	}
	
	
	
	

}
