package sequence;

import java.util.Arrays;

import javax.swing.*;
import BreezySwing.*;

public class SequenceGUI extends GBFrame {
	SequenceServer server = new SequenceServer();
	private int sequenceCount = 0; // remember to revalidate when you want it to change
	JLabel inputLabel = addLabel("Enter Value " + sequenceCount + ":", 1,1,1,1);
	JTextField inputField = addTextField("", 1,2,1,1);
	JButton inputButton = addButton("Input", 2,1,1,1);
	JButton outputButton = addButton("Output", 2,2,1,1);
	JButton exitButton = addButton("Exit", 3,1,1,1);
	JButton resetButton = addButton("Reset", 3,2,1,1);
	private int[] sequence = new int[25];
	
	public SequenceGUI() {
		outputButton.setEnabled(false);
	}
	
	public void buttonClicked(JButton buttonObj) {
		if(buttonObj == inputButton) {
			inputSequenceValue();
		}
		if(buttonObj == outputButton) {
			messageBox(server.findSequences(sequence, sequenceCount));
		}
		if(buttonObj == exitButton) {
			System.exit(0);
		}
		if(buttonObj == resetButton) {
			resetProgram();
		}
	}
	
	public static void main(String[] args) {
		JFrame frm = new SequenceGUI();
		frm.setTitle("Longest Non-Decreasing Sequence");
		frm.setSize(600, 400);
		frm.setVisible(true);
	}
	
	public void inputSequenceValue() {
		try {
			sequence[sequenceCount] = Integer.parseInt(inputField.getText());
			if(sequenceCount == 0)
				outputButton.setEnabled(true);
			inputField.setText("");
			inputField.requestFocusInWindow();
			sequenceCount++;
			revalidate();
		}
		catch(NumberFormatException e) {
			messageBox("Input a valid integer number, please");
			inputField.setText("");
		}
	}

	public void resetProgram() {
		for(int i = 0; i < sequenceCount; i++) {
			sequence[i] = 0;
		}
		sequenceCount = 0;
		inputField.setText("");
		outputButton.setEnabled(false);
	}
}
