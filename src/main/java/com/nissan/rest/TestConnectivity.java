package com.nissan.rest;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnectivity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jdbcUrl = "jdbc:sqlserver://localhost:1433;databaseName=DemoNissan;integratedSecurity=true";
		try {
			System.out.println("Connecting to database: " + jdbcUrl);

			Connection myConn =	DriverManager.getConnection(jdbcUrl);

			System.out.println("Connection successful!!!");
			myConn.close();
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}

}
