package guis;

import BreezySwing.*;
import javax.swing.*;
import objects.ObjectLibrary;

@SuppressWarnings({"serial", "unused"})
public class MainGUI extends GBFrame{
	private static JFrame frm = new MainGUI();
	private ObjectLibrary objLib = new ObjectLibrary();
	private AddEmployeeGUI addEmployeeGUI = new AddEmployeeGUI(frm, objLib);
	private AddStudentGUI addStudentGUI = new AddStudentGUI(frm, objLib);
	private AddWidgetGUI addWidgetGUI = new AddWidgetGUI(frm, objLib);
	private SortGUI sortGUI = new SortGUI(frm, objLib);
	private EmployeeSearchGUI employeeSearchGUI = new EmployeeSearchGUI(frm, objLib);
	private StudentSearchGUI studentSearchGUI = new StudentSearchGUI(frm, objLib);
	private WidgetSearchGUI widgetSearchGUI = new WidgetSearchGUI(frm, objLib);
	private JLabel addLabel = addLabel("Add Items:", 1,1,1,1);
	private JButton addEmployeeButton = addButton("Add Employee", 1,2,1,1);
	private JButton addStudentButton = addButton("Add Student", 1,3,1,1);
	private JButton addWidgetButton = addButton("Add Widget", 1,4,1,1);
	private JLabel searchLabel = addLabel("Search Items:", 2,1,1,1);
	private JButton employeeSearchButton = addButton("Search Employees", 2,2,1,1);
	private JButton studentSearchButton = addButton("Search Students", 2,3,1,1);
	private JButton widgetSearchButton = addButton("Search Widgets", 2,4,1,1);
	private JLabel sortLabel = addLabel("Sort Items:", 3,1,1,1);
	private JButton sortButton = addButton("Sorting Window", 3,2,1,1);
	private JButton exitButton = addButton("Exit", 4,4,1,1);
	
	public void buttonClicked(JButton buttonObj) {
		if(buttonObj == addEmployeeButton) {
			addEmployeeGUI.resetFrame();
			addEmployeeGUI.setVisible(true);
		}
		if(buttonObj == addStudentButton) {
			addStudentGUI.resetFrame();
			addStudentGUI.setVisible(true);
		}
		if(buttonObj == addWidgetButton) {
			addWidgetGUI.resetFrame();
			addWidgetGUI.setVisible(true);
		}
		if(buttonObj == employeeSearchButton) {
			employeeSearchGUI.resetFrame();
			employeeSearchGUI.setVisible(true);
		}
		if(buttonObj == studentSearchButton) {
			studentSearchGUI.resetFrame();
			studentSearchGUI.setVisible(true);
		}
		if(buttonObj == widgetSearchButton) {
			widgetSearchGUI.resetFrame();
			widgetSearchGUI.setVisible(true);
		}
		if(buttonObj == sortButton) {
			sortGUI.setVisible(true);
		}
		if(buttonObj == exitButton) {
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		frm.setVisible(true);
		frm.setSize(700, 300);
		frm.setResizable(false);
		frm.setTitle("Search and Sort");
	}
}