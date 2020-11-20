package ar.edu.arqSoft.ticketService.baseService.dto;

import ar.edu.arqSoft.ticketService.common.dto.*;

public class UserResponseDto implements DtoEntity{
	
	private String name;
	
	private String lastName;
	
	private String email;
	
	private String userName;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}