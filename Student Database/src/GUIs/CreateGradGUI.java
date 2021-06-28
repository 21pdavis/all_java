package GUIs;

//Paul Davis
import javax.swing.*;
import BreezySwing.*;
import objects.*;

@SuppressWarnings({ "serial", "unused" })
public class CreateGradGUI extends GBDialog {
	private Person[] people;
	private Person genericPerson;
	private JLabel nameInstructionsLabel = addLabel("Enter Name: ", 1, 1, 1, 1);
	private JTextField nameInputField = addTextField("", 1, 2, 1, 1);
	private JLabel idInstructionsLabel = addLabel("Enter Student ID", 2, 1, 1, 1);
	private IntegerField idInputField = addIntegerField(0, 2, 2, 1, 1);
	private JLabel majorInstructionsLabel = addLabel("Enter Major", 3, 1, 1, 1);
	private JTextField majorInputField = addTextField("", 3, 2, 1, 1);
	private JButton createGraduateButton = addButton("Create Graduate", 4, 1, 1, 1);
	private JButton compareGraduatesButton = addButton("Compare with existing students", 4, 2, 1, 1);
	private JLabel matchingUndergradsListLabel = addLabel("Graduates of the same major:", 5, 1, 2, 1);
	private JList<String> list = addList(6, 1, 2, 1);
	private DefaultListModel<String> model = (DefaultListModel<String>) list.getModel();
	private JButton exitButton = addButton("Exit", 7, 2, 1, 1);

	public CreateGradGUI(JFrame frm, Person[] people, Person genericPerson) {
		super(frm);
		setSize(400, 400);
		setTitle("Create a New Graduate Student");
		this.people = people;
		this.genericPerson = genericPerson;
	}

	public void buttonClicked(JButton buttonObj) {
		if (buttonObj == createGraduateButton) {
			if (nameInputField.getText().isEmpty() == false && nameInputField.getText().matches(".*\\d.*") == false
					&& idInputField.getNumber() != 0 && majorInputField.getText().isEmpty() == false
					&& majorInputField.getText().matches(".*\\d.*") == false) {
				try {
					createGrad();
					messageBox("Graduate student successfully created");
					resetFrame();
				} catch (ArrayIndexOutOfBoundsException e) {
					messageBox("Too many people:" + '\n' + e.getMessage());
					resetFrame();
				}
			} else if (nameInputField.getText().isEmpty() || nameInputField.getText().matches(".*\\d.*")) {
				messageBox("Please enter text (and only text) into the name field");
			} else if (idInputField.getNumber() == 0) {
				messageBox("Please change the id number from the default value" + '\n'
						+ "Only enter numbers into the id field");
			} else if (majorInputField.getText().isEmpty() || majorInputField.getText().matches(".*\\d.*")) {
				messageBox("Please enter text (and only text) into the major field");
			}
		}
		if (buttonObj == compareGraduatesButton) {
			boolean gradFound = false;
			model.clear();
			for (int i = 0; people[i] != null; i++) {
				if (people[i] instanceof GraduateStudent
						&& ((GraduateStudent) people[i]).getMajor().equals(majorInputField.getText())) {
					gradFound = true;
					model.addElement(((GraduateStudent) people[i]).print());
				}
			}
			if (gradFound == false)
				messageBox("No graduates of this " + '\n' + "major found");
		}
		if (buttonObj == exitButton) {
			setVisible(false);
		}
	}

	private void createGrad() {
		people[genericPerson.getPeopleCount() - 1] = new GraduateStudent(nameInputField.getText(),
				idInputField.getNumber(), majorInputField.getText());
	}

	public void resetFrame() {
		nameInputField.setText("");
		idInputField.setNumber(0);
		majorInputField.setText("");
	}
}