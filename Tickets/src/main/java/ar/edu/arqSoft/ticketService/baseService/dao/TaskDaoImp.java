package ar.edu.arqSoft.ticketService.baseService.dao;

import org.springframework.stereotype.Repository;

import ar.edu.arqSoft.ticketService.baseService.model.Task;
import ar.edu.arqSoft.ticketService.common.dao.*;

@Repository
public class TaskDaoImp extends GenericDaoImp<Task, Long> implements TaskDao{

}