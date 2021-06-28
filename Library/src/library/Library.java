package library;

import java.util.ArrayList;

public class Library {
	private ArrayList<Book> allBooks = new ArrayList<Book>();
	private ArrayList<Book> borrowedBooks = new ArrayList<Book>();
	private ArrayList<Book> availableBooks = new ArrayList<Book>();
	private Date date;
	
	public Library() {
		date = null;
	}
	
	public void setDate(int d, int m, int y) {
		date = new Date(m, d, y);
	}
	
	public Date getDate() {
		return date;
	}
	
	public ArrayList<Book> getAllBooks() {
		return allBooks;
	}
	
	public ArrayList<Book> getAvailableBooks() {
		return availableBooks;
	}
	
	public ArrayList<Book> getBorrowedBooks() {
		return borrowedBooks;
	}
	
	public void addBook(Book book) {
		allBooks.add(book);
		availableBooks.add(book);
	}
	
	public void loanBook(Book book, String borrowerName) {
		borrowedBooks.add(book);
		availableBooks.remove(book);
		book.setIsBorrowed(true);
		book.setBorrower(borrowerName);
	}
	
	public void returnBook(Book book) {
		borrowedBooks.remove(book);
		availableBooks.add(book);
		book.setDate(0, 0, 0);
		book.setBorrower(null);
		book.setIsBorrowed(false);
	}
	
	public boolean bookExists(Book book) {
		for(Book b : allBooks) {
			if(b.getTitle().equals(book.getTitle()) && b.getAuthor().equals(book.getAuthor()))
				return true;
		}
		return false;
	}
	
	public boolean bookTitleExists(String title) {
		for(Book b : allBooks) {
			if(b.getTitle().equals(title))
				return true;
		}
		return false;
	}
	
	public void resetLibrary() {
		getAllBooks().clear();
		getAvailableBooks().clear();
		getBorrowedBooks().clear();
		getDate().setDay(0);
		getDate().setMonth(0);
		getDate().setYear(0);
	}
}
