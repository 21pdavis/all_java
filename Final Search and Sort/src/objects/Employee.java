package objects;

public class Employee implements Comparable<Employee>{
	private String name;
	private double salary;
	
	public Employee() {
		name = "";
		salary = 0;
	}
	
	public Employee(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public double getSalary() {
		return salary;
	}
	
	@Override
	public int compareTo(Employee o) {
		return Double.compare(salary, o.getSalary());
	}
	
	public String toString() {
		return "Name: " + name + ", Salary: " + Math.round(salary * 100) / 100;
	}
}