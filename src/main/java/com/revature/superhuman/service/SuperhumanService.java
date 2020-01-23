package com.revature.superhuman.service;
import java.util.List;

import com.revature.superhuman.pojo.Superhuman;

public interface SuperhumanService {

	public List<Superhuman> getAllSuperhumans();
	public boolean createASuperhuman(String name, String alias, String home, String power, int alignId);
}
