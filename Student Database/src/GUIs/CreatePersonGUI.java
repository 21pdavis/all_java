package GUIs;

// Paul Davis
import javax.swing.*;
import BreezySwing.*;
import objects.*;

@SuppressWarnings({ "serial", "unused" })
public class CreatePersonGUI extends GBDialog {
	private Person[] people;
	private Person genericPerson;
	private JLabel nameInstructionsLabel = addLabel("Enter Name: ", 1, 1, 1, 1);
	private JTextField nameInputField = addTextField("", 1, 2, 1, 1);
	private JButton createPersonButton = addButton("Create Person", 2, 1, 1, 1);
	private JButton exitButton = addButton("Exit", 2, 2, 1, 1);

	public CreatePersonGUI(JFrame frm, Person[] people, Person genericPerson) {
		super(frm);
		setSize(400, 200);
		setTitle("Create a New Person");
		this.people = people;
		this.genericPerson = genericPerson;
	}

	public void buttonClicked(JButton buttonObj) {
		if (buttonObj == createPersonButton) {
			if (nameInputField.getText().isEmpty() == false && nameInputField.getText().matches(".*\\d.*") == false) {
				try {
					createPerson();
					messageBox("Person successfully created");
					resetFrame();
				} catch (ArrayIndexOutOfBoundsException e) {
					messageBox("Too many people:" + '\n' + e.getMessage());
					resetFrame();
				}
			} else {
				messageBox("Please enter text (and only text) into the name field");
				nameInputField.setText("");
			}
		}
		if (buttonObj == exitButton) {
			setVisible(false);
		}
	}

	private void createPerson() {
		people[genericPerson.getPeopleCount() - 1] = new Person(nameInputField.getText());
	}

	public void resetFrame() {
		nameInputField.setText("");
	}
}