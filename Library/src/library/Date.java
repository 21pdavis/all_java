package library;

public class Date {
	private int month;
	private int day;
	private int year;
	
	public Date() { //default constructor
		month = 0;
		day = 0;
		year = 0;
	}
	
	public Date(int m, int d, int y) { //constructor
		month = m;
		day = d;
		year = y;
	}
	
	public void setMonth(int m) {
		month = m;
	}
	
	public int getMonth() {
		return month;
	}
	
	public void setDay(int d) {
		day = d;
	}
	
	public int getDay() {
		return day;
	}
	
	public void setYear(int y) {
		year = y;
	}
	
	public int getYear() {
		return year;
	}
	
	public int getDayOfYear() {
		int dayOfYear = 0;
		int[] notLeapYearMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int[] leapYearMonths = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		if(isLeap()) {
			if(month == 1)
				dayOfYear = day;
			else {
				for(int i = 0; i < month - 1; i++) {
					dayOfYear += leapYearMonths[i];
				}
				dayOfYear += day;
			}
		}
		else {
			if(month == 01)
				dayOfYear = day;
			else {
				for(int i = 0; i < month - 1; i++) {
					dayOfYear += notLeapYearMonths[i];
				}
				dayOfYear += day;
			}
		}
		
		return dayOfYear;
	}
	
	private boolean isLeap() {
		boolean leap;
		if((year % 4 == 0 && year % 100 != 0) || (year % 4 == 0 && year % 400 == 0))
			leap = true;
		else
			leap = false;
		return leap;
	}
	
	public String toString() {
		return month + "/" + day + "/" + year;
	}
}
