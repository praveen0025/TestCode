package com;

import javax.persistence.Id;

public class Employe {
	@Id Long id;
	private String Emp_Name;
	private int Emp_Id;
	Employe(){}
	public String getEmp_Name() {
		return Emp_Name;
	}
	public void setEmp_Name(String emp_Name) {
		Emp_Name = emp_Name;
	}
	public int getEmp_Id(String delt) {
		return Emp_Id;
	}
	public void setEmp_Id(int emp_Id) {
		Emp_Id = emp_Id;
	}
	

}
