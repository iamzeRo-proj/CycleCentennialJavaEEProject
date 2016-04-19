package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.util.DataConnect;

public class RegisterDAO {

	public static void Register(String userid, String lName, String fName, Date dob, String gender, String number,
			String email, String address, String apartment, String city, String province, String zipcode,
			String password) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DataConnect.getConnection();
			String query = "INSERT INTO memberinfo (memberId,LastName,FirstName,DOB,Gender,ContactNumber,Email"
					+ "Address,Apartment/Unit,City,Province,PostalCode,Password)" + "Values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			ps = con.prepareStatement(query);
			ps.setString(1, userid);
			ps.setString(2, lName);
			ps.setString(3, fName);
			ps.setDate(4, dob);
			ps.setString(5, gender);
			ps.setString(6, number);
			ps.setString(7, email);
			ps.setString(8, address);
			ps.setString(9, apartment);
			ps.setString(10, city);
			ps.setString(11, province);
			ps.setString(12, zipcode);
			ps.setString(13, password);

			int success = ps.executeUpdate();

		
			}
		catch(SQLException se){
	         //Handle errors for JDBC
	         se.printStackTrace();
	      }catch(Exception e){
	         //Handle errors for Class.forName
	         e.printStackTrace();
	      }finally{
	         //finally block used to close resources
	         try{
	            if(con!=null)
	            con.close();
	         }catch(SQLException se){
	            se.printStackTrace();
	         }//end finally try
	      } //end try
	}
}
