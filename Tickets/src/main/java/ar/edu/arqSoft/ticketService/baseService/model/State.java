package ar.edu.arqSoft.ticketService.baseService.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

import ar.edu.arqSoft.ticketService.common.model.GenericObject;

@Entity
@Table(name="STATE")
public class State extends GenericObject{
	
	private String name;
	
	private String description;
	
	private Set<Task> tasks;

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

	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}
	
	
}