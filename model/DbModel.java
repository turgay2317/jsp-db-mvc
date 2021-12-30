package org.jdmp.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbModel {
	
	private static Connection con = null;
	private final String Host = "jdbc:mysql://localhost:3306/testdb";
	private final String Username = "root";
	private final String Password = "200034755";
	private static Statement st = null;
	private static ResultSet rs = null;
	
	public DbModel() {
		if(con == null) {
			try {
				con = DriverManager.getConnection(Host, Username, Password);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public ResultSet getResultFromQuery(String query) {
		try {
			st = con.createStatement();
			rs = st.executeQuery(query);
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean executeQuery(String query) {
		try {
			st = con.createStatement();
			return st.execute(query);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
