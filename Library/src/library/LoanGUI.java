package library;

import javax.swing.*;
import BreezySwing.*;

@SuppressWarnings({"serial", "unused"})
public class LoanGUI extends GBDialog{
	private Library library;
	private JLabel welcomeLabel = addLabel("Loan out a book here!", 1,1,1,1);
	private JLabel inputTitleLabel = addLabel("Title to be loaned:", 2,1,1,1);
	private JTextField inputTitleField = addTextField("", 2,2,5,1);
	private JLabel inputAuthorLabel = addLabel("Author Name:", 3,1,1,1);
	private JTextField inputAuthorField = addTextField("", 3,2,5,1);
	private JLabel inputDateLabel = addLabel("Enter the date (MM/DD/YYYY) the book was loaned:", 4,1,1,1);
	private JTextField monthInputField = addTextField("", 4,2,1,1);
	private JLabel slash1 = addLabel("/", 4,3,1,1);
	private JTextField dayInputField = addTextField("", 4,4,1,1);
	private JLabel slash2 = addLabel("/", 4,5,1,1);
	private JTextField yearInputField = addTextField("", 4,6,1,1);
	private JLabel inputNameLabel = addLabel("Your Name:", 5,1,1,1);
	private JTextField inputNameField = addTextField("", 5,2,1,1);
	private JButton loanButton = addButton("Loan Book", 6,1,1,1);
	private JButton exitButton = addButton("Exit", 6,4,1,1);
	public LoanGUI(JFrame frm, Library library) {
		super(frm); // implicit "super" constructor, not sure 100% how works, some kind of inheritance thing
		setSize(600, 500);
		setTitle("Loan or Return a Book");
		this.library = library; // "this" statement references instance variables of class
	}
	
	public void buttonClicked(JButton buttonObj) {
		if(buttonObj == loanButton) {
			boolean bookFound = false;
			if(inputTitleField.getText().isEmpty() == false && inputAuthorField.getText().isEmpty() == false && inputNameField.getText().isEmpty() == false && 
					 dayInputField.getText().length() == 2 && monthInputField.getText().length() == 2 && yearInputField.getText().length() == 4 &&
					 isDateAfterOrSame(library.getDate(), Integer.parseInt(monthInputField.getText()), Integer.parseInt(dayInputField.getText()), Integer.parseInt(yearInputField.getText())) && library.getDate() != null) {
				for(int i = 0; i < library.getAvailableBooks().size(); i++) {
					if(library.getAvailableBooks().get(i).getTitle().equals(inputTitleField.getText()) && library.getAvailableBooks().get(i).getAuthor().equals(inputAuthorField.getText())) {
						library.getAvailableBooks().get(i).setDate(Integer.parseInt(dayInputField.getText()), Integer.parseInt(monthInputField.getText()), Integer.parseInt(yearInputField.getText()));
						library.loanBook(library.getAvailableBooks().get(i), inputNameField.getText());
						messageBox("Book Successfully Loaned. Enjoy!");
						bookFound = true;
					}
				}
			}
			else if(inputTitleField.getText().isEmpty() || inputAuthorField.getText().isEmpty() || inputNameField.getText().isEmpty()) {
				messageBox("Make sure that no input fields are empty");
				bookFound = true;
			}
			else if(dayInputField.getText().length() != 2 || monthInputField.getText().length() != 2 || yearInputField.getText().length()  != 4) {
				messageBox("Invalid Date Input. Make sure that " + "\n" + "- The day input has 2 digits" + "\n" + "- The month input has 2 digits" + "\n" + "- The year input has 4 digits");
				dayInputField.setText("");
				monthInputField.setText("");
				yearInputField.setText("");
				bookFound = true;
			}
			else if(isDateAfterOrSame(library.getDate(), Integer.parseInt(dayInputField.getText()), Integer.parseInt(monthInputField.getText()), Integer.parseInt(yearInputField.getText())) == false) {
				messageBox("Invalid Date Input." + "\n" + "Make sure the loaned date is before today's date");
				bookFound = true;
			}
			if(bookFound == false)
				messageBox("Book not found");
			resetFrame();
		}
		if(buttonObj == exitButton)
			setVisible(false);
	}
	
	private boolean isDateAfterOrSame(Date currentDate, int month, int day, int year) {
		boolean isDateAfterOrSame = false;
		
		if(currentDate.getYear() == year && currentDate.getMonth() == month) {
			if(currentDate.getDay() > day || currentDate.getDay() == day) {
				isDateAfterOrSame = true;
			}
		}
		else if(currentDate.getYear() == year && currentDate.getMonth() != month) {
			if(currentDate.getMonth() > month) {
				isDateAfterOrSame = true;
			}
		}
		else if(currentDate.getYear() != year && currentDate.getMonth() != month) {
			if(currentDate.getYear() > year) {
				isDateAfterOrSame = true;
			}
		}
		
		return isDateAfterOrSame;
	}
	
	public void resetFrame() {
		inputTitleField.setText("");
		inputAuthorField.setText("");
		dayInputField.setText("");
		monthInputField.setText("");
		yearInputField.setText("");
		inputNameField.setText("");
	}
}
