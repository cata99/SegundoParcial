package ar.edu.arqSoft.ticketService.baseService.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

import ar.edu.arqSoft.ticketService.common.dto.*;



public class TaskResponseDto implements DtoEntity{
	
	private Long id;
	
	private String name;
	
	private String description;

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

	@JsonProperty("DESCRIPCION")
	public String getDescription() {
		return description;
	}

	@JsonProperty("DESCRIPCION")
	public void setDescription(String description) {
		this.description = description;
	}
	
}