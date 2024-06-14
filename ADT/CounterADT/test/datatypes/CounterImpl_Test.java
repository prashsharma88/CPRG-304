package datatypes;

import java.lang.reflect.Field;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import Untility.ReflectionUtil;
import exceptions.InvalidCounterException;

public class CounterImpl_Test {
	
	CounterImpl counterObject = null;
	
	final String COUNTER_CLASS_NAME = "datatypes.CounterImpl";
	final String COUNTER_FIELD_NAME = "counter";
	
	@BeforeAll
	public static void setup() {
		// Try to run time consuming task in setup method.
		// This method will be executed once before running any test case
	}
	
	@AfterAll
	public static void Teardown() {
		// Release all the resources you have allocated.
		// This method will be executed once after running all the test cases.
	}

	@BeforeEach
	public void setup_TestCase() {
		counterObject = new CounterImpl();
	}
	
	@AfterEach
	public void teardown_TestCase() {
		counterObject = null;
	}
	
	
	/**
	 * 1.) Test a valid scenario. (Test_setCounter_ValidValue)
	 * 2.) Test edge cases.
	 * 3.) Test an invalid input (negative int, double) // the expected behavior is to throw a exception.
	 * 4.) 
	 * */
	
	@Test
	public void Test_createCounter_ValidValue() throws InvalidCounterException, IllegalArgumentException, IllegalAccessException {
		CounterImpl counterObj = new CounterImpl();
		
		counterObj.createCounter(0);
		Field actual = ReflectionUtil.getField(COUNTER_CLASS_NAME, COUNTER_FIELD_NAME);
		Assertions.assertEquals(0, actual.getInt(counterObj));
	}

	@Test
	public void Test_createCounter_edgeCase() throws InvalidCounterException, IllegalArgumentException, IllegalAccessException {
		CounterImpl counterObj = new CounterImpl();
		
		counterObj.createCounter(Integer.MAX_VALUE);
		Field actual = ReflectionUtil.getField(COUNTER_CLASS_NAME, COUNTER_FIELD_NAME);
		Assertions.assertEquals(Integer.MAX_VALUE, actual.getInt(counterObj));
	}

	@Test
	public void Test_createCounter_InvalidInput() {
		CounterImpl counterObj = new CounterImpl();
		
		/*
		 * Assertions.assertThrows() takes 2 parameters
		 * 1.) Class of exception that is expected to be thrown 
		 * 2.) An executable object with code to test
		 * 
		 * This assertion will fail if:
		 * 1.) No exception is thrown
		 * 2.) Exception of different type is thrown.
		 * */
		
		Exception exception = Assertions.assertThrows(InvalidCounterException.class, ()-> {
			(new CounterImpl()).createCounter(-1);
		});
		
		Assertions.assertEquals("Invalid counter value passed", exception.getMessage());
	}
	
	
	@ParameterizedTest
	@ValueSource(ints = {1,0,-1,Integer.MAX_VALUE, Integer.MIN_VALUE})
	void Test_setCounter(int value) throws InvalidCounterException, IllegalArgumentException, IllegalAccessException {
		Field actual;
		Exception exception;
		switch(value) {
		case 0:
			counterObject.setCounter(value);
			actual = ReflectionUtil.getField(COUNTER_CLASS_NAME, COUNTER_FIELD_NAME);
			
			Assertions.assertEquals(value, actual.getInt(counterObject));
			break;
		case 1:
			counterObject.setCounter(value);
			actual = ReflectionUtil.getField(COUNTER_CLASS_NAME, COUNTER_FIELD_NAME);
			
			Assertions.assertEquals(value, actual.getInt(counterObject));
			break;
		case -1:
			exception = Assertions.assertThrows(InvalidCounterException.class, ()-> {
				(new CounterImpl()).setCounter(value);
			});
			
			Assertions.assertEquals("Cannot set Negative value", exception.getMessage());
			break;
			
		case Integer.MAX_VALUE:
			counterObject.setCounter(value);
			actual = ReflectionUtil.getField(COUNTER_CLASS_NAME, COUNTER_FIELD_NAME);
			
			Assertions.assertEquals(value, actual.getInt(counterObject));
			break;
			
		case Integer.MIN_VALUE:
			exception = Assertions.assertThrows(InvalidCounterException.class, ()-> {
				(new CounterImpl()).setCounter(value);
			});
			
			Assertions.assertEquals("Cannot set Negative value", exception.getMessage());
			break;
		}
	}

}
