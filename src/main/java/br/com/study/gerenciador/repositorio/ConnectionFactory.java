package br.com.study.gerenciador.repositorio;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {

	private DataSource dataSource;

	@SuppressWarnings("deprecation")
	public ConnectionFactory() {
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/gerenciadorDB");
			comboPooledDataSource.setUser("root");
			comboPooledDataSource.setPassword("123456");
			comboPooledDataSource.setMaxPoolSize(10);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		this.dataSource = comboPooledDataSource;
	}

	public Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
}
