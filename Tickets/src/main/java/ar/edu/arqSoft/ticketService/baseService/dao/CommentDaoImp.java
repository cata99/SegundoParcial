package ar.edu.arqSoft.ticketService.baseService.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import ar.edu.arqSoft.ticketService.baseService.model.Comment;
import ar.edu.arqSoft.ticketService.baseService.model.User;
import ar.edu.arqSoft.ticketService.common.dao.GenericDaoImp;

@Repository
public class CommentDaoImp extends GenericDaoImp<Comment, Long> implements CommentDao{
	
}