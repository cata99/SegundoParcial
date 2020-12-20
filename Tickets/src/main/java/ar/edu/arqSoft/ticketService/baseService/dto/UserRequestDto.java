package ar.edu.arqSoft.ticketService.baseService.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

import ar.edu.arqSoft.ticketService.common.dto.*;
public class UserRequestDto implements DtoEntity{
	
	private Long id;
	
	private String name;
	
	private String lastName;
	
	private String email;
	
	@JsonProperty("ID")
	public Long getId() {
		return id;
	}

	@JsonProperty("ID")
	public void setId(Long id) {
		this.id = id;
	}
	
	@JsonProperty("NAME")
	public String getName() {
		return name;
	}
	

	@JsonProperty("NAME")
	public void setName(String name) {
		this.name = name;
	}
	
	@JsonProperty("LASTNAME")
	public String getLastName() {
		return lastName;
	}

	@JsonProperty("LASTNAME")
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@JsonProperty("EMAIL")
	public String getEmail() {
		return email;
	}

	@JsonProperty("EMAIL")
	public void setEmail(String email) {
		this.email = email;
	}

}
