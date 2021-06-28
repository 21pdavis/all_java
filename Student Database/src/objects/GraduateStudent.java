package objects;

//Paul Davis
public class GraduateStudent extends Student {
	private String major;

	public GraduateStudent(String nm, int id, String maj) {
		setName(nm);
		setID(id);
		major = maj;
	}

	public GraduateStudent() {
		super();
		setName("");
		setID(0);
		major = "";
	}

	public void setMajor(String maj) {
		major = maj;
	}

	public String getMajor() {
		return major;
	}

	public boolean equals(String maj) {
		if (maj.equals(major)) {
			return true;
		}
		return false;
	}

	public String print() {
		return "Name: " + getName() + ", " + "ID: " + getID() + ", " + "Major: " + major;
	}
}