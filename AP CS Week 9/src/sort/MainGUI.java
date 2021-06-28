package sort;
/*
 * Paul Davis
 * Recursive Merge Sort/Binary Search Program
 * User inputs array of ints, program can sort or search for values
 */
import BreezySwing.*;
import javax.swing.*;

public class MainGUI extends GBFrame{
	private static JFrame frm = new MainGUI();
	private int[] nums;
	private JLabel numLabel = addLabel("Up to 10 Numbers (Separate with Comma and a Space):", 1,1,1,1);
	private JTextField numsField = addTextField("", 1,2,1,1);
	private JButton numButton = addButton("Input Numbers", 2,1,1,1);
	private JLabel searchLabel = addLabel("Search for a number to get its index: ", 3,1,1,1);
	private JTextField searchField = addTextField("", 3,2,1,1);
	private JButton searchButton = addButton("Search", 4,1,1,1);
	private JButton sortButton = addButton("Sort Array", 5,1,1,1);
	
	public void buttonClicked(JButton buttonObj) {
		if(buttonObj == numButton) {
			getInput();
		}
		if(buttonObj == searchButton) {
			search();
		}
		if(buttonObj == sortButton) {
			sortArray();
		}
	}
	
	private void getInput() {
		boolean errorFound = false;
		
		try {
			if(Server.getArray(numsField.getText()).length <= 10) {
				nums = Server.getArray(numsField.getText());
			}
		}
		catch(NumberFormatException e) {
			messageBox("Error in input:" + '\n' + "Separate numbers with a comma then a" + '\n' + "space and only input numbers");
			numsField.setText("");
			errorFound = true;
		}

		if(errorFound == false) {
			messageBox("Array Input");
			numsField.setText("");
		}
	}
	
	private void search() {
		boolean errorFound = false;
		int key = 0;
		int index = 0;
		
		try {
			key = Integer.parseInt(searchField.getText());
			System.out.println(nums.length - 1);
			index = Server.binarySearch(nums, 0, nums.length - 1, key);
		}
		catch(NumberFormatException e) {
			messageBox("Error in Input");
			searchField.setText("");
			errorFound = true;
		}
		catch(NullPointerException e) {
			messageBox("No items present in array");
			searchField.setText("");
			errorFound = true;
		}
		
		if(errorFound == false) {
			messageBox("The index of the number " + key + " is " + index);
			searchField.setText("");
		}
	}
	
	private void sortArray() {
		boolean errorFound = false;
		int[] sortedArray;
		String outputString = "Sorted Array:";
		
		try {
			sortedArray = Server.sort(nums, 0, nums.length - 1);
			for(int i = 0; i < sortedArray.length; i++) {
				if(i != sortedArray.length - 1)
					outputString += " " + sortedArray[i] + ",";
				else
					outputString += " " + sortedArray[i];
			}
		}
		catch(NullPointerException e) {
			messageBox("No items present in array");
			errorFound = true;
		}
		
		if(errorFound == false)
			messageBox(outputString);
	}
	
	public static void main(String[] args) {
		frm.setVisible(true);
		frm.setTitle("Recursive Merge Sort");
		frm.setResizable(false);
		frm.setSize(700, 300);
	}
}
