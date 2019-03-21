package com.example.java.collection;

public class VarArgsDemo {

	public static int sum(int...args) 
	{	
		int total=0;
		for(int arg:args) {
			total+=arg;
		}
		return total;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sum(10,56));
	}
	
	
}
