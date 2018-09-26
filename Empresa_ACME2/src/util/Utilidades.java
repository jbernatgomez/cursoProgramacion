package util;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.CachedRowSet;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

import model.Trabajador;

/**
 * clase Utilidades
 * 
 * @author Jorge Bernat
 * @version 1.0
 * 
 *          <p>
 *          Clase que genera los distintos modelos necesarios para cargar los
 *          elementos visuales con los datos de las bases de datos
 *          </p>
 */
public class Utilidades {

	/**
	 * Crea un modelo para una tabla	 
	 * @param CachedRowSet resultado
	 * @return DefaultTableModel
	 */
	public static DefaultTableModel crearModeloTabla(CachedRowSet resultado) throws SQLException {

		DefaultTableModel modelo = new DefaultTableModel();

		ResultSetMetaData md = resultado.getMetaData();

		int totalCampos = md.getColumnCount();

		for (int i = 1; i <= totalCampos; i++) {
			modelo.addColumn(md.getColumnName(i));
		}

		String[] campo = new String[totalCampos];
		while (resultado.next()) {
			for (int i = 1; i <= totalCampos; i++) {
				campo[i - 1] = resultado.getString(i);
			}
			modelo.addRow(campo);
		}

		return modelo;

	}

	/**
	 * Crea un modelo para una lista
	 * 
	 * @param CachedRowSet
	 *            resultado
	 * @return DefaultListModel
	 */
	public static DefaultListModel<String> crearModeloLista(CachedRowSet resultado) throws SQLException {
		DefaultListModel<String> modelo = new DefaultListModel<String>();
		while (resultado.next()) {
			modelo.addElement(resultado.getString(1));
		}
		return modelo;
	}

	/**
	 * Crea un modelo para una lista de trabajadores
	 * 
	 * @data List<Trabajador> trabajadores
	 * @return DefaultListModel
	 */
	public static DefaultListModel<String> crearModeloListaTrabajadores(List<Trabajador> trabajadores) throws SQLException {
		DefaultListModel<String> modelo = new DefaultListModel<String>();
		int totalDatos = trabajadores.size();
		for (int i = 0; i < totalDatos; i++) {
			modelo.addElement(trabajadores.get(i).getDni());
		}
		return modelo;
	}
}
