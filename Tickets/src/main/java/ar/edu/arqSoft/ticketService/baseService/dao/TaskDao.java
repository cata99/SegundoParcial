package ar.edu.arqSoft.ticketService.baseService.dao;

import java.util.List;

import ar.edu.arqSoft.ticketService.common.dao.*;

public interface TaskDao extends GenericDao<Task, Long>{
	
	public List<Task> FindByName (String nombre);
	
}