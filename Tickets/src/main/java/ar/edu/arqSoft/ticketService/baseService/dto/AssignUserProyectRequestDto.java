package ar.edu.arqSoft.ticketService.baseService.dto;

import ar.edu.arqSoft.ticketService.common.dto.DtoEntity;

public class AssignUserProyectRequestDto implements DtoEntity{
	
	private Long idUser;
	
	private Long idProyect;

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
	
	
}