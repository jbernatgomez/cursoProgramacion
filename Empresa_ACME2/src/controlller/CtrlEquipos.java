package controlller;

import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

import logic.LogicEquipos;
import logic.LogicProyectos;
import logic.LogicTrabajadores;
import util.Utilidades;
import view.DiaEqAnhadir;
import view.DiaEqCargo;
import view.FrEquipos;

/**
 * clase CtrlEquipos
 * 
 * @author Jorge Bernat
 * @version 1.0
 * 
 *          <p>
 *          Clase que controla las interaciones con la base de datos de equipos. 
 *          </p>
 */
public class CtrlEquipos {
	public static FrEquipos vEquipos;
	public static int idEquipo = -1;
	public static int idProyecto = -1;
	public static int idTrabajador = -1;
	public static int idCargo = -1;
	public static int menu;
		
	/**
	 * Crea un frame FrEquipos 	 
	 */
	public static void  inicioEquipos() {
		FrEquipos frEquipos = new FrEquipos();
		pintar();		
		frEquipos.setVisible(true);
	}	
	
	/**
	 * Rellena el JCombobox proyectos del frame de equipos con los datos la base de datos de proyectos
	 */		
	public static void pintar( ) {
		try {					
			CachedRowSet resultado = LogicProyectos.obtenerNombreProyectos();			
			DefaultListModel<String> m = util.Utilidades.crearModeloLista(resultado);
			view.FrEquipos.proyectos.addItem("");
			for(int i =0; i<= m.getSize();i++) {
				view.FrEquipos.proyectos.addItem((String) m.getElementAt(i));
			}
		} catch (Exception e) {
		}		
	}	
	
	/**
	 * Rellena el JList del dialogo de insertar trabajadores con los datos la base de datos de trabajadores
	 */
	public static void pintarTrabajadores( ) {
		try {									
			CachedRowSet resultado = LogicTrabajadores.obtenerNombreTrabajadores();							
			DefaultListModel<String> m = util.Utilidades.crearModeloLista(resultado);				
			DiaEqAnhadir.trabajadores.setModel(m);
		} catch (Exception e) {
		}						
	}	
	
	/**
	 * Rellena el JList del dialogo de editar cargos con los datos la base de datos de cargos
	 */
	public static void pintarCargos( ) {
		try {									
			CachedRowSet resultado = LogicEquipos.obtenerCargos();							
			DefaultListModel<String> m = util.Utilidades.crearModeloLista(resultado);				
			DiaEqCargo.cargos.setModel(m);
		} catch (Exception e) {
		}	
	}
	
	
	/**
	 * Rellena el JTable table del frame de equipos 
	 * con los datos la base de datos de trabajadores y cargos en funcion del proyecto seleccionado
	 */
	public static void cargarEquipos( ) {
		Object[] header = new Object[]{"DNI", "Cargo"};		
		if(FrEquipos.proyectos.getSelectedItem()=="") {			
			DefaultTableModel model = new DefaultTableModel(header, 0);
			FrEquipos.table.setModel(model);
			
		}else {
			try {				
				String proyecto = (String)FrEquipos.proyectos.getSelectedItem();
				CachedRowSet resultado = LogicEquipos.obtenerIdProyecto(proyecto);	
				DefaultListModel<String> m = util.Utilidades.crearModeloLista(resultado);			
				idProyecto =Integer.parseInt((String)m.getElementAt(0));
				CachedRowSet resultado2 = LogicEquipos.obtenerTablaEquipo(idProyecto);
				DefaultTableModel model = Utilidades.crearModeloTabla(resultado2);
				
				FrEquipos.table.setModel(model);			
			} catch (Exception e) {
			}
		}
	}
	
	/**
	 * Genera un dialogo para añadir trabajadores a un proyecto seleccionado
	 */
	public static void anhadir() {		
		if(FrEquipos.proyectos.getSelectedItem()=="") {						
		}else {
			DiaEqAnhadir diaEqAnhadir = new DiaEqAnhadir();
			pintarTrabajadores();
			diaEqAnhadir.setVisible(true);
		}
	}
	
