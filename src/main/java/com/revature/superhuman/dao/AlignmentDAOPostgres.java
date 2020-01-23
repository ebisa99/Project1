package com.revature.superhuman.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.superhuman.pojo.Alignment;
import com.revature.superhuman.util.ConnectionFactory;

public class AlignmentDAOPostgres implements AlignmentDAO {

	@Override
	public List<Alignment> getAll() {
		Connection conn = ConnectionFactory.getConnection();
		String sql = "select * from alignment";
		List<Alignment> aligns = new ArrayList<Alignment>();
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String type = rs.getString(2);
				
				aligns.add(new Alignment(id, type));
			}			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return aligns;
	}

	@Override
	public String getById(int id) {
		Connection conn = ConnectionFactory.getConnection();
		String sql = "Select align_type from alignment where id = ?";
		String align = "";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				align = rs.getString(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return align;
	}

	@Override
	public int getByType(String type) {
		Connection conn = ConnectionFactory.getConnection();
		String sql = "Select id from alignment where align_type = ?";
		int id = 0;
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, type);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				id = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return id;
	}

}
