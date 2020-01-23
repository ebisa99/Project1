package com.revature.superhuman.dao;

import java.util.List;

import com.revature.superhuman.pojo.Alignment;

public interface AlignmentDAO {

	public List<Alignment> getAll();
	
	public String getById(int id);
	public int getByType(String type);
}
