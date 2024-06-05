package main.java.nsquare;

import main.java.SortAlgo;
import main.java.utilities.Utils;


public class SelectionSort implements SortAlgo {

	
	public SelectionSort() {
		System.out.println("Selection Sort");
	}
	
	/**
	 * This method takes an input array and sort it in non-decreasing order 
	 * using selection sort
	 * 
	 * @param array		Array of elements to sort
	 * */
	@Override
	public void Sort(int[] array) {
		
		int n = array.length;
		
		// Loop from 0 till the second last index of array.
		// we leave last index because after that there is no element.
		for(int i = 0; i < array.length-1; i++) {
			
			int minIdx = i; // selecting value at 'i' index is minimum value
			
			// Loop from 'i+1' to the end of list to check if value at 'i' is
			// actually minimum, if not update 'minIdx' to store the index of
			// minimum value.
			for(int j = i+1; j < n; j++) {
				if(array[j] < array[minIdx]) {
					minIdx = j;
				}
			}
			
			// Swap the value at 'minIdx' with 'i'
			Utils.swap(array, minIdx, i);
		}
	}
	
	
}
