package model;


public class Proyecto {

	int 	id;
	String 	nombre;
	Float 	presupuesto;
	String 	inicio;
	String 	fin;
	
	public Proyecto() {		
	}
	
	public Proyecto(int id, String nombre, Float presupuesto, String inicio, String fin) {		
		this.id				= id;
		this.nombre			= nombre;
		this.presupuesto 	= presupuesto;
		this.inicio 		= inicio;
		this.fin 			= fin;
	}

	public String getNombre() {
		return nombre;
	}

	public Float getPresupuesto() {
		return presupuesto;
	}

	public String getInicio() {
		return inicio;
	}

	public String getFin() {
		return fin;
	}

	public int getId() {
		return id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPresupuesto(Float presupuesto) {
		this.presupuesto = presupuesto;
	}

	public void setInicio(String inicio) {
		this.inicio = inicio;
	}

	public void setFin(String fin) {
		this.fin = fin;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Proyecto [id=" + id + ", nombre=" + nombre + ", presupuesto=" + presupuesto + ", inicio=" + inicio
				+ ", fin=" + fin + "]";
	}		
}
