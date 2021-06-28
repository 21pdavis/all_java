package meanMedianMode;
/*
 * Paul Davis
 * 2/5/20
 * Mean Median Mode Insertion Sort Program
 */
import javax.swing.*;
import BreezySwing.*;
import java.util.ArrayList;

@SuppressWarnings({"serial", "unused"})
public class MMMGUI extends GBFrame {
	private static JFrame frm = new MMMGUI();
	private MMMServer server = new MMMServer();
	private int count = 0;
	private int[] unsortedList = new int[25];
	private int[] sortedList = new int[25]; // use this list to copy it over first, THEN do the sorting. sort within ONE array
	private String[] inputArray;
	private JLabel inputNumLabel = addLabel("Input Number Array (separate with commas):", 1,1,1,1);
	private JTextField inputTextField = addTextField("", 1,2,1,1);
	private JButton inputArrayButton = addButton("Input Numbers", 2,1,1,1);
	private JLabel outputInstructionsLabel = addLabel("Outputs:", 3,1,1,1);
	private JButton meanButton = addButton("Mean", 4,1,1,1);
	private JButton medianButton = addButton("Median", 5,1,1,1);
	private JButton modeButton = addButton("Mode", 6,1,1,1);
	private JButton standardDevButton = addButton("Standard Deviation", 7,1,1,1);
	private JButton displayButton = addButton("Display Array", 8,1,1,1);
	private JButton exitButton = addButton("Exit", 9,1,1,1);
	private JButton resetButton = addButton("Reset", 10,1,1,1);
	
	public MMMGUI() {
		meanButton.setEnabled(false);
		medianButton.setEnabled(false);
		modeButton.setEnabled(false);
		standardDevButton.setEnabled(false);
	}
	
	public void buttonClicked(JButton buttonObj) {
		if(buttonObj == inputArrayButton) {
			initArrays();
		}
		if(buttonObj == meanButton) {
			messageBox("Mean: " + server.calculateMean(unsortedList, count));
		}
		if(buttonObj == medianButton) {
			messageBox("Median(s): " + server.calculateMedian(sortedList, count));
		}
		if(buttonObj == modeButton) {
			messageBox("Mode(s): " + server.calculateMode(unsortedList, count));
		}
		if(buttonObj == standardDevButton) {
			messageBox("Standard Deviation: " + server.calculateStandardDeviation(unsortedList, count, server.calculateMean(unsortedList, count)));
		}
		if(buttonObj == displayButton) {
			messageBox("Sorted Array: " + toArray());
		}
		if(buttonObj == exitButton) {
			System.exit(0);
		}
		if(buttonObj == resetButton) {
			resetFrame();
			messageBox("Program Reset");
		}
	}
	
	private void initArrays() {
		boolean errorFound = false;
		enableButtons();
		inputArray = inputTextField.getText().split(",");
		count = inputArray.length;
		for(int i = 0; i < inputArray.length; i++) {
				inputArray[i] = inputArray[i].trim();
			try {
				unsortedList[i] = Integer.parseInt(inputArray[i]);
			}
			catch(ArrayIndexOutOfBoundsException e) {
				messageBox("Input only up to 25 numbers" + '\n' + "Message: " + e.getMessage());
				resetFrame();
				errorFound = true;
			}
			catch(NumberFormatException e) {
				messageBox("Input only whole numbers and commas" + '\n' + "Message: " + e.getMessage());
				resetFrame();
				errorFound = true;
			}
		}
		if(errorFound == false) {
			sortedList = sortArray(unsortedList);
			messageBox("Array Successfully Updated");
		}
	}
	
	private int[] sortArray(int[] unsortedList) {
		for (int i = 1; i < count; i++){
            int key = unsortedList[i];
            int j = i-1;  
            
            while (j > -1 && unsortedList[j] > key) {
            	unsortedList[j+1] = unsortedList[j];  
                j--;  
            }  
            unsortedList[j+1] = key; 
        }  
		return unsortedList;
	}
	
	private String toArray() {
		String toString = "";
		for(int i = 0; i < count; i++) {
			toString += sortedList[i] + " ";
		}
		return toString;
	}
	
	private void enableButtons() {
		meanButton.setEnabled(true);
		medianButton.setEnabled(true);
		modeButton.setEnabled(true);
		standardDevButton.setEnabled(true);
	}
	
	private void resetFrame() {
		for(int i = 0; i < count; i++)
		{
			unsortedList[i] = 0;
			sortedList[i] = 0;
		}
		inputTextField.setText("");
		meanButton.setEnabled(false);
		medianButton.setEnabled(false);
		modeButton.setEnabled(false);
	}
	
	public static void main(String[] args) {
		frm.setTitle("Mean Median Mode");
		frm.setSize(600, 500);
		frm.setVisible(true);
	}
}