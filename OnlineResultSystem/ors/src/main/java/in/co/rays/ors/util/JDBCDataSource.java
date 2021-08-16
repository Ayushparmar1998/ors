package in.co.rays.ors.util;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import in.co.rays.ors.exception.ApplicationException;

/**
 * JDBC DataSource is a Data Connection Pool
 * @author AYUSH
 *
 */
public final class JDBCDataSource {

	/**
	 * JDBC Database connection pool ( DCP )
	 */
	private static JDBCDataSource datasource;

	
	private JDBCDataSource() {}

	private ComboPooledDataSource cpds = null;

	/**
	 * Create instance of Connection Pool
	 */
	public static JDBCDataSource getInstance() {
		if (datasource == null) {

			//ResourceBundle rb = ResourceBundle.getBundle("in.co.bundle.system");

			datasource = new JDBCDataSource();
			datasource.cpds = new ComboPooledDataSource();
			try {
				datasource.cpds.setDriverClass(PropertyReader.getValue("driver"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			//datasource.cpds.setJdbcUrl(rb.getString("url"));
			datasource.cpds.setJdbcUrl(PropertyReader.getValue("url"));
			datasource.cpds.setUser(PropertyReader.getValue("username"));
			datasource.cpds.setPassword(PropertyReader.getValue("password"));
			datasource.cpds.setInitialPoolSize(DataUtility.getInt(PropertyReader.getValue("initialpoolSize")));
			datasource.cpds.setAcquireIncrement(DataUtility.getInt(PropertyReader.getValue("acquireIncrement")));
			datasource.cpds.setMaxPoolSize(DataUtility.getInt(PropertyReader.getValue("maxPoolSize")));
			datasource.cpds.setMaxIdleTime(DataUtility.getInt(PropertyReader.getValue("timeout")));
			datasource.cpds.setMinPoolSize(DataUtility.getInt(PropertyReader.getValue("minPoolSize")));

		}
		return datasource;
	}

	/**
	 * Gets the connection from ComboPooledDataSource
	 */
	public static Connection getConnection() throws Exception {
		return getInstance().cpds.getConnection();
	}

	/**
	 * Closes a connection
	 *
	 * @param connection
	 */ 
	public static void closeConnection(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (Exception e) {
			}
		}
	}

	
	public static void trnRollback(Connection connection) throws ApplicationException {
		if (connection != null) {
			try {
				connection.rollback();
			} catch (SQLException ex) {
				throw new ApplicationException(ex.toString());
			}
		}
	}

}
