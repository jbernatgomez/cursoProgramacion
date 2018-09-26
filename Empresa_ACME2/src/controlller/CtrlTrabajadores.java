package controlller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;
import javax.swing.DefaultListModel;

import logic.LogicTrabajadores;
import model.Trabajador;
import view.DiaTrabajadores;
import view.FrTrabajadores;

/**
 * clase CtrlTrabajadores
 * 
 * @author Jorge Bernat
 * @version 1.0
 * 
 *          <p>
 *          Clase que controla las interaciones con la base de datos de trabajadores. 
 *          </p>
 */
public class CtrlTrabajadores {
	static List <Trabajador> trabajadores= new ArrayList<Trabajador>();
	static Trabajador trabajador;
	public static String registro = "-1";
	public static int menu;
	
	/**
	 * Crea un frame FrTrabajadores 	 
	 */
	public static void  inicioTrabajadores() {
		FrTrabajadores frTrabajadores = new FrTrabajadores();
		pintar();		
		frTrabajadores.setVisible(true);
	}
	
	/**
	 * Llena el array trabajadores con los datos de la base de datos de trabajadores	 
	 */
	public static void llenarArray() {
		int id;
		String dni;
		String nombre;
		String apellidos;
		Boolean genero;
		Trabajador t;
		
		trabajadores.clear();
		
		try {
			CachedRowSet resultado = LogicTrabajadores.obtenerTrabajadores();			
			while(resultado.next()) {
				id = resultado.getInt("ID");
				dni = resultado.getString("DNI");
				nombre = resultado.getString("Nombre");
				apellidos = resultado.getString("Apellidos");
				genero = true;
				if(resultado.getString("Genero")=="H") {
					genero = true;
				}else if(resultado.getString("Genero")=="M") {
					genero = false;
				}	
			t= new Trabajador(id, dni, nombre, apellidos, genero);				
			trabajadores.add(t);		
			}
		} catch (Exception e) {
		}
	}
	
	/**
	 * Rellena el JList datos del frame de trabajadores con los datos del array de trabajadores 	 
	 */
	public static void pintar() {		
		try {
			llenarArray();
			DefaultListModel<String> m = util.Utilidades.crearModeloListaTrabajadores(trabajadores);			
			view.FrTrabajadores.datos.setModel(m);
		} catch (Exception e) {
		}
	}	
	
	/**
	 * Crea un JDialog DiaTrabajadores ajustandolo a las necesidades de la opcion elegida segun sea insertar, 
	 * editar o info, y ejecuta la opcion de borrado si la opcion elegida es borrar  	 
	 */
	public static void mTrabajador() {						
		DiaTrabajadores diaTrabajador = new DiaTrabajadores();		
		switch(menu) {
			case 1:
				DiaTrabajadores.textField_4.setVisible(false);
				DiaTrabajadores.masculino.setVisible(true);
				DiaTrabajadores.femenino.setVisible(true);
				DiaTrabajadores.textField_1.setEditable(true);
				DiaTrabajadores.textField_2.setEditable(true);
				DiaTrabajadores.textField_3.setEditable(true);
				DiaTrabajadores.textField_4.setEditable(true);
				diaTrabajador.setVisible(true);
				break;
			case 2:
				cargarTrabajador();
				borrar();
				break;
			case 3:
				cargarTrabajador();
				DiaTrabajadores.textField_4.setVisible(false);
				DiaTrabajadores.masculino.setVisible(true);
				DiaTrabajadores.femenino.setVisible(true);
				info();
				DiaTrabajadores.textField_1.setEditable(true);
				DiaTrabajadores.textField_2.setEditable(true);
				DiaTrabajadores.textField_3.setEditable(true);
				DiaTrabajadores.textField_4.setEditable(true);				
				diaTrabajador.setVisible(true);
				break;
			case 4: 
				cargarTrabajador();
				DiaTrabajadores.masculino.setVisible(false);
				DiaTrabajadores.femenino.setVisible(false);
				DiaTrabajadores.textField_4.setVisible(true);
				info();
				DiaTrabajadores.textField_1.setEditable(false);									
				DiaTrabajadores.textField_2.setEditable(false);
				DiaTrabajadores.textField_3.setEditable(false);
				DiaTrabajadores.textField_4.setEditable(false);
				diaTrabajador.setVisible(true);
				break;
		}			
	}	
	
