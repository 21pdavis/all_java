package objects;

/*
 * Paul Davis
 * 12/4/2020
 * Character Database Program
 * Takes in as many characters as the user inputs, then displays the characters in three lists: previous, current, and next characters
 */

public class CustomCharacter {
	private String name;
	private String role;
	private String ability;
	private String weakness;
	private int level;

	public CustomCharacter() {
		name = "";
		role = "";
		ability = "";
		weakness = "";
		level = 0;
	}

	public CustomCharacter(String name, String role, String ability, String weakness, int level) {
		this.name = name;
		this.role = role;
		this.ability = ability;
		this.weakness = weakness;
		this.level = level;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getRole() {
		return role;
	}

	public void setAbility(String ability) {
		this.ability = ability;
	}

	public String getAbility() {
		return ability;
	}

	public void setWeakness(String weakness) {
		this.weakness = weakness;
	}

	public String getWeakness() {
		return weakness;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getLevel() {
		return level;
	}

	public String toString() {
		return name + role + ability + weakness + level;
	}
}
