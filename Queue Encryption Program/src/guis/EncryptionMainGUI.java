package guis;

/*
 * Paul Davis
 * 2/26/2021
 * Queue Encryption Program
 * This program takes in a sentence and encryption key, encrypting and/or decrypting the message based on user choice. It used a modified Caesar Cipher that cycles through multiple keys
 */

import BreezySwing.*;
import javax.swing.*;
import structures.*;

@SuppressWarnings({ "serial", "unused" })
public class EncryptionMainGUI extends GBFrame {
	private static JFrame frm = new EncryptionMainGUI();
	private String keyString;
	private String encryptedMessage;
	private String decryptedMessage;
	private boolean messageIsEncrypted = false;
	private JLabel keyLabel = addLabel("Encryption Key (separate with spaces):", 1, 1, 1, 1);
	private JTextField keyField = addTextField("", 1, 2, 1, 1);
	private JButton keyButton = addButton("Input Key", 2, 1, 1, 1);
	private JLabel currentKeyLabel = addLabel("Current Key:", 3, 1, 1, 1);
	private JTextField currentKeyField = addTextField("", 3, 2, 1, 1);
	private JLabel messageLabel = addLabel("Message:", 4, 1, 1, 1);
	private JTextField messageField = addTextField("", 4, 2, 1, 1);
	private JButton setEncryptedMessageButton = addButton("Set Encrypted Message", 5, 1, 1, 1);
	private JButton setDecryptedMessageButton = addButton("Set Decrypted Message", 5, 2, 1, 1);
	private JLabel currentMessageLabel = addLabel("Current Message", 6, 1, 1, 1);
	private JTextField currentMessageField = addTextField("", 6, 2, 1, 1);
	private JButton encryptButton = addButton("Encrypt Message", 7, 1, 1, 1);
	private JButton decryptButton = addButton("Decrypt Message", 7, 2, 1, 1);
	private JButton resetButton = addButton("Reset", 8, 2, 1, 1);
	private JButton exitButton = addButton("Exit", 9, 2, 1, 1);

	public EncryptionMainGUI() {
		currentKeyField.setEditable(false);
		currentMessageField.setEditable(false);
	}

	public void buttonClicked(JButton buttonObj) {
		if (buttonObj == keyButton) {
			if (!keyField.getText().isEmpty() && keyField.getText().matches("[0-9 -]+")) {
				keyString = keyField.getText();
				messageBox("Encrpytion Key Received");
				currentKeyField.setText(keyString);
				keyField.setText("");
			} else if (keyField.getText().isEmpty()) {
				messageBox("Key input field is empty");
			} else if (!keyField.getText().matches("[0-9 -]+")) {
				messageBox("Invalid input." + '\n' + "Include only positive or negative integers and spaces");
				keyField.setText("");
			}
		}

		if (buttonObj == setEncryptedMessageButton) {
			if (messageField.getText().isEmpty()) {
				messageBox("Message Field is Empty");
			} else {
				encryptedMessage = messageField.getText();
				messageField.setText("");
				currentMessageField.setText(encryptedMessage);
				messageIsEncrypted = true;
				messageBox("Encrypted Message Set");
			}
		}

		if (buttonObj == setDecryptedMessageButton) {
			if (messageField.getText().isEmpty()) {
				messageBox("Message Field is Empty");
			} else {
				decryptedMessage = messageField.getText();
				messageField.setText("");
				currentMessageField.setText(decryptedMessage);
				messageIsEncrypted = false;
				messageBox("Decrypted Message Set");
			}
		}

		if (buttonObj == encryptButton) {
			try {
				if (!messageIsEncrypted) {
					encryptedMessage = Server.encryptMessage(decryptedMessage, keyString);
					currentMessageField.setText(encryptedMessage);
					messageIsEncrypted = true;
				} else {
					messageBox("Message is already encrypted");
				}
			} catch (NullPointerException e) {
				messageBox("Key or message input missing" + '\n' + "Make sure message is not shorter than key length");
			} catch (NumberFormatException e) {
				messageBox("Previously undetected error in key input found." + '\n' + "Resetting key...");
				keyString = null;
				currentKeyField.setText("");
			}
		}

		if (buttonObj == decryptButton) {
			try {
				if (messageIsEncrypted) {
					decryptedMessage = Server.decryptMessage(encryptedMessage, keyString);
					currentMessageField.setText(decryptedMessage);
					messageIsEncrypted = false;
				} else {
					messageBox("Message is already decrypted");
				}
			} catch (NullPointerException e) {
				messageBox("Key or message input missing" + '\n' + "Make sure message is not shorter than key length");
			}
		}

		if (buttonObj == resetButton) {
			try {
				resetProgram();
				messageBox("Program Reset");
			} catch (NullPointerException e) {
				messageBox("");
			}
		}

		if (buttonObj == exitButton) {
			System.exit(0);
		}
	}

	private void resetProgram() {
		keyString = null;
		encryptedMessage = null;
		decryptedMessage = null;
		messageIsEncrypted = false;

		keyField.setText("");
		currentKeyField.setText("");
		messageField.setText("");
		currentMessageField.setText("");
	}

	public static void main(String[] args) {
		frm.setSize(500, 600);
		frm.setTitle("Encryption Program");
		frm.setResizable(false);
		frm.setVisible(true);
	}
}
