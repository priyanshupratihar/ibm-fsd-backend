package com.exampales.java.io;

import java.io.File;

public class FileEx {

	public static void main(String[] args) {
		File file=new File("C:\\Users\\PRIYANSHUPRATIHAR\\Desktop");
		System.out.println("Is Directory: "+file.isDirectory());
		System.out.println("Absolute path: "+file.getAbsolutePath());
		System.out.println("Actual Path "+file.getPath());
		System.out.println(file.lastModified());   //epoch time
		
		for(File f:file.listFiles()) {
			System.out.println(f.isDirectory()? f.getName()+" is directory" : f.getName()+" is file");
		}
	}

}
