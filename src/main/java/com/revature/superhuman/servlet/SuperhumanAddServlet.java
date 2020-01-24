package com.revature.superhuman.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.superhuman.pojo.Superhuman;
import com.revature.superhuman.service.SuperhumanService;
import com.revature.superhuman.service.SuperhumanServiceImpl;

public class SuperhumanAddServlet extends HttpServlet {

	SuperhumanService superService = new SuperhumanServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Superhuman sh = new Superhuman();
		
		sh.setSuperName(req.getParameter("supname"));
		sh.setAlias(req.getParameter("alias"));
		sh.setHometown(req.getParameter("home"));
		sh.setMainPower(req.getParameter("power"));
		sh.setAlignment(Integer.parseInt(req.getParameter("align")));
		
		PrintWriter pw = resp.getWriter();
		
		if (superService.createASuperhuman(sh))
			pw.write("Add to DB: Success");
		else
			pw.write("Add to DB: Fail");
		
	}
}
