package datatypes;

import exceptions.InvalidCounterException;

public class CounterImpl implements CounterADT {

	private int counter = 0;
	
	@Override
	public void setCounter(int val) throws InvalidCounterException {
		if(val < 0) {
			throw new InvalidCounterException("Cannot set Negative value");
		}
		
		this.counter = val;
	}

	@Override
	public void createCounter(int val) throws InvalidCounterException {
		if(val < 0) {
			throw new InvalidCounterException("Invalid counter value passed");
		}
		this.counter = val;
		
	}
	

	@Override
	public void increment() {
		this.counter++;
		
	}

	@Override
	public void decrement() throws InvalidCounterException {
		if(counter <=0 ) {
			throw new InvalidCounterException("Cannot decrement counter");
		}
		counter--;
	}

	@Override
	public boolean isZero() {

		return this.counter == 0;
	}

	@Override
	public int getValue() {
		
		return counter;
	}

	@Override
	public String toString() {
		return counter+"";
	}
}




