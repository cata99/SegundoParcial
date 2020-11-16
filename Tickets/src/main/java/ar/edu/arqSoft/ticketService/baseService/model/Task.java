package ar.edu.arqSoft.ticketService.baseService.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

import ar.edu.arqSoft.ticketService.common.model.GenericObject;

@Entity
@Table(name = "TASK")
public class Task extends GenericObject{
	
	private String name;
	
	private String description;
	
	private User owner;
	
	private Proyect proyect;
	
	private Set<User> users;
	
	private State state;

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
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

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public Proyect getProyect() {
		return proyect;
	}

	public void setProyect(Proyect proyect) {
		this.proyect = proyect;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
}