package com.progresssoft.muhammedShattap.error;

import org.springframework.http.HttpStatus;

public class ErrorMessage {
	
private HttpStatus httpStatus;
private String errorMessage;


public ErrorMessage() {
	super();
}
public ErrorMessage(HttpStatus httpStatus, String errorMessage) {
	super();
	this.httpStatus = httpStatus;
	this.errorMessage = errorMessage;
}
public HttpStatus getHttpStatus() {
	return httpStatus;
}
public void setHttpStatus(HttpStatus httpStatus) {
	this.httpStatus = httpStatus;
}
public String getErrorMessage() {
	return errorMessage;
}
public void setErrorMessage(String errorMessage) {
	this.errorMessage = errorMessage;
}




}
