package ar.edu.arqSoft.ticketService.baseService.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import ar.edu.arqSoft.ticketService.common.model.GenericObject;

@Entity
@Table(name="COMMENT")
public class Comment extends GenericObject{
	
	private String description;
	
	private Boolean state;
	
	private Task task;
	
	private User user;

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
	
	
}