package logic;

import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;

public class LogicProyectos {

	public static CachedRowSet obtenerNombreProyectos() throws SQLException {
		String strSQL = "SELECT Nombre FROM dbo.JBProyectos";
		return dbManager.DBSQLServer.consultaSQLLista(strSQL);
	}
	
	public static CachedRowSet obtenerMaxIdProyectos() throws SQLException {
		String strSQL = "SELECT id FROM dbo.JBProyectos a WHERE a.id= (SELECT MAX( id)  FROM dbo.JBProyectos)";
		return dbManager.DBSQLServer.consultaSQLLista(strSQL);
	}

	public static void insertarProyecto(int id, String a,	Float b, String c,	String d) throws SQLException {
		String strSQL = "INSERT dbo.JBProyectos (ID, Nombre, Presupuesto, Inicio, Fin) VALUES ("+id+", '"+a+"', '"+b+"', '"+c+"', '"+d+"')";
		dbManager.DBSQLServer.ejecutaSQL(strSQL);
	}

	public static void borrarProyecto(String a) throws SQLException {
		String strSQL = "DELETE	dbo.JBProyectos FROM dbo.JBProyectos WHERE JBProyectos.Nombre = '"+ a+"'";
		dbManager.DBSQLServer.ejecutaSQL(strSQL);
		
	}
	
	public static void editarProyecto(int id, String a,	Float b, String c,	String d) throws SQLException {
		String strSQL = "UPDATE dbo.JBProyectos SET Nombre = '"+a+"', Presupuesto = '"+b+"', Inicio = '"+c+"', Fin = '"+d+"' WHERE ID = '"+id+"'";
		System.out.println(strSQL);
		
		dbManager.DBSQLServer.ejecutaSQL(strSQL);
		
	}
	
	public static CachedRowSet obtenerIdProyecto(String nombre) throws SQLException {
		String strSQL = "SELECT	Id FROM dbo.JBProyectos WHERE JBProyectos.Nombre = '" + nombre+"'";
		return dbManager.DBSQLServer.consultaSQLLista(strSQL);
	}
	
	public static CachedRowSet obtenerNombreProyecto(String nombre) throws SQLException {
		String strSQL = "SELECT	Nombre FROM dbo.JBProyectos WHERE JBProyectos.Nombre = '" + nombre+"'";	
		return dbManager.DBSQLServer.consultaSQLLista(strSQL);
	}
	
	public static CachedRowSet obtenerPresupuestoProyecto(String nombre) throws SQLException {
		String strSQL = "SELECT	Presupuesto FROM dbo.JBProyectos WHERE JBProyectos.Nombre = '" + nombre+"'";
		return dbManager.DBSQLServer.consultaSQLLista(strSQL);
	}
	
	public static CachedRowSet obtenerInicioProyecto(String nombre) throws SQLException {
		String strSQL = "SELECT	Inicio FROM dbo.JBProyectos WHERE JBProyectos.Nombre = '" + nombre+"'";
		return dbManager.DBSQLServer.consultaSQLLista(strSQL);
	}
	
	public static CachedRowSet obtenerFinProyecto(String nombre) throws SQLException {
		String strSQL = "SELECT	Fin FROM dbo.JBProyectos WHERE JBProyectos.Nombre = '" + nombre+"'";
		return dbManager.DBSQLServer.consultaSQLLista(strSQL);
	}
}
