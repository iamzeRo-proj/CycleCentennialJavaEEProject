package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.beans.BikeInfoBean;
import com.util.DataConnect;

public class BikeInfoDAO {

	public List<BikeInfoBean> getBikeInfo(String status,String location){
		Connection con = null;
		PreparedStatement ps = null;
		List<BikeInfoBean> bikesList = new LinkedList<>();

		try {
			con = DataConnect.getConnection();
			ps = con.prepareStatement(
					"Select id, status, location from bikes where status=? and location=?");
			ps.setString(1, status);
			ps.setString(2, location);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				BikeInfoBean bike = new BikeInfoBean();
				bike.setId(rs.getInt(1));
				bike.setStatus(rs.getString(2));
				bike.setLocation(rs.getString(3));
				bikesList.add(bike);
			}
		} catch (SQLException ex) {
			System.out.println("" + ex.getMessage());
			return null;
		} finally {
			DataConnect.close(con);
		}
		return bikesList;
	}
	public List<BikeInfoBean> getBikeInfo(String location){
		Connection con = null;
		PreparedStatement ps = null;
		List<BikeInfoBean> bikesList = new LinkedList<>();

		try {
			con = DataConnect.getConnection();
			ps = con.prepareStatement(
					"Select id, status, location from bikes where location=?");
			ps.setString(1, location);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				BikeInfoBean bike = new BikeInfoBean();
				bike.setId(rs.getInt(1));
				bike.setStatus(rs.getString(2));
				bike.setLocation(rs.getString(3));
				bikesList.add(bike);
			}
		} catch (SQLException ex) {
			System.out.println("" + ex.getMessage());
			return null;
		} finally {
			DataConnect.close(con);
		}
		return bikesList;
	}
	public List<BikeInfoBean> getBikeInfo(){
		Connection con = null;
		PreparedStatement ps = null;
		List<BikeInfoBean> bikesList = new LinkedList<>();

		try {
			con = DataConnect.getConnection();
			ps = con.prepareStatement(
					"Select id, status, location from bikes");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				BikeInfoBean bike = new BikeInfoBean();
				bike.setId(rs.getInt(1));
				bike.setStatus(rs.getString(2));
				bike.setLocation(rs.getString(3));
				bikesList.add(bike);
			}
		} catch (SQLException ex) {
			System.out.println("" + ex.getMessage());
			return null;
		} finally {
			DataConnect.close(con);
		}
		return bikesList;
	}
}
