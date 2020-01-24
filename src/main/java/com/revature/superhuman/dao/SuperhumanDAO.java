package com.revature.superhuman.dao;

import java.util.List;

import com.revature.superhuman.pojo.Superhuman;

public interface SuperhumanDAO {

	public boolean add(Superhuman sh);
	public boolean delete(Superhuman sh);
	
	public List<Superhuman> getAll();
}
