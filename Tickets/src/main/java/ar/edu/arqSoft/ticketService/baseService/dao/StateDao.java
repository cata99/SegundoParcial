package ar.edu.arqSoft.ticketService.baseService.dao;

import java.util.List;

import ar.edu.arqSoft.ticketService.baseService.model.State;
import ar.edu.arqSoft.ticketService.common.dao.GenericDao;

public interface StateDao extends GenericDao<State, Long>{

	public List<State> FindByName (String nombre);
}