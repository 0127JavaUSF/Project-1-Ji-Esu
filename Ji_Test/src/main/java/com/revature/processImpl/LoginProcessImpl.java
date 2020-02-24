package com.revature.processImpl;

import com.revature.util.DAO;
import com.revature.util.Process;

import java.nio.charset.StandardCharsets;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.google.common.hash.Hashing;

public class LoginProcessImpl implements Process{
	
	@Override
	public String process(String req) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String process(String user, String pass) {
		String confirm = "no";

		String userHash = Hashing.sha1().hashString(user, StandardCharsets.UTF_8).toString();
		String passHash = Hashing.sha1().hashString(pass, StandardCharsets.UTF_8).toString();
		
		System.out.println(userHash + " " + passHash);
		
		String query = "SELECT * FROM ers_users WHERE ers_username = ? AND ers_password = ?";
		
		db.setPreparedStatement(query);
		ResultSet result = db.queryStatements(userHash,passHash);
		
		try {
			if(result.next()) {
				confirm = "yes";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return confirm;
	}
	

}
