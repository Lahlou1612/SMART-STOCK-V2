package com.smart.stock.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.smart.stock.exception.EntityNotFoundException;
import com.smart.stock.exception.InvalidEntityException;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<ErrorDTO> handelerException(EntityNotFoundException exception, WebRequest webRequest) {

		final HttpStatus notFound = HttpStatus.NOT_FOUND;
		final ErrorDTO errorDTO = null;
		ErrorDTO.builder()
			.code(exception.getErrorCodes())
			.httpCode(notFound.value())
			.message(exception.getMessage())
			.build();
		
		return new ResponseEntity<>(errorDTO, notFound);
	}
	
	
	@ExceptionHandler(InvalidEntityException.class)
	public ResponseEntity<ErrorDTO> handlerException(InvalidEntityException exception, WebRequest request){
		
		final HttpStatus badRequest = HttpStatus.BAD_REQUEST;
		final ErrorDTO errorDTO = null;
		 ErrorDTO.builder()
			.code(exception.getErrorCodes())
			.httpCode(badRequest.value())
			.message(exception.getMessage())
			.errors(exception.getErrors())
			.build();
			
			return new ResponseEntity<>(errorDTO, badRequest);
		
	}

}

















