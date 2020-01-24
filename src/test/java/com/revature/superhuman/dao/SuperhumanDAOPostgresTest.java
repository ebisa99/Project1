package com.revature.superhuman.dao;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import com.revature.superhuman.pojo.Superhuman;
import com.revature.superhuman.util.ConnectionFactory;
import com.revature.superhuman.util.LoggerUtil;

@RunWith(MockitoJUnitRunner.class)
public class SuperhumanDAOPostgresTest {

	private SuperhumanDAOPostgres shDao = new SuperhumanDAOPostgres();
	private Superhuman sh;
	
	@Mock
	private Connection conn;
	
	@Spy
	private PreparedStatement addStmt = ConnectionFactory.getConnection().prepareStatement("insert into superhuman values(?, ?, ?, ?, ?)");
	
	@Spy
	private PreparedStatement deleteStmt = ConnectionFactory.getConnection().prepareStatement("delete from superhuman where super_name = ?");
	
	@Spy
	private PreparedStatement updateStmt = ConnectionFactory.getConnection().prepareStatement("update superhuman "
																								+ "set super_name = ?, alias = ?, hometown = ?, main_power = ?, align_id = ? "
																								+ "where super_name = ?");
	
	@Spy
	private PreparedStatement getAllStmt = ConnectionFactory.getConnection().prepareStatement("select * from superhuman");
	
	@Spy
	private PreparedStatement getJoinAlignStmt = ConnectionFactory.getConnection().prepareStatement("select s.super_name, s.alias, s.hometown, s.main_power, a.align_type from superhuman s inner join alignment a on s.align_id = a.id");
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		shDao.setConn(conn);		
		sh = new Superhuman();
	}

	@After
	public void tearDown() throws Exception {
		ConnectionFactory.getConnection().createStatement().execute("truncate table superhuman");
	}

	@Test
	public void addSuperhumanTest() throws SQLException {
		when(conn.prepareStatement("insert into superhuman values(?, ?, ?, ?, ?)")).thenReturn(addStmt);

		sh.setSuperName("Useless");
		sh.setAlias("No One");
		sh.setHometown("No Where");
		sh.setMainPower("Nothing");
		sh.setAlignment(1);
		
		try {			
			addStmt.setString(1, sh.getSuperName());
			addStmt.setString(2, sh.getAlias());
			addStmt.setString(3, sh.getHometown());
			addStmt.setString(4, sh.getMainPower());
			addStmt.setInt(5, sh.getAlignment());
			
		} catch (SQLException e) {
			LoggerUtil.error("Failed to create prepared statement in Add Test");
			return;
		}
		
		shDao.add(sh);
		verify(addStmt).execute();
	}

	@Test
	public void deleteSuperhumanTest() throws SQLException {
		when(conn.prepareStatement("delete from superhuman where super_name = ?")).thenReturn(deleteStmt);

		sh.setSuperName("Useless");
		
		try {			
			addStmt.setString(1, sh.getSuperName());
			
		} catch (SQLException e) {
			LoggerUtil.error("Failed to create prepared statement in Delete Test");
			return;
		}
		
		shDao.delete(sh);
		verify(deleteStmt).execute();
	}
	
	@Test
	public void updateSuperhumanTest () throws SQLException {
		when(conn.prepareStatement("update superhuman "
				+ "set super_name = ?, alias = ?, hometown = ?, main_power = ?, align_id = ? "
				+ "where super_name = ?")).thenReturn(updateStmt);

		sh.setSuperName("Useless");
		sh.setAlias("No One");
		sh.setHometown("No Where");
		sh.setMainPower("Nothing");
		sh.setAlignment(1);
		
		try {			
			addStmt.setString(1, sh.getSuperName());
			addStmt.setString(2, sh.getAlias());
			addStmt.setString(3, sh.getHometown());
			addStmt.setString(4, sh.getMainPower());
			addStmt.setInt(5, sh.getAlignment());
			addStmt.setString(6, sh.getSuperName());
			
		} catch (SQLException e) {
			LoggerUtil.error("Failed to create prepared statement in Add Test");
			return;
		}
		
		shDao.update(sh.getSuperName(), sh);
		verify(addStmt).execute();
	}
	
	@Test
	public void getAllSuperhumansTest() throws SQLException {
		when(conn.prepareStatement("select * from superhuman")).thenReturn(getAllStmt);
		
		shDao.getAll();		
		verify(getAllStmt).executeQuery();
	}
	
	@Test
	public void getJoinedTableAlign() throws SQLException {
		when(conn.prepareStatement("select s.super_name, s.alias, s.hometown, s.main_power, a.align_type from superhuman s inner join alignment a on s.align_id = a.id")).thenReturn(getJoinAlignStmt);
	
		shDao.getJoinedAlignment();
		verify(getJoinAlignStmt).executeQuery();
	}
	
	public SuperhumanDAOPostgresTest () throws SQLException {
		super();
	}
	
}
