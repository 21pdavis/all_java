package library;

import javax.swing.*;
import BreezySwing.*;

@SuppressWarnings({"serial", "unused"})
public class SearchBooksGUI extends GBDialog{
	private JLabel searchBookInstructions = addLabel("Search for a book by title (not case specific):", 1,1,1,1);
	private JLabel searchTitleLabel = addLabel("Title:", 2,1,1,1);
	private JTextField searchTitleField = addTextField("", 2,2,1,1);
	private JButton searchBookButton = addButton("Search", 3,2,1,1);
	private JList<String> list = addList(4, 1, 1, 1);
	DefaultListModel<String> model = (DefaultListModel<String>)list.getModel();
	private JButton resetButton = addButton("Reset", 5,1,1,1);
	private JButton exitButton = addButton("Exit", 5,2,1,1);
	Library library;
	
	public SearchBooksGUI(JFrame frm, Library library) {
		super(frm); // implicit super constructor, not sure 100% how works, some kind of inheritance thing
		setSize(600, 500);
		setTitle("Search Window");
		this.library = library;// "this" statement references instance variables of class
	}

	public void buttonClicked(JButton buttonObj) {
		if(buttonObj == searchBookButton) {
			if(library.bookTitleExists(searchTitleField.getText()) && searchTitleField.getText().isEmpty() == false) {
				for(Book b : library.getAllBooks()) {
					if(b.getTitle().equals(searchTitleField.getText()))
						model.addElement(b.toString());
				}
			}
			else if(searchTitleField.getText().isEmpty()) 
				messageBox("Please make sure that the search box is not empty");
			else if(library.bookTitleExists(searchTitleField.getText()) == false) 
				messageBox("Book not found");
		}
		if(buttonObj == resetButton) {
			resetFrame();
		}
		if(buttonObj == exitButton) {
			setVisible(false);
		}
	}
	
	public void resetFrame() {
		searchTitleField.setText("");
		model.removeAllElements();
	}
}
