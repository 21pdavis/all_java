package guis;

import javax.swing.*;
import objects.*;
import BreezySwing.*;

@SuppressWarnings({"serial", "unused"})
public class EditGUI extends GBDialog{
	private int index;
	private PeopleLib peopleLib;
	private JLabel instructionsLabel = addLabel("Use this window to view and/or change the searched person", 1,1,1,1);
	private JLabel nameLabel = addLabel("Name: ", 2,1,1,1);
	private JTextField nameField = addTextField("", 2,2,1,1);
	private JLabel ageLabel = addLabel("Age: ", 3,1,1,1);
	private JTextField ageField = addTextField("", 3,2,1,1);
	private JButton updatePersonButton = addButton("Update Person", 4,1,1,1);
	private JButton removePersonButton = addButton("Remove Person", 4,2,1,1);
	private JButton exitButton = addButton("Exit", 5,1,1,1);
	
	public EditGUI(JFrame frm, PeopleLib peopleLib) {
		super(frm);
		this.peopleLib = peopleLib;
		setSize(500, 300);
		setTitle("Display and Edit Window");
		setResizable(false);
	}
	
	public void buttonClicked(JButton buttonObj) {
		if(buttonObj == updatePersonButton) {
			peopleLib.getPeople()[index].setName(nameField.getText());
			peopleLib.getPeople()[index].setAge(Integer.parseInt(ageField.getText()));
			messageBox("Person Updated");
		}
		if(buttonObj == removePersonButton) {
			peopleLib.removePerson(index);
			messageBox("Person removed, exiting display window");
			setVisible(false);
		}
		if(buttonObj == exitButton) {
			setVisible(false);
		}
	}

	public void initFrame(int index) {
		this.index = index;
		nameField.setText(peopleLib.getPeople()[index].getName());
		ageField.setText("" + peopleLib.getPeople()[index].getAge());
	}
}
