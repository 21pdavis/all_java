package sample;

public class Student {
	private String name;
	private int test1;
	private int test2;
	private int test3;
	
	public Student() {
		name = "";
		test1 = 0;
		test2 = 0;
		test3 = 0;
	}
	
	public Student(String name, int test1, int test2, int test3) {
		this.name = name;
		this.test1 = test1;
		this.test2 = test2;
		this.test3 = test3;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setTest1(int test1) {
		this.test1 = test1;
	}
	
	public int getTest1() {
		return test1;
	}
	
	public void setTest2(int test2) {
		this.test2 = test2;
	}
	
	public int getTest2() {
		return test2;
	}
	
	public void setTest3(int test3) {
		this.test3 = test3;
	}
	
	public int getTest3() {
		return test3;
	}
	
	public String toString() {
		return "x";
	}
}