package br.com.springvalidation.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.springvalidation.exception.InvalidField.Field;

@ControllerAdvice
public class HandlerException extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(UserException.class)
	public ResponseEntity<?> handlerUserException(UserException exp, WebRequest request){
		
		return super.handleExceptionInternal(exp, exp.getMessage(), new HttpHeaders(), exp.getStatus(), request);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exp,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		var fieldsError = new ArrayList<InvalidField.Field>(); 
		
		exp.getBindingResult().getAllErrors().stream().forEach(error -> {
			fieldsError.add(Field.builder()
							.field(((FieldError) error).getField())
							.error(error.getDefaultMessage())
							.build());
		});
		
		var invalidField = InvalidField.builder()
							.title("Error")
							.status(status)
							.mensageError("Warning! Some fields are invalid")
							.time(LocalDateTime.now())
							.fields(fieldsError)
							.build();
		
		return super.handleExceptionInternal(exp, invalidField, headers, status, request);
	}
}
