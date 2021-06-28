package objects;

/*
 * Paul Davis
 * 10/13/2020
 * Iterator Program
 * This program takes in a classroom of students and allows the user to 
 * remove and modify those students
 */

public class Student {
	private String name;
	private int id;
	private double gpa;
	private double grade;
	
	public Student() {
		name = "";
		id = 0;
		gpa = 0;
		grade = 0;
	}
	
	public Student(String name, int id, double gpa, double grade) {
		this.name = name;
		this.id = id;
		this.gpa = gpa;
		this.grade = grade;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setID(int id) {
		this.id = id;
	}
	
	public int getID() {
		return id;
	}
	
	public void setGPA(double gpa) {
		this.gpa = gpa;
	}
	
	public double getGPA() {
		return gpa;
	}
	
	public void setGrade(double grade) {
		this.grade = grade;
	}
	
	public double getGrade() {
		return grade;
	}
	
	public String toString() {
		return "Name: " + name + ", ID: " + id + ", GPA: " + gpa + ", Grade: " + grade;
	}
}
