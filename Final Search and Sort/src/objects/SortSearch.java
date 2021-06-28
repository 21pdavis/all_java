package objects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SortSearch {
	public static ArrayList<Comparable> selectionSort(ArrayList<Comparable> list){
		int l = list.size();
		for(int i = 0; i < l - 1; i++) {
			int minIndex = i;
			for(int j = i + 1; j < l; j++) {
				if(list.get(j).compareTo(list.get(minIndex)) < 0) {
					minIndex = j;
				}
			}
			Collections.swap(list, minIndex, i);
		}
		return list;
	}
	
	public static ArrayList<Comparable> insertionSort(ArrayList<Comparable> list){
		int l = list.size();
		for(int i = 1; i < l; i++) {
			Comparable key = list.get(i);
			int j = i - 1;
			
			while(j >= 0 && list.get(j).compareTo(key) < 0) {
				list.set(j + 1, list.get(j));
				j = j - 1;
			}
			list.set(j + 1, key);
		}
		return list;
	}
	
	public static ArrayList<Comparable> binarySearch(ArrayList<Comparable> list, Object key){
		ArrayList<Comparable> results = new ArrayList<Comparable>();
		ArrayList<Comparable> tempList = new ArrayList<Comparable>();
		for(int i = 0; i < list.size(); i++) {
			tempList.add(list.get(i));
		}
		
		int lBound = 0, uBound = tempList.size() - 1;
		
		while(lBound <= uBound) {
			int midIndex = lBound + (uBound - 1) / 2;

			if(tempList.get(midIndex).compareTo(key) == 0) {
				results.add(tempList.get(midIndex));
				tempList.remove(midIndex);
			}

			if(tempList.get(midIndex).compareTo(key) < 0) 
				lBound = midIndex + 1;
			else 
				uBound = midIndex - 1;
		}
		return results;
	}
	
	public static ArrayList<Comparable> sequentialSearch(ArrayList<Comparable> list, Object key){
		ArrayList<Comparable> results = new ArrayList<Comparable>();
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).compareTo(key) == 0) {
				results.add(list.get(i));
			}
		}
		return results;
	}
}