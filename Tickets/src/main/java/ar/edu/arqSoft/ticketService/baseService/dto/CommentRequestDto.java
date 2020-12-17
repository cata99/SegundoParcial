package ar.edu.arqSoft.ticketService.baseService.dto;

import ar.edu.arqSoft.ticketService.common.dto.*;

public class CommentRequestDto implements DtoEntity{

	private String description;
	
	private Long idTask;
	
	private Long idUser;

	
	public Long getIdTask() {
		return idTask;
	}

	public void setIdTask(Long idTask) {
		this.idTask = idTask;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}