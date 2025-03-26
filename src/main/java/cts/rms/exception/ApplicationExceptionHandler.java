package cts.rms.exception;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import cts.rms.dto.ApiException;
import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice // if ur rest controller has any exception that exception will be
					  // handled by the class annotated with @RestControllerAdvice
public class ApplicationExceptionHandler {
	@ExceptionHandler(exception = RestaurentIdNotFoundException.class)
	public ResponseEntity<?> handlerRestaurentIdNotFoundException(RestaurentIdNotFoundException ex,HttpServletRequest request){
				// This is the method going to handle the restaurentIdnotfoundexception
		System.out.println("inside the restaurent id not found exception");
		ApiException api=new ApiException(LocalDateTime.now(),request.getRequestURI(),ex.getMessage());
		return new ResponseEntity<>(api,HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler(exception = RestaurentNameNotExistsException.class)
	public ResponseEntity<?> handlerRestaurentIdNotFoundException(RestaurentNameNotExistsException ex,HttpServletRequest request){
				// This is the method going to handle the restaurentIdnotfoundexception
		System.out.println("inside the restaurent id not found exception");
		ApiException api=new ApiException(LocalDateTime.now(),request.getRequestURI(),ex.getMessage());
		return new ResponseEntity<>(api,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(exception = RestaurentNotUpdatedException.class)
	public ResponseEntity<?> handlerRestaurentNotUpdatedException(RestaurentNotUpdatedException ex,HttpServletRequest request){
				// This is the method going to handle the restaurentIdnotfoundexception
		System.out.println("inside the restaurent id not found exception");
		ApiException api=new ApiException(LocalDateTime.now(),request.getRequestURI(),ex.getMessage());
		return new ResponseEntity<>(api,HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler(exception = MethodArgumentNotValidException.class)
	public ResponseEntity<?> handlerMethodArgumentNotValidException(MethodArgumentNotValidException ex,HttpServletRequest request){
				// This is the method going to handle the restaurentIdnotfoundexception
		System.out.println("inside the restaurent id not found exception");
		List<FieldError> listOfError = ex.getFieldErrors();
		StringBuilder sb=new StringBuilder();
		for (FieldError fieldError : listOfError) {
			sb.append(fieldError.getField()+":"+fieldError.getDefaultMessage()+"||");
		}
		ApiException api=new ApiException(LocalDateTime.now(),request.getRequestURI(),sb.toString());
		
		return new ResponseEntity<>(api,HttpStatus.NOT_FOUND);
		
	}
}
