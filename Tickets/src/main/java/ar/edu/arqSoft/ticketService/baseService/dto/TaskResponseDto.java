package ar.edu.arqSoft.ticketService.baseService.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

import ar.edu.arqSoft.ticketService.common.dto.*;



public class TaskResponseDto implements DtoEntity{
	
	private Long id;
	
	private String name;
	
	private String description;
	
	private Long idState;
	
	private Long idProyect;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@JsonProperty("STATE_ID")
	public Long getIdState() {
		return idState;
	}

	public void setIdState(Long idState) {
		this.idState = idState;
	}

	@JsonProperty("PROYECT_ID")
	public Long getIdProyect() {
		return idProyect;
	}

	public void setIdProyect(Long idProyect) {
		this.idProyect = idProyect;
	}
	
}