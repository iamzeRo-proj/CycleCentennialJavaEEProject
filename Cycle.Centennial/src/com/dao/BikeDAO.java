package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.util.DataConnect;

public class BikeDAO {
	public int updateBikeUnavailable(int id) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DataConnect.getConnection();
			String query = "update bikes set status=? where id=?";
			ps = con.prepareStatement(query);
			ps.setString(1, "unavailable");
			ps.setInt(2, id);
			int success = ps.executeUpdate();
		} catch (Exception e) {

		}
		return -1;
	}
}
