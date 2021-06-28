package guis;

import java.util.Collections;

import javax.swing.*;
import objects.*;
import BreezySwing.*;

@SuppressWarnings({"serial", "unused"})
public class SearchGUI extends GBDialog{
	private PeopleLib peopleLib;
	private EditGUI editGUI;
	private int checkCount = 0;
	private JLabel nameInputLabel = addLabel("Name: ", 1,1,1,1);
	private JTextField nameInputField = addTextField("", 1,2,1,1);
	private JButton sequentialSearchButton = addButton("Search Sequentially", 2,1,1,1);
	private JButton binarySearchButton = addButton("Search Binarily", 2,2,1,1);
	private JButton exitButton = addButton("Exit", 3,1,1,1);
	
	public SearchGUI(JFrame frm, PeopleLib peopleLib) {
		super(frm);
		this.peopleLib = peopleLib;
		editGUI = new EditGUI(frm, peopleLib);
		setSize(400, 300);
		setResizable(false);
		setTitle("Search for a person");
	}
	
	public void buttonClicked(JButton buttonObj) {
		if(buttonObj == sequentialSearchButton) {
			if(nameInputField.getText().matches(".*\\d.*") == false) {
				try {
					editGUI.initFrame(sequentialSearch(nameInputField.getText()));
					messageBox("Person Found in " + (checkCount) + " check(s)");
					editGUI.setVisible(true);
				}
				catch(ArrayIndexOutOfBoundsException e) {
					if(checkCount != 0)
						messageBox("Person not found after " + (checkCount) + " check(s)");
					else 
						messageBox("There are no people in the array");
				}
				checkCount = 0;
			}
			else {
				messageBox("Do not include numbers in the name input");
			}
		}
		if(buttonObj == binarySearchButton) {
			boolean errorFound = false;
			if(nameInputField.getText().matches(".*\\d.*") == false) {
				try {
					editGUI.initFrame(binarySearch(nameInputField.getText()));
					messageBox("Person Found in " + (checkCount) + " check(s)");
					editGUI.setVisible(true);
				}
				catch(ArrayIndexOutOfBoundsException e) {
					if(checkCount > 0) {
						messageBox("Person not found after " + (checkCount) + " check(s)");
					}
					errorFound = true;
				}
				catch(NullPointerException e) {
					messageBox("There are no people in the array");
					errorFound = true;
				}
				if(checkCount == 0 && errorFound == false) {
					messageBox("There are no people in the array");
				}
				checkCount = 0;
			}
			else
				messageBox("Do not include numbers in the name input");
		}
		if(buttonObj == exitButton) {
			setVisible(false);
		}
	}
	
	public int sequentialSearch(String name) { // done using unsorted list	
		for(int i = 0; i < peopleLib.getPeople().length; i++) {
			checkCount++;
			if(peopleLib.getPeople()[i].getName().equals(name)) {
				return i;
			}
		}
		return -1;	
	}
	
	public int binarySearch(String name) { // done using sorted list
		int uBound = peopleLib.getSortedPeople().length - 1, lBound = 0;
		while(lBound <= uBound) {
			int midIndex = (lBound + uBound) / 2;
			
			checkCount++;
			if(peopleLib.getSortedPeople()[midIndex].getName().equals(name)) {
				return midIndex;
			}
			
			if(peopleLib.getSortedPeople()[midIndex].getName().compareTo(name) < 0) {
				lBound = midIndex + 1;
			}
			else{
				uBound = midIndex - 1;
			}
		}
		return -1;
	}
	
	public void resetFrame() {
		checkCount = 0;
		nameInputField.setText("");
	}
}