package ar.edu.arqSoft.ticketService.baseService.model;

import java.util.Set;

import javax.persistence.CascadeType;
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
public class User extends GenericObject{
	
	@NotNull
	@Size(min=1, max=250)
	@Column (name="NAME")
	private String name;
	
	@NotNull
	@Size(min=1, max=250)
	@Column (name="LASTNAME")
	private String lastName;
	
	@NotNull
	@Size(min=1, max=100)
	@Column (name="EMAIL")
	private String email;
	
	@NotNull
	@Size(min=1, max=250)
	@Column (name="USERNAME")
	private String userName;
	
	@NotNull
	@Size(min=1, max=250)
	@Column (name="PASSWORD")
	private String password;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Task> tasks;
	
	@OneToMany (targetEntity=User.class, mappedBy="USER", fetch = FetchType.LAZY)
	private Set<Comment> comments;

	@ManyToMany(cascade = CascadeType.ALL)
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