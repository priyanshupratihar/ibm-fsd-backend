package com.example.java;

public class PrimeNumber {

	public static void main(String[] args) {
		//prime number
				int a=10;
				int b = 30;
				int flag=0;
				for(int i = a; i <= b; i++)
		        {
		            for(int j = 2; j < i; j++)
		            {
		                if(i % j == 0)
		                {
		                    flag = 0;
		                    break;
		                }
		                else
		                {
		                    flag = 1;
		                }
		            }
		            if(flag == 1)
		            {
		                System.out.println(i+" is prime number");
		            }
		        }
		
	}

}
