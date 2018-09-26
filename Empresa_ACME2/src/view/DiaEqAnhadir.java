package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controlller.CtrlEquipos;

/** 
 * clase DiaEqAnhadir
 * @author Jorge Bernat
 * @version 1.0
 * <br/>
 * <p> Interfaz grafica para la edicion del cargo de un trabajador seleccionado en un proyecto concreto</p>
 */
public class DiaEqAnhadir extends JDialog{
	
	private static final long serialVersionUID = 1L;

	public static JList<String> trabajadores;
	//private static int equipoSeleccionado = -1;

	private JPanel contentPanel;

	/** 
	 * Constructor del JDialog DiaEqAnhadir
	 */
	public DiaEqAnhadir() {
		setModal(true);
		setTitle("Trabajadores");
		setBounds(100, 100, 300, 350);		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());		
		contentPanel = new JPanel();
		contentPanel.setLayout(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		
		JLabel lblNewLabel = new JLabel("Trabajadores");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(90, 20, 100, 15);
		contentPanel.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 50, 200, 200);
		contentPanel.add(scrollPane);
		
		trabajadores = new JList<String>();
		scrollPane.setViewportView(trabajadores);
		
		JButton btnNewButton = new JButton("Asignar");
		btnNewButton.setBounds(90, 260, 100, 40);
		btnNewButton.addActionListener(new insertar());
		contentPanel.add(btnNewButton);		
	}
	

	/** 
	 * ActionListener que ejecuta la asignacion de un trabajador elejido a un proyecto determinado 
	 */
	class insertar implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {				
			CtrlEquipos.insertarTrabajador();
			dispose();			
		}
	}

}
