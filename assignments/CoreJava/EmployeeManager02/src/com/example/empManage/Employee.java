package com.example.empManage;

public class Employee<T extends Number> {
	private int eid;
	   private String name;
	  private T salary;
	   
	   public Employee(int eid,String name,T salary) {
	       this.eid=eid;
	       this.name=name;
	       this.salary=salary;
	   }

	   public int getEid() {
	       return eid;
	   }

	   public void setEid(int eid) {
	       this.eid = eid;
	   }

	   public String getName() {
	       return name;
	   }

	   public void setName(String name) {
	       this.name = name;
	   }

	   public T getSalary() {
	       return salary;
	   }

	   public void setSalary(T salary) {
	       this.salary = salary;
	   }
	   @Override
	   public String toString() {
	   // TODO Auto-generated method stub
	   return this.getEid()+" "+this.getName()+" "+this.getSalary();
	   }
}
