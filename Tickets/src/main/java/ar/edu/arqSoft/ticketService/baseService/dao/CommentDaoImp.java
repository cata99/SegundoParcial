package ar.edu.arqSoft.ticketService.baseService.dao;

import org.springframework.stereotype.Repository;
import ar.edu.arqSoft.ticketService.baseService.model.Comment;
import ar.edu.arqSoft.ticketService.common.dao.GenericDaoImp;

@Repository
public class CommentDaoImp extends GenericDaoImp<Comment, Long> implements CommentDao{
	
}