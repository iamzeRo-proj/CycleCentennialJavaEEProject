package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.util.DataConnect;
public class PaymentDAO {
	public static void InsertToPayinfo(int ccNumber, int userId, String ccType, String ccExpiryDate, String cardHolderName,
			double amount, int paymentId) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DataConnect.getConnection();
			String query = "INSERT INTO payinfo (ccNumber,memberId,ccType,ccExpiryDate,cardHolderName,amount,paymentId)" 
			+ "Values(?,?,?,?,?,?,?)";
			ps = con.prepareStatement(query);
			
			ps.setInt(1, ccNumber);
			ps.setInt(2, userId);
			ps.setString(3, ccType);
			ps.setString(4, ccExpiryDate);
			ps.setString(5, cardHolderName);
			ps.setDouble(6, amount);
			ps.setInt(7, paymentId);
			int rs = ps.executeUpdate(query);

			
					
		
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
