package ar.edu.arqSoft.ticketService.baseService.dao;


import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import ar.edu.arqSoft.ticketService.baseService.model.Task;
import ar.edu.arqSoft.ticketService.baseService.model.Task;
import ar.edu.arqSoft.ticketService.common.dao.*;

@Repository
public class TaskDaoImp extends GenericDaoImp<Task, Long> implements TaskDao{

}