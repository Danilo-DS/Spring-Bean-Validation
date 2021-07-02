package br.com.springvalidation.exception;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class InvalidField {
	
	private String title;
	private HttpStatus status;
	private String mensageError; 
	private LocalDateTime time;
	private List<Field> fields;
	
	@AllArgsConstructor
	@NoArgsConstructor
	@Data
	@Builder
	public static class Field {
		private String field;
		private String error;
	}
}
