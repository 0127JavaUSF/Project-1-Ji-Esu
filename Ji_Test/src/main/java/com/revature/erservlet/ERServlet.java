package com.revature.erservlet;

import com.google.common.hash.Hashing;
import com.revature.processImpl.LoginProcessImpl;
import com.revature.util.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class testServ
 */
public class ERServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// private DAO db;
	private LoginProcessImpl processTransaction;

	/**
	 * @throws ServletException
	 * @see HttpServlet#HttpServlet()
	 */

	public void init() throws ServletException {
		try {
			Class.forName("org.postgresql.Driver");
		}

		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// db = new DAO();
		processTransaction = new LoginProcessImpl();
		super.init();
	}

	public ERServlet() throws ServletException, ClassNotFoundException {
		this.init();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		//getting the cookie
        Cookie[] cookies = request.getCookies();
        int reqType;
		String returnVal = " ";
		
        //checking if client logged in the last 10 minutes
        if (cookies == null) {
            System.out.println("No cookies found");
            reqType = 1;
        }
        
        else {
        	// legacy code just in case Integer.parseInt(request.getParameter("reqType"));
        	reqType = 2;
        }
        
        
		switch(reqType) {
			case 1:
				String username = request.getParameter("user");
				String password = request.getParameter("pass");
				
				
				returnVal = processTransaction.process(username, password);
				if(returnVal.equals("YES")) {
					String cookID = "Login";
					String value = Hashing.sha1().hashString(username, StandardCharsets.UTF_8).toString();
					Cookie cookie = new Cookie(cookID,value);
					cookie.setMaxAge(10 * 60);
					System.out.println("asdfasdfasdfasdf");
					response.addCookie(cookie);
				}
				break;
			
			case 2:
				returnVal = "You Already Loggedin";
				
				break;

			default:
				break;
		
		}

		response.getWriter().append("Served at: ").append(returnVal);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
