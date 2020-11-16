package ar.edu.arqSoft.ticketService.baseService.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;


import ar.edu.arqSoft.ticketService.common.model.GenericObject;

@Entity
@Table(name = "USER")
public class User extends GenericObject{
	
	private String name;
	
	private String lastName;
	
	private String email;
	
	private String userName;
	
	private String password;
	
	private Set<Task> tasks;
	
	private Set<Comment> comments;
	
	private Set<Proyect> proyects;
	
	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public Set<Proyect> getProyects() {
		return proyects;
	}

	public void setProyects(Set<Proyect> proyects) {
		this.proyects = proyects;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}