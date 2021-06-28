package GUIs;

/* Paul Davis
 * Student Database Program
 * Store and display people/different types of students
 * Amount of classes is somewhat unnecessary, but wanted practice for larger program organization/package management
 */
import javax.swing.*;
import BreezySwing.*;
import objects.*;

@SuppressWarnings({ "unused", "serial" })
public class MainGUI extends GBFrame {
	// variables and people array
	Person[] people = new Person[10];
	Person genericPerson = new Person(); // person used to access static count variable
	// Initializing frames
	private static JFrame frm = new MainGUI();
	private CreatePersonGUI createPersonGUI = new CreatePersonGUI(frm, people, genericPerson);
	private CreateStudentGUI createStudentGUI = new CreateStudentGUI(frm, people, genericPerson);
	private CreateUndergradGUI createUndergradGUI = new CreateUndergradGUI(frm, people, genericPerson);
	private CreateGradGUI createGradGUI = new CreateGradGUI(frm, people, genericPerson);
	private DisplaysGUI displaysGUI = new DisplaysGUI(frm, people);
	// beginning of GUI elements
	private JLabel welcomeLabel = addLabel("Welcome to the Student Database!", 1, 1, 1, 1);
	private JButton createPersonButton = addButton("Create a Person", 2, 1, 1, 1);
	private JButton createStudentButton = addButton("Create a Student", 2, 2, 1, 1);
	private JButton createUndergradButton = addButton("Create an Undergraduate", 3, 1, 1, 1);
	private JButton createGradButton = addButton("Create a Graduate", 3, 2, 1, 1);
	private JButton displaysButton = addButton("Displays Window", 4, 1, 1, 1);
	private JButton exitButton = addButton("Exit", 5, 1, 1, 1);
	private JButton resetButton = addButton("Reset", 5, 2, 1, 1);

	public void buttonClicked(JButton buttonObj) {
		if (buttonObj == createPersonButton) {
			createPersonGUI.resetFrame();
			createPersonGUI.setVisible(true);
		}
		if (buttonObj == createStudentButton) {
			createStudentGUI.resetFrame();
			createStudentGUI.setVisible(true);
		}
		if (buttonObj == createUndergradButton) {
			createUndergradGUI.resetFrame();
			createUndergradGUI.setVisible(true);
		}
		if (buttonObj == createGradButton) {
			createGradGUI.resetFrame();
			createGradGUI.setVisible(true);
		}
		if (buttonObj == displaysButton) {
			displaysGUI.resetFrame();
			displaysGUI.setVisible(true);
		}
		if (buttonObj == exitButton) {
			System.exit(0);
		}
		if (buttonObj == resetButton) {
			for (int i = 0; i < people.length; i++) {
				people[i] = null;
			}
			messageBox("Program Reset");
		}
	}

	public Person[] getPersonArray() {
		return people;
	}

	public static void main(String[] args) {
		frm.setTitle("Student Database");
		frm.setSize(500, 500);
		frm.setVisible(true);
	}
}