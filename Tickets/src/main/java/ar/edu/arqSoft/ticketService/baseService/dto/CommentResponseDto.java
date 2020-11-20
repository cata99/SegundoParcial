package ar.edu.arqSoft.ticketService.baseService.dto;

import ar.edu.arqSoft.ticketService.baseService.model.Task;
import ar.edu.arqSoft.ticketService.baseService.model.User;
import ar.edu.arqSoft.ticketService.common.dto.*;

public class CommentResponseDto implements DtoEntity{
	
	private String description; 
	
	private Boolean state;
	
	private User user;
	
	private Task task;

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}