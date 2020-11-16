package ar.edu.arqSoft.ticketService.baseService.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import ar.edu.arqSoft.ticketService.common.dao.*;

@Repository
public class TaskDaoImp extends GenericDaoImp<Task, Long> implements TaskDao{
	
	public List<Task> FindByName (String nombre){

		CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Task> criteria = builder.createQuery(Task.class);
        Root<Task> entity = criteria.from(Task.class);

        criteria.select(entity).where(builder.equal(entity.get("name"+" "+"lastname"), nombre));
        return em.createQuery(criteria).getResultList();
	}
}