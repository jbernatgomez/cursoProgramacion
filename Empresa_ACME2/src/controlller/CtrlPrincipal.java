package controlller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import view.FrPrincipal;

/**
 * clase CtrlPrincipal
 * 
 * @author Jorge Bernat
 * @version 1.0
 * 
 *          <p>
 *          Clase que controla la funcionalidad de la ventana principal. A traves de ella accedemos a los menus de trabajadores, proyectos y equipos
 *          </p>
 */
public class CtrlPrincipal {	

	/**
	 * Realiza un test de conexion con la base de datos	 
	 */
	public static void conectar() {
	
		try {		
			FileReader fichero = new FileReader("archivos\\log.txt");
			BufferedReader buffer = new BufferedReader(fichero);
			String ip = buffer.readLine();
			String port = buffer.readLine();
			String db = buffer.readLine();
			String user = buffer.readLine();
			String password = buffer.readLine();
			buffer.close();			
			dbManager.DBSQLServer.generarCadena(ip, port, db, user, password);
		} catch (IOException e1) {
			e1.printStackTrace();
		}		
		inicioPrincipal();
	}
	
	/**
	 * Genera un frame principal funcional si el tes de conexion es positivo y no funcional si es negativo.
	 */
	public static void inicioPrincipal() {		
		if(dbManager.DBSQLServer.testConexion()) {	
			FrPrincipal frame = new FrPrincipal();
			frame.menuBar.setVisible(true);;
			frame.lblConectado.setVisible(true);
			frame.lblNoConectado.setVisible(false);
			frame.setVisible(true);
		}else {
			FrPrincipal frame = new FrPrincipal();
			frame.menuBar.setVisible(false);
			frame.lblConectado.setVisible(false);
			frame.lblNoConectado.setVisible(true);
			frame.setVisible(true);
		}	
	}
	
	/**
	 * Activa el metodo de inicio de CtrlProyectos.
	 */
	public static void inicioProyectos() {		
		CtrlProyectos.inicioProyectos();		
	}
	
	/**
	 * Activa el metodo de inicio de CtrlTrabajadores.
	 */
	public static void inicioTrabajadores() {		
		CtrlTrabajadores.inicioTrabajadores();
	}
	
	/**
	 * Activa el metodo de inicio de CtrlEquipos.
	 */
	public static void inicioEquipos() {
		CtrlEquipos.inicioEquipos();
	}
	
	
}
