package start;

import java.awt.EventQueue;

import controlller.CtrlPrincipal;

/** 
 * clase Index
 * @author Jorge Bernat
 * @version 1.0
 * <br/>
 * <p> Clase principal cuya única fnción es lanzar la aplicación </p>
 */
public class Index {	
	
	/** 
	 * Metodo main 
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {					
					CtrlPrincipal.conectar();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
