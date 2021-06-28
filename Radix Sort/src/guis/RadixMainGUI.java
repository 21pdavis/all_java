package guis;

/*
 * Paul Davis
 * 2/5/2021
 * Radix Sort Program
 * This program takes in a list of integers and sorts them using radix sort and an array of queues
 */

import java.util.ArrayList;
import structures.Sorter;
import javax.swing.*;
import BreezySwing.*;

@SuppressWarnings({ "serial", "unused" })
public class RadixMainGUI extends GBFrame {
	private static JFrame frm = new RadixMainGUI();
	private ArrayList<String> unsortedList = new ArrayList<String>();
	private JLabel inputLabel = addLabel("Number:", 1, 1, 1, 1);
	private JTextField inputField = addTextField("", 1, 2, 1, 1);
	private JButton inputButton = addButton("Add Number", 2, 1, 1, 1);
	private JLabel inputFeedbackLabel = addLabel("", 2, 2, 1, 1);
	private JButton sortButton = addButton("Sort Numbers", 3, 1, 1, 1);
	private JButton resetButton = addButton("Reset List", 4, 1, 1, 1);
	private JButton exitButton = addButton("Exit", 4, 2, 1, 1);

	public void buttonClicked(JButton buttonObj) {
		if (buttonObj == inputButton) {
			boolean isValid = isValidNumInput(inputField.getText());

			if (isValid) {
				unsortedList.add(inputField.getText());
				inputFeedbackLabel.setText("Number Successfully Input");
				inputField.setText("");
			} else if (!inputField.getText().matches("[0-9]+")) {
				messageBox("Input can only contain digits");
				inputFeedbackLabel.setText("");
				inputField.setText("");
			} else if (inputField.getText().isEmpty()) {
				messageBox("Input Field is empty.");
				inputFeedbackLabel.setText("");
				inputField.setText("");
			}
		}

		if (buttonObj == sortButton) {
			try {
				if (!unsortedList.isEmpty()) {
					messageBox("Sorted List: " + Sorter.radixSortList(unsortedList).toString());
				} else if (unsortedList.isEmpty()) {
					messageBox("Number List Is Empty");
					inputFeedbackLabel.setText("");
					inputField.setText("");
				}
			} catch (NumberFormatException e) {
				messageBox("Some value in list too large, clearing list");
				inputFeedbackLabel.setText("");
				inputField.setText("");
				unsortedList.clear();
			}
		}

		if (buttonObj == resetButton) {
			unsortedList.clear();
			messageBox("List Reset");
		}

		if (buttonObj == exitButton) {
			System.exit(0);
		}
	}

	private boolean isValidNumInput(String input) {
		if (!input.isEmpty() && input.matches("[0-9]+")) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		frm.setTitle("Radix Sort");
		frm.setSize(300, 400);
		frm.setResizable(false);
		frm.setVisible(true);
	}
}
