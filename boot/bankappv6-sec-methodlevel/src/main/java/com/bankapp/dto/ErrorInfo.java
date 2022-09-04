package com.bankapp.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;
@Data
//@Builder
public class ErrorInfo {
	private String errorMessage;
	private int statusCode;
	private String toContact;
	private LocalDateTime dateTime;
}
