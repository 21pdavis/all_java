package quicksort;

import javax.swing.*;
import BreezySwing.*;
import java.util.ArrayList;

public class MainGUI extends GBFrame{
	private static JFrame frm = new MainGUI();
	private ArrayList<Integer> unsortedNums;
	private ArrayList<Integer> sortedNums;
	private JLabel instructionsLabel = addLabel("Input your array of numbers and then sort them with this program", 1,1,1,1);
	private JLabel inputLabel = addLabel("Number array:", 2,1,1,1);
	private JTextField numsField = addTextField("", 2,2,1,1);
	private JButton inputButton = addButton("Input Array", 3,1,1,1);
	private JButton unsortedOutputButton = addButton("Output Unsorted Data", 4,1,1,1);
	private JButton sortButton = addButton("Output Sorted Data", 5,1,1,1);
	
	public void buttonClicked(JButton buttonObj) {
		if(buttonObj == inputButton) {
			initArrayLists(numsField.getText());
		}
		
		if(buttonObj == unsortedOutputButton) {
			outputUnsorted();
		}
		
		if (buttonObj == sortButton) {
			outputSorted();
		}
	}
	
	private void initArrayLists(String input) {
		boolean errorFound = false;
		
		try {
			unsortedNums = new ArrayList<Integer>(Server.getArray(input));
			sortedNums = new ArrayList<Integer>(Server.getArray(input));
		}
		catch(NullPointerException e) {
			messageBox("Enter only 10 values");
			numsField.setText("");
			errorFound = true;
		}
		catch(NumberFormatException e) {
			messageBox("Empty or Incorrect Input" + '\n' + "Separate numbers with comma and space");
			numsField.setText("");
			errorFound = true;
		}
		
		if(errorFound == false) 
			messageBox("Data Input");
	}
	
	private void outputUnsorted() {
		boolean errorFound = false;
		String outputString = "Unsorted Data: ";
		
		try {
			for(int i = 0; i < unsortedNums.size(); i++) {
				if(i == unsortedNums.size() - 1) {
					outputString += unsortedNums.get(i);
				}
				else {
					outputString += unsortedNums.get(i) + ", ";
				}
			}
		}
		catch(NullPointerException e) {
			messageBox("No Data in List");
			errorFound = true;
		}
		
		if(errorFound == false)
			messageBox(outputString);
	}
	
	private void outputSorted() {
		boolean errorFound = false;
		String outputString = "Sorted Data: ";
		
		try {
			Server.sort(sortedNums, 0, sortedNums.size() - 1);
			
			for (int i = 0; i < sortedNums.size(); i++) {
				if (i == sortedNums.size() - 1) {
					outputString += sortedNums.get(i);
				} 
				else {
					outputString += sortedNums.get(i) + ", ";
				}
			}
		}
		catch(NullPointerException e) {
			messageBox("No Data in List");
			errorFound = true;
		}
		
		if(errorFound == false)
			messageBox(outputString);
	}
	
	public static void main(String[] args) {
		frm.setVisible(true);
		frm.setSize(700, 500);
		frm.setResizable(false);
		frm.setTitle("Quick Sort Program");
	}
}
