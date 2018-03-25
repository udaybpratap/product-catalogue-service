package com.uday.sapient.productcatalogueservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.uday.sapient.productcatalogueservice.model.ErrorResponse;

@ControllerAdvice
public class ProductCatalougeServiceException extends Exception{

	public ProductCatalougeServiceException() {		
	}
	
	public ProductCatalougeServiceException(String message) {
		super(message);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleException(Exception ex){
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorResponse.setMessage(ex.getMessage());
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.OK);
	}
}
