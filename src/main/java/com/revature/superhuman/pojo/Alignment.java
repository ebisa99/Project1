package com.revature.superhuman.pojo;

public class Alignment {

	private int id;
	private String alignment;
	
	
	public Alignment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Alignment(int id, String alignment) {
		super();
		this.id = id;
		this.alignment = alignment;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAlignment() {
		return alignment;
	}
	public void setAlignment(String alignment) {
		this.alignment = alignment;
	}
	
	
}
