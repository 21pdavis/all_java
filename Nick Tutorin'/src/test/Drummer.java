package test;

public class Drummer extends Musician {
	
	public Drummer(String name) {
		super(name);
	}
	
	public String play() {
		return memName + " plays drums.";
	}
}
