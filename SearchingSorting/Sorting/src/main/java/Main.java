package main.java;

import main.java.nlogn.*;
import main.java.nsquare.*;
import main.java.utilities.*;

public class Main {
	
	public static void main(String[] args) {
		
		benchMark_QuickSort();
		
		SelectionSort sSort = new SelectionSort();
		testSorting(sSort);
		
		BubbleSort bSort = new BubbleSort();
		testSorting(bSort);
		
		InsertionSort iSort = new InsertionSort();
		testSorting(iSort);
		
		MergeSort mSort = new MergeSort();
		testSorting(mSort);
		
	}
	
	/**
	 * This method will do multiple iteration of QuickSort to bench mark its performance
	 * It will first perform 'runCount' iterations of last_element_pivot implementation
	 * then 'runCount' iterations for random_element_pivot implementation
	 * */
	
	private static void benchMark_QuickSort() {
		QuickSort qsObj = new QuickSort();
		long lastElementPivotTime = 0;
		int runCount = 100;
		qsObj.setLastElementPivot(true);
		for(int i=0; i<runCount; i++) {
			lastElementPivotTime += runQuickSort(qsObj);
		}
		
		long randomElementPivotTime = 0;
		qsObj.setLastElementPivot(false);
		for(int i=0; i<runCount; i++) {
			randomElementPivotTime += runQuickSort(qsObj);
		}
		
		System.out.println("Average Time when selecting last element as pivot:    " + lastElementPivotTime/runCount);
		System.out.println("Average Time when selecting random element as pivot : " + randomElementPivotTime/runCount);
		System.out.println("---------------------------------------------------------------");
	}
	
	
	
	/**
	 * This method will run execute the sort method of quick-sort class.
	 * passing an array of 10000 random values between 0-1000
	 * 
	 * @param qsObj		Object of {@code} QuickSort Class
	 * 
	 * @return long		Run time of quick-sort.
	 * */
	private static long runQuickSort(QuickSort qsObj) {
		int[] arr = new int[10000];
		
		for(int i=0; i<10; i++) {
			arr[i] = Utils.getRandomInt(1000);
		}
		
		long startTime = System.currentTimeMillis();
		
		qsObj.Sort(arr);
		
		long endTime = System.currentTimeMillis();
		
		return endTime-startTime;
	}
	
	
	
	/**
	 * This method will execute the Sort method for the provided SortAlgo object
	 * */
	
	private static void testSorting(SortAlgo sortObj) {
		int[] array = new int[10];
		for(int i=0; i<10; i++) {
			array[i] = Utils.getRandomInt(100);
		}
		
		System.out.print("Unsorted Array: ");
		Utils.printArray(array);
		sortObj.Sort(array);
		System.out.print("Sorted Array:   ");
		Utils.printArray(array);
		
		System.out.println("\n---------------------------------------------------------------");
	}
}












