package ar.edu.arqSoft.ticketService.baseService.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ar.edu.arqSoft.ticketService.common.model.GenericObject;

@Entity
@Table(name="STATE")
public class State extends GenericObject{
	
	@NotNull
	@Size(min=1, max=250)
	@Column (name="STATE")
	private String name;

	@OneToMany (targetEntity=User.class, mappedBy="Task", fetch = FetchType.LAZY)
	private Set<Task> tasks;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}
	
	
}