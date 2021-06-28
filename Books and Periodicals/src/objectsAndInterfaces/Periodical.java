package objectsAndInterfaces;
/*Paul Davis
 * Books and Periodicals Program
 * 1/15/20
 */
public class Periodical extends Item {
	private Integer issueNum;
	
	public Periodical() {
		setTitle("");
		issueNum = 0;
	}
	
	public Periodical(String title, int issueNum) {
		setTitle(title);
		this.issueNum = issueNum;
	}
	
	public int getIssueNum() {
		return issueNum;
	}

	@Override
	public int compareTo(Object o) {
		return issueNum.compareTo(((Periodical)o).getIssueNum());
	}
	
	public String print() {
		return "Title: " + getTitle() + ", Issue #: " + issueNum;
	}

}