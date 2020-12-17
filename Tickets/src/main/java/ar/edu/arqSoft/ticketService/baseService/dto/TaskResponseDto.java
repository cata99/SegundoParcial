package ar.edu.arqSoft.ticketService.baseService.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import ar.edu.arqSoft.ticketService.common.dto.*;



public class TaskResponseDto implements DtoEntity{
	
	private Long id;
	
	private Long idUser;
	
	private Long idProyect;
	
	private Long idState;
	
	private String name;
	
	private String description;
	
	private String userName;
	
	private String userLastname;
	
	private String proyectName;
	
	private String stateName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@JsonProperty("id_user")
	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	@JsonProperty("id_proyect")
	public Long getIdProyect() {
		return idProyect;
	}

	public void setIdProyect(Long idProyect) {
		this.idProyect = idProyect;
	}

	@JsonProperty("id_state")
	public Long getIdState() {
		return idState;
	}

	public void setIdState(Long idState) {
		this.idState = idState;
	}

	@JsonProperty("taskName")
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

	@JsonProperty("userName")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@JsonProperty("userLastname")
	public String getUserLastname() {
		return userLastname;
	}

	public void setUserLastname(String userLastname) {
		this.userLastname = userLastname;
	}

	@JsonProperty("proyectName")
	public String getProyectName() {
		return proyectName;
	}

	public void setProyectName(String proyectName) {
		this.proyectName = proyectName;
	}

	@JsonProperty("stateName")
	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	
}