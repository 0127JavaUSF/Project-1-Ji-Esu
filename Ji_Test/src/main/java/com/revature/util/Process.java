package com.revature.util;


public interface Process {
	public static DAO db = new DAO();
	
	public String process(String req);
	
}
