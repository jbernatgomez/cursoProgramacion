package dbManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

/**
 * clase DBSQLServer
 * 
 * @author Jorge Bernat
 * @version 1.0
 * 
 *          <p>
 *          Controla las conexiones de la aplicacion con  la base de datos y sus consiguientes peticiones.
 *          </p>
 */
public class DBSQLServer {
	
		public static String cadena;
		private static ResultSet r;
	
		/**
		 * Genera un string con los datos recogidos que funciona como orden deconexion con la base de datos	 
		 * @param String ip , String port, String db, String user, String password
		 */
		public static void generarCadena(String ip , String port, String db, String user, String password) {		
		cadena = "jdbc:sqlserver://"+ ip+":"+port+";databaseName=" + db + ";user="+ user + ";password=" + password;			
		}		
		
		/**
		 * Devuelve verdadero o falso segun si se ha podido establecer la conexion o no 
		 * @return boolean
		 */		
		public static boolean testConexion(){
			boolean test = false;
			try {
				Connection conn =  establecerConexion();
				test = true;
				cerrarConexion(conn);
			}catch(Exception e)	{
				test = false;
			}				
			return test;
		}
		
		/**
		 * Establece una conexion con el servidor atendiendo a la orden de conexion generada 
		 * @return Connection
		 */	
		public static Connection establecerConexion() throws SQLException{			
			return DriverManager.getConnection(cadena);			
		}
		
		/**
		 * Cierra la conexion abierta 
		 * @param Connection conn
		 */		
		public static void cerrarConexion(Connection conn) throws SQLException{
			conn.close();	
		}
		
		/**
		 * Devuelve los datos de una consulta SQL dada a la base de datos para una lista.
		 * @param String strSQL
		 * @return CachedRowSet
		 */
		public static CachedRowSet consultaSQLLista(String strSQL) throws SQLException {
			Connection conn = dbManager.DBSQLServer.establecerConexion();
			Statement s = conn.createStatement();
			ResultSet r = s.executeQuery(strSQL);	
			RowSetFactory factory = RowSetProvider.newFactory();
			CachedRowSet rowset = factory.createCachedRowSet();
			rowset.populate(r);
			dbManager.DBSQLServer.cerrarConexion(conn);
			
			return rowset;
		}
		
		/**
		 * Ejecuta una orden SQL dada a la base de datos.
		 * @param String strSQL
		 */
		public static void ejecutaSQL(String strSQL) throws SQLException {	
			Connection conn = dbManager.DBSQLServer.establecerConexion();			
			Statement s = conn.createStatement(); 		         
			s.executeUpdate(strSQL);
			dbManager.DBSQLServer.cerrarConexion(conn);			
		}
		
		/**
		 * Inserta  datos dados a la base de datos mediante SQL.
		 * @param String strSQL
		 */		
		public static void insertarSQL(String strSQL) throws SQLException {	
			Connection conn = dbManager.DBSQLServer.establecerConexion();			
			Statement s = conn.createStatement(); 		         
			s.execute(strSQL);
			dbManager.DBSQLServer.cerrarConexion(conn);			
		}
		
		/**
		 * Devuelve los datos de una consulta SQL dada a la base de datos para una tabla.
		 * @param String strSQL
		 * @return CachedRowSet
		 */
		public static CachedRowSet consultaSQLTabla (String instruccion) throws SQLException{			
			Connection c = dbManager.DBSQLServer.establecerConexion();
			Statement s = c.createStatement();
			r = s.executeQuery(instruccion);
			
			RowSetFactory factory = RowSetProvider.newFactory();
			CachedRowSet rowset = factory.createCachedRowSet();
			 
			rowset.populate(r);
			dbManager.DBSQLServer.cerrarConexion(c);
			
			return rowset;			
		}
		
		/**
		 * Devuelve los metadatos de la ultima consulta SQL realizada.
		 * @return ResultSetMetaData
		 */		
		public static ResultSetMetaData metadataSQL () {
			ResultSetMetaData rsmd= null;
			try {
				rsmd = r.getMetaData();				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return rsmd;
		}
		
		/**
		 * Devuelve el numero de columnas de la ultima consulta realizada.
		 * @return int
		 */			
		public static int numeroColSQL () {
			int numeroCampos = 0;
			try {
				ResultSetMetaData rsmd = r.getMetaData();			
				numeroCampos = rsmd.getColumnCount();
			} catch (SQLException e) {
				e.printStackTrace();
			}	
			return numeroCampos;
		}
}
