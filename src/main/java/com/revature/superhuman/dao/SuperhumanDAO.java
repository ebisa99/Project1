package com.revature.superhuman.dao;

import java.util.List;

import com.revature.superhuman.pojo.Superhuman;

public interface SuperhumanDAO {

	public void add();
	public void delete();
	
	public List<Superhuman> getAll();
}
