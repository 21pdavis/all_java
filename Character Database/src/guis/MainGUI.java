package guis;

/*
 * Paul Davis
 * 12/4/2020
 * Character Database Program
 * Takes in as many characters as the user inputs, then displays the characters in three lists: previous, current, and next characters
 */

import BreezySwing.*;
import javax.swing.*;
import objects.*;

@SuppressWarnings({ "serial", "unused" })
public class MainGUI extends GBFrame {
	private static JFrame frm = new MainGUI();
	private Counter currentIndex = new Counter(-1);
	private MyDoublyLinkedList<CustomCharacter> charList = new MyDoublyLinkedList<CustomCharacter>();
	private AddCharacterGUI addCharacterGUI = new AddCharacterGUI(frm, charList, currentIndex);
	private DisplayGUI displayGUI = new DisplayGUI(frm, charList, currentIndex);
	private JLabel welcomeLabel = addLabel("Welcome to the Character Database!", 1, 1, 1, 1);
	private JButton addCharacterButton = addButton("Add Character", 2, 1, 1, 1);
	private JButton displayButton = addButton("Character List", 3, 1, 1, 1);
	private JButton resetButton = addButton("Reset", 4, 1, 1, 1);
	private JButton exitButton = addButton("Exit", 4, 2, 1, 1);

	public void buttonClicked(JButton buttonObj) {
		if (buttonObj == addCharacterButton) {
			addCharacterGUI.resetFrame();
			addCharacterGUI.setVisible(true);
		}

		if (buttonObj == displayButton) {
			if (charList.getSize() >= 2) {
				displayGUI.initFrame();
				displayGUI.setVisible(true);
			} else
				messageBox("Create at least two characters");
		}

		if (buttonObj == resetButton) {
			if(charList.getSize() > 0) {
				charList.clear();
				messageBox("Database Reset");
			}
			else {
				messageBox("No Characters in Database");
			}
		}

		if (buttonObj == exitButton) {
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		frm.setTitle("Character Database");
		frm.setSize(400, 500);
		frm.setResizable(false);
		frm.setVisible(true);
	}
}
