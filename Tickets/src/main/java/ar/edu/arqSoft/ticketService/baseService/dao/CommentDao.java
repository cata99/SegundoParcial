package ar.edu.arqSoft.ticketService.baseService.dao;

import java.util.List;

import ar.edu.arqSoft.ticketService.baseService.model.Comment;
import ar.edu.arqSoft.ticketService.common.dao.GenericDao;


public interface CommentDao extends GenericDao<Comment, Long>{

	public List<Comment> getAllByTaskId(Long taskid);
}