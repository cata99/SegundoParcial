package ar.edu.arqSoft.ticketService.baseService.dto;

import ar.edu.arqSoft.ticketService.common.dto.DtoEntity;

public class AssignTaskProyectResponseDto implements DtoEntity{
	
	private Long idTask;
	
	private Long idProyect;

	public Long getIdTask() {
		return idTask;
	}

	public void setIdTask(Long idTask) {
		this.idTask = idTask;
	}

	public Long getIdProyect() {
		return idProyect;
	}

	public void setIdProyect(Long idProyect) {
		this.idProyect = idProyect;
	}
	
	
}