package com.revature.superhuman.service;
import java.util.List;

import com.revature.superhuman.pojo.Superhuman;

public interface SuperhumanService {

	public boolean createASuperhuman(Superhuman sh);
	public boolean deleteASuperhuman(Superhuman sh);
	
	public List<Superhuman> getAllSuperhumans();
	public String getAllJoinAlignmentString();
}
