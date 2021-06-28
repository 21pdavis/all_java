package library;

import BreezySwing.*;
import javax.swing.*;

@SuppressWarnings({ "unused", "serial" })
public class ReturnGUI extends GBDialog{
	private Library library;
	private JLabel welcomeLabel = addLabel("Return Books Here!", 1,1,1,1);
	private JLabel inputTitleLabel = addLabel("Title of book to be returned:", 2,1,1,1);
	private JTextField inputTitleField = addTextField("", 2,2,1,1);
	private JLabel inputAuthorLabel = addLabel("Author of book to be returned:", 3,1,1,1);
	private JTextField inputAuthorField = addTextField("", 3,2,1,1);
	private JButton returnButton = addButton("Return", 4,1,1,1);
	private JButton exitButton = addButton("Exit", 4,2,1,1);

	public ReturnGUI(JFrame frm, Library library) {
		super(frm);
		setSize(600, 500);
		setTitle("Return a Book");
		this.library = library;
	}	
	
	public void buttonClicked(JButton buttonObj) {
		if(buttonObj == returnButton) {
			boolean bookFound = false;
			if(inputTitleField.getText().isEmpty() == false && inputAuthorField.getText().isEmpty() == false && library.getBorrowedBooks().isEmpty() == false) {
				for(int i = 0; i < library.getBorrowedBooks().size(); i++) {
					if(library.getBorrowedBooks().get(i).getTitle().equals(inputTitleField.getText()) && library.getBorrowedBooks().get(i).getAuthor().equals(inputAuthorField.getText())) {
						library.returnBook(library.getBorrowedBooks().get(i));
						messageBox("Book successfully returned.");
						resetFrame();
						bookFound = true;
					}
				}
			}
			else if(inputTitleField.getText().isEmpty() || inputAuthorField.getText().isEmpty()){
				messageBox("Make sure no input fields are empty.");
				resetFrame();
			}
			else if(bookFound = false) {
				messageBox("Book not found");
			}
			else if(library.getBorrowedBooks().isEmpty()) {
				messageBox("Make sure you borrow a book first");
				resetFrame();
			}
		}
		if(buttonObj == exitButton) {
			setVisible(false);
		}
	}
	
	public void resetFrame() {
		inputTitleField.setText("");
		inputAuthorField.setText("");
	}
}
