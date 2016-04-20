package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.beans.UserBean;
import com.util.DataConnect;

public class LoginDAO {
	public static UserBean validate(String userName, String password) {
		Connection con = null;
		PreparedStatement ps = null;
		UserBean user = new UserBean();
		try {
			con = DataConnect.getConnection();
			ps = con.prepareStatement(
					"Select id, firstName, lastName, contactNumber, email, address from memberinfo where id = ? and password = ?");
			ps.setString(1, userName);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();
			

			if (rs.next()) {
				user.setId(rs.getInt(1));
				user.setFirstName(rs.getString(2));
				user.setLastName(rs.getString(3));
				user.setPhone(rs.getString(4));
				user.setEmail(rs.getString(5));
				user.setAddress(rs.getString(6));
				
			}
		} catch (SQLException ex) {
			System.out.println("Login error -->" + ex.getMessage());
			
		} finally {
			DataConnect.close(con);
		}
		return user;
	}
}
