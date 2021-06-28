package objects;

/*
 * Paul Davis
 * 12/4/2020
 * Character Database Program
 * Takes in as many characters as the user inputs, then displays the characters in three lists: previous, current, and next characters
 */

public class Counter {
	int val;

	public Counter() {
		val = -1;
	}

	public Counter(int val) {
		this.val = val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public int getVal() {
		return val;
	}

	public void increment() {
		val += 1;
	}

	public void decrement() {
		val -= 1;
	}
}
