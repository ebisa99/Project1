package com.revature.superhuman.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.revature.superhuman.dao.AlignmentDAO;
import com.revature.superhuman.dao.AlignmentDAOPostgres;
import com.revature.superhuman.dao.SuperhumanDAO;
import com.revature.superhuman.dao.SuperhumanDAOPostgres;
import com.revature.superhuman.pojo.Alignment;
import com.revature.superhuman.pojo.Superhuman;
import com.revature.superhuman.util.DBTablePrinter;

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
	public boolean updateASuperhuman(String superName, Superhuman sh) {
		return sdp.update(superName, sh);
	}

	@Override
	public String getAllJoinAlignmentString() {
//		List<Superhuman> sups = sdp.getAll();
//		List<Alignment> alig = adp.getAll();

		ResultSet rs = sdp.getJoinedAlignment();
		
		String tempString = DBTablePrinter.printResultSet(rs);
		
		tempString = tempString.replace("super_name", "Super Name");
		tempString = tempString.replace("alias", "Alias");
		tempString = tempString.replace("hometown", "Hometown");
		tempString = tempString.replace("main_power", "Main Power");
		tempString = tempString.replace("align_type", " Alignment");		
		
		return tempString;
		
//		for(Superhuman sh: sups) {
//			joinedList += (sh.toString() + ", Alignement: " + alig.get(alignIndex).getAlignment() + "\n");
//		}
//		
//		return joinedList;		
	}

}
