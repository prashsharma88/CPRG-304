package exceptions;

public class InvalidCounterException extends Exception{
	
	public InvalidCounterException() {
	
	}
	
	public InvalidCounterException(String message) {
		super(message);
	}

}