	/**
	 * Carga los datos del trabajador seleccionado en la variable Trabajador de esta clase.  	 
	 */
	public static void cargarTrabajador() {
		trabajador = trabajadores.get(FrTrabajadores.datos.getSelectedIndex());		
	}
	
	
	/**
	 * Ejecuta la insercion de los nuevos datos o la sustitucion de los datos antiguos por los 
	 * nuevos en funcion de la opcion elegida, para el trabajador elegido en el diaogo de trabajadores.  	 
	 */
	public static void ok() {	
		switch(menu) {
			case 1:
				nuevo();				
				break;
			case 3: 
				editar();
				break;			
		}						
	}
	
	/**
	 * Inserta un trabajador nuevo en la base de datos.  	 
	 */
	public static void nuevo() {	
			int id = 0;
			String dni= DiaTrabajadores.textField_1.getText();
			String nombre = DiaTrabajadores.textField_2.getText();
			String apellidos = DiaTrabajadores.textField_3.getText();
			String genero = "I";
			if(DiaTrabajadores.masculino.isSelected()) {						
				genero= "H";
			}else if(DiaTrabajadores.femenino.isSelected()) {
				genero= "M";
			}
			try {				
				CachedRowSet resultado = LogicTrabajadores.obtenerMaxIdTrabajadores();
				DefaultListModel<String> m = util.Utilidades.crearModeloLista(resultado);				
				id = 1 + Integer.valueOf((String) m.getElementAt(0));
				
				LogicTrabajadores.insertarTrabajador(id, dni, nombre, apellidos, genero);
				pintar();
			} catch (SQLException e) {
				e.printStackTrace();
			}			
	}
	
	/**
	 * Borra el trabajador elegido de la base de datos.  	 
	 */
	public static void borrar() {		
		try {
			LogicTrabajadores.borrarTrabajador(trabajador.getId());
			pintar();
		} catch (Exception e) {
		}	
	}
	
	/**
	 * Edita los datos de un trabajador elegido en la base de datos.  	 
	 */
	public static void editar() {		
		int id = trabajador.getId();
		
		String dni= DiaTrabajadores.textField_1.getText();
		String nombre = DiaTrabajadores.textField_2.getText();
		String apellidos = DiaTrabajadores.textField_3.getText();
		String genero = "I";		
		if(DiaTrabajadores.masculino.isSelected()) {						
			genero = "H";
		}else if(DiaTrabajadores.femenino.isSelected()) {
			genero = "M";
		};

		try {
			LogicTrabajadores.editarTrabajador(id, dni, nombre, apellidos, genero);
			pintar();
		} catch (SQLException e) {
			e.printStackTrace();
		}			
	}
	
	/**
	 * Muestra los datos de un trabajador elegido del array de trabajadores.  	 
	 */
	public static void info() {
		try {
			DiaTrabajadores.textField_1.setText(trabajador.getDni());
			DiaTrabajadores.textField_2.setText(trabajador.getNombre());
			DiaTrabajadores.textField_3.setText(trabajador.getApellidos());
			String genero = "";
			if(trabajador.getGenero()==true) {
				genero= "Hombre";
				DiaTrabajadores.masculino.setSelected(true);
				DiaTrabajadores.femenino.setSelected(false);
			}else if(trabajador.getGenero()==false){
				genero= "Mujer";
				DiaTrabajadores.masculino.setSelected(false);
				DiaTrabajadores.femenino.setSelected(true);
			}
			DiaTrabajadores.textField_4.setText(genero);
			
		} catch (Exception e) {
		}		
	}
}
