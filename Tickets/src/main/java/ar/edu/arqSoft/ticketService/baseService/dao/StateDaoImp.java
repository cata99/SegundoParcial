package ar.edu.arqSoft.ticketService.baseService.dao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;


import ar.edu.arqSoft.ticketService.baseService.model.State;
import ar.edu.arqSoft.ticketService.common.dao.GenericDaoImp;

@Repository
public class StateDaoImp extends GenericDaoImp<State, Long> implements StateDao{

	@Override
	public State getStateByTaskId(Long taskid) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<State> criteria = builder.createQuery(State.class);
        Root<State> entity = criteria.from(State.class);

        criteria.select(entity).where(builder.equal((entity.get("task").get("id")), taskid));

        return (State) em.createQuery(criteria);
	}
	
	
}