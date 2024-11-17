package br.com.fatec.service;

import java.sql.DriverManager;
import java.sql.SQLException;


public class Connection {

	private String schema = "jdbc:mariadb://localhost:3306/bd_progweb_java";

	public java.sql.Connection ConnectionClass() {
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
