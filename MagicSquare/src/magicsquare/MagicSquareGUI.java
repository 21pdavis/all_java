//Paul Davis
//C Block
//10/6/19
//Magic Square Program
//Program has the user input a magic square and returns whether or not what they entered is a magic square

package magicsquare;
import BreezySwing.*;
import javax.swing.*;

public class MagicSquareGUI extends GBFrame {
	MagicSquareServer server = new MagicSquareServer();
	JLabel greeting = addLabel("Welcome to the Magic Square!", 1,1,1,1);
	JLabel dimensionsInstructions = addLabel("Input whole number length and width between 2 and 8 (they are the same number because it is a square!): ", 2,1,1,1);
	DoubleField dimensionsInput = addDoubleField(0, 2,2,1,1);
	JButton inputDimensions = addButton("Input Dimensions", 3,1,1,1);
	JLabel squareInstructions = addLabel("Input all values of your magic square (positive integers only)!", 4,1,1,1);
	JButton inputSquare = addButton("Input Square", 13,1,1,1);
	DoubleField[][] fields;
	private int size = 0;
	private int constant = 0;
	private int correct = 0;
	private int correctNeeded = 0;
	private int validNumCount = 0;
	private int validNumNeeded = 0;
	public MagicSquareGUI() {
		inputSquare.setEnabled(false);
		squareInstructions.setVisible(false);
	}
	
	public void buttonClicked(JButton buttonObj) {
		size = (int)dimensionsInput.getNumber();
		if(buttonObj == inputDimensions) {
			if(size >= 3 && size <= 8 && dimensionsInput.getNumber() == (int)dimensionsInput.getNumber()) {
				fields = new DoubleField[size][size];
				for(int i = 0; i < size; i++) {
					for(int j = 0; j < size; j++) {
						fields[i][j] = addDoubleField(0, i+5,j+1,1,1);
					}
				}
				revalidate();
				inputSquare.setEnabled(true);
				squareInstructions.setVisible(true);
				inputDimensions.setEnabled(false);
				dimensionsInput.setEnabled(false);
			}
			else if(size == 2) {
				messageBox("There are actually no 2x2 Magic Squares!" + '\n' + "The numbers never add up correctly.");
				dimensionsInput.setNumber(0);
			}
			else if(dimensionsInput.getNumber() < 2 || dimensionsInput.getNumber() > 8){
				messageBox("You input a value that was not between" + '\n' +  "2 and 8, try again.");
				dimensionsInput.setNumber(0);
			}
			else if(dimensionsInput.getNumber() != (int)dimensionsInput.getNumber()) {
				messageBox("You input a decimal number," + '\n' + "try again.");
				dimensionsInput.setNumber(0);
			}
		}
		if(buttonObj == inputSquare) {
			//error checking individual fields
			validNumNeeded = (int) Math.pow(size, 2);
			for(int i = 0; i < size; i++) {
				for(int j = 0; j < size; j++) {
					if(fields[i][j].getNumber() > 0 && fields[i][j].getNumber() == (int)fields[i][j].getNumber())
						validNumCount++;
				}
			}
			if(validNumCount == validNumNeeded) { //output if magic square or not
				if(server.isMagicSquare(fields, size, constant, correctNeeded, correct) == true) {
					constant = (int)(size * ((Math.pow(size, 2) + 1) / 2));
					messageBox("Congratulations! You have entered a" + '\n' + "Magic Square with a constant of " + constant);
			}
				else {
					messageBox("Sorry, you did not enter a magic square" + '\n' + "Try again!");
					for(int i = 0; i < size; i++) { // reset all values to 0
						for(int j = 0; j < size; j++) {
							fields[i][j].setNumber(0);
						}
					}
				}
			}
			else {
				messageBox("Sorry, one or more of your inputs was" + '\n' + "invalid (must be positive integers)");
				for(int i = 0; i < size; i++) {
					for(int j = 0; j < size; j++) {
						fields[i][j].setNumber(0);
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		JFrame frm = new MagicSquareGUI();
		frm.setTitle("Magic Square");
		frm.setSize(800, 500);
		frm.setVisible(true);
	}

}


