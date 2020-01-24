package com.revature.superhuman.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.superhuman.pojo.Superhuman;
import com.revature.superhuman.util.ConnectionFactory;

public class SuperhumanDAOPostgres implements SuperhumanDAO {

	@Override
	public boolean add(Superhuman sh) {
		Connection conn = ConnectionFactory.getConnection();
		String sql = "insert into superhuman values(?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, sh.getSuperName());
			stmt.setString(2, sh.getAlias());
			stmt.setString(3, sh.getHometown());
			stmt.setString(4, sh.getMainPower());
			stmt.setInt(5, sh.getAlignment());
			
			stmt.execute();
		} catch (SQLException e) {
			return false;
		}
		
		return true;
	}

	@Override
	public boolean delete(Superhuman sh) {
		Connection conn = ConnectionFactory.getConnection();
		String sql = "delete from superhuman where super_name = ?";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, sh.getSuperName());
			
			if (!stmt.execute())
				return false;
			
		} catch (SQLException e) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public boolean update(String superName, Superhuman sh) {
		Connection conn = ConnectionFactory.getConnection();
		String sql = "update superhuman set "
					+ "super_name = ?, alias = ?, hometown = ?, main_power = ?, align_id = ? "
					+ "where super_name = ?";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, sh.getSuperName());
			stmt.setString(2, sh.getAlias());
			stmt.setString(3, sh.getHometown());
			stmt.setString(4, sh.getMainPower());
			stmt.setInt(5, sh.getAlignment());
			stmt.setString(6, superName);
			
			if (!stmt.execute()) {
				return false;
			}
			
		} catch (SQLException e) {
			return false;
		}
		
		return true;
	}

	@Override
	public List<Superhuman> getAll() {
		Connection conn = ConnectionFactory.getConnection();
		String sql = "Select * from superhuman";
		List<Superhuman> supers = new ArrayList<Superhuman>();
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				String supName = rs.getString(1);
				String supAlias = rs.getString(2);
				String supHome = rs.getString(3);
				String supMainPow = rs.getString(4);
				Integer supAlign = rs.getInt(5);
				
				supers.add(new Superhuman(supName, supAlias, supHome, supMainPow, supAlign));
			}
			
		} catch (SQLException e) {
			return null;
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				//
			}
		}
		
		return supers;
	}

	@Override
	public ResultSet getJoinedAlignment() {
		Connection conn = ConnectionFactory.getConnection();
		String sql = "select s.super_name, s.alias, s.hometown, s.main_power, a.align_type from superhuman s inner join alignment a on s.align_id = a.id;";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();
			return rs;
			
		} catch (SQLException e) {
			return null;
		}
		
	}

}
