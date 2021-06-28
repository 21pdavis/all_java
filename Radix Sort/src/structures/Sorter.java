package structures;

/*
 * Paul Davis
 * 2/5/2021
 * Radix Sort Program
 * This program takes in a list of integers and sorts them using radix sort and an array of queues
 */

import java.util.ArrayList;

public class Sorter {

	@SuppressWarnings("unchecked")
	public static ArrayList<String> radixSortList(ArrayList<String> unsortedList) {
		ArrayList<String> sortedList = new ArrayList<String>();
		ListQueue<String>[] queues = (ListQueue<String>[]) new ListQueue[10];
		String maxVal = "-1";

		for (int i = 0; i < queues.length; i++) {
			queues[i] = new ListQueue<String>();
		}

		// first pass through list (order by queue)
		for (int i = 0; i < unsortedList.size(); i++) {
			String num = unsortedList.get(i);
			int lastDigit = Character.getNumericValue(num.charAt(num.length() - 1));

			if (Integer.parseInt(num) > Integer.parseInt(maxVal)) // keep track of max num
				maxVal = num;

			queues[lastDigit].enqueue(num);
		}

		// i used to keep track of what position is being
		// compared by subtracting i + 1 from length
		for (int i = 1; i <= maxVal.toString().length(); i++) { 
			// iterate through individual queues
			for (int j = 0; j < queues.length; j++) { 
				ListQueue<String> tempQueue = new ListQueue<String>();

				// iterate until all queue items are moved into tempQueue or to
				// appropriate digit queue
				while (!queues[j].isEmpty()) { 
					String currentNum = queues[j].first();
					int currentDigit = -1;

					if (currentNum.length() - 1 - i >= 0) {
						currentDigit = Character.getNumericValue(currentNum.charAt(currentNum.length() - 1 - i));
					} else {
						currentDigit = 0;
					}

					if (currentNum.length() - i >= 0) {
						if (currentDigit == Character.getNumericValue(currentNum.charAt(currentNum.length() - i))) {
							queues[j].firstToLast();
						}
					}

					if (currentDigit == j) {
						tempQueue.enqueue(queues[j].dequeue());
					} else {
						queues[currentDigit].enqueue(queues[j].dequeue());
					}
				}
				// offload tempQueue back onto proper sorting queue
				while (!tempQueue.isEmpty()) {
					queues[j].enqueue(tempQueue.dequeue());
				}
			}
		}

		// parse sorted queue to ArrayList
		for (int i = 0; i < queues.length; i++) {
			while (!queues[i].isEmpty()) {
				sortedList.add(queues[i].dequeue());
			}
		}

		return sortedList;
	}
}
