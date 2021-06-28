package guis;

import BreezySwing.*;
import javax.swing.*;
import objects.*;

@SuppressWarnings({"serial", "unused"})
public class EmployeeSearchGUI extends GBDialog{
	private DisplayGUI displayGUI;
	private ObjectLibrary objLib;
	private JLabel instructionsLabel = addLabel("Search for an Employee:", 1,1,1,1);
	private JLabel salaryLabel = addLabel("Salary:", 2,1,1,1);
	private JTextField salaryField = addTextField("", 2,2,1,1);
	private JButton sequentialSearchButton = addButton("Sequential Search", 3,1,1,1);
	private JButton binarySearchButton = addButton("Binary Search", 3,2,1,1);
	private JButton exitButton = addButton("Exit", 4,1,1,1);
	
	public void buttonClicked(JButton buttonObj) {
		try {
			if(buttonObj == sequentialSearchButton) {
				displayGUI.initList(SortSearch.sequentialSearch(SortSearch.selectionSort(objLib.getEmployees()), new Employee("", Double.parseDouble(salaryField.getText()))));
				displayGUI.setVisible(true);
			}
			if(buttonObj == binarySearchButton) {
				displayGUI.initList(SortSearch.binarySearch(SortSearch.selectionSort(objLib.getEmployees()), new Employee("", Double.parseDouble(salaryField.getText()))));
				displayGUI.setVisible(true);
			}
		}
		catch(IndexOutOfBoundsException e) {
			messageBox("No items in array or no matches");
			resetFrame();
		}
		catch(NumberFormatException e) {
			messageBox("Input only numbers");
			resetFrame();
		}
		if(buttonObj == exitButton) {
			setVisible(false);
		}
	}
	
	public EmployeeSearchGUI(JFrame frm, ObjectLibrary objLib) {
		super(frm);
		this.objLib = objLib;
		displayGUI = new DisplayGUI(frm);
	}
	
	public void resetFrame() {
		salaryField.setText("");
	}
}