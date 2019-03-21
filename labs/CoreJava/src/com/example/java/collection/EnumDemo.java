package com.example.java.collection;

public class EnumDemo {
	public enum WeekDays {
		MONDAY{
			public String getDisplayName()
			{
				return "monday";
			}
		},
		TUESDAY{
			public String getDisplayName()
			{
				//System.out.println("tuesday");
				return "tuesday";
			}
		},
		WEDNESDAY,
		THURSDAY,
		FRIDAY,
		SATURDAY;
		
		private WeekDays()
		{
			System.out.println("constructor");
		}
		public String getDisplayName()
		{
			//System.out.println("enum method test");
			return "enum method test";
		}
		
	};
	public static void main(String[] args) 
	{
		String day="MONDAY";
		//String Comparision
		if(WeekDays.MONDAY.toString()==day) 
		{
			System.out.println("given day is "+day);
		}
		
		//Enum compare
		if(WeekDays.MONDAY==WeekDays.valueOf(day)) 
		{
			System.out.println("Enum comp given day is "+day);
		}
		//get all values
		for(Object weekDay:WeekDays.values()) {
			System.out.println(weekDay);
		}
	}
}
