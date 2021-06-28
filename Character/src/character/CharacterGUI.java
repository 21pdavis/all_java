package character;

import java.awt.Font;

import javax.swing.*;
import BreezySwing.*;


public class CharacterGUI extends GBFrame {
	JLabel instruction = addLabel("Enter your sentence here: ", 1,1,1,1);
	JTextField input = addTextField("", 1,2,1,1);
	JButton output = addButton("Output", 2,1,1,1);
	JButton exit = addButton("Exit", 3,1,1,1);
	Sentence sentence = new Sentence();
	
//	public CharacterGUI() {
//		instruction.setFont(instruction.getFont().deriveFont(Font.BOLD, 14f));
//	}
	
	public void buttonClicked(JButton buttonObj) {
		if(buttonObj == output) {
			try {
				sentence.setSentence(input.getText());
			}
			catch(Exception e) {
				messageBox("Error: " + e.getMessage());
			}
			try {
				sentence.findWords();
			}
			catch(Exception e) {
				messageBox("Error: " + e.getMessage());
			}
			messageBox(sentence.toString());
		}
		if(buttonObj == exit)
			System.exit(0);
	}
	
	public static void main(String[] args) {
		JFrame frm = new CharacterGUI();
		frm.setTitle("Character Program");
		frm.setSize(600, 400);
		frm.setVisible(true);
	}
}
