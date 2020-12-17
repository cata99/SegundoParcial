package ar.edu.arqSoft.ticketService.baseService.dto;

import java.util.Date;

import ar.edu.arqSoft.ticketService.baseService.model.*;
import ar.edu.arqSoft.ticketService.common.dto.*;

public class ProyectResponseDto implements DtoEntity{
	
	private String name;
	
	private String description;
	
	private Date startDate;
	
	private Date finishDate;
	
	private StateProyect state;
	
	private Long id;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}