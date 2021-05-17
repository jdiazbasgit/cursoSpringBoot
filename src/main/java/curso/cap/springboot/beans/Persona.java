package curso.cap.springboot.beans;

public class Persona {

	private String nombre, direccion, telegono;
	
	private int edad;
	
	

	public Persona(String nombre, String direccion, String telegono, int edad) {
		
		this.nombre = nombre;
		this.direccion = direccion;
		this.telegono = telegono;
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelegono() {
		return telegono;
	}

	public void setTelegono(String telegono) {
		this.telegono = telegono;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
}
