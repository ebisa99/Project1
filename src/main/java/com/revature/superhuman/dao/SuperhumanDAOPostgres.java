package com.revature.superhuman.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.superhuman.pojo.Superhuman;
import com.revature.superhuman.util.ConnectionFactory;
import com.revature.superhuman.util.LoggerUtil;

public class SuperhumanDAOPostgres implements SuperhumanDAO {
	
	Connection conn = ConnectionFactory.getConnection();
	
	@Override
	//Add superhumn sh to the superhuman DB
	public boolean add(Superhuman sh) {
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
			LoggerUtil.error("Failed to add Superhuman");
			return false;
		}
		
		LoggerUtil.info("Added Superhuman: " + sh.getSuperName());
		return true;
	}

	@Override
	//Delete superhuman sh from the superhuman DB
	public boolean delete(Superhuman sh) {
		String sql = "delete from superhuman where super_name = ?";

		try {
			//Check if the superhuman exists in the system
			PreparedStatement checkStmt = conn.prepareStatement("select * from superhuman where super_name = ?");
			checkStmt.setString(1, sh.getSuperName());
			
			if (!checkStmt.executeQuery().next()) {
				LoggerUtil.error("Failed to delete Superhuman: " + sh.getSuperName());
				return false;
			}
			
			//Remove Superhuman from the system
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, sh.getSuperName());
			
			stmt.execute();
			
		} catch (SQLException e) {
			LoggerUtil.error("Failed to delete Superhuman: " + sh.getSuperName());
			return false;
		}
		
		LoggerUtil.info("Deleted Superhuman: " + sh.getSuperName());
		return true;
	}
	
	@Override
	//Update superhuman in DB based on superName and then apply all updates from sh
	public boolean update(String superName, Superhuman sh) {
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
				LoggerUtil.error("Failed to update Superhuman: " + superName);
				return false;
			}
			
		} catch (SQLException e) {
			LoggerUtil.error("Failed to update Superhuman: " + superName);
			return false;
		}
		
		LoggerUtil.info("Updated Superhuman: " + superName);
		return true;
	}

	@Override
	//Get every superhuman from the database and apply them into the superhuman pojo
	public List<Superhuman> getAll() {
		String sql = "select * from superhuman";
		List<Superhuman> supers = new ArrayList<Superhuman>();
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			//Run through result set from query and add to the list
			while(rs.next()) {
				String supName = rs.getString(1);
				String supAlias = rs.getString(2);
				String supHome = rs.getString(3);
				String supMainPow = rs.getString(4);
				Integer supAlign = rs.getInt(5);
				
				supers.add(new Superhuman(supName, supAlias, supHome, supMainPow, supAlign));
			}
			
		} catch (SQLException e) {
			LoggerUtil.error("Failed to get all Superhumans");
			return null;
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				LoggerUtil.error("Failed to close connection");
			}
		}
		
		LoggerUtil.info("Got all Superhumans");
		
		return supers;
	}

	@Override
	//Return the result set from the join of superhuman and alignment tables
	public ResultSet getJoinedAlignment() {
		String sql = "select s.super_name, s.alias, s.hometown, s.main_power, a.align_type from superhuman s inner join alignment a on s.align_id = a.id";
		ResultSet rs;
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
		} catch (SQLException e) {
			LoggerUtil.error("Failed to get joined table SHxA");
			return null;
		}
		
		LoggerUtil.info("Got joined table SHxA");

		return rs;
	}

	//Used for JUnit testing to apply a mock connection
	public void setConn(Connection conn) {
		this.conn = conn;
	}

}
