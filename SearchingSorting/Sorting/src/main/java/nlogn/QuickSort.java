package main.java.nlogn;

import main.java.SortAlgo;
import main.java.utilities.Utils;

public class QuickSort implements SortAlgo{
	
//	boolean variable to switch between last element as pivot and 
//	random element as pivot implementation of quick sort
	private boolean last_element_pivot = true;

	
	public QuickSort() {
		System.out.println("QuickSort");
	}
	
	
	
	/**
	 * Method to set boolean variable 'last_element_pivot' to switch between the two
	 * implementation of quick-sort.
	 * */
	public void setLastElementPivot(boolean value) {
		last_element_pivot = value;
	}
	
	
	
	/**
	 * This method will call the quick-sort method depending on the value of 
	 * 'last_element_pivot' variable.
	 * 
	 * @param array		Integer array to be sorted.
	 * */
	
	@Override
	public void Sort(int[] array) {
		if(last_element_pivot)
			quicksort_lastPivot(array, 0, array.length-1);
		else
			quicksort_randomPivot(array, 0, array.length-1);
	}

	
	
	
	/**
	 * Recursive method to sort a input array using quick-sort algorithm.
	 * This implementation of quick sort selects the last element as pivot element
	 * 
	 * @param array		Array of elements to sort
	 * @param start		Starting index of array
	 * @param end		Last index of the array (inclusive)
	 * */
	
	private void quicksort_lastPivot(int[] array, int start, int end) {
		
		if(start>=end) return;	// Termination condition: if the array size is of 1 element then no need to sort.
		
		// Select last element as the pivot element
		
		int pivot = array[end];
		
		int leftpointer = start, rightpointer = end;
		
		while(leftpointer < rightpointer) {
			
			while(array[leftpointer] <= pivot && leftpointer < rightpointer) {
				leftpointer++;
			}
			
			while(array[rightpointer] >= pivot && rightpointer > leftpointer) {
				rightpointer--;
			}
			
			Utils.swap(array, leftpointer, rightpointer);
		}
		
		Utils.swap(array, leftpointer, end);
		
		quicksort_lastPivot(array, start, leftpointer-1);
		quicksort_lastPivot(array, leftpointer+1, end);
	}
	
	/**
	 * Recursive method to sort a input array using quic-ksort algorithm.
	 * This implementation of quick sort selects a random element as pivot element
	 * 
	 * @param array		Array of elements to sort
	 * @param start		Starting index of array
	 * @param end		Last index of the array (inclusive)
	 * */
	
	private void quicksort_randomPivot(int[] array, int start, int end) {
		
		if(start>=end) return;	// Termination condition: if the array size is of 1 element then no need to sort.
		
		// Code to select a random element as pivot element.
		int pivotIndex = Utils.getRandomInt(end-start) + start;
	
		int pivot = array[end];
		
		Utils.swap(array, pivotIndex, end);

		int leftpointer = start, rightpointer = end;
		
		while(leftpointer < rightpointer) {
			
			while(array[leftpointer] <= pivot && leftpointer < rightpointer) {
				leftpointer++;
			}
			
			while(array[rightpointer] >= pivot && rightpointer > leftpointer) {
				rightpointer--;
			}
			
			Utils.swap(array, leftpointer, rightpointer);
		}
		
		Utils.swap(array, leftpointer, end);
		
		quicksort_randomPivot(array, start, leftpointer-1);
		quicksort_randomPivot(array, leftpointer+1, end);
	}

}
