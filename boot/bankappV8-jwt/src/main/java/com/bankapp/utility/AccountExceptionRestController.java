package com.bankapp.utility;
import java.util.*;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.bankapp.exceptions.BankAccountNotFoundException;

//AOP: all about handling the cross cutting concern ,throws advice
@RestControllerAdvice
public class AccountExceptionRestController {

	@Autowired
	private Environment environment;// it used to get values from prop files
	// 404

	@ExceptionHandler(BankAccountNotFoundException.class)
	public ResponseEntity<ErrorInfo> handle404(BankAccountNotFoundException ex) {
		String message = environment.getProperty(ex.getMessage());

		ErrorInfo errorInfo = new ErrorInfo(message, 404, "ravi@ibm.com", LocalDateTime.now());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorInfo);
	}

	// 500
//	@ExceptionHandler(Exception.class)
//	public ResponseEntity<ErrorInfo> handle500(Exception ex){
//		
//		ErrorInfo errorInfo= ErrorInfo.builder()
//				.errorCode(500)
//				.errorMessage("some server side error")
//				.timeStamp(LocalDateTime.now())
//				.toContact("ravi@gmail.com")
//				.build();
//				
//		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorInfo);
//	}
	// valiation error MethodArgumentNotValidException
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handle400(MethodArgumentNotValidException ex) {
		Map<String, String> map=new HashMap<>();// let we populate error messages in this map
		
		ex.getBindingResult().getFieldErrors().forEach(error-> {
			map.put(error.getField(), error.getDefaultMessage());
		});
		
		return map;
	}
}






