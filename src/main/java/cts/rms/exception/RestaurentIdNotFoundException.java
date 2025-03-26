package cts.rms.exception;

public class RestaurentIdNotFoundException extends RuntimeException{
	
	public RestaurentIdNotFoundException(String message) {
		super(message); // one arg cons Runtime Exception
	}

}
