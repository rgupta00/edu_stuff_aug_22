package com.bankapp.dto;

import com.bankapp.entities.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtResponse {
	private UserEntity user;
	private String jwtToken;

}
