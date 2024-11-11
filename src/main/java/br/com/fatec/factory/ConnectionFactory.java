package br.com.fatec.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {

	private String schema = "jdbc:mariadb://localhost:3306/BD_ProgWeb_Java";

	public Connection ConnectionClass() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			return DriverManager.getConnection(this.schema, "root", "root");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
