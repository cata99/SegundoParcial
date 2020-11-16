package ar.edu.arqSoft.ticketService.baseService.dao;

import java.util.List;

import ar.edu.arqSoft.ticketService.baseService.dao.*;
import ar.edu.arqSoft.ticketService.common.dao.GenericDao;

public interface UserDao extends GenericDao<User, Long>{

	public List<User> FindByName (String nombre);
}