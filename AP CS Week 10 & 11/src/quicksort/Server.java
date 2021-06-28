package quicksort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Server {
	public static ArrayList<Integer> getArray(String inputString) {
		// Converts input string to arraylist of strings
		boolean errorFound = false;
		ArrayList<String> strings = new ArrayList<String>(Arrays.asList(inputString.split("\\s*,\\s*")));
		ArrayList<Integer> ints = new ArrayList<Integer>();

		// parse "strings" ArrayList to "ints" ArrayList
		for (String s : strings) {
			ints.add(Integer.parseInt(s));
			if(ints.size() == 11) {
				errorFound = true;
				break;
			}
		}
		
		if(errorFound == false)
			return ints;
		else
			return null;
	}
	
	

	private static int partition(ArrayList<Integer> nums, int low, int high) {
		int pivot = nums.get(low + (high - low) / 2);
		int i = low, j = high;
		
		while (i <= j) {
			while (nums.get(i) > pivot)
				i++;
			while (nums.get(j) < pivot)
				j--;
			if (i <= j) {
				Collections.swap(nums, i, j);
				i++;
				j--;
			}
		};
		
		return i;
	}

	/*
	 * The main function that implements QuickSort() arr[] --> Array to be sorted,
	 * low --> Starting index, high --> Ending index
	 */
	public static void sort(ArrayList<Integer> nums, int low, int high) {
		if (low < high) {
			/*
			 * pi is partitioning index, arr[pi] is now at right place
			 */
			int pi = partition(nums, low, high);
			
			if(low < pi - 1)
				sort(nums, low, pi - 1);
			if(pi < high)
				sort(nums, pi, high);
		}
	}

}
