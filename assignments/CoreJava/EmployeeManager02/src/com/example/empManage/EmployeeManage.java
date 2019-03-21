package com.example.empManage;
import java.util.*;
import java.util.Collection;
import java.util.TreeMap;



public class EmployeeManage {
	
static TreeMap<Integer,Object> empObj=new TreeMap<Integer,Object>();
    
    static void showEmp(Collection<Object> col) {
        for(Object emp:col) {
            System.out.println(emp);
        }
     }
     static void displayAll(Collection< Map.Entry<Integer, Object>> col) {
            Iterator< Map.Entry<Integer, Object>> itr = col.iterator();
            while (itr.hasNext()) {
                Map.Entry<Integer, Object> entry = itr.next();
                System.out.println(entry.getKey() + " " + entry.getValue() + " "); 
            }
            System.out.println();
    }
    
    
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub       
        empObj.put(1, new Employee<Float>(101,"abc",30000.70f));
        empObj.put(2, new Employee<Double>(102,"xyz",30000.50));
        empObj.put(3, new Employee<Integer>(103,"mnp",30000));
        
        showEmp(empObj.values());
        displayAll(empObj.entrySet());
        
        
        showEmp(empObj.values());
        EmployeeManage.deleteEmp();
        //Searching based on key
        serchEmp(empObj.get(3));   
    }
    public static void deleteEmp() {
        System.out.println("deleted emp : "+ empObj.remove(2));
        displayAll(empObj.entrySet());    
    }
    private static void serchEmp(Object ob) {
        System.out.println("search by key");
        System.out.println(ob);
    }

}
