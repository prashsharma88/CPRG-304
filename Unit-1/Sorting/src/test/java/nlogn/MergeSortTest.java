package test.java.nlogn;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import main.java.nlogn.MergeSort;
import test.java.utilities.Utils;

@TestInstance(Lifecycle.PER_CLASS)
public class MergeSortTest {

	MergeSort mergesort_TestObject = null;
	int[] expected_array = {1,3,5,7,10,13,15,20,21,22};
	int[] actual_array = {3,5,1,20,7,13,15,22,21,10};
	static final String className = "main.java.nlogn.MergeSort";
	static final String methodName_split = "split";
	static final String methodName_merge = "merge";
	
	@BeforeAll
	public void Test_Setup() {
		mergesort_TestObject = new MergeSort();
	}
	
	@Test
	public void Test_Sort() {
		
		mergesort_TestObject.Sort(actual_array);
		
		Assertions.assertArrayEquals(expected_array, actual_array);
	}
	
	@Test
	public void Test_split() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		Class[] argClasses = new Class[2];
		
		argClasses[0] = Integer.TYPE.arrayType();
		argClasses[1] = Integer.TYPE;
		
		Method split_method = Utils.getMethod(className, methodName_split, argClasses);
		
		if(split_method != null) {
			split_method.invoke(mergesort_TestObject, actual_array, actual_array.length);
			Assertions.assertArrayEquals(expected_array, actual_array);
		} else {
			Assertions.assertTrue(false);
		}
	} 
	
	@Test
	public void Test_Merge() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class[] argClasses = new Class[5];
		
		argClasses[0] = Integer.TYPE.arrayType();
		argClasses[1] = Integer.TYPE.arrayType();
		argClasses[2] = Integer.TYPE.arrayType();
		argClasses[3] = Integer.TYPE;
		argClasses[4] = Integer.TYPE;
		
		int[] leftArray = {1,2,3,4,5};
		int[] rightArray = {6,7,8,9,10};
		int[] expectedArray = {1,2,3,4,5,6,7,8,9,10};
		int[] actualArray = new int[10];
		
		Method merge_method = Utils.getMethod(className, methodName_merge, argClasses);
		
		if(merge_method != null) {
			merge_method.invoke(mergesort_TestObject, actualArray, leftArray, rightArray,5,5);
			Assertions.assertArrayEquals(expectedArray, actualArray);
		} else {
			Assertions.assertTrue(false);
		}
	}
}
