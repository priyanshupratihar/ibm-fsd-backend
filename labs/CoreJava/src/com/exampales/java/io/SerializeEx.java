package com.exampales.java.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;


public class SerializeEx {
	
	public static void main(String[] args) {
		Employee e = new Employee();
		e.name = "Priyanshu Pratihar";
		e.address = "abc edf";
		e.SSN = 366499883;
		e.id = 101;
		e.skills=Arrays.asList("java","python","javaScript");
		

		try {
			FileOutputStream fileOut = new FileOutputStream("C:\\Users\\PRIYANSHUPRATIHAR\\Desktop\\employee.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(e);
			out.close();
			fileOut.close();
			System.out.printf("Serialized data is saved in C:\\Users\\PRIYANSHUPRATIHAR\\Desktop\\employee.ser");
		} catch (IOException i) {
			i.printStackTrace();
		}
	}
	
}
