package objectsAndInterfaces;
/*Paul Davis
 * Books and Periodicals Program
 * 1/15/20
 */
public abstract class Item implements Comparable{
	private String title;
	
	public Item() {
		title = "";
	}
	
	public Item(String title) {
		this.title = title;
	}
	
	public void setTitle(String t) {
		title = t;
	}
	
	public String getTitle() {
		return title;
	}
	
	public abstract String print();
}