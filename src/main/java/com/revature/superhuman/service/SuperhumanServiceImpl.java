package com.revature.superhuman.service;

import java.util.List;

import com.revature.superhuman.dao.AlignmentDAO;
import com.revature.superhuman.dao.AlignmentDAOPostgres;
import com.revature.superhuman.dao.SuperhumanDAO;
import com.revature.superhuman.dao.SuperhumanDAOPostgres;
import com.revature.superhuman.pojo.Alignment;
import com.revature.superhuman.pojo.Superhuman;

public class SuperhumanServiceImpl implements SuperhumanService {

	SuperhumanDAO sdp = new SuperhumanDAOPostgres();
	AlignmentDAO adp = new AlignmentDAOPostgres();
	
	@Override
	public List<Superhuman> getAllSuperhumans() {		
		return sdp.getAll();
	}

	@Override
	public boolean createASuperhuman(Superhuman sh) {
		return sdp.add(sh);
	}

	@Override
	public boolean deleteASuperhuman(Superhuman sh) {
		return sdp.delete(sh);
	}

	@Override
	public String getAllJoinAlignmentString() {
		List<Superhuman> sups = sdp.getAll();
		List<Alignment> alig = adp.getAll();
		
		String joinedList = "";
		
		for(Superhuman sh: sups) {
			joinedList += (sh.toString() + ", Alignement - " + alig.get(sh.getAlignment() - 1).getAlignment() + "\n");
		}
		
		return joinedList;		
	}

}
