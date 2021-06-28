package library;

import javax.swing.*;
import BreezySwing.*;


@SuppressWarnings({ "unused", "serial" })
public class LibraryGUI extends GBFrame{
	//GUIs and necessary objects
	Library library = new Library();
	private static JFrame frm = new LibraryGUI(); // set to static because you want this to be accessible no matter what
	SearchBooksGUI searchGUI = new SearchBooksGUI(frm, library);
	BookDisplaysGUI bookDisplaysGUI = new BookDisplaysGUI(frm, library);
	LoanGUI loanGUI = new LoanGUI(frm, library);
	ReturnGUI returnGUI = new ReturnGUI(frm, library);
	//date input
	private JLabel welcomeMessage = addLabel("Welcome to the Library!", 1,1,1,1);
	private JLabel inputDateLabel = addLabel("Enter today's date (MM/DD/YYYY):", 2,1,1,1);
	private JTextField monthInputField = addTextField("", 2,2,1,1);
	private JLabel slash1 = addLabel("/", 2,3,1,1);
	private JTextField dayInputField = addTextField("", 2,4,1,1);
	private JLabel slash2 = addLabel("/", 2,5,1,1);
	private JTextField yearInputField = addTextField("", 2,6,1,1);
	private JButton setDateButton = addButton("Set Date", 3,2,1,1);
	//set of labels, fields, and buttons for book input
	private JLabel enterBookInstructions = addLabel("Enter a Book:", 4,1,1,1);
	private JLabel inputTitleLabel = addLabel("Title:", 5,1,1,1);
	private JTextField inputTitleField = addTextField("", 5,2,1,1);
	private JLabel inputAuthorLabel = addLabel("Author:", 6,1,1,1);
	private JTextField inputAuthorField = addTextField("", 6,2,1,1);
	private JButton inputBookButton = addButton("Input Book", 7,2,1,1);
	//set of labels, fields, and buttons for book search
	private JLabel searchBookInstructions = addLabel("Search for a book by title (Case Sensitive):", 8,1,1,1);
	private JButton searchBookButton = addButton("Search For A Book", 9,2,1,1);
	//set of labels, fields, and buttons for loaning or returning books
	private JLabel loanReturnInstructions = addLabel("Loan or Return a Book:", 10,1,1,1);
	private JButton loanBookButton = addButton("Loan Out a Book", 11,2,1,1);
	private JButton returnBookButton = addButton("Return a Book", 12,2,1,1);
	//set of labels and buttons for book displays section
	private JLabel displayBooks = addLabel("Book Displays", 13,1,1,1);
	private JButton displayBooksButton = addButton("Displays Window", 14,2,1,1);
	//reset and exit buttons
	private JButton exitButton = addButton("Exit", 15,1,1,1);
	private JButton resetButton = addButton("Reset Library", 15,2,1,1);
	
	public LibraryGUI() {//constructor for GUI
		//search book section
		searchBookButton.setEnabled(false);
		//Return/loan book section
		loanBookButton.setEnabled(false);
		returnBookButton.setEnabled(false);
		//book displays section
		displayBooksButton.setEnabled(false);
	}
	
