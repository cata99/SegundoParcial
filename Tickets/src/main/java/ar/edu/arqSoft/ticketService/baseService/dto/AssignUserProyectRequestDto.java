package ar.edu.arqSoft.ticketService.baseService.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import ar.edu.arqSoft.ticketService.common.dto.DtoEntity;

public class AssignUserProyectRequestDto implements DtoEntity {

	private Long idUser;

	private Long idProyect;

	@JsonProperty("USER_ID")
	public Long getIdUser() {
		return idUser;
	}

	@JsonProperty("USER_ID")
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	@JsonProperty("PROYECT_ID")
	public Long getIdProyect() {
		return idProyect;
	}

	@JsonProperty("PROYECT_ID")
	public void setIdProyect(Long idProyect) {
		this.idProyect = idProyect;
	}

}