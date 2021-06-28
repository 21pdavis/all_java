package objects;

public class Student implements Comparable<Student>{
	private String name;
	private double gpa;
	
	public Student() {
		name = "";
		gpa = 0;
	}
	
	public Student(String name, double gpa) {
		this.name = name;
		this.gpa = gpa;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	
	public double getGpa(){
		return gpa;
	}
	
	@Override
	public int compareTo(Student o) {
		return name.compareTo(o.getName());
	}
	
	public String toString() {
		return "Name: " + name + ", GPA: " + (Math.round(gpa * 100) / 100); 
	}
}