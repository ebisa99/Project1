package com.revature.superhuman.dao;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.revature.superhuman.pojo.Superhuman;
import com.revature.superhuman.service.SuperhumanServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class SuperhumanServiceImplTest {

	private SuperhumanServiceImpl superService = new SuperhumanServiceImpl();
	private Superhuman sh;

	@Mock
	SuperhumanDAO shDao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		sh = new Superhuman();
		superService.setSdp(shDao);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void createSuperhumanTest() {
		sh.setSuperName("Useless");
		sh.setAlias("No One");
		sh.setHometown("No Where");
		sh.setMainPower("Nothing");
		sh.setAlignment(1);
		
		superService.createASuperhuman(sh);
		
		verify(shDao).add(sh);
	}
	
	@Test
	public void deleteSuperhumanTest() {
		sh.setSuperName("Useless");
		sh.setAlias("No One");
		sh.setHometown("No Where");
		sh.setMainPower("Nothing");
		sh.setAlignment(1);
		
		superService.deleteASuperhuman(sh);
		
		verify(shDao).delete(sh);
	}
	
	@Test
	public void updateSuperhumanTest() {
		sh.setSuperName("Useless");
		sh.setAlias("No One");
		sh.setHometown("No Where");
		sh.setMainPower("Nothing");
		sh.setAlignment(1);
		
		superService.updateASuperhuman(sh.getSuperName(), sh);
		
		verify(shDao).update(sh.getSuperName(), sh);
	}

}
