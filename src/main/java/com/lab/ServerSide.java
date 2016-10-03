package com.lab;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServerSide {
	private static Connection getDBConnection() {
		Connection dbConnection = null;
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		try {
			dbConnection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProjectsAndOrders", "postgres",
					"20FREEdom08");
			return dbConnection;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return dbConnection;
	}

	public static void insertCustomer(int customers_id, String name){
		Connection dbConnection = null;
		Statement statement = null;
		String insertTableSQL = "INSERT INTO CUSTOMERS" + "(customers_id,name)" + "VALUES" + "("+customers_id+","+name+")";
		dbConnection = getDBConnection();
		try {
			statement = dbConnection.createStatement();
			statement.executeUpdate(insertTableSQL);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		SpringApplication.run(ServerSide.class, args);
		insertCustomer(1,"name");
		/*try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProjectsAndOrders",
					"postgres", "20FREEdom08");
			connection.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int customers_id = 1;
		Connection dbConnection = null;
		Statement statement = null;

		String insertTableSQL = "INSERT INTO CUSTOMERS" + "(CUSTOMERS_ID, NAME) " + "VALUES" + "(1,'Ivan Ivanov')";
		dbConnection = getDBConnection();
		try {
			statement = dbConnection.createStatement();
			statement.executeUpdate(insertTableSQL);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}

}