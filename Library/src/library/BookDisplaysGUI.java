package library;

import javax.swing.*;
import BreezySwing.*;

@SuppressWarnings({"serial"})
public class BookDisplaysGUI extends GBDialog{
	private Library library;
	private JButton displayAllBooksButton = addButton("Display All Books", 1,1,1,1);
	private JButton displayAvailableBooksButton = addButton("Display Available Books", 1,2,1,1);
	private JButton displayBorrowedBooksButton = addButton("Display Borrowed Books", 1,3,1,1);
	private JButton displayLateBooksButton = addButton("Display Late Books (2 weeks)", 1,4,1,1);
	private JList<String> list = addList(2,1,5,1);
	DefaultListModel<String> model = (DefaultListModel<String>)list.getModel();
	private JButton exitButton = addButton("Exit", 3,1,1,1);
	private JButton resetButton = addButton("Reset", 3,4,1,1);
	
	public BookDisplaysGUI(JFrame frm, Library library) {
		super(frm); // implicit super constructor, not sure 100% how works, some kind of inheritance thing
		setSize(900, 500);
		setTitle("All Books in the Library");
		this.library = library;// "this" statement references instance variables of class
	}
	
	public void buttonClicked(JButton buttonObj) {
		if(buttonObj == displayAllBooksButton) {
			resetFrame();
			for(Book b : library.getAllBooks()) {
				model.addElement(b.toString());
			}
		}
		if(buttonObj == displayAvailableBooksButton) {
			resetFrame();
			for(Book b : library.getAvailableBooks()) {
				model.addElement(b.toString());
			}
		}
		if(buttonObj == displayBorrowedBooksButton) {
			resetFrame();
			for(Book b : library.getBorrowedBooks()) {
				model.addElement(b.toString());
			}
		}
		if(buttonObj == displayLateBooksButton) {
			resetFrame();
			if(library.getDate() != null) {
				for(Book b : library.getBorrowedBooks()) {
					if(isBookLate(library.getDate(), b.getDate())) {
						model.addElement(b.toString());
					}
				}
			}
			else {
				messageBox("Set the date in the main GUI first");
				resetFrame();
			}
		}
		if(buttonObj == exitButton)
			setVisible(false);
		if(buttonObj == resetButton) 
			resetFrame();
	}
	
	private boolean isBookLate(Date currentDate, Date loanDate) {
		int dayDifference = 0;
		
		if(currentDate.getYear() == loanDate.getYear() && currentDate.getMonth() == loanDate.getMonth()) 
			dayDifference = currentDate.getDay() - loanDate.getDay();
		else if(currentDate.getYear() == loanDate.getYear() && currentDate.getMonth() != loanDate.getMonth() ){
			dayDifference = currentDate.getDayOfYear() - loanDate.getDayOfYear();
		}
		
		if(dayDifference > 14)
			return true;
		return false;
	}
	
	public void resetFrame() {
		model.removeAllElements();
	}
}
