package com.exampales.java.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFileWithByteStreamEx {

	public static void main(String[] args) throws IOException {
		FileInputStream in = null;
	      FileOutputStream out = null;

	      try {
	         in = new FileInputStream("C:\\Users\\PRIYANSHUPRATIHAR\\Desktop\\test.txt");
	        // out = new FileOutputStream("Desktop\\test.txt");
	         
	         int c;
	         while ((c = in.read()) != -1) {
	            System.out.print((char)c);
	        	// out.write(c);
	         }         
	  
	         System.out.println(" File copied successfully.");         
	       
	      }catch(FileNotFoundException e)
	      {	  
	    	  System.out.println("exception: "+e.getLocalizedMessage());
	      }
	}

}
