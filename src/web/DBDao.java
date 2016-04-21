package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class DBDao{
	private static final String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/companydb";
    
    private ResultSet rs;
    
	
    public ResultSet getSQL(String input){
	    	String sql = input;
	    	try{
	    	Class.forName(DRIVER_CLASS_NAME);
			Connection conn = DriverManager.getConnection(URL, "student", "student");
			Statement statement = conn.createStatement();
			rs = statement.executeQuery(sql);
			
			
		} catch (Exception e) {
			System.err.println(e);
		}
			return rs;
    
    }			
}

