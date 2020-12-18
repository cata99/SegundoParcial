package ar.edu.arqSoft.ticketService.baseService.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ar.edu.arqSoft.ticketService.common.model.GenericObject;

@Entity
@Table(name = "USER")
public class User extends GenericObject {

	@NotNull
	@Size(min = 1, max = 250)
	@Column(name = "NAME")
	private String name;

	@NotNull
	@Size(min = 1, max = 250)
	@Column(name = "LASTNAME")
	private String lastName;

	@NotNull
	@Size(min = 1, max = 100)
	@Column(name = "EMAIL")
	private String email;

	@ManyToMany(mappedBy = "users")
	private Set<Task> tasks;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private Set<Comment> comments;

	@ManyToMany(mappedBy = "users")
	private Set<Proyect> proyects;

	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Task tasks) {
		this.tasks.add(tasks);
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

}