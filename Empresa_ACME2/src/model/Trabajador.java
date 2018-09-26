package model;

public class Trabajador {
	
	int			id;
	String		dni;
	String 		nombre;	
	String 		apellidos;
	Boolean 	genero;
	
	public Trabajador() {
	}
	
	public Trabajador(int id, String dni, String nombre, String apellidos, Boolean genero) {
		this.id=id;	
		this.dni=dni;
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.genero=genero;			
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public Boolean getGenero() {
		return genero;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public void setGenero(Boolean genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		return "Trabajador [id=" + id + ", dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", genero="
				+ genero + "]";
	}	
}
