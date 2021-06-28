package objects;

public class PeopleLib {
	private Person[] people, sortedPeople;
	
	public PeopleLib() {
		people = new Person[0];
	}
	
	public PeopleLib(Person[] people) {
		this.people = people;
	}
	
	public void setPeople(Person[] people) {
		this.people = people;
	}
	
	public Person[] getPeople() {
		return people;
	}
	
	public Person[] getSortedPeople() {
		return sortedPeople;
	}
	
	public void sortPeople() {
		sortedPeople = new Person[people.length];
		for(int i = 0; i < people.length; i++) {
			sortedPeople[i] = people[i];
		}
		
		int l = sortedPeople.length;
		for(int i = 0; i < l - 1; i++) {
			int minIndex = i;
			for(int j = i + 1; j < l; j++) {
				if(sortedPeople[j].getName().compareTo(sortedPeople[minIndex].getName()) < 0) {
					minIndex = j;
				}
			}
			Person temp = sortedPeople[minIndex];
			sortedPeople[minIndex] = sortedPeople[i];
			sortedPeople[i] = temp;
		}
	}
	
	public void addPerson(String name, int age) {
		Person[] people = new Person[this.people.length + 1];
		
		for(int i = 0; i < this.people.length; i++) {
			people[i] = this.people[i];
		}
		
		people[people.length - 1] = new Person(name, age);
		this.people = people;
		sortPeople();
	}
	
	public void removePerson(int index) {
		Person[] people = new Person[this.people.length - 1];
		
		Person temp = this.people[index];
		this.people[index] = this.people[this.people.length - 1];
		this.people[this.people.length - 1] = temp;
		
		for(int i = 0; i < this.people.length - 1; i++) {
			people[i] = this.people[i];
		}
		this.people = people;
		sortPeople();
	}
}
