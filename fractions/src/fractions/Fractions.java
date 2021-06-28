package fractions;

import javax.swing.*;
import BreezySwing.*;

public class Fractions extends GBFrame {
	//fraction1 fields/labels
	JLabel fraction1 = addLabel("First Fraction:", 1,1,1,1);
	IntegerField fraction1Num = addIntegerField(0, 1,2,1,1);
	JLabel fraction1Slash = addLabel("/", 1,3,1,1);
	IntegerField fraction1Denom = addIntegerField(0, 1,4,1,1);
	//fraction2 fields/labels
	JLabel fraction2 = addLabel("Second Fraction:", 2,1,1,1);
	IntegerField fraction2Num = addIntegerField(0, 2,2,1,1);
	JLabel fraction2Slash = addLabel("/", 2,3,1,1);
	IntegerField fraction2Denom = addIntegerField(0, 2,4,1,1);
	//reset button to start program over
	JButton resetButton = addButton("Reset", 4,1,1,1);
	//Multiply/errorchecking button
	JButton multiplyButton = addButton("Multiply", 3,1,1,1);
	//output fields/labels
	JLabel output = addLabel("Output:", 6,1,1,1);
	JLabel negative = addLabel("", 6,2,1,1);
	JTextField outputFraction = addIntegerField(0, 6,3,1,1);
	
	public void buttonClicked(JButton buttonObj) {
		int gcf = 1, numerator1 = fraction1Num.getNumber(), numerator2 = fraction2Num.getNumber(),
				denominator1 = fraction1Denom.getNumber(), denominator2 = fraction2Denom.getNumber(), productNum, productDenom;
		boolean validIntegers= true, validDenoms = true, oneNegative = false, bothNegative = false;
		if(buttonObj == multiplyButton) {			
			//errorcheck for integers
			if(numerator1 == (int)numerator1 && numerator2 == (int)numerator2 && denominator1 == (int)denominator1 &&
					denominator2 == (int)denominator2)
				validIntegers = true;
			else
				validIntegers = false;
						
			//errorcheck for denominators
			if(denominator1 != 0 && denominator2 != 0)
				validDenoms = true;
			else
				validDenoms = false;
			
			//output error message
			if(validIntegers == false || validDenoms == false) {
				messageBox("Error in input, press reset to try again");
				multiplyButton.setEnabled(false);
			}
			
			//begin multiplication
			else if(validIntegers == true && validDenoms == true) {
				productNum = numerator1 * numerator2;
				productDenom = denominator1 * denominator2;
				//find gcf
				for(int i = 1; i <= Math.abs(productNum) && i <= Math.abs(productDenom); i++) {
					if(productNum % i == 0 && productDenom % i == 0)
						gcf = i;
				}
				//reduce fraction
				productNum /= gcf;
				productDenom /= gcf;
				
				//determine how many outputs are negative
				if(productNum < 0 && productDenom > 0 || productNum > 0 && productDenom < 0) {
					oneNegative = true;
					negative.setText("-");
				}
				if(productNum < 0 && productDenom < 0) 
					bothNegative = true;
				
				//printing final output
				if(oneNegative == true) {
					outputFraction.setText("-" + Math.abs(productNum) + "/" + Math.abs(productDenom));
				}
				else if(bothNegative == true) {
					outputFraction.setText("" + Math.abs(productNum) + "/" + Math.abs(productDenom));
				}
				else {
					outputFraction.setText("" + productNum + "/" + productDenom);
				}
			}
		}
		
		if(buttonObj == resetButton) {//reset button code
			negative.setText("");
			multiplyButton.setEnabled(true);
			fraction1Num.setNumber(0);
			fraction2Num.setNumber(0);
			fraction1Denom.setNumber(0);
			fraction2Denom.setNumber(0);
			outputFraction.setText("");
		}
	}
	
	public static void main(String[] args) {//class to set up window
		JFrame frm = new Fractions();
		frm.setTitle("Fractions Multiplier");
		frm.setSize(600, 400);
		frm.setVisible(true);
	}

}









