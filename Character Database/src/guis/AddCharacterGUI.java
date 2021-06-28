package guis;

/*
 * Paul Davis
 * 12/4/2020
 * Character Database Program
 * Takes in as many characters as the user inputs, then displays the characters in three lists: previous, current, and next characters
 */

import BreezySwing.*;
import javax.swing.*;
import objects.*;

@SuppressWarnings({ "serial", "unused" })
public class AddCharacterGUI extends GBDialog {
	private MyDoublyLinkedList<CustomCharacter> charList;
	private Counter currentIndex;
	private JLabel instructionLabel = addLabel("Design a Character Here!", 1, 1, 1, 1);
	private JLabel nameLabel = addLabel("Name:", 2, 1, 1, 1);
	private JTextField nameField = addTextField("", 2, 2, 1, 1);
	private JLabel roleLabel = addLabel("Class:", 3, 1, 1, 1);
	private JTextField roleField = addTextField("", 3, 2, 1, 1);
	private JLabel abilityLabel = addLabel("Ability:", 4, 1, 1, 1);
	private JTextField abilityField = addTextField("", 4, 2, 1, 1);
	private JLabel weaknessLabel = addLabel("Weakness:", 5, 1, 1, 1);
	private JTextField weaknessField = addTextField("", 5, 2, 1, 1);
	private JLabel levelLabel = addLabel("Level:", 6, 1, 1, 1);
	private JTextField levelField = addTextField("", 6, 2, 1, 1);
	private JButton createCharacterButton = addButton("Create Character", 7, 1, 1, 1);
	private JButton exitButton = addButton("Exit", 8, 1, 1, 1);

	public AddCharacterGUI(JFrame frm, MyDoublyLinkedList<CustomCharacter> charList, Counter currentIndex) {
		super(frm);
		setTitle("Add Character");
		this.charList = charList;
		this.currentIndex = currentIndex;
	}

	public void buttonClicked(JButton buttonObj) {
		if (buttonObj == createCharacterButton) {
			try {
				if (isValidInput()) {
					charList.insert(new CustomCharacter(nameField.getText(), roleField.getText(),
							abilityField.getText(), weaknessField.getText(), Integer.parseInt(levelField.getText())));
					currentIndex.increment();
					resetFrame();
					messageBox("Character Created");
				} else if (nameField.getText().isEmpty() || roleField.getText().isEmpty()
						|| abilityField.getText().isEmpty() || weaknessField.getText().isEmpty()
						|| levelField.getText().isEmpty()) {
					messageBox("One or more fields is/are empty");
				} else if (Integer.parseInt(levelField.getText()) < 0) {
					messageBox("Input a level greater than 0");
				} else if (nameField.getText().matches(".*\\d.*") || roleField.getText().matches(".*\\d.*")
						|| abilityField.getText().matches(".*\\d.*") || weaknessField.getText().matches(".*\\d.*")) {
					messageBox("Input only letters into non-level fields");
				}
			} catch (NumberFormatException e) {
				messageBox("Input only integers into level field");
			}
		}
		if (buttonObj == exitButton) {
			setVisible(false);
		}
	}

	private boolean isValidInput() {
		if (nameField.getText().matches(".*\\d.*") == false && nameField.getText().isEmpty() == false
				&& roleField.getText().matches(".*\\d.*") == false && roleField.getText().isEmpty() == false
				&& abilityField.getText().matches(".*\\d.*") == false && abilityField.getText().isEmpty() == false
				&& weaknessField.getText().matches(".*\\d.*") == false && weaknessField.getText().isEmpty() == false
				&& levelField.getText().isEmpty() == false && Integer.parseInt(levelField.getText()) >= 0)
			return true;
		return false;
	}

	public void resetFrame() {
		nameField.setText("");
		roleField.setText("");
		abilityField.setText("");
		weaknessField.setText("");
		levelField.setText("");
	}
}
