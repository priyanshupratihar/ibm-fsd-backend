package com.examples.java.concurrency;

public class CounterDemo {

	public static void main(String[] args) {
    Counter counter = new Counter();
    counter.increment();
    counter.decrement();
    counter.increment();
    counter.increment();
    System.out.println(counter);
	}
	

}
