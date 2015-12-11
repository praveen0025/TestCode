package com;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.*;

import com.google.appengine.repackaged.com.google.gson.Gson;
import com.google.apphosting.utils.config.ClientDeployYamlMaker.Request;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Query;

@SuppressWarnings("serial")
public class Db1Servlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		resp.setContentType("text/json");	
		
								
							//	Employe em= ofy.get(Employe.class,e.id);
							//	em.getEmp_Id();
							//resp.getWriter().println("Ended "+em.getEmp_Name());
		Employe e =new Employe();
		try{
			ObjectifyService.register(Employe.class);
			}
		catch(Exception e1){}
		
		Objectify ofy = ObjectifyService.begin();
				Query<Employe> query=ofy.query(Employe.class);
				Gson gson=new Gson();
				List <Employe> empList=new ArrayList<Employe>();
						for(Employe emp: query)
								{
								empList.add(emp);
								}				
				String json=gson.toJson(empList);				
				resp.getWriter().println(json);
				//System.out.println(""+json);
	}												      			
}
