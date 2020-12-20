package ar.edu.arqSoft.ticketService.baseService.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import ar.edu.arqSoft.ticketService.common.dto.*;

public class TaskRequestDto implements DtoEntity {

	private String name;
	
	private Long state;

	private String description;

	private Long id;
	
	private Long proyect;

	@JsonProperty("STATE_ID")
	public Long getState() {
		return state;
	}

	@JsonProperty("STATE_ID")
	public void setState(Long state) {
		this.state = state;
	}
	
	@JsonProperty("PROYECT_ID")
	public Long getProyect() {
		return proyect;
	}

	@JsonProperty("PROYECT_ID")
	public void setProyect(Long proyect) {
		this.proyect = proyect;
	}

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

	@JsonProperty("DESCRPCION")
	public String getDescription() {
		return description;
	}

	@JsonProperty("DESCRPCION")
	public void setDescription(String description) {
		this.description = description;
	}
}