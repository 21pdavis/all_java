package guis;

/*
 * Paul Davis
 * 10/13/2020
 * Iterator Program
 * This program takes in a classroom of students and allows the user to 
 * remove and modify those students
 */

import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.*;
import BreezySwing.*;
import objects.Student;

@SuppressWarnings({ "unused", "serial" })
public class StudentEditingGUI extends GBDialog {
	private Student editStudent;
	private JLabel editLabel = addLabel("Edit Student Here:", 1, 1, 1, 1);
	private JLabel nameLabel = addLabel("Name:", 2, 1, 1, 1);
	private JTextField nameField = addTextField("", 2, 2, 1, 1);
	private JLabel idLabel = addLabel("ID:", 3, 1, 1, 1);
	private JTextField idField = addTextField("", 3, 2, 1, 1);
	private JLabel gpaLabel = addLabel("GPA:", 4, 1, 1, 1);
	private JTextField gpaField = addTextField("", 4, 2, 1, 1);
	private JLabel gradeLabel = addLabel("Grade:", 5, 1, 1, 1);
	private JTextField gradeField = addTextField("", 5, 2, 1, 1);
	private JButton updateButton = addButton("Update", 6, 1, 1, 1);
	private JButton exitButton = addButton("Exit", 7, 1, 1, 1);

	public StudentEditingGUI(JFrame frm) {
		super(frm);
		setTitle("Add Student");
		setSize(600, 500);
	}
	
	public void buttonClicked(JButton buttonObj) {
		if(buttonObj == updateButton) {
			updateStudent();
		}
		if(buttonObj == exitButton) {
			setVisible(false);
		}
	}
	
	private void updateStudent() {
		try {
			if (isValidInput()) {
				editStudent.setName(nameField.getText());
				editStudent.setID(Integer.parseInt(idField.getText()));
				editStudent.setGPA(Double.parseDouble(gpaField.getText()));
				editStudent.setGrade(Double.parseDouble(gradeField.getText()));
				messageBox("Student updated");
			} else if (nameField.getText().matches(".*\\d.*")) {
				messageBox("Please only input characters in name field");
			} else if (idField.getText().length() != 4) {
				messageBox("ID must be 4 digits long and positive");
			} else if (Double.parseDouble(gpaField.getText()) < 0 || Double.parseDouble(gpaField.getText()) > 5) {
				messageBox("Input a GPA between 0 and 5");
			}
			else if (Double.parseDouble(gradeField.getText()) < 0 || Double.parseDouble(gradeField.getText()) > 100) {
				messageBox("Input a grade between 0 and 100");
			}
			else {
				messageBox("One or more fields is empty");
			}
		} catch (NumberFormatException e) {
			messageBox("Input only numbers into id, gpa, and grade fields");
		}
	}
	
	private boolean isValidInput() {
		if (nameField.getText().matches(".*\\d.*") == false && idField.getText().length() == 4
				&& Integer.parseInt(idField.getText()) > 0 && Double.parseDouble(gpaField.getText()) >= 0
				&& Double.parseDouble(gpaField.getText()) <= 5 && Double.parseDouble(gradeField.getText()) >= 0
				&& Double.parseDouble(gradeField.getText()) <= 100 && nameField.getText().isEmpty() == false
				&& idField.getText().isEmpty() == false && gpaField.getText().isEmpty() == false
				&& gradeField.getText().isEmpty() == false)
			return true;

		return false;
	}

	public void initFrame(Student editStudent) {
		resetFrame();
		this.editStudent = editStudent;
		
		nameField.setText(editStudent.getName());
		idField.setText(Integer.toString(editStudent.getID()));
		gpaField.setText(Double.toString(editStudent.getGPA()));
		gradeField.setText(Double.toString(editStudent.getGrade()));
	}
	
	public void resetFrame() {
		nameField.setText("");
		idField.setText("");
		gpaField.setText("");
		gradeField.setText("");
	}
}
