package test;

public class Musician {
	public String memName;
	
	public Musician(String name) {
		memName = name;
	}
	
	public String play() {
		return memName + " plays music.";
	}
}
