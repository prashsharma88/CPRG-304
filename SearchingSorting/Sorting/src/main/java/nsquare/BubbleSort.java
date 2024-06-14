package main.java.nsquare;

import main.java.SortAlgo;
import main.java.utilities.Utils;

public class BubbleSort implements SortAlgo {

	public BubbleSort() {
		System.out.println("Bubble Sort");
	}
	
	/**
	 * This method takes an input array and sort it in non-decreasing order 
	 * using bubble sort algorithm
	 * 
	 * @param array		Array of elements to sort
	 * */
	@Override
	public void Sort(int[] array) {
		int n = array.length;
		
		// Loop from starting index to second last element
		for(int i=0; i<n; i++) {
			
			// Loop from starting index till the unsorted porting of array.
			// At each index compare if value at index'j' is bigger than
			// value at next index 'j+1', if true, swap them.
			for(int j=0; j<n-i-1; j++) {
				if(array[j] >= array[j+1]) {
					Utils.swap(array, j, j+1);
				}
			}
		}
		
	}
	
}
