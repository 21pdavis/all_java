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
public class DisplayGUI extends GBDialog {
	private EditGUI editGUI;
	private MyDoublyLinkedList<CustomCharacter> charList;
	private MyListIterator<CustomCharacter> it;
	private Counter currentIndex;
	private Counter forwardBackward = new Counter(0);
	private CustomCharacter currentChar;
	private boolean backTwice = false;
	private JLabel prevCharLabel = addLabel("Previous Character:", 1, 1, 1, 1);
	private JLabel currentCharLabel = addLabel("Current Character:", 1, 2, 1, 1);
	private JLabel nextCharLabel = addLabel("Next Character:", 1, 3, 1, 1);
	private JList<String> prevCharList = addList(2, 1, 1, 1);
	private DefaultListModel<String> prevCharListModel = (DefaultListModel<String>) prevCharList.getModel();
	private JList<String> currentCharList = addList(2, 2, 1, 1);
	private DefaultListModel<String> currentCharListModel = (DefaultListModel<String>) currentCharList.getModel();
	private JList<String> nextCharList = addList(2, 3, 1, 1);
	private DefaultListModel<String> nextCharListModel = (DefaultListModel<String>) nextCharList.getModel();
	private JButton prevCharButton = addButton("Previous", 3, 1, 1, 1);
	private JButton nextCharButton = addButton("Next", 3, 3, 1, 1);
	private JButton editPrevCharButton = addButton("Edit Previous Character", 4, 1, 1, 1);
	private JButton editCurrentCharButton = addButton("Edit Current Character", 4, 2, 1, 1);
	private JButton editNextCharButton = addButton("Edit Next Character", 4, 3, 1, 1);
	private JButton exitButton = addButton("Exit", 5, 2, 1, 1);

	public DisplayGUI(JFrame frm, MyDoublyLinkedList<CustomCharacter> charList, Counter currentIndex) {
		super(frm);
		setTitle("Character Display");
		setSize(800, 500);
		this.charList = charList;
		this.currentIndex = currentIndex;
		editGUI = new EditGUI(frm, currentIndex, this, forwardBackward);
	}

	public void buttonClicked(JButton buttonObj) {
		if (buttonObj == prevCharButton) {
			if (it.hasPrev()) {
				currentIndex.decrement();
				initFrame();
			} else {
				messageBox("No Previous Character");
			}
		}
		if (buttonObj == nextCharButton) {
			if (it.hasNext()) {
				currentIndex.increment();
				initFrame();
			} else {
				messageBox("No Next Character");
			}
		}
		if (buttonObj == editPrevCharButton) {
			if (it.hasPrev()) {
				CustomCharacter prevChar = getPrevChar();
				forwardBackward.setVal(-1);
				editGUI.initFrame(prevChar);
				editGUI.setVisible(true);
			} else {
				messageBox("No Previous Character");
			}
		}
		if (buttonObj == editCurrentCharButton) {
			forwardBackward.setVal(0);
			editGUI.initFrame(currentChar);
			editGUI.setVisible(true);
		}
		if (buttonObj == editNextCharButton) {
			if (it.hasNext()) {
				CustomCharacter nextChar = getNextChar();
				forwardBackward.setVal(1);
				editGUI.initFrame(nextChar);
				editGUI.setVisible(true);
			} else {
				messageBox("No Next Character");
			}
		}
		if (buttonObj == exitButton) {
			setVisible(false);
		}
	}

	public void initFrame() {
		resetFrame();
		it = charList.listIterator();
		currentChar = getInitChar();

		populateList(currentCharListModel, currentChar);

		if (it.hasPrev()) {
			it.prev(); // move cursor
			populateList(prevCharListModel, it.prev());
			it.next();
			it.next();
		} else {
			prevCharListModel.addElement("No Previous Character");
		}

		if (it.hasNext()) {
			populateList(nextCharListModel, it.next());
			it.prev();
		} else {
			nextCharListModel.addElement("No Next Character");
		}
	}

	private void populateList(DefaultListModel<String> model, CustomCharacter character) {
		model.addElement("Name: " + character.getName());
		model.addElement("Role: " + character.getRole());
		model.addElement("Ability: " + character.getAbility());
		model.addElement("Weakness: " + character.getWeakness());
		model.addElement("Level " + character.getLevel());
	}

	private CustomCharacter getInitChar() {
		CustomCharacter initChar = null;

		for (int i = 0; i <= currentIndex.getVal(); i++) {
			initChar = it.next();
		}

		return initChar;
	}

	private CustomCharacter getCurrentChar() {
		CustomCharacter currentChar = null;

		if (it.hasNext() && it.hasPrev() || it.hasPrev() && it.hasNext() == false) {
			it.prev();
			currentChar = it.next();
		} else if (it.hasPrev() == false && it.hasNext()) {
			it.next();
			currentChar = it.prev();
		}

		return currentChar;
	}

	private CustomCharacter getPrevChar() {
		CustomCharacter prevChar = null;

		it.prev();
		prevChar = it.prev();

		return prevChar;
	}

	private CustomCharacter getNextChar() {
		CustomCharacter nextChar = null;

		if (backTwice == true) {
			it.next();
			nextChar = it.next();
		} else {
			nextChar = it.next();
		}
		backTwice = false;

		return nextChar;
	}

	private void resetFrame() {
		prevCharListModel.clear();
		currentCharListModel.clear();
		nextCharListModel.clear();
	}
}
