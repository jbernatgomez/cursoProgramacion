package model;

import java.util.*;


public class Equipo {
	int id;
	String proyecto;
	List<Trabajador> trabajadores;
	List<Cargo> cargos;
	
	public Equipo(){
	}
	
	public Equipo(int id, String proyecto, List<Trabajador> trabajadores, List<Cargo> cargos){
		this.id = id;
		this.proyecto = proyecto;
		this.trabajadores = trabajadores;
		this.cargos = cargos;
	}

	public int getId() {
		return id;
	}

	public String getProyecto() {
		return proyecto;
	}

	public List<Trabajador> getTrabajadores() {
		return trabajadores;
	}

	public List<Cargo> getCargos() {
		return cargos;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setProyecto(String proyecto) {
		this.proyecto = proyecto;
	}

	public void setTrabajadores(List<Trabajador> trabajadores) {
		this.trabajadores = trabajadores;
	}

	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}

	@Override
	public String toString() {
		return "Equipo [id=" + id + ", proyecto=" + proyecto + ", trabajadores=" + trabajadores + ", cargos=" + cargos
				+ "]";
	}
}
