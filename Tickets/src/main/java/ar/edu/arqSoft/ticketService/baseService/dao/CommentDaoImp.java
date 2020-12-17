package ar.edu.arqSoft.ticketService.baseService.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import ar.edu.arqSoft.ticketService.baseService.model.Comment;
import ar.edu.arqSoft.ticketService.common.dao.GenericDaoImp;

@Repository
public class CommentDaoImp extends GenericDaoImp<Comment, Long> implements CommentDao{
	
	@Override
	public List<Comment> getAllByTaskId(Long taskid) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Comment> criteria = builder.createQuery(Comment.class);
        Root<Comment> entity = criteria.from(Comment.class);

        criteria.select(entity).where(builder.equal((entity.get("task").get("id")), taskid));

        return em.createQuery(criteria).getResultList();
	}
}