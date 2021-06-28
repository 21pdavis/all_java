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
public class DisplayGUI extends GBDialog {
	private ArrayList<Student> studentList;
	private Student editStudent;
	private JLabel outputLabel = addLabel("Entire Classroom (double click to modify an individual student):", 1, 1, 1,1);
	private JButton refreshButton = addButton("Refresh List", 2,1,1,1);
	private JList<String> studentListOutput = addList(3, 1, 1, 1);
	private DefaultListModel<String> studentListOutputModel = (DefaultListModel<String>) studentListOutput.getModel();
	private JButton removeButton = addButton("Remove Selected Student", 4, 1, 1, 1);
	private JButton exitButton = addButton("Exit", 4, 2, 1, 1);
	private StudentEditingGUI studentEditingGUI;

	public DisplayGUI(JFrame frm, ArrayList<Student> studentList) {
		super(frm);
		this.studentList = studentList;
		setTitle("Display and Modify Students");
		setSize(600, 500);
		studentEditingGUI = new StudentEditingGUI(frm);
	}

	public void buttonClicked(JButton buttonObj) {
		if(buttonObj == refreshButton) {
			populateList(false);
		}
		if(buttonObj == removeButton) {
			removeStudent();
		}
		if(buttonObj == exitButton) {
			setVisible(false);
		}
	}

	public void listDoubleClicked(JList listObj, String itemClicked) {
		if (listObj.equals(studentListOutput)) {
			editStudent = findStudent(listObj.getSelectedIndex());
			studentEditingGUI.initFrame(editStudent);
			studentEditingGUI.setVisible(true);
		}
	}

	public void populateList(boolean studentJustRemoved) {
		studentListOutputModel.clear();
		Iterator<Student> it = studentList.iterator();

		if(it.hasNext()) {
			while (it.hasNext()) {
				Student s = it.next();
				studentListOutputModel.addElement(s.toString());
			}
			setVisible(true);
		}
		else if(studentJustRemoved == false && it.hasNext() == false) {
			messageBox("No students in classroom");
		}
	}
	
	private void removeStudent() {
		Iterator<Student> it = studentList.listIterator();
		int index = studentListOutput.getSelectedIndex();
		
		for(int i = 0; i <= index; i++) {
			if(it.hasNext()) {
				it.next();
			}
		}
		
		it.remove();
		messageBox("Student Removed");
		populateList(true);
	}

	public Student findStudent(int index) {
		Student s = new Student();
		Iterator it = studentList.listIterator();
		for (int i = 0; i <= index; i++) {
			if (i <= index - 1) {
				it.next();
			}
			if (i == index) {
				s = (Student) it.next();
			}
		}
		return s;
	}
}
