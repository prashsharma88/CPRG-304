package datatypes;

import exceptions.InvalidCounterException;

public interface CounterADT {


	/**
	 * This method will set the value of counter to 'val'
	 * 
	 * @param val		Value to set to counter
	 * @exception		Throws an InvalidCounterException if 'val' is negative
	 * */
	
	public void setCounter(int val) throws InvalidCounterException;
	
	/**
	 * This method will initialize the value of counter to provided 'val'.
	 * If the given value of a long or double, this method  will discard the decimal portion of the value.
	 * 
	 * @param val		Optional: Values to initialize the counter, default is zero
	 * @exception		Throws an InvalidCounterException if 'val' is negative
	 * */
	
	public void createCounter(int val) throws InvalidCounterException;
	
	/**
	 * Method will increase the value of counter by one
	 * */

	public void increment();
	
	
	/**
	 * Method will decrease the value of counter by one.
	 * 
	 * @exception	InvalidCounterException, if the value of counter goes negative
	 * 				after decrement then it will throw InvalidCounterException.
	 * */
	
	public void decrement() throws InvalidCounterException;
	
	/**
	 * Method to check whether the value of counter is zero or not.
	 * 
	 * @return		True: If value of counter is equal to zero.
	 * 				False: If the value of counter is not equal to zero.
	 * */
	
	public boolean isZero();
	
	/**
	 * Method returns the current value of counter
	 * 
	 * @return		Current value of counter
	 * */
	
	public int getValue();
	
	
	/**
	 * Method returns the value of counter in String format
	 * 
	 * @return		Current value of counter in String format
	 * */
	
	public String toString();
}























