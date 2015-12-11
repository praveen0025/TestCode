package com;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

public class Insertdata extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/plain");
		
		String ename =req.getParameter("name");
		int eid=Integer.parseInt(req.getParameter("id"));
		
		System.out.println(ename+" servlet started "+eid);	
		Employe e = new Employe();
					e.setEmp_Name(ename);
					e.setEmp_Id(eid);
			try{
						ObjectifyService.register(Employe.class);							
				}
			catch(Exception e1){}
				
			Objectify ofy = ObjectifyService.begin();System.out.println("hello");
			
			ofy.put(e);				
			
			resp.getWriter().println("servlet : Successfully Inserted ");		
	}


}
