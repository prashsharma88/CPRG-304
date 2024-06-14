package main.java.utilities;

import java.util.Random;

public class Utils {

	
	/**
	 * Utility method to swap two elements at 'index1' and 'index2' in an array
	 * 
	 * @param array		Array of elements
	 * @param index1	Index of first element
	 * @param index2	Index of second element
	 * */
	
	public static void swap(int[] array, int index1, int index2) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
	
	/**
	 * Method to print an array
	 * 
	 * @param array		Array to print
	 * */
	
	public static void printArray(int[] array) {
		for(int i : array) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	
	/**
	 * This method will return a random integer between 0 and range provided
	 * 
	 * @param range		Upper limit for selecting the random integer.
	 * */
	public static int getRandomInt(int range) {
		return (new Random()).nextInt(range);
	}
	
}
