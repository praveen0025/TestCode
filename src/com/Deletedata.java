package com;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Query;

public class Deletedata extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				// TODO Auto-generated method stub
				//super.doPost(req, resp);
				int delt =Integer.parseInt(req.getParameter("delitem"));
				System.out.println("hello");
				try {
					ObjectifyService.register(Employe.class);
				} catch (Exception e2) {
					// TODO: handle exception
				}				
				Objectify ofy = ObjectifyService.begin();
				System.out.println("hello1"+delt);		
				Employe em= ofy.query(Employe.class).filter("Emp_Id =", delt).get();
				System.out.println(em);
				ofy.delete(em);
				
				//update
				//em.setEmp_Id(54321);
				//ofy.put(em);
				//ofy.delete(em);

				System.out.println("data deleted suu"+em);
				//Query<Employe> delquery=(Query<Employe>) ofy.query(Employe.class).filter("e.Emp_Id","123").get();
				//ofy.delete(delquery);
		
				resp.getWriter().println("deletion ok");
				//get(Employe.class,del);
				//ofy.delete().keys(em);
		}
	}