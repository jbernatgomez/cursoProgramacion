

package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import controlller.CtrlTrabajadores;

/** 
 * clase FrTrabajadores
 * @author Jorge Bernat
 * @version 1.0
 * <br/>
 * <p> Interfaz grafica para manipular la base de datos de trabajadores</p>
 */
public class FrTrabajadores extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	public static JList<String> datos;
	
	/** 
	 * Constructor del JFrame FrTrabajadores
	 */
	public FrTrabajadores() {
		setTitle("Trabajadores");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.setBounds(22, 202, 89, 23);
		btnNuevo.addActionListener(new Nuevo());
		contentPane.add(btnNuevo);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(121, 202, 89, 23);
		btnBorrar.addActionListener(new Borrar());
		contentPane.add(btnBorrar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(220, 202, 89, 23);
		btnEditar.addActionListener(new Editar());
		contentPane.add(btnEditar);
		
		JButton btnInfo = new JButton("Info");
		btnInfo.setBounds(321, 202, 89, 23);
		btnInfo.addActionListener(new Info());
		contentPane.add(btnInfo);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(65, 25, 300, 150);
			datos = new JList<String>();						
		scrollPane.setViewportView(datos);		
		contentPane.add(scrollPane);		
	}
	
	/** 
	 * ActionListener que activa el dialogo de insertar nuevo trabajador
	 */
	static class Nuevo implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {			
			CtrlTrabajadores.menu = 1;
			System.out.println("Error");
			CtrlTrabajadores.mTrabajador();
		}
	}
	
	/** 
	 * ActionListener que activa el borrado de un trabajador seleccionado
	 */
	static class Borrar implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			CtrlTrabajadores.menu = 2;
			CtrlTrabajadores.mTrabajador();				
		}
	}

	/** 
	 * ActionListener que activa el dialogo de edicion de un trabajador seleccionado
	 */
	static class Editar implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			CtrlTrabajadores.menu = 3;
			CtrlTrabajadores.mTrabajador();
		}
	}
	
	/** 
	 * ActionListener que activa el dialogo de informacion de un trabajador seleccionado
	 */	
	static class Info implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {	
			CtrlTrabajadores.menu = 4;
			CtrlTrabajadores.mTrabajador();			
		}		
	}
}
