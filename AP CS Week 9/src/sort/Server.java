package sort;

public class Server {
	public static int[] getArray(String arr) {
		String[] stringArr = arr.split("\\s*, \\s*");
		int[] intArr = new int[stringArr.length];

		for (int i = 0; i < stringArr.length; i++) {
			intArr[i] = Integer.parseInt(stringArr[i]);
		}

		return intArr;
	}

	public static int binarySearch(int[] arr, int l, int r, int key) {
		if (r >= l) {
			int midPoint = l + (r - 1) / 2;

			if (arr[midPoint] == key)
				return midPoint;

			if (arr[midPoint] > key)
				return binarySearch(arr, l, midPoint - 1, key);

			return binarySearch(arr, midPoint + 1, r, key);
		}
		return -1;
	}

	// Main function that sorts arr[left..r] using
	// merge()
	public static int[] sort(int arr[], int left, int r) {
		int[] sortedArray;
		if (left < r) {
			// Find the middle point
			int m = (left + r) / 2;

			// Sort first and second halves
			sort(arr, left, m);
			sort(arr, m + 1, r);

			// Merge the sorted halves
			sortedArray = merge(arr, left, m, r);
		}
		return arr;
	}

	// Merges two subarrays of arr[].
	// First subarray is arr[left..m]
	// Second subarray is arr[m+1..r]
	public static int[] merge(int arr[], int left, int m, int r) {
		// Find sizes of two subarrays to be merged
		int n1 = m - left + 1;
		int n2 = r - m;

		/* Create temp arrays */
		int L[] = new int[n1];
		int R[] = new int[n2];

		/* Copy data to temp arrays */
		for (int i = 0; i < n1; ++i)
			L[i] = arr[left + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arr[m + 1 + j];

		/* Merge the temp arrays */
		// Initial indexes of first and second subarrays
		int i = 0, j = 0;
		// Initial index of merged subarray array
		int k = left;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		/* Copy remaining elements of L[] if any */
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		/* Copy remaining elements of R[] if any */
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
		return arr;
	}
}
