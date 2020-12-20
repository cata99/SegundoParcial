package ar.edu.arqSoft.ticketService.baseService.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import ar.edu.arqSoft.ticketService.common.dto.*;

public class CommentRequestDto implements DtoEntity {

	private String description;

	private Long id;
	
	private Long idTask;

	private Long idUser;
	
	@JsonProperty("USER_ID")
	public Long getIdUser() {
		return idUser;
	}

	@JsonProperty("USER_ID")
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

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

	@JsonProperty("TASK_ID")
	public Long getIdTask() {
		return idTask;
	}

	@JsonProperty("TASK_ID")
	public void setIdTask(Long idTask) {
		this.idTask = idTask;
	}
	
	

}