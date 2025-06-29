package org.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBConnections {
	 static final String DB_URL = "jdbc:mysql://localhost:3306/automation_test1"; // replace with your DB name
	    static final String USER = "rathiva";       // replace with your DB user
	    static final String PASS = "Pass3word!"; 
	     static String sql = "SELECT * FROM automation_test1.TestRunner WHERE runner_id = '1'";
	    public static Connection connectMySQL(String DB_URL, String USER, String PASS) {
	    	Connection conn = null;
	    	 // 1. Load JDBC driver (optional for newer Java versions)
            try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				 // 2. Open connection
	            conn = DriverManager.getConnection(DB_URL, USER, PASS);
	            
	            System.out.println("Connected to the database!");
	           
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return conn;
         
           
	    }
	    
	    public static ResultSet executeQuery(String query) {
	    	  Statement stmt = null;
	    	  ResultSet rs = null;
	    	try {
				stmt = DBConnections.connectMySQL(DB_URL, USER, PASS).createStatement();
				 // 4. Execute SQL query
	            String sql = "SELECT * FROM automation_test1.TestRunner WHERE runner_id = '1'";
	            rs = stmt.executeQuery(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return rs;    
            }
	    public static void main(String[] args) {
	    	
	        ResultSet rs = null;
	        try {
	        		        	
	        	rs = DBConnections.executeQuery(sql);
	            boolean found = false;
	            while (rs.next()) {
	                String username = rs.getString("test_result");
	                String email = rs.getString("test_case_name");

	                System.out.println("User: " + username + ", Email: " + email);

	                // Sample test validation
	                if (email.contains("@")) {
	                    System.out.println("✅ Email format is valid.");
	                } else {
	                    System.out.println("❌ Invalid email format!");
	                }

	                found = true;
	            }

	            if (!found) {
	                System.out.println("No active users found.");
	            }

	            // 6. Close result set
	            rs.close();

	        } catch (SQLException se) {
	            se.printStackTrace();
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            System.out.println("Database connection closed.");
	        }
	    }
}
