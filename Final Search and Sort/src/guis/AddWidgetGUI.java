package guis;

import BreezySwing.*;
import javax.swing.*;
import objects.ObjectLibrary;

@SuppressWarnings({"serial", "unused"})
public class AddWidgetGUI extends GBDialog{
	private ObjectLibrary objLib;
	private JLabel productNumLabel = addLabel("Product Number: :", 1,1,1,1);
	private JTextField productNumField = addTextField("", 1,2,1,1);
	private JLabel numSoldLabel = addLabel("Number Sold: ", 2,1,1,1);
	private JTextField numSoldField = addTextField("", 2,2,1,1);
	private JButton addWidgetButton = addButton("Add Widget", 3,1,1,1);
	private JButton exitButton = addButton("Exit", 3,2,1,1);
	
	public AddWidgetGUI(JFrame frm, ObjectLibrary objLib) {
		super(frm);
		this.objLib = objLib;
		setSize(400, 300);
		setTitle("Add Widget");
		setResizable(false);
	}
	
	public void buttonClicked(JButton buttonObj) {
		if(buttonObj == addWidgetButton) {
			try {
				if(productNumField.getText().isEmpty() == false && numSoldField.getText().isEmpty() == false && productNumField.getText().length() == 3 &&
						Integer.parseInt(productNumField.getText()) >= 0 && Integer.parseInt(numSoldField.getText()) >= 0) {
					objLib.addWidget(Integer.parseInt(productNumField.getText()), Integer.parseInt(numSoldField.getText()));
					messageBox("Successfully Added Widget");
					resetFrame();
				}
				else if(productNumField.getText().isEmpty() || numSoldField.getText().isEmpty()) {
					messageBox("One or more fields is/are empty");
					resetFrame();
				}
				else if(productNumField.getText().length() != 3) {
					messageBox("Product Number must be a 3 digit code");
					resetFrame();
				}
				else if(Integer.parseInt(productNumField.getText()) < 0 || Integer.parseInt(numSoldField.getText()) < 0) {
					messageBox("Inputs must be positive values");
					resetFrame();
				}
			}
			catch(NumberFormatException e) {
				messageBox("Input only numbers in fields");
				resetFrame();
			}
		}
		if(buttonObj == exitButton) {
			setVisible(false);
		}
	}
	
	public void resetFrame() {
		productNumField.setText("");
		numSoldField.setText("");
	}
}