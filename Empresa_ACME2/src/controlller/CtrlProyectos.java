package controlller;

import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.swing.DefaultListModel;

import logic.LogicProyectos;
import view.DiaProyectos;
import view.FrProyectos;

/**
 * clase CtrlProyectos
 * 
 * @author Jorge Bernat
 * @version 1.0
 * 
 *          <p>
 *          Clase que controla las interaciones con la base de datos de proyectos. 
 *          </p>
 */
public class CtrlProyectos {	
	public static String registro = "-1";	
	public static int menu;
	
	/**
	 * Crea un frame FrProyectos 	 
	 */
	public static void  inicioProyectos() {
		FrProyectos frProyectos = new FrProyectos();
		pintar();
		frProyectos.setVisible(true);
	}
	
	/**
	 * Rellena el JList datos del frame de proyectos con los datos la base de datos de proyectos
	 */
	public static void pintar() {
		try {
			CachedRowSet resultado = logic.LogicProyectos.obtenerNombreProyectos();
			DefaultListModel<String> m = util.Utilidades.crearModeloLista(resultado);
			view.FrProyectos.datos.setModel(m);			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
	
	/**
	 * Crea un JDialog DiaProyectos ajustandolo a las necesidades de la opcion elegida segun sea insertar, 
	 * editar o info  	 
	 */
	public static void mProyecto() {		
		DiaProyectos proyecto = new DiaProyectos();		
		switch(menu) {
			case 1:
				DiaProyectos.textField_1.setEditable(true);
				DiaProyectos.textField_2.setEditable(true);
				DiaProyectos.textField_3.setEditable(true);
				DiaProyectos.textField_4.setEditable(true);
				break;
			case 3:
				info();
				DiaProyectos.textField_1.setEditable(true);
				DiaProyectos.textField_2.setEditable(true);
				DiaProyectos.textField_3.setEditable(true);
				DiaProyectos.textField_4.setEditable(true);				
				
				break;
			case 4: 
				info();
				DiaProyectos.textField_1.setEditable(false);
				DiaProyectos.textField_2.setEditable(false);
				DiaProyectos.textField_3.setEditable(false);
				DiaProyectos.textField_4.setEditable(false);
				break;
		}		
		proyecto.setVisible(true);		
	}
	
	/**
	 * Ejecuta la insercion de los nuevos datos o la sustitucion de los datos antiguos por los 
	 * nuevos en funcion de la opcion elegida, para el proyecto elegido en el diaogo de proyectos.  	 
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
	 * Inserta un proyecto nuevo en la base de datos.  	 
	 */
	public static void nuevo() {		
		int id = 0;
		String a = DiaProyectos.textField_1.getText();
		Float b = Float.parseFloat(DiaProyectos.textField_2.getText());		
		String c = DiaProyectos.textField_3.getText();
		String d = DiaProyectos.textField_4.getText();
				
		try {				
			CachedRowSet resultado = LogicProyectos.obtenerMaxIdProyectos();
			DefaultListModel<String> m = util.Utilidades.crearModeloLista(resultado);				
			id = 1 + Integer.valueOf((String) m.getElementAt(0));
			LogicProyectos.insertarProyecto(id, a, b, c, d);
			pintar();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	/**
	 * Borra el proyecto elegido de la base de datos.  	 
	 */
	public static void borrar() {		
		try {
			LogicProyectos.borrarProyecto((String)FrProyectos.datos.getSelectedValue());
			pintar();
		} catch (Exception e) {
		}		
	}
	
	/**
	 * Edita los datos de un proyecto elegido en la base de datos.  	 
	 */
	public static void editar() {				
		int id = Integer.parseInt(registro);
		
		String a = DiaProyectos.textField_1.getText();
		Float b = Float.parseFloat(DiaProyectos.textField_2.getText());		
		String c = DiaProyectos.textField_3.getText();
		String d = DiaProyectos.textField_4.getText();

		try {
			LogicProyectos.editarProyecto(id, a, b, c, d);
			pintar();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	/**
	 * Muestra los datos de un proyecto elegido de la base de datos de proyectos.  	 
	 */
	public static void info() {		
		try {
			String nombre = (String) FrProyectos.datos.getSelectedValue();				
			CachedRowSet resultado = LogicProyectos.obtenerIdProyecto(nombre);	
			DefaultListModel<String> m = util.Utilidades.crearModeloLista(resultado);			
			registro =(String)m.getElementAt(0);
								
			resultado = LogicProyectos.obtenerNombreProyecto(nombre);	
			m = util.Utilidades.crearModeloLista(resultado);
			DiaProyectos.textField_1.setText((String)m.getElementAt(0));
			
			resultado = LogicProyectos.obtenerPresupuestoProyecto(nombre);						
			m = util.Utilidades.crearModeloLista(resultado);			
			DiaProyectos.textField_2.setText((String)m.getElementAt(0));
			
			resultado = LogicProyectos.obtenerInicioProyecto(nombre);						
			m = util.Utilidades.crearModeloLista(resultado);
			DiaProyectos.textField_3.setText((String)m.getElementAt(0));
			
			resultado = LogicProyectos.obtenerFinProyecto(nombre);						
			m = util.Utilidades.crearModeloLista(resultado);			
			DiaProyectos.textField_4.setText((String)m.getElementAt(0));
			
		} catch (Exception e) {
		}			
	}
}
