package library;

public class Book {
	private String title;
	private String author;
	private String borrower;
	private Date dateBorrowed;
	private boolean isBorrowed;
	
	public Book() {
		title = "";
		author = "";
		borrower = null;
		dateBorrowed = new Date();
		isBorrowed = false;
	}
	public Book(String t, String a) {
		title = t;
		author = a;
	}
	
	public void setTitle(String t) {
		title = t;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setAuthor(String a) {
		author = a;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setBorrower(String b) {
		borrower = b;
	}
	
	public String getBorrower() {
		return borrower;
	}
	
	public void setDate(int m, int d, int y) {
		dateBorrowed = new Date(m, d, y);
	}
	
	public Date getDate() {
		return dateBorrowed;
	}
	
	public void setIsBorrowed(boolean iB) {
		isBorrowed = iB;
	}
	
	public boolean getIsBorrowed() {
		return isBorrowed;
	}
	
	public String toString() {
		if(isBorrowed == true)
			return "Title: " + title + ", " + "Author: "  + author + ", " + "Date Borrowed: " + dateBorrowed + ", " + "Borrower: " + borrower;
		else
			return "Title: " + title + ", " + "Author: "  + author + ", " + "Date Borrowed: N/A" + ", " + "Borrower: N/A";
	}
}
