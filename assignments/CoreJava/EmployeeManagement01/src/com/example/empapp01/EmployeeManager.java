package com.example.empapp01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Period;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EmployeeManager {
	
	Connection conn=null;
	final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    final String DB_URL = "jdbc:mysql://localhost/jdbctraining";
    final String USER = "root";
    final String PASS = "";
    Statement stmt=null;
    
   // Connection conn = null;
	 
//	public interface ValidateEmployee {
//		public boolean check(Employee emp);
//	}
//
//	// Validate method definition
//	public boolean validate(ValidateEmployee validator,Employee emp)
//	{
//		//System.out.println(emp);
//		return validator.check(emp);
//	}	
	public static void handleError(String errorMessage, Consumer<String> consumer)
	{
		consumer.accept(errorMessage);
	}
	
	public static boolean validate(Employee emp, Predicate<Employee> validator)
	{
		return validator.test(emp); // executes lambda expression body
	}
	
	TreeMap <Integer,Employee> obj =new <Integer,Employee> TreeMap(); 
	Scanner sc=new Scanner(System.in);
	public void AddEmployee() {
		
		String name,loc,dept;
		int id,age;
		int Salary;
		Employee emp=new Employee();
		
		System.out.println("Enter The Employee Name:");
		name=sc.next();
		emp.setName(name);
		System.out.println("Enter The Employee Id:");
		id=sc.nextInt();
		emp.setId(id);
		System.out.println("Enter The Employee Location:");
		loc=sc.next();
		emp.setLocation(loc);
		System.out.println("Enter The Employee Department:");
		dept=sc.next();
		emp.setDepartment(dept);
		System.out.println("Enter The Employee Age:");
		age=sc.nextInt();
		emp.setAge(age);
		System.out.println("Enter The Employee Salary:");
		Salary=sc.nextInt();
		emp.setSalary(Salary);
		
		System.out.println("Enter The Employee dob:");
		String inputdob=sc.next();
		LocalDate dob=LocalDate.parse(inputdob);
		emp.setDob(dob);
		
//		ValidateEmployee validator=new ValidateEmployee()
//		 {			
//			@Override
//			public boolean check(Employee emp) {
//				return emp.getAge()>0;
//						//return false;
//			}
//		};
		
//		ValidateEmployee validator=e->e.getAge()>0;		
//		boolean valStatus=validate(validator,emp);
		
		boolean valStatus = validate(emp, (Employee e) -> {return e.getAge() > 0 && e.getSalary() > 0;});

		if(valStatus)
		{
			// Logic to save employee details
			obj.put(emp.getId(), emp);
			System.out.println("Employee saved");
			
		}
		else {
			handleError("Invalid Age or Salary", msg -> {System.out.println("Validation Error:" );System.out.println(msg);});
		}
		
}
	

	
	

	public boolean SearchEmpl(int id) {
		if(obj.containsKey(id)) {
			return true;
		}
		return false;
	}
	
	public void DeleteEmployee(int id) {
		if(SearchEmpl(id)) {
			System.out.println("Employee Deleted:"+obj.remove(id));
		}
		else {
			System.out.println("Data Not Found");
		}
	}
	
	public void display() {
		
		
		System.out.println("Id:\t\t Name:\t\t Location:\t\t Salary:\t\tAge:");
		for(Object O:obj.keySet()) {
			//System.out.println(obj.get(O).dob);
			System.out.format("%d\t\t %s\t\t %s\t\t %d\t\t%d",obj.get(O).getId(),obj.get(O).getName(),obj.get(O).getLocation(),obj.get(O).getSalary(),calculateAge(obj.get(O).getDob()));
			System.out.println();
		}
	}
	
	public void EditEmployee(int id) {
		
		if(SearchEmpl(id)) {
			int ch;
			while(true) {
				System.out.println("1.Edit Name:");
				System.out.println("2. Edit Location:");
				
				System.out.println("3. Edit Salary");
				System.out.println("4.Back To The Main Menu");
				System.out.println("Enter Your Choice 1,2,3,4:");
				ch=sc.nextInt();
				switch(ch) {
				case 1:
					String name;
					System.out.println("Enter The Updated Name:");
					name=sc.next();
					obj.get(id).setName(name);
					break;
				case 2:
					String loc;
					System.out.println("Enter The Updated Location:");
					loc=sc.next();
					obj.get(id).setLocation(loc);
					break;
					
				
				case 3:
					int sal;
					System.out.println("Enter The Updated Salary:");
					sal=sc.nextInt();
					obj.get(id).setSalary(sal);
					break;
									
				
				case 4:return;
				
				default:System.out.println("Enter valid Choice");
					
				}
			}
		}
		else {
			System.out.println("Employee Not Found");
		}
		
	}
	
		
	
		
public void statistics() {
	//int ch;
//	while(true) {
//		System.out.println("1.Show By Department");
//		System.out.println("2. Show By Location");
//		System.out.println("3.Search Employee Having Salary Less Than 25000");
//		System.out.println("4.Search Employee Having Salary Greater Than 25000");
//		System.out.println("5.Back To Main Menu");
//		System.out.println("6.No of employees older than 30 years");
//		System.out.println("Enter Your Choice 1,2,3,4,5:");
//		ch=sc.nextInt();
//		switch(ch) {
//		
//		case 1:System.out.println("Enter The Department:");
//			String dep=sc.next();
//			TreeMap <Integer,Employee> D=new <Integer,Employee>TreeMap();
//			for(Object o:obj.keySet()) {
//				if(obj.get(o).getDepartment().equals(dep)) {
//					D.put(obj.get(o).getId(),obj.get(o));
//				}
//			}
//			System.out.println("Id:\t\t Name:\t\t Location:\t\t Salary:");
//			for(Object O:D.keySet()) {
//				System.out.format("%d\t\t %s\t\t %s\t\t %d",obj.get(O).getId(),obj.get(O).getName(),obj.get(O).getLocation(),obj.get(O).getSalary());
//				System.out.println();
//			}
//			break;
//			
//		case 2: 
//			System.out.println("Enter The Location:");
//			String loc=sc.next();
//		TreeMap <Integer,Employee> L=new <Integer,Employee>TreeMap();
//		
//		
//		for(Object o:obj.keySet()) {
//			if(obj.get(o).getDepartment().equals(loc)) {
//				L.put(obj.get(o).getId(),obj.get(o));
//			}
//		}
//		
//		System.out.println("Id:\t\t Name:\t\t Location:\t\t Salary:");
//		for(Object O:L.keySet()) {
//			System.out.format("%d\t\t %s\t\t %s\t\t %d",obj.get(O).getId(),obj.get(O).getName(),obj.get(O).getLocation(),obj.get(O).getSalary());
//			System.out.println();
//		}
//		break;
//		
//		
//		case 3:TreeMap <Integer,Employee> LTS=new <Integer,Employee>TreeMap();
//		for(Object o:obj.keySet()) {
//			if(obj.get(o).getSalary()<25000) {
//				LTS.put(obj.get(o).getId(),obj.get(o));
//			}
//		}
//		for(Object O:LTS.keySet()) {
//			System.out.format("%d\t\t %s\t\t %s\t\t %d",obj.get(O).getId(),obj.get(O).getName(),obj.get(O).getLocation(),obj.get(O).getSalary());
//			System.out.println();
//		}
//			break;
//			
//		case 4:
//			TreeMap <Integer,Employee> GTS=new <Integer,Employee>TreeMap();
//			for(Object o:obj.keySet()) {
//				if(obj.get(o).getSalary()>25000) {
//					GTS.put(obj.get(o).getId(),obj.get(o));
//				}
//			}
//			for(Object O:GTS.keySet()) {
//				System.out.format("%d\t\t %s\t\t %s\t\t %d",obj.get(O).getId(),obj.get(O).getName(),obj.get(O).getLocation(),obj.get(O).getSalary());
//				System.out.println();
//			}
//				break;
//				
//		case 5:
//			return;
//		case 6:
//			
//			
//			
//	default:System.out.println("Wrong Choice");
//			}
//			
//		}
	 
	Collection<Employee> ageFiltered=obj.values();
	Long filteredAge=ageFiltered.stream().filter(e->e.getAge()>30).count();
	System.out.println("No of employes more than 30 years: "+filteredAge); 
	
	Collection<Employee> idFiltered=obj.values();
	List<Integer> empIds=idFiltered.stream()
			.filter(e->e.getAge()>30)
			.map(e->e.getId())
			.collect(Collectors.toList());
	System.out.println("Employee Ids of age greater than 30: "+empIds);
	
	double totalSal =idFiltered.stream()
			.map(Employee::getSalary)
			.reduce(0,(a,b)->a.intValue()+b.intValue()).doubleValue();   //Identity=>initial value    Accumulator=>'a' representPartial result and 'b' represent next value
	System.out.println("Sum of the Employee's salary: "+totalSal);
	
//	Averager averager=idFiltered.stream()
//			.map(Employee:: getSalary)                                   //Supplier=>Factory method to create new instance of container object
//			.collect(Averager::new,Averager::accept,Averager::combine);  //Accumulator=>combine o/p of similar class
																		//Combiner=>
//	System.out.println(averager.average());
	
	double avgSal=idFiltered.stream()
			.collect(Collectors.averagingInt(Employee::getSalary));
	System.out.println("Average salary of the Employees: "+avgSal);
	
	Map<String, List<Employee>> groupByDept=idFiltered.stream()
			.collect(Collectors.groupingBy(Employee:: getDepartment));
	System.out.println("group by Departments: "+groupByDept);
	
	Map<String, Long> groupByDeptCount=idFiltered.stream()
			.collect(Collectors.groupingBy(Employee:: getDepartment,Collectors.counting()));
	System.out.println("No of employee per Dept: "+groupByDeptCount);
	
	//Avg age by dept
	Map<String, Double> avgAgeByDept = idFiltered.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingInt(Employee::getAge)));
	System.out.println("Average age by dept: "+avgAgeByDept);
	
	
	//dept having more than 3 employee

	List<String> somethings=idFiltered.stream()
			.collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()))
			.entrySet()
			.stream()
			.filter(entry->entry.getValue()>3)
			.map(Map.Entry::getKey)
			.collect(Collectors.toList());
   
		
	//name starting with 's'
	//idFiltered.stream().filter((s) -> s.startsWith("S")).findFirst().get();
    List<String> MatchedName=idFiltered.stream().filter((s)->s.getName().toLowerCase().startsWith("S".toLowerCase())).map(Employee::getName).collect(Collectors.toList());
    System.out.println("name starting with s: "+MatchedName);
	
    //group by dept and sorted
    Map<String,Long> groupByDeptSorted=idFiltered.stream().sorted(Comparator.comparing(Employee::getDepartment))
    		.collect(Collectors.groupingBy(Employee::getDepartment,TreeMap:: new,Collectors.counting()));
    System.out.println("group by dept and sorted: "+groupByDeptSorted);
    
 }

