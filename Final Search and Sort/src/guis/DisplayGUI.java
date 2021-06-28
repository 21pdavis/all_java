package guis;

import BreezySwing.*;
import java.util.ArrayList;
import javax.swing.*;
import objects.*;

@SuppressWarnings({"serial", "unused"})
public class DisplayGUI extends GBDialog{
	private JLabel outputLabel = addLabel("Matches Found:", 1,1,1,1);
	private JList<String> outputList = addList(2,1,1,1);
	private DefaultListModel<String> model = (DefaultListModel<String>)outputList.getModel();
	private JButton exitButton = addButton("Exit", 2,1,1,1);
	
	public DisplayGUI(JFrame frm) {
		super(frm);
	}
	
	public void buttonClicked(JButton buttonObj) {
		if(buttonObj == exitButton)
			setVisible(false);
	}
	
	public void initList(ArrayList<Comparable> list) {
		model.clear();
		if(list.get(0) instanceof Employee) {
			model.addElement("Names:" + '\t' + "Salary:");
			for(int i = 0; i < list.size(); i++) 
				model.addElement(list.get(i).toString());
		}
		if(list.get(0) instanceof Student) {
			model.addElement("Names:" + '\t' + "GPA: ");
			for(int i = 0; i < list.size(); i++)
				model.addElement(list.get(i).toString());
		}
		if(list.get(0) instanceof Widget) {
			model.addElement("Product Numbers:" + '\t' + "Number Sold:");
			for(int i = 0; i < list.size(); i++) 
				model.addElement(list.get(i).toString());
		}
	}
}