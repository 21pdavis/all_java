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

@SuppressWarnings({ "unused", "serial" })
public class MainGUI extends GBFrame{
	private static JFrame frm = new MainGUI();
	private MyLinkedList<String> nounList = new MyLinkedList<String>();
	private MyLinkedList<String> verbList = new MyLinkedList<String>();
	private MyLinkedList<String> sentenceList = new MyLinkedList<String>();
	private AddWordsGUI addWordsGUI = new AddWordsGUI(frm, nounList, verbList, sentenceList);
	private SentenceGUI sentenceGUI = new SentenceGUI(frm, nounList, verbList, sentenceList);
	private JLabel welcomeLabel = addLabel("Welcome to the Random Sentence Generator!", 1,1,1,1);
	private JButton wordButton = addButton("Add Words", 2,1,1,1);
	private JButton sentenceButton = addButton("Open Sentence Generator", 3,1,1,1);
	private JButton exitButton = addButton("Exit", 4,1,1,1);
	
	public void buttonClicked(JButton buttonObj) {
		if(buttonObj == wordButton) {
			addWordsGUI.resetFrame();
			addWordsGUI.setVisible(true);
		}
		
		if(buttonObj == sentenceButton) {
			MyIterator<String> it = nounList.iterator();
			it.add("D");
			MyLinkedList.printList(nounList);
			
			sentenceGUI.setVisible(true);
		}
		
		if(buttonObj == exitButton) {
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		frm.setVisible(true);
		frm.setSize(500, 600);
		frm.setTitle("Random Sentence Generator");
	}
}
