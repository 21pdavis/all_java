package guis;

/*
 * Paul Davis
 * 12/22/2020
 * Postfix Evaluator Expression
 * This program gets a postfix mathemetical expression as input and returns its double value sum, product, difference, or quotient
 */

import BreezySwing.*;
import java.util.NoSuchElementException;
import javax.swing.*;
import structures.*;

@SuppressWarnings({"serial", "unused"})
public class PostfixMainGUI extends GBFrame {
	private static JFrame frm = new PostfixMainGUI();
	private JLabel inputLabel = addLabel("Postfix Expression", 1,1,1,1);
	private JTextField inputField = addTextField("", 1,2,1,1);
	private JButton calculateButton = addButton("Calculate", 2,1,1,1);
	private JButton exitButton = addButton("Exit", 3,1,1,1);
	
	public void buttonClicked(JButton buttonObj) {
		if(buttonObj == calculateButton) {
			try {
				messageBox(PostfixEvaluator.evaluate(inputField.getText().trim()));
				inputField.setText("");
			} catch (TooManyOperandsException e) {
				messageBox(e.getMessage());
				inputField.setText("");
				PostfixEvaluator.clear();
			} catch (PostfixFormatException e) {
				messageBox("Incorrect text format\n" + "Check for extra spaces or double operators");
				inputField.setText("");
				PostfixEvaluator.clear();
			} catch(NoSuchElementException e) {
				messageBox("Not Enough Operands");
				inputField.setText("");
				PostfixEvaluator.clear();
			}
		}
		if(buttonObj == exitButton) {
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		frm.setSize(400, 500);
		frm.setTitle("Postfix Evaluator");
		frm.setResizable(false);
		frm.setVisible(true);
	}
}
