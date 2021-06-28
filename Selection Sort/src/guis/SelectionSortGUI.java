package guis;

import BreezySwing.*;
import objects.*;
import javax.swing.*;

@SuppressWarnings ({"serial", "unused"})
public class SelectionSortGUI extends GBFrame {
	private static JFrame frm = new SelectionSortGUI();
	private AllStudents allStudents = new AllStudents();
	private CreateStudentGUI createStudentGUI = new CreateStudentGUI(frm, allStudents);
	private SortGUI sortGUI = new SortGUI(frm, allStudents);
	private JLabel welcomeLabel = addLabel("Welcome to the Student Sorting Program!", 1,1,1,1);
	private JButton inputStudentButton = addButton("Add Student", 2,1,1,1);
	private JButton sortButton = addButton("Sorting Window", 2,2,1,1);
	private JButton exitButton = addButton("Exit", 3,1,1,1);
	private JButton resetButton = addButton("Reset Program", 3,2,1,1);
	
	public void buttonClicked(JButton buttonObj) {
		if(buttonObj == inputStudentButton) {
			createStudentGUI.resetFrame();
			createStudentGUI.setVisible(true);
		}
		if(buttonObj == sortButton) {
			sortGUI.resetFrame();
			sortGUI.setVisible(true);
		}
		if(buttonObj == exitButton) {
			System.exit(0);
		}
		if(buttonObj == resetButton) {
			resetProgram();
			messageBox("Program Reset");
		}
	}
	
	private void resetProgram() {
		allStudents.resetAllStudents();
	}
	
	public static void main(String[] args) {
		frm.setTitle("Student Sorting Program");
		frm.setSize(600, 200);
		frm.setVisible(true);
	}
}