package com;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Query;
public class Updatedata extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);		
		resp.getWriter().println("text/plain");		
		Employe emp= new Employe();		
		
		int prvid=Integer.parseInt(req.getParameter("fromid"));
		
		int newid=Integer.parseInt(req.getParameter("toid"));
		
		try{ 
			ObjectifyService.register(Employe.class);
			}
		catch(Exception e1){}		
		Objectify ofy=ObjectifyService.begin();	
		
					
		Employe e= ofy.query(Employe.class).filter("Emp_Id =",prvid).get();		
									
		e.setEmp_Id(newid);
		ofy.put(e);
		
				
	}		
}
