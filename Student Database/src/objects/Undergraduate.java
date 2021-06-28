package objects;

//Paul Davis
public class Undergraduate extends Student {
	private String grade;

	public Undergraduate(String nm, int id, String gd) {
		setName(nm);
		setID(id);
		grade = gd;
	}

	public Undergraduate() {
		super();
		setName("");
		setID(0);
		grade = "";
	}

	public void setGrade(String gd) {
		grade = gd;
	}

	public String getGrade() {
		return grade;
	}

	public boolean equals(String gd) {
		if (gd.equals(grade)) {
			return true;
		}
		return false;
	}

	public String print() {
		return "Name: " + getName() + ", " + "ID: " + getID() + ", " + "Grade: " + grade;
	}
}