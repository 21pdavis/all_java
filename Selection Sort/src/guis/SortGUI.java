package guis;

import BreezySwing.*;
import objects.*;
import java.util.ArrayList;
import javax.swing.*;

@SuppressWarnings({ "serial", "unused" })
public class SortGUI extends GBDialog {
	private AllStudents allStudents;
	private JLabel instructionsLabel = addLabel("Use this window to sort the students you have created", 1, 1, 1, 1);
	private JButton nameSortButton = addButton("Sort By Name", 2, 1, 1, 1);
	private JButton gradeSortButton = addButton("Sort By Grade", 3, 1, 1, 1);
	private JList<String> list = addList(4, 1, 1, 1);
	private DefaultListModel<String> model = (DefaultListModel<String>) list.getModel();
	private JButton exitButton = addButton("Exit", 5, 1, 1, 1);
	private JButton resetButton = addButton("Reset", 5, 2, 1, 1);

	public SortGUI(JFrame frm, AllStudents allStudents) {
		super(frm);
		this.allStudents = allStudents;
		setSize(500, 300);
		setTitle("Sort Students");
	}

	public void buttonClicked(JButton buttonObj) {
		if (buttonObj == nameSortButton) {
			if (allStudents.getAllStudents().size() > 0) {
				populateNameList();
			} else if (allStudents.getAllStudents().size() <= 0)
				messageBox("Please input a student first");
		}
		if (buttonObj == gradeSortButton) {
			if (allStudents.getAllStudents().size() > 0) {
				populateGradeList();
			} else if (allStudents.getAllStudents().size() <= 0)
				messageBox("Please input a student first");
		}
		if (buttonObj == exitButton) {
			setVisible(false);
		}
		if (buttonObj == resetButton) {
			resetFrame();
		}
	}

	private void populateNameList() {
		model.clear();
		for (int i = 0; i < allStudents.getNameSortedStudents().size(); i++) {
			model.addElement(allStudents.getNameSortedStudents().get(i).toString());
		}
	}

	private void populateGradeList() {
		model.clear();
		for (int i = 0; i < allStudents.getGradeSortedStudents().size(); i++) {
			model.addElement(allStudents.getGradeSortedStudents().get(i).toString());
		}
	}

	public void resetFrame() {
		model.clear();
	}
}