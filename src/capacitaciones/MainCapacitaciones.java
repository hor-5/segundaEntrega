package capacitaciones;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class MainCapacitaciones {

	public static void main(String[] args) {
		
		
		
		
		Institucion inst = new Institucion("Instituto de formacion N°3","instituto3@edu.org","1160451232");
        try{    		
    		Docente seedD = new Docente(20250120,"jperez2021","juanp@gmail.com",114578642,"clave123","Juan","Perez","Arte/diseño");
    		inst.setDocentes(seedD);
    		Curso seedC = new Curso("Fundamentos de programacion", "principiante","programacion","Fundamentos base para el aprendizaje de programacion");
    		Curso seedCurso = new Curso("Ingles", "intermedio","Idioma Ingles"," Adquiri competencias de idioma ingles oral y escrito");
    		Administrativo seedAdmin= new Administrativo(30255478,"alucena","alucena@gmail.com",11425785,"pass","Agustina","Lucena");
    		inst.setAdministrativos(seedAdmin);
    		inst.setCursos(seedC);
    		inst.setCursos(seedCurso);
    		
    		 DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    	     Calendar cal = Calendar.getInstance();
    	     Date date = cal.getTime();    	     
    	     String todaysdate = dateFormat.format(date);    	 
    	     System.out.println(todaysdate);   	     
    	     

        	
    		System.out.println("Creando institucion... "  + inst);
    		System.out.println("Creando docente... " + seedD);    		
    		System.out.println("Creando curso.. " + seedC);
    		System.out.println("Creando administrativo... " + seedAdmin);
    		/*AGREGAR CURSO A DOCENTE*/
    		seedD.agregarCurso(seedC);
    		System.out.println("Docente modificado... " + seedD);
    		System.out.println("\nTodo salió correctamente!");
        }
        catch(StackOverflowError e){
            System.err.println("ouch! algo salió mal");
        }
		
    	boolean finalizar= false;
		while (!finalizar) {
			//INGRESO AL PROGRAMA
	        bienvenida();
	        int opt = pedirInt();
	        while (opt < 1 || opt > 4) {
	        	System.out.println("Ingrese una opción correcta");
	        	bienvenida();
	        	opt = pedirInt();
	        }
	        if(opt == 1) {
	        	//MENU DEL PROFESOR
	        	boolean session = false;
        		System.out.println("\nIngrese su n° de DNI");
        		int dni = pedirInt();
        		Docente profSelec = inst.encontrarDocente(dni);
        		if(profSelec!=null) {
        			System.out.println("Ingrese su usuario");
        			String user = pedirString();
        			if(user.toLowerCase().equals(profSelec.nombre_usuario.toLowerCase())){
        				System.out.println("Ingrese su contraseña");
        				String pass = pedirString();
        				if(pass.equals(profSelec.clave)){
        					System.out.println("LOGUEO EXITOSO!");
        					session = true;
        				}
        			}else {
        				System.out.println("Usuario Incorrecto!");
        			}
        			
	        		while(session){
	    	        	System.out.println("\nBienvenido prof. " + capitalize( profSelec.getNombre() ) + " " + capitalize(profSelec.getApellido())+ " !" );
	    	        	mostrarMenuProf();
	    	        	int opcion = pedirInt();
	    	        	if(opcion == 1) {
	    	        		System.out.println("Sus cursos son:");
	    	        		profSelec.imprimirCursos();
	    	        		System.out.println("¿Desea dar clases de alguno de los cursos?");
	    	        		System.out.println("1-si 2-no");
	    	        		int o = pedirInt();
	    	        		while(o>2){
	    	        			System.out.println("Ingrese una opción correcta!");
		    	        		System.out.println("¿Desea dar clases de alguno de los cursos?");
		    	        		System.out.println("1-si 2-no");
		    	        		o = pedirInt();
	    	        		}
	    	        		if(o == 1) {
	    	        			System.out.println("Ingrese el numero del curso");
	    	        			int cur = pedirInt();
								while(cur>inst.getCursos().size()){
									System.out.println("Ingrese una opción correcta");
									cur = pedirInt();
								}
								
								profSelec.accion(cur);
	    	        		}
	    	        	}       	
	    	        	else if (opcion==2) {
	    	        		System.out.println("\n¿De que curso se va a encargar?");
							inst.imprimirCursos();
							int cursoMenu = pedirInt();		        		
							while(cursoMenu>inst.getCursos().size()){
								System.out.println("Ingrese una opción correcta");
								cursoMenu = pedirInt();
							}
							Curso cursoSelec = inst.getCursos().get(cursoMenu-1);
							profSelec.agregarCurso(cursoSelec);
							System.out.println("\nGenial "+capitalize(profSelec.getNombre()) + " " + capitalize(profSelec.getApellido())+". Ya es el profesor asignado para el curso de " + cursoSelec.getTitulo());
	    	        	}
	    	        	else if(opcion==3){
	    	        		session = false;
	    	        		System.out.println("Sesión finalizada con exito!");	        		
	    	        	}
	    	        	else {
	    	        		System.out.println("Opcion inválida!");
	    	        	}
	        		}

        		}
        		else {
        			System.out.println("No está registrado!");
        			System.out.println("Debe estar registrado para ingresar como profesor.");
        			System.out.println("Ingresando algunos datos a continuación va a concretar su registro.");
	        		System.out.println("Al registrarse va a poder dictar clases en los cursos del " + inst.getNombre());
	        		System.out.println();
	        		Docente doc = crearDocente(inst);
	    			//System.out.println(doc);
        		}	        	
        		
        	//FIN PARTE PROFESOR
	        }
	        else if (opt == 2) {
	        	//MENU DEL ALUMNO
	        	boolean session = false;
        		System.out.println("\nIngrese su n° de DNI");
        		int dni = pedirInt();
        		Alumno aluSelec = inst.encontrarAlumno(dni);
        		if(aluSelec!=null) {
        			System.out.println("Ingrese su usuario");
        			String user = pedirString();
        			if(user.toLowerCase().equals(aluSelec.nombre_usuario.toLowerCase())){
        				System.out.println("Ingrese su contraseña");
        				String pass = pedirString();
        				if(pass.equals(aluSelec.clave)){
        					System.out.println("LOGUEO EXITOSO!");
        					session = true;
        				}
        			}else {
        				System.out.println("Usuario Incorrecto!");
        			}
        			
	        		while(session){
	    	        	System.out.println("\nBienvenido "+ capitalize(aluSelec.getNombre()) + " " + capitalize(aluSelec.getApellido()));
	    	        	mostrarMenuAlum();
	    	        	int opcion = pedirInt();	
	    	        	if (opcion==1) {
	    	        		if(aluSelec.getCursos().size()>0){
		    	        		System.out.println("Los cursos a los que está inscripto son:");
		    	        		aluSelec.imprimirCursos();
		    	        		System.out.println("¿Desea ingresar a cursar a alguno?");
		    	        		System.out.println("1-si 2-no");
		    	        		int o = pedirInt();
		    	        		while(o>2){
		    	        			System.out.println("Ingrese una opción correcta!");
		    	        			System.out.println("¿Desea ingresar a cursar a alguno?");
			    	        		System.out.println("1-si 2-no");
			    	        		o = pedirInt();
		    	        		}
		    	        		if(o == 1) {
		    	        			System.out.println("Ingrese el numero del curso");
		    	        			int cur = pedirInt();
									while(cur>inst.getCursos().size()){
										System.out.println("Ingrese una opción correcta");
										cur = pedirInt();
									}
									
									aluSelec.accion(cur);
		    	        		}
	    	        		}
	    	        		else {
	    	        			System.out.println("\nTodavia no está inscripto a ningún curso");
	    	        		}
	    	        	}	
	    	        	else if(opcion == 2) {
	    	        		
	    	        		if(aluSelec!=null) {
	    		        		System.out.println("\n¿A que curso deseabas inscribirte?");
	    		        		inst.imprimirCursos();
	    		        		int cursoMenu = pedirInt();		        		
	    		        		while(cursoMenu>inst.getCursos().size()){
	    		        			System.out.println("Ingrese una opción correcta");
	    		        			cursoMenu = pedirInt();
	    		        		}
	    		        		Curso cursoSelec = inst.getCursos().get(cursoMenu-1);
	    		        		aluSelec.agregarCurso(cursoSelec);
	    		        		System.out.println("\nGenial "+capitalize(aluSelec.getNombre()) + " " + capitalize(aluSelec.getApellido())+". Se inscribió correctamente al curso de " + cursoSelec.getTitulo());
	           			
	    	        		}
	    	        		
	    	        	}
	    	        	else if (opcion == 3) {
	    	        		if(aluSelec.getCertificados().size()>0) {
	    	        			System.out.println("Los certificados que tiene son: ");
	    	        			aluSelec.imprimirCertificados();
	    	        		}
	    	        		else{
	    	        			System.out.println("\nTodavia no tiene ningún certificado");
	    	        		}
	    	        	}
	    	        	else if (opcion == 4) {
	    	        		session = false;
	    	        		System.out.println("Sesión finalizada con exito!");	  
	    	        	}
	    	        	else {
	    	        		System.out.println("Opcion inválida!");
	    	        	}
	        		}
        			
        		}
        		else {
        			System.out.println("No está registrado!");
        			System.out.println("Debe estar registrado para ingresar como alumno.");
        			System.out.println("Ingresando algunos datos a continuación va a concretar su registro.");
	        		System.out.println("Al registrarse va a poder inscribirse a los cursos del "+inst.getNombre());
	        		System.out.println();
	    			Alumno al = crearAlumno(inst);
	    			//System.out.println(al);
        		}
        		

	        	//FIN PARTE ALUMNO
	        }
	        else if (opt == 3) {
	        	//MENU DEL ADMINISTRATIVO
	        	boolean session = false;
        		System.out.println("\nIngrese su n° de DNI");
        		int dni = pedirInt();
        		Administrativo adminSelec = inst.encontrarAdministrativo(dni);        		
        		if(adminSelec!=null) {
        			System.out.println("Ingrese su usuario");
        			String user = pedirString();
        			if(user.toLowerCase().equals(adminSelec.nombre_usuario.toLowerCase())){
        				System.out.println("Ingrese su contraseña");
        				String pass = pedirString();
        				if(pass.equals(adminSelec.clave)){
        					System.out.println("LOGUEO EXITOSO!");
        					session = true;
        				}
        			}else {
        				System.out.println("Usuario Incorrecto!");
        			}
        			
        			while(session){                		
                		System.out.println("\n Bienvenido "+ capitalize(adminSelec.getNombre()) + " " + capitalize(adminSelec.getApellido())); 
                		System.out.println("Seleccione una opción.");
        	        	mostrarMenuAdmin();
        	        	int opcion = pedirInt();
        	        	if (opcion == 1) {
        	        		System.out.println("Editar alumnos");
        	        		System.out.println("1-Crear alumno");
        	        		System.out.println("2-Ver alumnos");
        	        		System.out.println("3-Generar certificado de aprobación");
        	        		System.out.println("4-Dar de baja alumno");
        	        		int op = pedirInt();
        	        		if (op == 1) {
        	        			Alumno a = crearAlumno(inst);
        	        		}
        	        		else if (op == 2) {
        	        			if(inst.getAlumnos().size()!=0){
        	        			inst.imprimirAlumnos();
        	        			}
        	        			else {
        	        				System.out.println("\nTodavia no hay alumnos cargados en el sistema.");
        	        			}
        	        		}
        	        		else if (op == 3) {
        	        			generarCertificado(inst);
        	        		}
        	        		else if (op ==4) {
        	        			bajaAlumno(inst);
        	        		}
        	        		else {
        	        			System.out.println("Ingrese una opción válida!");
        	        		}
        	        	}
        	        	else if (opcion == 2) {
        	        		System.out.println("Editar profesores");
        	        		System.out.println("1-Crear profesor");
        	        		System.out.println("2-Ver profesores");
        	        		System.out.println("3-Dar de baja profesor");
        	        		int op = pedirInt();
        	        		if (op == 1) {
        	        			Docente d = crearDocente(inst);
        	        		}
        	        		else if (op == 2) {
        	        			if(inst.getDocentes().size()!=0){
        	        			inst.imprimirDocentes();
        	        			}
        	        			else {
        	        				System.out.println("\nTodavia no hay docentes cargados en el sistema.");
        	        			}
        	        		}
        	        		else if(op == 3) {
        	        			bajaProfesor(inst);
        	        		}
        	        		else {
        	        			System.out.println("Ingrese una opción válida!");
        	        		}
        	        	}
        	        	else if (opcion == 3) {
        	        		System.out.println("Editar cursos");
        	        		System.out.println("1-Crear curso");
        	        		System.out.println("2-Ver cursos");
        	        		System.out.println("3-Dar de baja curso");
        	        		int op = pedirInt();	        		
        	        		if (op == 1) {
        	        			Curso c = crearCurso(inst);
        	        		}
        	        		else if (op == 2) {
        	        			if(inst.getCursos().size()!=0) {
        	        			inst.imprimirCursos();
        	        			}
        	        			else {
        	        				System.out.println("\nTodavia no hay cursos cargados en el sistema.");
        	        			}
        	        		}
        	        		else if(op ==3) {
        	        			bajaCurso(inst);
        	        		}
        	        		else {
        	        			System.out.println("Ingrese una opción válida!");
        	        		}
        	        	}
        	        	else if (opcion == 4) {
        	        		adminSelec.accion(0);
        	        	}
        	        	else if (opcion == 5) {
        	        		session = false;
        	        		System.out.println("Sesión finalizada con exito!");	   
        	        	}
        	        	else {
        	        		System.out.println("Ingrese una opción válida");
        	        	} 
        			}
        			
        		} else {
        			System.out.println("No está autorizado a ingresar como admin comuniquese por email a " + inst.getEmail());
        			System.out.println("O telefonicamente al " + inst.getTelefono());
        			System.out.println(inst.getNombre());
        		}
	        	
	        	      	
        	
	        	//FIN PARTE ADMINISTRATIVO

	        	
	        }
	        
	        else if(opt == 4) {
	        	//última opción menu principal
	        	finalizar = salir(finalizar);
	        }

	        
		}
		System.out.println("\nPROGRAMA FINALIZADO");
		}
		


	public static void mostrarMenuProf() {		
		System.out.println("Opcion 1: Ver mis cursos");		
		System.out.println("Opcion 2: Tomar un curso");					
		System.out.println("Opcion 3: Cerrar sesión");
		System.out.println("Ingrese una opción");
		
	}
	
	public static void mostrarMenuAlum() {		
		System.out.println("Opcion 1: Ver mis cursos");		
		System.out.println("Opcion 2: Inscribirse a un curso");
		System.out.println("Opcion 3: Ver mis certificados");
		System.out.println("Opcion 4: Cerrar sesión");
		System.out.println("Ingrese una opción");
		
	}
	
	public static void mostrarMenuAdmin() {		
		System.out.println("Opcion 1: Editar alumnos");		
		System.out.println("Opcion 2: Editar profesores");
		System.out.println("Opcion 3: Editar cursos");
		System.out.println("Opcion 4: Revisar papeles y tramites");
		System.out.println("Opcion 5: Cerrar sesión");
		System.out.println("Ingrese una opción");
		
	}
	
	public static void bienvenida() {
	     DateFormat timeFormat = new SimpleDateFormat("HH:mm");
	     Date time = new Date();
	     System.out.println();
	     System.out.println(timeFormat.format(time));
	     
		System.out.println("\nBIENVENIDO AL SISTEMA DE CAPACITACIONES");
		System.out.println("\n¿Es profesor o alumno?");
		System.out.println("1-profesor");
		System.out.println("2-alumno");
		System.out.println("3-administrativo");
		System.out.println("4-salir");
	}
	
	public static boolean salir(boolean finalizar) {
		System.out.println("\n¿Está seguro que desea salir?");
		System.out.println("1-si 2-no");
		int op = pedirInt();
		while(op < 1 || op > 2) {
			System.out.println("opción inválida!");
    		System.out.println("\n¿Está seguro que desea salir?");
    		System.out.println("1-si 2-no");
			op=pedirInt();
			
		}
		if(op==1) {
			finalizar = true;
		}
		return finalizar;
	}
	
	public static Docente crearDocente(Institucion inst) {		
		int id;
		String nombre;
		String apellido;
		String especializacion;
		String nombre_usuario;
		String clave;
		String email;
		int telefono;
		ArrayList<Curso> cursos = new ArrayList<Curso>();
		
		System.out.println("Ingrese su dni: ");
		id=pedirInt();
		
		System.out.println("Ingrese su nombre: ");
		nombre=pedirString();
		
		System.out.println("Ingrese su apellido: ");
		apellido=pedirString();
		
		System.out.println("Ingrese su especializacion: ");
		especializacion=pedirString();
		
		System.out.println("\nGenial "  + capitalize(nombre) + ", ahora debes crear tu usuario.");
		System.out.println("Ingresa un nombre de usuario :");
		nombre_usuario=pedirString();
		
		System.out.println("Ingresa una clave: ");
		clave=pedirString();
		
		System.out.println("\nGenial " + capitalize(nombre) + " solamente faltan algunos datos de contacto.");
		
		System.out.println("Ingresá tu email: ");
		email=pedirString();
		
		System.out.println("Ingresá tu celular: ");
		telefono=pedirInt();
		
		Docente docenteCreado = new Docente(id,nombre_usuario,email,telefono,clave,nombre,apellido,especializacion,cursos);
		inst.setDocentes(docenteCreado);
		System.out.println("\nTodo salió correctamente!");
		
		return docenteCreado;
		
	}
	
	public static Alumno crearAlumno(Institucion inst) {		
		int id;
		String nombre;
		String apellido;
		String nombre_usuario;
		String clave;
		String email;
		int telefono;
		ArrayList<Curso> cursos = new ArrayList<Curso>();
		ArrayList<Certificado> certificados = new ArrayList<Certificado>();
		
		System.out.println("Ingrese su dni: ");
		id=pedirInt();
		
		System.out.println("Ingrese su nombre: ");
		nombre=pedirString();
		
		System.out.println("Ingrese su apellido: ");
		apellido=pedirString();
		
		System.out.println("\nGenial "  + capitalize(nombre) + ", ahora debes crear tu usuario.");
		System.out.println("Ingresa un nombre de usuario :");
		nombre_usuario=pedirString();
		
		System.out.println("Ingresa una clave: ");
		clave=pedirString();
		
		System.out.println("\nGenial " + capitalize(nombre) + " solamente faltan algunos datos de contacto.");
		
		System.out.println("Ingresá tu email: ");
		email=pedirString();
		
		System.out.println("Ingresá tu celular: ");
		telefono=pedirInt();
		
		Alumno alumnoCreado = new Alumno(id,nombre_usuario,email,telefono,clave,nombre,apellido,cursos,certificados);
		System.out.println("\nTodo salió correctamente!");
		inst.setAlumnos(alumnoCreado);	
		return alumnoCreado;
		
	}
	
	public static Administrativo crearAdmin(Institucion inst) {		
		int id;
		String nombre;
		String apellido;		
		String nombre_usuario;
		String clave;
		String email;
		int telefono;		
		
		System.out.println("Ingrese su dni: ");
		id=pedirInt();
		
		System.out.println("Ingrese su nombre: ");
		nombre=pedirString();
		
		System.out.println("Ingrese su apellido: ");
		apellido=pedirString();		

		
		System.out.println("\nGenial "  + capitalize(nombre) + ", ahora debes crear tu usuario.");
		System.out.println("Ingresa un nombre de usuario :");
		nombre_usuario=pedirString();
		
		System.out.println("Ingresa una clave: ");
		clave=pedirString();
		
		System.out.println("\nGenial " + capitalize(nombre) + " solamente faltan algunos datos de contacto.");
		
		System.out.println("Ingresá tu email: ");
		email=pedirString();
		
		System.out.println("Ingresá tu celular: ");
		telefono=pedirInt();
		
		Administrativo adminCreado = new Administrativo(id,nombre_usuario,email,telefono,clave,nombre,apellido);
		inst.setAdministrativos(adminCreado);
		System.out.println("\nTodo salió correctamente!");
		
		return adminCreado;
		
	}
	
	public static Curso crearCurso(Institucion inst) {
		
		String titulo;		
		String dificultad;
		String tematica;
		String descripcion;		

		
		System.out.println("Ingrese el titulo del curso: ");
		titulo=pedirString();

		
		
		System.out.println("Ingrese la dificultad del curso :");
		System.out.println("principiante intermedio avanzado");
		dificultad=pedirString();
		
		System.out.println("Ingrese la tematica del curso: ");
		tematica=pedirString();
		
		System.out.println("Ingrese una breve descripcion del curso:");
		descripcion=pedirString();

		Curso cursoCreado = new Curso(titulo, dificultad,tematica,descripcion);		
        
		inst.setCursos(cursoCreado);		
		System.out.println("\nTodo salió correctamente!");      
     		
		return cursoCreado;
		
	}	
	
	public static void generarCertificado(Institucion i) {
		
		System.out.println("Ingrese el dni del alumno");
		int dni = pedirInt();
		Alumno alu = i.encontrarAlumno(dni);
		if(alu!=null) {
			System.out.println("Alumno encontrado: "+ capitalize(alu.getNombre())+" "+capitalize(alu.getApellido()));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("Seleccione el curso del cual se va a otorgar certificado a "+ capitalize(alu.getNombre()));
			if(alu.getCursos().size()>0) {
				alu.imprimirCursos();
				System.out.println("Seleccione opción:");
				int selec = pedirInt();
				int index = selec-1;
				while(selec > alu.getCursos().size()) {
					System.out.println("Ingrese una opción correcta");
					alu.imprimirCursos();
					System.out.println("Seleccione opción:");
					selec = pedirInt();
				}
				Curso curso = alu.encontrarCurso(index);
				
				Certificado ce = new Certificado(alu,curso);				
				alu.agregarCertificado(ce);
				System.out.println("\nCertificado generado con exito!");
			}else{
				System.out.println(capitalize(alu.getNombre())+" "+capitalize(alu.getApellido())+" todavia no está inscripto a ningún curso");
			}
			
		}else {
			System.out.println("DNI inválido o no existente en el sistema");
		}		
		
	}
	
	public static void bajaAlumno(Institucion i){
		System.out.println("Ingrese el dni del alumno");
		int dni = pedirInt();
		Alumno alu = i.encontrarAlumno(dni);
		if(alu!=null) {
			System.out.println("Alumno encontrado: "+ capitalize(alu.getNombre())+" "+capitalize(alu.getApellido()));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("¿Está seguro de eliminar a "+capitalize(alu.getNombre())+" "+capitalize(alu.getApellido())+ " del sistema ?");
			System.out.println("1-si 2-no");
			int op = pedirInt();
			while(op>2 && op<1) {
				System.out.println("Opción inválida!");
				System.out.println("¿Está seguro de eliminar a "+capitalize(alu.getNombre())+" "+capitalize(alu.getApellido())+ " del sistema ?");
				System.out.println("1-si 2-no");
			}
			if(op==1) {
				int index = i.getAlumnos().indexOf(alu);				
				if(index==0){
					i.getAlumnos().clear();
					System.out.println("Registro eliminado con exito!");
				}
				else {
				i.getAlumnos().remove(index);
				System.out.println("Registro eliminado con exito!");
				}
			}
		}else {
			System.out.println("DNI inválido o no registrado en el sistema");
		}	
	}
	
	public static void bajaProfesor(Institucion i){
		System.out.println("Ingrese el dni del profesor");
		int dni = pedirInt();
		Docente prof = i.encontrarDocente(dni);		
		if(prof!=null) {
			System.out.println("Profesor encontrado: "+ capitalize(prof.getNombre())+" "+capitalize(prof.getApellido()));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("¿Está seguro de eliminar a "+capitalize(prof.getNombre())+" "+capitalize(prof.getApellido())+ " del sistema ?");
			System.out.println("1-si 2-no");
			int op = pedirInt();
			while(op>2 && op<1) {
				System.out.println("Opción inválida!");
				System.out.println("¿Está seguro de eliminar a "+capitalize(prof.getNombre())+" "+capitalize(prof.getApellido())+ " del sistema ?");
				System.out.println("1-si 2-no");
			}
			if(op==1) {
				int index = i.getDocentes().indexOf(prof);				
				if(index==0){
					i.getDocentes().clear();
					System.out.println("Registro eliminado con exito!");
				}
				else {
				i.getAlumnos().remove(index);
				System.out.println("Registro eliminado con exito!");
				}
			}
		}else {
			System.out.println("DNI inválido o no registrado en el sistema");
		}	
	}
	
	public static void bajaCurso(Institucion i){
		i.imprimirCursos();
		System.out.println("Seleccione una opción:");
		int o = pedirInt();
		int index = o-1;
			
		if(index<i.getCursos().size() && index>=0) {
			Curso curso = i.getCursos().get(index);	
			System.out.println("¿Está seguro de eliminar a "+curso.getTitulo()+ " del sistema ?");
			System.out.println("1-si 2-no");
			int op = pedirInt();
			while(op>2 && op<1) {
				System.out.println("Opción inválida!");
				System.out.println("¿Está seguro de eliminar a "+curso.getTitulo()+ " del sistema ?");
				System.out.println("1-si 2-no");
			}
			if(op==1) {							
				if(index==0){
					i.getCursos().clear();
					System.out.println("Registro eliminado con exito!");
				}
				else {
				i.getCursos().remove(index);
				System.out.println("Registro eliminado con exito!");
				}
			}
		}else {
			System.out.println("¡Opción inválida!");
		}	
	}
	
	public static int pedirInt() {
		Scanner teclado = new Scanner (System.in);
		int num;
		num = teclado.nextInt();
		return num;
	}
	
	public static String pedirString() {
		Scanner teclado = new Scanner (System.in);
		String texto;
		texto = teclado.nextLine();
		
		return texto;
	}
	
	public static String capitalize(String example){
		example = example.substring(0,1).toUpperCase() + example.substring(1).toLowerCase();
		return example;
	}

}

