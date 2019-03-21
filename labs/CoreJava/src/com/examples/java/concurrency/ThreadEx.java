package com.examples.java.concurrency;

import java.util.Scanner;

public class ThreadEx {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Thread lifecycle demo");
		
		System.out.println("sleeping");
		Thread.sleep(5000);
		
		System.out.println("Thread wake up..");
		Scanner in =new Scanner(System.in);
		System.out.println(in.nextLine());
		ThreadEx tx=new ThreadEx();
		tx.wait(4000);
		System.out.println(Thread.currentThread().getName());
	}

}
