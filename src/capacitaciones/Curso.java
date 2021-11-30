package capacitaciones;

public class Curso {
	
	private String titulo;	
	private String dificultad;
	private String tematica;
	private String descripcion;
	
	public Curso(){
		
	}	
	
	
	public Curso(String titulo, String dificultad, String tematica, String descripcion) {		
		this.titulo = titulo;		
		this.dificultad = dificultad;
		this.tematica = tematica;
		this.descripcion = descripcion;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getDificultad() {
		return dificultad;
	}

	public void setDificultad(String dificultad) {
		this.dificultad = dificultad;
	}

	public String getTematica() {
		return tematica;
	}

	public void setTematica(String tematica) {
		this.tematica = tematica;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Curso [titulo=" + titulo +", dificultad=" + dificultad + ", tematica="
				+ tematica + ", descripcion=" + descripcion + "]";
	}
	
	

	
}
