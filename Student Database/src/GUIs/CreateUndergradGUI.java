package GUIs;

//Paul Davis
import javax.swing.*;
import BreezySwing.*;
import objects.*;

@SuppressWarnings({ "serial", "unused" })
public class CreateUndergradGUI extends GBDialog {
	private Person[] people;
	private Person genericPerson;
	private boolean initialized = false;
	private JLabel nameInstructionsLabel = addLabel("Enter Name: ", 1, 1, 1, 1);
	private JTextField nameInputField = addTextField("", 1, 2, 1, 1);
	private JLabel idInstructionsLabel = addLabel("Enter Student ID", 2, 1, 1, 1);
	private IntegerField idInputField = addIntegerField(0, 2, 2, 1, 1);
	private JComboBox<String> gradesBox = addComboBox(3, 1, 1, 1);
	private JButton createUndergradButton = addButton("Create Undergraduate", 4, 1, 1, 1);
	private JButton compareUndergradButton = addButton("Compare with existing students", 4, 2, 1, 1);
	private JLabel matchingUndergradsListLabel = addLabel("Undergraduates of the same grade level:", 5, 1, 2, 1);
	private JList<String> list = addList(6, 1, 2, 1);
	private DefaultListModel<String> model = (DefaultListModel<String>) list.getModel();
	private JButton exitButton = addButton("Exit", 7, 1, 1, 1);

	public CreateUndergradGUI(JFrame frm, Person[] people, Person genericPerson) {
		super(frm);
		setSize(400, 400);
		setTitle("Create a New Undergrad Student");
		this.people = people;
		this.genericPerson = genericPerson;
	}

	public void buttonClicked(JButton buttonObj) {
		if (buttonObj == createUndergradButton) {
			if (nameInputField.getText().isEmpty() == false && nameInputField.getText().matches(".*\\d.*") == false
					&& idInputField.getNumber() != 0) {
				try {
					createUndergrad();
					messageBox("Undergraduate student successfully created");
					resetFrame();
				} catch (ArrayIndexOutOfBoundsException e) {
					messageBox("Too many people:" + '\n' + e.getMessage());
					resetFrame();
				}
			} else if (nameInputField.getText().isEmpty() || nameInputField.getText().matches(".*\\d.*")) {
				messageBox("Please enter text (and only text) into the name field");
				nameInputField.setText("");
			} else if (idInputField.getNumber() == 0) {
				messageBox("Please change the id number from the default value" + '\n'
						+ "Only enter numbers into the id field");
				idInputField.setNumber(0);
			}
		}
		if (buttonObj == compareUndergradButton) {
			boolean undergradFound = false;
			model.clear();
			for (int i = 0; people[i] != null; i++) {
				if (people[i] instanceof Undergraduate
						&& ((Undergraduate) people[i]).getGrade().equals(gradesBox.getSelectedItem())) {
					undergradFound = true;
					model.addElement(((Undergraduate) people[i]).print());
				}
			}
			if (undergradFound == false)
				messageBox("No undergraduates of this " + '\n' + "grade level found");
		}
		if (buttonObj == exitButton) {
			setVisible(false);
		}
	}

	private void createUndergrad() {
		people[genericPerson.getPeopleCount() - 1] = new Undergraduate(nameInputField.getText(),
				idInputField.getNumber(), (String) gradesBox.getSelectedItem());
	}

	public void resetFrame() {
		if (initialized == false) {
			gradesBox.addItem("Freshman");
			gradesBox.addItem("Sophomore");
			gradesBox.addItem("Junior");
			gradesBox.addItem("Senior");
			initialized = true;
		}
		gradesBox.setSelectedIndex(0);
		nameInputField.setText("");
		idInputField.setNumber(0);
	}
}