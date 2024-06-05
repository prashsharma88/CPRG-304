package main.java.nlogn;

import main.java.SortAlgo;

public class MergeSort implements SortAlgo{

	public MergeSort() {
		System.out.println("Merge Sort");
	}
	
	@Override
	public void Sort(int[] array) {
		
		split(array, array.length);
		
		
	}
	
	/**
	 * Split the input array in two equal half and create 2 sub array
	 * 
	 * @param array		Array of elements need to be sorted
	 * @param n			Size of input array
	 * */
	
	private void split(int[] array, int n) {
		if(n<2) return;
		
		int mid = n/2;
		
		int[] leftArray = new int[mid];
		int[] rightArray = new int[n-mid];
		
		for(int i=0; i<mid; i++)
			leftArray[i] = array[i];
		
		for(int i=0; i<n-mid; i++) 
			rightArray[i] = array[mid+i];
		
		split(leftArray, mid);
		split(rightArray, n-mid);
		
		merge(array, leftArray, rightArray, mid, n-mid);
	}
	
	
	/**
	 * Merge two array 'leftArray and rightArray and store the result in 'array'
	 * 
	 * @param array			Store the elements after merging 2 arrays
	 * @param leftArray		First array to be merged in non-decreasing order
	 * @param rightArray	Second array to be merged in non-decreasing order
	 * @param leftSize		Size of left array
	 * @param rightSize		Size of right array
	 * */
	
	private void merge(int[] array, int[] leftArray, int[] rightArray, int leftSize, int rightSize) {
		int i = 0, j = 0, k = 0;
		
		while(i<leftSize && j<rightSize) {
			if(leftArray[i] < rightArray[j]) {
				array[k++] = leftArray[i++];
			} else {
				array[k++] = rightArray[j++];
			}
		}
		
		while(i<leftSize) {
			array[k++] = leftArray[i++];
		}
		
		while(j<rightSize) {
			array[k++] = rightArray[j++];
		}
	}

}
