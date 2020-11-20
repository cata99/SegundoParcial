package ar.edu.arqSoft.ticketService.baseService.dto;

import java.util.Date;
import java.util.Set;

import ar.edu.arqSoft.ticketService.baseService.model.*;
import ar.edu.arqSoft.ticketService.common.dto.*;

public class ProyectResponseDto implements DtoEntity{
	
	private String name;
	
	private String description;
	
	private Date startDate;
	
	private Date finishDate;
	
	private StateProyect state;
	
	private Set<Task> task;
	
	private Set<User> user;
	
	private User owner;

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}

	public StateProyect getState() {
		return state;
	}

	public void setState(StateProyect state) {
		this.state = state;
	}

	public Set<Task> getTask() {
		return task;
	}

	public void setTask(Set<Task> task) {
		this.task = task;
	}

	public Set<User> getUser() {
		return user;
	}

	public void setUser(Set<User> user) {
		this.user = user;
	}
	
	
	
	
}