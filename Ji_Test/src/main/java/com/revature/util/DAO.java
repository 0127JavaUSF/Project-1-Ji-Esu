package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {


	private Connection db;
	private PreparedStatement prepState;
	private ResultSet result;
	
	public DAO(){
		//get the sql connected :D
		try{
			do {
			//jdbc:postgresql://host:port/database_name
			db = DriverManager.getConnection("jdbc:postgresql://database-1.cfgsjckjokdt.us-east-2.rds.amazonaws.com:5432/postgres","jkong20", "1234" );
			}while (db == null);
		}
		catch (SQLException ex) {
			System.out.println("Connection has Timed out, Please verify username or firewall on your database");
			System.out.println(ex);
		}
	}
	

	public void setPreparedStatement(String query) {
		
		try {
			prepState = db.prepareStatement(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	//get result set
	public ResultSet queryStatements(String... query) {
		try{
			int i = 1;
			for(String e:query) {
				prepState.setString(i,e);
				i++;
			}
			result = prepState.executeQuery();
		}
		
		catch(SQLException ex) {
			System.out.println(ex);
		}
		return result;
	}
	
}
