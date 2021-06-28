package guis;
/*Paul Davis
 * Books and Periodicals Program
 * 1/15/20
 */
import javax.swing.*;
import BreezySwing.*;
import objectsAndInterfaces.Item;
import objectsAndInterfaces.Book;
import objectsAndInterfaces.Periodical;
import java.util.ArrayList;

@SuppressWarnings({ "unused", "serial" })
public class MainGUI extends GBFrame {
	// Forms and variables
	private ArrayList<Item> items = new ArrayList<Item>();
	private static JFrame frm = new MainGUI();
	private CompareGUI compareGUI = new CompareGUI(frm, items);
	// Form elements
	private JLabel bookLabel = addLabel("Input a book:", 1, 1, 1, 1);
	private JLabel bookTitleLabel = addLabel("Title: ", 2, 1, 1, 1);
	private JTextField bookTitleField = addTextField("", 2, 2, 1, 1);
	private JLabel bookAuthorLabel = addLabel("Author: ", 3, 1, 1, 1);
	private JTextField bookAuthorField = addTextField("", 3, 2, 1, 1);
	private JButton bookInputButton = addButton("Input Book", 4, 1, 1, 1);
	private JLabel periodicalLabel = addLabel("Input a periodical:", 5, 1, 1, 1);
	private JLabel periodicalTitleLabel = addLabel("Title: ", 6, 1, 1, 1);
	private JTextField periodicalTitleField = addTextField("", 6, 2, 1, 1);
	private JLabel periodicalNumberLabel = addLabel("Issue Number (Greater than 0): ", 7, 1, 1, 1);
	private IntegerField periodicalNumberField = addIntegerField(0, 7, 2, 1, 1);
	private JButton periodicalInputButton = addButton("Input Periodical", 8, 1, 1, 1);
	private JButton compareButton = addButton("Compare Items", 9,1,1,1);
	private JButton exitButton = addButton("Exit", 10, 1, 1, 1);
	private JButton resetButton = addButton("Reset", 10, 2, 1, 1);

	public void buttonClicked(JButton buttonObj) {
		if (buttonObj == bookInputButton) {
			createBook(bookTitleField.getText(), bookAuthorField.getText());
		}

		if (buttonObj == periodicalInputButton) {
			createPeriodical(periodicalTitleField.getText(), periodicalNumberField.getNumber());
		}
		if(buttonObj == compareButton) {
			compareGUI.resetFrame();
			compareGUI.setVisible(true);
		}
		if (buttonObj == exitButton) {
			System.exit(0);
		}
		if (buttonObj == resetButton) {
			resetFrame();
		}
	}

	private void createBook(String title, String author) {
		if(title.isEmpty() || author.isEmpty()) {
			bookTitleField.setText("");
			bookAuthorField.setText("");
			messageBox("Change the title and author fields from" + '\n' + "the default values");
		}
		else if(title.matches(".*\\d.*") || author.matches(".*\\d.*")){
			bookTitleField.setText("");
			bookAuthorField.setText("");
			messageBox("Do not include numbers in" + '\n' + "title or author fields");
		}
		else {
			items.add(new Book(title, author));
			bookTitleField.setText("");
			bookAuthorField.setText("");
			messageBox("Book successfully input");
		}
	}

	private void createPeriodical(String title, int issueNum) {
		if(title.isEmpty()) {
			periodicalTitleField.setText("");
			periodicalNumberField.setNumber(0);
			messageBox("Change the title and issue number fields from" + '\n' + "the default values");
		}
		else if(title.matches(".*\\d.*")){
			periodicalTitleField.setText("");
			periodicalNumberField.setNumber(0);		
			messageBox("Do not include numbers in" + '\n' + "title field");
		}
		else if(issueNum == 0) {
			periodicalTitleField.setText("");
			periodicalNumberField.setNumber(0);
			messageBox("Change issue number from default value" + '\n' + "and ensure it contains no letters");
		}
		else {
			items.add(new Periodical(title, issueNum));
			periodicalTitleField.setText("");
			periodicalNumberField.setNumber(0);
			messageBox("Periodical successfully input");
		}
	}
	
	private void resetFrame() {
		items.clear();
		bookTitleField.setText("");
		bookAuthorField.setText("");
		periodicalTitleField.setText("");
		periodicalNumberField.setNumber(0);
	}
	
	public static void main(String[] args) {
		frm.setTitle("Books and Periodicals");
		frm.setSize(450, 500);
		frm.setVisible(true);
	}
}