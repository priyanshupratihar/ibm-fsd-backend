package com.example.lamda;

import java.util.function.BiFunction;
import java.util.function.Consumer;

public class LamdaCalc {
	public static void main(String args[]) {
		LamdaCalc lamExp = new LamdaCalc();
			
	      //with type declaration
		// BiFunction<Integer,Integer,Integer> addition = ( a, b) -> a + b;
			
	      //with out type declaration
	     // MathOperation subtraction = (a, b) -> a - b;
		 BiFunction<Integer,Integer,Integer> subtraction = ( a, b) -> a - b;
			
	      //with return statement along with curly braces
	     // MathOperation multiplication = (int a, int b) -> { return a * b; };
	      BiFunction<Integer,Integer,Integer> multiplication = ( a, b) -> a * b;	
	      
	      //without return statement and without curly braces
	      //MathOperation division = (int a, int b) -> a / b;
	      BiFunction<Integer,Integer,Integer> division = ( a, b) -> a / b;
			
	      System.out.println("10 + 5 = " + lamExp.operate(10, 5, ( a, b) -> a + b));
	      System.out.println("10 - 5 = " + lamExp.operate(10, 5, subtraction));
	      System.out.println("10 x 5 = " + lamExp.operate(10, 5, multiplication));
	      System.out.println("10 / 5 = " + lamExp.operate(10, 5, division));
	  
	      //without parenthesis and using Consumer functional interface
	      Consumer<String> greetService1 = message ->
	      System.out.println("Hello " + message);
			
	      //without parenthesis and using Consumer functional interface
	      Consumer<String> greetService2 = (message) ->
	      System.out.println("Hello " + message);
			
	      greetService1.accept("Mahesh");
	      greetService2.accept("Suresh");      
	      
	   }
		
//	   interface MathOperation {
//	      int operation(int a, int b);
//	   }

		
	   
//	   interface GreetingService {
//	      void sayMessage(String message);
//	   }
		
	  
	   
//	   private int operate(int a, int b, MathOperation mathOperation) {
//	      return mathOperation.operation(a, b);
//	   }
	   private int operate(int a,int b,BiFunction<Integer,Integer,Integer> mathOperation) {
		   return mathOperation.apply(a,b);
	   }

}
