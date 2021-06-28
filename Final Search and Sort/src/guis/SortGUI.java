package guis;

import BreezySwing.*;
import javax.swing.*;
import objects.*;

@SuppressWarnings({"serial", "unused"})
public class SortGUI extends GBDialog {
	private ObjectLibrary objLib;
	private DisplayGUI displayGUI;
	private JLabel instructionsLabel = addLabel("Sort all lists by insertion or binary sort", 1,1,1,1);
	private JButton selectionSortEmployeesButton = addButton("Selection Sort Employees", 2,1,1,1);
	private JButton insertionSortEmployeesButton = addButton("Insertion Sort Employees", 2,2,1,1);
	private JButton selectionSortStudentsButton = addButton("Selection Sort Students", 3,1,1,1);
	private JButton insertionSortStudentsButton = addButton("Insertion Sort Students", 3,2,1,1);
	private JButton selectionSortWidgetsButton = addButton("Selection Sort Widgets", 4,1,1,1);
	private JButton insertionSortWidgetsButton = addButton("Insertion Sort Widgets", 4,2,1,1);
	private JButton exitButton = addButton("Exit", 5,1,1,1);
	
	public SortGUI(JFrame frm, ObjectLibrary objLib) {
		super(frm);
		this.objLib = objLib;
		displayGUI = new DisplayGUI(frm);
		setSize(500, 400);
		setTitle("Sort Window");
		setResizable(false);
	}
	
	public void buttonClicked(JButton buttonObj) {
		try {
			if(buttonObj == selectionSortEmployeesButton) {
				displayGUI.initList(SortSearch.selectionSort(objLib.getEmployees()));
				displayGUI.setVisible(true);
			}
			if(buttonObj == insertionSortEmployeesButton) {
				displayGUI.initList(SortSearch.insertionSort(objLib.getEmployees()));
				displayGUI.setVisible(true);
			}
			if(buttonObj == selectionSortStudentsButton) {
				displayGUI.initList(SortSearch.selectionSort(objLib.getStudents()));
				displayGUI.setVisible(true);
			}
			if(buttonObj == insertionSortStudentsButton) {
				displayGUI.initList(SortSearch.insertionSort(objLib.getStudents()));
				displayGUI.setVisible(true);
			}
			if(buttonObj == selectionSortWidgetsButton) {
				displayGUI.initList(SortSearch.selectionSort(objLib.getWidgets()));
				displayGUI.setVisible(true);
			}
			if(buttonObj == insertionSortWidgetsButton) {
				displayGUI.initList(SortSearch.insertionSort(objLib.getWidgets()));
				displayGUI.setVisible(true);
			}
		}
		catch(IndexOutOfBoundsException e) {
			messageBox("No items in array");
		}
		if(buttonObj == exitButton) {
			setVisible(false);
		}
	}
}