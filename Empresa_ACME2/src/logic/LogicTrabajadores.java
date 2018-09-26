package logic;

import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;

public class LogicTrabajadores {
	
	public static CachedRowSet obtenerTrabajadores() throws SQLException {
		String strSQL = "SELECT * FROM dbo.JBTrabajador";
		return dbManager.DBSQLServer.consultaSQLLista(strSQL);
	}

	
	public static CachedRowSet obtenerNombreTrabajadores() throws SQLException {
		String strSQL = "SELECT dni FROM dbo.JBTrabajador";
		return dbManager.DBSQLServer.consultaSQLLista(strSQL);
	}
	
	
	public static CachedRowSet obtenerMaxIdTrabajadores() throws SQLException {
		String strSQL = "SELECT id FROM dbo.JBTrabajador a WHERE a.id= (SELECT MAX( id)  FROM JBTrabajador)";
		return dbManager.DBSQLServer.consultaSQLLista(strSQL);
	}

	public static void insertarTrabajador(int id, String a,	String b, String c,	String d) throws SQLException {
		String strSQL = "INSERT dbo.JBTrabajador (ID, DNI, Nombre, Apellidos, Genero) VALUES ("+id+", '"+a+"', '"+b+"', '"+c+"', '"+d+"')";
		dbManager.DBSQLServer.ejecutaSQL(strSQL);
	}

	public static void borrarTrabajador(int a) throws SQLException {
		String strSQL = "DELETE	dbo.JBTrabajador FROM JBTrabajador WHERE JBTrabajador.id = '"+ a+"'";
		dbManager.DBSQLServer.ejecutaSQL(strSQL);
		
	}
	
	public static void editarTrabajador(int id, String a,	String b, String c,	String d) throws SQLException {
		String strSQL = "UPDATE dbo.JBTrabajador SET DNI = '"+a+"', Nombre = '"+b+"', Apellidos = '"+c+"', Genero = '"+d+"' WHERE ID = '"+id+"'";
		dbManager.DBSQLServer.ejecutaSQL(strSQL);
	}
	
	public static CachedRowSet obtenerIdTrabajador(String dni) throws SQLException {
		String strSQL = "SELECT	Id FROM dbo.JBTrabajador WHERE JBTrabajador.DNI = '" + dni+"'";
		return dbManager.DBSQLServer.consultaSQLLista(strSQL);
	}
	
	public static CachedRowSet obtenerDniTrabajador(String dni) throws SQLException {
		String strSQL = "SELECT	DNI FROM dbo.JBTrabajador WHERE JBTrabajador.DNI = '" + dni+"'";	
		return dbManager.DBSQLServer.consultaSQLLista(strSQL);
	}
	
	public static CachedRowSet obtenerNombreTrabajador(String dni) throws SQLException {
		String strSQL = "SELECT	Nombre FROM dbo.JBTrabajador WHERE JBTrabajador.DNI = '" + dni+"'";
		return dbManager.DBSQLServer.consultaSQLLista(strSQL);
	}
	
	public static CachedRowSet obtenerApellidosTrabajador(String dni) throws SQLException {
		String strSQL = "SELECT	Apellidos FROM dbo.JBTrabajador WHERE JBTrabajador.DNI = '" + dni+"'";
		return dbManager.DBSQLServer.consultaSQLLista(strSQL);
	}
	
	public static CachedRowSet obtenerGeneroTrabajador(String dni) throws SQLException {
		String strSQL = "SELECT	Genero FROM dbo.JBTrabajador WHERE JBTrabajador.DNI = '" + dni+"'";
		return dbManager.DBSQLServer.consultaSQLLista(strSQL);
	}
}
