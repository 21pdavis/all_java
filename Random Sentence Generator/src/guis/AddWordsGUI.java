package guis;

/*
 * Paul Davis
 * 11/6/2020
 * Random Sentence Generator Program
 * This program takes in however many verbs and nouns that the user enters and generates a grammatically random sentence from those words
 */

import BreezySwing.*;
import objects.*;
import javax.swing.*;

@SuppressWarnings({"serial", "unused"})
public class AddWordsGUI extends GBDialog{
	private MyLinkedList<String> nounList;
	private MyLinkedList<String> verbList;
	private MyLinkedList<String> sentenceList;
	private JLabel welcomeLabel = addLabel("Double click a list item to remove it", 1,1,1,1);
	private JLabel nounLabel = addLabel("Enter a Noun:", 2,1,1,1);
	private JTextField nounField = addTextField("", 3,1,1,1);
	private JButton nounButton = addButton("Add Noun", 4,1,1,1);
	private JList<String> existingNounsList = addList(5,1,1,1);
	private DefaultListModel<String> existingNounsModel = (DefaultListModel<String>) existingNounsList.getModel();
	private JLabel verbLabel = addLabel("Enter a Verb (past or present tense, not infinitive):", 6,1,1,1);
	private JTextField verbField = addTextField("", 7,1,1,1);
	private JButton verbButton = addButton("Add Verb", 8,1,1,1);
	private JList<String> existingVerbsList = addList(9,1,1,1);
	private DefaultListModel<String> existingVerbsModel = (DefaultListModel<String>) existingVerbsList.getModel();
	private JButton exitButton = addButton("Exit", 10,1,1,1);
	
	public AddWordsGUI(JFrame frm, MyLinkedList<String> nounList, MyLinkedList<String> verbList, MyLinkedList<String> sentenceList) {
		super(frm);
		setSize(500, 600);
		setTitle("Add Words");
		this.nounList = nounList;
		this.verbList = verbList;
		this.sentenceList = sentenceList;
	}
	
	public void buttonClicked(JButton buttonObj) {
		if(buttonObj == nounButton) {
			if(isValidInput(nounField.getText()))
				addNoun(nounField.getText());
			else if(nounField.getText().matches(".*\\d.*")) {
				messageBox("Noun input contains numbers");
				nounField.setText("");
			}
			else if(nounField.getText().isEmpty()) {
				messageBox("Noun field is empty");
			}
		}
		if(buttonObj == verbButton) {
			if(isValidInput(verbField.getText()))
				addVerb(verbField.getText());
			else if(verbField.getText().matches(".*\\d.*")) {
				messageBox("Verb input contains numbers");
				verbField.setText("");
			}
			else if(nounField.getText().isEmpty()) {
				messageBox("Verb field is empty");
			}
		}
		if(buttonObj == exitButton) {
			setVisible(false);
		}
	}
	
	public void listDoubleClicked(JList listObj, String itemClicked) {
		if(listObj.equals(existingNounsList)) {
			removeNoun(listObj.getSelectedIndex());
		}
		if(listObj.equals(existingVerbsList)) {
			removeVerb(listObj.getSelectedIndex());
		}
	}
	
	private void addNoun(String noun) {
		boolean nounExists = false;
		MyIterator<String> it = nounList.iterator();
		
		while(it.hasNext()) {
			if(it.next().equals(noun)) {
				nounExists = true;
			}
		}
		
		if(nounExists == false) {
			MyLinkedList.insert(nounList, nounField.getText());
			populateNounList();
		}
		else {
			messageBox("Noun already exists");
		}
		
		nounField.setText("");
	}
	
	private void addVerb(String verb) {
		boolean verbExists = false;
		MyIterator<String> it = verbList.iterator();
		
		while(it.hasNext()) {
			if(it.next().equals(verb)) {
				verbExists = true;
			}
		}
		
		if(verbExists == false) {
			MyLinkedList.insert(verbList, verbField.getText());
			populateVerbList();
		}
		else {
			messageBox("Verb already exists");
		}
		
		verbField.setText("");
	}

	private void removeNoun(int index) {
		MyIterator<String> it = nounList.iterator();
		
		for(int i = 0; i <= index; i++) {
			it.next();
		}
		it.remove();
		populateNounList();
	}
	
	private void removeVerb(int index) {
		MyIterator<String> it = verbList.iterator();
		
		for(int i = 0; i <= index; i++) {
			it.next();
		}
		it.remove();
		populateNounList();		
	}
	
	private void populateNounList() {
		existingNounsModel.clear();
		if(MyLinkedList.staticGetSize(nounList) != 0) {
			MyIterator<String> it = nounList.iterator();
			while(it.hasNext()) {
				existingNounsModel.addElement(it.next());
			}
		}
	}
	
	private void populateVerbList() {
		existingVerbsModel.clear();
		MyIterator<String> it = verbList.iterator();
		while(it.hasNext()) {
			existingVerbsModel.addElement(it.next());
		}
	}
	
	private boolean isValidInput(String s) {
		if(s.matches(".*\\d.*") == false && !s.isEmpty()) 
			return true;
		return false;
	}
	
	public void resetFrame() {
		nounField.setText("");
		verbField.setText("");
	}

}
