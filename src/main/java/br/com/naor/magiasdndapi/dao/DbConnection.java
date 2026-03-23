package br.com.naor.magiasdndapi.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlDataSource;

import br.com.naor.magiasdndapi.config.DbConfig;

public class DbConnection {

	private static MysqlDataSource dataSource;
	
	private static DbConfig dbConfig;

	private static DataSource getDataSource() {
		if (dataSource == null && dbConfig == null) {
			dataSource = new MysqlDataSource();
			dbConfig = new DbConfig();
			dataSource.setServerName(dbConfig.getServerName());
			dataSource.setPortNumber(dbConfig.getDbPortNumber());
			dataSource.setDatabaseName(dbConfig.getDbName());
			dataSource.setUser(dbConfig.getDbUser());
			dataSource.setPassword(dbConfig.getDbPassword());

		}

		return dataSource;
	}

	public static Connection getConnection() throws SQLException {
		return getDataSource().getConnection();
	}
}
