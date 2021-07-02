package br.com.springvalidation.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class UserException extends RuntimeException {
	
	private static final long serialVersionUID = 2744906378793896100L;
	
	private HttpStatus status;
	
	public UserException(String msg, HttpStatus sts) {
		super(msg);
		status = sts;
	}
}
