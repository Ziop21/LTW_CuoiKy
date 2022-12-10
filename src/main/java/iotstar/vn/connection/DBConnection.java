package iotstar.vn.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	private final String serverName = "LAPTOP-1F69K9NB";
	private final String dbName = "LTW_Servlet_JSP";
	//private final String portNumber = "1433";
	private final String instance = "MSSQLSERVER2016";// MSSQLSERVER LEAVE THIS ONE EMPTY IF YOUR SQL IS A SINGLE INSTANCE
	private final String userID = "newsa";
	private final String password = "sa";
	public Connection getConnection() throws Exception {
		String url = "jdbc:sqlserver://" + serverName +  "\\" + instance + ";databaseName=" + dbName;
		if (instance == null || instance.trim().isEmpty())
		url = "jdbc:sqlserver://"+serverName +";databaseName="+dbName + ";encrypt=true;trustServerCertificate=true";
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		return DriverManager.getConnection(url, userID, password);
	}
	/*
	public Connection getConnectionW() throws Exception {
		String url = "jdbc:sqlserver://" + serverName + "\\" + instance  + ";integratedSecurity=true;databaseName=" +	dbName;
		if (instance == null || instance.trim().isEmpty())
		url = "jdbc:sqlserver://" + serverName + 
		";integratedSecurity=true;databaseName=" + dbName;
		//DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		return DriverManager.getConnection(url);
	} */
	public static void main(String[] args) {
		try {
			System.out.println(new DBConnection().getConnection());
			
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
}

