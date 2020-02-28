package practica;
import java.util.List;
import java.util.Scanner;


public class main {

	static Scanner input =new Scanner (System.in);
	public static void main(String[] args) {
		System.out.println("Bienvenido \n ingrese la opcion que desea realizar \n 1.- crear usuario \n 2.- Usar el cajero \n 0.- salir.");
		int opcion = input.nextInt();
		while(opcion != 0) {
			//System.out.println("hola");
			
			switch(opcion) {
			case 1:
				guardarUsuario();
				break;
			case 2:
				System.out.println("Bienvenido al cajero");
				inicio();
				break;
			}
			System.out.println("Bienvenido \n ingrese la opcion que desea realizar \n 1.- crear usuario \n 2.- Usar el cajero \n 0.- salir.");
			opcion = input.nextInt();
			
		}
        
		
	}
	
	public static void inicio() {
		Persona p = new Persona();
		conexion c = new conexion();
		System.out.println("Ingrese el número de tarjeta");
		int numTarjeta = input.nextInt();
		p.setNumeroTarjeta(numTarjeta);
		p = c.seleccionarPersona(p);
		int id = p.getId();
		String usuario = p.getNombreP();
		int numeroTarjeta = p.getNumeroTarjeta();
		int nip = p.getNip();
		int fondo = p.getFondos();
		String apellidoP = p.getApellidoP();
		String apellidoM = p.getApellidoM();
		int edad =p.getEdadP();
		System.out.println("Ingrese el nip: \n");
		int nipIngresado = input.nextInt();
		if(nipIngresado == nip) {
			System.out.println("Bienvenido "+usuario);
			System.out.println("Qué operación desea realizar: \n 1.-Visualizar fondos\n 2.- Retiro de fondos\n 3.-Deposito de dinero 0.-cerrar sesión");
			int operacion = input.nextInt();
			while(operacion != 0) {
				switch(operacion) {
				case 1:
					fondo = p.getFondos();
					System.out.println("Has seleccionado Visualizar fondos");
					System.out.println("Su saldo es: \n"+fondo);
					break;
				case 2:
					fondo = p.getFondos();
					System.out.println("Has seleccionado Retiro de fondos");
					System.out.println("Su saldo es: \n"+fondo);
					System.out.println("¿Cuánto deseas retirar?");
					int retiro = input.nextInt();
					if(fondo<retiro) {
						System.out.println("Fondo insuficiente");
					}else {
						fondo = fondo-retiro;
						
						p.setFondos(fondo);
						actualizar(id, usuario, apellidoP,apellidoM, edad,nip,fondo,numeroTarjeta);
						
					}
					break;
				
				case 3:
					fondo = p.getFondos();
					System.out.println("Has seleccionado Deposito de dinero");
					System.out.println("Su saldo es: \n"+fondo);
					System.out.println("Ingresa el dinero");
					int deposito = input.nextInt();
					int total = fondo + deposito;
					actualizar(id, usuario, apellidoP,apellidoM, edad,nip,total,numeroTarjeta);
					p.setFondos(total);
					
				}
				System.out.println("Qué operación desea realizar: \n 1.-Visualizar fondos\n 2.- Retiro de fondos\n 3.-Deposito de dinero 0.-cerrar sesión");
				operacion = input.nextInt();
			}

		}else {
			System.out.println("nip incorrecto");
			inicio();
		}
		
	}

	public static void guardarUsuario() {
		Persona p = new Persona();
		conexion c = new conexion();
		//proceso();
		System.out.println("Ingresa el id de la persona");
		int id = input.nextInt();
		p.setId(id);
		System.out.println("Ingresa el nombre de la persona");
		String nombre = input.next();
		p.setNombreP(nombre);
		System.out.println("Ingresa el apellido paterno de la persona");
		String apellidoP = input.next();
		p.setApellidoP(apellidoP);
		
		System.out.println("Ingresa el apellido materno de la persona");
		String apellidoM = input.next();
		p.setApellidoP(apellidoM);
		
		System.out.println("Ingresa la edad");
		int edad = input.nextInt();
		p.setEdadP(edad);
		
		System.out.println("Ingresa el nip");
		int nip = input.nextInt();
		p.setNip(nip);
		
		System.out.println("Ingresa el fondo");
		int fondos = input.nextInt();
		p.setFondos(fondos);
		
		System.out.println("Ingresa el numeroTarjeta");
		int numeroTarjeta = input.nextInt();
		p.setNumeroTarjeta(numeroTarjeta);
		
		//eliminar(id);
		
		insertar(p);
		
		seleccionar(p);
	}
	
	public static void insertar(Persona p) {
		conexion c = new conexion();
		c.insertarRegistro(p);
	}
	
	public static void seleccionar(Persona p) {
		conexion c = new conexion();
		p = c.seleccionarPersona(p);
		System.out.println(p);
	}
	public static void actualizar(int id, String nombre, String apellidoP, String apellidoM, int edad, int nip, int fondos, int numeroTarjeta) {
		conexion c = new conexion();
		c.actualizacionPersona(id, nombre, apellidoP,apellidoM, edad,nip,fondos,numeroTarjeta);
	}
	public static void eliminar(int id) {
		conexion c = new conexion();
		c.eliminarRegistros(id);
	}
}
