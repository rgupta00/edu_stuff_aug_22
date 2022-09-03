package com.app.dao;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import java.util.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@NoArgsConstructor
@Entity
@Table(name = "spring_sec_user")
@ToString
public class UserEntity {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String username;
	private String password;
	private String email;
	@JoinColumn(name = "user_role")

    @ElementCollection(fetch = FetchType.EAGER)
	private List<String> roles=new ArrayList<String>();

	public UserEntity(String username, String password, String email, List<String> roles) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.roles = roles;
	}
	
	

}
