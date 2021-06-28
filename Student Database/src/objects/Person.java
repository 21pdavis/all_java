package objects;

//Paul Davis
public class Person {
	private String name;
	private static int peopleCount;

	public Person() {
		name = "";
		peopleCount++;
	}

	public Person(String nm) {
		name = nm;
		peopleCount++;
	}

	public void setName(String nm) {
		name = nm;
	}

	public String getName() {
		return name;
	}

	public void setPeopleCount(int count) {
		peopleCount = count;
	}

	public int getPeopleCount() {
		return peopleCount;
	}

	public String print() {
		return "Name: " + name;
	}
}