package logic;

import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;

public class LogicEquipos {
	
	public static CachedRowSet obtenerIdProyecto(String nombredProyecto) throws SQLException {
		String strSQL ="SELECT	id FROM [dbo].[JBProyectos] where Nombre = '" + nombredProyecto +"'";		
		return dbManager.DBSQLServer.consultaSQLLista(strSQL);
	}
	
	
	public static CachedRowSet obtenerTablaEquipo(int idProyecto) throws SQLException {
		String strSQL ="SELECT	c.DNI, a.Nombre 	FROM	[dbo].[JBCargos] a INNER JOIN [dbo].[JBEquipos] b ON a.ID = b.Cargo INNER JOIN  [dbo].[JBTrabajador] c  ON b.Trabajador = c.ID\r\nwhere	b.Proyecto = "+idProyecto;		
		return dbManager.DBSQLServer.consultaSQLTabla(strSQL);
	}
	
	
	public static CachedRowSet obtenerMaxIdEequipos() throws SQLException {
		String strSQL = "SELECT id FROM dbo.JBEquipos a WHERE a.id= (SELECT MAX( id)  FROM JBEquipos)";
		return dbManager.DBSQLServer.consultaSQLLista(strSQL);
	}
	
	public static void insertarTrabajadorEq (int idEquipo, int idProyecto,	int idTrabajador, int idCargo) throws SQLException {
		String strSQL = "INSERT dbo.JBEquipos (ID, Proyecto, Trabajador, Cargo) VALUES ("+idEquipo+", "+idProyecto+", "+idTrabajador+", "+idCargo+")";				
		dbManager.DBSQLServer.ejecutaSQL(strSQL);
	}

	public static void borrarTrabajadorEq(int idTrabajador, int idProyecto, int idCargo) throws SQLException {
		String strSQL = "DELETE	dbo.JBEquipos FROM JBEquipos WHERE JBEquipos.Trabajador = "+ idTrabajador+" and JBEquipos.Proyecto = " +idProyecto+ " and JBEquipos.Cargo = " + idCargo ;
		dbManager.DBSQLServer.ejecutaSQL(strSQL);
	}
	
	public static CachedRowSet obtenerIdCargo(String nombre) throws SQLException {
		String strSQL = "SELECT id FROM dbo.JBCargos WHERE  dbo.JBCargos.Nombre = '"+ nombre+"'";
		return dbManager.DBSQLServer.consultaSQLLista(strSQL);
		
	}	
	
	public static CachedRowSet obtenerCargos() throws SQLException {
		String strSQL = "SELECT nombre FROM dbo.JBCargos";
		return dbManager.DBSQLServer.consultaSQLLista(strSQL);
		
	}
	
	public static void editarCargoT(int idProyecto, int idTrabajador, int idCargo, int idCargoN) throws SQLException {
		String strSQL = "UPDATE dbo.JBEquipos SET Cargo = "+idCargoN+" WHERE Proyecto = "+idProyecto+" and Trabajador = " +idTrabajador +" and Cargo = " + idCargo;			
		dbManager.DBSQLServer.ejecutaSQL(strSQL);
		
	}
	
	
	/*
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
*/
}
