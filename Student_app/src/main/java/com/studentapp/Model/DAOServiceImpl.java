package com.studentapp.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//Inheritence
public class DAOServiceImpl implements DAOService {

	private Connection con;
	private Statement stmnt;

//polymorphism
	@Override
	public void connectionDB() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/second", "root", "test");
			stmnt = con.createStatement();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean verifycredentials(String email, String password) {
		try {
			ResultSet result = stmnt
					.executeQuery("select * from login where email='" + email + "' and password='" + password + "' ");
			return result.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public void SaveReg(String name, String city, String email, String mobile) {
		try {
			stmnt.executeUpdate("insert into registration values('" + name + "' , '" + city + "' , '" + email + "' , '"
					+ mobile + "')");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public ResultSet listRegistration() {
		try {
			ResultSet result = stmnt.executeQuery("select * from registration");
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public void deleteByEmail(String email) {
		try {
			stmnt.executeUpdate("Delete from registration where email = '"+email+"' ");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void updateReg(String email, String mobile) {

		try {
			stmnt.executeUpdate("update registration set  mobile='"+mobile+"' where email='"+email+"' ");
			
		} catch (Exception e) {
			e.printStackTrace();
		}	


	}
	
}
