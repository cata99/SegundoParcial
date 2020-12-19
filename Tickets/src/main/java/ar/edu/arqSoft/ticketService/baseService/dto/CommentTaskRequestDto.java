package ar.edu.arqSoft.ticketService.baseService.dto;

import ar.edu.arqSoft.ticketService.common.dto.DtoEntity;

public class CommentTaskRequestDto implements DtoEntity{
	
	private Long idTask;

	public Long getIdTask() {
		return idTask;
	}

	public void setIdTask(Long idTask) {
		this.idTask = idTask;
	}
	
	
}