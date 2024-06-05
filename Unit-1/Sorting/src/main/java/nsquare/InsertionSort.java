package main.java.nsquare;

import main.java.SortAlgo;

public class InsertionSort implements SortAlgo {

	
	/**
	 * Class constructor
	 * */
	
	public InsertionSort() {
		System.out.println("Insertion Sort");
	}
	
	
	/**
	 * This method will sort the input array in non-decreasing order
	 * using insertion sort algorithm.
	 * 
	 * @param array		Integer array for sorting
	 * */
	
	@Override
	public void Sort(int[] array) {
		
		int n = array.length;
		
		
		// Loop from second index of list making array to the left of 'i' 
		// as sorted portion of array

		for(int i=1; i<n; i++) {
			
			// pick insertion element
			int element = array[i];
			
			int j=i;
			
			// loop from the end of the sorted portion of array and
			// insert the 'element' at the correct position.
			// To identify correct position we compare 'element' with all
			// the values of sorted portion and move all values bigger than 'element'
			// to right or array.
			while(j>0 && array[j-1] > element) {
				
				array[j] = array[j-1];
				
				j--;
			}
			// place 'element' at the correct index
			array[j] = element;
		}

	}

}
