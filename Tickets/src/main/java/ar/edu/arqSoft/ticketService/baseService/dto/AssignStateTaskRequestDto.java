package ar.edu.arqSoft.ticketService.baseService.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import ar.edu.arqSoft.ticketService.common.dto.DtoEntity;

public class AssignStateTaskRequestDto implements DtoEntity{
	
	private Long idState;
	
	private Long idTask;

	@JsonProperty("STATE_ID")
	public Long getIdState() {
		return idState;
	}

	@JsonProperty("STATE_ID")
	public void setIdState(Long idState) {
		this.idState = idState;
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


