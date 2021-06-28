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
import java.util.Random;

@SuppressWarnings({ "unused", "serial" })
public class SentenceGUI extends GBDialog{
	private MyLinkedList<String> nounList;
	private MyLinkedList<String> verbList;
	private MyLinkedList<String> sentenceList;
	private JLabel welcomeLabel = addLabel("Generate Sentences (Double Click to remove a sentence", 1,1,1,1);
	private JButton generateButton = addButton("Generate a Sentence", 2,1,1,1);
	private JList<String> existingSentenceList = addList(3,1,1,1);
	private DefaultListModel<String> existingSentenceListModel = (DefaultListModel<String>) existingSentenceList.getModel();
	private JButton exitButton = addButton("Exit", 4,1,1,1);

	public SentenceGUI(JFrame frm, MyLinkedList<String> nounList, MyLinkedList<String> verbList, MyLinkedList<String> sentenceList) {
		super(frm);
		setSize(600, 500);
		setTitle("Generate Sentences");
		this.nounList = nounList;
		this.verbList = verbList;
		this.sentenceList = sentenceList;
	}
	
	public void buttonClicked(JButton buttonObj) {
		if(buttonObj == generateButton) {
			try { // the if statement here is included in the try catch to accommodate variable scope, not to check the if statement
				String sentence = generateSentence();
				Comparable c = "ABC";
				Comparable b = "DEF";
				b.compareTo(c);
				
				if(!(sentence.equals("")))
					messageBox(sentence);
				else {
					messageBox("Generator failed to generate a new sentence after 10 attempts." + '\n' + "Try again or add more words.");
				}
			}
			catch(IllegalArgumentException e) {
				messageBox("No Items in List");
			}
			
			
		}
		if(buttonObj == exitButton) {
			setVisible(false);
		}
	}
	
	public void listDoubleClicked(JList listObj, String itemClicked) {
		if(listObj == existingSentenceList) {
			removeSentence(listObj.getSelectedIndex());
		}
	}
	
	private String generateSentence() {
		boolean sentenceExists = false;
		String sentence = "";
		Random rand = new Random();
		int count = 0;
		
		do {
			MyIterator<String> it = sentenceList.iterator();
			String[] nounArray = generateNouns(rand);
			String verb = generateVerb(rand);
			sentence = "The " + nounArray[0] + " " + verb + " the " + nounArray[1] + " with a " + nounArray[2];
			
			while(it.hasNext()) {
				if(it.next().equals(sentence)) {
					sentence = "";
					sentenceExists = true;
					break;
				}
			}
			
			if(sentenceExists == false && !(sentence.equals(""))) {
				MyLinkedList.insert(sentenceList, sentence);
				populateSentenceList();
				break;
			}
			
			count++;
		}while(sentenceExists == true && count < 10); // I found only five attempts to be too restricting for my sentence format, so I upped it a little
		
		return sentence;
	}
	
	private void removeSentence(int index) {
		MyIterator<String> it = sentenceList.iterator();
		
		for(int i = 0; i <= index; i++) {
			it.next();
		}
		it.remove();
		populateSentenceList();		
	}
	
	private String[] generateNouns(Random rand) {
		String[] nounArray = new String[3];
		
		for(int i = 0; i < 3; i++) {
			int index = rand.nextInt(MyLinkedList.staticGetSize(nounList));
			MyIterator<String> it = nounList.iterator();
			for(int j = 0; j < index; j++) {
				it.next();
			}
			nounArray[i] = it.next();
		}
		
		return nounArray;
	}
	
	private String generateVerb(Random rand) {
		MyIterator<String> it = verbList.iterator();
		int index = rand.nextInt(MyLinkedList.staticGetSize(verbList));
		
		for(int i = 0; i < index; i++) {
			it.next();
		}
		
		return it.next();
	}
	
	private void populateSentenceList() {
		existingSentenceListModel.clear();
		MyIterator<String> it = sentenceList.iterator();
		
		while(it.hasNext()) {
			existingSentenceListModel.addElement(it.next());
		}
	}
}
