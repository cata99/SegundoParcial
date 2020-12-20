package ar.edu.arqSoft.ticketService.baseService.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import ar.edu.arqSoft.ticketService.baseService.model.*;
import ar.edu.arqSoft.ticketService.common.dto.*;

public class ProyectResponseDto implements DtoEntity{
	
	private String name;
	
	private String description;
	
	private Date startDate;
	
	private StateProyect state;
	
	private Long id;

	@JsonProperty("NAME")
	public String getName() {
		return name;
	}

	@JsonProperty("NAME")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("DESCRIPTION")
	public String getDescription() {
		return description;
	}

	@JsonProperty("DESCRIPTION")
	public void setDescription(String description) {
		this.description = description;
	}

	@JsonProperty("STARTDATE")
	public Date getStartDate() {
		return startDate;
	}

	@JsonProperty("STARTDATE")
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@JsonProperty("STATE")
	public StateProyect getState() {
		return state;
	}

	@JsonProperty("STATE")
	public void setState(StateProyect state) {
		this.state = state;
	}

	@JsonProperty("ID")
	public Long getId() {
		return id;
	}

	@JsonProperty("ID")
	public void setId(Long id) {
		this.id = id;
	}
	
}