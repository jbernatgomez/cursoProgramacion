package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/** 
 * clase DiaExit
 * @author Jorge Bernat
 * @version 1.0
 * <br/>
 * <p> Interfaz grafica del dialogo de salida del programa</p>
 */
public class DiaExit extends JDialog {

	private JPanel contentPane;

	private static final long serialVersionUID = 1L;
	
	/** 
	 * Constructor del JDialog DiaExit
	 */
	public DiaExit() {
		setModal(true);
		setTitle("Exit");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 300, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel txtSalir = new JLabel("\u00BFDesea salir de la aplicaci\u00F3n?");
		txtSalir.setBounds(75, 22, 145, 14);
		contentPane.add(txtSalir);
		
		JButton btnSi = new JButton("Si");
		btnSi.addActionListener(new ActionListener() {
			/** 
			 * ActionListener que cierra el programa
			 */
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnSi.setBounds(31, 47, 100, 30);
		contentPane.add(btnSi);
		
		JButton btnNo = new JButton("No");
		btnNo.addActionListener(new ActionListener() {
			
			/** 
			 * ActionListener que cierra el dialogo de salida
			 */
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		btnNo.setBounds(153, 47, 100, 30);
		contentPane.add(btnNo);				
		
		contentPane.setVisible(true);		
	}	
}
