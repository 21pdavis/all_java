package guis;

/*
 * Paul Davis
 * 4/2/2021
 * Binary Tree Program
 * This program takes in integers and sorts them into a balanced binary tree, 
 * allowing the user to input and remove numbers as well as output 
 * inorder, preorder, postorder, and level order traversals
 */

import BreezySwing.*;
import java.util.NoSuchElementException;
import javax.swing.*;
import structures.*;

@SuppressWarnings({ "unused", "serial" })
public class BinaryTreeGUI extends GBFrame {
	private static JFrame frm = new BinaryTreeGUI();
	private BinaryTree tree = new BinaryTree();
	private JLabel numLabel = addLabel("Number: ", 1, 1, 1, 1);
	private JTextField numField = addTextField("", 1, 2, 1, 1);
	private JButton inputButton = addButton("Input Number", 2, 1, 1, 1);
	private JButton removeButton = addButton("Remove Number", 2, 2, 1, 1);
	private JButton inorderButton = addButton("Output Inorder", 3, 1, 1, 1);
	private JButton preorderButton = addButton("Output Preorder", 3, 2, 1, 1);
	private JButton postorderButton = addButton("Output Postorder", 4, 1, 1, 1);
	private JButton levelOrderButton = addButton("Output Level Order", 4, 2, 1, 1);
	private JButton resetButton = addButton("Reset", 5, 1, 1, 1);
	private JButton exitButton = addButton("Exit", 5, 2, 1, 1);

	public void buttonClicked(JButton buttonObj) {
		if (buttonObj == inputButton) {
			if (tree.size() < 33 && !numField.getText().isEmpty()) {
				try {
					if (tree.addElement(Integer.parseInt(numField.getText()))) {
						messageBox("Number Input");
					} else {
						messageBox("Number already exists in tree," + '\n' + "Number not input");
						numField.setText("");
					}
				} catch (NumberFormatException e) {
					messageBox("Invalid Input." + '\n' + "Ensure input contains only integer values");
				}
			} else if (tree.size() > 33){
				messageBox("Input a maximum of 33 items into tree");
			} else if (numField.getText().isEmpty()) {
				messageBox("Number field is empty");
			}
			numField.setText("");
		}
		if (buttonObj == removeButton) {
			if(!tree.isEmpty() && !numField.getText().isEmpty()) {
				try {
					tree.removeElement(Integer.parseInt(numField.getText()));
					messageBox("Number Removed");
				} catch (NoSuchElementException e) {
					messageBox("Number not in tree");
				} catch (NumberFormatException e) {
					messageBox("Invalid Input." + '\n' + "Ensure that input contains only integer values");
				}
			} else if (tree.isEmpty()){
				messageBox("Tree is Empty");
			} else if (numField.getText().isEmpty()) {
				messageBox("Number field is empty");
			}
			numField.setText("");
		}
		if (buttonObj == inorderButton) {
			if (!tree.isEmpty()) {
				messageBox("Inorder Output:" + '\n' + tree.toStringInorder());
			}
			else {
				messageBox("Tree is Empty.");
			}
		}
		if (buttonObj == preorderButton) {
			if (!tree.isEmpty()) {
				messageBox("Preorder Output:" + '\n' + tree.toStringPreorder());
			}
			else {
				messageBox("Tree is Empty.");
			}
		}
		if (buttonObj == postorderButton) {
			if (!tree.isEmpty()) {
				messageBox("Postorder Output:" + '\n' + tree.toStringPostorder());
			}
			else {
				messageBox("Tree is Empty.");
			}
		}
		if (buttonObj == levelOrderButton) {
			if (!tree.isEmpty()) {
				messageBox("Level Order Output:" + '\n' + tree.toStringLevelOrder());
			}
			else {
				messageBox("Tree is Empty.");
			}
		}
		if (buttonObj == resetButton) {
			if (!tree.isEmpty()) {
				tree.removeAllElements();
				numField.setText("");
				messageBox("Tree Reset");
			} else {
				messageBox("Tree already empty.");
				numField.setText("");
			}
		}
		if (buttonObj == exitButton) {
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		frm.setTitle("Binary Tree Program");
		frm.setSize(400, 400);
		frm.setResizable(false);
		frm.setVisible(true);
	}
}