//Age Calculate
public int calculateAge(LocalDate dob) {
	LocalDate curDate=LocalDate.now();
	return Period.between(dob, curDate).getYears();
}

public void employeeImport() {
    // TODO Auto-generated method stub
    try {
        FileOutputStream fileOut = new FileOutputStream("C:\\Users\\PRIYANSHUPRATIHAR\\Desktop\\employeeManagement.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        for(Object emp:obj.keySet()) {
            out.writeObject(obj.get(emp));
        }
        
        out.close();
        fileOut.close();
        System.out.println("Serialized data is saved in C:\\Users\\PRIYANSHUPRATIHAR\\Desktop\\employeeManagement.ser");
    } catch (IOException i) {
        i.printStackTrace();
    }
    
}

public void employeeExport() {
    // TODO Auto-generated method stub
    System.out.println("..... Deserialized Employee Records ....");
    System.out.println("\n");
    
    //while(empObj.keySet()!=null) {
        Employee e = null;
      try {
         FileInputStream fileIn = new FileInputStream("C:\\Users\\PRIYANSHUPRATIHAR\\Desktop\\employeeManagement.ser");
         ObjectInputStream in = new ObjectInputStream(fileIn);
         for(Object emp:obj.keySet()) {
             e = (Employee) in.readObject();
            
              System.out.println("Employee name: "+e.name);
              System.out.println(" Employee id: "+e.id);
              System.out.println(" Employee age: "+ e.age);
              System.out.println(" Location" + e.Location);
              System.out.println(" Department: " + e.department);
              System.out.println("Salary: "+e.Salary);
              System.out.println("Employee Date of birth:"+e.dob);
              System.out.println("\n");          
         }
         in.close();
         fileIn.close();
      } catch (IOException i) {
         i.printStackTrace();
         return;
      } catch (ClassNotFoundException c) {
         System.out.println("Employee class not found");
         c.printStackTrace();
         return;
      }

}

