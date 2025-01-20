package org.tenosoft.temp.measurements;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.tenosoft.temp.measurements.driver.SmartHomeDriverManager;

import java.sql.SQLException;

@SpringBootApplication
public class Application {
/*
	@Value("${db.jdbc.dbName}")
	 private static String dbName;

		@Value("${db.jdbc.driver}")
	private static String dbDriver;

		@Value("${db.jdbc.user}")
	private static String dbUser;

	@Value("${db.jdbc.pwd}")
	private static String dbPwd;

	@Value("${db.jdbc.port}")
	private static String dbPort;

	@Value("${db.jdbc.host.name}" )
	private static String dbHostName;
	*/
/*
	public static void connectSmarthome() throws SQLException {

		SmartHomeDriverManager smartHomeDriverManager = new SmartHomeDriverManager();
		smartHomeDriverManager.setDbName(dbName);
		smartHomeDriverManager.setDbDriver(dbDriver);
		smartHomeDriverManager.setDbPort(dbPort);
		smartHomeDriverManager.setDbUser(dbUser);
		smartHomeDriverManager.setDbPwd(dbPwd);
		smartHomeDriverManager.setDbHostName(dbHostName);
		smartHomeDriverManager.getConnection();
	}
*/



	public static void main(String[] args) throws SQLException {
		//connectSmarthome();
		SpringApplication.run(Application.class, args);

	}

}
