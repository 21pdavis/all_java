package guis;

/*
 * Paul Davis
 * 10/13/2020
 * Iterator Program
 * This program takes in a classroom of students and allows the user to 
 * remove and modify those students
 */

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.*;
import BreezySwing.*;
import objects.Student;

@SuppressWarnings({ "unused", "serial" })
public class AddStudentGUI extends GBDialog {
	private ArrayList<Student> studentList;
	private JLabel welcomeMessage = addLabel("Create student:", 1, 1, 1, 1);
	private JLabel nameLabel = addLabel("Name:", 2, 1, 1, 1);
	private JTextField nameField = addTextField("", 2, 2, 1, 1);
	private JLabel idLabel = addLabel("ID (4 digit code):", 3, 1, 1, 1);
	private JTextField idField = addTextField("", 3, 2, 1, 1);
	private JLabel gpaLabel = addLabel("GPA (5 point scale):", 4, 1, 1, 1);
	private JTextField gpaField = addTextField("", 4, 2, 1, 1);
	private JLabel gradeLabel = addLabel("Grade:", 5, 1, 1, 1);
	private JTextField gradeField = addTextField("", 5, 2, 1, 1);
	private JButton addButton = addButton("Add Student", 6, 1, 1, 1);
	private JButton exitButton = addButton("Exit", 7, 1, 1, 1);
	private JButton resetButton = addButton("Reset", 7, 2, 1, 1);

	public void buttonClicked(JButton buttonObj) {
		if (buttonObj == addButton) {
			addStudent();
		}
		if (buttonObj == exitButton) {
			setVisible(false);
		}
		if(buttonObj == resetButton) {
			resetFrame();
		}
	}

	public AddStudentGUI(JFrame frm, ArrayList<Student> studentList) {
		super(frm);
		setTitle("Add Student");
		setSize(600, 500);
		this.studentList = studentList;
	}

	private void addStudent() {
		try {
			if (isValidInput()) {
				studentList.add(new Student(nameField.getText(), Integer.parseInt(idField.getText()),
						Double.parseDouble(gpaField.getText()), Double.parseDouble(gradeField.getText())));
				messageBox("Student added");
				resetFrame();
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

	public void resetFrame() {
		nameField.setText("");
		idField.setText("");
		gpaField.setText("");
		gradeField.setText("");
	}
}
