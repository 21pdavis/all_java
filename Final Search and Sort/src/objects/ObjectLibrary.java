package objects;

import java.util.ArrayList;

public class ObjectLibrary {
	ArrayList<Comparable> employees;
	ArrayList<Comparable> students;
	ArrayList<Comparable> widgets;

	public ObjectLibrary() {
		employees = new ArrayList<Comparable>();
		students = new ArrayList<Comparable>();
		widgets = new ArrayList<Comparable>();
	}

	public void addEmployee(String name, double salary) {
		employees.add(new Employee(name, salary));
	}

	public ArrayList<Comparable> getEmployees() {
		return employees;
	}

	public void addStudent(String name, double gpa) {
		students.add(new Student(name, gpa));
	}

	public ArrayList<Comparable> getStudents() {
		return students;
	}

	public void addWidget(int productNum, int numSold) {
		widgets.add(new Widget(productNum, numSold));
	}

	public ArrayList<Comparable> getWidgets() {
		return widgets;
	}
}