	/**
	 * Inserta un trabajador seleccinado en un proyecto determinado mediante la insercion de 
	 * los datos correspondientes en la base de datos de quipos
	 */
	public static void insertarTrabajador() {		
		String dniTrabajador= (String)DiaEqAnhadir.trabajadores.getSelectedValue();		
		idCargo = 0;
		try {
			CachedRowSet resultado = LogicEquipos.obtenerMaxIdEequipos();
			DefaultListModel<String> m = util.Utilidades.crearModeloLista(resultado);				
			idEquipo = 1 + Integer.valueOf((String) m.getElementAt(0));
			resultado = LogicTrabajadores.obtenerIdTrabajador(dniTrabajador);
			m = util.Utilidades.crearModeloLista(resultado);			
			idTrabajador = Integer.parseInt((String)m.getElementAt(0));
			
			LogicEquipos.insertarTrabajadorEq(idEquipo, idProyecto, idTrabajador, idCargo);
			
			cargarEquipos();
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}						
	}
	
	/**
	 * Elimina un trabajador seleccinado de un proyecto determinado mediante el borrado de 
	 * los datos correspondientes en la base de datos de quipos
	 */
	public static void eliminar() {	
		if(FrEquipos.table.getValueAt(FrEquipos.table.getSelectedRow(), 0).toString()=="") {
			System.out.println(1);					
		}else {
			String dniTrabajador= FrEquipos.table.getValueAt(FrEquipos.table.getSelectedRow(), 0).toString();
			String cargoTrabajador= FrEquipos.table.getValueAt(FrEquipos.table.getSelectedRow(), 1).toString();
			try {
				CachedRowSet resultado = LogicTrabajadores.obtenerIdTrabajador(dniTrabajador);
				DefaultListModel<String> m = util.Utilidades.crearModeloLista(resultado);
				idTrabajador = Integer.parseInt((String)m.getElementAt(0));
				resultado = LogicEquipos.obtenerIdCargo(cargoTrabajador);
				m = util.Utilidades.crearModeloLista(resultado);	
				idCargo = Integer.parseInt((String)m.getElementAt(0));
				
				LogicEquipos.borrarTrabajadorEq(idTrabajador,idProyecto,idCargo);
				cargarEquipos();
			} catch (Exception e) {
			}	
		}
	}
	
	/**
	 * Genera un dialogo para editar el cargo de un trabajador determinado en un proyecto seleccionado
	 */
	public static void editar() {		
		if(FrEquipos.proyectos.getSelectedItem()=="") {						
		}else {
			DiaEqCargo diaEqCargo = new DiaEqCargo();
			pintarCargos();
			diaEqCargo.setVisible(true);
		}
	}	
	
	/**
	 * Edita el cargo de un trabajador seleccinado de un proyecto determinado mediante el borrado de 
	 * los datos correspondientes en la base de datos de quipos
	 */
	public static void insertarcargo() {			
		if(DiaEqCargo.cargos.isSelectionEmpty()) {
			System.out.println(1);
		}else {
			try {
				String dniTrabajador= FrEquipos.table.getValueAt(FrEquipos.table.getSelectedRow(), 0).toString();
				String cargoTrabajador= FrEquipos.table.getValueAt(FrEquipos.table.getSelectedRow(), 1).toString();
				
				CachedRowSet resultado = LogicTrabajadores.obtenerIdTrabajador(dniTrabajador);
				DefaultListModel<String> m = util.Utilidades.crearModeloLista(resultado);
				idTrabajador = Integer.parseInt((String)m.getElementAt(0));
				
				resultado = LogicEquipos.obtenerIdCargo(cargoTrabajador);
				m = util.Utilidades.crearModeloLista(resultado);	
				idCargo = Integer.parseInt((String)m.getElementAt(0));
				
				String nombreCargo = DiaEqCargo.cargos.getSelectedValue().toString();
				resultado = LogicEquipos.obtenerIdCargo(nombreCargo);			
				m = util.Utilidades.crearModeloLista(resultado);	
				int idCargoN = Integer.parseInt((String)m.getElementAt(0));
				
				LogicEquipos.editarCargoT(idProyecto, idTrabajador, idCargo, idCargoN );
				
				cargarEquipos();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}		
}
