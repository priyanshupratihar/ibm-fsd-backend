package com.example.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RflectionMain {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<?> c;
		try {
			c = Class.forName("com.example.reflection.ReflectionEx");
			System.out.println(c);
			Constructor<?> consrt=c.getConstructor();
			System.out.println(consrt);
			
			Object obj=consrt.newInstance();
			
			Method addm=c.getMethod("add", Integer.class,Integer.class);		
			Integer result= (Integer) addm.invoke(obj,12,8);
			System.out.println("sum is:"+result);
			
			Method subm=c.getMethod("sub", Integer.class,Integer.class);		
			Integer result1= (Integer) subm.invoke(obj,56,9);
			System.out.println("diff is:"+result1);
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		; 
	}

}
