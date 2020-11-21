package ar.edu.arqSoft.ticketService.baseService.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ar.edu.arqSoft.ticketService.common.model.GenericObject;

@Entity
@Table(name="PROYECT")
public class Proyect extends GenericObject{
	
	@NotNull
	@Size(min=1, max=250)
	@Column (name="NAME")
	private String name;
	
	@NotNull
	@Size(min=1, max=250)
	@Column (name="DESCRPTION")
	private String description;
	
	@Column(name="START_DATE")
	private Date startDate;
	
	@Column(name = "END_DATE")
	private Date finishDate;
	
	@Enumerated(value = EnumType.ORDINAL)
	@Column(name = "STATE_PROYECT")
	private StateProyect state;
	
	@ManyToMany(mappedBy = "users")
	private Set<User> users;
	
	@OneToMany (targetEntity=User.class, mappedBy="TASK", fetch = FetchType.LAZY)
	private Set<Task>  tasks;

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

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users.add(users);
	}

	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Task tasks) {
		this.tasks.add(tasks);
	}
	
	
}