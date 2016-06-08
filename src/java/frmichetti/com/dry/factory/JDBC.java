/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see mailto:frmichetti@gmail.com
 * */
package frmichetti.com.dry.factory;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import frmichetti.com.dry.LoadProperties;
import frmichetti.com.dry.factory.exception.ConnectionException;

public final class JDBC {	

	private Properties properties;

	private Connection connection;

	private Context ctx = null;

	private DataSource ds = null;

	private String url = "jdbc:mysql://%s:%s/%s";
	private String dbHost ;
	private String dbPort ;
	private String dbName ;	
	private String dbLogin ;
	private String dbPassword ;
	private String jndiName ;

	private void doLoadProperties(){

		try {

			properties = LoadProperties.readProperties(new File("./src/resources/META-INF/properties.properties"));

			dbHost = properties.getProperty("dbHost");

			dbPort = properties.getProperty("dbPort");

			dbName = properties.getProperty("dbName") ;

			dbLogin = properties.getProperty("dbLogin");

			dbPassword = properties.getProperty("dbPassword") ;

			jndiName = properties.getProperty("jndiName");


		} catch (IOException e) {

			throw new RuntimeException("File properties Not Found ", e);
		}

	}

	private JDBC() {

		doLoadProperties();

		try {

			doLoadJNDIConnection();

			System.out.println("Connected with JNDI !");			

		} catch (ConnectionException e) {

			System.err.println("Failed to load JNDI, trying to load Driver Manager \n " + e);

			try {

				doLoadDriverManager();

				System.out.println("Connected with Driver Manager !");

			} catch (ConnectionException ex) {

				throw new RuntimeException("Failed to load Driver Manager \n" + ex);
			}			

		} 		
	}


	public Connection getConnection() {

		return connection;
	}

	public void doCloseConnection() {
		try {
			if (!connection.isClosed()) {
				connection.close();
				System.out.println("Connection was closed");
			} else {
				System.out.println("Connection already closed");
			}
		} catch (SQLException ex) {
			System.err.println(ex);
		}
	}

	private void doLoadDriverManager() throws ConnectionException {

		System.out.println("[doLoadDriverManager]");

		url = String.format(url, dbHost, dbPort, dbName);


		try {			

			connection = (Connection) DriverManager.getConnection(url, dbLogin, dbPassword);		


		} catch (SQLException ex) {

			throw new ConnectionException("Could not load Driver Manager, check the properties of the connection. : " + ex);
		}		

	}

	private void doLoadJNDIConnection() throws ConnectionException {
		System.out.println("[doLoadJNDIConnection]");

		try {
			ctx = new InitialContext();

			ds = (DataSource) ctx.lookup(jndiName);

			connection = ds.getConnection();

		} catch (NamingException | SQLException ex) {

			throw new ConnectionException("Could not load Driver Manager, check the properties of the connection. :" + ex);

		}	

		
	}

}
