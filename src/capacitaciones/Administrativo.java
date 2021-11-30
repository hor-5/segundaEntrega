package capacitaciones;

public class Administrativo extends Usuario{	

	
	public Administrativo(){
		
	}
	
	public Administrativo(int id, String nombre_usuario,String clave){
		super(id, nombre_usuario, clave);
	}	
	
	public Administrativo(int id, String nombre_usuario, String email, int telefono, String clave, String nombre,
			String apellido) {
		super(id, nombre_usuario, email, telefono, clave,nombre,apellido);
	}
	
	@Override
	public void accion(int index) {		
		System.out.println("Revisando tramites y papeles...");
		try {
			Thread.sleep(1000);
			System.out.println("\n...");
			Thread.sleep(1700);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("\nTodo en orden.");
	}

	@Override
	public String toString() {
		return "Administrativo [nombre=" + nombre + ", apellido=" + apellido + ", id=" + id + ", nombre_usuario="
				+ nombre_usuario + ", email=" + email + ", telefono=" + telefono + ", clave=" + clave + "]";
	}
	
	
	
	
}
