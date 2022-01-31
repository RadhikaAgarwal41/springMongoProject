package com.example.demo.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler{
	
	
	@ExceptionHandler(Exception.class)
	  public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
	    
	    return new ResponseEntity<>(new ApiError( ex.getMessage(), HttpStatus.BAD_REQUEST, LocalDateTime.now()) , HttpStatus.INTERNAL_SERVER_ERROR);
	  }

	@ExceptionHandler(StudentNotFound.class)
	public ResponseEntity<Object> handleStudentNotFound(StudentNotFound ex, WebRequest req)
	{
		return new ResponseEntity<Object>(new ApiError(ex.getMessage(), HttpStatus.NOT_FOUND ,LocalDateTime.now()) ,HttpStatus.NOT_FOUND);
				
		
	}
	
	@Override
	protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest req)
	{
		return new ResponseEntity<Object>(new ApiError(ex.getMessage(), HttpStatus.NOT_FOUND ,LocalDateTime.now()) ,HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(InvalidAge.class)
	public ResponseEntity<Object> handleInvalidAge(InvalidAge ex, WebRequest req)
	{
		return new ResponseEntity<Object>(new ApiError(ex.getMessage(), HttpStatus.BAD_REQUEST ,LocalDateTime.now()) ,HttpStatus.BAD_REQUEST);
				
		
	}
	
	
	/*@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex , WebRequest request) {

       // ex.getBindingResult(): extract the bind result for default message. 
         String errorResult = ex.getBindingResult().toString();
   ApiError exc = new ApiError(errorResult , HttpStatus.BAD_REQUEST, LocalDateTime.now());

    return new ResponseEntity<Object>(exc, HttpStatus.BAD_REQUEST);
    }*/
	
	
	
	
}
