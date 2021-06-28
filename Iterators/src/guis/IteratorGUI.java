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
public class IteratorGUI extends GBFrame {
	private static JFrame frm = new IteratorGUI();
	private ArrayList<Student> studentList = new ArrayList<Student>();
	private AddStudentGUI addStudentGUI = new AddStudentGUI(frm, studentList);
	private DisplayGUI displayGUI = new DisplayGUI(frm, studentList);
	private JLabel welcomeMessage = addLabel("Create and modify your classroom here.", 1,1,1,1);
	private JButton addButton = addButton("Add a Student", 2,1,1,1);
	private JButton displayModifyButton = addButton("Display and Modify Students", 2,2,1,1);
	private JButton exitButton = addButton("Exit", 3,1,1,1);
	
	public void buttonClicked(JButton buttonObj) {
		if(buttonObj == addButton) {
			addStudentGUI.resetFrame();
			addStudentGUI.setVisible(true);
		}
		if(buttonObj == displayModifyButton) {
			displayGUI.populateList(false);
		}
		if(buttonObj == exitButton) {
			System.exit(0);
		}
	}
	public static void main(String[] args) {
		frm.setTitle("Classroom With Iterators");
		frm.setSize(500, 400);
		frm.setResizable(false);
		frm.setVisible(true);
	}
}
