package ar.edu.arqSoft.ticketService.baseService.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import ar.edu.arqSoft.ticketService.common.dto.DtoEntity;

public class AssignUserTaskResponseDto implements DtoEntity {

	private Long idUser;

	private Long idTask;

	@JsonProperty("USER_ID")
	public Long getIdUser() {
		return idUser;
	}

	@JsonProperty("USER_ID")
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	@JsonProperty("TASK_ID")
	public Long getIdTask() {
		return idTask;
	}

	@JsonProperty("TASK_ID")
	public void setIdTask(Long idTask) {
		this.idTask = idTask;
	}

}