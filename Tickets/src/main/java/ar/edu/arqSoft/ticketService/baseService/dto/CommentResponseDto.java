package ar.edu.arqSoft.ticketService.baseService.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import ar.edu.arqSoft.ticketService.common.dto.*;

public class CommentResponseDto implements DtoEntity{
	
	private String description; 
	
	private Boolean state;
	
	private Long taskId;
	
	private Long userId;
	
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

	@JsonProperty("task_id")
	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	@JsonProperty("user_id")
	public Long getUserId() {
		return userId;
	}
	
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
}