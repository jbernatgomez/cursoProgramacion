package model;

public class Cargo {

	int 	id;
	String 	nombre;
	
	public Cargo() {				
	}
	
	public Cargo(int id, String nombre) {				
		this.id			= id;	
		this.nombre			= nombre;		
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Cargo [id=" + id + ", nombre=" + nombre + "]";
	}
}
