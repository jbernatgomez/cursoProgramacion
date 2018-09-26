package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import controlller.CtrlProyectos;

/** 
 * clase DiaProyectos
 * @author Jorge Bernat
 * @version 1.0
 * <br/>
 * <p> Interfaz grafica para añadir, editar o mostrar proyectos</p>
 */
public class DiaProyectos extends JDialog {

	private JPanel contentPane;

	private static final long serialVersionUID = 1L;

	public static JTextField textField_1;
	public static JTextField textField_2;
	public static JTextField textField_3;
	public static JTextField textField_4;
	private JButton btnOK;
	
	/** 
	 * Constructor del JDialog DiaProyectos
	 */
	public DiaProyectos() {		
		setModal(true);		
		setTitle("Proyecto");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		textField_1 = new JTextField();
		textField_1.setBounds(130, 30, 250, 30);
		textField_1.setColumns(10);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(130, 80, 250, 30);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(130, 130, 250, 30);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(130, 180, 250, 30);
		contentPane.add(textField_4);
		
		JLabel etiqueta1 = new JLabel("Nombre: ");
		etiqueta1.setBounds(25, 35, 100, 15);
		contentPane.add(etiqueta1);
		
		JLabel etiqueta2 = new JLabel("Presupuesto: ");
		etiqueta2.setBounds(25, 85, 100, 15);
		contentPane.add(etiqueta2);
		
		JLabel etiqueta3 = new JLabel("Fecha inicio: ");
		etiqueta3.setBounds(25, 135, 100, 15);
		contentPane.add(etiqueta3);
		
		
		JLabel etiqueta4 = new JLabel("Fecha fin: ");
		etiqueta4.setBounds(25, 185, 100, 15);
		contentPane.add(etiqueta4);			
		
		btnOK = new JButton("OK");
		btnOK.setBounds(291, 227, 89, 23);
		btnOK.addActionListener(new Ok());
		contentPane.add(btnOK);
	}
	
	/** 
	 * ActionListener que activa la ocion elegida, ya sea añadir, editar o cerrar el dialogo con la informacion
	 */
	class Ok implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			CtrlProyectos.ok();
			dispose();	
		}				
	}
}
