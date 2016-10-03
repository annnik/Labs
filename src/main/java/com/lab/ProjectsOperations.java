package com.lab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ProjectsOperations {

	public void insertCustomer(int customers_id, String name){
		Connection dbConnection = null;
		Statement statement = null;
		String insertTableSQL = "INSERT INTO CUSTOMERS" + "(customers_id,name)" + "VALUES" + "("+customers_id+name+")";
		dbConnection = getDBConnection();
		try {
			statement = dbConnection.createStatement();
			statement.executeUpdate(insertTableSQL);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void insertProjectManagers(int Project_managers_id, String name,String department, int salary){
		Connection dbConnection = null;
		Statement statement = null;
		String insertTableSQL = "INSERT INTO CUSTOMERS" + "(Project_managers_id,name,department,salary)" + "VALUES" + "("+Project_managers_id+name+department+salary+")";
		dbConnection = getDBConnection();
		try {
			statement = dbConnection.createStatement();
			statement.executeUpdate(insertTableSQL);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
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
	
}
