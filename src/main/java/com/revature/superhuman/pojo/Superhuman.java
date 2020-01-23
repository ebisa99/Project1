package com.revature.superhuman.pojo;

public class Superhuman {
	
	private String superName;
	private String alias;
	private String hometown;
	private String mainPower;
	private String alignment;
	
	public Superhuman(String superName, String alias, String hometown, String mainPower, String alignment) {
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
	
	@Override
	public String toString() {
		return "Superhuman [superName=" + superName + ", alias=" + alias + ", hometown=" + hometown + ", mainPower="
				+ mainPower + ", alignment=" + alignment + "]";
	}
	
	
}
