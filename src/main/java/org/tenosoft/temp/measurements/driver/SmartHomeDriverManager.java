package org.tenosoft.temp.measurements.driver;

import java.sql.Connection;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class SmartHomeDriverManager {

	private final static Logger   log = LoggerFactory.getLogger(SmartHomeDriverManager.class);
	
	
	@Value("${db.jdbc.dbName}")
	String dbName;
	
	@Value("${db.jdbc.driver}")
	String dbDriver;
	
	@Value("${db.jdbc.user}")
	String dbUser;
	
	@Value("${db.jdbc.pwd}")
	String dbPwd;
	
	@Value("${db.jdbc.port}")
	String dbPort;
	
	@Value("${db.jdbc.host.name}")
	String dbHostName;

			
	public SmartHomeDriverManager() {
		
	}
	
	public Connection getConnection() throws SQLException {
		Connection conn = null;
		log.debug("Connection will be created");
		String dbURL = dbDriver +"://" + dbHostName+":"+ dbPort+"/" + dbName;
	   	conn = java.sql.DriverManager.getConnection(
	   			dbURL, dbUser, dbPwd);

         if (conn != null) {
        	 log.info("Connectin to database successfuly create");
        	 conn.setAutoCommit(false);
            } else {
                log.error("Error occured whilst creating database connection");
          }
        
		return conn;
	}
	
	
	
	
	

	
	
	public static void main(String[] args) {
		SmartHomeDriverManager test = new SmartHomeDriverManager();
		//test.getConnection();
	//test.insertPreparedStatement("Remi", 1);
	//test.insertPreparedStatement("Bathroom", 1);
		
		
	}
	
}

