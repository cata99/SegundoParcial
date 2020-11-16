package ar.edu.arqSoft.ticketService.baseService.dao;

import java.util.List;

import ar.edu.arqSoft.ticketService.baseService.model.Proyect;
import ar.edu.arqSoft.ticketService.common.dao.GenericDao;

public interface ProyectDao extends GenericDao<Proyect, Long>{
	
	public List<Proyect> FindByName (String nombre);
}