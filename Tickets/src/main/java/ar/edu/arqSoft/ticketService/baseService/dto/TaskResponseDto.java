package ar.edu.arqSoft.ticketService.baseService.dto;

import ar.edu.arqSoft.ticketService.common.dto.*;

import java.util.Set;

import ar.edu.arqSoft.ticketService.baseService.model.*;

public class TaskResponseDto implements DtoEntity{
	
	private String name;
	
	private String description;
	
	private Set<User> user;
	
	private Set<Comment> comment;
	
	private Proyect proyect;
	

	private State state;
	
	

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Proyect getProyect() {
		return proyect;
	}

	public void setProyect(Proyect proyect) {
		this.proyect = proyect;
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

	public Set<User> getUser() {
		return user;
	}

	public void setUser(Set<User> user) {
		this.user = user;
	}

	public Set<Comment> getComment() {
		return comment;
	}

	public void setComment(Set<Comment> comment) {
		this.comment = comment;
	}
	
	
}