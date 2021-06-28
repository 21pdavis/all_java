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
public class CompareGUI extends GBDialog {
	private ArrayList<Item> items= new ArrayList<Item>();
	private JLabel bookLabel = addLabel("Compare book with preexisting book:", 1, 1, 1, 1);
	private JLabel bookTitleLabel = addLabel("Title: ", 2, 1, 1, 1);
	private JTextField bookTitleField = addTextField("", 2, 2, 1, 1);
	private JLabel bookAuthorLabel = addLabel("Author: ", 3, 1, 1, 1);
	private JTextField bookAuthorField = addTextField("", 3, 2, 1, 1);
	private JButton compareBookButton = addButton("Compare Book", 4, 1, 1, 1);
	private JLabel periodicalLabel = addLabel("Compare periodical with preexisting periodical:", 5, 1, 1, 1);
	private JLabel periodicalTitleLabel = addLabel("Title: ", 6, 1, 1, 1);
	private JTextField periodicalTitleField = addTextField("", 6, 2, 1, 1);
	private JLabel periodicalNumberLabel = addLabel("Issue Number: ", 7, 1, 1, 1);
	private IntegerField periodicalNumberField = addIntegerField(0, 7, 2, 1, 1);
	private JButton comparePeriodicalButton = addButton("Compare Periodical", 8,1,1,1);
	private JList<String> beforeList = addList(9, 1, 1, 1);
	private DefaultListModel<String> beforeModel = (DefaultListModel<String>) beforeList.getModel();
	private JList<String> equalList = addList(9, 2, 1, 1);
	private DefaultListModel<String> equalModel = (DefaultListModel<String>) equalList.getModel();
	private JList<String> afterList = addList(9, 3, 1, 1);
	private DefaultListModel<String> afterModel = (DefaultListModel<String>) afterList.getModel();
	private JButton exitButton = addButton("Exit", 10,1,1,1);
	private JButton resetButton = addButton("Reset", 10,2,1,1);
	
	public CompareGUI(JFrame frm, ArrayList<Item> items) {
		super(frm);
		setTitle("Compare Items");
		setSize(1000, 400);
		this.items = items;
		beforeModel.addElement("Before:");
		equalModel.addElement("Equal:");
		afterModel.addElement("After:");
	}
	
	@SuppressWarnings("unchecked")
	public void buttonClicked(JButton buttonObj) {
		if(buttonObj == compareBookButton) {
			if(bookTitleField.getText().isEmpty() || bookAuthorField.getText().isEmpty()) {
				bookTitleField.setText("");
				bookAuthorField.setText("");
				messageBox("Change the title and author fields from" + '\n' + "the default values");
			}
			else if(bookTitleField.getText().matches(".*\\d.*") || bookAuthorField.getText().matches(".*\\d.*")){
				bookTitleField.setText("");
				bookAuthorField.setText("");
				messageBox("Do not include numbers in" + '\n' + "title or author fields");
			}
			else {
				resetLists();
				boolean bookFound = false;
				Book b = new Book(bookTitleField.getText(), bookAuthorField.getText());
				for(int i = 0; i < items.size(); i++) {
					if(items.get(i) instanceof Book && items.get(i).compareTo(b) > 0) {
						afterModel.addElement(items.get(i).print());
						bookFound = true;
					}
					if(items.get(i) instanceof Book && items.get(i).compareTo(b) == 0) {
						equalModel.addElement(items.get(i).print());
						bookFound = true;
					}
					if(items.get(i) instanceof Book && items.get(i).compareTo(b) < 0) {
						beforeModel.addElement(items.get(i).print());
						bookFound = true;
					}
	
				}
				 if(bookFound == false) 
					 messageBox("No books found");
				 b = null;
			}
		}
		if(buttonObj == comparePeriodicalButton) {
			if(periodicalTitleField.getText().isEmpty()) {
				periodicalTitleField.setText("");
				periodicalNumberField.setNumber(0);
				messageBox("Change the title field from" + '\n' + "the default values");
			}
			else if(periodicalTitleField.getText().matches(".*\\d.*")){
				periodicalTitleField.setText("");
				periodicalNumberField.setNumber(0);		
				messageBox("Do not include numbers in" + '\n' + "title field");
			}
			else if(periodicalNumberField.getNumber() == 0) {
				periodicalTitleField.setText("");
				periodicalNumberField.setNumber(0);
				messageBox("Change issue number from default value" + '\n' + "and ensure it contains no letters");
			}
			else {
				resetLists();
				boolean periodicalFound = false;
				Periodical p = new Periodical(periodicalTitleField.getText(), periodicalNumberField.getNumber());
				for(int i = 0; i < items.size(); i++) {
					if(items.get(i) instanceof Periodical && items.get(i).compareTo(p) > 0) {
						afterModel.addElement(items.get(i).print());
						periodicalFound = true;
					}
					if(items.get(i) instanceof Periodical && items.get(i).compareTo(p) == 0) {
						equalModel.addElement(items.get(i).print());
						periodicalFound = true;
					}
					if(items.get(i) instanceof Periodical && items.get(i).compareTo(p) < 0) {
						beforeModel.addElement(items.get(i).print());
						periodicalFound = true;
					}
				}
				if(periodicalFound = false) 
					messageBox("No periodicals found");
				p = null;
			}
		}
		if(buttonObj == exitButton) {
			setVisible(false);
		}
		if(buttonObj == resetButton) {
			resetFrame();
		}
	}
	
	private void resetLists() {
		beforeModel.clear();
		equalModel.clear();
		afterModel.clear();
		beforeModel.addElement("Before:");
		equalModel.addElement("Equal:");
		afterModel.addElement("After:");
	}

	public void resetFrame() {
		bookTitleField.setText("");
		bookAuthorField.setText("");
		periodicalTitleField.setText("");
		periodicalNumberField.setNumber(0);
		resetLists();
		setSize(1000, 400);
	}
}