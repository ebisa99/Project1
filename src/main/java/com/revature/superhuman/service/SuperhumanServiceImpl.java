package com.revature.superhuman.service;

import java.util.List;

import com.revature.superhuman.dao.SuperhumanDAOPostgres;
import com.revature.superhuman.pojo.Superhuman;

public class SuperhumanServiceImpl implements SuperhumanService {

	SuperhumanDAOPostgres sdp = new SuperhumanDAOPostgres();
	
	@Override
	public List<Superhuman> getAllSuperhumans() {		
		return sdp.getAll();
	}

	@Override
	public boolean createASuperhuman(String name, String alias, String home, String power, int alignId) {
		// TODO Auto-generated method stub
		return false;
	}

}
