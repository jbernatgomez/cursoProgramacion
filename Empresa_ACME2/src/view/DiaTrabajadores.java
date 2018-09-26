package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controlller.CtrlTrabajadores;

/** 
 * clase DiaTrabajadores
 * @author Jorge Bernat
 * @version 1.0
 * <br/>
 * <p> Interfaz grafica para añadir, editar o mostrar trabajadores</p>
 */
public class DiaTrabajadores extends JDialog{	

	private static final long serialVersionUID = 1L;

	public  JPanel contentPane;
	public static JTextField textField_1;
	public static JTextField textField_2;
	public static  JTextField textField_3;
	public static  JTextField textField_4;
	public static  JCheckBox masculino;
	public static  JCheckBox femenino;
	public static  ButtonGroup genero;
	public static  JButton btnOK;
	
	/** 
	 * Constructor del JDialog FrTrabajadores
	 */
	public DiaTrabajadores() {		
		setModal(true);
		setTitle("Trabajador");
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
		
		genero = new ButtonGroup ();
		
		masculino =new JCheckBox("Masculino", true);
		masculino.setBounds(130, 185, 100, 20);
		contentPane.add(masculino);		
		
		femenino =new JCheckBox("Femenino", false);
		femenino.setBounds(250, 185, 100, 20);
		contentPane.add(femenino);	
		
		genero.add(masculino);
		genero.add(femenino);
		
		JLabel etiqueta1 = new JLabel("DNI: ");
		etiqueta1.setBounds(25, 35, 100, 15);
		contentPane.add(etiqueta1);
		
		JLabel etiqueta2 = new JLabel("Nombre: ");
		etiqueta2.setBounds(25, 85, 100, 15);
		contentPane.add(etiqueta2);
		
		JLabel etiqueta3 = new JLabel("Apellidos: ");
		etiqueta3.setBounds(25, 135, 100, 15);
		contentPane.add(etiqueta3);
				
		JLabel etiqueta4 = new JLabel("Genero: ");
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
			CtrlTrabajadores.ok();
			dispose();
		}				
	}
}
