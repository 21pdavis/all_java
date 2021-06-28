package guis;

import javax.swing.*;
import objects.*;
import BreezySwing.*;

@SuppressWarnings({"serial", "unused"})
public class AddPersonGUI extends GBDialog{
	private PeopleLib peopleLib;
	private JLabel nameInputLabel = addLabel("Name: ", 1,1,1,1);
	private JTextField nameInputField = addTextField("", 1,2,1,1);
	private JLabel ageInputLabel = addLabel("Age: ", 2,1,1,1);
	private JTextField ageInputField = addTextField("", 2,2,1,1);
	private JButton addPersonButton = addButton("Add Person", 3,1,1,1);
	private JButton exitButton = addButton("Exit", 3,2,1,1);
	
	public AddPersonGUI(JFrame frm, PeopleLib peopleLib) {
		super(frm);
		this.peopleLib = peopleLib;
		setSize(400, 300);
		setResizable(false);
		setTitle("Add a Person");
	}
	
	public void buttonClicked(JButton buttonObj) {
		if(buttonObj == addPersonButton) {
			boolean errorFound = false;
			try {
				if(nameInputField.getText().matches(".*\\d.*") == false && Integer.parseInt(ageInputField.getText()) >= 0 && nameInputField.getText().isEmpty() == false) {
					peopleLib.addPerson(nameInputField.getText(), Integer.parseInt(ageInputField.getText()));
				}
				else if(nameInputField.getText().matches(".*\\d.*")) {
					messageBox("Do not include numbers in name input");
					resetFrame();
					errorFound = true;
				}
				else if(Integer.parseInt(ageInputField.getText()) < 0) {
					messageBox("Age must be at least 0");
					resetFrame();
					errorFound = true;
				}
				else if(nameInputField.getText().isEmpty() == true) {
					messageBox("Name and/or age input is empty");
					resetFrame();
					errorFound = true;
				}
			}
			catch(NumberFormatException e) {
				messageBox("Include only numbers in age input" + '\n' + "(and check if age input is empty");
				resetFrame();
				errorFound = true;
			}
			if(errorFound == false) {
				messageBox("Person Successfully Added");
				resetFrame();
			}
		}
		if(buttonObj == exitButton) {
			setVisible(false);
		}
	}
	
	public void resetFrame() {
		nameInputField.setText("");
		ageInputField.setText("");
	}
}