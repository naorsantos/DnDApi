package br.com.naor.magiasdndapi.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DbConfig {

	private static final String DB_DATABASENAME = "db.databasename";

	private static final String DB_PORTNUMBER = "db.portnumber";

	private static final String DB_PASSWORD = "db.password";

	private static final String DB_USER = "db.user";

	private static final String DB_SERVER_NAME = "db.servername";

	private static final String DB_PROPERTIES = "db.properties";

	private String dbServerName;
	private int dbPortNumber;
	private String dbName;
	private String dbUser;
	private String dbPassword;

	private static Properties properties;

	public DbConfig() {

		Properties dbProperties = loadDbProperties();

		this.dbServerName = dbProperties.getProperty(DB_SERVER_NAME);
		this.dbPortNumber = Integer.valueOf(dbProperties.getProperty(DB_PORTNUMBER, "3306"));
		this.dbName = dbProperties.getProperty(DB_DATABASENAME);
		this.dbUser = dbProperties.getProperty(DB_USER);
		this.dbPassword = dbProperties.getProperty(DB_PASSWORD);
	}

	private Properties loadDbProperties() {

		if (properties == null) {

			properties = new Properties();

			try (InputStream resourceAsStream = DbConfig.class.getClassLoader().getResourceAsStream(DB_PROPERTIES)) {

				if (resourceAsStream == null) {
					System.out.println("Arquivo de configuracao nao encontrado");
					System.exit(0);
				}

				properties.load(resourceAsStream);

			} catch (IOException e) {
				System.err.println("Erro ao ler arquivo de configuracao");
				e.printStackTrace();
				System.exit(0);
			}
		}
		return properties;

	}

	public String getServerName() {
		return dbServerName;
	}

	public int getDbPortNumber() {
		return dbPortNumber;
	}

	public String getDbName() {
		return dbName;
	}

	public String getDbUser() {
		return dbUser;
	}

	public String getDbPassword() {
		return dbPassword;
	}

}
