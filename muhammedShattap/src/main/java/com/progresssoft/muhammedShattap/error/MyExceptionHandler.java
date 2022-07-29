package com.progresssoft.muhammedShattap.error;

import java.util.List;

import org.apache.derby.client.am.SqlException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class MyExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(DealNotFound.class)
	public  ResponseEntity<ErrorMessage>  dealNotFoundException(DealNotFound dealNotFoundException,WebRequest request) {
		ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND,dealNotFoundException.getMessage());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
		
	}
	
	
	@ExceptionHandler(DealExsist.class)
	public  ResponseEntity<ErrorMessage>  dealExsistException(DealExsist dealExsist,WebRequest request) {
		ErrorMessage message = new ErrorMessage(HttpStatus.CONFLICT,dealExsist.getMessage());
		return ResponseEntity.status(HttpStatus.CONFLICT).body(message);
		
	}
	


	   @Override
	   protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
	                 HttpHeaders headers, HttpStatus status, WebRequest request) {
	        
	 
	      	ErrorMessage message = new ErrorMessage(HttpStatus.BAD_REQUEST,ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage());
			
	      	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
	   }
	   
		@ExceptionHandler(SqlException.class)
		public  ResponseEntity<ErrorMessage>  amountException(SqlException amout,WebRequest request) {
			ErrorMessage message = new ErrorMessage(HttpStatus.BAD_REQUEST,amout.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
			
		}
	
}