public synchronized void bulkImport() {
	int counter=0;
	try(Scanner in=new Scanner(new FileReader("C:\\Users\\PRIYANSHUPRATIHAR\\Desktop\\employeeManagement.txt"))) {
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public void insertIntoDatabase() throws ClassNotFoundException{

	String name,loc,dept;
	int id,age;
	int Salary;
	Employee emp=new Employee();
	
//	System.out.println("Enter The Employee Id:");
//	id=sc.nextInt();
//	emp.setId(id);
	System.out.println("Enter The Employee Name:");
	name=sc.next();
	emp.setName(name);
	System.out.println("Enter The Employee Location:");
	loc=sc.next();
	emp.setLocation(loc);
	System.out.println("Enter The Employee Department:");
	dept=sc.next();
	emp.setDepartment(dept);
	System.out.println("Enter The Employee Age:");
	age=sc.nextInt();
	emp.setAge(age);
	System.out.println("Enter The Employee Salary:");
	Salary=sc.nextInt();
	emp.setSalary(Salary);
	
	System.out.println("Enter The Employee dob:");
	String inputdob=sc.next();
	LocalDate dob=LocalDate.parse(inputdob);
	emp.setDob(dob);
    
    
    
        
     try {
         //Statement stmt = null;
         Class.forName("com.mysql.jdbc.Driver");
         conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
         Statement stmt = (Statement) conn.createStatement();
         if(conn!=null) {
         String insertSql="insert into employee1(name,location,depertment,age,salary,dob) values('"+name+"','"+loc+"','"+dept+"',"+age+","+Salary+",'"+dob+"')";
         int count=stmt.executeUpdate(insertSql);
         //if(insertStatus) {
             System.out.println("Employee successfully inserted");
        // }
         }
         else {
             System.out.println("connection null");
         }
         try {
                stmt.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
     }catch(SQLException se) {
         System.out.println(se);
        
     }
     finally {
        
         try {
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
     }
}

public void showFromDatabase() {
    // TODO Auto-generated method stub
    try {
        Class.forName("com.mysql.jdbc.Driver");
         conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
         Statement stmt = (Statement) conn.createStatement();
         if(conn!=null) {
             String sql="select * from employee1";
             ResultSet rs = stmt.executeQuery(sql);
             System.out.println("\t Emp ID \t Emp Name \t Emp location \t Emp Dept \t Emp age \t Emp salary\t Emp dob");
            
                 while(rs.next()) {
                        // System.out.format("\t    %s \t      %s \t      %d \t      %s \t        %s  \t        %d",rs.getString("id"),rs.getString("name"),rs.getInt("salary"),rs.getString("dob").toString(),rs.getString("dept"));
                        System.out.format("\t%d\t%s\t%s\t%s\t%d\t%d\t%s",rs.getInt("id"),rs.getString("name"),rs.getString("location"),rs.getString("depertment"),rs.getInt("age"),rs.getInt("salary"),rs.getString("dob"));
                	 System.out.println("\n");
                    
                }
         }
        
    }catch(Exception e) {
        System.out.println(e);
    }
}

public void deleteFromDatabase() throws ClassNotFoundException{

	
	int delId;
	
	Employee emp=new Employee();
	System.out.println("Enter The Employee Id:");
	delId=sc.nextInt();
	emp.setId(delId);
	
        
     try {
         //Statement stmt = null;
         Class.forName("com.mysql.jdbc.Driver");
         conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
         Statement stmt = (Statement) conn.createStatement();
         if(conn!=null) {
         //String insertSql="insert into employee1(name,location,depertment,age,salary,dob) values('"+name+"','"+loc+"','"+dept+"',"+age+","+Salary+",'"+dob+"')";
        String deleteSql="delete from employee1 where id="+delId;
        int count=stmt.executeUpdate(deleteSql);
         //if(insertStatus) {
             System.out.println("Employee successfully deleted");
        // }
         }
         else {
             System.out.println("connection null");
         }
         try {
                stmt.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
     }catch(SQLException se) {
         System.out.println(se);
        
     }
     finally {
        
         try {
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
     }
}

public void editEmployeeInDatabase(int id) throws ClassNotFoundException {
    try {
    	
        //Statement stmt = null;
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement stmt = conn.createStatement();
        System.out.println(id+"outer");
        if(conn!=null) {
        	System.out.println(id+"inner");        		
        		int ch;
        		while(true) {
        			System.out.println("1.Edit Name:");
        			System.out.println("2. Edit Location:");
        			
        			System.out.println("3. Edit Salary");
        			System.out.println("4.Back To The Main Menu");
        			System.out.println("Enter Your Choice 1,2,3,4:");
        			ch=sc.nextInt();
        			switch(ch) {
        			case 1:
        				String name;
        				System.out.println("Enter The Updated Name:");
        				name=sc.next();
        				//obj.get(id).setName(name);
        				String editNameSql="update employee1 set name='"+ name +"' where id="+ id;
        			    stmt.executeUpdate(editNameSql);
        			    System.out.println("Employee successfully updated");
        				
        				break;
        			case 2:
        				String loc;
        				System.out.println("Enter The Updated Location:");
        				loc=sc.next();
        				//obj.get(id).setLocation(loc);
        				String editLocationSql="update employee1 set location='"+ loc +"' where id="+ id;
        			    stmt.executeUpdate(editLocationSql);
        			    System.out.println("Employee successfully updated");
        				break;
        				
        			
        			case 3:
        				int sal;
        				System.out.println("Enter The Updated Salary:");
        				sal=sc.nextInt();
        				//obj.get(id).setSalary(sal);
        				String editSalarySql="update employee1 set salary="+ sal +" where id="+ id;
        			    stmt.executeUpdate(editSalarySql);
        			    System.out.println("Employee successfully updated");
        				break;
        								
        			
        			case 4:return;
        			
        			default:System.out.println("Enter valid Choice");
        				
        			}
        		}
        	
        
//     
        }
        else {
            System.out.println("connection null");
        }
        try {
               stmt.close();
           } catch (SQLException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
           }
    }catch(SQLException se) {
        System.out.println(se);
       
    }
    finally {
       
        try {
           conn.close();
       } catch (SQLException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       }
    }
	
}

//-----statistics from db----------//

public void employeeStatisticsFromDatabase() throws ClassNotFoundException {
    // TODO Auto-generated method stub
    System.out.println("----Employee Statistics---- ");
    try {
        Class.forName("com.mysql.jdbc.Driver");
         conn = DriverManager.getConnection(DB_URL, USER, PASS);
         Statement stmt = conn.createStatement();
        
         if(conn!=null) {
             String sql="select * from employee1 where name like 'x%'";
             ResultSet rs=stmt.executeQuery(sql);
             System.out.println("Employee Name Strt with 'x' : ");
            // System.out.println("\t Emp ID \t Emp Name \t Emp salary \t Emp DOB \t Emp Dept  ");
             while(rs.next()) {
            	 System.out.println(rs.getString("name"));
             }
            //employee having salary more than 20000
             System.out.println("Employee having salary > 20000");
             String sql2="select name from employee1 where salary>20000";
             ResultSet rs1=stmt.executeQuery(sql2);
             while(rs1.next()) {
                 System.out.println(rs1.getString("name"));
             }
             
             String sql3="select sum(salary) as total_sal from employee1";
             ResultSet rs3=stmt.executeQuery(sql3);
             while(rs3.next()) {
                 System.out.println("Total salary of all employee : "+rs3.getInt("total_sal"));
             }
            
            //average salary
             String sql4="select avg(salary) as avgSal from employee1";
             ResultSet rs4=stmt.executeQuery(sql4);
             while(rs4.next()) {
                 System.out.println("Average salary of all employee : "+rs4.getInt("avgSal"));
             }
            
//             System.out.print("Department wise employee count with sorted order :  ");
//             String sql5="select dept,count(*) as empNo from employee1 group by dept order by dept";
//             ResultSet rs5=stmt.executeQuery(sql5);
//             while(rs5.next()) {
//                 System.out.print(rs5.getString("dept")+" -> "+rs5.getInt("empNo")+" , ");
//             }
             System.out.println("\n");
             
         }else {
             System.out.println("Connection not established");
         }
    }catch(SQLException e) {
        e.printStackTrace();
    }
    finally {
         try {
             if(stmt!=null) {
                 stmt.close();
             }
         }
         catch(SQLException e) {
             e.printStackTrace();
         }
        
         try {
             if(conn!=null) {
            conn.close();
             }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
     }
}

}
