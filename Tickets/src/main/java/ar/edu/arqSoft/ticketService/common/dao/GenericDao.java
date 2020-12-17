package ar.edu.arqSoft.ticketService.common.dao;

import ar.edu.arqSoft.ticketService.common.exception.*;
import java.io.Serializable;
import java.util.List;


public interface GenericDao<E, ID extends Serializable> {
	
	public void insert(E entity) throws BadRequestException;
	
	public void saveOrUpdate(E entity);

	public void update(E entity);

	public void remove(E entity);

	public E load(ID key) throws EntityNotFoundException;

	public List<E> getAll();
	
}