	public void buttonClicked(JButton buttonObj) {
		if(buttonObj == setDateButton) {
			if(dayInputField.getText().length() == 2 && monthInputField.getText().length() == 2 && yearInputField.getText().length() == 4 &&
					isValidMonth(Integer.parseInt(monthInputField.getText())) && isValidDay(Integer.parseInt(dayInputField.getText()), Integer.parseInt(monthInputField.getText()), Integer.parseInt(yearInputField.getText())) && 
					isValidYear(Integer.parseInt(yearInputField.getText()))) {
				try {
				library.setDate(Integer.parseInt(dayInputField.getText()), Integer.parseInt(monthInputField.getText()), Integer.parseInt(yearInputField.getText()));
				messageBox("Date Set Successfully" + "\n" + "Reset the program to change it");
				setDateButton.setEnabled(false);
				}
				catch(NumberFormatException e) {
					messageBox("Input only numbers into the fields");
					dayInputField.setText("");
					monthInputField.setText("");
					yearInputField.setText("");
				}
			}
			else {
				messageBox("Invalid Date Input. Make sure that " + "\n" + "- The day input has 2 digits" + "\n" + "- The month input has 2 digits" + "\n" + "- The year input has 4 digits" + "\n" + "- The inputs are within proper ranges" +
			"\n" + "- The day value is within its proper range for the month");
				dayInputField.setText("");
				monthInputField.setText("");
				yearInputField.setText("");
			}
		}
		if(buttonObj == inputBookButton) {
			inputBook();
			inputTitleField.setText("");
			inputAuthorField.setText("");
		}
		if(buttonObj == searchBookButton) {
			searchGUI.resetFrame();
			searchGUI.setVisible(true);
		}
		if(buttonObj == displayBooksButton) {
			bookDisplaysGUI.resetFrame();
			bookDisplaysGUI.setVisible(true);
		}
		if(buttonObj == loanBookButton) {
			loanGUI.resetFrame();
			loanGUI.setVisible(true);
		}
		if(buttonObj == returnBookButton) {
			returnGUI.resetFrame();
			returnGUI.setVisible(true);
		}
		if(buttonObj == exitButton)
			System.exit(0);
		if(buttonObj == resetButton) {
			resetFrame();
		}
	}
	
	private void enableFieldsAndButtons() {
		//search book section
		searchBookButton.setEnabled(true);
		//Return book section
		loanBookButton.setEnabled(true);
		returnBookButton.setEnabled(true);
		//book displays section
		displayBooksButton.setEnabled(true);
	}
	
	private void inputBook() {
		if(isValidBookInput(inputTitleField.getText(), inputAuthorField.getText())) { // error check input
			library.addBook(new Book(inputTitleField.getText(), inputAuthorField.getText()));//add book to array lists
			enableFieldsAndButtons();
		}
		else {
			messageBox("Title input or author input is empty. Try again.");
			inputTitleField.setText("");
			inputAuthorField.setText("");
			inputTitleField.requestFocusInWindow();
		}
	}
	
	private boolean isValidBookInput(String title, String author) {//error check input for book input
		if(title.isEmpty() || author.isEmpty()) {
			return false;
		}
		else
			return true;
	}
	
	private boolean is30Month(int month) {
		boolean is30Month = true;
		
		if(month == 4 || month == 6 || month == 9 || month == 11)
			is30Month = true;
		else if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
			is30Month = false;
		
		return is30Month;
	}

	private boolean isLeap(int year) {
		boolean leap;
		if((year % 4 == 0 && year % 100 != 0) || (year % 4 == 0 && year % 400 == 0))
			leap = true;
		else
			leap = false;
		return leap;
	}

	
	public boolean isValidMonth(int month) {
		boolean isValidMonth = true;
		
		if(month <= 0 || month > 12)
			isValidMonth = false;
		
		return isValidMonth;
	}
	
	public boolean isValidDay(int day, int month, int year) {
		boolean isValidDay = true;
		
		if((day < 1 || day > 30) && (is30Month(month) == true))
			isValidDay = false;
		
		if((day < 1 || day > 31) && (is30Month(month) == false))
			isValidDay = false;
		
		if((day < 1 || day > 28) && month == 2 && isLeap(year) == false)
			isValidDay = false;
		
		if((day < 1 || day > 29) && month == 2 && isLeap(year) == true)
			isValidDay = false;
		
		return isValidDay;
	}
	
	public boolean isValidYear(int year) {
		boolean isValidYear = true;
		
		if(year < 1) 
			isValidYear = false;
		
		return isValidYear;
	}

	
	public Library getLibrary() {
		return library;
	}
	
	private void resetFrame(){
		dayInputField.setText("");
		monthInputField.setText("");
		yearInputField.setText("");
		inputTitleField.setText("");
		inputAuthorField.setText("");
		//search book section
		searchBookButton.setEnabled(false);
		//Return/loan book section
		loanBookButton.setEnabled(false);
		returnBookButton.setEnabled(false);
		//book displays section
		displayBooksButton.setEnabled(false);
		//date button
		setDateButton.setEnabled(true);
	}
	
	public static void main(String[] args) {
		frm.setTitle("Library");
		frm.setSize(750, 700);
		frm.setVisible(true);
	}
}
