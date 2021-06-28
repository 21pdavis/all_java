package objects;

//Paul Davis
public class Student extends Person {
	private int studentID;

	public Student(String nm, int id) {
		setName(nm);
		studentID = id;
	}

	public Student() {
		super();
		setName("");
		studentID = 0;
	}

	public void setID(int id) {
		studentID = id;
	}

	public int getID() {
		return studentID;
	}

	public String print() {
		return "Name: " + getName() + "," + "ID: " + studentID;
	}
}