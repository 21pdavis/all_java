package objectsAndInterfaces;
/*Paul Davis
 * Books and Periodicals Program
 * 1/15/20
 */
public class Book extends Item {
	private String author;
	
	public Book() {
		setTitle("");
		author = "";
	}
	
	public Book(String title, String author) {
		setTitle(title);
		this.author = author;
	}

	@Override
	public int compareTo(Object o) {
		return getTitle().compareTo(((Book)o).getTitle());
	}

	public String print() {
		return "Title: " + getTitle() + ", Author: " + author;
	}
}