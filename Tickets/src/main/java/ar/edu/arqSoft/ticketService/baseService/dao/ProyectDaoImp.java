package ar.edu.arqSoft.ticketService.baseService.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import ar.edu.arqSoft.ticketService.baseService.dao.*;
import ar.edu.arqSoft.ticketService.common.dao.GenericDaoImp;

@Repository
public class ProyectDaoImp extends GenericDaoImp<Proyect, Long > implements ProyectDao{
	
	public List<Proyect> FindByName (String nombre){

		CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Proyect> criteria = builder.createQuery(Proyect.class);
        Root<Proyect> entity = criteria.from(Proyect.class);

        criteria.select(entity).where(builder.equal(entity.get("name"), nombre));
        return em.createQuery(criteria).getResultList();
	}
}