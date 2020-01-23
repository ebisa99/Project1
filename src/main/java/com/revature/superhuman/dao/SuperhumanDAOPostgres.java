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
	public void add() {
		

	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Superhuman> getAll() {
		Connection conn = ConnectionFactory.getConnection();
		String sql = "Select s.super_name, s.alias, s.hometown, s.main_power, a.align_type from superhuman s inner join alignment a on s.align_id = a.id;";
		List<Superhuman> supers = new ArrayList<Superhuman>();
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				String supName = rs.getString(1);
				String supAlias = rs.getString(2);
				String supHome = rs.getString(3);
				String supMainPow = rs.getString(4);
				String supAlign = rs.getString(5);
				
				supers.add(new Superhuman(supName, supAlias, supHome, supMainPow, supAlign));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return supers;
	}

}
