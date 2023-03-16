package br.com.study.gerenciador.repositorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	@SuppressWarnings("deprecation")
	public Connection getConnection()
			throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		String url = "jdbc:mysql://localhost/gerenciadorDB";
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		return DriverManager.getConnection(url, "root", "123456");
	}
}
