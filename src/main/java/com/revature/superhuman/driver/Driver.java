package com.revature.superhuman.driver;

import com.revature.superhuman.pojo.Superhuman;
import com.revature.superhuman.service.SuperhumanServiceImpl;

public class Driver {

	private static SuperhumanServiceImpl ss = new SuperhumanServiceImpl();
	
	public static void main (String[] args) {
		//ss.createASuperhuman(new Superhuman("Senior Test", "Testie", "Junit", "Discovering Problems", 1));
		
		System.out.println(ss.getAllJoinAlignmentString());
		
//		for (Superhuman s: ss.getAllSuperhumans()) {
//			System.out.println(s.toString());		
//		}
	}
}
