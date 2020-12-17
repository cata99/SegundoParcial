package ar.edu.arqSoft.ticketService.baseService.dto;

import ar.edu.arqSoft.ticketService.common.dto.*;

public class TaskRequestDto implements DtoEntity{
	
	private Long idState;
	
	private Long idUser;
	
	private Long idProyect;
	
	private String name;
	
	private String description;	
	
	private Long id;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdState() {
		return idState;
	}

	public void setIdState(Long idState) {
		this.idState = idState;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public Long getIdProyect() {
		return idProyect;
	}

	public void setIdProyect(Long idProyect) {
		this.idProyect = idProyect;
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
}