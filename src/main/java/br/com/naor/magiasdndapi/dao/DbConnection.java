package br.com.naor.magiasdndapi.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mysql.cj.jdbc.MysqlDataSource;

import br.com.naor.magiasdndapi.config.DbConfig;

public class DbConnection {
	
	private static final Logger LOGGER  = LoggerFactory.getLogger(DbConnection.class);

	private static MysqlDataSource dataSource;
	
	private static DbConfig dbConfig;

	private static DataSource getDataSource() {
		if (dataSource == null && dbConfig == null) {
			LOGGER.info("INICIALIZANDO CONFIGURACAO DE CONEXAO");
			dataSource = new MysqlDataSource();
			dbConfig = new DbConfig();
			dataSource.setServerName(dbConfig.getServerName());
			dataSource.setPortNumber(dbConfig.getDbPortNumber());
			dataSource.setDatabaseName(dbConfig.getDbName());
			dataSource.setUser(dbConfig.getDbUser());
			dataSource.setPassword(dbConfig.getDbPassword());

		}
		LOGGER.info("CONEXAO ESTABELECIDA");
		return dataSource;
	}

	public static Connection getConnection() throws SQLException {
		LOGGER.info("BUSCANDO CONEXAO COM BANCO");
		return getDataSource().getConnection();
	}
}
