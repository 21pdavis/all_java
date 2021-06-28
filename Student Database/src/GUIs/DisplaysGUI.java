package GUIs;

//Paul Davis
import javax.swing.*;
import BreezySwing.*;
import objects.*;

@SuppressWarnings({ "serial", "unused" })
public class DisplaysGUI extends GBDialog {
	private Person[] people;
	private JButton displayPeopleButton = addButton("Display People", 1, 1, 1, 1);
	private JButton displayStudentsButton = addButton("Display Students", 1, 2, 1, 1);
	private JButton displayUndergradsButton = addButton("Display Undergraduates", 2, 1, 1, 1);
	private JButton displayGradsButton = addButton("Display Graduates", 2, 2, 1, 1);
	private JList<String> list = addList(3, 1, 2, 1);
	private DefaultListModel<String> model = (DefaultListModel<String>) list.getModel();
	private JButton exitButton = addButton("Exit", 4, 1, 1, 1);
	private JButton resetButton = addButton("Reset", 4, 2, 1, 1);

	public DisplaysGUI(JFrame frm, Person[] people) {
		super(frm);
		setSize(400, 500);
		setTitle("Displays Window");
		this.people = people;
	}

	public void buttonClicked(JButton buttonObj) {
		if (buttonObj == displayPeopleButton) {
			boolean personFound = false;
			resetFrame();
			for (Person p : people) {
				if (p instanceof Person) {
					personFound = true;
					model.addElement(p.print());
				}
			}
			if (personFound == false)
				messageBox("No people found");
		}
		if (buttonObj == displayStudentsButton) {
			boolean studentFound = false;
			resetFrame();
			for (Person p : people) {
				if (p instanceof Student) {
					model.addElement(p.print());
					studentFound = true;
				}
			}
			if (studentFound == false) {
				messageBox("No students found");
			}
		}
		if (buttonObj == displayUndergradsButton) {
			boolean undergradFound = false;
			resetFrame();
			for (Person p : people) {
				if (p instanceof Undergraduate) {
					model.addElement(p.print());
					undergradFound = true;
				}
			}
			if (undergradFound == false) {
				messageBox("No undergraduate students found");
			}
		}
		if (buttonObj == displayGradsButton) {
			boolean gradFound = false;
			resetFrame();
			for (Person p : people) {
				if (p instanceof GraduateStudent) {
					model.addElement(p.print());
					gradFound = true;
				}
			}
			if (gradFound == false) {
				messageBox("No graduate students found");
			}
		}
		if (buttonObj == exitButton) {
			setVisible(false);
		}
		if (buttonObj == resetButton) {
			resetFrame();
		}
	}

	public void resetFrame() {
		model.clear();
	}
}