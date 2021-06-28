package structures;

import java.util.ArrayList;

public class Sorter {
	private static ListQueue<String>[] queues;
	
	@SuppressWarnings("unchecked")
	public static ArrayList<String> radixSortList(ArrayList<String> unsortedList) {
		ArrayList<String> sortedList = new ArrayList<String>();
		queues = (ListQueue<String>[]) new ListQueue[10];
		String maxNum = "-1";
		
		for(int i = 0; i < queues.length; i++) {
			queues[i] = new ListQueue<String>();
		}

		// first pass through list (order by queue)
		for (int i = 0; i < unsortedList.size(); i++) {
			String num = unsortedList.get(i);
			int lastDigit = Character.getNumericValue(num.charAt(num.length() - 1));

			if(Integer.parseInt(num) > Integer.parseInt(maxNum)) // keep track of max num
				maxNum = num;
			
			queues[lastDigit].enqueue(num);
		}
		
		printArray();
		
		for(int i = 1; i <= maxNum.toString().length(); i++) {// digit place tracking (length - 1 because first pass is done at this point)
			for(int j = 0; j < queues.length; j++) { // queue tracking
				ListQueue<String> tempQueue = new ListQueue<String>();
				
				while(!queues[j].isEmpty()) {
				//for(int k = 0; k < queues[j].size(); k++) {
					String currentNum = queues[j].first();
					int currentDigit = -1;
					
					if(currentNum.length() - 1 - i >= 0) {
						currentDigit = Character.getNumericValue(currentNum.charAt(currentNum.length() - 1 - i)); 
					}
					else {
						currentDigit = 0;
					}
					
					//System.out.println(currentNum + " " + j + currentDigit);
//					if(currentDigit == Character.getNumericValue(currentNum.charAt(currentNum.length() - i))) {
//						System.out.println(queues[j].toString());
//						queues[j].firstToLast();
//					}
					
					if(currentDigit == j) {
						tempQueue.enqueue(queues[j].dequeue());
					}
					else {
						queues[currentDigit].enqueue(queues[j].dequeue());
					}
				}
				
				// offload tempQueue back onto proper sorting queue
				while(!tempQueue.isEmpty()) {
					queues[j].enqueue(tempQueue.dequeue());
				}
			}
			printArray();
		}
		
		
		// parse sorted queue to ArrayList
		for(int i = 0; i < queues.length; i++) {
			while(!queues[i].isEmpty()) {
				sortedList.add(queues[i].dequeue());
			}
		}
		
		return sortedList;
	}

	public static void printArray() {
		for(int i = 0; i < queues.length; i++) {
			System.out.println(i + "s: ");
			System.out.println(queues[i].toString());
		}
		System.out.println('\n' + "///BREAK///" + '\n');
	}
}
