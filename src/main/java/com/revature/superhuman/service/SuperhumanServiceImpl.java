package com.revature.superhuman.service;

import java.sql.ResultSet;
import java.util.List;

import com.revature.superhuman.dao.SuperhumanDAO;
import com.revature.superhuman.dao.SuperhumanDAOPostgres;
import com.revature.superhuman.pojo.Superhuman;
import com.revature.superhuman.util.DBTablePrinter;

public class SuperhumanServiceImpl implements SuperhumanService {

	SuperhumanDAO sdp = new SuperhumanDAOPostgres();
	
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
		ResultSet rs = sdp.getJoinedAlignment();
		
		//Get a string containing the entire result set as a string
		String tempString = DBTablePrinter.printResultSet(rs);
		
		//rename the returning result set column titles
		tempString = tempString.replace("super_name", "Super Name");
		tempString = tempString.replace("alias", " Name");
		tempString = tempString.replace("hometown", "Hometown");
		tempString = tempString.replace("main_power", "Main Power");
		tempString = tempString.replace("align_type", " Alignment");		
		
		return tempString;	
	}

	public void setSdp(SuperhumanDAO sdp) {
		this.sdp = sdp;
	}
	
	

}
