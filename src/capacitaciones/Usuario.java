package capacitaciones;



public abstract class Usuario {
	
	protected int id;
	protected String nombre_usuario;
	protected String email;
	protected int telefono;
	protected String clave;
	protected String nombre;
	protected String apellido;
	
	
	
	public Usuario() {
		
	}
	public Usuario(int id, String nombre_usuario, String clave){
		this.id=id;
		this.nombre_usuario = nombre_usuario;
		this.clave = clave;
	}
	
	public Usuario(int id, String nombre_usuario, String email, int telefono, String clave,String nombre,
			String apellido) {		
		this.id = id;
		this.nombre_usuario = nombre_usuario;
		this.email = email;
		this.telefono = telefono;
		this.clave = clave;
		this.nombre = nombre;
		this.apellido = apellido;
	}
	
	public abstract void accion(int index);
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre_usuario() {
		return nombre_usuario;
	}
	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre_usuario=" + nombre_usuario + ", email=" + email + ", telefono="
				+ telefono + ", clave=" + clave + ", nombre=" + nombre + ", apellido=" + apellido + "]";
	}

	
	
	

}
