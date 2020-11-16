package ar.edu.arqSoft.ticketService.baseService.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import ar.edu.arqSoft.ticketService.baseService.model.User;
import ar.edu.arqSoft.ticketService.common.dao.*;

@Repository 
public class UserDaoImp extends GenericDaoImp<User, Long > implements UserDao{
	
	public List<User> FindByName (String nombre){

		CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<User> criteria = builder.createQuery(User.class);
        Root<User> entity = criteria.from(User.class);

        criteria.select(entity).where(builder.equal(entity.get("name"+" "+"lastName"), nombre));
        return em.createQuery(criteria).getResultList();
	}
}
