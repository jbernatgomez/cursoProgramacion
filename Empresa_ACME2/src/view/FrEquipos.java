package view;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlller.CtrlEquipos;

/** 
 * clase FrEquipos
 * @author Jorge Bernat
 * @version 1.0
 * <br/>
 * <p> Interfaz grafica para manipular la base de datos de equipos</p>
 */
public class FrEquipos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTable table;
	public static JComboBox<String> proyectos;
	
	/** 
	 * Constructor del JFrame FrEquipos
	 */
	public FrEquipos() {
		setTitle("Equipos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblProyecto = new JLabel("Proyecto:");
		lblProyecto.setBounds(40, 40, 100, 15);
		contentPane.add(lblProyecto);	
		
		JLabel lblTrabajadores = new JLabel("Trabajadores:");
		lblTrabajadores.setBounds(40, 80, 100, 15);
		contentPane.add(lblTrabajadores);
		
		proyectos = new JComboBox<String>();
		proyectos.setBounds(150, 35, 250, 20);
		proyectos.addActionListener(new cargarTra());
		contentPane.add(proyectos);
		
		JButton btnAnhadir = new JButton("A\u00F1adir");
		btnAnhadir.setBounds(40, 225, 100, 25);
		btnAnhadir.addActionListener(new Anhadir());
		contentPane.add(btnAnhadir);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(170, 225, 100, 25);
		btnEliminar.addActionListener(new Eliminar());
		contentPane.add(btnEliminar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(300, 225, 100, 25);
		btnEditar.addActionListener(new Editar());
		contentPane.add(btnEditar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 110, 360, 100);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},				
			},
			new String[] {
				"Nombre", "Cargos"
			}
		));
		scrollPane.setViewportView(table);		
	}
		
	/** 
	 * ActionListener que carga la lista de trabajadores asignados a un proyecto concreto
	 */
	static class cargarTra implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {		
			CtrlEquipos.cargarEquipos();						
		}
	}
	
	/** 
	 * ActionListener que activa el dialogo de anhadir un trabajador a un proyecto elejido
	 */
	static class Anhadir implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {													
			CtrlEquipos.anhadir();					
		}
	}
	
	/** 
	 * ActionListener que elimina un trabajador elejido de un proyecto concreto
	 */
	static class Eliminar implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			CtrlEquipos.eliminar();
		}
	}
	
	/** 
	 * ActionListener activa el dialogo para editar el cargo de un trabajador seleccionado en un proyecto concreto
	 */
	static class Editar implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			CtrlEquipos.editar();
		}
	}
}
