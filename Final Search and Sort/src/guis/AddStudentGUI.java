package guis;

import BreezySwing.*;
import javax.swing.*;
import objects.ObjectLibrary;

@SuppressWarnings({"serial", "unused"})
public class AddStudentGUI extends GBDialog{
	private ObjectLibrary objLib;
	private JLabel nameLabel = addLabel("Name:", 1,1,1,1);
	private JTextField nameField = addTextField("", 1,2,1,1);
	private JLabel gpaLabel = addLabel("GPA: ", 2,1,1,1);
	private JTextField gpaField = addTextField("", 2,2,1,1);
	private JButton addStudentButton = addButton("Add Student", 3,1,1,1);
	private JButton exitButton = addButton("Exit", 3,2,1,1);
	
	public AddStudentGUI(JFrame frm, ObjectLibrary objLib) {
		super(frm);
		this.objLib = objLib;
		setSize(400, 300);
		setTitle("Add Student");
		setResizable(false);
	}
	
	public void buttonClicked(JButton buttonObj) {
		if(buttonObj == addStudentButton) {
			try {
				if(nameField.getText().isEmpty() ==false && gpaField.getText().isEmpty() == false && nameField.getText().matches(".*\\d.*") == false &&
						Double.parseDouble(gpaField.getText()) >= 0 && Double.parseDouble(gpaField.getText()) <= 5) {
					objLib.addStudent(nameField.getText(), Double.parseDouble(gpaField.getText()));
					messageBox("Successfully Added Student");
					resetFrame();
				}
				else if(nameField.getText().isEmpty() || gpaField.getText().isEmpty()) {
					messageBox("One or more fields is/are empty");
					resetFrame();
				}
				else if(nameField.getText().matches(".*\\d.*")) {
					messageBox("Input only letters in name field");
					resetFrame();
				}
				else if(Double.parseDouble(gpaField.getText()) < 0 || Double.parseDouble(gpaField.getText()) > 5) {
					messageBox("GPA must be greater than 0 and less than 5");
					resetFrame();
				}
			}
			catch(NumberFormatException e) {
				messageBox("Input only validnumbers in name field");
				
			}
		}
		if(buttonObj == exitButton) {
			setVisible(false);
		}
	}
	
	public void resetFrame() {
		nameField.setText("");
		gpaField.setText("");
	}
}