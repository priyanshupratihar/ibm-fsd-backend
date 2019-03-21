package com.example.java.collection;
import java.util.Arrays;
import java.util.*;
import java.util.List;
import java.util.Vector;
public class CollectionListEx {

	public static void main(String[] args) {
		Vector countries=new Vector();
		//countries.add("India");
		//countries.add("Australia");
		//countries.add("NZ");
		
		for(int i=0;i<50;i++)
		{
			countries.add("India"+i);
		}
		System.out.println("Iterating");
		Iterator itr=countries.iterator();
		while(itr.hasNext()) {
			Object item=itr.next();
			System.out.println(item);
			itr.remove();
		}
		System.out.println(countries.size());
		System.out.println(countries.get(0));
		
		for(Object item:countries) {
			System.out.println(item);
		}
		countries.remove(1);
		System.out.println("After remove");
		for(Object item:countries) {
			System.out.println(item);
		}
		//convert collection object to array
		Object countryArray=countries.toArray();
		System.out.println(countryArray);
		
		List countriesArrToList=Arrays.asList(countryArray);
		System.out.println(countriesArrToList);
	}

}
