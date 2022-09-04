package com.bankapp.util;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.bankapp.dto.ErrorInfo;
import com.bankapp.exceptions.BankAccountNotFoundException;

@RestControllerAdvice
public class BankExceptionController {

	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(BankAccountNotFoundException.class)
	public ErrorInfo handle404(BankAccountNotFoundException ex) {
//		ErrorInfo errorInfo=ErrorInfo.builder().statusCode(HttpStatus.NOT_FOUND.value())
//				.dateTime(LocalDateTime.now())
//				.errorMessage(ex.getMessage())
//				.toContact("rgutpa.mtech@gmail.com")
//				.build();
		
		ErrorInfo errorInfo=new ErrorInfo();
		errorInfo.setDateTime(LocalDateTime.now());
		errorInfo.setErrorMessage(ex.getMessage());
		errorInfo.setStatusCode(HttpStatus.NOT_FOUND.value());
		errorInfo.setToContact("rgutpa.mtech@gmail.com");
		
		return errorInfo;
		
	}
	
	//last step is to handle MethodArgumentNotValidException exception
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ErrorInfo handle400(MethodArgumentNotValidException ex) {

		//now we need to grab all the ex messages and give back the client
		
		String errorMessages= ex.getBindingResult().getAllErrors()
				.stream().map(x-> x.getDefaultMessage())
				.collect(Collectors.joining(" ,"));
		
		
		ErrorInfo errorInfo=new ErrorInfo();
		errorInfo.setDateTime(LocalDateTime.now());
		errorInfo.setErrorMessage(errorMessages);
		errorInfo.setStatusCode(HttpStatus.BAD_REQUEST.value());
		errorInfo.setToContact("rgutpa.mtech@gmail.com");
		
		return errorInfo;
		
	}
	
//	
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public ErrorInfo handle500(Exception ex) {

		ErrorInfo errorInfo=new ErrorInfo();
		errorInfo.setDateTime(LocalDateTime.now());
		errorInfo.setErrorMessage("try after some time");
		errorInfo.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorInfo.setToContact("rgutpa.mtech@gmail.com");
		
		return errorInfo;
		
	}
}
