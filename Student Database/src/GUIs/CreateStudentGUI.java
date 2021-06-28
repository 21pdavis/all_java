package GUIs;
// Paul Davis

import javax.swing.*;
import BreezySwing.*;
import objects.*;

@SuppressWarnings({ "serial", "unused" })
public class CreateStudentGUI extends GBDialog {
	private Person[] people;
	private Person genericPerson;
	private JLabel nameInstructionsLabel = addLabel("Enter Name: ", 1, 1, 1, 1);
	private JTextField nameInputField = addTextField("", 1, 2, 1, 1);
	private JLabel idInstructionsLabel = addLabel("Enter Student ID", 2, 1, 1, 1);
	private IntegerField idInputField = addIntegerField(0, 2, 2, 1, 1);
	private JButton createStudentButton = addButton("Create Student", 3, 1, 1, 1);
	private JButton exitButton = addButton("Exit", 3, 2, 1, 1);

	public CreateStudentGUI(JFrame frm, Person[] people, Person genericPerson) {
		super(frm);
		setSize(400, 200);
		setTitle("Create a New Student");
		this.people = people;
		this.genericPerson = genericPerson;
	}

	public void buttonClicked(JButton buttonObj) {
		if (buttonObj == createStudentButton) {
			boolean idExists = false;
			for (int i = 0; i < people.length; i++)
				if (people[i] instanceof Student && ((Student) people[i]).getID() == idInputField.getNumber())
					idExists = true;

			if (nameInputField.getText().isEmpty() == false && nameInputField.getText().matches(".*\\d.*") == false
					&& idInputField.getNumber() != 0 && idExists == false) {
				try {
					createStudent();
					messageBox("Student successfully created");
					resetFrame();
				} catch (ArrayIndexOutOfBoundsException e) {
					resetFrame();
					messageBox("Too many people:" + '\n' + e.getMessage());
				}
			} else if (nameInputField.getText().isEmpty() || nameInputField.getText().matches(".*\\d.*")) {
				messageBox("Please enter text (and only text) into the name field");
				nameInputField.setText("");
			} else if (idInputField.getNumber() == 0) {
				messageBox("Please change the id number from the default value" + '\n'
						+ "Only enter numbers into the id field");
				idInputField.setNumber(0);
			} else if (idExists == true) {
				messageBox("Student ID already taken");
				idInputField.setNumber(0);
			}
		}

		if (buttonObj == exitButton) {
			setVisible(false);
		}
	}

	private void createStudent() {
		people[genericPerson.getPeopleCount() - 1] = new Student(nameInputField.getText(), idInputField.getNumber());
	}

	public void resetFrame() {
		nameInputField.setText("");
		idInputField.setNumber(0);
	}
}