package guis;

import BreezySwing.*;
import objects.*;
import java.util.ArrayList;
import javax.swing.*;

@SuppressWarnings ({"serial", "unused"})
public class CreateStudentGUI extends GBDialog {
	private AllStudents allStudents;
	private JLabel instructionsLabel = addLabel("When Inputting Grades, Separate the Grades with Commas", 1,1,1,1);
	private JLabel nameLabel = addLabel("Name: ", 2,1,1,1);
	private JTextField nameField = addTextField("", 2,2,1,1);
	private JLabel testsLabel = addLabel("Up to Five Test Grades: ", 3,1,1,1);
	private JTextField testsField = addTextField("", 3,2,1,1);
	private JLabel quizzesLabel = addLabel("Up to Eight Quiz Grades: ", 4,1,1,1);
	private JTextField quizzesField = addTextField("", 4,2,1,1);
	private JLabel homeworkAverageLabel = addLabel("Homework Average", 5,1,1,1);
	private JTextField homeworkAverageField = addTextField("", 5,2,1,1);
	private JButton inputButton = addButton("Create Student", 6,1,1,1);
	private JButton exitButton = addButton("Exit", 7,1,1,1);
	private JButton resetButton = addButton("Reset", 7,2,1,1);
	private boolean errorFound = false;

	public CreateStudentGUI(JFrame frm, AllStudents allStudents) {
		super(frm);
		this.allStudents = allStudents;
		setSize(500, 300);
		setTitle("Create a Student");
	}
	
	public void buttonClicked(JButton buttonObj) {
		if(buttonObj == inputButton) {
			errorFound = false;
			if(allStudents.getAllStudents().size() + 1 <= 15 && nameField.getText().matches(".*\\d.*") == false) {
				try{
					inputStudentInfo();
				}
				catch(NumberFormatException e) {
					messageBox("Error in number input:" + '\n' + "Include only spaces, commas, and numbers in inputs." + '\n' + "Also assure there are no spaces between numbers");
					errorFound = true;
					resetFrame();
				}
				catch(ArrayIndexOutOfBoundsException e) {
					messageBox("Input only up to 5 quiz grades and" + '\n' + "up to 8 test grades");
					errorFound = true;
					resetFrame();
				}
			}
			else if(allStudents.getAllStudents().size() > 15){
				messageBox("Input only 15 students");
				errorFound = true;
				resetFrame();
			}
			else if(nameField.getText().matches(".*\\d.*")) {
				messageBox("Do not include numbers in the name input");
				errorFound = true;
				resetFrame();
			}
			if(errorFound == false) {
				messageBox("Student Info Successfully Input");
				errorFound = true;
				resetFrame();
			}
			
		}
		if(buttonObj == exitButton) {
			setVisible(false);
		}
		if(buttonObj == resetButton) {
			resetFrame();
		}
	}
	
	private void inputStudentInfo() {
		boolean numsWithinBounds = true;
		for(int i = 0; i < getTestList().size(); i++){
			if(getTestList().get(i) < 0 || getTestList().get(i) > 100 || getQuizList().get(i) < 0 || getQuizList().get(i) > 100)
				numsWithinBounds = false;
		}
		for(int i = 0; i < getQuizList().size(); i++){
			if(getQuizList().get(i) < 0 || getQuizList().get(i) > 100)
				numsWithinBounds = false;
		}
		if(numsWithinBounds == true)
			allStudents.addStudent(nameField.getText(), Double.parseDouble(homeworkAverageField.getText()),
			getTestList(), getQuizList());
		else{
			messageBox("Keep quiz and test input within a 0-100 range");
			errorFound = true;
			resetFrame();
		}
	}
	
	private ArrayList<Double> getTestList() {
		ArrayList<Double> testNums = new ArrayList<Double>();
		String[] testStrings = new String[5];
		testStrings = testsField.getText().split(",");
		boolean numsWithinBounds = true;
		
		for(int i = 0; i < testStrings.length; i++)
			testStrings[i] = testStrings[i].trim();
		
		for(int i = 0; i < testStrings.length; i++)
			testNums.add(Double.parseDouble(testStrings[i]));
		
		return testNums;
	}
	
	private ArrayList<Double> getQuizList(){
		ArrayList<Double> quizNums = new ArrayList<Double>();
		String[] quizStrings = new String[8];
		quizStrings = quizzesField.getText().split(",");
		
		for(int i = 0; i < quizStrings.length; i++)
			quizStrings[i] = quizStrings[i].trim();

		for(int i = 0; i < quizStrings.length; i++)
			quizNums.add(Double.parseDouble(quizStrings[i]));
		
		return quizNums;
	}

	public void resetFrame() {
		nameField.setText("");
		testsField.setText("");
		quizzesField.setText("");
		homeworkAverageField.setText("");
	}
}