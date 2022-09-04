package com.bankapp.utility;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//DTO used to carray the error info in grace full way to client
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorInfo {

	private String errorMessage;
	private int errorCode;
	private String toContact;
	private LocalDateTime timeStamp;
}
