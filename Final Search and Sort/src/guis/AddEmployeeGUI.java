package guis;

import BreezySwing.*;
import javax.swing.*;
import objects.ObjectLibrary;

@SuppressWarnings({"serial", "unused"})
public class AddEmployeeGUI extends GBDialog{
	private ObjectLibrary objLib;
	private JLabel nameLabel = addLabel("Name:", 1,1,1,1);
	private JTextField nameField = addTextField("", 1,2,1,1);
	private JLabel salaryLabel = addLabel("Salary: ", 2,1,1,1);
	private JTextField salaryField = addTextField("", 2,2,1,1);
	private JButton addEmployeeButton = addButton("Add Employee", 3,1,1,1);
	private JButton exitButton = addButton("Exit", 3,2,1,1);
	
	public AddEmployeeGUI(JFrame frm, ObjectLibrary objLib) {
		super(frm);
		this.objLib = objLib;
		setSize(400, 300);
		setTitle("Add Employee");
		setResizable(false);
	}
	
	public void buttonClicked(JButton buttonObj) {
		if(buttonObj == addEmployeeButton) {
			try {
				if(nameField.getText().isEmpty() == false && salaryField.getText().isEmpty() == false && nameField.getText().matches(".*\\d.*") == false && 
						Double.parseDouble(salaryField.getText()) >= 0) {
					objLib.addEmployee(nameField.getText(), Double.parseDouble(salaryField.getText()));
					messageBox("Successfully Added Employee");
					resetFrame();
				}
				else if(nameField.getText().isEmpty() || salaryField.getText().isEmpty()) {
					messageBox("One or more fields is/are empty");
					resetFrame();
				}
				else if(nameField.getText().matches(".*\\d.*")) {
					messageBox("Input only letters in name field");
					resetFrame();
				}
				else if(Double.parseDouble(salaryField.getText()) < 0) {
					messageBox("Salary must be greater than 0");
					resetFrame();
				}
			}
			catch(NumberFormatException e) {
				messageBox("Input only valid numbers in salary field");
				resetFrame();
			}
		}
		if(buttonObj == exitButton) {
			setVisible(false);
		}
	}

	public void resetFrame() {
		nameField.setText("");
		salaryField.setText("");
	}
}