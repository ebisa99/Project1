package com.revature.superhuman.pojo;

public class Superhuman {
	
	private String superName;
	private String alias;
	private String hometown;
	private String mainPower;
	private Integer alignment;
	
	public Superhuman(String superName, String alias, String hometown, String mainPower, Integer alignment) {
		super();
		this.superName = superName;
		this.alias = alias;
		this.hometown = hometown;
		this.mainPower = mainPower;
		this.alignment = alignment;
	}
	public Superhuman() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getSuperName() {
		return superName;
	}
	public void setSuperName(String superName) {
		this.superName = superName;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getHometown() {
		return hometown;
	}
	public void setHometown(String hometown) {
		this.hometown = hometown;
	}
	public String getMainPower() {
		return mainPower;
	}
	public void setMainPower(String mainPower) {
		this.mainPower = mainPower;
	}
	public Integer getAlignment() {
		return alignment;
	}
	public void setAlignment(Integer alignment) {
		this.alignment = alignment;
	}
	
	@Override
	public String toString() {
		return "Superhuman: Super Name - " + superName + ", Alias - " + alias + ", Hometown - " + hometown + ", Main Power - "
				+ mainPower;
	}
	
	
	
	
}
