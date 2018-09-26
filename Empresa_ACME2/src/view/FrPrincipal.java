package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;

import javax.help.HelpBroker;
import javax.help.HelpSet;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
//import javax.print.DocFlavor.URL;

import controlller.CtrlPrincipal;

/** 
 * clase FrPrincipal
 * @author Jorge Bernat
 * @version 1.0
 * <br/>
 * <p> Interfaz grafica principal que contiene el menu principal de la aplicacion </p>
 */
public class FrPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	public JLabel lblConectado;
	public JLabel lblNoConectado;
	public JMenuBar menuBar;
	public JMenuItem menuAyuda;
	
	
	/** 
	 * Constructor del JFrame FrPrincipal
	 */
	public FrPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu base = new JMenu("Base");
		menuBar.add(base);
		
		JMenuItem proyectos = new JMenuItem("Proyectos");
		proyectos.addActionListener(new BtnProyectos());
		base.add(proyectos);
		
		JMenuItem trabajadores = new JMenuItem("Trabajadores");
		trabajadores.addActionListener(new BtnTrabajadores());
		base.add(trabajadores);
		
		JSeparator separator = new JSeparator();
		base.add(separator);
		
		JMenuItem salir = new JMenuItem("Salir");		
		salir.addActionListener(new Salir());
		base.add(salir);
		
		JMenu gestion = new JMenu("Gestion");
		menuBar.add(gestion);
		
		JMenuItem equipos = new JMenuItem("Equipos");
		equipos.addActionListener(new BtnEquipos());
		gestion.add(equipos);
		
		JMenu ayuda = new JMenu("Ayuda");
		menuBar.add(ayuda);
		
		menuAyuda = new JMenuItem("Menu de ayuda");
		equipos.addActionListener(new BtnAyuda());
		ayuda.add(menuAyuda);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		lblConectado = new JLabel("Conectado");
		lblConectado.setHorizontalAlignment(SwingConstants.CENTER);
		lblConectado.setFont(new Font("Tahoma", Font.BOLD, 48));
		lblConectado.setBounds(40, 80, 350, 60);
		contentPane.add(lblConectado);
		
		lblNoConectado = new JLabel("Desconectado");
		lblNoConectado.setHorizontalAlignment(SwingConstants.CENTER);
		lblNoConectado.setFont(new Font("Tahoma", Font.BOLD, 47));
		lblNoConectado.setForeground(Color.RED);
		lblNoConectado.setBounds(40, 80, 350, 60);
		contentPane.add(lblNoConectado);
	}
	
	/** 
	 * ActionListener que activa el dialogo de salida
	 */
	
	static class Salir implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			DiaExit salida = new DiaExit();
			salida.setVisible(true);
		}
	}
	
	/** 
	 * ActionListener que activa la opcion proyectos
	 */
	static class BtnProyectos implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {			
			CtrlPrincipal.inicioProyectos();			
		}
	}
	
	/** 
	 * ActionListener que activa la opcion trabajadores
	 */
	static class BtnTrabajadores implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			CtrlPrincipal.inicioTrabajadores();				
		}
	}
	
	/** 
	 * ActionListener que activa la opcion equipos
	 */
	static class BtnEquipos implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {						
			CtrlPrincipal.inicioEquipos();			
		}
	}
	
	/** 
	 * ActionListener que activa el menu de ayuda
	 */
	static class BtnAyuda implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {						
			//CtrlPrincipal.ayuda();			
		}
	}
	
	public void ayuda() {
		try {
			// Carga el fichero de ayuda
			File fichero = new File("Proyecto/src/help/help.hs");
			URL hsURL = fichero.toURI().toURL();
		 
			// Crea el HelpSet y el HelpBroker
			HelpSet helpset = new HelpSet(getClass().getClassLoader(), hsURL);
			HelpBroker hb = helpset.createHelpBroker();
		 
			// Pone ayuda a item de menu al pulsar F1. mntmIndice es el JMenuitem
			hb.enableHelpOnButton(menuAyuda, "manual", helpset);
			hb.enableHelpKey(this.getContentPane(), "ventana_principal", helpset);
		 
		} catch (Exception e) {
			System.out.println("Error al cargar la ayuda: " + e);
		}
	}	
	
}
