package meanMedianMode;
/*
 * Paul Davis
 * 2/5/20
 * Mean Median Mode Insertion Sort Program
 */
import java.util.ArrayList;

public class MMMServer {
	public double calculateMean(int[] unsortedList, int count) {
		int sum = 0;
		for (int i = 0; i < count; i++) {
			sum += unsortedList[i];
		}

		return sum / count;
	}
	
	private double calculateMeanDouble(double[] list, int count) {
		double sum = 0;
		for (int i = 0; i < count; i++) {
			sum += list[i];
		}

		return sum / count;
	}

	public String calculateMedian(int[] sortedList, int count) {
		String medianString = "";
		
		if(count % 2 == 0) {
			medianString += (sortedList[count / 2 - 1] + sortedList[count / 2]) / 2.0;
		}
		else {
			medianString += sortedList[count / 2];
		}
		
		return medianString;
	}
	
	public double calculateStandardDeviation(int[] unsortedList, int count, double mean) {
		double[] standardDevArray = new double[count];
		
		for(int i = 0; i < count; i++) {
			standardDevArray[i] = Math.pow(unsortedList[i] - calculateMean(unsortedList, count), 2);
		}
		
		return Math.sqrt(calculateMeanDouble(standardDevArray, count));
	}
	
	public String calculateMode(int[] unsortedList, int count) { // stupid mode >:(
		String modeString = "";
		int currentMax = 1, potentialMax = 0, modeCount = 0;
		ArrayList<Integer> modes = new ArrayList<Integer>();
				
		for(int i = 0; i < count; i++) { // loop to find highest occuring number of any mode
			potentialMax = 0;
			for(int j = 0; j < count; j++) {	
				if(unsortedList[j] == unsortedList[i]) {
					potentialMax++;
				}
			}
			if(potentialMax > currentMax) 
				currentMax = potentialMax;
		}
		
		if(currentMax != 1) {
			for(int i = 0; i < count; i++) { // add modes to list
				modeCount = 0;
				for(int j = 0; j < count; j++) {
					if(unsortedList[j] == unsortedList[i]) {
						modeCount++;
						if(modeCount == currentMax) {
							modes.add(unsortedList[i]);
						}
					}
				}
			}
			
			for(int i = 0; i < modes.size(); i++) { // remove repeat values
				for(int j = i; j < modes.size(); j++) {
					if(modes.get(j) == modes.get(i)) {
						modes.remove(j);
					}
				}
			}
			
			for(int i = 0; i < modes.size(); i++) {
				modeString += modes.get(i) + " ";
			}
		}
		else {
			modeString = "There is no mode";
		}
		
		return modeString;
	}
}