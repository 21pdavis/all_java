package guis;

import BreezySwing.*;
import objects.*;
import javax.swing.*;

@SuppressWarnings({"serial", "unused"})
public class MainGUI extends GBFrame{
	private static JFrame frm = new MainGUI();
	private PeopleLib peopleLib = new PeopleLib();
	private AddPersonGUI addPersonGUI = new AddPersonGUI(frm, peopleLib);
	private SearchGUI searchGUI = new SearchGUI(frm, peopleLib);
	private JButton openAddPersonWindowButton = addButton("Add Person", 1,1,1,1);
	private JButton openSearchWindowButton = addButton("Open Search Window", 1,2,1,1);
	private JButton displayPeopleButton = addButton("Display People", 2,1,1,1);
	private JList<String> list = addList(3,1,2,1);
	private DefaultListModel<String> model = (DefaultListModel<String>)list.getModel();
	private JButton exitButton = addButton("Exit", 4,1,1,1);
	
	public void buttonClicked(JButton buttonObj) {
		if(buttonObj == openAddPersonWindowButton) {
			addPersonGUI.resetFrame();
			addPersonGUI.setVisible(true);
		}
		if(buttonObj == openSearchWindowButton) {
			searchGUI.resetFrame();
			searchGUI.setVisible(true);
		}
		if(buttonObj == displayPeopleButton) {
			boolean errorFound = false;
			model.clear();
			try {
				for(int i = 0; i < peopleLib.getSortedPeople().length; i++) {
					model.addElement(peopleLib.getSortedPeople()[i].toString());
				}
			}
			catch(NullPointerException e) {
				messageBox("There are no people in the array");
				errorFound = true;
			}
			if(errorFound == false && model.isEmpty()) {
				messageBox("There are no people in the array");
			}
		}
		if(buttonObj == exitButton) {
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		frm.setTitle("People Search Program");
		frm.setSize(400,500);
		frm.setResizable(false);
		frm.setVisible(true);
	}
}