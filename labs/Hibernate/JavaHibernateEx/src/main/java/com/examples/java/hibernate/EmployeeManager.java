package com.examples.java.hibernate;


import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.examples.java.hibernate.model.Employee;

public class EmployeeManager {

	public static void main(String args[]) {
		//Step 1: create configeration
		Configuration config=new Configuration();
		config.configure().addAnnotatedClass(Employee.class);        //loads hibernate default config path
		
		//step 2: create sessionFactory
		
		SessionFactory sessionFactory=config.buildSessionFactory();
		System.out.println(sessionFactory);
		
		//Step 3: create session
		
		Session session=sessionFactory.openSession();
		Transaction txn=session.beginTransaction();
		//insert into table by supplying the persistent object
		Employee emp=new Employee();
		emp.setAge(34);
		emp.setDept("watson");
		emp.setEid("e007");
		emp.setName("Jagdish");
		emp.setSalary(25000);
		
		session.save(emp);
		//step 4: Transaction management
		//txn.commit();
		//step 5: perform database operation
		
		
        //Listing the employees
		
		//using HQL
        //List<Employee> employees = session.createQuery("FROM Employee").list();
		
		//using Native SQL Query
//        List<Employee> employees=session.createNativeQuery("select * from employee",Employee.class).list();
//        for(Iterator<Employee> iterator=employees.iterator(); iterator.hasNext();) {
//        	Employee employee = (Employee)iterator.next();
//        	System.out.println(employee.getName()+"\t"+employee.getAge()+"\t"+employee.getDept());
//        }
        
        //Using criteria query
        @SuppressWarnings("deprecation")
		Criteria criteria = session.createCriteria(Employee.class);
		@SuppressWarnings("unchecked")
		List<Employee> employees = criteria.list();
		for(Iterator<Employee> iterator=employees.iterator(); iterator.hasNext();) {
        	Employee employee = (Employee)iterator.next();
        	System.out.println(employee.getName()+"\t"+employee.getAge()+"\t"+employee.getDept());
        }

        
        //update
        Employee empForUpdate=session.get(Employee.class,5);
        empForUpdate.setDept("Admin");
        session.update(empForUpdate);
       
        //delete
        Employee empForDelete=session.get(Employee.class, 12);
        session.delete(empForDelete);
        
        txn.commit();
	}
}
