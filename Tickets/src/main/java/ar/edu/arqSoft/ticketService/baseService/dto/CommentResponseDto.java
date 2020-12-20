package ar.edu.arqSoft.ticketService.baseService.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import ar.edu.arqSoft.ticketService.common.dto.*;

public class CommentResponseDto implements DtoEntity{
	
	private String description; 
	
	private Long id;

	@JsonProperty("ID")
	public Long getId() {
		return id;
	}
	
	@JsonProperty("ID")
	public void setId(Long id) {
		this.id = id;
	}

	@JsonProperty("DESCRIPTION")
	public String getDescription() {
		return description;
	}

	@JsonProperty("DESCRIPTION")
	public void setDescription(String description) {
		this.description = description;
	}
	
}