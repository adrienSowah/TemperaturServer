package org.tenosoft.temp.measurements.driver;

import java.sql.Connection;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@Component
public class SmartHomeDriverManager {

	private final static Logger   log = LoggerFactory.getLogger(SmartHomeDriverManager.class);
	

	@Value("${db.jdbc.dbName}")
	 private String dbName;
	@Value("${db.jdbc.driver}")
	private String dbDriver;
	@Value("${db.jdbc.user}")
	private String dbUser;
	@Value("${db.jdbc.pwd}")
	private String dbPwd;
	@Value("${db.jdbc.port}")
	private String dbPort;
	@Value("${db.jdbc.dbHostName}")
	private String dbHostName;

			
	public SmartHomeDriverManager() {
		
	}


	public  Connection getConnection() throws SQLException {
		Connection conn = null;
		log.debug("Connection will be created with dbDriver {}", dbDriver);
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


	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public String getDbDriver() {
		return dbDriver;
	}

	public void setDbDriver(String dbDriver) {
		this.dbDriver = dbDriver;
	}

	public String getDbUser() {
		return dbUser;
	}

	public void setDbUser(String dbUser) {
		this.dbUser = dbUser;
	}

	public String getDbPwd() {
		return dbPwd;
	}

	public void setDbPwd(String dbPwd) {
		this.dbPwd = dbPwd;
	}

	public String getDbPort() {
		return dbPort;
	}

	public void setDbPort(String dbPort) {
		this.dbPort = dbPort;
	}

	public String getDbHostName() {
		return dbHostName;
	}

	public void setDbHostName(String dbHostName) {
		this.dbHostName = dbHostName;
	}

	public static void main(String[] args) {
		SmartHomeDriverManager test = new SmartHomeDriverManager();
		//test.getConnection();
	//test.insertPreparedStatement("Remi", 1);
	//test.insertPreparedStatement("Bathroom", 1);
		
		
	}
	
}

